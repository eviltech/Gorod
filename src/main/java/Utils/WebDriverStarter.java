package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Evil on 27.09.2014.
 */
public class WebDriverStarter {
    private static ChromeDriverService service;
    private static WebDriver driver;
    final static String PATH_TO_CHROMEDRIVER = "src//main//resources//chromedriver.exe";

    public WebDriverStarter() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingChromeDriverExecutable(new File(PATH_TO_CHROMEDRIVER))
                .usingAnyFreePort()
                .build();
        service.start();
        driver = new ChromeDriver(service);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() throws IOException {
        if(driver == null) {
            new WebDriverStarter();
        }
        return driver;
    }

}
