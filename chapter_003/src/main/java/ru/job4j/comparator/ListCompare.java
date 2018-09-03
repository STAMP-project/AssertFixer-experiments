package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int len1 = left.length();
        int len2 = right.length();
        int lim = Math.min(len1, len2);
        char[] leftCharArray = left.toCharArray();
        char[] rightCharArray = right.toCharArray();

        int i = 0;
        while (i < lim) {
            char c1 = leftCharArray[i];
            char c2 = rightCharArray[i];
            if (c1 != c2) {
                return c1 - c2;
            }
            i++;
        }
        return len1 - len2;
    }
}

