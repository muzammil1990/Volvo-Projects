/**
 * 
 */
package com.volvo.lisa.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.volvo.lisa.page.Corrections;
import com.volvo.lisa.page.Manage;
import com.volvo.lisa.page.Search;
import com.volvo.lisa.page.StandardParts;
import com.volvo.lisa.utility.ApplicationConstants;
import com.volvo.lisa.utility.BaseClass;
import com.volvo.lisa.utility.ExcelReadAndWrite;
import com.volvo.lisa.utility.UIUtils;

/**
 * This class are my Test Cases
 */
public class Manage_TC extends BaseClass {

    WebDriver driver;
    Manage manageScreen;
    Corrections corrections;
    StandardParts stdParts;
    Search search;
    HashMap<String, Object> data = null;
    public ExcelReadAndWrite excelReadWrite;
    public static List<Object> lstData;

    @BeforeClass
    public void initializeDriver() {

        driver = getDriver();
        manageScreen = new Manage(driver);
        corrections = new Corrections(driver);
        stdParts = new StandardParts(driver);
        search = new Search(driver);
    }

    @Parameters({ "appURL", "testDataFileName" })
    @Test
    public void TC1_verifyManageScreen(String url, String testDataFileName) {

        try {
            manageScreen.launchApplication(url);
            excelReadWrite = new ExcelReadAndWrite(ApplicationConstants.RESOURCES_TEST_DATA + "QA\\" + testDataFileName, "ManageTestData");
            lstData = excelReadWrite.readAll();
            data = (HashMap<String, Object>) lstData.get(1);
            manageScreen.loginToLisaClassic(data);
            manageScreen.manageVersionLinkVerification(data);
            manageScreen.managePartsLinkVerification(data);
            manageScreen.manageTextLinkVerification(data);
            manageScreen.managePrefaceVerification(data);
            manageScreen.LisaOpQueueVerification(data);
            manageScreen.manageRequestVerification(data);
            manageScreen.orderCatalogVerification(data);
            manageScreen.manageUserRolesVerification(data);

        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Parameters("testDataFileName")
    @Test
    public void TC2_verifyCorrectionsScreen(String testDataFileName) {

        try {
            excelReadWrite = new ExcelReadAndWrite(ApplicationConstants.RESOURCES_TEST_DATA + "QA\\" + testDataFileName, "CorrectionsTestData");
            lstData = excelReadWrite.readAll();
            data = (HashMap<String, Object>) lstData.get(1);
            corrections.manageDeviationsVerification(data);
            corrections.deviationQueueVerification(data);
            corrections.correctTextblockVerification(data);
            corrections.correctPartsVerification(data);

        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Parameters("testDataFileName")
    @Test
    public void TC3_verifyStandardPartsScreen(String testDataFileName) {

        try {
            excelReadWrite = new ExcelReadAndWrite(ApplicationConstants.RESOURCES_TEST_DATA + "QA\\" + testDataFileName, "StandardPartsData");
            lstData = excelReadWrite.readAll();
            data = (HashMap<String, Object>) lstData.get(1);
            stdParts.searchPartGroupVerification();
            stdParts.managePartGroupVerification(data);
            stdParts.manageLinkVerification();
            stdParts.manageImageVerification(data);
            stdParts.manageStandardPartTextVerification(data);

        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Parameters("testDataFileName")
    @Test
    public void TC4_verifySearchScreen(String testDataFileName) {

        try {
            excelReadWrite = new ExcelReadAndWrite(ApplicationConstants.RESOURCES_TEST_DATA + "QA\\" + testDataFileName, "SearchData");
            lstData = excelReadWrite.readAll();
            data = (HashMap<String, Object>) lstData.get(1);

            search.searchTextblockVerification(data);
            search.searchChasisVerification(data);
            search.logInformationVerification(data);

        } catch (Exception e) {
            e.getMessage();
        }

    }

}
