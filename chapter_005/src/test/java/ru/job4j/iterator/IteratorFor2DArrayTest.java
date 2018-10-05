package ru.job4j.iterator;

        import org.junit.Test;

        import java.util.Iterator;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.Matchers.is;

public class IteratorFor2DArrayTest {
    @Test
    public void whenSquaredMassiveThenWorkingNext() {
        IteratorFor2DArray it = new IteratorFor2DArray(new int[][]{{1, 2}, {3, 4}});
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
    }
}