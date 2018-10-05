/**Calculator.
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *@version $Id$
 *@since 0.1
 */

package ru.job4j.calculator;

public class Calculator {

	private double result;

	/**
	 *Method add.
	 *@param first The first number.
	 *@param second The second number.
	 *@return Sum of two numbers.
	 */
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
	 *Method subtract.
	 *@param first The first number.
	 *@param second The second number.
	 *@return The Difference of two numbers.
	 */
	public void subtract(double first, double second) {
		this.result = first - second;
	}
	/**
	 *Method multiple.
	 *@param first The first number.
	 *@param second The second number.
	 *@return The Product of two numbers.
	 */
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	/**
	 *Method div.
	 *@param first The first number.
	 *@param second The second number.
	 *@return The Quotient of two numbers.
	 */
	public void div(double first, double second) {
		this.result = (double) first / second;
	}
	/**
	 *Method getResult.
	 *@return result.
	 */
	public double getResult() {
		return this.result;
	}
}