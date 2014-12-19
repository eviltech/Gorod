package Tests;



import Screens.*;
import Utils.LoadPage;
import Utils.PageScreenShot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evil on 27.09.2014.
 */
public class SmokeTest extends BaseTest {

    final static String REGISTRATION_ACCEPT_TEXT = "Данные пользователя";
    final static String LINK1 = "Просмотр сведений о субъекте";
    final static String LINK2 = "Формирование и печать выходных форм";
    final static String Link3 = "Внесение сведений о субъекте";
    final static String LOGIN_ERROR = "Пользователь или пароль некорректен, повторите ввод.";
    final static String BLOCK_ERROR = "Доступ для пользователя временно запрещен.";
    final static String TYPES_OUTPUT_FORMS_TITLE = "Типы выходных форм";
    final static String SUBJECT_NAME = "Инспекция Министерства по налогам и сборам Республики Беларусь по Россонскому району";
    final static String MAIN_OBJECT_TAB_TEXT = "Сведения о главном объекте";
    final static String PART_OBJECT_TAB_TEXT = "Сведения о составной части (принадлежности)";
    final static String TITLE_FOR_MAIN_OBJECT = "Поиск основного объекта";
    final static String RADIO_BTN_BUILD_FOR_MAIN_OBJECT = "Здание";
    final static String RADIO_CONSTRUCTION_BUILD_FOR_MAIN_OBJECT = "Сооружение";
    final static String RADIO_ISOLATEDROOM_BUILD_FOR_MAIN_OBJECT = "Изолированное помещение";
    final static String BLOCKING_PART = "DATAOFBLOCKINGPART";
    final static String PRINTING_RESULT = "PRINTINGRESULT ";


    @Test(priority = 1)

    public void CheckEnterError() throws IOException, SQLException{
        log.info("----------------------------------ТЕСТ#1-----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        IndexPageErrorScreen findEnterError = indexPageScreen.getEnterError();
        String errorText = findEnterError.getEnterError();
        Assert.assertEquals(LOGIN_ERROR, errorText, "Текст ошибки не совпадает");
    }

    @Test(priority = 2)
    public void CheckBlockError()throws IOException, SQLException{
        log.info("----------------------------------ТЕСТ#2-----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        IndexPageErrorScreen findBlockError = indexPageScreen.getBlockError();
        String blockErrorTextx = findBlockError.getBlockError();
        Assert.assertEquals(BLOCK_ERROR, blockErrorTextx, "Текст ошибки не совпадает");
    }

    @Test(priority = 3)
    public void CheckTitleUserDataScreen() throws IOException, SQLException {
        log.info("----------------------------------ТЕСТ#3-----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        UserDataScreen userDataTitle = indexPageScreen.findTitle();
        String registerAcceptText = userDataTitle.findTitle();
        Assert.assertEquals(REGISTRATION_ACCEPT_TEXT, registerAcceptText, "Текст в Title не совпал с ожидаемым");
    }

    @Test(priority = 4)
    public void CheckLink1UserDataScreen () throws IOException, SQLException{
        log.info("----------------------------------ТЕСТ#4-----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        UserDataScreen userDataLink = indexPageScreen.findLinkViewSubjectDetails();
        String myAcceptText = userDataLink.findLinkViewSubjectDetails();
        Assert.assertEquals(LINK1,myAcceptText,"Текст не совпал с ожидаемым - Просмотр сведений о субъекте");
    }

    @Test(priority = 5)
    public void CheckLink2UserDataScreen() throws IOException, SQLException{
        log.info("----------------------------------ТЕСТ#5-----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        UserDataScreen userDataLink = indexPageScreen.findLinkFormatationAndPrintForms();
        String myAcceptText = userDataLink.findLinkFormatationAndPrintForms();
        Assert.assertEquals(LINK2,myAcceptText, "Текст не совпал с ожидаемым - Формирование и печать выходных форм");
    }

    @Test(priority = 6)
    public void CheckLink3UserDataScreen() throws IOException, SQLException{
        log.info("----------------------------------ТЕСТ#6-----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        UserDataScreen userDataLink = indexPageScreen.findLinkAddSubjectInfo();
        String myAcceptText = userDataLink.findLinkAddSubjectInfo();
        Assert.assertEquals(Link3, myAcceptText, "Текст не совпал с ожидаемым");
    }

    @Test(priority = 7)
    public void CheckTitleTypesOutputForms() throws IOException, SQLException{
        log.info("----------------------------------ТЕСТ#7-----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        TypesOutputFormsScreen findTitleTypesOutputForms = indexPageScreen.findTitleTypesOutputForms();
        String myAcceptText = findTitleTypesOutputForms.findTitleTypesOutputForms();
        Assert.assertEquals(TYPES_OUTPUT_FORMS_TITLE, myAcceptText,"Текст в Title не совпал с ожидаемым");
    }

    @Test(priority = 8)
    public void SearchResultBySubjectName() throws IOException, SQLException{
        log.info("----------------------------------ТЕСТ#8-----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        FindSubjectScreen searchResultBySubjectname = indexPageScreen.findByEgrNumber();
        String myAcceptText = searchResultBySubjectname.findByEgrNumber();
        Assert.assertEquals(SUBJECT_NAME,myAcceptText, "Наименования не совпадают");
    }

    @Test(priority = 9)
    public void CheckInformationAboutMainObject() throws IOException,SQLException{
        log.info("----------------------------------ТЕСТ#9-----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        FormationPrintingOutputFormsRealEstateScreen checkInformationAboutMainObject = indexPageScreen.checkTabInformationAboutMainObject();
        String myAcceptText = checkInformationAboutMainObject.checkTabInformationAboutMainObject();
        Assert.assertEquals(MAIN_OBJECT_TAB_TEXT, myAcceptText, "Название вкладок не совпадает");
    }

    @Test(priority = 10)
    public void CheckInformationAboutPart() throws IOException,SQLException{
        log.info("----------------------------------ТЕСТ#10----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        FormationPrintingOutputFormsRealEstateScreen checkTabInformationAboutPart = indexPageScreen.checkTabInformationAboutPart();
        String myAcceptText = checkTabInformationAboutPart.checkTabInformationAboutPart();
        Assert.assertEquals(PART_OBJECT_TAB_TEXT, myAcceptText,"Название вкладок не совпадает");
    }

    @Test(priority = 11)
    public void CheckTitleForMainObject() throws IOException, SQLException{
        log.info("----------------------------------ТЕСТ#11----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        FormationPrintingOutputFormsRealEstateScreen checkTitleForMainObject =indexPageScreen.checkTitleForMainObject();
        String myAcceptText = checkTitleForMainObject.checkTitleForMainObject();
        Assert.assertEquals(TITLE_FOR_MAIN_OBJECT,myAcceptText,"Название title не совпадает");
    }

    @Test(priority = 12)
    public void CheckRadioBtnBuildForMainObject() throws IOException, SQLException {
        log.info("----------------------------------ТЕСТ#12----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        FormationPrintingOutputFormsRealEstateScreen checkRadioBtnBuildForMainObject = indexPageScreen.checkRadioBtnBuildForMainObject();
        String myAcceptText = checkRadioBtnBuildForMainObject.checkRadioBtnBuildForMainObject();
        Assert.assertEquals(RADIO_BTN_BUILD_FOR_MAIN_OBJECT, myAcceptText,"Название radiobtn не совпадает");
    }

    @Test(priority = 13)
    public void CheckRadioBtnConstructionForMainObject() throws IOException, SQLException {
        log.info("----------------------------------ТЕСТ#13----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        FormationPrintingOutputFormsRealEstateScreen checkRadioBtnConstructionForMainObject = indexPageScreen.checkRadioBtnConstructionForMainObject();
        String myAcceptText = checkRadioBtnConstructionForMainObject.checkRadioBtnConstructionForMainObject();
        Assert.assertEquals(RADIO_CONSTRUCTION_BUILD_FOR_MAIN_OBJECT, myAcceptText,"Название radiobtn не совпадает");
    }

    @Test(priority = 14)
    public void CheckRadioBtnIsolatedRoomForMainObject() throws IOException, SQLException {
        log.info("----------------------------------ТЕСТ#14----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        FormationPrintingOutputFormsRealEstateScreen checkRadioBtnIsolatedRoomForMainObject = indexPageScreen.checkRadioBtnIsolatedRoomForMainObject();
        String myAcceptText = checkRadioBtnIsolatedRoomForMainObject.checkRadioBtnIsolatedRoomForMainObject();
        Assert.assertEquals(RADIO_ISOLATEDROOM_BUILD_FOR_MAIN_OBJECT, myAcceptText,"Название radiobtn не совпадает");

    }

    @Test(priority = 15)
    public void CheckBlockingPart() throws IOException, SQLException {
        log.info("----------------------------------ТЕСТ#15----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        FormationPrintingOutputFormsRealEstateScreen checkBlockingPart = indexPageScreen.checkBlockingPart();
        checkBlockingPart.checkBlockingPart();
        PageScreenShot util = new PageScreenShot(driver);
        util.takeScreenShot(BLOCKING_PART);
    }

    @Test(priority = 16)
    public void CheckDataResult() throws IOException, SQLException {
        log.info("----------------------------------ТЕСТ#16----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        FormationPrintingOutputFormsRealEstateScreen checkDataResult = indexPageScreen.checkDataResult();

        List<String> myResultArr= checkDataResult.checkDataResult();
        String dataResult = "";
        for (int i = 0; i < myResultArr.size(); i++) {
            dataResult = dataResult + myResultArr.get(i) + " ";
        }

        log.info("ВСЕ ДАННЫЕ МАССИВА resultArraddResultArr: " + dataResult);
    }

    @Test(priority = 17)
    public void TableDataResultForm1007Screen() throws IOException, SQLException {
        log.info("----------------------------------ТЕСТ#17----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        TableDataResultForm1007Screen tableResults = indexPageScreen.tableResults();
        List<WebElement> myResultArr = tableResults.tableResults();
        log.info("ВСЕ ДАННЫЕ МАССИВА myResultArr: " + myResultArr);
    }

    @Test(priority = 18)
    public void CheckPrintingResult() throws IOException, SQLException {
        log.info("----------------------------------ТЕСТ#18----------------------------------------------------------");
        IndexPageScreen indexPageScreen = new IndexPageScreen(driver);
        FormationPrintingOutputFormsRealEstateScreen checkPrintingResult = indexPageScreen.checkPrintingResult();
        checkPrintingResult.checkPrintingResult();
        PageScreenShot util = new PageScreenShot(driver);
        LoadPage loadPage = new LoadPage();
        loadPage.waitForPageLoaded(driver);
        util.takeScreenShot(PRINTING_RESULT);
    }


    @AfterClass
    public static void closeDriver() {
        driver.close();
    }

    @AfterTest
    public static void CC(){
        driver.quit();
    }

}



