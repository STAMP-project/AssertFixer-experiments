package ru.job4j.max;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Класс Max вычисляет наибольшее из трех чисел.
 */
public class Max {
    private int first;
    private int second;
    private int third;

    public Max(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    public int maxthree(int first, int second, int third) {
        return this.max((this.max(first, second)), third);
    }
}