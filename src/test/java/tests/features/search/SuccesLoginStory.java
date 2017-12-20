package tests.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.TestData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tests.entities.User;
import tests.entities.UserFactory;
import tests.steps.serenity.LoginSteps;

@RunWith(SerenityRunner.class)
public class SuccesLoginStory {
    User user;

    @Managed
    public WebDriver webdriver;

    @Steps
    public LoginSteps clinet;

    @TestData
    public void getData(){
        user = new UserFactory().getUser(1);
    }

    @Before
    public void before(){
        clinet.open();
    }

    @Test
    @Title("Проверка логина валидным пользователем")
    public void succes_login_test(){
        getData();
        clinet.logIn(user);
        clinet.checkLogIn(user.getLogin());
    }
}
