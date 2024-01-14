import Selectors.MainPageSelectors;
import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.assertNotNull;

public class SectionsMainPageTest {
    private WebDriver webDriver;

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
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
        assertNotNull(By.xpath(".//div[contains (@class, 'tab_tab_type_current')]/span[contains (text(), 'Булки')]"));
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
        assertNotNull(By.xpath(".//div[contains (@class, 'tab_tab_type_current')]/span[contains (text(), 'Соусы')]"));

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
        assertNotNull(By.xpath(".//div[contains (@class, 'tab_tab_type_current')]/span[contains (text(), 'Ингредиенты')]"));
    }

    @After
    public void teardown() {
        webDriver.quit();
    }
}
