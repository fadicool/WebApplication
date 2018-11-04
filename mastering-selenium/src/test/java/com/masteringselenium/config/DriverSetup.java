package com.masteringselenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Johannes on 11/3/2018.
 */
public interface DriverSetup {

    WebDriver getWebDriverInstance(DesiredCapabilities desiredCapabilities);

    DesiredCapabilities getDesiredCapabilities();

}
