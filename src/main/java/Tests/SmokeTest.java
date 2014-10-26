package Tests;


import Screens.GorodRegistrationScreen;
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
    final static String REGISTRATION_ACCEPT_TEXT = "Пользователь с такой почтой уже зарегистрирован1";
    @Test
    public void GorodRegistration() throws IOException, SQLException {
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        GorodRegistrationScreen gorodRegistration = indexPageScreen.registrationUser();
        String registerAcceptText = gorodRegistration.registrationUser();
        Assert.assertEquals(REGISTRATION_ACCEPT_TEXT, registerAcceptText, "Текст в попап не совпал с ожидаемым");


    }




    @AfterClass
    public static void closeDriver() {
        driver.close();
    }



}
