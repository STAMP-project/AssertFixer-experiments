package ru.job4j;

import org.junit.Test;
import ru.job4j.coffemachine.CoffeeMachine;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {
    @Test
    public void whenBuyAmericanoWithHundredThenGenChange() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] result = machine.changes(100, 35);
        int[] expected = {10, 10, 10, 10, 10, 10, 5};
        assertThat(result, is(expected));
    }

    @Test
    public void whenBuyAmericanoWithThirtySevenThenGenChange() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] result = machine.changes(37, 35);
        int[] expected = {2};
        assertThat(result, is(expected));
    }

    @Test
    public void whenBuyAmericanoWithThirtySixThenGenChange() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] result = machine.changes(36, 35);
        int[] expected = {1};
        assertThat(result, is(expected));
    }
}
