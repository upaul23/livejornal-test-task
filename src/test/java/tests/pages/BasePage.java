package tests.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Paul on 02.03.2017.
 */
@DefaultUrl("https://HOST")
public abstract class BasePage extends PageObject {

    protected abstract WebElementFacade getLoadCriteria();


    public void waitTimeout(long value){
        waitABit(value);
    }

    public void javaScriptClick(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        waitTimeout(2000);
        executor.executeScript("arguments[0].click();", element);
        waitStandartTimeout();
    }

    public void waitStandartTimeout(){
        waitABit(4000);
    }

    public void moveDown(int times, WebElementFacade element){
        for (int x = 0; x <= times; x++){
            element.sendKeys(Keys.ARROW_DOWN);
            waitStandartTimeout();
        }
    }

    public void javaScriptSetAttribute(WebElement element, String value){
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].setAttribute('value', '"+ value +"')" , element);
        waitStandartTimeout();
    }

    public void clickTargetValueFromSuggest(String target){
        WebElement el = getDriver().findElement(By.xpath("//div[contains(@class, 'input__suggest')]"));
        waitFor(el);
        actionClick(getDriver().findElement(By.xpath("//div[contains(text(), '"+target+"') and @class='input__suggest__element '][1]")));
    }

    public void actionClick(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        waitTimeout(2000);
        new Actions(getDriver()).moveToElement(element).click().build().perform();
    }

    public void enterText(WebElementFacade field, String value){
        waitFor(field);
        field.sendKeys(value);
    }

}
