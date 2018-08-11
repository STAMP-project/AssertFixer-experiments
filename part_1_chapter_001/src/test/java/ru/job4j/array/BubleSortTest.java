package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BubleSortTest {
    @Test
    public void whenOneFourArray() {
        BubleSort sort = new BubleSort();
        int[] input = new int[] {3, 2, 1, 4};
        int[] result = sort.buble(input);
        int[] expect = new int[] {1, 2, 3, 4};
        assertThat(result, is(expect));
    }

    @Test
    public void whenOneFiveArray() {
        BubleSort sort = new BubleSort();
        int[] input = new int[] {5, 2, 3, 1, 4};
        int[] result = sort.buble(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, is(expect));
    }
    @Test
    public void whenOneTenArray() {
        BubleSort sort = new BubleSort();
        int[] input = new int[] {5, 2, 3, 1, 4, 6, 10, 8, 9, 7};
        int[] result = sort.buble(input);
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(expect));
    }
}