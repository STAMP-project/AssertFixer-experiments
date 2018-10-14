package com.cryptoeagle.rest;

import com.cryptoeagle.AbstractWebController;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ItemRestControllerTest extends AbstractWebController {

    private static final String PATH = "/api/";

    private static final String SOURCE = "/walletinvestor";

    private static final String FAKE_SOURCE = "/fake";



    @Test
    public void getItems() throws Exception {
        mockMvc.perform(get(PATH + "items"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(100)))
                .andExpect(jsonPath("$[0].title", notNullValue()))
                .andExpect(jsonPath("$[0].description", notNullValue()))
                .andExpect(jsonPath("$[0].publishDate", notNullValue()))
                .andExpect(jsonPath("$[0].link", notNullValue()))
                .andExpect(jsonPath("$[0].source", notNullValue()));
    }

    @Test
    public void getItemsBySource() throws Exception {
        mockMvc.perform(get(PATH + "items" + SOURCE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(10)))
                .andExpect(jsonPath("$[0].title", notNullValue()))
                .andExpect(jsonPath("$[0].description", notNullValue()))
                .andExpect(jsonPath("$[0].publishDate", notNullValue()))
                .andExpect(jsonPath("$[0].link", notNullValue()))
                .andExpect(jsonPath("$[0].source", notNullValue()));
    }

    @Test
    public void getItemsBySourceNotFound() throws Exception {
        mockMvc.perform(get(PATH + "items" + FAKE_SOURCE))
                .andExpect(status().isNotFound());
    }
}