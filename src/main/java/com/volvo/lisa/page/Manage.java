/**
 * 
 */
package com.volvo.lisa.page;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.volvo.lisa.utility.AppBasedUtils;
import com.volvo.lisa.utility.BaseClass;
import com.volvo.lisa.utility.ReadPropertyFile;
import com.volvo.lisa.utility.UIUtils;

/**
 * This is a POM. This pg will be used to initialise all the webelements
 */
public class Manage extends BaseClass {

    WebDriver driver;
    String configFilePath = ".\\resources\\config.properties";
    ReadPropertyFile rpf = new ReadPropertyFile();
    UIUtils uiutil = new UIUtils();
    String testDataFileName;
    String sheetName;
    SoftAssert softassert = new SoftAssert();

    AppBasedUtils appBasedUtils = new AppBasedUtils();

    @FindBy(how = How.XPATH, using = "//td[text()='Manage Textblock Version']")
    WebElement manageTextVersion;

    @FindBy(xpath = "//frame[@name='lisaStart']")
    WebElement loginFrame;

    @FindBy(xpath = "//input[@name='userName']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//input[@value='Log on']")
    WebElement loginButton;

    @FindBy(how = How.LINK_TEXT, using = "Manage Version")
    WebElement manageversionlink;

    @FindBy(how = How.XPATH, using = "//input[@type='text' and @name='textblock']")
    WebElement manageVersionTextblock;

    @FindBy(how = How.XPATH, using = "//input[@type='button' and @name='retrieve']")
    WebElement retrieveButton;

    @FindBy(how = How.NAME, using = "header")
    WebElement HeaderBox;

    @FindBy(how = How.LINK_TEXT, using = "Manage Parts")
    WebElement managePartsLink;

    @FindBy(how = How.XPATH, using = "//td[text()='Manage Parts per Textblock Version']")
    WebElement ManagePartsPerTextblockVersionText;

    @FindBy(how = How.XPATH, using = "//input[@type='text' and @name='textblock']")
    WebElement managePartsTextblock;

    @FindBy(how = How.XPATH, using = "//input[@type='button' and @name='retrieve']")
    WebElement managePartsRetrieveButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Manage Text']")
    WebElement manageTextLink;

    @FindBy(how = How.XPATH, using = "//td[text()='Manage Text']")
    WebElement ManageTextHeader;

    @FindBy(how = How.XPATH, using = "//input[@value='Search']")
    WebElement manageTextSearchButton;

    @FindBy(how = How.XPATH, using = "//textarea[text()='Textblock retrieved']")
    WebElement TextblockRetrieved_Text;

    @FindBy(how = How.XPATH, using = "//textarea[text()='Warning: Illustration not stored in SAFT']")
    WebElement warningText;

    @FindBy(how = How.XPATH, using = "//frame[@name='result']")
    WebElement manageParts_resultFrame;

    @FindBy(how = How.XPATH, using = "//select[@name='textTypeSearch']")
    WebElement manageText_TexttypeDropdown;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Result:')]")
    WebElement manageText_ResultText;

    @FindBy(how = How.XPATH, using = "//a[text()='Manage Preface']")
    WebElement managePrefaceLink;

    @FindBy(how = How.XPATH, using = "//td[text()='Search Preface']")
    WebElement managePreface_SearchPrefaceText;

    @FindBy(how = How.XPATH, using = "//input[@name='functionGroupSearch']")
    WebElement managePreface_FunctionGroupEditBox;

    @FindBy(how = How.XPATH, using = "//input[@value='Search']")
    WebElement managePrefaceSearchButton;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Result:')]")
    WebElement managePreface_ResultText;

    @FindBy(how = How.XPATH, using = "//a[text()='Manage Request']")
    WebElement manageRequestLink;

    @FindBy(how = How.XPATH, using = "//td[text()='Manage Request']")
    WebElement manageRequest_manageRequestText;

    @FindBy(how = How.XPATH, using = "//select[@name='actionSearch']")
    WebElement manageRequest_ActionDropdown;

    @FindBy(how = How.XPATH, using = "//input[@value='Search']")
    WebElement manageRequestSearchButton;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Result:')]")
    WebElement manageRequest_ResultText;

    @FindBy(how = How.XPATH, using = "//a[text()='Order Catalog']")
    WebElement orderCatalogLink;

    @FindBy(how = How.XPATH, using = "//input[@name='chassiFrom']")
    WebElement orderCalalog_ChasisNoFrom;

    @FindBy(how = How.XPATH, using = "//input[@name='chassiTo']")
    WebElement orderCalalog_ChasisNoTo;

    @FindBy(how = How.XPATH, using = "//td[text()='Order Catalog']")
    WebElement orderCalalogText;

    @FindBy(how = How.XPATH, using = "//input[@name='chassiType']")
    WebElement orderCalalog_ChasisType;

    @FindBy(how = How.XPATH, using = "//select[@name='language']")
    WebElement orderCalalog_languageDropdown;

    @FindBy(how = How.XPATH, using = "//input[@name='mailAddress']")
    WebElement orderCalalog_Email;

    @FindBy(how = How.XPATH, using = "//input[@value='Send Order']")
    WebElement orderCalalog_SendOrder;

    @FindBy(how = How.XPATH, using = "//textarea[contains(text(),'Process of spare part catalog')]")
    WebElement orderCatalogEmailConfirmationText;

    @FindBy(how = How.XPATH, using = "//a[text()='LISA Op. Queue']")
    WebElement LisaOpQueueLink;

    @FindBy(how = How.XPATH, using = "//td[text()='LISA Operations queue']")
    WebElement LisaOpQueue_LisaOperationQueueText;

    @FindBy(how = How.XPATH, using = "//select[@name='productClass']")
    WebElement LisaOpQueueProductClass;

    @FindBy(how = How.XPATH, using = "//input[@value='Search']")
    WebElement LisaOpQueue_SearchButton;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Result:')]")
    WebElement lisaOpQueue_ResultText;

    @FindBy(how = How.XPATH, using = "//a[text()='Manage User Roles']")
    WebElement manageUserRolesLink;

    @FindBy(how = How.XPATH, using = "//td[text()='Manage User Roles']")
    WebElement manageUserRoles_ManageUserRolesText;

    @FindBy(how = How.XPATH, using = "//input[@name='userIdSearch']")
    WebElement manageUserRoles_UserID;

    @FindBy(how = How.XPATH, using = "//input[@value='Retrieve']")
    WebElement manageUserRoles_RetrieveButton;

    @FindBy(how = How.XPATH, using = "//select[@name='roles']")
    WebElement manageUserRoles_CurrentRolesForUserID;

    @FindBy(how = How.XPATH, using = "//input[@type='button']")
    WebElement manageUserRoles_CurrentRolesDeleteButton;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Result:')]")
    WebElement manageUserRoles_ResultText;

    public Manage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void launchApplication(String url) {
        driver.manage().window().maximize();
        driver.get(url);

    }

    public void loginToLisaClassic(HashMap<String, Object> data) {

        try {
            Thread.sleep(2000);
            driver.switchTo().frame(loginFrame);

            uiutil.input(username, appBasedUtils.getStringData(data, "Username"));
            uiutil.input(password, appBasedUtils.getStringData(data, "Password"));
            loginButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*
     * This method is to verify manage version link
     * 
     */

    public void manageVersionLinkVerification(HashMap<String, Object> data) {
        try {

            uiutil.switchToChildWindow(driver);
            uiutil.switchToManageLinksFrame(driver);
            manageversionlink.click();
            uiutil.waitFor(2000);
            switchToFrameEditTextblockHeader(driver);
            uiutil.waitFor(1000);
            uiutil.input(manageVersionTextblock, appBasedUtils.getStringData(data, "TextBlockNumber"));
            retrieveButton.click();
            uiutil.waitForElementVisibility(driver, TextblockRetrieved_Text);

            softassert.assertTrue(TextblockRetrieved_Text.isDisplayed(), "Element is visible");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        softassert.assertAll();
    }

    public void switchToFrameEditTextblockHeader(WebDriver driver) {
        try {

            uiutil.switchToDefaultContent(driver);
            driver.switchTo().frame("MAIN");
            driver.switchTo().frame("editTextblockHeader");
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(manageTextVersion));

        } catch (Exception e) {
            e.getMessage(); // add no such element exception
        }
    }

    public void switchToFramePartsHeader(WebDriver driver) {
        try {
            uiutil.switchToManageLinksFrame(driver);
            managePartsLink.click();
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(ManagePartsPerTextblockVersionText));
            uiutil.switchToDefaultContent(driver);
            driver.switchTo().frame("MAIN");
            driver.switchTo().frame("partsheader");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void switchToFrameManageTextHeader(WebDriver driver) {
        try {
            uiutil.switchToManageLinksFrame(driver);
            manageTextLink.click();
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(ManageTextHeader));
            uiutil.switchToDefaultContent(driver);
            driver.switchTo().frame("MAIN");
            driver.switchTo().frame("manageTextHeader");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void managePartsLinkVerification(HashMap<String, Object> data) throws InterruptedException {

        uiutil.switchToDefaultContent(driver);
        uiutil.switchToManageLinksFrame(driver);
        managePartsLink.click();
        Thread.sleep(5000);
        uiutil.switchToRightFrame(driver, "partsheader", ManagePartsPerTextblockVersionText);

        Thread.sleep(2000);
        uiutil.input(manageVersionTextblock, appBasedUtils.getStringData(data, "TextBlockNumber"));
        retrieveButton.click();
        uiutil.waitForElementVisibility(driver, warningText);

        softassert.assertTrue(warningText.isDisplayed(), "Element is visible");
        softassert.assertAll();
    }

    public void manageTextLinkVerification(HashMap<String, Object> data) throws InterruptedException {
        uiutil.switchToDefaultContent(driver);
        uiutil.switchToManageLinksFrame(driver);
        manageTextLink.click();
        Thread.sleep(2000);

        uiutil.switchToRightFrame(driver, "manageTextHeader", manageTextSearchButton);
        uiutil.selectDropdownByVisibleText(manageText_TexttypeDropdown, appBasedUtils.getStringData(data, "ManageText_TextTypeOption"));
        manageTextSearchButton.click();
        Thread.sleep(2000);

        softassert.assertTrue(manageText_ResultText.isDisplayed());
        softassert.assertAll();
    }

    public void managePrefaceVerification(HashMap<String, Object> data) throws InterruptedException {
        uiutil.switchToDefaultContent(driver);
        uiutil.switchToManageLinksFrame(driver);
        managePrefaceLink.click();
        Thread.sleep(2000);
        uiutil.switchToRightFrame(driver, "searchPrefaceHeader", managePreface_SearchPrefaceText);
        uiutil.input(managePreface_FunctionGroupEditBox, appBasedUtils.getStringData(data, "ManagePreface_FunctionGroupBox"));
        managePrefaceSearchButton.click();

        Thread.sleep(2000);
        uiutil.switchToRightFrame(driver, "searchPrefaceHeader", managePreface_ResultText);

        softassert.assertTrue(managePreface_ResultText.isDisplayed());
        softassert.assertAll();

    }

    public void LisaOpQueueVerification(HashMap<String, Object> data) throws InterruptedException {
        uiutil.switchToDefaultContent(driver);
        uiutil.switchToManageLinksFrame(driver);
        LisaOpQueueLink.click();
        Thread.sleep(2000);
        uiutil.switchToRightFrame(driver, "workLogFromLisaHeader", LisaOpQueue_LisaOperationQueueText);
        uiutil.selectDropdownByVisibleText(LisaOpQueueProductClass, appBasedUtils.getStringData(data, "LisaOpQueue_ProductClassDropdownOption"));
        LisaOpQueue_SearchButton.click();
        uiutil.waitForElementVisibility(driver, lisaOpQueue_ResultText);

        softassert.assertTrue(lisaOpQueue_ResultText.isDisplayed());
        softassert.assertAll();
    }

    public void manageRequestVerification(HashMap<String, Object> data) throws InterruptedException {
        uiutil.switchToDefaultContent(driver);
        uiutil.switchToManageLinksFrame(driver);
        manageRequestLink.click();
        Thread.sleep(2000);
        uiutil.switchToRightFrame(driver, "managePreProdChassiHeader", manageRequestSearchButton);
        uiutil.selectDropdownByVisibleText(manageRequest_ActionDropdown, appBasedUtils.getStringData(data, "ManageRequest_ActionDropDownOption"));

        Thread.sleep(2000);
        uiutil.switchToRightFrame(driver, "managePreProdChassiButtons", manageRequest_ResultText);

        softassert.assertTrue(manageRequest_ResultText.isDisplayed());
        softassert.assertAll();
    }

    public void orderCatalogVerification(HashMap<String, Object> data) throws InterruptedException {
        uiutil.switchToDefaultContent(driver);
        uiutil.switchToManageLinksFrame(driver);
        orderCatalogLink.click();
        Thread.sleep(2000);
        driver.switchTo().frame("MAIN");
        uiutil.waitForElementVisibility(driver, orderCalalogText);
        uiutil.input(orderCalalog_ChasisNoFrom, appBasedUtils.getStringData(data, "OrderCatalog_ChasisNoFrom"));
        Thread.sleep(1000);
        uiutil.input(orderCalalog_ChasisNoTo, appBasedUtils.getStringData(data, "OrderCatalog_ChasisNoTo"));
        Thread.sleep(1000);
        uiutil.input(orderCalalog_ChasisType, appBasedUtils.getStringData(data, "OrderCatalog_ChasisType"));
        uiutil.selectDropdownByIndex(orderCalalog_languageDropdown, appBasedUtils.getStringData(data, "OrderCatalog_LanguageDropdownOptions"));
        uiutil.input(orderCalalog_Email, appBasedUtils.getStringData(data, "OrderCatalog_Email"));
        orderCalalog_SendOrder.click();
        Thread.sleep(1000);

        softassert.assertTrue(orderCatalogEmailConfirmationText.isDisplayed());
        softassert.assertAll();
    }

    public void manageUserRolesVerification(HashMap<String, Object> data) throws InterruptedException {
        Thread.sleep(2000);
        uiutil.switchToDefaultContent(driver);
        uiutil.switchToManageLinksFrame(driver);
        uiutil.waitFor(1000);
        uiutil.scrollToBottom(driver);
        manageUserRolesLink.click();
        uiutil.waitFor(2000);
        uiutil.switchToRightFrame(driver, "manageUsersHeader", manageUserRoles_ManageUserRolesText);

        uiutil.input(manageUserRoles_UserID, appBasedUtils.getStringData(data, "ManageUserRoles_UserId"));
        manageUserRoles_RetrieveButton.click();
        uiutil.waitFor(2000);

        uiutil.switchToRightFrame(driver, "manageUsersHeader", manageUserRoles_ResultText);

        softassert.assertTrue(manageUserRoles_ResultText.isDisplayed());
        softassert.assertAll();

    }

}
