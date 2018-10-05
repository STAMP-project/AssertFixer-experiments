package ru.job4j.sorting;

import java.util.*;

public class SortUserByAlphabetName implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user1.getName().compareTo(user2.getName());
    }
}
