package ru.javawebinar.graduation.controller.meal;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javawebinar.graduation.View;
import ru.javawebinar.graduation.model.Meal;
import ru.javawebinar.graduation.service.MealService;

import java.net.URI;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.javawebinar.graduation.util.DateTimeUtil.*;
import static ru.javawebinar.graduation.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.graduation.util.ValidationUtil.checkNew;

@RestController
@RequestMapping(MealAdminRestController.REST_URL)
public class MealAdminRestController {

    static final String REST_URL = "/rest/admin/restaurants/{restaurantId}/meals";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;


    @GetMapping(value = "/history", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Meal> getAll(@PathVariable("restaurantId") int restaurantId) {
        log.info("getAll");
        return service.getAll(restaurantId);
    }


    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Meal> getAllByToday(@PathVariable("restaurantId") int restaurantId) {
        log.info("getAllByToday");
        return service.getAllByToday(restaurantId);
    }

    @GetMapping(value = "/byDate", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Meal> getAllByDate(@PathVariable("restaurantId") int restaurantId, @RequestParam("date") LocalDate date) {
        log.info("getAllByDate");
        return service.getAllByDate(restaurantId, date);
    }

    @GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Meal> getAllBetween(@PathVariable("restaurantId") int restaurantId,
                                    @RequestParam(value = "startDate", required = false) LocalDate startDate,
                                    @RequestParam(value = "endDate", required = false) LocalDate endDate) {
        log.info("getAllBetween");
        return service.getAllBetween(restaurantId, orElse(startDate, MIN_DATE), orElse(endDate, MAX_DATE));
    }


    @GetMapping(value = "/{mealId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Meal get(@PathVariable("restaurantId") int restaurantId, @PathVariable("mealId") int mealId) {
        log.info("get {}", mealId);
        return service.get(mealId, restaurantId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> add(@Validated(View.Web.class) @RequestBody Meal meal, @PathVariable("restaurantId") int restaurantId) {
        log.info("create {}", meal);
        checkNew(meal);
        Meal created = service.create(meal, restaurantId);
        Map<String, Integer> parameters = new HashMap<>();
        parameters.put("restaurantId", restaurantId);
        parameters.put("mealId", created.getId());
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{mealId}")
                .buildAndExpand(parameters).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @DeleteMapping(value = "/{mealId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("restaurantId") int restaurantId, @PathVariable("mealId") int mealId) {
        log.info("delete {}", mealId);
        service.delete(mealId, restaurantId);
    }

    @PutMapping(value = "/{mealId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@Validated(View.Web.class) @RequestBody Meal meal, @PathVariable("restaurantId") int restaurantId, @PathVariable("mealId") int mealId) {
        log.info("update {} with id={}", meal, mealId);
        assureIdConsistent(meal, mealId);
        service.update(meal,restaurantId);
    }
}
