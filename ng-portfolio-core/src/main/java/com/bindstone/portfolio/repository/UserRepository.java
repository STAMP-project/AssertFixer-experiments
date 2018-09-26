package com.bindstone.portfolio.repository;

import com.bindstone.portfolio.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * User Repository
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
