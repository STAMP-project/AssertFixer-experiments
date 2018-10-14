package com.cryptoeagle.entity;

import com.cryptoeagle.AbstractTest;
import com.cryptoeagle.service.abst.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UserTest extends AbstractTest {

    @Autowired
    UserService service;

    @Test
    public void user() {

        List<User> all = service.getAll();

        User user = all.stream().findFirst().get();

        assertTrue(user.isAccountNonExpired());
        assertTrue(user.isAccountNonLocked());
        assertTrue(user.isCredentialsNonExpired());
        assertTrue(user.isEnabled());
        assertTrue(user.getPassword().length() > 0);
    }

}