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
public class UnsuccessfulLoginStory {
    User deletedUser;
    User nonexistentUser;
    User wrongPassword;

    @Managed
    public WebDriver webdriver;

    @Steps
    public LoginSteps clinet;

    @Before
    public void before(){
        clinet.open();
        getData();
    }

    @TestData
    public void getData(){
        deletedUser = new UserFactory().getUser(2);
        nonexistentUser = new UserFactory().getUser(3);
        wrongPassword = new UserFactory().getUser(4);
    }

    @Test
    @Title("Проверка сообщения при удаленном журнале")
    public void check_deleted_user_message(){
        clinet.logIn(deletedUser);
        clinet.checkLoginErrorMessage("Этот журнал удален");
    }

    @Test
    @Title("Проверка сообщения при несуществующем логине")
    public void check_nonexistent_user_message(){
        clinet.logIn(nonexistentUser);
        clinet.checkLoginErrorMessage("Имя не найдено. Создать?");
    }

    @Test
    @Title("Проверка сообщения при неверном пароле")
    public void check_wrong_password_message(){
        clinet.logIn(wrongPassword);
        clinet.checkPasswordErrorMessage("Неверный пароль");
    }

    @Test
    @Title("Проверка сообщения при пустом поле логин")
    public void check_empty_login_message(){
        clinet.clickOnEnter();
        clinet.clickEnterInPopup();
        clinet.checkLoginErrorMessage("Введите имя пользователя");
    }

    @Test
    @Title("Проверка сообщения при пустом поле пароль")
    public void check_empty_password_message(){
        clinet.clickOnEnter();
        clinet.enterLogin("123");
        clinet.clickEnterInPopup();
        clinet.checkPasswordErrorMessage("Введите пароль");
    }



}

