package ru.javawebinar.graduation.service;

import ru.javawebinar.graduation.model.Meal;
import ru.javawebinar.graduation.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface MealService {

    Meal create(Meal meal, int restaurantId);

    void delete(int id, int restaurantId) throws NotFoundException;

    Meal get(int id, int restaurantId) throws NotFoundException;

    void update(Meal meal, int restaurantId) throws NotFoundException;

    List<Meal> getAll(int restaurantId);

    List<Meal> getAllByToday(int restaurantId);

    List<Meal> getAllByDate(int restaurantId, LocalDate date);

    List<Meal> getAllBetween(int restaurantId, LocalDate startDate, LocalDate endDate);
}
