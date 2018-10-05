package ru.job4j.calculator;
/**
 *CalculatorTest
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *@version $Id$
 *@since 0.1
 */
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
	/**
	 *Test add.
	 */ @Test
	public void whenAddOnePlusOneThenTwo() {
	 	Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}

	/**
	 *Test subtract.
	 */ @Test
	public void whenThreeMinusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.subtract(3D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}

	/**
	 *Test multiple.
	 */ @Test
	public void whenTwoMultipleTwoThenFor() {
		Calculator calc = new Calculator();
		calc.multiple(2D, 2D);
		double result = calc.getResult();
		double expected = 4D;
		assertThat(result, is(expected));
	}
	/**
	 *Test div.
	 */ @Test
	public void whenSixDivTwoThenThree() {
		Calculator calc = new Calculator();
		calc.div(6D, 2D);
		double result = calc.getResult();
		double expected = 3D;
		assertThat(result, is(expected));
	}

}