package ru.job4j.iterator;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * Итератор итераторов.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> iterators) {
        return new Iterator<Integer>() {
            Iterator<Integer> it;
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (it == null || !it.hasNext()) {
                    while (iterators.hasNext()) {
                        it = iterators.next();
                        if (it.hasNext()) {
                            result = true;
                            break;
                        }
                    }
                }
                if (it != null && it.hasNext()) {
                    result = true;
                }
                return result;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return it.next();
            }
        };
    }
}


