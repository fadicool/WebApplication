package com.masteringselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by Johannes on 11/3/2018.
 */
public class BaseTestWD extends DriverFactory {

    private void googleSearch(final String searchterm){

//        System.setProperty("webdriver.chrome.driver","C:/Users/Laptop/Downloads/chromedriver_win32 (1)/chromedriver.exe");
//        WebDriver driver= new ChromeDriver();
        WebDriver driver = DriverFactory.getDriverInstance();
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
    }

    @Test
    public void googleCheeseSearch(){
        googleSearch("Cheese");
    }

    @Test
    public void googleMilkSearch(){
        googleSearch("Milk");
    }

//    @Test
    public void googleOrangeSearch(){
        googleSearch("Orange");
    }

//    @Test
    public void googleToysSearch(){
        googleSearch("Toys");
    }

}
