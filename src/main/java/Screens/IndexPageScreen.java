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

    final static String MAIN_PAGE_ENTER_LOGIN_XPATH = "//input[@name ='j_username']";
    final static String MAIN_PAGE_ENTER_PASSWORD_XPATH = "//input[@name ='j_password']";
    final static String MAIN_PAGE_ENTER_USER_XPATH = "//input[@id ='ok']";

    public WebDriver driver;
    public static final Logger log = Logger.getLogger(SmokeTest.class);

    public IndexPageScreen(WebDriver driver) throws IOException {
        this.driver = driver;
        PageScreenShot util = new PageScreenShot(driver);
        LoadPage loadPage = new LoadPage();
        driver.get("http://ncaergi:8080/");
        loadPage.waitForPageLoaded(driver);
        System.out.print(String.format("Main Page Registration= %s", MAIN_PAGE_ENTER_USER_XPATH));
        util.takeScreenShot("IndexPage");
    }


    public UserDataScreen findTitle() {
        log.info("Осуществляем вход");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_LOGIN_XPATH)).sendKeys("RIKTest");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_PASSWORD_XPATH)).sendKeys("test");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_USER_XPATH)).click();
        log.info("Вход осуществлен");
        return new UserDataScreen(driver);
    }

    public UserDataScreen findLinkViewSubjectDetails(){
        log.info("Осуществляем вход");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_LOGIN_XPATH)).sendKeys("RIKTest");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_PASSWORD_XPATH)).sendKeys("test");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_USER_XPATH)).click();
        log.info("Вход осуществлен");
        return new UserDataScreen(driver);
    }

}
