package Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPageSelectors {
    private final WebDriver webDriver;

    public static final String URL_REGISTER_PAGE = "https://stellarburgers.nomoreparties.site/register";

    private By nameField = By.xpath(".//label[contains (text(), 'Имя')]/ancestor::div[contains (@class, 'input')]/input");

    public By getNameField() {
        return nameField;
    }

    public By getEmailField() {
        return emailField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getRegisterButton() {
        return registerButton;
    }

    public By getFailTip() {
        return failTip;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getProfileButton() {
        return profileButton;
    }

    private By emailField = By.xpath(".//label[contains (text(), 'Email')]/ancestor::div[contains (@class, 'input')]/input");
    private By passwordField = By.xpath(".//label[contains (text(), 'Пароль')]/ancestor::div[contains (@class, 'input')]/input");
    private By registerButton = By.xpath(".//button[contains (text(), 'Зарегистрироваться')]");
    private By failTip = By.xpath(".//p[contains (@class, 'input__error ')]");
    private By loginButton = By.xpath(".//a[contains (@href, '/login')]");
    private By profileButton = By.xpath(".//p[contains (text(), 'Личный Кабинет')]");

    public RegisterPageSelectors(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
