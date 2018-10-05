package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * FactorialTest.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
public class FactorialTest {
    /**
     * Test calc.
     */
    @Test
    public void whenN5ThenFact120() {
        Factorial factorial = new Factorial();
        int number = 5;
        int result = factorial.calc(number);
        assertThat(result, is(120));
    }
}
