package com.masteringselenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by Laptop on 11/2/2018.
 */
public class BasicTest {

    private void googleSearch(final String searchterm){

        System.setProperty("webdriver.chrome.driver","C:/Users/Laptop/Downloads/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver= new ChromeDriver(); ;
        driver.get("http://www.google.com/");

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys(searchterm);

        System.out.println("Page title is: " + driver.getTitle());

        searchField.submit();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driverObject){
                return driverObject.getTitle().toLowerCase().startsWith(searchterm.toLowerCase());
            }
        });

        System.out.println();

        driver.quit();
    }

    @Test
    public void googleCheeseSearch(){
        googleSearch("Cheese");
    }

    @Test
    public void googleMilkSearch(){
        googleSearch("Milk");
    }

}
