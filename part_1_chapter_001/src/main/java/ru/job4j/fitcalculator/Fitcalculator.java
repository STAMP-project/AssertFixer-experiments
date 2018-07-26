package ru.job4j.fitcalculator;

/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Программа расчета идеального веса.
 */
public class Fitcalculator {
    /**
     * Идеальный вес для мужщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return ((height - 100) * 1.15);
    }
    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return ((height - 110) * 1.15);
    }
}
