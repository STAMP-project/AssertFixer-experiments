package ru.job4j.loop;

        import org.junit.Test;
        import static org.hamcrest.core.Is.is;
        import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void whenStart1Finish10() {
        Counter test = new Counter();
        int result = test.add(1, 10);
        assertThat(result, is(30));
    }
}