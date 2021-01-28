package com.volvo.lisa.utility;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class UIUtils {

    SoftAssert softAssert = new SoftAssert();

    /**
     * @param inputBox:-
     *            edit box locator value
     * @param obj:-
     *            text value to put inside edit box
     */
    public void input(WebElement inputBox, String strText) {
        try {

            inputBox.clear();
            inputBox.sendKeys(strText);

        } catch (NoSuchElementException e) {

            Assert.fail(inputBox.getAttribute("id") + "  element not found");
        } catch (Exception e) {

            Assert.fail(inputBox.getAttribute("id") + "  element not found");
        }
    }

    public void switchToChildWindow(WebDriver driver) throws InterruptedException {
        // Switch to windows
        Set<String> s = driver.getWindowHandles();
        Iterator<String> it = s.iterator();
        String parentWindow = it.next(); // parent window id
        String childWindow = it.next(); // child window id
        Thread.sleep(2000);
        driver.switchTo().window(childWindow);
        driver.manage().window().maximize();

    }

    // Selecting a dropdown by visible text
    public void selectDropdownByVisibleText(WebElement dropDownElement, Object text) {

        Select select = new Select(dropDownElement);
        select.selectByVisibleText(text.toString());
    }

    // Selecting a dropdown by Index
    public void selectDropdownByIndex(WebElement dropDownElement, Object index) {

        int changedIndex = Integer.parseInt(index.toString());
        Select select = new Select(dropDownElement);
        select.selectByIndex(changedIndex);
    }

    // Selecting a dropdown by value
    public void selectDropdownByValue(WebElement dropDownElement, Object value) {
        String changedValue = value.toString();
        Select select = new Select(dropDownElement);
        select.selectByValue(changedValue);
    }

    public void sectionHeaderIsDisplayed(WebElement headerText) {

        softAssert.assertTrue(headerText.isDisplayed());
    }

    public boolean editBoxIsEnabled(WebElement element) {
        if (element.isEnabled()) {
            return true;
        }
        return false;
    }

    public void columnHeaderIsDisplayed(WebElement columnName) {

        softAssert.assertTrue(columnName.isDisplayed());
    }

    // clicking a radiobutton
    public void clickOnRadioButton(WebElement element) {

        element.click();
    }
/*
    public void switchToLoginFrame(WebDriver driver, WebElement element) throws InterruptedException {
        // Thread.sleep(2000);
        // WebDriverWait wait = new WebDriverWait(driver,15);
        // wait.until(ExpectedConditions.visibilityOf(element));

        driver.switchTo().frame(element);

    }*/

    // this method is to switch between the frames in lisa classic
    public void switchToManageLinksFrame(WebDriver driver) throws InterruptedException {
        waitForFrameToLoadAndSwitch(driver, "TOC");
        waitForFrameToLoadAndSwitch(driver, "TOC2");
        waitForFrameToLoadAndSwitch(driver, "tocContents");
        
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();

    }

    //this method is used to switch from left pane to right side frame in Lisa Classic
    public void switchToRightFrame(WebDriver driver, String frameName, WebElement element) {
        switchToDefaultContent(driver);
        //driver.switchTo().frame("MAIN");
        waitForFrameToLoadAndSwitch(driver, "MAIN");
        //driver.switchTo().frame(frameName);
        waitForFrameToLoadAndSwitch(driver, frameName);
        waitForElementVisibility(driver, element);
    }

    //to wait for any specific webelement
    public void waitForElementVisibility(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
        }

    }
    
    //this method is used to wait for the frame and when available, switch to it.
    public void waitForFrameToLoadAndSwitch(WebDriver driver, String frameName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
        }

    }
    
    //this method is used to wait for specific attribute to be available
    public void waitForAttributeToBeNotEmpty(WebDriver driver, WebElement element, String attribute) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
        }

    }

    public void waitFor(int timeInMilliseconds) throws InterruptedException {
        Thread.sleep(timeInMilliseconds);
    }

    public void switchToCorrectionsLinksFrame(WebDriver driver) throws InterruptedException {
        
        waitForFrameToLoadAndSwitch(driver, "TOC");
        waitForFrameToLoadAndSwitch(driver, "TOC2");
        waitForFrameToLoadAndSwitch(driver, "tocTop");
    }

    // this method is to scroll till the end of the page.
    public void scrollToBottom(WebDriver driver) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        waitFor(2000);
    }

    //to get the size or no. of dropdown items
    public int getSizeOfDropDownOptions(WebElement dropDownElement) {
        Select select = new Select(dropDownElement);
        List<WebElement> options = select.getOptions();
        int sizeOfOptions = options.size();
        return sizeOfOptions;
    }

}
