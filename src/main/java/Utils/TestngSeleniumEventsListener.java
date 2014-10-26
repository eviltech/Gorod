package Utils;

import Tests.SmokeTest;
import Utils.PageScreenShot;
import org.apache.log4j.Logger;
import org.testng.*;

import java.io.IOException;

/**
 * Created by Evil on 05.10.2014.
 */
public class TestngSeleniumEventsListener implements ITestListener, IInvokedMethodListener
 {
     public static final Logger log = Logger.getLogger(TestngSeleniumEventsListener.class);

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
         log.error( iTestResult.getThrowable().getMessage());
         PageScreenShot failePageScreenShot = null;
         try {
             failePageScreenShot = new PageScreenShot(WebDriverStarter.getDriver());
         } catch (IOException e) {
             e.printStackTrace();
         }
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
         log.error("");
     }

     @Override
     public void onFinish(ITestContext iTestContext) {

     }
 }
