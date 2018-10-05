package ru.job4j.sorting;

import java.util.*;

public class SortUserByAge implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user1.getAge().compareTo(user2.getAge());
    }
}