package ru.job4j;

import org.junit.Test;
import ru.job4j.usersort.UserSort;
import ru.job4j.usersort.User;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SortUserTest {
    @Test
    public void whenUsersSortThenSorted() {
        boolean matcher = false;
        UserSort sort = new UserSort();
        List<User> list = new ArrayList<>();
        list.add(new User("Ivan", 22));
        list.add(new User("Kurt", 27));
        list.add(new User("Bob", 2));
        TreeSet<User> set = (TreeSet<User>) sort.sort(list);
        Object[] array = set.toArray();
        int[] ageArray = new int[3];
        for (int i = 0; i < array.length; i++) {
            ageArray[i] = set.pollFirst().getAge();
        }
        if (ageArray[0] < ageArray[1] && ageArray[1] < ageArray[2]) {
            matcher = true;
        }
        assertThat(matcher, is(true));

    }

    @Test
    public void whenUsersSortByLenghtThenSorted() {
        boolean matcher = false;
        UserSort sort = new UserSort();
        List<User> list = new ArrayList<>();
        list.add(new User("Ivan", 22));
        list.add(new User("Thelongestivanever", 22));
        list.add(new User("Sameivanbulonger", 22));
        List<User> result = new ArrayList<>();
        result.addAll(sort.sortNameLength(list));
        if (result.get(0).getName().length() < result.get(1).getName().length()
                && result.get(1).getName().length() < result.get(2).getName().length()
                ) {
            matcher = true;
        }
        assertThat(matcher, is(true));
    }

    @Test
    public void whenUsersSortByNameAndAgeThenSorted() {
        boolean matcher = false;
        UserSort sort = new UserSort();
        List<User> list = new ArrayList<>();
        list.add(new User("Ivan", 24));
        list.add(new User("Ivan", 22));
        list.add(new User("Adam", 16));
        List<User> result = new ArrayList<>();
        result.addAll(sort.sortByAllFields(list));
        if (result.get(0).getName().equals("Adam")
                && result.get(1).getAge() == 22
                && result.get(2).getAge() == 24
                ) {
            matcher = true;
        }
        assertThat(matcher, is(true));

    }
}
