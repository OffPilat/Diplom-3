package Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageSelectors {
    private final WebDriver webDriver;

    public static final String URL_LOGIN_PAGE = "https://stellarburgers.nomoreparties.site/login";

    private By loginButton = By.xpath(".//button[contains (text(), 'Войти')]");

    public By getLoginButton() {
        return loginButton;
    }

    public By getProfileButton() {
        return profileButton;
    }

    public By getConstructorButton() {
        return constructorButton;
    }

    public By getMainPageButton() {
        return mainPageButton;
    }

    public By getLogoPage() {
        return logoPage;
    }

    private By profileButton = By.xpath(".//p[contains (text(), 'Личный Кабинет')]");
    private By constructorButton = By.xpath(".//p[contains (text(), 'Конструктор')]");
    private By mainPageButton = By.xpath(".//div[contains (@class, 'logo')]/a[@href='/']");

    public By getEmailField() {
        return emailField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    private By emailField = By.xpath(".//label[contains (text(), 'Email')]/ancestor::div[contains (@class, 'input')]/input");
    private By passwordField = By.xpath(".//label[contains (text(), 'Пароль')]/ancestor::div[contains (@class, 'input')]/input");
    private By logoPage = By.xpath(".//h2[contains (text(), 'Вход')]");

    public LoginPageSelectors(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
