package com.atos.cucumberdemo.step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Vincent Free on 21-3-2015.
 */
public class SelToCucSteps {

    private final WebDriver webDriver;

    public SelToCucSteps(SharedDriver webDriver){
        this.webDriver = webDriver;
        //this.driver = new driver;

    }
    @Given("^I am on the Google search page$")
    public void I_visit_google(){
        //WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vincent\\Downloads\\chromedriver_win32\\chromedriver.exe");
        webDriver.get("http://www.google.com");

    }

    @When("^I search for \"([^\"]*)\"$")
    public void search_for(String query){
        WebElement element = webDriver.findElement(By.name("q"));
        //Enter something to search for
        element.sendKeys(query);
        //Submit the form. Webdriver finds the form from element
        element.submit();
    }

    @Then("^the page title should start with \"([^\"]*)\"$")
    public void checkTitle(final String title) {
        (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
            //@Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(title);
            }
        });
        //assertThat(driver.getTitle().startsWith(title));
    }
      /*  @After()
        public void closeBrowser(){
            webDriver.quit();
        }*/

    @When("^the page title should start with this \"([^\"]*)\"$")
    public void the_page_title_should_start_with_this(final String searchQuery) {
            (new WebDriverWait(webDriver, 10)).until(new ExpectedCondition<Boolean>() {
                //@Override
                public Boolean apply(WebDriver d) {
                    return d.getTitle().toLowerCase().startsWith(searchQuery);
                }
            });

    }

    @When("^I search for this\"([^\"]*)\"$")
    public void I_search_for_this(String searchQuery) {
        WebElement element = webDriver.findElement(By.name("q"));
        //Enter something to search for
        element.sendKeys(searchQuery);
        //Submit the form. Webdriver finds the form from element
        element.submit();
    }


}
