package ru.job4j.calculator;
/**
 *Программа расчёта идеального веса.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *@version $Id$
 *@since 0.1
 */
public class Fit {
    /**
     * Идеальный вес для мужчины.
     *
     * @param height Рост в см.
     * @return идеальный вес в кг.
     */
    double manWeight(double height) {
        return ((height - 100) * 1.15);
    }

    /**
     * Идеальный вес для женщины.
     *
     * @param height Рост в см.
     * @return идеальный вес в кг.
     */
    double womanWeight(double height) {
        return ((height - 110) * 1.15);
    }
}
