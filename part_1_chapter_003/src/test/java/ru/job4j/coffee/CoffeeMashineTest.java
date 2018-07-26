package ru.job4j.coffee;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMashineTest {
    @Test
    public void whenNote100Price28() {
        CoffeeMashine one = new CoffeeMashine();
        int[] test = new int[]{10, 10, 10, 10, 10, 10, 10, 2};
        assertThat(one.coins(100, 28), is(test));
    }

    @Test
    public void whenNote50Price25() {
        CoffeeMashine one = new CoffeeMashine();
        int[] test = new int[]{10, 10, 5};
        assertThat(one.coins(50, 25), is(test));
    }

    @Test
    public void whenNote100Price72() {
        CoffeeMashine one = new CoffeeMashine();
        int[] test = new int[]{10, 10, 5, 2, 1};
        assertThat(one.coins(100, 72), is(test));
    }
}
