package ru.job4j.tracker;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Ошибка выбора пункта меню.
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}