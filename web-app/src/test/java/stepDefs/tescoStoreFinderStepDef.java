package stepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Johannes on 11/4/2018.
 */

public class tescoStoreFinderStepDef {

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

    @Given("^I am on Tesco's website$")
    public void I_am_on_Tesco_s_website() throws Throwable {
        driver.get("https://www.tesco.com");
        driver.manage().window().maximize();
    }

    @When("^I click the FindStore tab$")
    public void I_click_the_FindStore_tab() throws Throwable {
        WebElement storeFinderTag = driver.findElement(By.cssSelector("ul.utility-section li:nth-child(2) a"));
//        WebElement storeFinderTag = driver.findElement(By.linkText("Store locator"));
        storeFinderTag.click();
    }

    @When("^I enter a postcode ([^\\\"]*)$")
    public void I_enter_a_postcode_NN_FT(String postcode) throws Throwable {
        WebElement textBox = driver.findElement(By.cssSelector("input.drop-down-search-box"));
        textBox.sendKeys(postcode);

        WebElement findStoreButton = driver.findElement(By.cssSelector("button.drop-down-search-btn"));
//        WebElement findStoreButton = driver.findElement(By.linkText("Find store"));
        findStoreButton.click();
    }

    @Then("^I should see a list of stores around that postcode$")
    public void I_should_see_a_list_of_stores_around_that_postcode() throws Throwable {
        WebElement pageContext = driver.findElement(By.cssSelector("h1.heading"));
        Assert.assertTrue(pageContext.getText().contains("Store locator"));
        System.out.println("-- Page contains text: " + pageContext.getText());

    }


}
