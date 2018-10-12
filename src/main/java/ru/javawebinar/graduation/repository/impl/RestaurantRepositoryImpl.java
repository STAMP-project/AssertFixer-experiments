package ru.javawebinar.graduation.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.javawebinar.graduation.model.Restaurant;
import ru.javawebinar.graduation.repository.CrudRestaurantRepository;
import ru.javawebinar.graduation.repository.RestaurantRepository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private static final Sort SORT_NAME = new Sort(Sort.Direction.ASC, "name");

    @Autowired
    private CrudRestaurantRepository crudRestaurantRepository;

    @Override
    public Restaurant save(Restaurant restaurant) {
        if(!restaurant.isNew() && get(restaurant.getId()) == null){
            return null;
        }
        return crudRestaurantRepository.save(restaurant);
    }

    @Override
    public boolean delete(int id) {
        return crudRestaurantRepository.delete(id) != 0;
    }

    @Override
    public Restaurant get(int id) {
        return crudRestaurantRepository.findById(id).orElse(null);
    }

    @Override
    public Restaurant getByName(String name) {
        return crudRestaurantRepository.getByName(name).orElse(null);
    }

    @Override
    public Restaurant getWithMealsByDate(int id, LocalDate date) {
        return crudRestaurantRepository.getWithMealsByDate(id, date);
    }

    @Override
    public List<Restaurant> getAllWithMealsByDate(LocalDate date) {
        return crudRestaurantRepository.getALLWithMealsByDate(date);
    }

    @Override
    public List<Restaurant> getAll() {
        return crudRestaurantRepository.findAll(SORT_NAME);
    }
}
