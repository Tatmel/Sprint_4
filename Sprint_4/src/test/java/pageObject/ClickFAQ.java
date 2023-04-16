package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickFAQ {
        private WebDriver driver;
        @Test
        public void checkClickFAQ() {
            //драйвер для браузера Chrome
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
            //драйвер для браузера FireFox
            //WebDriverManager.firefoxdriver().setup();
            //WebDriver driver = new FirefoxDriver();

            //переход на главную страницу
            driver.get("https://qa-scooter.praktikum-services.ru/");

            //объект класса главной страницы
            HomePageScooter objHomePage = new HomePageScooter(driver);

            //закрыть куки
            objHomePage.clickConfirmCookie();

            //найти элемент с вопросами
            objHomePage.findListFaq();

            //найти вопрос и кликнуть
            objHomePage.clickQuestionOneInFAQ();
            //получить текст и сравнить результат
            String actualAnswer = driver.findElement(By.id("accordion__panel-0")).getText();
            Assert.assertEquals("Ошибка: Текст ответа в первом вопросе не совпадает", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", actualAnswer);

            objHomePage.clickQuestionTwoInFAQ();
            actualAnswer = driver.findElement(By.id("accordion__panel-1")).getText();
            Assert.assertEquals("Ошибка: Текст ответа во втором вопросе не совпадает", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", actualAnswer);

            objHomePage.clickQuestionThreeInFAQ();
            actualAnswer = driver.findElement(By.id("accordion__panel-2")).getText();
            Assert.assertEquals("Ошибка: Текст ответа в третьем вопросе не совпадает", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", actualAnswer);

            objHomePage.clickQuestionFourInFAQ();
            actualAnswer = driver.findElement(By.id("accordion__panel-3")).getText();
            Assert.assertEquals("Ошибка: Текст ответа в четвертом вопросе не совпадает", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", actualAnswer);

            objHomePage.clickQuestionFiveInFAQ();
            actualAnswer = driver.findElement(By.id("accordion__panel-4")).getText();
            Assert.assertEquals("Ошибка: Текст ответа в пятом вопросе не совпадает", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", actualAnswer);

            objHomePage.clickQuestionSixInFAQ();
            actualAnswer = driver.findElement(By.id("accordion__panel-5")).getText();
            Assert.assertEquals("Ошибка: Текст ответа в шестом вопросе не совпадает", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", actualAnswer);

            objHomePage.clickQuestionSevenInFAQ();
            actualAnswer = driver.findElement(By.id("accordion__panel-6")).getText();
            Assert.assertEquals("Ошибка: Текст ответа в седьмом вопросе не совпадает", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", actualAnswer);

            objHomePage.clickQuestionEightInFAQ();
            actualAnswer = driver.findElement(By.id("accordion__panel-7")).getText();
            Assert.assertEquals("Ошибка: Текст ответа в восьмом вопросе не совпадает", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", actualAnswer);
        }
        @After
        public void teardown() {
            driver.quit();
        }
}
