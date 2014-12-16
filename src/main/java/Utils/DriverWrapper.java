package Utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

/**
 * Created by eviltechnology on 25.10.2014.
 */
public class DriverWrapper {
    public static final Logger log = Logger.getLogger(DriverWrapper.class);
    private  WebDriver driver;


    public DriverWrapper(WebDriver driver) {
        this.driver = driver;
    }

    //******************************************************************************************************************
    public void findByXpath(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        log.info(String.format("Элемент по xpath = %s найден", xpath));
    }
    public List<WebElement> findElementsByXpath(String xpath){
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        log.info(String.format("Элемент по xpath = %s найден", xpath));
        return elements;
    }

    //******************************************************************************************************************
    public void findByTagName(String xpath){
        WebElement element = driver.findElement(By.tagName(xpath));
        log.info(String.format("Элемент по xpath = %s найден", xpath));
    }

    //******************************************************************************************************************
    public List<WebElement> findByTagsNames(String xpath){
        List<WebElement> elements = driver.findElements(By.tagName(xpath));
        log.info(String.format("Элемент по xpath = %s найден", xpath));
        return elements;
    }

    //******************************************************************************************************************
    public void clickByXpath(String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        log.info(String.format("Элемент по xpath = %s найден", xpath));
        element.click();
        log.info(String.format("Клик по xpath = %s ", xpath));
    }



    //******************************************************************************************************************
    public void  clickByXpath(String xpath, int timeout){
        WebElement element = driver.findElement(By.xpath(xpath));//добавить ожидание
        log.info(String.format("Элемент по xpath = %s найден", xpath));
        element.click();
    }

    //******************************************************************************************************************
    public void sendKeysByXpath(String xpath, String text ) {
        WebElement element = driver.findElement(By.xpath(xpath));
        log.info(String.format("Элемент по xpath = %s найден", xpath));
        element.sendKeys(text);
        log.info(String.format("Вводи текст = %s c  xpath = %s1 ",text, xpath));
    }

    //******************************************************************************************************************
    public boolean isSelectedByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        log.info(String.format("Элемент по xpath = %s найден", xpath));
        boolean result = element.isSelected();
        log.info(String.format("Элемент c  xpath = %s является выбранным:%s1 ", xpath, result));
        return result;
    }

    //******************************************************************************************************************
    public String getTextByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        log.info(String.format("Элемент по xpath = %s найден", xpath));
        String result = element.getText();
        log.info(String.format("Элемент c  xpath = %s содержит текст: %s1", xpath, result));
        return result;
    }

    //******************************************************************************************************************
    public String getPageTitle(){
        String pageTitle = driver.getTitle();
        return pageTitle;

    }

    //******************************************************************************************************************
    public String getPagelink(String text){
        WebElement element = driver.findElement(By.linkText(text));
        log.info(String.format("Элемент по тексту = %s найден", text));
        String result = element.getText();
        log.info(String.format("Элемени содержит текст = %s", text));
        return result;
    }

}
