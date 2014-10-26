package Screens;

import Tests.SmokeTest;
import Utils.LoadPage;
import Utils.PageScreenShot;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by eviltechnology on 19.10.2014.
 */
public class IndexPageScreen {
    final static String MAIN_PAGE_REGESTRATION = "//span[@id ='registrationUser']";
    public WebDriver driver;
    public static final Logger log = Logger.getLogger(SmokeTest.class);

    public IndexPageScreen(WebDriver driver) throws IOException {
        this.driver = driver;
        PageScreenShot util = new PageScreenShot(driver);
        LoadPage loadPage = new LoadPage();
        driver.get("http://gorod.mos.ru/");
        loadPage.waitForPageLoaded(driver);
        System.out.print(String.format("Main Page Registration= %s", MAIN_PAGE_REGESTRATION));
        util.takeScreenShot("IndexPage");
    }
    public GorodRegistrationScreen registrationUser() {
        driver.findElement(By.xpath(MAIN_PAGE_REGESTRATION)).click();
        return new GorodRegistrationScreen(driver);
    }
}
