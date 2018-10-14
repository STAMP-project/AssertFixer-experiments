package com.cryptoeagle.rest;

import com.cryptoeagle.AbstractWebController;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class IcoRestControllerTest extends AbstractWebController {

    private static final String PATH = "/api/";

    private static final String ICO_ALL = "icos/";

    private static final String ICO_UPCOMING = "icos/upcoming";
    private static final String ICO_FINISHED = "icos/finishied";
    private static final String ICO_ACTIVE = "icos/active";

    private static final String ICO_NAME = "Virtual Rehab";
    private static final String ICO_FAKE = "fake";


    @Test
    public void retrieveAllIcos() throws Exception {
        testIco(PATH + ICO_ALL, 8);
    }

    @Test
    public void retrieveUpcoming() throws Exception {
        testIco(PATH + ICO_UPCOMING, 5);
    }

    @Test
    public void retrieveFinished() throws Exception {
        mockMvc.perform(get(PATH + ICO_FINISHED))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void retrieveActive() throws Exception {
        testIco(PATH + ICO_ACTIVE, 3);
    }

    @Test
    public void getIcoWithData() throws Exception {

        mockMvc.perform(get(PATH + ICO_ALL + ICO_NAME))
                .andDo(print())
                .andExpect(status().isOk())

                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name", notNullValue()))
                .andExpect(jsonPath("$.logolink", notNullValue()))
                .andExpect(jsonPath("$.description", notNullValue()))
                .andExpect(jsonPath("$.website_link", notNullValue()))
                .andExpect(jsonPath("$.rating", notNullValue()))
                .andExpect(jsonPath("$.preIcoStart", notNullValue()))
                .andExpect(jsonPath("$.preIcoEnd", notNullValue()))
                .andExpect(jsonPath("$.icoStart", notNullValue()))
                .andExpect(jsonPath("$.icoEnd", notNullValue()))
                .andExpect(jsonPath("$.data", notNullValue()));

    }

    @Test
    public void getIcoWithDataNotFound() throws Exception {
        mockMvc.perform(get(PATH + ICO_ALL + ICO_FAKE))
                .andExpect(status().isNotFound());
    }


    private void testIco(String path, int count) throws Exception {

        mockMvc.perform(get(path))
                .andDo(print())
                .andExpect(status().isOk())

                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(count)))
                .andExpect(jsonPath("$[0].name", notNullValue()))
                .andExpect(jsonPath("$[0].logolink", notNullValue()))
                .andExpect(jsonPath("$[0].description", notNullValue()))
                .andExpect(jsonPath("$[0].website_link", notNullValue()))
                .andExpect(jsonPath("$[0].rating", notNullValue()))
                .andExpect(jsonPath("$[0].preIcoStart", notNullValue()))
                .andExpect(jsonPath("$[0].preIcoEnd", notNullValue()))
                .andExpect(jsonPath("$[0].icoStart", notNullValue()))
                .andExpect(jsonPath("$[0].icoEnd", notNullValue()));

    }

}