package Tests;



import Screens.IndexPageErrorScreen;
import Screens.UserDataScreen;
import Screens.IndexPageScreen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Evil on 27.09.2014.
 */
public class SmokeTest extends BaseTest {

    final static String REGISTRATION_ACCEPT_TEXT = "Данные пользователя";
    final static String LINK1 = "Просмотр сведений о субъекте";
    final static String LINK2 = "Формирование и печать выходных форм";
    final static String Link3 = "Внесение сведений о субъекте";
    final static String LOGIN_ERROR = "Пользователь или пароль некорректен, повторите ввод.";
    final static String BLOCK_ERROR = "Доступ для пользователя временно запрещен.";


    @Test(priority = 0)
    public void CheckEnterError() throws IOException, SQLException{
     IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        IndexPageErrorScreen findEnterError = indexPageScreen.getEnterError();
        String errorText = findEnterError.getEnterError();
        Assert.assertEquals(LOGIN_ERROR, errorText, "Текст ошибки не совпадает");
    }

    @Test(priority = 1)
    public void CheckBlockError()throws IOException, SQLException{
        log.info("--------------------------------------------------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        IndexPageErrorScreen findBlockError = indexPageScreen.getBlockError();
        String blockErrorTextx = findBlockError.getBlockError();
        Assert.assertEquals(BLOCK_ERROR, blockErrorTextx, "Текст ошибки не совпадает");
    }

    @Test(priority = 2)
    public void CheckTitleUserDataScreen() throws IOException, SQLException {
        log.info("--------------------------------------------------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        UserDataScreen userDataTitle = indexPageScreen.findTitle();
        String registerAcceptText = userDataTitle.findTitle();
        Assert.assertEquals(REGISTRATION_ACCEPT_TEXT, registerAcceptText, "Текст в Title не совпал с ожидаемым");
    }

    @Test(priority = 3)
    public void CheckLink1UserDataScreen () throws IOException, SQLException{
        log.info("--------------------------------------------------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        UserDataScreen userDataLink = indexPageScreen.findLinkViewSubjectDetails();
        String myAcceptText = userDataLink.findLinkViewSubjectDetails();
        Assert.assertEquals(LINK1,myAcceptText,"Текст не совпал с ожидаемым - Просмотр сведений о субъекте");
    }

    @Test(priority = 4)
    public void CheckLink2UserDataScreen() throws IOException, SQLException{
        log.info("--------------------------------------------------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        UserDataScreen userDataLink = indexPageScreen.findLinkFormatationAndPrintForms();
        String myAcceptText = userDataLink.findLinkFormatationAndPrintForms();
        Assert.assertEquals(LINK2,myAcceptText, "Текст не совпал с ожидаемым - Формирование и печать выходных форм");
    }

    @Test(priority = 5)
    public void CheckLink3UserDataScreen() throws IOException, SQLException{
        log.info("--------------------------------------------------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        UserDataScreen userDataLink = indexPageScreen.findLinkAddSubjectInfo();
        String myAcceptText = userDataLink.findLinkAddSubjectInfo();
        Assert.assertEquals(Link3, myAcceptText, "Текст не совпал с ожидаемым");
    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }
}
