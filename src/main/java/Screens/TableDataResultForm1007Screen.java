package Screens;

import Tests.SmokeTest;
import Utils.DriverWrapper;
import Utils.MyFileWriter;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by makovskiy on 12.12.2014.
 */
public class TableDataResultForm1007Screen {
    DriverWrapper wrapper;
    public static final Logger log = Logger.getLogger(SmokeTest.class);
    MyFileWriter mfw = new MyFileWriter();

    final static String CLICK_RADIO_BTN_BUILD_FOR_MAIN_OBJECT_XPATH = "//input[@value='2']";
    final static String SEARCH_BTN_XPATH = "//input[@value='Поиск']";
    final static String TABLE_RESULTS_XPATH = "//table[@id='subjectsList']";


    TableDataResultForm1007Screen(WebDriver driver) {
        wrapper = new DriverWrapper(driver);
    }

    public List<WebElement> tableResults(){

        wrapper.clickByXpath(CLICK_RADIO_BTN_BUILD_FOR_MAIN_OBJECT_XPATH);
        wrapper.clickByXpath(SEARCH_BTN_XPATH);
        wrapper.findByXpath(TABLE_RESULTS_XPATH);




        /*List<WebElement> TotalRowCount=wrapper.findByTagsNames("tr");
        log.info("No. of Rows in the WebTable: " + TotalRowCount.size());
            // Now we will Iterate the Table and print the Values
            int RowIndex=1;
            for(WebElement rowElement:TotalRowCount)
            {
                List<WebElement> TotalColumnCount=rowElement.findElements(By.xpath("td"));
                int ColumnIndex=1;
                for(WebElement colElement:TotalColumnCount)
                {
                    log.info("Row " + RowIndex + " Column " + ColumnIndex + " Data " + colElement.getText());
                    ColumnIndex=ColumnIndex+1;
                }
                RowIndex=RowIndex+1;
            }*/




        List<WebElement> rows=wrapper.findByTagsNames("tr");

        for(int rnum=3;rnum<rows.size();rnum++)
        {
            List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
            log.info("Number of columns:"+columns.size());


            for(int cnum=0;cnum<columns.size();cnum++)
            {
                log.info(columns.get(cnum).getText());
                mfw.myFileWriter(columns.get(cnum).getText());
                System.out.println(mfw);
            }
        }

        return rows;
    }


}
