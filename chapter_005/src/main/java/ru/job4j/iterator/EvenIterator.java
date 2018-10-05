package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private int i = 0;
    private int[] numbers = new int[i];
    private int size;

    public EvenIterator(int[] numbers) {
        this.numbers = numbers;
        this.size = numbers.length;
    }

    @Override
    public boolean hasNext() {
        boolean rst = false;
        for (; this.i < this.size; i++) {
            if (this.numbers[i] % 2 == 0) {
                rst = true;
                break;
            }
        }
        return rst;
    }

    @Override
    public Integer next() {
        if (i > size) {
            throw new NoSuchElementException();
        }
        int element = 0;
        for (; i < size; i++) {
            if (numbers[i] % 2 == 0) {
                element = numbers[i];
                i++;
                break;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        EvenIterator it = new EvenIterator(new int[]{4, 2, 1, 1});
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.hasNext());
    }
}