package ru.job4j.max;

        import org.junit.Test;
        import static org.hamcrest.core.Is.is;
        import static org.junit.Assert.assertThat;
/**
 * Test.
 *
 * @author Egor Novikov (e.novikov@yahoo.com)
 * @version 1
 * @since 04.06.2018
 */
public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max(4, 2, 6);
        int result = maxim.max(4, 2);
        assertThat(result, is(4));
    }
    @Test
    public void whenFirstLessSecondLessThird() {
        Max maxim = new Max(4, 2, 6);
        int result = maxim.maxthree(4, 2, 6);
        assertThat(result, is(6));
    }
}