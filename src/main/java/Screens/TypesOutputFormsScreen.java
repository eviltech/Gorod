package Screens;

import Tests.SmokeTest;
import Utils.DriverWrapper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by makovskiy on 21.11.2014.
 */
public class TypesOutputFormsScreen {
    DriverWrapper wrapper;
    public static final Logger log = Logger.getLogger(SmokeTest.class);

    //final

    TypesOutputFormsScreen(WebDriver driver) {
        wrapper = new DriverWrapper(driver);

    }

    public String findTitleTypesOutputForms(){
        log.info("Получаем Title страницы");
        String title = wrapper.getPageTitle();
        log.info("Отображается текст в title " + title );
        return title;
    }
}
