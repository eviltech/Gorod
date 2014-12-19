package Screens;

import Tests.SmokeTest;
import Utils.LoadPage;
import Utils.MyRandom;
import java.util.Random;
import Utils.PageScreenShot;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.Set;

/**
 * Created by eviltechnology on 19.10.2014.
 */
public class IndexPageScreen {
    // Interface
    final static String MAIN_PAGE_ENTER_LOGIN_XPATH = "//input[@name ='j_username']";
    final static String MAIN_PAGE_ENTER_PASSWORD_XPATH = "//input[@name ='j_password']";
    final static String MAIN_PAGE_ENTER_USER_XPATH = "//input[@id ='ok']";
    final static String TYPES_OUTPUT_FORMS_TITLE_XPATH = "//a[text()='Формирование и печать выходных\n" +
            "                                                        форм']";//добавить id или class
    final static String VIEW_SUBJECT_DETAILS_XPATH = "//a[@id = 'el1']";
    final static String FORMATION_PRINT_OUTPUT_FORM_LINK_XPATH = "//a[@id = 'el4']";
    final static String FORMATION_PRINT_OUTPUT_FORM_REAL_ESTATE_BTN_XPATH = "//input[@value='Формирование и печать выходных форм по объектам недвижимости ']";
    final static String FORM_10_07_XPATH = "//input[@value='Форма 10-07. Сведения об объектах недвижимости и их составных частях (принадлежностях)']";
    final static String SEARCH_BTN_DATA_OF_MAIN_OBJECT = "//input[@id='mainBuildingSearchButton']";

    // Const
    public static final String ВХОД_ОСУЩЕСТВЛЕН = "Вход осуществлен";
    public static final String HTTP_NCAERGI_8080 = "http://ncaergi:8080/";
    public static final String MAIN_PAGE_REGISTRATION_S = "Main Page Registration= %s";
    public static final String INDEX_PAGE = "IndexPage";
    public static final String ОСУЩЕСТВЛЯЕМ_ВХОД = "Осуществляем вход";
    public static final String TEST = "test";
    public static final String RIK_TEST = "RIKTest";
    public static final String ПОЯВЛЕНИЕ_ОШИБКИ = "Появление ошибки";
    public static final String NAMENAME = "namename";
    public static final String FINDNAME = "findname";

    public WebDriver driver;
    public static final Logger log = Logger.getLogger(SmokeTest.class);

    // Implementation
    //******************************************************************************************************************
    public IndexPageScreen(WebDriver driver) throws IOException {
        this.driver = driver;

        LoadPage loadPage = new LoadPage();
        driver.get(HTTP_NCAERGI_8080);
        loadPage.waitForPageLoaded(driver);
        System.out.print(String.format(MAIN_PAGE_REGISTRATION_S, MAIN_PAGE_ENTER_USER_XPATH));

    }

    //******************************************************************************************************************
    public IndexPageErrorScreen getEnterError(){
        Random rand = new Random();
        SignIn(MyRandom.generateString(rand, FINDNAME, 8), TEST);
        log.info(ПОЯВЛЕНИЕ_ОШИБКИ);
        return new IndexPageErrorScreen(driver);
    }

    //******************************************************************************************************************
    public IndexPageErrorScreen getBlockError(){
        Random rand = new Random();
        for (int i=0; i<5; i++)
        {
            SignIn(NAMENAME, TEST);
            log.info(ПОЯВЛЕНИЕ_ОШИБКИ);
        }
        return new IndexPageErrorScreen(driver);
    }

    //******************************************************************************************************************
    public UserDataScreen findTitle() {
        SimpleEnterLogging();
        return new UserDataScreen(driver);
    }

    //******************************************************************************************************************
    public UserDataScreen findLinkViewSubjectDetails(){
        SimpleEnterLogging();
        return new UserDataScreen(driver);
    }

    //******************************************************************************************************************
    public UserDataScreen findLinkFormatationAndPrintForms(){
        SimpleEnterLogging();
        return new UserDataScreen(driver);
    }

    //******************************************************************************************************************
    public UserDataScreen findLinkAddSubjectInfo(){
        SimpleEnterLogging();
        return new UserDataScreen(driver);
    }

    //******************************************************************************************************************
    public TypesOutputFormsScreen findTitleTypesOutputForms(){
        SignIn();
        driver.findElement(By.xpath(TYPES_OUTPUT_FORMS_TITLE_XPATH)).click();
        log.info(ВХОД_ОСУЩЕСТВЛЕН);
        return new TypesOutputFormsScreen(driver);
    }

    //******************************************************************************************************************
    public FindSubjectScreen findByEgrNumber(){
        SignIn();
        driver.findElement(By.xpath(VIEW_SUBJECT_DETAILS_XPATH)).click();
        return new FindSubjectScreen(driver);
    }

    //******************************************************************************************************************
    public FormationPrintingOutputFormsRealEstateScreen checkTabInformationAboutMainObject(){
        SignIn();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_LINK_XPATH)).click();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_REAL_ESTATE_BTN_XPATH)).click();
        driver.findElement(By.xpath(FORM_10_07_XPATH)).click();
        GetTabFocus();
        return new FormationPrintingOutputFormsRealEstateScreen(driver);
    }

    //******************************************************************************************************************
    public FormationPrintingOutputFormsRealEstateScreen checkTabInformationAboutPart(){
        SignIn();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_LINK_XPATH)).click();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_REAL_ESTATE_BTN_XPATH)).click();
        driver.findElement(By.xpath(FORM_10_07_XPATH)).click();
        GetTabFocus();
        return new FormationPrintingOutputFormsRealEstateScreen(driver);
    }


    //******************************************************************************************************************
    public FormationPrintingOutputFormsRealEstateScreen checkTitleForMainObject(){
        SignIn();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_LINK_XPATH)).click();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_REAL_ESTATE_BTN_XPATH)).click();
        driver.findElement(By.xpath(FORM_10_07_XPATH)).click();
        GetTabFocus();
        driver.findElement(By.xpath(SEARCH_BTN_DATA_OF_MAIN_OBJECT)).click();
        return new FormationPrintingOutputFormsRealEstateScreen(driver);
    }

    //******************************************************************************************************************
    public FormationPrintingOutputFormsRealEstateScreen checkRadioBtnBuildForMainObject(){
        SignIn();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_LINK_XPATH)).click();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_REAL_ESTATE_BTN_XPATH)).click();
        driver.findElement(By.xpath(FORM_10_07_XPATH)).click();
        GetTabFocus();
        driver.findElement(By.xpath(SEARCH_BTN_DATA_OF_MAIN_OBJECT)).click();
        return new FormationPrintingOutputFormsRealEstateScreen(driver);
    }

    //******************************************************************************************************************
    public FormationPrintingOutputFormsRealEstateScreen checkRadioBtnConstructionForMainObject(){
        SignIn();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_LINK_XPATH)).click();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_REAL_ESTATE_BTN_XPATH)).click();
        driver.findElement(By.xpath(FORM_10_07_XPATH)).click();
        GetTabFocus();
        driver.findElement(By.xpath(SEARCH_BTN_DATA_OF_MAIN_OBJECT)).click();
        return new FormationPrintingOutputFormsRealEstateScreen(driver);
    }

    //******************************************************************************************************************
    public FormationPrintingOutputFormsRealEstateScreen checkRadioBtnIsolatedRoomForMainObject(){
        SignIn();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_LINK_XPATH)).click();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_REAL_ESTATE_BTN_XPATH)).click();
        driver.findElement(By.xpath(FORM_10_07_XPATH)).click();
        GetTabFocus();
        driver.findElement(By.xpath(SEARCH_BTN_DATA_OF_MAIN_OBJECT)).click();
        return new FormationPrintingOutputFormsRealEstateScreen(driver);
    }

    //******************************************************************************************************************
    public FormationPrintingOutputFormsRealEstateScreen checkBlockingPart(){
        SignIn();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_LINK_XPATH)).click();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_REAL_ESTATE_BTN_XPATH)).click();
        driver.findElement(By.xpath(FORM_10_07_XPATH)).click();
        GetTabFocus();
        driver.findElement(By.xpath(SEARCH_BTN_DATA_OF_MAIN_OBJECT)).click();
        return new FormationPrintingOutputFormsRealEstateScreen(driver);
    }

    public FormationPrintingOutputFormsRealEstateScreen checkDataResult(){
        SignIn();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_LINK_XPATH)).click();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_REAL_ESTATE_BTN_XPATH)).click();
        driver.findElement(By.xpath(FORM_10_07_XPATH)).click();
        GetTabFocus();
        driver.findElement(By.xpath(SEARCH_BTN_DATA_OF_MAIN_OBJECT)).click();
        return new FormationPrintingOutputFormsRealEstateScreen(driver);
    }

    public FormationPrintingOutputFormsRealEstateScreen checkPrintingResult(){
        SignIn();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_LINK_XPATH)).click();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_REAL_ESTATE_BTN_XPATH)).click();
        driver.findElement(By.xpath(FORM_10_07_XPATH)).click();
        GetTabFocus();
        driver.findElement(By.xpath(SEARCH_BTN_DATA_OF_MAIN_OBJECT)).click();
        return new FormationPrintingOutputFormsRealEstateScreen(driver);
    }

    public TableDataResultForm1007Screen tableResults(){
        SignIn();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_LINK_XPATH)).click();
        driver.findElement(By.xpath(FORMATION_PRINT_OUTPUT_FORM_REAL_ESTATE_BTN_XPATH)).click();
        driver.findElement(By.xpath(FORM_10_07_XPATH)).click();
        GetTabFocus();
        driver.findElement(By.xpath(SEARCH_BTN_DATA_OF_MAIN_OBJECT)).click();

        return new TableDataResultForm1007Screen(driver);
    }





    //Методы
    //******************************************************************************************************************
    private void GetTabFocus() {
        //handle windows change
        String base = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        set.remove(base);
        driver.close();
        assert set.size() == 1;
        driver.switchTo().window((String) set.toArray()[0]);

        //close the window and sitch back to the base tab
        //driver.close();
        //driver.switchTo().window(base);
    }

    //******************************************************************************************************************
    private void SignIn() {
        log.info(ОСУЩЕСТВЛЯЕМ_ВХОД);
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_LOGIN_XPATH)).sendKeys(RIK_TEST);
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_PASSWORD_XPATH)).sendKeys(TEST);
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_USER_XPATH)).click();
    }

    //******************************************************************************************************************
    private void SignIn(String A, String B) {
        log.info(ОСУЩЕСТВЛЯЕМ_ВХОД);
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_LOGIN_XPATH)).sendKeys(A);
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_PASSWORD_XPATH)).sendKeys(B);
        driver.findElement(By.xpath(MAIN_PAGE_ENTER_USER_XPATH)).click();
    }

    //******************************************************************************************************************
    private void SimpleEnterLogging() {
        SignIn();
        log.info(ВХОД_ОСУЩЕСТВЛЕН);
    }


}
