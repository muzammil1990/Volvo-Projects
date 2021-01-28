
package com.volvo.lisa.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * This class is used to launch the application in specific browser
 */
public class BaseClass {

    WebDriver driver; 
    String browserName;
    ReadPropertyFile rpf = new ReadPropertyFile();
    public static String url;
    static String dummy;

    String configFilePath = ".\\resources\\config.properties ";

    public WebDriver getDriver() {

        String browserName = rpf.readDataFromPropertiesFile(configFilePath, "browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\resources\\Drivers\\chromedriver.exe");
            
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("window-size=1400,800");
//            options.addArguments("headless");
//            driver = new ChromeDriver(options);
            driver = new ChromeDriver();
        }

        else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\resources\\Drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        else {
            System.setProperty("webdriver.ie.driver", ".\\resources\\Drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        return driver;
    }
    
    
    /****************************************
     * #Description : This method is to get the environment from from the URL passed
     *
     ******************************************/
    public static String getEnvironmentName() {
        
        try {
            String[] env;
            int left = url.indexOf("r")+1;
            int right = url.indexOf(".");
            String dummy = url.substring(left + 1, right);
            //env = dummy.split("\\-");
            //return env[0];
            return dummy;
        } catch (Exception e) {
            e.getMessage();
        }
        return dummy;
    }

}
