package ru.javawebinar.graduation;

import ru.javawebinar.graduation.model.Vote;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.graduation.model.AbstractBaseEntity.START_SEQ;

public class VoteTestData {
    public static final int VOTE_FIRST_ID = START_SEQ + 13;

    public static final Vote CREATED_VOTE = new Vote();
    public static final Vote UPDATED_VOTE  = new Vote(VOTE_FIRST_ID);
    public static final Vote FIRST_VOTE  = new Vote(VOTE_FIRST_ID);


    public static void assertMatch(Iterable<Vote> actual, Vote... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Vote> actual, Iterable<Vote> expected) {
        assertThat(actual).usingElementComparatorIgnoringFields("restaurant", "user").isEqualTo(expected);
    }
}
