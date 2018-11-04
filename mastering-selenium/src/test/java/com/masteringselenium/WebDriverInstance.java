package com.masteringselenium;

import com.masteringselenium.config.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

import static com.masteringselenium.config.DriverType.CHROME;
import static com.masteringselenium.config.DriverType.valueOf;


/**
 * Created by Johannes on 11/3/2018.
 */
public class WebDriverInstance {

    private WebDriver driver;
    private DriverType selectedDriverType;
    private final DriverType defaultDriverType = CHROME;
    private final String browser = System.getProperty("browser").toUpperCase();
    private final String operatingSystems = System.getProperty("os.name").toUpperCase();
    private final String systemArchetecture = System.getProperty("os.arch");

    //method to get or pass Browser instance to whoever is calling this method
    public WebDriver getDriver() {
        if (driver == null) {
            selectedDriverType = determineDriverType();
            DesiredCapabilities desiredCapabilities = selectedDriverType.getDesiredCapabilities();
            instantiateWebDriver(desiredCapabilities);
        }
        return driver;
    }

    //method to close open Browser
    public void quitDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }

    private DriverType determineDriverType(){
        DriverType driverType = defaultDriverType;
        try {
            driverType = valueOf(browser);
        }
        catch (IllegalArgumentException ignore){
            System.err.println("Unknown driver specified, default to: " + driverType + " ...");
        }
        catch (NullPointerException ignore){
            System.err.println("No driver specified, defaulting to: " + driverType + " ...");
        }
        return driverType;
    }

    private void instantiateWebDriver(DesiredCapabilities desiredCapabilities){
            System.out.println(" ");
            System.out.println("Current Operating System is: " + operatingSystems);
            System.out.println("Current Archetecture is: " + systemArchetecture);
            System.out.println("Current Browser selected is: CHROME");
            System.out.println(" ");

            System.setProperty("webdriver.chrome.driver","C:/Users/Laptop/Downloads/chromedriver_win32 (1)/chromedriver.exe");
//            driver= new ChromeDriver(DesiredCapabilities.chrome());
            driver = selectedDriverType.getWebDriverInstance(desiredCapabilities);
    }

}
