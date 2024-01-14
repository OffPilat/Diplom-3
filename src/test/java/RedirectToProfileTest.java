import Selectors.ForgotPassPageSelectors;
import Selectors.LoginPageSelectors;
import Selectors.RegisterPageSelectors;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class RedirectToProfileTest {
    private WebDriver webDriver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @DisplayName("Тест на проверку перехода на страницу личного кабинета из страницы восстановления пароля")
    @Description("Проверка работы UI по редиректу на страницу личного кабинета")
    @Test
    public void RedirectFromForgotPageViaProfileButton() {
        ForgotPassPageSelectors forgotPassPageSelectors = new ForgotPassPageSelectors(webDriver);
        LoginPageSelectors loginPageSelectors = new LoginPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(forgotPassPageSelectors.URL_FORGOT_PASS_PAGE)
                .click(forgotPassPageSelectors.getProfileButton());
        assertEquals("Вход", webDriver.findElement(loginPageSelectors.getLogoPage()).getText());
    }

    @DisplayName("Тест на проверку перехода на страницу личного кабинета из страницы регистрации")
    @Description("Проверка работы UI по редиректу на страницу личного кабинета")
    @Test
    public void RedirectFromRegisterPageViaProfileButton() {
        RegisterPageSelectors registerPageSelectors = new RegisterPageSelectors(webDriver);
        LoginPageSelectors loginPageSelectors = new LoginPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(registerPageSelectors.URL_REGISTER_PAGE)
                .click(registerPageSelectors.getProfileButton());
        assertEquals("Вход", webDriver.findElement(loginPageSelectors.getLogoPage()).getText());
    }

    @After
    public void teardown() {
        webDriver.quit();
    }
}
