package Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassPageSelectors {
    private final WebDriver webDriver;

    public static final String URL_FORGOT_PASS_PAGE = "https://stellarburgers.nomoreparties.site/forgot-password";

    public By getLoginButton() {
        return loginButton;
    }

    public By getProfileButton() {
        return profileButton;
    }

    private By loginButton = By.xpath(".//a[contains (@href, '/login')]");
    private By profileButton = By.xpath(".//p[contains (text(), 'Личный Кабинет')]");

    public ForgotPassPageSelectors(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
