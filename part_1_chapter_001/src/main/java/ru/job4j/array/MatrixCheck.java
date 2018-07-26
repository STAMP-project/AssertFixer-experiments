package ru.job4j.array;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Квадратный массив заполнен true или false по диагоналям.
 */
public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = false;
        boolean f = data[0][0];
        int g = data.length - 1;
        for (int i = 0; i < data.length; i++) {
            if (data[i][i] == data[g][i] == f) {
                g--;
                result = true;
            } else {
                i = data.length;
                result = false;
            }
        }
        return result;
    }
}