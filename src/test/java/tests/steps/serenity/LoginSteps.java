package tests.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;
import org.seleniumhq.jetty9.server.Authentication;
import tests.entities.User;
import tests.pages.MainPage;

public class LoginSteps {

    MainPage page;

    @StepGroup("Выполнить авторизацию")
    public void logIn(User user){
        page.waitTimeout(15000L);
        clickOnEnter();
        enterLogin(user.getLogin());
        enterPassword(user.getPassword());
        clickEnterInPopup();
    }

    @Step("Ввести нажать на ссылку Войти в хедере")
    public void clickOnEnter(){
        //Таймаут если появится рекламный банер
        page.waitTimeout(10000L);
        page.loginLink.click();
    }

    @Step("Ввести логин в поле логина")
    public void enterLogin(String login){
        page.loginField.sendKeys(login);
    }

    @Step("Ввести пароль в поле пароль")
    public void enterPassword(String password){
        page.passwordField.sendKeys(password);
    }

    @Step("Нажать войти в окне авторизации")
    public void clickEnterInPopup(){
        page.logInButton.click();
    }

    @Step("Проверить, что авторизация выполнена")
    public void checkLogIn(String expectedName){
        Assert.assertEquals("Имя пользователя неверное", expectedName.toLowerCase(), page.userNameBar.getText().toLowerCase());
    }

    @Step("Проверка сообщения об ошибка для поля логин")
    public void checkLoginErrorMessage(String expectedErrorMsg){
        String actualErrorMsg = page.loginErrorMessage.getText();
        Assert.assertEquals("Сообщение об ошибки невереное", expectedErrorMsg, actualErrorMsg);
    }

    @Step("Проверка сообщения об ошибка для поля пароль")
    public void checkPasswordErrorMessage(String expectedErrorMsg){
        String actualErrorMsg = page.passwordErrorMessage.getText();
        Assert.assertEquals("Сообщение об ошибки невереное", expectedErrorMsg, actualErrorMsg);
    }

    @Step("Открыть страницу")
    public void open() {
        page.open();
        page.waitFor(5000);
    }
}
