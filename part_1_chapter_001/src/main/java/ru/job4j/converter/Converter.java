package ru.job4j.converter;

/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Корвертор валюты.
 */
public class Converter {
    /**
     * Объявление переменных euro, dollar.
     */
    private int euro;
    private int dollar;
    /**
     * Конструктор класса Converter. Инициализация переменных euro, dollar.
     */
    public Converter(int euro, int dollar) {
        this.euro = euro;
        this.dollar = dollar;
    }
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return евро.
     */

    public int rubleToEuro(int value) {
        return (value * euro);
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли.
     */
    public int euroToRuble(int value) {
        return (value / euro);
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return доллары.
     */
    public int rubleToDollar(int value) {
        return (value * dollar);
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли.
     */
    public int dollarToRuble(int value) {
        return (value / dollar);
    }
}
