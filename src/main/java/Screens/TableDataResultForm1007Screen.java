package Screens;

import Tests.SmokeTest;
import Utils.DriverWrapper;

import Utils.WriterW;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;


/**
 * Created by makovskiy on 12.12.2014.
 */
public class TableDataResultForm1007Screen {

    DriverWrapper wrapper;
    public static final Logger log = Logger.getLogger(SmokeTest.class);
    WriterW mfw = new WriterW();

    final static String CLICK_RADIO_BTN_BUILD_FOR_MAIN_OBJECT_XPATH = "//input[@value='2']";
    final static String SEARCH_BTN_XPATH = "//input[@value='Поиск']";
    final static String TABLE_RESULTS_XPATH = "//table[@id='subjectsList']";
    final static String TABLE_RESULTS_ONMOUSEDOWN_XPATH ="//tr[@onmousedown='selectRecord(this.id);']";


    TableDataResultForm1007Screen(WebDriver driver) {
        wrapper = new DriverWrapper(driver);
    }

    public List<WebElement> tableResults() throws IOException {

        wrapper.clickByXpath(CLICK_RADIO_BTN_BUILD_FOR_MAIN_OBJECT_XPATH);
        wrapper.clickByXpath(SEARCH_BTN_XPATH);
        wrapper.findByXpath(TABLE_RESULTS_XPATH);

        List<WebElement> rows=wrapper.findByTagsNames("tr");
        //List<WebElement> rows=wrapper.findElementsByXpath(TABLE_RESULTS_ONMOUSEDOWN_XPATH);
        for(int rnum=4;rnum<rows.size();rnum++)
        {
            List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
            log.info("Number of columns:"+columns.size());


            for(int cnum=0;cnum<columns.size();cnum++)
            {
                log.info(columns.get(cnum).getText());
                mfw.myFileWriter(columns.get(cnum).getText());

            }
        }

        mfw.close();

        return rows;
    }


}
