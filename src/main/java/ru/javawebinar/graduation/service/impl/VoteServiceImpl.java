package ru.javawebinar.graduation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.graduation.model.Vote;
import ru.javawebinar.graduation.repository.RestaurantRepository;
import ru.javawebinar.graduation.repository.VoteRepository;
import ru.javawebinar.graduation.service.VoteService;
import ru.javawebinar.graduation.util.exception.VoteTimeExpiredException;

import java.time.LocalTime;

import static ru.javawebinar.graduation.util.DateTimeUtil.TIME_END_VOTING;


@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository repository;

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository repository, RestaurantRepository restaurantRepository) {
        this.repository = repository;
        this.restaurantRepository = restaurantRepository;
    }

    //todo

    @Override
    @Transactional
    public Vote choice(int restaurantId, int userId) {
        if (restaurantRepository.get(restaurantId) == null) {
            return null;
        }
        Vote voted = repository.get(userId);
        if (voted != null) {
            if (LocalTime.now().isBefore(TIME_END_VOTING)) {
                return repository.save(voted, restaurantId, userId);
            } else {
                throw new VoteTimeExpiredException("Time for re-voting has expired");
            }
        } else {
            return repository.save(new Vote(), restaurantId, userId);
        }
    }
}
