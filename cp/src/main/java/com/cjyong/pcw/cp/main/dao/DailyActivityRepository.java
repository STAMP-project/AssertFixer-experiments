package com.cjyong.pcw.cp.main.dao;

import com.cjyong.pcw.cp.main.entity.DailyActivity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailyActivityRepository extends JpaRepository<DailyActivity, Long> {
    /**
     * Find new three one
     *
     * @param id
     * @param pageable
     * @return
     */
    List<DailyActivity> findAllByIdGreaterThan(Long id, Pageable pageable);
}
