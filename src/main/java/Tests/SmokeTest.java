package Tests;


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

    final static String REGISTRATION_ACCEPT_TEXT = "Данные пользователя1";
    final static String REG = "Просмотр сведений о субъекте";


    @Test
    public void GorodRegistration() throws IOException, SQLException {
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        UserDataScreen userDataTitle = indexPageScreen.findTitle();
        String registerAcceptText = userDataTitle.findTitle();
        Assert.assertEquals(REGISTRATION_ACCEPT_TEXT, registerAcceptText, "Текст в попап не совпал с ожидаемым");
    }

    @Test
    public void GorodTest () throws IOException, SQLException{
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        UserDataScreen userDataLink = indexPageScreen.findLinkViewSubjectDetails();
        String myAcceptText = userDataLink.findLinkViewSubjectDetails();
        Assert.assertEquals(REG,myAcceptText,"Просмотр сведений о субъекте");
    }




    @AfterClass
    public static void closeDriver() {
        driver.close();
    }





}
