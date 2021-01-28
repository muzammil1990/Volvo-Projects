package com.volvo.lisa.poc;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class POC_LisaMA {

    WebDriver driver;
    SoftAssert softAssert;

    public void switchToManageLinksFrame() {
        driver.switchTo().frame("TOC");
        driver.switchTo().frame("TOC2");
        driver.switchTo().frame("tocContents");
    }

    // increase thread sleep time after sendkeys to 3 sec for demo purpose.
    @Test
    public void testMFOnlineScreens() throws InterruptedException {

        softAssert = new SoftAssert();

        System.setProperty("webdriver.chrome.driver", ".\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://lisa-server-qa.acps-alpha-r1.srv.volvo.com/lisa-web/");

        // switching to frame
        driver.switchTo().frame("lisaStart");
        WebElement userName = driver.findElement(By.xpath("//input[@name='userName']"));
        userName.sendKeys("A247622");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("titan00");
        Thread.sleep(1000);

        WebElement logonbutton = driver.findElement(By.xpath("//input[@value='Log on']"));
        logonbutton.click();

        // String parentwindow= driver.getWindowHandle();

        // Switch to windows
        Set<String> s = driver.getWindowHandles();
        Iterator<String> it = s.iterator();
        String parentWindow = it.next(); // parent window id
        String childWindow = it.next(); // child window id
        Thread.sleep(2000);

        // switiching to child window
        driver.switchTo().window(childWindow);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        System.out.println(driver.getTitle());

        int size = driver.findElements(By.tagName("frameset")).size();
        System.out.println("no of frames:" + size);

        // Manage Version
        switchToManageLinksFrame();
        Thread.sleep(1000);
        WebElement manageversionlink = driver.findElement(By.linkText("Manage Version"));
        manageversionlink.click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("MAIN");
        driver.switchTo().frame("editTextblockHeader");
        Thread.sleep(2000);

        WebElement textblock1 = driver.findElement(By.xpath("//input[@type='text' and @name='textblock']"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(textblock1));
        textblock1.sendKeys("74624928");
        Thread.sleep(2000);

        WebElement retrieveButton = driver.findElement(By.xpath("//input[@type='button' and @name='retrieve']"));
        retrieveButton.click();
        Thread.sleep(3000);

        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        // manage parts
        switchToManageLinksFrame();
        Thread.sleep(1000);
        WebElement manageparts = driver.findElement(By.linkText("Manage Parts"));
        manageparts.click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("MAIN");
        driver.switchTo().frame("partsheader");
        Thread.sleep(2000);

        WebElement textblock2 = driver.findElement(By.xpath("//input[@type='text' and @name='textblock']"));
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        wait2.until(ExpectedConditions.visibilityOf(textblock2));
        textblock2.sendKeys("76938017");
        Thread.sleep(2000);

        WebElement retrieveButton2 = driver.findElement(By.xpath("//input[@type='button' and @name='retrieve']"));
        retrieveButton2.click();
        Thread.sleep(3000);

        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        // Manage Text
        switchToManageLinksFrame();
        Thread.sleep(1000);
        WebElement managetext = driver.findElement(By.linkText("Manage Text"));
        managetext.click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("MAIN");
        driver.switchTo().frame("manageTextHeader");
        Thread.sleep(2000);

        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Search']"));
        searchButton.click();
        Thread.sleep(3000);

        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        // Manage preface
        switchToManageLinksFrame();
        Thread.sleep(1000);
        WebElement managePreface = driver.findElement(By.linkText("Manage Preface"));
        managePreface.click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.switchTo().frame("MAIN");
        driver.switchTo().frame("searchPrefaceHeader");
        Thread.sleep(2000);

        WebElement functiongroupTextbox = driver.findElement(By.xpath("//input[@name='functionGroupSearch']"));
        functiongroupTextbox.sendKeys("22");
        Thread.sleep(2000);

        WebElement searchButton2 = driver.findElement(By.xpath("//input[@value='Search']"));
        searchButton2.click();
        Thread.sleep(3000);

        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        // Manage Request
        switchToManageLinksFrame();
        Thread.sleep(1000);
        WebElement manageRequest = driver.findElement(By.linkText("Manage Request"));
        manageRequest.click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.switchTo().frame("MAIN");
        driver.switchTo().frame("managePreProdChassiHeader");
        Thread.sleep(2000);

        WebElement actionDropdown = driver.findElement(By.xpath("//select[@name='actionSearch']"));
        Select dropdownItem = new Select(actionDropdown);
        dropdownItem.selectByIndex(1);
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        // order catalog
        switchToManageLinksFrame();
        Thread.sleep(1000);
        WebElement orderCatalog = driver.findElement(By.linkText("Order Catalog"));
        orderCatalog.click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.switchTo().frame("MAIN");
        Thread.sleep(2000);

        WebElement chasisFrom = driver.findElement(By.name("chassiFrom"));
        chasisFrom.sendKeys("25197");
        Thread.sleep(2000);

        WebElement chasisTo = driver.findElement(By.name("chassiTo"));
        chasisTo.sendKeys("25199");
        Thread.sleep(2000);

        WebElement chasisType = driver.findElement(By.name("chassiType"));
        chasisType.sendKeys("JPCT");
        Thread.sleep(2000);

        WebElement emailBox = driver.findElement(By.name("mailAddress"));
        emailBox.sendKeys("muzammil.choudhury@volvo.com");
        Thread.sleep(2000);

        WebElement sendOrder = driver.findElement(By.xpath("//input[@value='Send Order']"));
        sendOrder.click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        // scroll to last
        switchToManageLinksFrame();
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // document.body.scrollHeight:- return the complete ht of the body i.e. webpage
        Thread.sleep(2000);

//        driver.switchTo().defaultContent();
//        Thread.sleep(1000);
//
//        // manage user roles
//        switchToManageLinksFrame();
//        Thread.sleep(1000);
        WebElement manageUserRoles = driver.findElement(By.linkText("Manage User Roles"));
        manageUserRoles.click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.switchTo().frame("MAIN");    
        driver.switchTo().frame("manageUsersHeader");
        Thread.sleep(2000);

        WebElement userIdSearch = driver.findElement(By.name("userIdSearch"));
        userIdSearch.sendKeys("A247622");

        WebElement retrieveButton3 = driver.findElement(By.xpath("//input[@value='Retrieve']"));
        retrieveButton3.click();
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        

        driver.close(); // closing childwindow

        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(parentWindow);
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.quit();

    }

}
