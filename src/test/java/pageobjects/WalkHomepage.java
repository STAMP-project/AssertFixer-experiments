package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WalkHomepage {

    private static WebElement element = null;
    public static WebDriver driver;

    public WalkHomepage(WebDriver driver) {
        WalkHomepage.driver = driver;
    }

    //logo
    public static WebElement homepageLogo(WebDriver driver) {
        element = driver.findElement(By.className("Mobile-bar-branding-logo"));
        return element;
    }

    public static WebElement homepageCookie(WebDriver driver) {
        element = driver.findElement(By.className("accept"));
        return element;
    }

    public static WebElement homepagePopup(WebDriver driver) {
        element = driver.findElement(By.className("sqs-popup-overlay-close"));
        return element;
    }

    public static WebElement homepageShopNow(WebDriver driver) {
        element = driver.findElement(By.className("sqs-block-button-element"));
        return element;
    }

}
