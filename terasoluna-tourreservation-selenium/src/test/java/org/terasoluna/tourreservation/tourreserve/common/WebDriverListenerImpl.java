package org.terasoluna.tourreservation.tourreserve.common;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

public class WebDriverListenerImpl implements WebDriverEventListener {

    @Value("${selenium.WebDriverWait}")
    protected long WebDriverWait;

    @Value("${selenium.WebDriverSleepWait}")
    protected long WebDriverSleepWait;

    protected Wait<WebDriver> wait = null;

    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        wait = new WebDriverWait(driver, 1, 500);
        try {
            wait.until(
                    (ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                            .executeScript("return document.readyState").equals(
                                    "loading"));
            wait.until(
                    (ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                            .executeScript("return document.readyState").equals(
                                    "complete"));
        } catch (TimeoutException e) {
            logger.debug("loading is not done");
        }
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver,
            CharSequence[] keysToSend) {
        // TODO Auto-generated method stub
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver,
            CharSequence[] keysToSend) {
        // TODO Auto-generated method stub
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        // TODO Auto-generated method stub

    }

}
