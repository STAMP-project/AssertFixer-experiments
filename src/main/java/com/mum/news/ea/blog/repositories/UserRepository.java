package com.mum.news.ea.blog.repositories;

/**
 * User: franc
 * Date: 21/09/2018
 * Time: 3:47
 */

import com.mum.news.ea.blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
