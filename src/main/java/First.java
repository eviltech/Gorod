import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Evil on 27.09.2014.
 */
public class First {
    private static WebDriver driver;

    @BeforeClass
    public static void createAndStartService() throws IOException {
        driver = WebDriverStarter.createAndStartService();


    }
    @Test
    public void GorodRegistration() throws IOException {
        GorodRegistration gorodRegistration = new GorodRegistration(driver);


    }

    @AfterClass
    public static void closeDriver() {
        driver.close();
    }



}
