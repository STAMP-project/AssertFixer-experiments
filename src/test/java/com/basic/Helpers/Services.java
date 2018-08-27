package com.basic.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.basic.Actionwords.browser;

public class Services {
    public static ArrayList getAllLinks(String mask)
    {
        ArrayList itemLinks = new ArrayList();
        List<WebElement> products = browser.findElements(By.tagName("a"));
        for (WebElement product:products)
        {
            String href = product.getAttribute("href");
            if (!mask.equals("")) {
                if (href.contains(mask)) itemLinks.add(href);
            }
            else itemLinks.add(href);
        }
        return itemLinks;
    }

    public static int getRandomNumber(int min, int max)
    {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static String getProductCode()
    {
        String code = browser.findElement(By.xpath("//*[@id=\"app\"]/div[3]/section[1]/div/div[3]/div[2]/div/div[4]")).getText();
        return code.replaceAll("([A-Za-zА-Яа-я: ])", "");
    }

    public static String getProductName()
    {
        return "asd";
    }

    public static String getProductPrice()
    {
        String productCost = browser.findElement(By.xpath("//*[@id=\"app\"]/div[3]/section[1]/div/div[3]/div[2]/div/div[1]/div")).getText();
        return productCost;
    }
}
