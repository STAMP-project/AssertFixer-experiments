package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void factorial0() {
        Factorial test = new Factorial();
        int result = test.calc(0);
        assertThat(result, is(1));
    }
    @Test
    public void factorial5() {
        Factorial test = new Factorial();
        int result = test.calc(5);
        assertThat(result, is(120));
    }
}