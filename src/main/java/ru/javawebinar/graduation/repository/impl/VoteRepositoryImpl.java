package ru.javawebinar.graduation.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.javawebinar.graduation.model.Vote;
import ru.javawebinar.graduation.repository.CrudRestaurantRepository;
import ru.javawebinar.graduation.repository.CrudUserRepository;
import ru.javawebinar.graduation.repository.CrudVoteRepository;
import ru.javawebinar.graduation.repository.VoteRepository;

import java.time.LocalDate;

@Repository
public class VoteRepositoryImpl implements VoteRepository {

    @Autowired
    private CrudVoteRepository crudVoteRepository;
    @Autowired
    private CrudRestaurantRepository crudRestaurantRepository;
    @Autowired
    private CrudUserRepository crudUserRepository;
    @Override
    public Vote save(Vote vote, int restaurantId, int userId) {
        vote.setRestaurant(crudRestaurantRepository.getOne(restaurantId));
        vote.setUser(crudUserRepository.getOne(userId));
        return crudVoteRepository.save(vote);
    }

    @Override
    public Vote get(int userId) {
        return crudVoteRepository.findByUserIdAndVoted(userId, LocalDate.now())
                .orElse(null);
    }
}