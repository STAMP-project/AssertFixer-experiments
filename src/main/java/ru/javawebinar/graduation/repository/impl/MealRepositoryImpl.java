package ru.javawebinar.graduation.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javawebinar.graduation.model.Meal;
import ru.javawebinar.graduation.repository.CrudMealRepository;
import ru.javawebinar.graduation.repository.CrudRestaurantRepository;
import ru.javawebinar.graduation.repository.MealRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class MealRepositoryImpl implements MealRepository {

    @Autowired
    private CrudMealRepository crudMealRepository;

    @Autowired
    private CrudRestaurantRepository crudRestaurantRepository;

    public Meal save(Meal meal, int restaurantId){
        if (!meal.isNew() && get(meal.getId(), restaurantId) == null) {
            return null;
        }
        meal.setRestaurant(crudRestaurantRepository.getOne(restaurantId));
        return crudMealRepository.save(meal);
    }

    // false if meal do not belong to restaurantId
    public boolean delete(int id, int restaurantId){
        return crudMealRepository.delete(id, restaurantId) != 0;
    }

    // null if meal do not belong to restaurantId
    public Meal get(int id, int restaurantId) {
        return crudMealRepository.findById(id).filter(meal -> meal.getRestaurant().getId() == restaurantId).orElse(null);
    }

    @Override
    public List<Meal> getAll(int restaurantId) {
        return crudMealRepository.getAll(restaurantId);
    }

    @Override
    public List<Meal> getAllByDate(int restaurantId, LocalDate date) {
        return crudMealRepository.getAllByDate(restaurantId, date);
    }

    @Override
    public List<Meal> getAllBetween(int restaurantId, LocalDate startDate, LocalDate endDate) {
        return crudMealRepository.getAllBetween(restaurantId, startDate, endDate);
    }
}
