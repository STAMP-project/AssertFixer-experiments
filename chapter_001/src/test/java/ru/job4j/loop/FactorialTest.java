package ru.job4j.loop;

/**
 * Test.
 *
 * 4.2. Создать программу вычисляющую факториал
 *
 * @author Sergey Petrov (sergey45684745@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class FactorialTest {
    @Test
    public  void whenWeGiveFiveWeGetOneHuntredTwelve() {
        Factorial factorial = new Factorial();
        long result =  factorial.getFactorial(5);
        long expected = 120;
        assertThat(result, is(expected));
    }

}
