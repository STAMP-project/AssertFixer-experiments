package ru.job4j.array;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Поиск в массиве перебором.
 */
public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}