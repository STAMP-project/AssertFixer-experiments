package ru.job4j.sorting;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenListOfUsersThenSortingUserByAgeTreeSet() {
        assertThat(
                new SortUserByAge().compare(
                        new User("Svetlana", 27),
                        new User("Petr", 26)
                ), is(1));
    }

    @Test
    public void whenListOfUsersThenSortUserByNameLengthTreeSet() {
        assertThat(
                new SortUserByNameLength().compare(
                        new User("Svetlana", 27),
                        new User("Petr", 26)
                ), is(4));
    }
    @Test
    public void whenListOfUsersThenSortingUsersByNameLength() {
        List<User> users = new ArrayList<>();
        users.add(new User("Svetlana", 27));
        users.add(new User("Petr", 26));
        SortUser sortUsers = new SortUser();
        assertThat(sortUsers.sortNameLength(users).get(0).getAge(), is(26));
    }
    @Test
    public void whenListOfUsersThenSortingUsersByAllFields() {
        List<User> users = new ArrayList<>();
        users.add(new User("Svetlana", 27));
        users.add(new User("Petr", 26));
        SortUser sortUsers = new SortUser();
        assertThat(sortUsers.sortNameLength(users).get(0).getName(), is("Petr"));
    }
}