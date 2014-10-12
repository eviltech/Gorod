package Screens;

import Tests.SmokeTest;
import Utils.LoadPage;
import Utils.PageScreenShot;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import java.io.IOException;

/**
 * Created by Evil on 27.09.2014.
 */

public class GorodRegistrationScreen {

    private WebDriver driver;
    protected static final Logger log = Logger.getLogger(SmokeTest.class);

    final static String MAIN_PAGE_REGESTRATION = "//span[@id ='registrationUser']";
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

    public GorodRegistrationScreen(WebDriver driver) throws IOException {
        this.driver = driver;
        PageScreenShot util = new PageScreenShot(driver);
        LoadPage loadPage = new LoadPage();
        driver.get("http://gorod.mos.ru/");
        loadPage.waitForPageLoaded(driver);
        System.out.print(String.format("Main Page Registration= %s", MAIN_PAGE_REGESTRATION));
        util.takeScreenShot("IndexPage");
    }

    private GorodRegistrationScreen enterUserEmail() {
        log.info("Вводим почтовый адрес для нового пользователя");
        driver.findElement(By.xpath(USER_EMAIL)).click();
        driver.findElement(By.xpath(USER_EMAIL)).sendKeys("eviltech86@gmail.com");
        return this;
    }

    private GorodRegistrationScreen enterUserPassword() {
        log.info("Вводим пароль для нового пользователя");
        driver.findElement(By.xpath(USER_PASS)).click();
        driver.findElement(By.xpath(USER_PASS)).sendKeys("11111111");
        return this;
    }

    public boolean registrationUser() {
        driver.findElement(By.xpath(MAIN_PAGE_REGESTRATION)).click();

        enterUserEmail().enterUserPassword();


        //TODO Разнести большой метод на маленькие
        driver.findElement(By.xpath(USER_PASS_CONFIRM)).click();
        driver.findElement(By.xpath(USER_PASS_CONFIRM)).sendKeys("11111111");

        driver.findElement(By.xpath(USER_NAME)).click();
        driver.findElement(By.xpath(USER_NAME)).sendKeys("Test");

        driver.findElement(By.xpath(USER_SURNAME)).click();
        driver.findElement(By.xpath(USER_SURNAME)).sendKeys("Prognoz");

        if ( !driver.findElement(By.xpath(CHECK_BOX_CONF1)).isSelected() )
        {
            driver.findElement(By.xpath(CHECK_BOX_CONF1)).click();
        }

        if ( !driver.findElement(By.xpath(CHECK_BOX_CONF2)).isSelected() )
        {
            driver.findElement(By.xpath(CHECK_BOX_CONF2)).click();
        }

        return true;
    }

        //TODO Создать новые классы скринов (3 скрина) и закинуть туда функционал из этого класса
       /* if ( !driver.findElement(By.xpath(CHECK_BOX_CONF3)).isSelected() )
        {
            driver.findElement(By.xpath(CHECK_BOX_CONF3)).click();
        }*/
        driver.findElement(By.xpath(USER_AVATAR)).click();
        driver.findElement(By.xpath(USER_AVATAR_CLICK)).click();
        driver.findElement(By.xpath(USER_AVATAR_SAVE)).click();

        driver.findElement(By.xpath(USER_REGISTRATION_BTN)).click();




        //Assert.assertFalse(true);
    }


}
