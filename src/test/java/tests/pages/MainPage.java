package tests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://HOST")
public class MainPage extends BasePage {

    @FindBy(xpath = "//a[text()='Войти']|//a[text()='Login']")
    public WebElementFacade loginLink;

    @FindBy(xpath = "//*[@id=\"user\"]")
    public WebElementFacade loginField;

    @FindBy(xpath = "//*[@id=\"lj_loginwidget_password\"]")
    public WebElementFacade passwordField;

    @FindBy(xpath = "//button[@name='action:login']")
    public WebElementFacade logInButton;

    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/header/div/nav[2]/ul/li[3]/a/span")
    public WebElementFacade userNameBar;

    @FindBy(xpath = "//*[@id=\"user\"]/parent::div/following-sibling::span")
    public WebElementFacade loginErrorMessage;

    @FindBy(xpath = "//*[@id=\"lj_loginwidget_password\"]/parent::div/following-sibling::span")
    public WebElementFacade passwordErrorMessage;

    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/header/div/nav[2]/ul/li[4]/a/span[1]|//button[text()='Создать запись']")
    public WebElementFacade writeToBlog;


    @Override
    protected WebElementFacade getLoadCriteria() {
        return null;
    }
}
