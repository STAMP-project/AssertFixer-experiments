package ru.job4j.tracker;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Интерфейс действий пользователя.
 */
public interface UserAction {

    int key();

    void execute(Input input, Tracker tracker);

    String info();
}