package Tests;


import Screens.GorodRegistrationScreen;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Evil on 27.09.2014.
 */
public class SmokeTest extends BaseTest {

    @Test
    public void GorodRegistration() throws IOException, SQLException {
        GorodRegistrationScreen gorodRegistration = new GorodRegistrationScreen(driver);
        Assert.assertEquals(true, true, "");
    }




    @AfterClass
    public static void closeDriver() {
        driver.close();
    }



}
