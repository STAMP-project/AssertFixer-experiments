package com.cryptoeagle.rest;

import com.cryptoeagle.AbstractWebController;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class CoinRestControllerTest extends AbstractWebController {

    private static final String PATH = "/api/";

    private static final String SYMBOL = "ETH";

    private static final String FAKE_SYMBOL = "FAKE";



    @Test
    public void retrieveAllCoins() throws Exception {

        mockMvc
                .perform(get(PATH + "coins"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(10)))
                .andExpect(jsonPath("$[0].id", notNullValue()))
                .andExpect(jsonPath("$[0].name", notNullValue()))
                .andExpect(jsonPath("$[0].image", notNullValue()))
                .andExpect(jsonPath("$[0].symbol", notNullValue()))
                .andExpect(jsonPath("$[0].circulating_supply", notNullValue()))
                .andExpect(jsonPath("$[0].price", notNullValue()))
                .andExpect(jsonPath("$[0].volume_24h", notNullValue()))
                .andExpect(jsonPath("$[0].market_cap", notNullValue()))
                .andExpect(jsonPath("$[0].percent_change_1h", notNullValue()))
                .andExpect(jsonPath("$[0].percent_change_7d", notNullValue()))
                .andExpect(jsonPath("$[0].percent_change_24h", notNullValue()))
                .andExpect(jsonPath("$[0].dataAvailable", notNullValue()));

    }

    @Test
    public void retrieveCoin() throws Exception {

        mockMvc.perform(get(PATH +  "coins/" + SYMBOL))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.name", notNullValue()))
                .andExpect(jsonPath("$.image", notNullValue()))
                .andExpect(jsonPath("$.symbol", notNullValue()))
                .andExpect(jsonPath("$.circulating_supply", notNullValue()))
                .andExpect(jsonPath("$.price", notNullValue()))
                .andExpect(jsonPath("$.volume_24h", notNullValue()))
                .andExpect(jsonPath("$.market_cap", notNullValue()))
                .andExpect(jsonPath("$.percent_change_1h", notNullValue()))
                .andExpect(jsonPath("$.percent_change_7d", notNullValue()))
                .andExpect(jsonPath("$.percent_change_24h", notNullValue()))
                .andExpect(jsonPath("$.dataAvailable", notNullValue()));
    }

    @Test
    public void retrieveCoinNotFound() throws Exception {

        mockMvc.perform(get(PATH +  "coins/" +  FAKE_SYMBOL))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}