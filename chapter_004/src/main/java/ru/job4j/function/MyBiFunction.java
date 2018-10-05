package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class MyBiFunction {

    final double k = 2.0;

    List<Double> diapason(double start, double end, BiFunction<Double, Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (; start <= end; start++) {
            result.add(func.apply(start, k));
        }
        return result;
    }
}