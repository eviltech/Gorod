package Utils;

import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DriverCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Evil on 30.09.2014.
 */
public class PageScreenShot {
    WebDriver driver;


    public PageScreenShot(WebDriver driver) {
        this.driver = driver;
    }


    public void takeScreenShot(String screenShotName) throws IOException {
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File("screen\\" + screenShotName + getTimeStampValue() + ".png"));
    }

    public String getTimeStampValue() throws IOException {

        Calendar cal = Calendar.getInstance();
        Date time = cal.getTime();
        String timestamp = time.toString();
        System.out.println(timestamp);
        String systime = timestamp.replace(":", "-");
        System.out.println(systime);
        return systime;

    }
        //Сохранение  хтмл
//    public  void saveSourceToFile(String caseName) throws IOException {
//        try {
//            PrintWriter output = new PrintWriter(caseName+getTimeStampValue() + ".html");
//
//            String source = (String) driver.execute(DriverCommand.GET_PAGE_SOURCE, ImmutableMap.<String, Object>of()).getValue();
//            if (source.length() >= "OK,".length()) {
//                source = source.substring("OK,".length());
//            }
//            output.println(source);
//            output.close();
//        } catch (FileNotFoundException e1) {
//            e1.printStackTrace();
//        }
//    }
}



