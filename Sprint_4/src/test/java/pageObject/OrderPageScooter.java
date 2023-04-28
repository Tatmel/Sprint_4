package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPageScooter {
    private WebDriver driver;
    //Локаторы на форму заказа
    // (1) Имя
    private By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    // (2) Фамилия
    private By secondNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // (3) Адрес
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // (4) Станция метро
    private By metroListField = By.xpath(".//input[@placeholder='* Станция метро']");
    // (5) Телефон
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // (6) Кнопка "Далее"
    private By buttonNext = By.xpath(".//button[text()='Далее']");

    //Локаторы на поля в форме "Про аренду"
    // (1) Когда привезти самокат
    private By whenDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // (2) Срок аренды
    private By dayRentField = By.className("Dropdown-root");
    private By dayRentDropdownOptions = By.xpath(".//div[@class = 'Dropdown-menu']/div");

    //Кнопка "Заказать"
    private By buttonOrder = By.xpath(".//div[contains(@class, 'Order_Buttons')]/button[text()='Заказать']");
    //Всплывающее окно "Хотите оформить заказ?"
    //Кнопка "Да"
    private By buttonConfirmOrder = By.xpath(".//div[contains(@class, 'Order_Modal')]/div/button[text()='Да']");

    //Локатор на текст , что заказ оформлен
    private By processedOrder = By.xpath(".//div[text() = 'Заказ оформлен']");

    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для ввода имени
    public void setFirstNameField(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    //Метод для ввода фамилии
    public void setSecondNameField(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }
    //Метод для ввода адреса
    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    //Метод для выбора метро
    public void setMetroListField(String metro) {
        WebDriverWait ulWait = new WebDriverWait(driver, 30);
        ulWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(metroListField));
        driver.findElement(metroListField).click();
        driver.findElement(metroListField).sendKeys(Keys.ARROW_DOWN, metro);
        driver.findElement(metroListField).sendKeys(Keys.ENTER);
    }
    //Метод для ввода телефона
    public void setPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }
    //Метод для клика по кнопке "Далее"
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    //Методы для формы "Про аренду"
    //Метод для ввода даты
    public void setWhenDateField(String whenDate) {
        driver.findElement(whenDateField).sendKeys(whenDate, Keys.ENTER);
    }
    // Метод для выбора срока аренды
    public void setDayRentField(String dayRent) {
        WebDriverWait ulWait = new WebDriverWait(driver, 30);
        ulWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dayRentField));
        driver.findElement(dayRentField).click();
        driver.findElement(dayRentDropdownOptions).click();
    }
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    //Объединенный метод оформления заказа
    public void formOrder(String firstName, String secondName, String address, String metro, String phone, String whenDate, String dayRent) {
        setFirstNameField(firstName);
        setSecondNameField(secondName);
        setAddressField(address);
        setMetroListField(metro);
        setPhoneField(phone);
        clickButtonNext();
        setWhenDateField(whenDate);
        setDayRentField(dayRent);
        clickButtonOrder();
    }

    //Метод для подтверждения заказа
    public void clickButtonConfirmOrder() {
        driver.findElement(buttonConfirmOrder).click();
    }

    //Метод для поиска текста "Заказ оформлен" после подтверждения заказа
    public String findTextProcessedOrder() { return driver.findElement(processedOrder).getText(); }
}


