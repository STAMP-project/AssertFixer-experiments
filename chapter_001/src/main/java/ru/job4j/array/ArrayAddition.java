package ru.job4j.array;

public class ArrayAddition {
    public int[] addArray(int[] array1, int[] array2) {
        int size = array1.length + array2.length;
        int[] result = new int[size];
        int index = 0, indexSecond = 0, indexFirst = 0;
        while (indexFirst < array1.length && indexSecond < array2.length) {
            result[index++] = array1[indexFirst] < array2[indexSecond]
                    ? array1[indexFirst++] : array2[indexSecond++];
        }
        if (indexFirst < array1.length) {
            System.arraycopy(array1, indexFirst, result, index, array1.length - indexFirst);
        } else if (indexSecond < array2.length) {
            System.arraycopy(array2, indexSecond, result, index, array2.length - indexSecond);
        }
        return  result;
    }


}
