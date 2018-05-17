package com.github.goive.steamapi.data;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SteamAppConvenienceMethodsTest {

    private SteamApp steamApp;

    @Before
    public void setup() {
        SteamApp.Price price = createPrice(0, 0, 0);
        steamApp = createSteamApp(price);
    }

    @Test
    public void f2pGameShouldNotBeDiscounted() {
        assertTrue(steamApp.isFreeToPlay());
        assertFalse(steamApp.isDiscounted());
        assertFalse(steamApp.isDiscountedByAtLeast(10));
    }

    @Test
    public void notDiscountedGameShouldNotBeDiscounted() {
        SteamApp.Price price = createPrice(0, 10, 10);
        steamApp = createSteamApp(price);

        assertFalse(steamApp.isDiscounted());
        assertFalse(steamApp.isDiscountedByAtLeast(10));
        assertFalse(steamApp.isFreeToPlay());
    }

    @Test
    public void discountedGameShouldBeDiscounted() {
        SteamApp.Price price = createPrice(50, 5, 10);
        steamApp = createSteamApp(price);

        assertFalse(steamApp.isFreeToPlay());
        assertTrue(steamApp.isDiscounted());
        assertTrue(steamApp.isDiscountedByAtLeast(50));
        assertFalse(steamApp.isDiscountedByAtLeast(51));
    }

    @Test
    public void fullyDiscountedGameShouldBeF2P() {
        SteamApp.Price price = createPrice(100, 0, 10);
        steamApp = createSteamApp(price);

        assertTrue(steamApp.isFreeToPlay());
        assertTrue(steamApp.isDiscounted());
        assertTrue(steamApp.isDiscountedByAtLeast(75));
    }

    @Test(expected = IllegalArgumentException.class)
    public void discountedCheckShouldNotAllowLowerThan0Percentage() {
        steamApp.isDiscountedByAtLeast(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void discountedCheckShouldNotAllowHigherThan100Percentage() {
        steamApp.isDiscountedByAtLeast(101);
    }

    @Test
    public void shouldContainAnyCategory() {
        assertTrue(steamApp.isInAnyCategory("c1"));
        assertTrue(steamApp.isInAnyCategory("c2", "c1"));
        assertFalse(steamApp.isInAnyCategory("c3"));
        assertFalse(steamApp.isInAnyCategory());
    }

    @Test
    public void shouldCheckIfCheaperThanTargetPrice() {
        SteamApp.Price price = createPrice(0, 10, 10);
        steamApp = createSteamApp(price);

        assertFalse(steamApp.isCheaperThan(BigDecimal.valueOf(5)));
        assertFalse(steamApp.isCheaperThan(BigDecimal.valueOf(10.0)));
        assertTrue(steamApp.isCheaperThan(BigDecimal.valueOf(10.01)));

        assertFalse(steamApp.isCheaperThan(5.0));
        assertFalse(steamApp.isCheaperThan(10.0));
        assertTrue(steamApp.isCheaperThan(10.01));

        assertFalse(steamApp.isCheaperThan(5));
        assertFalse(steamApp.isCheaperThan(10));
        assertTrue(steamApp.isCheaperThan(11));
    }

    @Test
    public void shouldCheckIfCheaperThanOtherSteamApp() {
        SteamApp cheaperApp = createSteamApp(createPrice(0, 10, 10));
        SteamApp expensiveApp = createSteamApp(createPrice(0, 50, 50));

        assertTrue(cheaperApp.isCheaperThan(expensiveApp));
        assertFalse(expensiveApp.isCheaperThan(cheaperApp));
        assertFalse(cheaperApp.isCheaperThan(cheaperApp));
    }

    private SteamApp.Price createPrice(int discount, int finalPrice, int initialPrice) {
        return new SteamApp.Price(Currency.getInstance("USD"),
                BigDecimal.valueOf(initialPrice),
                BigDecimal.valueOf(finalPrice),
                discount);
    }

    private SteamApp createSteamApp(SteamApp.Price price) {
        return new SteamApp("1", "type", "name", 1, "desc", "about", Arrays.asList("l1", "l2"), "headerimage",
                "website", price, Arrays.asList("dev1"), Arrays.asList("publisher1"), true, true, false,
                Arrays.asList("c1", "c2"), new Date(), 75, "metaUrl", "supportUrl", "supportMail",
                Arrays.asList("gen1"));
    }


}