package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayAdditionTest {
    @Test
    public  void whenAddArraysThenGetBigSortedArray() {
        ArrayAddition arrayAddition = new ArrayAddition();
        int[] array1 = {1, 3, 5, 7, 9};
        int[] array2 = {2, 4, 6, 8, 10};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = arrayAddition.addArray(array1, array2);
        assertThat(result, is(expected));
    }
    @Test
    public  void whenAddArraysThenGetBigSortedArrayFourElementsTotal() {
        ArrayAddition arrayAddition = new ArrayAddition();
        int[] array1 = {1, 3};
        int[] array2 = {2, 4};
        int[] expected = {1, 2, 3, 4};
        int[] result = arrayAddition.addArray(array1, array2);
        assertThat(result, is(expected));
    }
    @Test
    public  void whenAddArraysThenGetBigSortedArryFourElementsTotalDifferentOrder() {
        ArrayAddition arrayAddition = new ArrayAddition();
        int[] array1 = {1, 3};
        int[] array2 = {5, 7};
        int[] expected = {1, 3, 5, 7};
        int[] result = arrayAddition.addArray(array1, array2);
        assertThat(result, is(expected));
    }
    @Test
    public  void whenAddArraysThenGetBigSortedArrayTenElementsTotalOneAfterOne() {
        ArrayAddition arrayAddition = new ArrayAddition();
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {6, 7, 8, 9, 10};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] result = arrayAddition.addArray(array1, array2);
        assertThat(result, is(expected));
    }

    @Test
    public  void whenSecondArraySmallerTenElementsTotal() {
        ArrayAddition arrayAddition = new ArrayAddition();
        int[] array1 = {10, 30, 50, 70, 90};
        int[] array2 = {2, 4, 6, 8, 10};
        int[] expected = {2, 4, 6, 8, 10, 10, 30, 50, 70, 90};
        int[] result = arrayAddition.addArray(array1, array2);
        assertThat(result, is(expected));
    }
}
