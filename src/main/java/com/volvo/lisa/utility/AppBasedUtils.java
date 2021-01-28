package com.volvo.lisa.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class AppBasedUtils {
    SoftAssert softAssert = new SoftAssert();
   

    public Properties config = null;

    /**
     * @param filename
     *            to read the properties values
     */
    public Properties getConfigProperties(String filename) {
        try {

            Path path = Paths.get("resources", "Configuration", filename + ".properties");

            FileInputStream fs = new FileInputStream(path.toString());
            config = new Properties();
            config.load(fs);
        } catch (IOException e) {
            Reporter.log(filename + " : " + "File not found");
            Assert.fail("File not found");

        } catch (Exception e) {
            Reporter.log(filename + " : " + "File not found");
            Assert.fail("File not found");

        }
        return config;
    }

    /***************************************************
     * #Description : common method to compare expected with actual result and write report log message
     **************************************************/
    public void asserVerification(String strExpected, String strActual, SoftAssert softAssert) {
        try {
            softAssert.assertEquals(strActual, strExpected);

        } catch (Exception e) {

        }
    }

    /*
     * #Description : returns the test data from the excel
     */
    public String getStringData(HashMap<String, Object> testDataHolder, String key) {
        String testDataStr = null;
        try {
            if ((testDataHolder.get(key) != null)) {
                testDataStr = testDataHolder.get(key).toString();
            } else {

            }
            return testDataStr;
        } catch (Exception e) {

            Assert.fail("Error occurred while reading test data.");
        }
        return testDataStr;
    }

}