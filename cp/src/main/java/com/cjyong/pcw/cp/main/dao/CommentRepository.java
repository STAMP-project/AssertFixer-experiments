package com.cjyong.pcw.cp.main.dao;

import com.cjyong.pcw.cp.main.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
