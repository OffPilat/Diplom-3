import Api.UserClient;
import Selectors.LoginPageSelectors;
import Selectors.MainPageSelectors;
import Selectors.ProfilePageSelectors;
import constants.EndPoints;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static Driver.WebDriverCreator.createWebDriver;
import static org.junit.Assert.assertEquals;

public class LogoutTest {
    private WebDriver webDriver;
    UserClient userClient = new UserClient();

    @Before
    public void setup() {
        webDriver = createWebDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        RestAssured.baseURI = EndPoints.BASE_URL;
        userClient.createUser();
    }

    @DisplayName("Тест на проверку выхода из профиля пользователя")
    @Description("Проверка работы UI по выходу из профиля")
    @Test
    public void LogoutViaButton() {
        ProfilePageSelectors profilePageSelectors = new ProfilePageSelectors(webDriver);
        LoginPageSelectors loginPageSelectors = new LoginPageSelectors(webDriver);
        MainPageSelectors mainPageSelectors = new MainPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(loginPageSelectors.URL_LOGIN_PAGE)
                .inputText(loginPageSelectors.getEmailField(), "fexuaa@yandex.ru")
                .inputText(loginPageSelectors.getPasswordField(), "123456Qa")
                .click(loginPageSelectors.getLoginButton())
                .click(mainPageSelectors.getProfileButton())
                .click(profilePageSelectors.getLogoutButton());
        assertEquals("Вход", webDriver.findElement(loginPageSelectors.getLogoPage()).getText());
    }

    @After
    public void teardown() {
        userClient.deleteUser();
        webDriver.quit();
    }
}
