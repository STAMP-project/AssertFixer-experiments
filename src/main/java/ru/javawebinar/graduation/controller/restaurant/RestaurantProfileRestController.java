package ru.javawebinar.graduation.controller.restaurant;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.graduation.AuthorizedUser;
import ru.javawebinar.graduation.model.Restaurant;

import java.util.List;

import static ru.javawebinar.graduation.util.exception.VoteTimeExpiredException.SUCCESSFULLY_VOTED;
import static ru.javawebinar.graduation.util.exception.VoteTimeExpiredException.UNSUCCESSFULLY_VOTED;

@RestController
@RequestMapping(RestaurantProfileRestController.REST_URL)
public class RestaurantProfileRestController extends AbstractRestaurantController {
    public static final String REST_URL = "/rest/profile/restaurants";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> getAllWithMealsByToday() {
        return super.getAllWithMealsByToday();
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> choice (@RequestParam("restaurantId") int restaurantId, @AuthenticationPrincipal AuthorizedUser authUser) {
        return super.choice(restaurantId, authUser.getId()) != null ?
                ResponseEntity.status(HttpStatus.OK).body(messageUtil.getMessage(SUCCESSFULLY_VOTED) + restaurantId) :
                ResponseEntity.badRequest().body(messageUtil.getMessage(UNSUCCESSFULLY_VOTED));
    }
}
