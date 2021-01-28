/**
 * 
 */
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

/**
 * This is a POM. This pg will be used to initialise all the webelements and will record all the actionable methods.
 */
public class StandardParts {

    WebDriver driver;
    String configFilePath = ".\\resources\\config.properties";
    ReadPropertyFile rpf = new ReadPropertyFile();
    UIUtils uiutil = new UIUtils();
    String testDataFileName;
    String sheetName;
    SoftAssert softassert = new SoftAssert();

    AppBasedUtils appBasedUtils = new AppBasedUtils();

    @FindBy(how = How.LINK_TEXT, using = "Standard Parts")
    WebElement standardPartsLink;

    @FindBy(how = How.LINK_TEXT, using = "Search Part Group")
    WebElement standardParts_SearchPartGroupLink;

    @FindBy(how = How.XPATH, using = "//input[@value='Search']")
    WebElement CommonSearchButton;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Result:')]")
    WebElement CommonResultText;

    @FindBy(how = How.LINK_TEXT, using = "Manage Part Group")
    WebElement standardParts_ManagePartGroupLink;

    @FindBy(how = How.XPATH, using = "//input[@name='partGrpIdSearch']")
    WebElement commonPartGrpID;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Manage Part Group')]")
    WebElement managePartGroup_ManagePartGroupText;

    @FindBy(how = How.XPATH, using = "//input[@value='Retrieve']")
    WebElement managePartGroup_RetrieveButton;

    @FindBy(how = How.LINK_TEXT, using = "Manage Link")
    WebElement standardParts_ManageLink;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Manage Link')]")
    WebElement manageLink_ManageLinkText;

    @FindBy(how = How.LINK_TEXT, using = "Manage Image")
    WebElement standardParts_ManageImageLink;

    @FindBy(how = How.XPATH, using = "//td[starts-with(text(),'Manage')]")
    WebElement manageImage_ManageImageText;

    @FindBy(how = How.LINK_TEXT, using = "Manage Standard Part Text")
    WebElement standardParts_ManageStandardPartTextLink;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Manage Standard Part Text')]")
    WebElement manageStdPartText_ManageStandardPartText;

    @FindAll({ @FindBy(xpath = "//input[@name='originalTextRow']") })
    List<WebElement> manageStandardPartText_OriginalTextColumn;

    @FindAll({ @FindBy(xpath = "//input[@type='radio']") })
    List<WebElement> manageStandardPartText_RadioButtonColumn;

    @FindBy(how = How.XPATH, using = "//input[@value='parallel pin']")
    WebElement manageStdPartText_OriginalTextColumnValue;

    public StandardParts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchPartGroupVerification() {
        try {
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.switchToCorrectionsLinksFrame(driver);
            standardPartsLink.click();
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToManageLinksFrame(driver);
            standardParts_SearchPartGroupLink.click();
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToRightFrame(driver, "searchPartGroupsHeader", CommonSearchButton);
            CommonSearchButton.click();
            uiutil.waitForElementVisibility(driver, CommonResultText);

            softassert.assertTrue(CommonResultText.isDisplayed());
            softassert.assertAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void managePartGroupVerification(HashMap<String, Object> data) {
        try {
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToManageLinksFrame(driver);
            standardParts_ManagePartGroupLink.click();
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToRightFrame(driver, "managePartGroupsHeader", managePartGroup_ManagePartGroupText);
            uiutil.input(commonPartGrpID, appBasedUtils.getStringData(data, "ManagePartGroup_PartGrpID"));
            managePartGroup_RetrieveButton.click();
            uiutil.waitForElementVisibility(driver, CommonResultText);

            softassert.assertTrue(CommonResultText.isDisplayed());
            softassert.assertAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageLinkVerification() {
        try {
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToManageLinksFrame(driver);
            standardParts_ManageLink.click();
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToRightFrame(driver, "stdPartsLinksHeader", manageLink_ManageLinkText);
            CommonSearchButton.click();
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToRightFrame(driver, "update", CommonResultText);

            softassert.assertTrue(CommonResultText.isDisplayed());
            softassert.assertAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageImageVerification(HashMap<String, Object> data) {
        try {
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(3000);
            uiutil.switchToManageLinksFrame(driver);
            standardParts_ManageImageLink.click();
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(4000);
            uiutil.switchToRightFrame(driver, "illustrationsHeader", manageImage_ManageImageText);
            uiutil.waitFor(2000);
            uiutil.input(commonPartGrpID, appBasedUtils.getStringData(data, "ManageImage_PartGrpId"));
            CommonSearchButton.click();
            uiutil.waitForElementVisibility(driver, CommonResultText);
            uiutil.waitFor(2000);

            softassert.assertTrue(CommonResultText.isDisplayed());
            softassert.assertAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void manageStandardPartTextVerification(HashMap<String, Object> data) {
        try {
            uiutil.waitFor(2000);
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToManageLinksFrame(driver);
            standardParts_ManageStandardPartTextLink.click();
            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToRightFrame(driver, "manageTextSTHeader", manageStdPartText_ManageStandardPartText);
            CommonSearchButton.click();

            uiutil.switchToDefaultContent(driver);
            uiutil.waitFor(2000);
            uiutil.switchToRightFrame(driver, "result", manageStdPartText_OriginalTextColumnValue);
            uiutil.waitFor(2000);

            int originalTextLength = manageStandardPartText_OriginalTextColumn.size();
            for (int i = 0; i < originalTextLength; i++) {
                String originalTextActualValue = manageStandardPartText_OriginalTextColumn.get(i).getAttribute("value");
                String originalTextExpectedValue = appBasedUtils.getStringData(data, "ManageStdPartText_ExpectedValueOriginalText");

                if (originalTextActualValue.equalsIgnoreCase(originalTextExpectedValue)) {
                    manageStandardPartText_RadioButtonColumn.get(i).click();
                    break;
                }
            }

            softassert.assertTrue(manageStdPartText_OriginalTextColumnValue.isDisplayed());
            softassert.assertAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
