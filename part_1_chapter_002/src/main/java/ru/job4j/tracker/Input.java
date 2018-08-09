package ru.job4j.tracker;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 */
public interface Input {
    String ask(String question);

    int ask(String question, int[] range);
}