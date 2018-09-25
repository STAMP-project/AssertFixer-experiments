package com.cjyong.pcw.cp.main.dao;

import com.cjyong.pcw.cp.main.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
