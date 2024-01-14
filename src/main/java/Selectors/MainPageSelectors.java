package Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPageSelectors {
    private final WebDriver webDriver;

    public static final String URL_MAIN_PAGE = "https://stellarburgers.nomoreparties.site/";

    public By getLoginButton() {
        return loginButton;
    }

    public By getProfileButton() {
        return profileButton;
    }

    public By getTitleHead() {
        return titleHead;
    }

    public By getBunsButton() {
        return bunsButton;
    }

    public By getSaucesButton() {
        return saucesButton;
    }

    public By getFillingsButton() {
        return fillingsButton;
    }

    private By loginButton = By.xpath(".//button[contains (text(), 'Войти')]");
    private By profileButton = By.xpath(".//p[contains (text(), 'Личный Кабинет')]");
    private By titleHead = By.xpath(".//h1[contains (text(), 'Соберите бургер')]");
    private By bunsButton = By.xpath(".//span[contains (text(), 'Булки')]");

    public By getBunsButtonActive() {
        return bunsButtonActive;
    }

    public By getSaucesButtonActive() {
        return saucesButtonActive;
    }

    public By getFillingsButtonActive() {
        return fillingsButtonActive;
    }

    private By bunsButtonActive = By.xpath(".//div[contains (@class, 'tab_tab_type_current')]/span[contains (text(), 'Булки')]");
    private By saucesButton = By.xpath(".//span[contains (text(), 'Соусы')]");
    private By saucesButtonActive = By.xpath(".//div[contains (@class, 'tab_tab_type_current')]/span[contains (text(), 'Булки')]");
    private By fillingsButton = By.xpath(".//span[contains (text(), 'Начинки')]");
    private By fillingsButtonActive = By.xpath(".//div[contains (@class, 'tab_tab_type_current')]/span[contains (text(), 'Начинки')]");


    public MainPageSelectors(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
