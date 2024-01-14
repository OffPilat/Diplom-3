import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Steps {

    private WebDriver webDriver;

    public Steps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Step("Открытие url")
    public Steps open(String Url) {
        webDriver.get(Url);
        return this;
    }

    @Step("Поиск элемента")
    public Steps find(By element) {
        WebElement new_element = webDriver.findElement(element);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    @Step("Клик по элементу")
    public Steps click(By element) {
        webDriver.findElement(element).click();
        return this;
    }

    @Step("Ввод текста в поле")
    public Steps inputText(By element, String text) {
        webDriver.findElement(element).sendKeys(text);
        return this;
    }


}