package ru.job4j.iterator;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator<Integer> {
    private int[] array;
    int index = 0;

    public PrimeIterator(int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {

        boolean result = false;
        while (array.length > index) {
            if (isPrime(array[index])) {
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException("No Such Element");
        }
        return array[index++];
    }


    private boolean isPrime(int n) {
        BigInteger bigInteger = BigInteger.valueOf(n);
        return bigInteger.isProbablePrime((int) Math.log(n)) && n >= 2;
    }
}
