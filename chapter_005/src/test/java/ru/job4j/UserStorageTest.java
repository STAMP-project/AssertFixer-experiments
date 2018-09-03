package ru.job4j;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserStorageTest {
    @Test
    public void whenAddUserThenAdded() {
        User userA = new User(1, 20);
        User userB = new User(2, 30);
        UserStorage storage = new UserStorage();
        assertTrue(storage.add(userA));
        assertTrue(storage.add(userB));
    }

    @Test
    public void whenDublicateAddThenDidntAdd() {
        User userA = new User(1, 20);
        UserStorage storage = new UserStorage();
        storage.add(userA);
        assertFalse(storage.add(userA));
    }

    @Test
    public void whenUserAddThenUserGot() {
        User userA = new User(1, 20);
        UserStorage storage = new UserStorage();
        storage.add(userA);
        User result = storage.storage.get(1);
        assertEquals(result, userA);
    }

    @Test
    public void whenDeleteThenEmptyStorage() {
        User userA = new User(1, 20);
        UserStorage storage = new UserStorage();
        storage.add(userA);
        assertTrue(storage.delete(userA));
        assertTrue(storage.storage.isEmpty());
    }

    @Test
    public void whenUserUpdateThenGetNewAmount() {
        User userA = new User(1, 20);
        UserStorage storage = new UserStorage();
        storage.add(userA);
        storage.update(new User(1, 30));
        assertThat(storage.storage.get(1).getAmount(), is(30));
    }

    @Test
    public void whenTransferThenOk() {
        User userA = new User(1, 20);
        User userB = new User(2, 30);
        UserStorage storage = new UserStorage();
        storage.add(userA);
        storage.add(userB);
        storage.transfer(1, 2, 20);
        assertThat(storage.storage.get(1).getAmount(), is(0));
        assertThat(storage.storage.get(2).getAmount(), is(50));
    }

    @Test(expected = NullPointerException.class)
    public void whenTransferThenFail() {
        User userA = new User(1, 20);
        User userB = new User(2, 30);
        UserStorage storage = new UserStorage();
        storage.add(userA);
        storage.add(userB);
        storage.transfer(4, 5, 20);

    }
}