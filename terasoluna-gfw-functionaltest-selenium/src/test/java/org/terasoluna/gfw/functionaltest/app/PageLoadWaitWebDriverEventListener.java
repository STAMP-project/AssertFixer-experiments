package org.terasoluna.gfw.functionaltest.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.JavascriptExecutor;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementWithText;

public class PageLoadWaitWebDriverEventListener extends
                                                WebDriverEventListenerAdapter {

    protected final Log logger = LogFactory.getLog(getClass());

    protected static Wait<WebDriver> wait;

    protected static String compareXTrack;

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        wait = new WebDriverWait(driver, 7);
        try {
            wait.until(invisibilityOfElementWithText(By.id("xtrack"),
                    compareXTrack));
        } catch (TimeoutException e) {
            logger.debug("XTrack hasn't change in default time");
        }
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd).executeScript(
                "return document.readyState").equals("complete"));
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        compareXTrack = driver.findElement(By.id("xtrack")).getText();
    }

}
