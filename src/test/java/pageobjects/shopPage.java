package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class shopPage {

    private static WebElement element = null;
    public static WebDriver driver;

    public shopPage(WebDriver driver) {
        shopPage.driver = driver;
    }

    public static WebElement shopPageFreeShippingBar(WebDriver driver) {
        element = driver.findElement(By.className("sqs-announcement-bar-url"));
        return element;
    }

    public static WebElement shopPageTitle(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"block-yui_3_17_2_1_1522143358338_813772\"]/div/p/strong"));
        return element;
    }
}
