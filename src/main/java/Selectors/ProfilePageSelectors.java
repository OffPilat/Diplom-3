package Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePageSelectors {

    private final WebDriver webDriver;

    public static final String URL_PROFILE_PAGE = "https://stellarburgers.nomoreparties.site/account/profile";

    public By getConstructorButton() {
        return constructorButton;
    }

    public By getMainPageButton() {
        return mainPageButton;
    }

    public By getLogoutButton() {
        return logoutButton;
    }

    private By constructorButton = By.xpath(".//p[contains (text(), 'Конструктор')]");
    private By mainPageButton = By.xpath(".//div[contains (@class, 'logo')]/a[@href='/']");
    private By logoutButton = By.xpath(".//button[contains (text(), 'Выход')]");

    public ProfilePageSelectors(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
