package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenThisMassiv() {
        ArrayDuplicate check = new ArrayDuplicate();
        String[] input = new String[]{"Хорошо", "Хорошо", "Отлично", "Удовлетворительно", "Отлично"};
        String[] result = new String[]{"Хорошо", "Отлично", "Удовлетворительно"};
        String[] res = check.remove(input);
        assertThat(res, is(result));
    }
}