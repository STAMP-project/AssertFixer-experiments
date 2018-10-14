package com.cryptoeagle.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class WhiteListTest {

    private static final String LONG_NAME = "Binance Coin";
    private static final String SHORT_NAME = "ETH";

    private static final WhiteList WHITELIST1 = new WhiteList();
    private static final WhiteList WHITELIST2 = new WhiteList();


    static {

        WHITELIST1.setName(LONG_NAME);
        WHITELIST1.setStatus("active");
        WHITELIST1.setCategory("test_category");
        WHITELIST1.setLogo("testlogo");


        WHITELIST2.setName(SHORT_NAME);
        WHITELIST2.setStatus("active");
        WHITELIST2.setCategory("test_category");
        WHITELIST2.setLogo("testlogo");

    }


    @Test
    public void compareTo() {

        int i = WHITELIST1.compareTo(WHITELIST2);

        assertTrue(i > 0);

    }
}