package ru.job4j.sorting.departments;

import java.util.*;

public class DepartmentComparatorInDescending implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {

        char[] leftWorld = o1.toCharArray();
        char[] rightWorld = o2.toCharArray();

        int rst = 0;

        int len = leftWorld.length < rightWorld.length ? leftWorld.length : rightWorld.length;

        for (int i = 0; i < len; i++) {
            rst = Character.compare(rightWorld[i], leftWorld[i]);
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