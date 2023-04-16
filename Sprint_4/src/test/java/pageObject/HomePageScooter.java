package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageScooter {
    private WebDriver driver;
    //Локатор для закрытия куки по кнопке
    private By buttonCookie = By.id("rcc-confirm-button");

    //Локатор для списка вопросов
    private By listFaq = By.xpath(".//div[contains(@class, 'Home_FAQ')]");

    // Локатор для открытия каждого вопроса в выпадающем списке
    private By questionOneInFAQ = By.id("accordion__heading-0");
    private By questionTwoInFAQ = By.id("accordion__heading-1");
    private By questionThreeInFAQ = By.id("accordion__heading-2");
    private By questionFourInFAQ = By.id("accordion__heading-3");
    private By questionFiveInFAQ = By.id("accordion__heading-4");
    private By questionSixInFAQ = By.id("accordion__heading-5");
    private By questionSevenInFAQ = By.id("accordion__heading-6");
    private By questionEightInFAQ = By.id("accordion__heading-7");

    // Локатор  для кнопки "Заказать" вверху страницы (возможно потребуется проскроллить назад вверх страницы)
    private By buttonOrderInUpPage = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    // Локатор для кнопки "Заказать" внизу страницы
    private By buttonOrderInDownPage = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()= 'Заказать']");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для нажатия на кнопку куки
    public void clickConfirmCookie() {
        driver.findElement(buttonCookie).click();
    }

    //Метод для перехода к списку вопросов
    public void findListFaq() {
        WebElement element = driver.findElement(listFaq);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Метод для нажатия на вопрос из выпадающего списка
    public void clickQuestionOneInFAQ() {
        driver.findElement(questionOneInFAQ).click();
    }
    public void clickQuestionTwoInFAQ() {
        driver.findElement(questionTwoInFAQ).click();
    }
    public void clickQuestionThreeInFAQ() {
        driver.findElement(questionThreeInFAQ).click();
    }
    public void clickQuestionFourInFAQ() {
        driver.findElement(questionFourInFAQ).click();
    }
    public void clickQuestionFiveInFAQ() {
        driver.findElement(questionFiveInFAQ).click();
    }
    public void clickQuestionSixInFAQ() {
        driver.findElement(questionSixInFAQ).click();
    }
    public void clickQuestionSevenInFAQ() {
        driver.findElement(questionSevenInFAQ).click();
    }
    public void clickQuestionEightInFAQ() {
        driver.findElement(questionEightInFAQ).click();
    }

    //Метод для нажатия на кнопку "Заказать" вверху страницы
    public void clickOrderUpPage() {
        driver.findElement(buttonOrderInUpPage).click();
    }

    //Метод для нажатия на кнопку "Заказать" внизу страницы
    public void clickOrderDownPage() {
        driver.findElement(buttonOrderInDownPage).click();
    }
}
