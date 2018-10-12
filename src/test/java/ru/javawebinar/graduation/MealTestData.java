package ru.javawebinar.graduation;


import ru.javawebinar.graduation.model.Meal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.graduation.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int MEAL1_ID = START_SEQ + 5;
    public static final int MEAL2_ID = START_SEQ + 6;
    public static final int MEAL_NO_EXIST_ID = START_SEQ + 10;

    public static final Meal MEAL1 = new Meal(MEAL1_ID,"Beef steak" , new BigDecimal("3.00"));
    public static final Meal MEAL2 = new Meal(MEAL1_ID + 1,"Borsch" , new BigDecimal("2.00"));
    public static final Meal MEAL3 = new Meal(MEAL1_ID + 2,"Pancake" , new BigDecimal("1.00"));

    public static final Meal MEAL4 = new Meal(MEAL1_ID + 3,"Deep fried potatoes" , new BigDecimal("1.00"));
    public static final Meal MEAL5 = new Meal(MEAL1_ID + 4,"Macaroni" , new BigDecimal("2.00"));
    public static final Meal MEAL6 = new Meal(MEAL1_ID + 5,"Bouillon" , new BigDecimal("1.00"));

    public static final Meal MEAL7 = new Meal(MEAL1_ID + 6,"Porridge" , new BigDecimal("1.50"));
    public static final Meal MEAL8 = new Meal(MEAL1_ID + 7,"Pizza" , new BigDecimal("2.50"));

    public static final List<Meal> MEALS = Arrays.asList(MEAL1, MEAL2, MEAL3, MEAL4, MEAL5, MEAL6, MEAL7, MEAL8);


    public static Meal getCreated() {
        return new Meal(null, "Sushi", new BigDecimal("2.75"));
    }

    public static Meal getUpdated() {
        return new Meal(MEAL1_ID, "Updated meal", new BigDecimal("2.85"));
    }

    public static Meal getUpdatedNotFound() {
        return new Meal(1, "Несуществующая еда", new BigDecimal("2.25"));
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "restaurant");
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("restaurant", "created").isEqualTo(expected);
    }
}

