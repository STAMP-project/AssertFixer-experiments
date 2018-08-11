package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static final class User {

        private String name;
        private int children;
        private Calendar birthday;

        public User(String name, int children, Calendar birthday) {
            this.name = name;
            this.children = children;
            this.birthday = birthday;
        }
    }

    public static void main(String[] args) {
        Calendar birthday = new GregorianCalendar(1990, 01, 31);
        User first = new User("Egor", 0, birthday);
        User second = new User("Egor", 0, birthday);
        Map<User, String> map = new HashMap<>();
        map.put(first, "First");
        map.put(second, "First");
        System.out.println(map);
    }

    //При создании объекта типа User, создается уникальный id для конкретного User.

}
