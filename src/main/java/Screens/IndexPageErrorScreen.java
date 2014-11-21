package Screens;

import Tests.SmokeTest;
import Utils.DriverWrapper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by makovskiy on 21.11.2014.
 */
public class IndexPageErrorScreen {
    DriverWrapper wrapper;
    public static final Logger log = Logger.getLogger(SmokeTest.class);

    final static String MAIN_PAGE_ENTER_ERROR_XPATH = "//div [text() = 'Пользователь или пароль некорректен, повторите ввод.']"; //ДОБАВИТЬ НОРМАЛЬНЫЕ ЛОКАТОРЫ
    final static String MAIN_PAGE_BLOK_ERROR_XPATH = "//div [text() = 'Доступ для пользователя временно запрещен.']"; //ДОБАВИТЬ НОРМАЛЬНЫЕ ЛОКАТОРЫ

    IndexPageErrorScreen(WebDriver driver) {
        wrapper = new DriverWrapper(driver);
    }

    public String getEnterError(){
        log.info("Получаем ошибку");
        String error = wrapper.getTextByXpath(MAIN_PAGE_ENTER_ERROR_XPATH);
        log.info("Текст ошибки");
        return error;
    }

    public String getBlockError(){
        log.info("Получаем ошибку");
        String blockError = wrapper.getTextByXpath(MAIN_PAGE_BLOK_ERROR_XPATH);
        log.info("Текст ошибки");
        return blockError;
    }
}
