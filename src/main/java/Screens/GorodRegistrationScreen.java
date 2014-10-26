package Screens;

import Tests.SmokeTest;
import Utils.DriverWrapper;
import Utils.LoadPage;
import Utils.PageScreenShot;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import java.io.IOException;

/**
 * Created by Evil on 27.09.2014.
 */

public class GorodRegistrationScreen {
    DriverWrapper wrapper;
    public static final Logger log = Logger.getLogger(SmokeTest.class);

    final static String USER_EMAIL = "//input[@id ='user_login']";
    final static String USER_PASS = "//input[@id ='user_password']";
    final static String USER_PASS_CONFIRM = "//input[@id ='user_password2']";
    final static String USER_NAME = "//input[@id ='user_firstname']";
    final static String USER_SURNAME = "//input[@id ='user_surname']";
    final static String CHECK_BOX_CONF1 = "//div[@id='ccheck_policy']/div[@class='btn']";//Я согласен(на) с  соглашением о пользовании Порталом
    final static String CHECK_BOX_CONF2 = "//div[@id='ccheck_rules']/div[@class='btn']";//ознакомлен(а) с Едиными правилами модерации
   // final static String CHECK_BOX_CONF3 = "//div[@id='ccheck_is_get_email']/div[@class='btn']";//Я согласен(на) получать сообщения о новостях Портала
    final static String USER_AVATAR = "//div[@id ='registerAvatarBlock']";
    final static String USER_AVATAR_CLICK = "//div[@id ='avatar289']";
    final static String USER_AVATAR_SAVE = "//div[@class ='button-wr']";
    final static String USER_REGISTRATION_BTN = "//div[@class ='ui-button undefined']";
    final static String REGISTRATION_ACCEPT_POPUP_XPATH = "//div[@id = 'alertContent']";
    final static String REGISTRATION_ACCEPT_TEXT_XPATH = "//div[@class = 'auth-completed']";
    final static String REGISTRATION_ACCEPT_BUTTON_XPATH = "//div [text() = 'Хорошо']";


    GorodRegistrationScreen(WebDriver driver) {
        wrapper = new DriverWrapper(driver);
    }


    private GorodRegistrationScreen enterUserEmail() {
        log.info("Вводим почтовый адрес для нового пользователя");
        wrapper.clickByXpath(USER_EMAIL);//сделать такую обертку для остального в DriwerWrapper
        wrapper.sendKeysByXpath(USER_EMAIL,"eviltech86@gmail.com");

        return this;
    }

    private GorodRegistrationScreen enterUserPassword() {
        log.info("Вводим пароль для нового пользователя");
        wrapper.clickByXpath(USER_PASS);
        wrapper.sendKeysByXpath(USER_PASS,"11111111");
        return this;
    }

    private GorodRegistrationScreen enterUserPasswordConfirm(){
        log.info("Повторяем ввод пароля для нового пользователя");
        wrapper.clickByXpath(USER_PASS_CONFIRM);
        wrapper.sendKeysByXpath(USER_PASS_CONFIRM,"11111111");
        return this;
    }

    private GorodRegistrationScreen enterUserName(){
        log.info("Вводим имя пользователя");
        wrapper.clickByXpath(USER_NAME);
        wrapper.sendKeysByXpath(USER_NAME,"Test");
        return this;
    }

    private GorodRegistrationScreen enterUserSurName(){
        log.info("Вводим фамилию пользователя");
        wrapper.clickByXpath(USER_SURNAME);
        wrapper.sendKeysByXpath(USER_SURNAME,"Prognoz");

        return this;
    }

    private GorodRegistrationScreen selectCheckboxUserConfirm(){
        log.info("Выбираем чекбокс Я согласен(на) с  соглашением о пользовании Порталом");
        if ( !wrapper.isSelectedByXpath(CHECK_BOX_CONF1))
        {
            wrapper.clickByXpath(CHECK_BOX_CONF1);
        }
        return this;
    }

    private GorodRegistrationScreen selectUniformRulesOfModeration(){
        log.info("Выбираем чекбокс ознакомлен(а) с Едиными правилами модерации");
        if ( !wrapper.isSelectedByXpath(CHECK_BOX_CONF2))
        {
            wrapper.clickByXpath(CHECK_BOX_CONF2);
        }
        return this;
    }

    private GorodRegistrationScreen selectUserAvatar(){
        log.info("Выбираем аватар");
        wrapper.clickByXpath(USER_AVATAR);
        return this;
    }

    private GorodRegistrationScreen selectUserAvatarStep2(){
        log.info("Выбираем аватар шаг2");
        wrapper.clickByXpath(USER_AVATAR_CLICK);
        return this;
    }

    private GorodRegistrationScreen saveUserAvatar(){
        log.info("Сохраняем аватар");
        wrapper.clickByXpath(USER_AVATAR_SAVE);
        return this;
    }

    private GorodRegistrationScreen registerUser(){
        log.info("Регистрируем пользователя");
        wrapper.clickByXpath(USER_REGISTRATION_BTN);
        return this;
    }

    public String registrationUser() {

        enterUserEmail().enterUserPassword().enterUserPasswordConfirm().enterUserName().enterUserSurName()
                .selectCheckboxUserConfirm().selectUniformRulesOfModeration().selectUserAvatar().selectUserAvatarStep2()
                .saveUserAvatar().registerUser();
        String popupText = wrapper.getTextByXpath(REGISTRATION_ACCEPT_TEXT_XPATH);
        log.info("Отображается текст в popup " + popupText );

        return popupText;
    }
}



