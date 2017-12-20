package tests.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import tests.pages.PostOldPage;

public class PostSteps {
    PostOldPage postOldPage;

    @Step("Проверить, что кнопка Отправить задезейблина")
    public void checkThatSumbitDisabled(){
        String t = postOldPage.submitButton.getAttribute("disabled");
        Assert.assertTrue("Отсуствуе аттрибут disabled для кнопки Отправить",postOldPage.submitButton.getAttribute("disabled").equals("true"));
    }

    @Step("Нажать на 'Написать в блог'")
    public String clickWriteToBlog(){
        postOldPage.actionClick(postOldPage.writeToBlog);
        postOldPage.waitTimeout(10000L);
        return postOldPage.getDriver().getCurrentUrl();
    }

    @Step("Открыть старый редактор")
    public void openOldEditor(){
        postOldPage.open();
    }

    @Step("Ввод в поле Тема")
    public void typeInSubjectField(String text){
        postOldPage.subjectField.sendKeys(text);
    }

    @Step("Ввод в поле тело блога")
    public void typeInBodyTextArea(String text){
        postOldPage.actionClick(postOldPage.htmlTab);
        postOldPage.bodyTextArea.sendKeys(text);
    }

    @Step("Очистить поле тело блога")
    public void cleanBody(){
        postOldPage.bodyTextArea.clear();
    }

    @Step("Очистить поле тело блога")
    public void cleanSubject(){
        postOldPage.subjectField.clear();
    }

    @Step("Ввести логин в поле логина")
    public void enterLogin(String login){
        postOldPage.loginField.sendKeys(login);
    }

    @Step("Удалить пост")
    public void removePost(String url){
        postOldPage.getDriver().get(url);
        postOldPage.editPostLink.click();
        postOldPage.actionClick(postOldPage.removePost);
        postOldPage.getAlert().accept();
    }

    @Step("Проверить, что пост удален")
    public void checkThatPostRmove(String url){
        postOldPage.getDriver().get(url);
        String text = postOldPage.find(By.xpath("/html/body/div[1]/div/div/div/section[1]/h1")).getText();
        Assert.assertEquals("Страница не найдена", text);
    }

    @Step("Ввести пароль в поле пароль")
    public void enterPassword(String password){
        postOldPage.passwordField.sendKeys(password);
    }

    @Step("Проверить содержимое поста")
    public void checkPostContent(String expectedSubject, String expectedBody){
        String source = postOldPage.getBody();
        Assert.assertTrue(source.contains(expectedBody));
        String subject = postOldPage.subjectText.getText();
        Assert.assertEquals(expectedSubject, subject);

    }

}
