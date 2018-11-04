package stepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



/**
 * Created by Johannes on 11/4/2018.
 */

public class userSearchStepDef {

    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:/Users/Laptop/Downloads/chromedriver_win32 (1)/chromedriver.exe");
        driver=new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("^I am on a browser$")
    public void I_am_on_a_browser() throws Throwable {
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
    }

    @When("^I enter a search term ([^\\\"]*) in the searchbox and submit$")
    public void I_enter_a_search_term_cheese_in_the_searchbox_and_submit(String searchTerm) throws Throwable {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchTerm);
        searchBox.submit();

//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("return document.readyState").equals("complete");

        ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
    }

//    @Then("^I should be taken to the search results page$")
//    public void I_should_be_taken_to_the_search_results_page() throws Throwable {
//        String pageTitle = driver.getTitle();
//        System.out.println("Page Title is: " + pageTitle);
//        Assert.assertTrue("ERROR page is NOT the same as Expected", pageTitle.equalsIgnoreCase("cheese - Google Search"));
//    }

    @Then("^I should be taken to the search results page with page title containing ([^\\\"]*)$")
    public void I_should_be_taken_to_the_search_results_page_with_page_title_containing_searchterm(String searchTerm) throws Throwable {
        String pageTitle = driver.getTitle();
        System.out.println("Page Title is: " + pageTitle);
        Assert.assertTrue("ERROR page is NOT the same as Expected", pageTitle.equalsIgnoreCase(searchTerm +" - Google Search"));
    }

}
