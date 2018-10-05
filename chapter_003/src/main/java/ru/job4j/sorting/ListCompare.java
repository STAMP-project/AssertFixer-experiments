package ru.job4j.sorting;

import java.util.*;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] leftWorld = left.toCharArray();
        char[] rightWorld = right.toCharArray();

        int rst = 0;

        int len = leftWorld.length < rightWorld.length ? leftWorld.length : rightWorld.length;

        for (int i = 0; i < len; i++) {
            rst = Character.compare(leftWorld[i], rightWorld[i]);
            if (rst != 0) {
                break;
            }
        }
        if (rst == 0) {
            rst = Integer.compare(leftWorld.length, rightWorld.length);
        }
        return rst;
    }
}