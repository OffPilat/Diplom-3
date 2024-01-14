import Api.UserClient;
import Selectors.LoginPageSelectors;
import Selectors.RegisterPageSelectors;
import constants.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class RegisterTest {
    private WebDriver webDriver;
    UserClient userClient = new UserClient();

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        RestAssured.baseURI = EndPoints.BASE_URL;
    }

    @DisplayName("Тест на регистрацию пользователя")
    @Description("Проверка работы UI регистрации пользователя")
    @Test
    public void successfulRegistration() {
        RegisterPageSelectors registerPageSelectors = new RegisterPageSelectors(webDriver);
        LoginPageSelectors loginPageSelectors = new LoginPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(registerPageSelectors.URL_REGISTER_PAGE)
                .inputText(registerPageSelectors.getNameField(), "Fexuaa")
                .inputText(registerPageSelectors.getEmailField(), "fexuaa@yandex.ru")
                .inputText(registerPageSelectors.getPasswordField(), "123456Qa")
                .click(registerPageSelectors.getRegisterButton());
        assertEquals("Вход", webDriver.findElement(loginPageSelectors.getLogoPage()).getText());
    }

    @DisplayName("Тест на проверку подсказки пароля при регистрации пользователя")
    @Description("Проверка работы UI регистрации пользователя")
    @Test
    public void failTipRegistration() {
        RegisterPageSelectors registerPageSelectors = new RegisterPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(registerPageSelectors.URL_REGISTER_PAGE)
                .inputText(registerPageSelectors.getNameField(), "Fexuaa12345")
                .inputText(registerPageSelectors.getEmailField(), "fexuaa123456@yandex.ru")
                .inputText(registerPageSelectors.getPasswordField(), "1234")
                .click(registerPageSelectors.getRegisterButton());
        assertEquals("Некорректный пароль", webDriver.findElement(registerPageSelectors.getFailTip()).getText());
    }

    @After
    public void teardown() {
        webDriver.quit();
        userClient.deleteUser();
    }
}
