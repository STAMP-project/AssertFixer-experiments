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

public class EventRestControllerTest extends AbstractWebController {

    private static final int EVENTS_COUNT = 12;

    private static final String PATH = "/api/";

    @Test
    public void retrieveAllEvents() throws Exception {
        mockMvc.perform(get(PATH + "events"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(EVENTS_COUNT)))
                .andExpect(jsonPath("$[0].title", notNullValue()))
                .andExpect(jsonPath("$[0].coinName", notNullValue()))
                .andExpect(jsonPath("$[0].name", notNullValue()))
                .andExpect(jsonPath("$[0].description", notNullValue()))

                .andExpect(jsonPath("$[0].proof", notNullValue()))
                .andExpect(jsonPath("$[0].source", notNullValue()))
                .andExpect(jsonPath("$[0].twitter", notNullValue()))

                .andExpect(jsonPath("$[0].date_event", notNullValue()));
    }
}