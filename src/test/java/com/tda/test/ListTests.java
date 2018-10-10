package com.tda.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by jet533 on 9/18/2018.
 */
public class ListTests {

    @Test(groups="FunTest")
    void Test1()
    {
        System.out.println("Test1");
    }

    @Test
    public void Test2() throws IOException {
        System.out.println("Inside Test");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("user","tradereqa1@tdameritrade.com");
        capabilities.setCapability("password","trader9033");
        capabilities.setCapability("deviceName","FA7BR1A03387");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("manufacturer", "Google");
        capabilities.setCapability("browserName","Chrome");
       AppiumDriver driver=new AndroidDriver(new URL("https://tda.perfectomobile.com//nexperience/perfectomobile/wd/hub" ),capabilities);
       driver.get("https://qualitykiosk.com/");
       System.out.println("Loaded with Qualitykiosk site");
       String pageTitle=driver.getCurrentUrl();
        Assert.assertEquals(pageTitle,"https://qualitykiosk.com/");
        driver.get("http://www.google.com");
        System.out.println("Loaded with google.com");
        driver.quit();


    }

}
