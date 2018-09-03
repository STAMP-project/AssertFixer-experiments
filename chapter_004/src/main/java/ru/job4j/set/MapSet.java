package ru.job4j.set;


import java.util.Arrays;

public class MapSet<E> {

    private int index = 0;
    private int capacity = 3;
    E[] setArray = (E[]) new Object[capacity]; //main array for data

    private int getPosition(E value) {
        return Math.abs(value.hashCode()) % capacity;
    }


    public boolean add(E value) {

        boolean result = true;
        if (!contains(value)) {
            if (setArray[getPosition(value)] == null) {
                setArray[getPosition(value)] = value;
            }
        } else {
            result = false;
        }

        return result;
    }

    public boolean contains(E value) {
        boolean result = false;

        if (setArray[getPosition(value)] != null && value.equals(setArray[getPosition(value)])) {
            result = true;
        } else {
            for (int i = getPosition(value); i < setArray.length; i++) {  //main loop for finding equals
                if (value.equals(setArray[i])) {
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean remove(E value) {
        boolean result = false;
        if (contains(value)) {
            setArray[getPosition(value)] = null;
            result = true;
        }
        return result;
    }

}
