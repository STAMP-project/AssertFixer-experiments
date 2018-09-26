package com.bindstone.portfolio.rest;

import com.bindstone.portfolio.entity.Currency;
import com.bindstone.portfolio.factories.CurrencyFactory;
import com.bindstone.portfolio.mapper.dto.CurrencyDto;
import com.bindstone.portfolio.service.CurrencyService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class CurrencyRestTest extends AbstractRestTest {

    private static final String ROOT = "/api/currency/";
    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    private CurrencyService currencyService;

    private Currency testValue;

    @Before
    public void tearDown() {
        System.out.println("Test execution port:" + port);
        RestAssured.port = port;
        RestAssuredMockMvc.webAppContextSetup(wac);

        testValue = currencyService.save(CurrencyFactory.CURRENCY_1());
    }

    @Test
    public void getCurrencies() throws Exception {
        Assert.assertNotNull("Service validation", currencyService);

        RestAssuredMockMvc
                .get(ROOT)
                .then().statusCode(200);
    }

    @Test
    public void getCurrency() throws Exception {
        Assert.assertNotNull("Service validation", currencyService);

        RestAssuredMockMvc
                .get(ROOT + testValue.getId())
                .then().statusCode(200);
    }

    @Test
    public void putCurrency() throws Exception {
        Assert.assertNotNull("Service validation", currencyService);
        CurrencyDto value = CurrencyDto.builder().iso("TT1").name("Test").build();

        RestAssuredMockMvc
                .given().contentType(ContentType.JSON).body(value)
                .when()
                .put(ROOT)
                .then().statusCode(200);
    }

    @Test
    public void postCurrency() throws Exception {
        Assert.assertNotNull("Service validation", currencyService);
        CurrencyDto value = CurrencyDto.builder().iso("TT2").name("Test").build();

        RestAssuredMockMvc
                .given().contentType(ContentType.JSON).body(value)
                .when()
                .post(ROOT)
                .then().statusCode(200);
    }

    @Test
    public void deleteCurrency() throws Exception {
        Assert.assertNotNull("Service validation", currencyService);

        RestAssuredMockMvc
                .delete(ROOT + testValue.getId())
                .then().statusCode(200);
    }
}
