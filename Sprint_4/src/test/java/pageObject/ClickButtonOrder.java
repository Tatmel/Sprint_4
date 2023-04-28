package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickButtonOrder {
    @RunWith(Parameterized.class)
    public static class ClickButtonOrderTestClass {
        private WebDriver driver;
        @Before
        public void preparingForTest () {
            //драйвер для браузера Chrome
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
            //драйвер для браузера FireFox
            //WebDriverManager.firefoxdriver().setup();
            //WebDriver driver = new FirefoxDriver();
        }
        private final String buttonLocator;
        public ClickButtonOrderTestClass(String buttonLocator) {
            this.buttonLocator = buttonLocator;
        }

        @Parameterized.Parameters
        public static Object[][] getButton() {
            return new Object[][]{
                    {".//div[contains(@class, 'Header_Nav')]/button[text()='Заказать']"},
                    {".//div[contains(@class, 'Home_FinishButton')]/button[text()='Заказать']"},
            };
        }
        @Test
        public void checkClickButtonOrder() {
            //переход на главную страницу
            driver.get("https://qa-scooter.praktikum-services.ru/");

            //объект класса главной страницы
            HomePageScooter objHomePage = new HomePageScooter(driver);

            //закрыть куки
            objHomePage.clickConfirmCookie();

            //кликнуть на кнопку "Заказать"
            objHomePage.clickButtonOrder(buttonLocator);
            //проверить, что находимся на странице заказа
            String actual = driver.getCurrentUrl();
            String expected = "https://qa-scooter.praktikum-services.ru/order";
            Assert.assertEquals("Это не страница заказа", actual, expected);
        }
        @After
        public void teardown () {
            driver.quit();
        }
    }
}


