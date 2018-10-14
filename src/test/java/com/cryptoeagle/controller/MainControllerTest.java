package com.cryptoeagle.controller;

import com.cryptoeagle.AbstractWebController;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class MainControllerTest extends AbstractWebController {

    private static final String SOURCE_NAME = "bitcoin";
    private static final int ITEM_FROM_SOURCE = 10;

    private static final int WHITELIST_COUNT = 64;
    private static final int EVENTS_COUNT = 12;
    private static final int USERS_COUNT = 4;
    private static final int ICO_COUNT = 3;
    private static final int BLOG_COUNT = 8;

    private static final int ITEM_COUNT = 7;


    @Test
    public void welcome() throws Exception {

        mockMvc
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("icos", hasSize(ICO_COUNT)))
                .andExpect(model().attribute("icos", hasItem(
                        allOf(
                                hasProperty("name"),
                                hasProperty("logolink"),
                                hasProperty("description"),
                                hasProperty("website_link"),
                                hasProperty("rating")
                        )
                )))
                .andExpect(model().attribute("events", hasSize(5)))
                .andExpect(model().attribute("events", hasItem(
                        allOf(
                                hasProperty("title"),
                                hasProperty("coinName"),
                                hasProperty("name"),
                                hasProperty("description"),
                                hasProperty("proof"),
                                hasProperty("source"),
                                hasProperty("date_event")

                        )
                )))
                .andExpect(model().attribute("topItem", notNullValue()))
                .andExpect(model().attribute("averageItems", hasSize(2)))
                .andExpect(model().attribute("averageItems", hasItem(
                        allOf(
                                hasProperty("title"),
                                hasProperty("description"),
                                hasProperty("publishDate"),
                                hasProperty("link"),
                                hasProperty("source")

                        )
                )))
                .andExpect(model().attribute("lowerItems", hasSize(3)))
                .andExpect(model().attribute("lowerItems", hasItem(
                        allOf(
                                hasProperty("title"),
                                hasProperty("description"),
                                hasProperty("publishDate"),
                                hasProperty("link"),
                                hasProperty("source")
                        )
                )))
                .andExpect(view().name("welcome"));
    }

    @Test
    public void whitelist() throws Exception {

        mockMvc.perform(get("/whitelist"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("whiteLists", hasSize(WHITELIST_COUNT)))
                .andExpect(model().attribute("whiteLists", hasItem(
                        allOf(
                                hasProperty("status"),
                                hasProperty("name"),
                                hasProperty("logo"),
                                hasProperty("category")
                        )
                )))
                .andExpect(view().name("white-list"));

    }

    @Test
    public void news() throws Exception {

        mockMvc.perform(get("/news"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("sources", hasSize(7)))
                .andExpect(model().attribute("items", hasSize(10)))
                .andExpect(model().attribute("items", hasItem(
                        allOf(
                                hasProperty("title"),
                                hasProperty("description"),
                                hasProperty("publishDate"),
                                hasProperty("link"),
                                hasProperty("source")
                        )
                )))
                .andExpect(view().name("news-page"));
    }

    @Test
    public void newsBySource() throws Exception {

        mockMvc.perform(get("/news/" + SOURCE_NAME))
                .andExpect(status().isOk())
                .andExpect(model().attribute("sources", notNullValue()))
                .andExpect(model().attribute("items", hasSize(ITEM_FROM_SOURCE)))
                .andExpect(model().attribute("items", hasItem(
                        allOf(
                                hasProperty("title"),
                                hasProperty("description"),
                                hasProperty("publishDate"),
                                hasProperty("link"),
                                hasProperty("source")
                        )
                )))
                .andExpect(view().name("news-page"));
    }

    @Test
    public void blogs() throws Exception {

        mockMvc.perform(get("/blogs"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("blogs", hasSize(BLOG_COUNT)))
                .andExpect(model().attribute("blogs", hasItem(
                        allOf(
                                hasProperty("name"),
                                hasProperty("url"),
                                hasProperty("items"),
                                hasProperty("user")
                        )
                )))
                .andExpect(view().name("blogs"));
    }

    @Test
    public void events() throws Exception {

        mockMvc.perform(get("/events"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("events", hasSize(EVENTS_COUNT)))
                .andExpect(model().attribute("events", hasItem(
                        allOf(
                                hasProperty("title"),
                                hasProperty("coinName"),
                                hasProperty("name"),
                                hasProperty("description"),
                                hasProperty("proof"),
                                hasProperty("source"),
                                hasProperty("date_event")
                        )
                )))
                .andExpect(view().name("events-page"));
    }

    @Test
    public void admin() throws Exception {

        mockMvc.perform(get("/admin-page"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("users", hasSize(USERS_COUNT)))
                .andExpect(model().attribute("users", hasItem(
                        allOf(
                                hasProperty("name"),
                                hasProperty("email"),
                                hasProperty("password"),
                                hasProperty("roles"),
                                hasProperty("blogs")
                        )
                )))
                .andExpect(view().name("admin-page"));
    }
}