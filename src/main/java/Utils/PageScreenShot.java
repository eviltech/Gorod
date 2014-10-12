package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Evil on 30.09.2014.
 */
public class PageScreenShot {
    WebDriver driver;


    public PageScreenShot(WebDriver driver){
        this.driver = driver;
    }


    public void takeScreenShot(String screenShotName) throws IOException{
        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile,new File("e:\\Gorod\\screen\\"+ screenShotName + getTimeStampValue() + ".png"));
    }
    public  String getTimeStampValue()throws IOException {

        Calendar cal = Calendar.getInstance();
        Date time=cal.getTime();
        String timestamp=time.toString();
        System.out.println(timestamp);
        String systime=timestamp.replace(":", "-");
        System.out.println(systime);
        return systime;

    }




}



