package ru.job4j.sorting;

import java.util.*;

public class SortUser {

    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.getName().length() - t1.getName().length();
            }
        });
        return users;
    }

    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                int rst = user.getName().compareTo(t1.getName());
                if (rst != 0) {
                    rst = user.getAge().compareTo(t1.getAge());
                }
                return rst;
            }
        });
        return users;
    }
}