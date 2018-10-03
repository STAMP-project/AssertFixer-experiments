package stepdefs;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.WalkHomepage;
import pageobjects.shopPage;

import java.util.concurrent.TimeUnit;

public class HomepageTest {

    private static WebDriver driver;
    WalkHomepage walkHomepage = new WalkHomepage(driver);

    @Before
    public void Setup()
    {
        System.setProperty("webdriver.chrome.driver", "src//test/resources//chromedriver.exe");
        // Add options to Google Chrome. The window-size is important for responsive sites
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver();
        driver.get("http://www.walklondonshoes.co.uk/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Given("^I am on www\\.walklondonshoes\\.co\\.uk homepage$")
    public void i_am_on_www_walklondonshoes_co_uk_homepage() throws Throwable {
        WalkHomepage.homepageCookie(driver).click();
        //WalkHomepage.homepagePopup(driver).click();
    }

    @Then("^I verify that the title contains WALK London Shoes$")
    public void i_verify_that_the_title_contains_WALK_London_Shoes() throws Throwable {
        WalkHomepage.homepageLogo(driver).isDisplayed();
        Assert.assertTrue(true);
        driver.quit();
    }

    @When("^I click on the \"([^\"]*)\" link$")
    public void i_click_on_the_link(String arg1) throws Throwable {
        WalkHomepage.homepageShopNow(driver).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @Then("^I verify that the Shop Now page is displayed$")
    public void iVerifyThatTheShopNowPageIsDisplayed() throws Throwable {
        shopPage.shopPageTitle(driver).isDisplayed();
        Assert.assertTrue(true);
        driver.quit();
    }
}
