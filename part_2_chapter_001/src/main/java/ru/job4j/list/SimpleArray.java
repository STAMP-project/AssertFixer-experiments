package ru.job4j.list;

public interface SimpleArray<E> extends Iterable<E> {

    public void add(E date);

    public E get(int index);
}
