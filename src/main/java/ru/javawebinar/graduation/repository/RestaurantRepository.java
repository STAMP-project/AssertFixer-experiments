package ru.javawebinar.graduation.repository;

import ru.javawebinar.graduation.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    // false if not found
    boolean delete(int id);

    // null if not found
    Restaurant get(int id);

    // null if not found
    Restaurant getByName(String name);

    Restaurant getWithMealsByDate(int id, LocalDate date);

    List<Restaurant> getAllWithMealsByDate(LocalDate date);

    List<Restaurant> getAll();
}
