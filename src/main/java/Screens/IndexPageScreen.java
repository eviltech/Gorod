package Screens;

import Tests.SmokeTest;
import Utils.LoadPage;
import Utils.MyRandom;
import java.util.Random;
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

    public IndexPageErrorScreen getEnterError(){
        Random rand = new Random();
        log.info("Осуществляем вход");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_LOGIN_XPATH)).sendKeys(MyRandom.generateString(rand, "findname", 8));
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_PASSWORD_XPATH)).sendKeys("test");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_USER_XPATH)).click();
        log.info("Появление ошибки");
        return new IndexPageErrorScreen(driver);
    }

    public IndexPageErrorScreen getBlockError(){
        Random rand = new Random();
        for (int i=0; i<5; i++)
        {
            log.info("Осуществляем вход");
            driver.findElement(By.xpath(MAIN_PAGE_ENTER_LOGIN_XPATH)).sendKeys("namename");
            driver.findElement(By.xpath(MAIN_PAGE_ENTER_PASSWORD_XPATH)).sendKeys("test");
            driver.findElement(By.xpath(MAIN_PAGE_ENTER_USER_XPATH)).click();
            log.info("Появление ошибки");
        }
        return new IndexPageErrorScreen(driver);
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

    public UserDataScreen findLinkFormatationAndPrintForms(){
        log.info("Осуществляем вход");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_LOGIN_XPATH)).sendKeys("RIKTest");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_PASSWORD_XPATH)).sendKeys("test");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_USER_XPATH)).click();
        log.info("Вход осуществлен");
        return new UserDataScreen(driver);
    }

    public UserDataScreen findLinkAddSubjectInfo(){
        log.info("Осуществляем вход");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_LOGIN_XPATH)).sendKeys("RIKTest");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_PASSWORD_XPATH)).sendKeys("test");
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_USER_XPATH)).click();
        log.info("Вход осуществлен");
        return new UserDataScreen(driver);
    }

}
