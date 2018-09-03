package ru.job4j.array;

import org.junit.Test;
import ru.job4j.max.Max;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
        @Test
        public void when123then149() {
            Square square = new Square();
            int[] result = square.calculate(3);
            int[] expected = new int[]{1, 4, 9};
            assertThat(result, is(expected));
        }
}
