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

public class OrderScooter {
    @RunWith(Parameterized.class)
    public static class OrderTestClass {
        private WebDriver driver;
        @Before
        public void preparingForTest() {
            //драйвер для браузера Chrome
            WebDriverManager.chromedriver().setup();
            this.driver = new ChromeDriver();
            //драйвер для браузера FireFox
            //WebDriverManager.firefoxdriver().setup();
            //WebDriver driver = new FirefoxDriver();
        }
        private final String firstName;
        private final String secondName;
        private final String address;
        private final String metro;
        private final String phone;
        private final String whenDate;
        private final String dayRent;

        public OrderTestClass(String firstName, String secondName, String address, String metro, String phone, String whenDate, String dayRent) {
            this.firstName = firstName;
            this.secondName = secondName;
            this.address = address;
            this.metro = metro;
            this.phone = phone;
            this.whenDate = whenDate;
            this.dayRent = dayRent;
        }
        @Parameterized.Parameters
        public static Object[][] sendFields() {
            return new Object[][]{
                    {"Та", "Та", "Та", "Та", "Та", "20.12.2023", "двое суток"},
                    {"Tatyana", "Melnikova", "Test", "Test", "911", "20.12.2023", "сутки"},
                    {"Татьяна", "Мельникова", "Невский проспект, д.12", "Белорусская", "89991234567", "14.04.2023", "сутки"},
                    {"Татьяна", "Мельникова", "Трам пам пам", "Ленинский проспект", "89998761234", "16.04.2023", "семеро суток"}
            };
        }
        @Test
        public void checkOrderScooter() {
            //переход на страницу заказа
            driver.get("https://qa-scooter.praktikum-services.ru/order");

            //объект класса страницы заказа
            OrderPageScooter objOrderPage = new OrderPageScooter(driver);

            //заполни поля в форме заказа
            objOrderPage.formOrder(firstName, secondName, address, metro, phone, whenDate, dayRent);

            //Подтвердить заказ и убедиться, что он создан
            objOrderPage.clickButtonConfirmOrder();
            String actual = objOrderPage.findTextProcessedOrder();
            Assert.assertEquals("Ошибка: заказ НЕ оформлен", actual, "Заказ оформлен");
        }
        @After
        public void teardown() {
            driver.quit();
        }
    }
}