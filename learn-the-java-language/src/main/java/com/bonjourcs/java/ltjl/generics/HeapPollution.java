package com.bonjourcs.java.ltjl.generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description: heap pollution
 * Date: 2018/4/3
 */
public class HeapPollution {

    public static <T> void addToList(List<T> list, T... elements) {
        Collections.addAll(list, elements);
    }

    public static void faultyMethod(List<String>... lists) {
        Object[] objects = lists;
        objects[0] = Arrays.asList(42);
        String s = lists[0].get(0);
    }
}
