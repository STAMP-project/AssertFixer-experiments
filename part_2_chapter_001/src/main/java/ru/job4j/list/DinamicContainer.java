package ru.job4j.list;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Динамический список на базе массива.
 */
import java.util.*;

public class DinamicContainer<E extends Object> implements SimpleArray<E> {

    private int position;
    private E[] array;
    private int modification = 0;
    private int expectedModification = 0;

    public DinamicContainer(int size) {
        this.array = (E[]) new Object[size];
    }

    public void add(E model) {
        reSize();
        array[position++] = model;
        modification++;
    }

    private void reSize() {
        if (position >= array.length) {
            E[] newArray = (E[]) new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            this.array = newArray;
        }
    }

    public E get(int index) {
        return array[index];
    }

    public boolean change() {
        boolean result = false;
        if (expectedModification != modification) {
            result = true;
        }
        return result;
    }



    @Override
    public ListIterator<E> iterator() {
        return new ListIterator<E>() {
            private int index = 0;
            private int next = 0;
            private int previous = 0;
            @Override
            public boolean hasNext() {
                if (index == 0) {
                    expectedModification = modification;
                }
                if (change()) {
                    throw new ConcurrentModificationException();
                }
                boolean result = false;
                if (index < position) {
                    result = true;
                    next++;
                    index++;
                }
                return result;
            }
            @Override
            public E next() {
                if (index == 0) {
                    expectedModification = modification;
                }
                if (change()) {
                    throw new ConcurrentModificationException();
                }
                E result = null;
                if (index < position) {
                    result = array[index];
                    index++;
                    next++;
                } else {
                    throw new NoSuchElementException();
                }
                return result;
            }
            @Override
            public boolean hasPrevious() {
                boolean result = false;
                if (index == 0) {
                    expectedModification = modification;
                }
                if (change()) {
                    throw new ConcurrentModificationException();
                }
                index--;
                if (index >= 0) {
                    result = true;
                }
                return result;
            }
            @Override
            public E previous() {
                index--;
                if (change()) {
                    throw new ConcurrentModificationException();
                }
                E result = null;
                if (index > 0 && index < position) {
                    expectedModification = modification;
                    result = get(index - 1);
                    previous++;
                } else {
                    index++;
                    throw new NoSuchElementException();
                }
                return result;
            }
            @Override
            public int nextIndex() {
                if (index == 0) {
                    expectedModification = modification;
                }
                if (change()) {
                    throw new ConcurrentModificationException();
                }
                int result = position;
                if (index < position) {
                    result = index + 1;
                    index++;
                }
                return result;
            }
            @Override
            public int previousIndex() {
                if (index == 0) {
                    expectedModification = modification;
                }
                if (change()) {
                    throw new ConcurrentModificationException();
                }
                int result = -1;
                if (index >= 0) {
                    result = index - 1;
                    index--;
                }
                return result;
            }
            @Override
            public void remove() {
                if (index == 0) {
                    expectedModification = modification;
                }
                if (change()) {
                    throw new ConcurrentModificationException();
                }
                if (next > 0 || previous > 0) {
                    System.arraycopy(array, index, array, index - 1, position - index);
                    modification++;
                } else {
                    throw new IllegalStateException();
                }
            }
            @Override
            public void set(E e) {
                if (index == 0) {
                    expectedModification = modification;
                }
                if (change()) {
                    throw new ConcurrentModificationException();
                }
                if (index < position) {
                    array[index] = e;
                }
            }
            @Override
            public void add(E e) {
                if (index == 0) {
                    expectedModification = modification;
                }
                if (change()) {
                    throw new ConcurrentModificationException();
                }
                if (index < position) {
                    System.arraycopy(array, index, array, index + 1, position - index);
                    array[index] = e;
                    position++;
                    modification++;
                }
            }
        };
    }
}
