package com.cjyong.pcw.cp.main.dao;

import com.cjyong.pcw.cp.main.entity.Album;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/12/7
 * Time: 16:30
 * Description:
 */
@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    /**
     * Find album by title
     *
     * @param title
     * @return
     */
    List<Album> findByTitle(String title);

    /**
     * Find the new three one
     *
     * @param id
     * @param pageable
     * @return
     */
    List<Album> findAllByIdGreaterThan(Long id, Pageable pageable);

    List<Album> findAll();
}
