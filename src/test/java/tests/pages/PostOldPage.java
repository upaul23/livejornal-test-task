package tests.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://HOST/update.bml?subject=&event=&version=1")
public class PostOldPage extends MainPage{
    @FindBy(xpath = "//*[@id=\"subject\"]")
    public WebElementFacade subjectField;

    @FindBy(xpath = "//*[@id=\"body\"]")
    public WebElementFacade bodyTextArea;

    @FindBy(xpath = "//*[@id='post']/div/div[5]/div[4]/dl/dd/button[2]|//button[text()='Создать запись']")
    public WebElementFacade submitButton;

    @FindBy(xpath = "//a[text()=\"HTML\"]")
    public WebElementFacade htmlTab;

    @FindBy(xpath = "//label[@for='user']/following-sibling::span/input")
    public WebElementFacade loginField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElementFacade passwordField;

    @FindBy(xpath = "//article[@role='main']//article")
    public WebElementFacade article;

    @FindBy(xpath = "//a[contains(@href, 'editjournal.bml')]")
    public WebElementFacade editPostLink;

    @FindBy(xpath = "//button[@data-value='delete']")
    public WebElementFacade removePost;

    @FindBy(xpath = "//article[@role='main']//h1")
    public WebElementFacade subjectText;

    public String getBody(){
        return article.getAttribute("innerHTML");
    }

    @Override
    protected WebElementFacade getLoadCriteria() {
        return null;
    }
}
