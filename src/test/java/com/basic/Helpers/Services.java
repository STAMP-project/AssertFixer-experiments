package com.basic.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        productCost = productCost.substring(0, productCost.indexOf("."));
        return productCost.replaceAll("[^\\d]", "");
        //return productCost.replaceAll("$\\.–.\\d","").replaceAll("[^\\d]", "");
    }

    public static boolean hasProducts()
    {
        boolean status = false;
        try {
            Thread.sleep(2000);
            if (browser.findElement(By.className("filter-1quogC")).isDisplayed() && Services.getAllLinks("/catalog/products/").size() > 2 ) status = true;
        } catch (Exception ignored) {}
        return status;
    }

    public static int getTotalPrice()
    {
        String cardTotalPrice__selector =
                "#app > div.container.content > div.cartProducts-1QD32Q > div.cart-bar > div:nth-child(1) > div > div:nth-child(2)";
        String cardTotalPrice = browser.findElement(By.cssSelector(cardTotalPrice__selector)).getText().replaceAll("[^\\d]", "");
        return Integer.parseInt(cardTotalPrice);
    }

    public static boolean cardHasProduct(String productCode)
    {
        boolean status = false;
        System.out.println(browser.findElement(By.xpath("//*[text()[contains(.,'" + productCode + "')]]")).getText());
        try {
            if (browser.findElement(By.xpath("//*[text()[contains(.,'" + productCode + "')]]")).isDisplayed())
                status = true;
        } catch (Exception ignored) {}
        return status;
    }

    public static boolean pickupStatus()
    {
        String pickupClasses = browser.findElement(By.xpath(
                "//*[@id=\"app\"]/div[3]/div[2]/form/div[6]/div[2]/div/div/label"
        )).getAttribute("class");

        if (pickupClasses.matches("is-checked"))
            return true;
        else
            return false;
    }

    public static String generateXPATH(WebElement childElement, String current) {
        String childTag = childElement.getTagName();
        if(childTag.equals("html")) {
            return "/html[1]" + current;
        }
        WebElement parentElement = childElement.findElement(By.xpath(".."));
        List<WebElement> childrenElements = parentElement.findElements(By.xpath("*"));
        int count = 0;
        for(int i=0;i<childrenElements.size(); i++) {
            WebElement childrenElement = childrenElements.get(i);
            String childrenElementTag = childrenElement.getTagName();
            if(childTag.equals(childrenElementTag)) {
                count++;
            }
            if(childElement.equals(childrenElement)) {
                return generateXPATH(parentElement, "/" + childTag + "[" + count + "]"+current);
            }
        }
        return null;
    }
}
