package ru.job4j.sorting.departments;

import java.util.*;

public class DepartmentsBook {

    public String[] sortDepartmentsInAscending(String[] array) {
        return parse(array);
    }

    public String[] sortDepartmentsInDescending(String[] array) {
        Arrays.sort(array, new DepartmentComparatorInDescending());
        return array;
    }

    public String[] parse(String[] departments) {
        TreeSet<String> result = new TreeSet<>();
        int number;
        for (String s : departments) {
            number = 0;
            result.add(s);
            for (char c : s.toCharArray()) {
                if (c == '\\') {
                    result.add(s.substring(0, number));
                }
                number++;
            }
        }
        return result.toArray(new String[0]);
    }
}