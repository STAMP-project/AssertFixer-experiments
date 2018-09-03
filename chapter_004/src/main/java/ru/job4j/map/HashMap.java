package ru.job4j.map;

import java.util.Arrays;

public class HashMap<K, V> implements Map<K, V> {

    private int capacity = 16;
    private V[] mainArray;

    public HashMap() {
        mainArray = (V[]) new Object[capacity];
    }

    @Override
    public boolean insert(K key, V value) {
        boolean result = false;
        if (mainArray[getIndex(key)] == null) {
            if (!getFilledFields()) {
                mainArray[getIndex(key)] = value;
                result = true;
            } else {
                mainArray = createNewArray();
                if (mainArray[getIndex(key)] == null) {
                    result = insert(key, value);
                }
            }
        }
        return result;
    }

    @Override
    public V get(K key) {
        return mainArray[getIndex(key)];
    }

    @Override
    public boolean delete(K key) {
        boolean result = false;
        if (!(mainArray[getIndex(key)] == null)) {
            mainArray[getIndex(key)] = null;
            result = true;
        }
        return result;
    }

    private int getIndex(K key) {
        int result = 0;
        result = key.hashCode() % capacity;
        return result;
    }

    /*
    Here we check if array is filled enough to enlarge array
    true if array is almost full;
     */
    private boolean getFilledFields() {
        double fillRate = 0.75;
        int finalRate = (int) (capacity * fillRate);
        boolean result = false;
        for (V value : mainArray) {
            if (value != null) {
                finalRate--;
            }
            if (finalRate <= 0) {
                result = true;
            }
        }
        return result;
    }

    private V[] createNewArray() {
        capacity *= 2;
        return Arrays.copyOf(mainArray, capacity);
    }
}
