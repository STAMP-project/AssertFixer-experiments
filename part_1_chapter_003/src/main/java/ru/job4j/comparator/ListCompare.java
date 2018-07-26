package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int length = left.length() <= right.length() ? left.length() : right.length();
            for (int i = 0; i < length; i++) {
                result = result + Character.compare(left.toCharArray()[i], right.toCharArray()[i]);
            }
            if (left.length() != right.length() && result == 0) {
                result = left.length() - right.length();
            }
        return result;
    }
}
