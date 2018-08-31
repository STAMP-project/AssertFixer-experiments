package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class HelloWorld {

    private Eyes eyes;
    private WebDriver driver;


    @BeforeTest
    public void initialize() throws MalformedURLException {

        eyes = new Eyes();
        // obtain the API key from an environment variable and set it
        String apiKey = System.getenv("APPLITOOLS_API_KEY");
        eyes.setApiKey(apiKey);

        String SAUCE_USER = System.getenv("SAUCE_USER");
        String SAUCE_KEY= System.getenv("SAUCE_KEY");
        String Url = "http://" + SAUCE_USER + ":" + SAUCE_KEY + "@ondemand.saucelabs.com:80/wd/hub";
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "macOS 10.12");
        caps.setCapability("version", "64.0");
        caps.setCapability("screenResolution", "1280x960");
        
        
        // obtain the ID from the environment variables - the name should be specified as null
        String batchName = null;
        String batchId   = System.getenv("APPLITOOLS_BATCH_ID");
        //String batchId   = "hellot";

        // set the batch
        BatchInfo batchInfo = new BatchInfo(batchName);
        batchInfo.setId(batchId);
        eyes.setBatch(batchInfo);
        driver = new RemoteWebDriver(new URL(Url), caps);

    }

    @Test
    public void test() {

        eyes.open(driver, "Applitools-HelloWorld", "GithubDemoTests", new RectangleSize(800, 600));

        driver.navigate().to("https://applitools.com/helloworld?diff1");

        eyes.checkWindow("VisualCheck_1");

        driver.findElement(By.tagName("button")).click();

        eyes.checkWindow("VisualCheck_2");

        eyes.close(false);

    }

    @AfterTest
    public void cleanup(){
        eyes.abortIfNotClosed();
        driver.quit();
    }

}
