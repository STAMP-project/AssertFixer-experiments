package ru.job4j.cash;

public class Base {
    private final int id;

    public int getVersion() {
        return version;
    }

    public void updateVersion() {
        this.version++;
    }

    private int version;

    protected Base(final int id) {
        this.id = id;
        version = 0;
    }

    public int getId() {
        return id;
    }
}
