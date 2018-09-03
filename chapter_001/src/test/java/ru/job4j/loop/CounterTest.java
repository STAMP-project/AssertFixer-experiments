package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CounterTest {
    @Test
    public  void whenWeGiveSomeNumsWeGetSumOfEven() {
        Counter counter = new Counter();
        int result =  counter.add(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
}
