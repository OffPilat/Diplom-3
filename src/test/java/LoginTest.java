import Selectors.ForgotPassPageSelectors;
import Selectors.LoginPageSelectors;
import Selectors.MainPageSelectors;
import Selectors.RegisterPageSelectors;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static Driver.WebDriverCreator.createWebDriver;
import static org.junit.Assert.assertEquals;

public class LoginTest {
    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = createWebDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @DisplayName("Тест на проверку перехода в Личный кабинет с главной страницы")
    @Description("Проверка работы UI по редиректу в Личный кабинет")
    @Test
    public void LoginFromMainPageViaLoginButton() {
        MainPageSelectors mainPageSelectors = new MainPageSelectors(webDriver);
        LoginPageSelectors loginPageSelectors = new LoginPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(mainPageSelectors.URL_MAIN_PAGE)
                .click(mainPageSelectors.getLoginButton());
        assertEquals("Вход", webDriver.findElement(loginPageSelectors.getLogoPage()).getText());
    }

    @DisplayName("Тест на проверку перехода в Личный кабинет с главной страницы через кнопку")
    @Description("Проверка работы UI по редиректу в Личный кабинет")
    @Test
    public void LoginFromMainPageViaProfileButton() {
        MainPageSelectors mainPageSelectors = new MainPageSelectors(webDriver);
        LoginPageSelectors loginPageSelectors = new LoginPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(mainPageSelectors.URL_MAIN_PAGE)
                .click(mainPageSelectors.getProfileButton());
        assertEquals("Вход", webDriver.findElement(loginPageSelectors.getLogoPage()).getText());
    }

    @DisplayName("Тест на проверку перехода в Личный кабинет со страницы регистрации")
    @Description("Проверка работы UI по редиректу в Личный кабинет")
    @Test
    public void LoginFromRegisterPageViaLoginButton() {
        RegisterPageSelectors registerPageSelectors = new RegisterPageSelectors(webDriver);
        LoginPageSelectors loginPageSelectors = new LoginPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(registerPageSelectors.URL_REGISTER_PAGE)
                .click(registerPageSelectors.getLoginButton());
        assertEquals("Вход", webDriver.findElement(loginPageSelectors.getLogoPage()).getText());
    }

    @DisplayName("Тест на проверку перехода в Личный кабинет со страницы восстановления пароля")
    @Description("Проверка работы UI по редиректу в Личный кабинет")
    @Test
    public void LoginFromForgotPassPageViaLoginButton() {
        ForgotPassPageSelectors forgotPassPageSelectors = new ForgotPassPageSelectors(webDriver);
        LoginPageSelectors loginPageSelectors = new LoginPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(forgotPassPageSelectors.URL_FORGOT_PASS_PAGE)
                .click(forgotPassPageSelectors.getLoginButton());
        assertEquals("Вход", webDriver.findElement(loginPageSelectors.getLogoPage()).getText());
    }

    @After
    public void teardown() {
        webDriver.quit();
    }
}
