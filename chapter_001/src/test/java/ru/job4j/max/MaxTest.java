package ru.job4j.max;
/**MaxTest
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *@version $Id$
 *@since 0.1
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    /**
     *Test max.
     */ @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(2, 1);
        assertThat(result, is(2));
    }
    /**
     *Test maxOfThree.
     */ @Test
    public void whenFirstLessSecondAndThird() {
        Max maxim = new Max();
        int result = maxim.maxOfThree(0, 3, 4);
        assertThat(result, is(4));
    }
}
