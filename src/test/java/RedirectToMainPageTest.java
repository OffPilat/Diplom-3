import Selectors.LoginPageSelectors;
import Selectors.MainPageSelectors;
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

public class RedirectToMainPageTest {
    private WebDriver webDriver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @DisplayName("Тест на проверку перехода на главную страницу через логотип")
    @Description("Проверка работы UI по редиректу на главную страницу")
    @Test
    public void RedirectToMainPageViaLogo() {
        LoginPageSelectors loginPageSelectors = new LoginPageSelectors(webDriver);
        MainPageSelectors mainPageSelectors = new MainPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(loginPageSelectors.URL_LOGIN_PAGE)
                .click(loginPageSelectors.getMainPageButton());
        assertEquals("Соберите бургер", webDriver.findElement(mainPageSelectors.getTitleHead()).getText());
    }

    @DisplayName("Тест на проверку перехода на главную страницу через кнопку конструктора")
    @Description("Проверка работы UI по редиректу на главную страницу")
    @Test
    public void RedirectToMainPageViaConstructorButton() {
        LoginPageSelectors loginPageSelectors = new LoginPageSelectors(webDriver);
        MainPageSelectors mainPageSelectors = new MainPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(loginPageSelectors.URL_LOGIN_PAGE)
                .click(loginPageSelectors.getConstructorButton());
        assertEquals("Соберите бургер", webDriver.findElement(mainPageSelectors.getTitleHead()).getText());
    }

    @After
    public void teardown() {
        webDriver.quit();
    }
}
