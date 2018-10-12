package ru.javawebinar.graduation.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.graduation.model.Restaurant;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Transactional
    @Override
    Restaurant save(Restaurant restaurant);

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Override
    Optional<Restaurant> findById(Integer id);

    Optional<Restaurant> getByName(String name);

    @Query("SELECT r FROM Restaurant r LEFT JOIN FETCH r.meals m WHERE r.id=:id AND m.created=:date")
    Restaurant getWithMealsByDate(@Param("id") int id, @Param("date") LocalDate date);

    @Query("SELECT DISTINCT r FROM Restaurant r LEFT JOIN FETCH r.meals m WHERE m.created=:date ORDER BY r.name ASC")
    List<Restaurant> getALLWithMealsByDate(@Param("date") LocalDate date);

    @Override
    List<Restaurant> findAll(Sort sort);
}
