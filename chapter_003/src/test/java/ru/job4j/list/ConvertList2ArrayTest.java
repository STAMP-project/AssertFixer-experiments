package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * ConvertList2ArrayTest.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int rows = 3;
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                rows
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }
    @Test
    public void whenListOfArraysThenOneList() {
        ConvertList2Array list = new ConvertList2Array();
        int[] input1 = {1, 2};
        int[] input2 = {3, 4, 5, 6};
        List<int[]> convertList = new ArrayList<>();
        convertList.add(0, input1);
        convertList.add(1, input2);
        List<Integer> result = list.convert(convertList);
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }
}