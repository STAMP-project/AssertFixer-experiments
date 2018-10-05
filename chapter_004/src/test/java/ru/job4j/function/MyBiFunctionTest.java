package ru.job4j.function;

import org.junit.Test;

import java.util.function.*;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MyBiFunctionTest {
    @Test
    public void whenLinearFunctionThenValueList() {
        double start = 10.0;
        double end = 20.0;
        BiFunction<Double, Double, Double> linearFunction = (x, y) -> y * x;
        MyBiFunction func1 = new MyBiFunction();
        List<Double> actual = func1.diapason(start, end, linearFunction);
        assertThat(actual, is(Arrays.asList(20.0, 22.0, 24.0, 26.0, 28.0, 30.0, 32.0, 34.0, 36.0, 38.0, 40.0)));
    }

    @Test
    public void whenSquaredFunctionThenValueList() {
        double start = 10.0;
        double end = 15.0;
        BiFunction<Double, Double, Double> squaredFunction = (x, y) -> y * Math.pow(x, 2.0);
        MyBiFunction func1 = new MyBiFunction();
        List<Double> actual = func1.diapason(start, end, squaredFunction);
        assertThat(actual, is(Arrays.asList(200.0, 242.0, 288.0, 338.0, 392.0, 450.0)));
    }

    @Test
    public void whenLogarithmicFunctionThenValueList() {
        MyBiFunction func1 = new MyBiFunction();
        double start = 10.0;
        double end = 15.0;
        BiFunction<Double, Double, Double> logarithmicFunction = (x, y) -> y * Math.log10(x);
        assertThat((func1.diapason(start, end, logarithmicFunction).get(0)), is(2.0));
    }
}