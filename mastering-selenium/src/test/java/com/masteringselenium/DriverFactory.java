package com.masteringselenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Johannes on 11/3/2018.
 */
public class DriverFactory {

    private static List<WebDriverInstance> driverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverInstance>());
    private static ThreadLocal<WebDriverInstance> driverThread;

    //@Before Hooks
    @BeforeSuite
    public static void instantiatDriverObject(){
        driverThread = new ThreadLocal<WebDriverInstance>(){
            @Override
            protected WebDriverInstance initialValue(){
                WebDriverInstance driverInstance = new WebDriverInstance();
                driverThreadPool.add(driverInstance);
                return driverInstance;
            }
        };
    }

    public static WebDriver getDriverInstance(){
        return driverThread.get().getDriver();
    }

    @AfterMethod
    public static void clearCookies(){
        getDriverInstance().manage().deleteAllCookies();
    }

    //@After Hooks
    @AfterSuite
    public static void closeDriverObjects(){
      //  System.out.println("** Driver Instance POOL size: " + driverThreadPool.size());
        for (WebDriverInstance driverInstance : driverThreadPool){
            driverInstance.quitDriver();
        }
    }

}
