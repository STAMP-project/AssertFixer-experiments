package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    @Test
    public void when3thenMulitplyTable3x3() {
        Matrix array = new Matrix();
        int[][] result = array.multiply(3);
        int[][] expected = new int[][]{{1, 2, 3}, {2, 4, 6}, {3, 6, 9}};
        assertThat(result, is(expected));
    }
    @Test
    public void when4thenMulitplyTable4x4() {
        Matrix array = new Matrix();
        int[][] result = array.multiply(4);
        int[][] expected = new int[][]{{1, 2, 3, 4}, {2, 4, 6, 8}, {3, 6, 9, 12}, {4, 8, 12, 16}};
        assertThat(result, is(expected));
    }
}
