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
    //Метод для клика на вопрос
    public void clickQuestion(String questionId) {
        driver.findElement(By.id(questionId)).click();
    }
    //Метод для получения ответа из вопроса, на который нажали
    public String getAnswerText(String answerId) {
        return driver.findElement(By.id(answerId)).getText();
    }
    //Объединенный метод для проверки текста в вопросе
    public String checkAnswerText(String questionId, String answerId) {
        findListFaq();
        clickQuestion(questionId);
        return getAnswerText(answerId);
    }
    //Метод для нажатия на кнопку "Заказать"
    public void clickButtonOrder(String buttonLocator) {
        driver.findElement(By.xpath(buttonLocator)).click();
    }
}
