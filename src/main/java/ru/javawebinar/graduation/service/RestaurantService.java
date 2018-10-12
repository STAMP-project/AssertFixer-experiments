package ru.javawebinar.graduation.service;

import ru.javawebinar.graduation.model.Restaurant;
import ru.javawebinar.graduation.util.exception.NotFoundException;

import java.util.List;

public interface RestaurantService {

    Restaurant create(Restaurant restaurant);

    void delete(int id) throws NotFoundException;

    void update(Restaurant restaurant) throws NotFoundException;

    Restaurant get(int id) throws NotFoundException;

    Restaurant getByName(String name) throws NotFoundException;

    Restaurant getWithMealsByToday(int id) throws NotFoundException;

    List<Restaurant> getAllWithMealsByToday();

    List<Restaurant> getAll();
}
