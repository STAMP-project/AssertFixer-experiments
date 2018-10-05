package ru.job4j.coffeemachine;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeeMachineTest {
/**
 * CoffeeMachineTest.
 */
@Test
public void whenValueAndPriceThenLessCoinsChange() {
        int[] expected = {10, 5};
        int value = 50;
        int price = 35;
        CoffeeMachine array = new CoffeeMachine();
        int[] result = array.changes(value, price);
        assertThat(result, is(expected));
}
}