package ru.job4j.loop;
/**CounterTest.
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *@version $Id$
 *@since 0.1
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    /**
     *Test add..
     */ @Test
    public void whenStart1Finish10ThenSum30() {
        Counter sum1 = new Counter();
        int result = sum1.add(1, 10);
        assertThat(result, is(30));
    }
}
