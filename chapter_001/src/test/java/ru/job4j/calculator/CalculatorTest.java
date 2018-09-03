package ru.job4j.calculator;

/**
 * Calculator test.
 * Test all the mathematical operations.
 *
 * @author Sergey Petrov (sergey45684745@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    /**
     * Test add
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * Test sub
     */
    @Test
    public void whenSubOneFromTwoThenOne() {
        Calculator calc = new Calculator();
        calc.sub(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
    /**
     * Test mul
     */
    @Test
    public void whenMultiplyTwoAndTwoThenFour() {
        Calculator calc = new Calculator();
        calc.mul(2D, 2D);
        double result = calc.getResult();
        double expected = 4D;
        assertThat(result, is(expected));
    }
    /**
     * Test div
     */
    @Test
    public void whenDivideFourByTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.div(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}
