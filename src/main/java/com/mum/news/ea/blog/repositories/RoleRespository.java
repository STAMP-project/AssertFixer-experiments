package com.mum.news.ea.blog.repositories;

/**
 * User: franc
 * Date: 21/09/2018
 * Time: 3:49
 */

import com.mum.news.ea.blog.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

///https://www.jackrutorial.com/2018/04/spring-boot-user-registration-login.html

@Repository
public interface RoleRespository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
