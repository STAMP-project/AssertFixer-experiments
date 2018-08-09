package ru.job4j.search;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Объект задача.
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}
