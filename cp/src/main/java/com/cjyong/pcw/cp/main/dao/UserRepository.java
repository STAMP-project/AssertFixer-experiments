package com.cjyong.pcw.cp.main.dao;

import com.cjyong.pcw.cp.main.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find the other one to the parameter one.
     *
     * @param userId
     * @return
     */
    User findFirstByIdNot(Long userId);

    /**
     * Find user by user's account and password.
     *
     * @param userAccount
     * @param password
     * @return
     */
    User findUserByAccountAndPassword(String userAccount, String password);
}
