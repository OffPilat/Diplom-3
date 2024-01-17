import Selectors.MainPageSelectors;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static Driver.WebDriverCreator.createWebDriver;
import static org.junit.Assert.assertTrue;

public class SectionsMainPageTest {
    private WebDriver webDriver;

    @Before
    public void setup() {
        webDriver = createWebDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @DisplayName("Тест на проверку активности раздела Булки")
    @Description("Проверка работы UI активности панели сбора бургера")
    @Test
    public void ActivationBunsSection() {
        MainPageSelectors mainPageSelectors = new MainPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(mainPageSelectors.URL_MAIN_PAGE)
                .click(mainPageSelectors.getSaucesButton())
                .click(mainPageSelectors.getBunsButton());
        assertTrue((steps.find(mainPageSelectors.getBunsButtonActive()).isDisplayed()));
    }

    @DisplayName("Тест на проверку активности раздела Соусы")
    @Description("Проверка работы UI активности панели сбора бургера")
    @Test
    public void ActivationSaucesSection() {
        MainPageSelectors mainPageSelectors = new MainPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(mainPageSelectors.URL_MAIN_PAGE)
                .click(mainPageSelectors.getSaucesButton());
        assertTrue((steps.find(mainPageSelectors.getSaucesButtonActive()).isDisplayed()));

    }

    @DisplayName("Тест на проверку активности раздела Начинки")
    @Description("Проверка работы UI активности панели сбора бургера")
    @Test
    public void ActivationFillingsSection() {
        MainPageSelectors mainPageSelectors = new MainPageSelectors(webDriver);
        Steps steps = new Steps(webDriver);
        steps
                .open(mainPageSelectors.URL_MAIN_PAGE)
                .click(mainPageSelectors.getFillingsButton());
        assertTrue((steps.find(mainPageSelectors.getFillingsButtonActive()).isDisplayed()));
    }

    @After
    public void teardown() {
        webDriver.quit();
    }
}
