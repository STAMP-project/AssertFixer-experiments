package ru.javawebinar.graduation.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.graduation.model.Vote;

import java.time.LocalDate;

import static ru.javawebinar.graduation.RestaurantTestData.RESTAURANT_TWO_ID;
import static ru.javawebinar.graduation.UserTestData.USER_ID;

class VoteServiceImplTest extends AbstractServiceTest {

    @Autowired
    private VoteService service;

    @Test
    void testChoice() {
        Vote created = service.choice(RESTAURANT_TWO_ID, USER_ID);
        Assertions.assertThat(created.getRestaurant().getId()).isEqualTo(RESTAURANT_TWO_ID);
        Assertions.assertThat(created.getUser().getId()).isEqualTo(USER_ID);
        Assertions.assertThat(created.getVoted()).isEqualTo(LocalDate.now());
    }
}