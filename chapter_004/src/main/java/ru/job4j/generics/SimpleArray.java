package ru.job4j.generics;

public class SimpleArray<T> {
    Object[] array;
    int index = 0;
    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        this.array[this.index++] = model;
    }

    public  void set(int index, T model) {
        this.array[index] = model;
    }

    public  void delete(int index) {
        this.array[index] = null;
    }

    public  T get(int index) {
        return (T) this.array[index];
    }
}
