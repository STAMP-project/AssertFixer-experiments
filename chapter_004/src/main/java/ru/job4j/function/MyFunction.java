package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class MyFunction {

    final double step = 2.0;

    List<Double> diapason(double start, double end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (double i = start; i <= end; i += step) {
            result.add(func.apply(i));
        }
        return result;
    }
}