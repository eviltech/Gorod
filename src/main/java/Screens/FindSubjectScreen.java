package Screens;

import Tests.SmokeTest;
import Utils.DriverWrapper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by makovskiy on 25.11.2014.
 */
public class FindSubjectScreen {
    DriverWrapper wrapper;

    public static final Logger log = Logger.getLogger(SmokeTest.class);

    final static String EGR_NUMBER_XPATH = "//input[@name='egr']";
    final static String FIND_BUTTON_XPATH = "//input[@name='_target5']";
    final static String SUBJECT_NAME_XPATH = "//td[text()='Инспекция Министерства по налогам и сборам Республики Беларусь по Россонскому району']";// добавить поиск по локатору


    FindSubjectScreen(WebDriver driver) {
        wrapper = new DriverWrapper(driver);
    }

    public String findByEgrNumber(){
        log.info("Ищем и заполняем поле Номер ЕГР");
        wrapper.sendKeysByXpath(EGR_NUMBER_XPATH, "300003713");
        log.info("Нажимаем поиск");
        wrapper.clickByXpath(FIND_BUTTON_XPATH);
        log.info("Ищем по наименованию");// добавить локаторы на поля таблицы
        String subjectName = wrapper.getTextByXpath(SUBJECT_NAME_XPATH);
        return subjectName;
    }

}
