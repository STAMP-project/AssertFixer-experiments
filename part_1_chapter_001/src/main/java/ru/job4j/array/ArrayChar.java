package ru.job4j.array;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Проверяет что слово начинается с префикса.
 */
public class ArrayChar {
    private char[] data;
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }
    /**
     * @param prefix префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        if (value.length <= data.length) {
            for (int index = 0; index < value.length; index++) {
                if (value[index] != data[index]) {
                    result = false;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
    }
