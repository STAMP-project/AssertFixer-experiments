/*
 * Copyright (C) 2013-2018 NTT DATA Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.terasoluna.gfw.functionaltest.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${selenium.waitInSecond}")
    protected int waitInSecond;

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        wait = new WebDriverWait(driver, waitInSecond);
        try {
            wait.until(invisibilityOfElementWithText(By.id("xtrack"),
                    compareXTrack));
        } catch (TimeoutException e) {
            logger.debug("XTrack hasn't change in default time");
        }
        wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
                .executeScript("return document.readyState").equals(
                        "complete"));
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        compareXTrack = driver.findElement(By.id("xtrack")).getText();
    }

}
