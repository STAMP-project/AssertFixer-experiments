package com.bonjourcs.java.ltjl.generics;

/**
 * @author Liang Chenghao
 * Description: util class for Number
 * Date: 2018/4/2
 */
public class NumberUtils {

    /**
     * count elements in list which is greater than specific element
     *
     * @param list    list
     * @param element element to compare
     * @param <T>     element type
     * @return count number
     */
    public static <T extends Comparable<T>> int countGreaterThan(T[] list, T element) {
        int count = 0;
        for (T t : list) {
            if (t.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }
}
