package ru.job4j.sorting.departments;

import java.util.Comparator;

public class DepartmentComparatorInAscending implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
