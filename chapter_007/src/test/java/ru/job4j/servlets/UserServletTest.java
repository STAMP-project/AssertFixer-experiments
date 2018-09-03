package ru.job4j.servlets;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.User;
import ru.job4j.ValidateService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserServletTest {
    ValidateService logic;

    @Before
    public void setup() {
        logic = ValidateService.getInstance();
    }

    @Test
    public void whenAddUserThenAdded() {
        logic.addUser(new User("TestLogin", "TestPassword", "TestUser", "Test@email.com"));
        assertNotNull(logic.findAll().get(0));
    }

    @Test
    public void whenDeleteUserThenDeleted() {
        if (logic.findAll().isEmpty()) {
            logic.addUser(new User("TestLogin", "TestPassword", "TestUser", "Test@email.com"));
            logic.deleteUser(1);
            assertTrue(logic.findAll().isEmpty());
        } else {
            logic.deleteUser(1);
            assertTrue(logic.findAll().isEmpty());
        }
    }

    @Test
    public void whenUpdateThenUpdated() {
        if (logic.findAll().isEmpty()) {
            logic.addUser(new User("TestLogin", "TestPassword", "TestUser", "Test@email.com"));
            logic.updateUser(logic.findAll().get(0).getId().get(), new User("NewTestLogin", "TestPassword", "TestUser", "Test@email.com"));
            assertTrue(logic.findAll().get(0).getLogin().equals("NewTestLogin"));
        } else {
            logic.addUser(new User("TestLogin", "TestPassword", "TestUser", "Test@email.com"));
            logic.updateUser(logic.findAll().get(0).getId().get(), new User("NewTestLogin", "TestPassword", "TestUser", "Test@email.com"));
            assertTrue(logic.findAll().get(0).getLogin().equals("NewTestLogin"));
        }

    }

}