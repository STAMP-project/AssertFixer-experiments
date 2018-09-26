package com.bindstone.portfolio.service.impl;

import com.bindstone.portfolio.entity.User;
import com.bindstone.portfolio.repository.UserRepository;
import com.bindstone.portfolio.service.UserService;
import com.bindstone.portfolio.validator.NoValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User Service
 */
@Service
@Slf4j
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {

    /**
     * Constructor
     *
     * @param userRepository User Repository
     * @param validation     No Validation
     */
    @Autowired
    public UserServiceImpl(UserRepository userRepository, NoValidation validation) {
        super(userRepository, validation);
    }
}
