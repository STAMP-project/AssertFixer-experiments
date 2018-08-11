package ru.job4j.iterator;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Итератор четных чисел.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbers implements Iterator {

    private int[] massive;
    private int index = 0;

    EvenNumbers(int[] massive) {
        this.massive = massive;
    }

    @Override
    public Object next() {
        int result = 0;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        result = massive[index];
        index++;
        return result;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < massive.length; i++) { //проверяем от индекса до конца массива
            if (massive[i] % 2 == 0) {                 //если четное число
                result = true;                         //меняем результат
                index = i;                             //запоминаем его позицию
                break;                                 //выходим
            }
        }
        return result;
    }
}
