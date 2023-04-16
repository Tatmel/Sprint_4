package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickButtonOrder {
    private WebDriver driver;

    @Test
    public void checkClickButtonOrder() {
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

        //кликнуть на кнопку "Заказать" вверху страницы
        objHomePage.clickOrderUpPage();
        //проверить, что находимся на странице заказа
        String actual = driver.getCurrentUrl();
        String expected = "https://qa-scooter.praktikum-services.ru/order";
        Assert.assertEquals("Это не страница заказа", actual, expected);

        //вернуться на главную страницу
        driver.get("https://qa-scooter.praktikum-services.ru/");
        //кликнуть на кнопку "Заказать" внизу страницы
        objHomePage.clickOrderDownPage();
        //проверить, что находимся на странице заказа
        actual = driver.getCurrentUrl();
        Assert.assertEquals("Это не страница заказа", actual, expected);

    }
    @After
    public void teardown() {
        driver.quit();
    }
}
