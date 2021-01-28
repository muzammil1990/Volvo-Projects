package com.volvo.lisa.page;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
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

public class Corrections {

    WebDriver driver;
    String configFilePath = ".\\resources\\config.properties";
    ReadPropertyFile rpf = new ReadPropertyFile();
    UIUtils uiutil = new UIUtils();
    String testDataFileName;
    String sheetName;
    SoftAssert softassert = new SoftAssert();

    AppBasedUtils appBasedUtils = new AppBasedUtils();

    @FindBy(xpath = "//frame[@name='lisaStart']")
    WebElement loginFrame;

    @FindBy(xpath = "//input[@name='userName']")
    WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//input[@value='Log on']")
    WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Corrections']")
    WebElement correctionLink;

    @FindBy(how = How.XPATH, using = "//a[text()='Manage Deviations']")
    WebElement correctionsManageDeviationsLink;

    @FindBy(how = How.XPATH, using = "//select[@name='errorCodeSearch']")
    WebElement manageDeviation_DeviationDropdown;

    @FindBy(how = How.XPATH, using = "//td[text()='Search Batch Deviations']")
    WebElement manageDeviation_SearchBatchDeviationsText;

    @FindBy(how = How.XPATH, using = "//select[@name='factorySearch']")
    WebElement manageDeviation_FactoryDropdown;

    @FindBy(how = How.XPATH, using = "//input[@value='Search']")
    WebElement manageDeviation_SearchButton;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Result:')]")
    WebElement commonResultText;

    @FindBy(how = How.XPATH, using = "//a[text()='Deviation Queue']")
    WebElement correctionsDeviationQueueLink;

    @FindBy(how = How.XPATH, using = "//td[text()='Deviation Queue']")
    WebElement deviationQueue_deviationQueueText;

    @FindBy(how = How.XPATH, using = "//select[@name='errorSearch']")
    WebElement deviationQueue_ErrorDropdown;

    @FindBy(how = How.XPATH, using = "//select[@name='factorySearch']")
    WebElement FactoryDropdown;

    @FindBy(how = How.XPATH, using = "//input[@value='Search']")
    WebElement commonSearch;

    @FindBy(how = How.XPATH, using = "//a[text()='Correct Textblock']")
    WebElement correctTextblockLink;

    @FindBy(how = How.XPATH, using = "//td[text()='Search Chassis to correct']")
    WebElement correctTextblock_SearchChasistoCorrectText;

    @FindBy(how = How.XPATH, using = "//a[text()='Correct Parts']")
    WebElement correctPartsLink;

    @FindBy(how = How.XPATH, using = "//td[text()='Correct Parts on Textblock']")
    WebElement correctParts_CorrectPartsOnTextblock;

    @FindBy(how = How.XPATH, using = "//input[@name='textblock']")
    WebElement correctParts_Textblock;

    @FindBy(how = How.XPATH, using = "//input[@name='retrieve']")
    WebElement correctParts_RetrieveButton;

    @FindAll({ @FindBy(xpath = "//input[@name='description']") })
    List<WebElement> correctParts_DescriptionColumn;

    @FindAll({ @FindBy(xpath = "//input[@type='radio']") })
    List<WebElement> correctParts_RadioButtonColumn;

    @FindBy(how = How.XPATH, using = "//table[@class='table']")
    WebElement correctParts_ResultTable;

    @FindBy(how = How.XPATH, using = "//input[@name='partNumberUpd']")
    WebElement correctParts_PartNoBox;

    @FindBy(how = How.XPATH, using = "//td[text()='Description:']")
    WebElement correctParts_DescriptionText;

    public Corrections(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void manageDeviationsVerification(HashMap<String, Object> data) {
        try {
            uiutil.waitFor(3000);
            uiutil.switchToDefaultContent(driver);
            uiutil.switchToCorrectionsLinksFrame(driver);
            correctionLink.click();
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToManageLinksFrame(driver);
            correctionsManageDeviationsLink.click();
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToRightFrame(driver, "searchBatchErrorsHeader", manageDeviation_SearchBatchDeviationsText);
            uiutil.selectDropdownByIndex(manageDeviation_DeviationDropdown, appBasedUtils.getStringData(data, "ManageDeviations_DeviationDropdownOption"));
            uiutil.selectDropdownByIndex(manageDeviation_FactoryDropdown, appBasedUtils.getStringData(data, "ManageDeviations_FactoryDropdownOption"));
            manageDeviation_SearchButton.click();
            uiutil.waitForElementVisibility(driver, commonResultText);

            softassert.assertTrue(commonResultText.isDisplayed());
            softassert.assertAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deviationQueueVerification(HashMap<String, Object> data) {
        try {
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.switchToManageLinksFrame(driver);
            correctionsDeviationQueueLink.click();
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToRightFrame(driver, "deviationQueueHeader", deviationQueue_deviationQueueText);
            uiutil.waitFor(2000);
            uiutil.selectDropdownByIndex(deviationQueue_ErrorDropdown, appBasedUtils.getStringData(data, "DeviationQueue_ErrorDropdownOption"));
            uiutil.waitFor(2000);
            uiutil.selectDropdownByIndex(FactoryDropdown, appBasedUtils.getStringData(data, "DeviationQueue_FactoryDropdownOption"));
            commonSearch.click();
            uiutil.waitFor(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void correctTextblockVerification(HashMap<String, Object> data) {
        try {
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.switchToManageLinksFrame(driver);
            correctTextblockLink.click();
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToRightFrame(driver, "searchCorrectTextblockHeader", correctTextblock_SearchChasistoCorrectText);
            uiutil.waitFor(2000);
            uiutil.selectDropdownByIndex(FactoryDropdown, appBasedUtils.getStringData(data, "CorrectTextblock_FactoryDropdownOption"));
            commonSearch.click();
            uiutil.waitForElementVisibility(driver, commonResultText);

            softassert.assertTrue(commonResultText.isDisplayed());
            softassert.assertAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void correctPartsVerification(HashMap<String, Object> data) {
        try {
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.switchToManageLinksFrame(driver);
            correctPartsLink.click();
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToRightFrame(driver, "correctPartsHeader", correctParts_CorrectPartsOnTextblock);
            uiutil.waitFor(2000);
            uiutil.input(correctParts_Textblock, appBasedUtils.getStringData(data, "CorrectParts_Textblock"));
            correctParts_RetrieveButton.click();
            uiutil.switchToRightFrame(driver, "correctPartsResult", correctParts_ResultTable);
            uiutil.waitFor(2000);

           int descColumnLength = correctParts_DescriptionColumn.size();
            for (int i = 0; i < descColumnLength; i++) {
                String descTextActualValue = correctParts_DescriptionColumn.get(i).getAttribute("value");

                if (descTextActualValue.equalsIgnoreCase(appBasedUtils.getStringData(data, "CorrectParts_ExpectedDesc"))) {
                    correctParts_RadioButtonColumn.get(i).click();
                    break;
                }
            }

            // used when no. of rows and no of columns present and have to click on corresponding radiobtn or Checkboxes
            /*String firstPart = "//input[@value='";
            String secondPart = "']/../../td[1]";
            String xpath = firstPart + appBasedUtils.getStringData(data, "CorrectParts_ExpectedDesc") + secondPart;

            WebElement correctParts_expectedRadiobutton = driver.findElement(By.xpath(xpath));
            correctParts_expectedRadiobutton.click();*/

            uiutil.switchToRightFrame(driver, "correctPartsUpdate", correctParts_DescriptionText);
            //uiutil.waitFor(2000);
            uiutil.waitForAttributeToBeNotEmpty(driver, correctParts_PartNoBox, "value");
            
            String actualPartNummberValue = correctParts_PartNoBox.getAttribute("value");
            uiutil.waitFor(1000);
            String expectedPartNumberValue= appBasedUtils.getStringData(data, "CorrectParts_ExpectedPartNumber");
             
            softassert.assertEquals(actualPartNummberValue, expectedPartNumberValue);
            softassert.assertAll();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
