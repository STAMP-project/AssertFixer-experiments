package ru.job4j.lambda;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Подсчет функций в диапазоне.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaFunctions {

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        ArrayList<Double> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(func.apply((double) i));
        }
        return result;
    }
}
