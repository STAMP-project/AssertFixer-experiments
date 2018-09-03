package ru.job4j.calculator;

/**
 * Calculator.
 *
 * @author Sergey Petrov (sergey45684745@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Calculator {
    private double result;
    /**
     * Method adds first to second.
     * @param first first num.
     */

    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Method substract second from first.
     * @param first first num.
     */
    public void sub(double first, double second) {
        this.result = first - second;
    }
    /**
     * Method multipys first and second.
     * @param first first num.
     */
    public void mul(double first, double second) {
        this.result = first * second;
    }
    /**
     * Method divides first by second.
     * @param first first num.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Method adds first to second.
     * @return result of mathemetic operation.
     */

    public double getResult() {
        return this.result;
    }
}
