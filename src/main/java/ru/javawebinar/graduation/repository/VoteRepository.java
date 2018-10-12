package ru.javawebinar.graduation.repository;

import ru.javawebinar.graduation.model.Vote;

public interface VoteRepository {

    Vote save(Vote vote, int restaurantId, int userId);

    Vote get(int userId);
}
