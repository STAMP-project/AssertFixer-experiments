package ru.javawebinar.graduation.service;

import ru.javawebinar.graduation.model.Vote;

public interface VoteService {

    Vote choice (int restaurantId, int userId);
}
