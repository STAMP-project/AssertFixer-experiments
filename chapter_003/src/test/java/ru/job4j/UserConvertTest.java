package ru.job4j;

import org.junit.Test;
import ru.job4j.listmapper.User;
import ru.job4j.listmapper.UserConvert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenListGoesToMapThenMap() {
        boolean matcher = false;
        UserConvert convert = new UserConvert();
        List<User> list = new ArrayList<>();
        User user1 = new User("UserName1", "CityName1");
        User user2 = new User("UserName2", "CityName2");
        User user3 = new User("UserName3", "CityName3");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        Map<Integer, User> result = convert.process(list);
        Map<Integer, User> expected = new HashMap<>();
        expected.put(1, user1);
        expected.put(2, user2);
        expected.put(3, user3);
        if (// Это очень сложный if, который сравнивает карты и список попольно
                list.get(0).getId() == result.get(0).getId()
                        && list.get(1).getId() == result.get(1).getId()
                        && list.get(2).getId() == result.get(2).getId()
                        && list.get(0).getName().equals(result.get(0).getName())
                        && list.get(1).getName().equals(result.get(1).getName())
                        && list.get(2).getName().equals(result.get(2).getName())
                        && list.get(0).getCity().equals(result.get(0).getCity())
                        && list.get(1).getCity().equals(result.get(1).getCity())
                        && list.get(2).getCity().equals(result.get(2).getCity())
                ) {
            matcher = true;
        }
        assertThat(matcher, is(true));
    }
}
