package ru.job4j.listconverter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterListTest {
    @Test
    public void whenArrayCopyToList() {
        ConvertList convertList = new ConvertList();
        int[][] array = {{1, 2, 3}, {1, 2, 3}};
        List<Integer> result = convertList.toList(array);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.addAll(expected);
        assertThat(result, is(expected));
    }

    @Test
    public void whenListCopyToArray() {
        ConvertList convertList = new ConvertList();
        List<Integer> innerList = new ArrayList<>();
        innerList.add(1);
        innerList.add(2);
        innerList.add(3);
        innerList.addAll(innerList);
        int[][] result = convertList.toArray(innerList, 3);
        int[][] expected = {{1, 2}, {3, 1}, {2, 3}};
        assertThat(result, is(expected));
    }

    @Test
    public void whenListOfArraysCopiesToList() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = convertList.convert(list);
        List<Integer> expected = asList(new Integer[]{1, 2, 3, 4, 5, 6});
        assertThat(result, is(expected));
    }

    /**
     * Массив из замечаний
     */
    @Test
    public void whenListCopyToArray2() {
        ConvertList convertList = new ConvertList();
        List<Integer> innerList = new ArrayList<>();
        innerList.add(1);
        innerList.add(2);
        innerList.add(3);
        innerList.add(4);
        innerList.add(5);
        innerList.add(6);
        innerList.add(7);
        int[][] result = convertList.toArray(innerList, 3);
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(result, is(expected));
    }
}
