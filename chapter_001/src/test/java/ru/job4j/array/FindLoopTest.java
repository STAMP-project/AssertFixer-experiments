package ru.job4j.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindLoopTest {
    @Test
    public  void whenWePut123and2weget1() {
        FindLoop loop = new FindLoop();
        int result = loop.indexOf(new int[]{1, 2, 3}, 2);
        int expected = 1;
        assertThat(result, is(expected));
    }
    @Test
    public  void whenWePut123and4wegetMinus1() {
        FindLoop loop = new FindLoop();
        int result = loop.indexOf(new int[]{1, 2, 3}, 4);
        int expected = -1;
        assertThat(result, is(expected));
    }
}
