package com.bindstone.portfolio.repository;

import com.bindstone.portfolio.entity.User;
import com.bindstone.portfolio.factories.UserFactory;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This is the only Repository Test. As we use JPA, we suppose the Framework does its
 * work, and the tests will be executed on Service Layer. Still, in case of special
 * manipulations (SQL) we can include tests on this lower level.
 */
public class UserRepositoryTest extends AbstractRepositoryTest {

    @Test
    public void createTest() {
        Iterable<User> before = userRepository.findAll();
        assertFalse("User Table is not empty (Prerequisite)", before.iterator().hasNext());

        User user = UserFactory.USER_1();
        userRepository.save(user);

        Iterable<User> after = userRepository.findAll();
        assertTrue("User Table is empty, no save has been done.", after.iterator().hasNext());
    }
}
