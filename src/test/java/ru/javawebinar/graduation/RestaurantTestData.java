package ru.javawebinar.graduation;

import ru.javawebinar.graduation.model.Restaurant;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.graduation.MealTestData.*;
import static ru.javawebinar.graduation.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {
    public static final int RESTAURANT_ONE_ID = START_SEQ + 2;
    public static final int RESTAURANT_TWO_ID = START_SEQ + 3;
    public static final int RESTAURANT_THREE_ID = START_SEQ + 4;
    public static final int RESTAURANT_NO_EXIST_ID = START_SEQ + 5;

    public static final Restaurant RESTAURANT_ONE = new Restaurant(RESTAURANT_ONE_ID, "Cafe Maya");
    public static final Restaurant RESTAURANT_TWO = new Restaurant(RESTAURANT_TWO_ID, "Little Wonder Cafe");
    public static final Restaurant RESTAURANT_THREE = new Restaurant(RESTAURANT_THREE_ID, "Cafe Loren");

    public static Restaurant getRestaurantWithMeals() {
        Restaurant getWithMeals = new Restaurant(RESTAURANT_ONE_ID, "Cafe Maya");
        getWithMeals.setMeals((Arrays.asList(MEAL1, MEAL2, MEAL3)));
        return getWithMeals;
    }

    public static List<Restaurant> getAllRestaurantWithMeals() {
        Restaurant getWithMealsOne = new Restaurant(RESTAURANT_ONE_ID, "Cafe Maya");
        getWithMealsOne.setMeals((Arrays.asList(MEAL1, MEAL2, MEAL3)));
        Restaurant getWithMealsTwo = new Restaurant(RESTAURANT_TWO_ID, "Little Wonder Cafe");
        getWithMealsTwo.setMeals(Arrays.asList(MEAL4, MEAL5, MEAL6));
        Restaurant getWithMealsThree = new Restaurant(RESTAURANT_THREE_ID, "Cafe Loren");
        getWithMealsThree.setMeals(Arrays.asList(MEAL7, MEAL8));
        return Arrays.asList(getWithMealsThree, getWithMealsOne, getWithMealsTwo);
    }

    public static Restaurant getCreated() {
        return new Restaurant(null, "New Restaurant");
    }

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT_ONE_ID, "Updated Restaurant");
    }

    public static Restaurant getUpdatedNotFound() {
        return new Restaurant(1, "Do not exist Restaurant");
    }

    public static void assertMatch(Restaurant actual, Restaurant expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, "votes", "meals");
    }

    public static void assertMatch(Iterable<Restaurant> actual, Restaurant... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Restaurant> actual, Iterable<Restaurant> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("votes", "meals").isEqualTo(expected);
    }

}


