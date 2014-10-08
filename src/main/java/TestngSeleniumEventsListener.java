import Tests.PageScreenShot;
import org.testng.*;

import java.io.IOException;

/**
 * Created by Evil on 05.10.2014.
 */
public class TestngSeleniumEventsListener implements ITestListener, IInvokedMethodListener
 {

     @Override
     public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

     }

     @Override
     public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

     }

     @Override
     public void onTestStart(ITestResult iTestResult) {

     }

     @Override
     public void onTestSuccess(ITestResult iTestResult) {

     }

     @Override
     public void onTestFailure(ITestResult iTestResult) {
         PageScreenShot failePageScreenShot = new PageScreenShot(WebDriverStarter.getDriver());
         try {
             failePageScreenShot.takeScreenShot(failePageScreenShot.getTimeStampValue());
         } catch (IOException e) {
             e.printStackTrace();
         }

     }

     @Override
     public void onTestSkipped(ITestResult iTestResult) {

     }

     @Override
     public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

     }

     @Override
     public void onStart(ITestContext iTestContext) {

     }

     @Override
     public void onFinish(ITestContext iTestContext) {

     }
 }
