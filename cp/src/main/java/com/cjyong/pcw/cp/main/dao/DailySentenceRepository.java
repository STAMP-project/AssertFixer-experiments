package com.cjyong.pcw.cp.main.dao;

import com.cjyong.pcw.cp.main.entity.DailySentence;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DailySentenceRepository extends JpaRepository<DailySentence, Long> {
    /**
     * Find the new three one
     *
     * @param id
     * @param pageable
     * @return
     */
    List<DailySentence> findAllByIdGreaterThan(Long id, Pageable pageable);
}
