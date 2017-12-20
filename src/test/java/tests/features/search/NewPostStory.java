package tests.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.After;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Concurrent(threads="1")
@RunWith(SerenityParameterizedRunner.class)
public class NewPostStory {
    Map<String, String> post;
    User user;
    String postUrl;

    @Managed
    WebDriver driver;

    public NewPostStory(Map<String, String> post){
        this.post = post;
        this.user = new UserFactory().getUser(1);
    }

    @Steps
    public PostSteps postSteps;

    @Steps
    public LoginSteps loginSteps;

    @TestData
    public static Collection<Object[]> testData() throws IOException {
        return new PostFactory().getAsCollection();
    }

    @Before
    public void before(){
        postSteps.openOldEditor();
    }

    @Test
    @Title("Тест добавления поста с различным контентом")
    public void check_that_submit_disabled_after_clean(){
        postSteps.enterLogin(user.getLogin());
        postSteps.enterPassword(user.getPassword());
        postSteps.typeInSubjectField(post.get("subject"));
        postSteps.typeInBodyTextArea(post.get("body"));
        postUrl = postSteps.clickWriteToBlog();
        postSteps.checkPostContent(post.get("subject"), post.get("body"));

    }

    @After
    public void after(){
        loginSteps.logIn(user);
        postSteps.removePost(postUrl);
    }
}
