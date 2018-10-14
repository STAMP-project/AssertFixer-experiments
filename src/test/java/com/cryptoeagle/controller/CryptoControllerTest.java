package com.cryptoeagle.controller;

import com.cryptoeagle.AbstractWebController;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CryptoControllerTest extends AbstractWebController {

    private static final String ICO_NANE = "Virtual Rehab";
    private static final String SYMBOL = "ETH";

    @Test
    public void icoStats() throws Exception {

        mockMvc.perform(get("/ico-stats"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("icos", hasSize(8)))
                .andExpect(view().name("ico-stats"));
    }

    @Test
    public void icoList() throws Exception {

        mockMvc.perform(get("/ico-list"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("activeIco", hasSize(3)))
                .andExpect(model().attribute("activeIco", hasItem(

                        allOf(
                                hasProperty("name"),
                                hasProperty("logolink"),
                                hasProperty("description"),
                                hasProperty("website_link"),
                                hasProperty("rating")

                        )

                )))
                .andExpect(model().attribute("upcoming", hasSize(5)))
                .andExpect(model().attribute("upcoming", hasItem(

                        allOf(
                                hasProperty("name"),
                                hasProperty("logolink"),
                                hasProperty("description"),
                                hasProperty("website_link"),
                                hasProperty("rating")

                        )

                )))
                .andExpect(model().attribute("finished", hasSize(0)))
                .andExpect(view().name("ico-list"));
    }

    @Test
    public void icoListActive() throws Exception {

        mockMvc.perform(get("/ico-list/active"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("icos", hasSize(3)))
                .andExpect(model().attribute("icos", hasItem(

                        allOf(
                                hasProperty("name"),
                                hasProperty("logolink"),
                                hasProperty("description"),
                                hasProperty("website_link"),
                                hasProperty("rating")
                        )
                )))
                .andExpect(view().name("ico-category"));
    }

    @Test
    public void icoListUpcoming() throws Exception {

        mockMvc.perform(get("/ico-list/upcoming"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("icos", hasSize(5)))
                .andExpect(model().attribute("icos", hasItem(

                        allOf(
                                hasProperty("name"),
                                hasProperty("logolink"),
                                hasProperty("description"),
                                hasProperty("website_link"),
                                hasProperty("rating")
                        )
                )))
                .andExpect(view().name("ico-category"));
    }

    @Test
    public void icoListFinished() throws Exception {

        mockMvc.perform(get("/ico-list/finished"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("icos", hasSize(0)))
                .andExpect(view().name("ico-category"));
    }

    @Test
    public void coinList() throws Exception {

        mockMvc.perform(get("/coin-list"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("coins", hasSize(10)))
                .andExpect(model().attribute("coins", hasItem(

                        allOf(
                                hasProperty("name"),
                                hasProperty("image"),
                                hasProperty("symbol"),
                                hasProperty("rank"),
                                hasProperty("circulating_supply"),
                                hasProperty("volume_24h"),
                                hasProperty("market_cap"),
                                hasProperty("percent_change_1h"),
                                hasProperty("percent_change_7d"),
                                hasProperty("percent_change_24h")
                        )
                )))
                .andExpect(view().name("coin-list"));
    }

    @Test
    public void icoPage() throws Exception {

        mockMvc.perform(get("/ico-page/" + ICO_NANE))
                .andExpect(status().isOk())
                .andExpect(model().attribute("ico", notNullValue()))
                .andExpect(model().attribute("ico", notNullValue()))
                .andExpect(model().attribute("ico", hasProperty("name")))
                .andExpect(model().attribute("ico", hasProperty("logolink")))
                .andExpect(model().attribute("ico", hasProperty("description")))
                .andExpect(model().attribute("ico", hasProperty("website_link")))
                .andExpect(model().attribute("ico", hasProperty("rating")))
                .andExpect(model().attribute("ico", hasProperty("preIcoStart")))
                .andExpect(model().attribute("ico", hasProperty("preIcoEnd")))
                .andExpect(model().attribute("ico", hasProperty("icoStart")))
                .andExpect(model().attribute("ico", hasProperty("data")))

                .andExpect(view().name("ico-page"));
    }

    @Test
    public void coinPage() throws Exception {

        mockMvc.perform(get("/coin-page/" + SYMBOL))
                .andExpect(status().isOk())
                .andExpect(model().attribute("coin", notNullValue()))
                .andExpect(model().attribute("coin", hasProperty("name")))
                .andExpect(model().attribute("coin", hasProperty("image")))
                .andExpect(model().attribute("coin", hasProperty("symbol")))
                .andExpect(model().attribute("coin", hasProperty("rank")))
                .andExpect(model().attribute("coin", hasProperty("circulating_supply")))
                .andExpect(model().attribute("coin", hasProperty("volume_24h")))
                .andExpect(model().attribute("coin", hasProperty("market_cap")))
                .andExpect(model().attribute("coin", hasProperty("market_cap")))
                .andExpect(model().attribute("coin", hasProperty("percent_change_1h")))
                .andExpect(model().attribute("coin", hasProperty("percent_change_7d")))
                .andExpect(model().attribute("coin", hasProperty("percent_change_24h")))

                .andExpect(view().name("coin-page"));
    }

}