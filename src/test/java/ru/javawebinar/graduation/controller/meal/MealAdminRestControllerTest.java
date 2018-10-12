package ru.javawebinar.graduation.controller.meal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.graduation.MealTestData;
import ru.javawebinar.graduation.controller.AbstractControllerTest;
import ru.javawebinar.graduation.controller.json.JsonUtil;
import ru.javawebinar.graduation.controller.restaurant.RestaurantAdminRestController;
import ru.javawebinar.graduation.model.Meal;
import ru.javawebinar.graduation.service.MealService;
import ru.javawebinar.graduation.util.exception.ErrorType;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.javawebinar.graduation.MealTestData.*;
import static ru.javawebinar.graduation.RestaurantTestData.RESTAURANT_ONE_ID;
import static ru.javawebinar.graduation.TestUtil.*;
import static ru.javawebinar.graduation.UserTestData.ADMIN;
import static ru.javawebinar.graduation.controller.ExceptionInfoHandler.EXCEPTION_MEAL_DUPLICATE_NAME_TODAY;

class MealAdminRestControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RestaurantAdminRestController.REST_URL + '/' + RESTAURANT_ONE_ID + "/meals/";

    @Autowired
    private MealService service;

    @Test
    void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + MEAL1_ID)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJson(MEAL1));
    }

    @Test
    void testGetNotFound() throws Exception {
        mockMvc.perform(get(REST_URL + MEAL_NO_EXIST_ID)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void testGetUnAuth() throws Exception {
        mockMvc.perform(get(REST_URL + MEAL1_ID))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + MEAL1_ID)
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isNoContent());
        MealTestData.assertMatch(service.getAll(RESTAURANT_ONE_ID), MEAL2, MEAL3);
    }

    @Test
    void testDeleteNotFound() throws Exception {
        mockMvc.perform(delete(REST_URL + MEAL_NO_EXIST_ID)
                .with(userHttpBasic(ADMIN)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    void testUpdate() throws Exception {
        Meal updated = getUpdated();

        mockMvc.perform(put(REST_URL + MEAL1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated))
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isNoContent());

        MealTestData.assertMatch(service.get(MEAL1_ID, RESTAURANT_ONE_ID), updated);
    }

    @Test
    void testCreate() throws Exception {
        Meal created = getCreated();
        ResultActions action = mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(created))
                .with(userHttpBasic(ADMIN)));

        Meal returned = readFromJson(action, Meal.class);
        created.setId(returned.getId());

        MealTestData.assertMatch(returned, created);
        MealTestData.assertMatch(service.getAll(RESTAURANT_ONE_ID), MEAL1, MEAL2, MEAL3, created);
    }

    @Test
    void testCreateWithIllegalRequestData() throws Exception {
        mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .with(userHttpBasic(ADMIN))
                .content(JsonUtil.writeValue(MEAL1)))
                .andExpect(status().isUnprocessableEntity())
                .andExpect(errorType(ErrorType.VALIDATION_ERROR))
                .andDo(print());
    }

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL + "history")
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJsonArray(MEAL1, MEAL2, MEAL3));
    }

    @Test
    void testGetAllByToday() throws Exception {
        mockMvc.perform(get(REST_URL + "today")
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJsonArray(MEAL1, MEAL2, MEAL3));
    }

    @Test
    void testGetAllByDate() throws Exception {
        mockMvc.perform(get(REST_URL + "byDate")
                .param("date", LocalDate.now().toString())
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJsonArray(MEAL1, MEAL2, MEAL3));
    }

    @Test
    void testGetAllFilter() throws Exception {
        mockMvc.perform(get(REST_URL + "filter")
                .param("startDate", LocalDate.now().toString()).param("endDate", LocalDate.now().toString())
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(contentJsonArray(MEAL1, MEAL2, MEAL3));
    }

    @Test
    void testGetAllFilterAll() throws Exception {
        mockMvc.perform(get(REST_URL + "filter?startDate=&endDate=")
                .with(userHttpBasic(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(contentJsonArray(MEAL1, MEAL2, MEAL3));
    }

    @Test
    void testUpdateHtmlUnsafe() throws Exception {
        Meal invalid = new Meal(MEAL1_ID, "<script>alert(123)</script>", new BigDecimal("6.00"));
        mockMvc.perform(put(REST_URL + MEAL1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid))
                .with(userHttpBasic(ADMIN)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(errorType(ErrorType.VALIDATION_ERROR))
                .andDo(print());
    }


    @Test
    void testCreateInvalid() throws Exception {
        Meal invalid = new Meal("", new BigDecimal("2.50"));
        mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid))
                .with(userHttpBasic(ADMIN)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(errorType(ErrorType.VALIDATION_ERROR))
                .andDo(print());
    }


    @Test
    void testUpdateInvalid() throws Exception {
        Meal invalid = new Meal(MEAL1_ID, "Updated meal", null);
        mockMvc.perform(put(REST_URL + MEAL1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid))
                .with(userHttpBasic(ADMIN)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(errorType(ErrorType.VALIDATION_ERROR))
                .andDo(print());
    }

    @Test
    @Transactional(propagation = Propagation.NEVER)
    void testUpdateDuplicate() throws Exception {
        Meal invalid = new Meal(MEAL1_ID, MEAL2.getName(), new BigDecimal("1.50"));

        mockMvc.perform(put(REST_URL + MEAL1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid))
                .with(userHttpBasic(ADMIN)))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(errorType(ErrorType.VALIDATION_ERROR))
                .andExpect(jsonMessage("$.details", EXCEPTION_MEAL_DUPLICATE_NAME_TODAY));
    }

    @Test
    @Transactional(propagation = Propagation.NEVER)
    void testCreateDuplicate() throws Exception {
        Meal invalid = new Meal(MEAL2.getName(), new BigDecimal("2.00"));
        mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid))
                .with(userHttpBasic(ADMIN)))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(errorType(ErrorType.VALIDATION_ERROR))
                .andExpect(jsonMessage("$.details", EXCEPTION_MEAL_DUPLICATE_NAME_TODAY));
    }
}