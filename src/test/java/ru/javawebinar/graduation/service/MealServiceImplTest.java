package ru.javawebinar.graduation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.graduation.MealTestData;
import ru.javawebinar.graduation.model.Meal;
import ru.javawebinar.graduation.util.exception.ErrorType;
import ru.javawebinar.graduation.util.exception.NotFoundException;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.javawebinar.graduation.MealTestData.*;
import static ru.javawebinar.graduation.MealTestData.assertMatch;
import static ru.javawebinar.graduation.RestaurantTestData.*;


class MealServiceImplTest extends AbstractServiceTest {

    @Autowired
    private MealService service;

    @Test
    void testCreate() {
        Meal created = MealTestData.getCreated();
        service.create(created, RESTAURANT_ONE_ID);
        assertMatch(service.getAll(RESTAURANT_ONE_ID), MEAL1, MEAL2, MEAL3, created);
    }

    @Test
    void testDelete() throws Exception {
        service.delete(MEAL1_ID, RESTAURANT_ONE_ID);
        assertMatch(service.getAll(RESTAURANT_ONE_ID), MEAL2, MEAL3);
    }

    @Test
    void testDeleteNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                service.delete(MEAL1_ID, 1));
    }

    @Test
    void testGet() throws Exception {
        Meal actual = service.get(MEAL1_ID, RESTAURANT_ONE_ID);
        assertMatch(actual, MEAL1);
    }

    @Test
    void testGetNotFound() throws Exception {
        assertThrows(NotFoundException.class, () ->
                service.get(MEAL1_ID, RESTAURANT_TWO_ID));
    }

    @Test
    void testUpdate() throws Exception {
        Meal updated = MealTestData.getUpdated();
        service.update(updated, RESTAURANT_ONE_ID);
        assertMatch(service.get(MEAL1_ID, RESTAURANT_ONE_ID), updated);
    }

    @Test
    void testUpdateNotFound() throws Exception {
        NotFoundException e = assertThrows(NotFoundException.class, () -> service.update(MEAL2, RESTAURANT_TWO_ID));
        String msg = e.getMessage();
        assertTrue(msg.contains(ErrorType.DATA_NOT_FOUND.name()));
        assertTrue(msg.contains(NotFoundException.NOT_FOUND_EXCEPTION));
        assertTrue(msg.contains(String.valueOf(MEAL2_ID)));
    }

    @Test
    void testGetAll() throws Exception {
        List<Meal> all = service.getAll(RESTAURANT_ONE_ID);
        assertMatch(all, MEAL1, MEAL2, MEAL3);
    }

    @Test
    void testGetAllToday() throws Exception {
        List<Meal> allToday = service.getAllByToday(RESTAURANT_TWO_ID);
        assertMatch(allToday, MEAL4, MEAL5, MEAL6);
    }

    @Test
    void testGetAllByDate() throws Exception {
        List<Meal> allByDate = service.getAllByDate(RESTAURANT_THREE_ID, LocalDate.now());
        assertMatch(allByDate, MEAL7, MEAL8);
    }

    @Test
    void testGetAllBetween() throws Exception {
        List<Meal> allBetween = service.getAllBetween(RESTAURANT_ONE_ID, LocalDate.now(), LocalDate.now());
        assertMatch(allBetween, MEAL1, MEAL2, MEAL3);
    }

    @Test
    void testValidation() throws Exception {
        validateRootCause(() -> service.create(new Meal(null," ", new BigDecimal("5.50")), RESTAURANT_ONE_ID), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new Meal(null,"Е", new BigDecimal("5.25")), RESTAURANT_ONE_ID), ConstraintViolationException.class);
        validateRootCause(() -> service.create(new Meal(null,"Еда", null), RESTAURANT_ONE_ID), ConstraintViolationException.class);
    }
}

