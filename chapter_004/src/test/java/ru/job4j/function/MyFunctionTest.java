package ru.job4j.function;

import org.junit.Test;

import java.util.function.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MyFunctionTest {
    @Test
    public void whenLinearFunctionThenValueList() {
        double start = 10.0;
        double end = 20.0;
        Function<Double, Double> linearFunction = (x) -> x;
        MyFunction func1 = new MyFunction();
        assertThat((func1.diapason(start, end, linearFunction).get(1)), is(12.0));
    }

    @Test
    public void whenSquaredFunctionThenValueList() {
        double start = 10.0;
        double end = 20.0;
        Function<Double, Double> squaredFunction = (x) -> Math.pow(x, 2.0);
        MyFunction func1 = new MyFunction();
        assertThat((func1.diapason(start, end, squaredFunction).get(1)), is(144.0));
    }

    @Test
    public void whenLogarithmicFunctionThenValueList() {
        MyFunction func1 = new MyFunction();
        double start = 10.0;
        double end = 20.0;
        Function<Double, Double> logarithmicFunction = (x) -> Math.log10(x);
        assertThat((func1.diapason(start, end, logarithmicFunction).get(0)), is(1.0));
    }
}