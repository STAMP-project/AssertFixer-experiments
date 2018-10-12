package ru.javawebinar.graduation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.javawebinar.graduation.model.Meal;
import ru.javawebinar.graduation.repository.MealRepository;
import ru.javawebinar.graduation.service.MealService;
import ru.javawebinar.graduation.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

import static ru.javawebinar.graduation.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository repository;

    @Autowired
    public MealServiceImpl(MealRepository repository) {
        this.repository = repository;
    }

    @Override
    public Meal create(Meal meal, int restaurantId) {
        Assert.notNull(meal, "meal must not be null");
        return repository.save(meal, restaurantId);
    }

    @Override
    public void delete(int id, int restaurantId) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id, restaurantId), id);

    }

    @Override
    public Meal get(int id, int restaurantId) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id, restaurantId), id);
    }


    @Override
    public void update(Meal meal, int restaurantId) throws NotFoundException {
        checkNotFoundWithId(repository.save(meal, restaurantId), meal.getId());
    }

    @Override
    public List<Meal> getAll(int restaurantId) {
        return repository.getAll(restaurantId);
    }

    @Override
    public List<Meal> getAllByToday(int restaurantId) {
        return repository.getAllByDate(restaurantId, LocalDate.now());
    }

    @Override
    public List<Meal> getAllByDate(int restaurantId, LocalDate date) {
        return repository.getAllByDate(restaurantId, date);
    }

    @Override
    public List<Meal> getAllBetween(int restaurantId, LocalDate startDate, LocalDate endDate) {
        return repository.getAllBetween(restaurantId, startDate, endDate);
    }
}
