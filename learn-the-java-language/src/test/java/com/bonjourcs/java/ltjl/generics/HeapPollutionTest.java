package com.bonjourcs.java.ltjl.generics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/3
 */
public class HeapPollutionTest {


    @Test
    public void test() {

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        HeapPollution.addToList(list1, "Seven", "Eight", "Nine");
        HeapPollution.addToList(list2, "Ten", "Eleven", "Twelve");

        List<List<String>> listOfStringLists = new ArrayList<>();
        HeapPollution.addToList(listOfStringLists, list1, list2);

        try {
            HeapPollution.faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
        } catch (Exception e) {
            // ClassCastException
            System.out.println(e);
        }

    }

}