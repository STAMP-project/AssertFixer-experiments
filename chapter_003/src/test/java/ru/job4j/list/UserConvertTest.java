package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenListOfUsersThenHashMapOfUsers() {
        UserConvert listOfUsers = new UserConvert();
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Svetlana", "SPb"));
        HashMap<Integer, User> hashMapUsers = listOfUsers.process(users);
        assertThat(hashMapUsers.containsKey(1), is(true));
    }
}