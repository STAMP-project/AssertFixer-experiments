package ru.javawebinar.graduation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.graduation.MealTestData;
import ru.javawebinar.graduation.model.Restaurant;
import ru.javawebinar.graduation.util.exception.ErrorType;
import ru.javawebinar.graduation.util.exception.NotFoundException;

import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.javawebinar.graduation.RestaurantTestData.*;

class RestaurantServiceImplTest extends AbstractServiceTest {

    @Autowired
    RestaurantService service;

    @Test
    void testCreate() {
        Restaurant created = getCreated();
        service.create(created);
        assertMatch(service.getAll(), RESTAURANT_THREE, RESTAURANT_ONE, RESTAURANT_TWO, created);
    }

    @Test
    void testDelete() throws Exception {
        service.delete(RESTAURANT_ONE_ID);
        assertMatch(service.getAll(), RESTAURANT_THREE, RESTAURANT_TWO);
    }

    @Test
    void testDeleteNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                service.delete(1));
    }

    @Test
    void testUpdate() throws Exception {
        Restaurant updated = getUpdated();
        service.update(updated);
        assertMatch(service.get(RESTAURANT_ONE_ID), updated);
    }

    @Test
    void testUpdateNotFound() throws Exception {
        Restaurant notFoundRestaurant = getUpdatedNotFound();
        NotFoundException e = assertThrows(NotFoundException.class, () -> service.update(notFoundRestaurant));
        String msg = e.getMessage();
        assertTrue(msg.contains(ErrorType.DATA_NOT_FOUND.name()));
        assertTrue(msg.contains(NotFoundException.NOT_FOUND_EXCEPTION));
        assertTrue(msg.contains(String.valueOf(notFoundRestaurant.getId())));
    }

    @Test
    void testGet() throws Exception {
        Restaurant actual = service.get(RESTAURANT_ONE_ID);
        assertMatch(actual, RESTAURANT_ONE);
    }

    @Test
    void testGetNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                service.get(getUpdatedNotFound().getId()));
    }

    @Test
    void testGetByName() throws Exception {
        Restaurant actual = service.getByName(RESTAURANT_ONE.getName());
        assertMatch(actual, RESTAURANT_ONE);
    }

    @Test
    void testGetByNameNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                service.getByName("name"));
    }

    @Test
    void testGetWithMealsByToday() throws Exception {
        Restaurant restaurantWithMeals = service.getWithMealsByToday(RESTAURANT_ONE_ID);
        assertMatch(restaurantWithMeals, RESTAURANT_ONE);
        MealTestData.assertMatch(restaurantWithMeals.getMeals(), MealTestData.MEAL1, MealTestData.MEAL2, MealTestData.MEAL3);
    }

    @Test
    void testGetWithMealsByTodayNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                service.getWithMealsByToday(getUpdatedNotFound().getId()));
    }

    @Test
    void testGetAllWithMealsByToday() throws Exception {
        List<Restaurant> restaurantsWithMeals = service.getAllWithMealsByToday();
        assertMatch(restaurantsWithMeals, RESTAURANT_THREE, RESTAURANT_ONE, RESTAURANT_TWO);
        MealTestData.assertMatch(restaurantsWithMeals.get(0).getMeals(), MealTestData.MEAL7, MealTestData.MEAL8);
        MealTestData.assertMatch(restaurantsWithMeals.get(1).getMeals(), MealTestData.MEAL1, MealTestData.MEAL2, MealTestData.MEAL3);
        MealTestData.assertMatch(restaurantsWithMeals.get(2).getMeals(), MealTestData.MEAL4, MealTestData.MEAL5, MealTestData.MEAL6);
    }


    @Test
    void testGetAll() throws Exception {
        List<Restaurant> actual = service.getAll();
        assertMatch(actual, RESTAURANT_THREE, RESTAURANT_ONE, RESTAURANT_TWO);
    }

    @Test
    void testValidation() throws Exception {
        validateRootCause(() -> service.create(new Restaurant(null, "  ")), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new Restaurant(null, "Р")), ConstraintViolationException.class);
    }
}