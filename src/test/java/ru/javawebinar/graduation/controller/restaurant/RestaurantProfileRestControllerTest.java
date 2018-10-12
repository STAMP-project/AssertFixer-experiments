package ru.javawebinar.graduation.controller.restaurant;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import ru.javawebinar.graduation.controller.AbstractControllerTest;
import ru.javawebinar.graduation.util.DateTimeUtil;
import ru.javawebinar.graduation.util.exception.ErrorType;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.javawebinar.graduation.RestaurantTestData.*;
import static ru.javawebinar.graduation.TestUtil.*;
import static ru.javawebinar.graduation.UserTestData.ADMIN;
import static ru.javawebinar.graduation.UserTestData.USER;
import static ru.javawebinar.graduation.util.exception.VoteTimeExpiredException.*;

class RestaurantProfileRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RestaurantProfileRestController.REST_URL + '/';

    @Test
    void testGetUnAuth() throws Exception {
        mockMvc.perform(get(REST_URL + RESTAURANT_ONE_ID))
                .andExpect(status().isUnauthorized());
    }


    @Test
    void testGetAllWithMealsByToday() throws Exception {
        mockMvc.perform(get(REST_URL)
                .with(userHttpBasic(USER)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJson(getAllRestaurantWithMeals()));
    }

    @Test
    void testChoice() throws Exception {
        ResultActions actions = mockMvc.perform(post(REST_URL)
                .param("restaurantId", String.valueOf(RESTAURANT_THREE_ID))
                .with(userHttpBasic(USER)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(print());

        String contentBody = readFromJson(actions, String.class);
        assertThat(contentBody).isEqualTo(messageUtil.getMessage(SUCCESSFULLY_VOTED) + RESTAURANT_THREE_ID);
    }

    @Test
    void testChoiceReVote() throws Exception {
        DateTimeUtil.TIME_END_VOTING = LocalTime.of(23, 59);

        ResultActions actions =mockMvc.perform(post(REST_URL)
                .param("restaurantId", String.valueOf(RESTAURANT_TWO_ID))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(print());

        String contentBody = readFromJson(actions, String.class);
        assertThat(contentBody).isEqualTo(messageUtil.getMessage(SUCCESSFULLY_VOTED) + RESTAURANT_TWO_ID);
    }

    @Test
    void testChoiceTimeIsUpReVote() throws Exception {
        DateTimeUtil.TIME_END_VOTING = LocalTime.of(11, 0);
        mockMvc.perform(post(REST_URL)
                .param("restaurantId", String.valueOf(RESTAURANT_THREE_ID))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isNotAcceptable())
                .andExpect(errorType(ErrorType.APP_ERROR))
                .andExpect(jsonMessage("$.details", TIME_IS_UP_EXCEPTION))
                .andDo(print());
    }

    @Test
    void testChoiceBadVote() throws Exception {
        ResultActions actions = mockMvc.perform(post(REST_URL)
                .param("restaurantId", "10")
                .with(userHttpBasic(USER)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andDo(print());

        String contentBody = readFromJson(actions, String.class);
        assertThat(contentBody).isEqualTo(messageUtil.getMessage(UNSUCCESSFULLY_VOTED));
    }

}