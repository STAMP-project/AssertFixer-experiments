package ru.javawebinar.graduation.controller.restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.graduation.controller.MessageUtil;
import ru.javawebinar.graduation.model.Restaurant;
import ru.javawebinar.graduation.model.Vote;
import ru.javawebinar.graduation.service.RestaurantService;
import ru.javawebinar.graduation.service.VoteService;

import java.util.List;

import static ru.javawebinar.graduation.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.graduation.util.ValidationUtil.checkNew;

public abstract class AbstractRestaurantController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected MessageUtil messageUtil;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private VoteService voteService;


    public List<Restaurant> getAll() {
        log.info("getAll");
        return restaurantService.getAll();
    }

    public Restaurant get(int id) {
        log.info("get {}", id);
        return restaurantService.get(id);
    }

    public Restaurant create(Restaurant restaurant) {
        log.info("create {}", restaurant);
        checkNew(restaurant);
        return restaurantService.create(restaurant);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        restaurantService.delete(id);
    }

    public void update(Restaurant restaurant, int id) {
        log.info("update {} with id={}", restaurant, id);
        assureIdConsistent(restaurant, id);
        restaurantService.update(restaurant);
    }

    public Restaurant getByName(String name) {
        log.info("getByName {}", name);
        return restaurantService.getByName(name);
    }

    public Restaurant getWithMeals(int id) {
        log.info("getWithMeals {}", id);
        return restaurantService.getWithMealsByToday(id);
    }

    public List<Restaurant> getAllWithMealsByToday() {
        log.info("getWithMealsByToday {}");
        return restaurantService.getAllWithMealsByToday();
    }

    public Vote choice(int restaurantId, int userId) {
        log.info("choice {}");
        return voteService.choice(restaurantId, userId);
    }
}