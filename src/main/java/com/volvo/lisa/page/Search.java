/**
 * 
 */
package com.volvo.lisa.page;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.volvo.lisa.utility.AppBasedUtils;
import com.volvo.lisa.utility.ReadPropertyFile;
import com.volvo.lisa.utility.UIUtils;

/**
 * This is a POM. This pg will be used to initialise all the webelements and will record all the actionable methods.
 */
public class Search {

    WebDriver driver;
    String configFilePath = ".\\resources\\config.properties";
    ReadPropertyFile rpf = new ReadPropertyFile();
    UIUtils uiutil = new UIUtils();
    String testDataFileName;
    String sheetName;
    SoftAssert softassert = new SoftAssert();
    AppBasedUtils appBasedUtils = new AppBasedUtils();

    @FindBy(how = How.LINK_TEXT, using = "Search")
    WebElement searchLink;

    @FindBy(how = How.LINK_TEXT, using = "Search Textblock")
    WebElement search_SearchTextblockLink;

    @FindBy(how = How.XPATH, using = "//input[@name='functionGroupFrom']")
    WebElement searchTextblock_FuncGrpFrom;

    @FindBy(how = How.XPATH, using = "//input[@name='functionGroupTo']")
    WebElement searchTextblock_FuncGrpTo;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Search Textblock')]")
    WebElement searchTextblock_SearchTextblockText;

    @FindBy(how = How.XPATH, using = "//input[@value='Search']")
    WebElement commonSearchButton;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Result')]")
    WebElement CommonResultText;

    @FindBy(how = How.LINK_TEXT, using = "Search Chassis")
    WebElement searchChasisLink;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Search Chassis')]")
    WebElement searchChasis_SearchChassisText;

    @FindBy(how = How.XPATH, using = "//select[@name='searchFactory']")
    WebElement searchChasis_FactoryDropdown;

    @FindBy(how = How.XPATH, using = "//table[@class='table']")
    WebElement searchChasis_ResultTable;

    @FindAll({ @FindBy(xpath = "//input[@name='specificationWeek']") })
    List<WebElement> searchChasis_SpecificationWeek;

    @FindAll({ @FindBy(xpath = "//input[@name='rowNumber']") })
    List<WebElement> searchChasis_AllRadioButton;

    @FindBy(how = How.XPATH, using = "(//input[@name='specificationWeek'])[3]")
    WebElement searchChasis_SpecWeekColumnThirdValue;

    @FindBy(how = How.XPATH, using = "//font[starts-with(text(),'1')]")
    WebElement searchChasis_FolderTreeFirstElement;
    
    @FindBy(how = How.LINK_TEXT, using = "Log Information")
    WebElement logInformationLink;
    
    @FindBy(how = How.XPATH, using = "//input[@name='textblock']")
    WebElement logInformation_TB;
  
    @FindBy(how = How.XPATH, using = "//input[@value='Retrieve']")
    WebElement logInformation_RetrieveButton;
  
    @FindBy(how = How.XPATH, using = "//textarea[contains(text(),'Textblock retrieved')]")
    WebElement logInformation_TextblockRetrieve;
    
    public Search(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchTextblockVerification(HashMap<String, Object> data) {
        try {

            uiutil.waitFor(1000);
            uiutil.switchToDefaultContent(driver);
            uiutil.switchToCorrectionsLinksFrame(driver);
            uiutil.waitFor(2000);
            searchLink.click();
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(1000);
            uiutil.switchToManageLinksFrame(driver);
            search_SearchTextblockLink.click();
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(1000);
            uiutil.switchToRightFrame(driver, "searchTextblockHeader", searchTextblock_SearchTextblockText);
            uiutil.input(searchTextblock_FuncGrpFrom, appBasedUtils.getStringData(data, "SearchTextblock_FunctionGrpFrom"));
            uiutil.input(searchTextblock_FuncGrpTo, appBasedUtils.getStringData(data, "SearchTextblock_FunctionGrpTo"));
            commonSearchButton.click();
            uiutil.waitForElementVisibility(driver, CommonResultText);

            softassert.assertTrue(CommonResultText.isDisplayed());
            softassert.assertAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchChasisVerification(HashMap<String, Object> data) {
        try {

            uiutil.switchToDefaultContent(driver);
            uiutil.switchToManageLinksFrame(driver);
            uiutil.waitForElementVisibility(driver, searchChasisLink);
            searchChasisLink.click();
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToRightFrame(driver, "searchChassiHeader", searchChasis_SearchChassisText);
            uiutil.selectDropdownByVisibleText(searchChasis_FactoryDropdown, appBasedUtils.getStringData(data, "SearchChassis_FactoryDropdown"));
            commonSearchButton.click();

            uiutil.switchToRightFrame(driver, "searchChassiResult", searchChasis_ResultTable);
            uiutil.waitForAttributeToBeNotEmpty(driver, searchChasis_SpecWeekColumnThirdValue, "value");

            int specWeekLength = searchChasis_SpecificationWeek.size();

            for (int i = 0; i < specWeekLength; i++) {
                String specWeekActualValue = searchChasis_SpecificationWeek.get(i).getAttribute("value");
                String specWeekExpectedValue = appBasedUtils.getStringData(data, "SearchChassis_SpecWeekColumnValue");

                if (specWeekActualValue.equalsIgnoreCase(specWeekExpectedValue)) {
                    searchChasis_AllRadioButton.get(i).click();
                    break;
                }
            }

            uiutil.waitFor(2000);
            uiutil.switchToRightFrame(driver, "menufrm", searchChasis_FolderTreeFirstElement);
            searchChasis_FolderTreeFirstElement.click();
            uiutil.switchToRightFrame(driver, "basefrm", CommonResultText);

            softassert.assertTrue(CommonResultText.isDisplayed());
            softassert.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logInformationVerification(HashMap<String, Object> data) {
        try {
            uiutil.switchToDefaultContent(driver);
            uiutil.switchToManageLinksFrame(driver);
            uiutil.waitFor(3000);
            uiutil.waitForElementVisibility(driver, logInformationLink);
            logInformationLink.click();
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            driver.switchTo().frame("MAIN");
            uiutil.input(logInformation_TB, appBasedUtils.getStringData(data, "LogInformation_TB"));
            logInformation_RetrieveButton.click();
            
            uiutil.waitForElementVisibility(driver, logInformation_TextblockRetrieve);
            
            softassert.assertTrue(logInformation_TextblockRetrieve.isDisplayed());
            softassert.assertAll();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
