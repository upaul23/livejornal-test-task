package tests.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.TestData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tests.entities.PostFactory;
import tests.entities.User;
import tests.entities.UserFactory;
import tests.steps.serenity.LoginSteps;
import tests.steps.serenity.PostSteps;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

@RunWith(SerenityRunner.class)
public class BlogStory {
    User user;
    Map<String, String> post;


    @Managed
    public WebDriver webdriver;

    @Steps
    public PostSteps postSteps;

    @Steps
    public LoginSteps loginSteps;

    @TestData
    public void getData() {
        user = new UserFactory().getUser(1);
        post = new PostFactory().getPosts().get(1);
    }

    @Before
    public void before(){
        loginSteps.open();
        getData();
    }

    @Test
    @Title("Проверка, что кто кнопка Отправить зайдезейблина при пустых полях")
    public void check_that_submit_disabled(){
        postSteps.openOldEditor();
        postSteps.checkThatSumbitDisabled();
    }

    @Test
    @Title("Проверка, что кто кнопка Отправить зайдезейблина после очистки обязательных полей")
    public void check_that_submit_disabled_after_clean(){
//        loginSteps.logIn(user);
        postSteps.openOldEditor();
        postSteps.typeInSubjectField("Test");
        postSteps.typeInBodyTextArea("Test");
        postSteps.cleanSubject();
        postSteps.cleanBody();
        postSteps.checkThatSumbitDisabled();
    }

    @Test
    @Title("Удаление блога")
    public void remove_post_test(){
        postSteps.openOldEditor();
        postSteps.enterLogin(user.getLogin());
        postSteps.enterPassword(user.getPassword());
        postSteps.typeInSubjectField(post.get("subject"));
        postSteps.typeInBodyTextArea(post.get("body"));
        postSteps.clickWriteToBlog();
        String url = webdriver.getCurrentUrl();
        loginSteps.logIn(user);
        postSteps.removePost(url);
        postSteps.checkThatPostRmove(url);
    }
}
