import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Evil on 01.10.2014.
 */
public class LoadPage {
    WebDriver driver1;

    public void waitForPageLoaded(WebDriver driver) {
        this.driver1 = driver;
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };

        Wait<WebDriver> wait = new WebDriverWait(driver,30);
        try {
            wait.until(expectation);
        } catch(Throwable error) {
            System.out.print(String.format("Timeout waiting for Page Load Request to complete."));
        }
    }
}
