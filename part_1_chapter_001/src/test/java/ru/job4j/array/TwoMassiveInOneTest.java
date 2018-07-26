package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TwoMassiveInOneTest {
    @Test
    public void oneS() {
        TwoMassiveInOne turner = new TwoMassiveInOne();
        int[] oneinput = new int[] {1, 3, 5, 7, 9, 10, 11};
        int[] twoinput = new int[] {2, 4, 6, };
        int[] result = turner.twoInOne(oneinput, twoinput);
        int[] expect = new int[] {1, 2, 3, 4, 5, 6, 7, 9, 10, 11};
        assertThat(result, is(expect));
    }

    @Test
    public void twoS() {
        TwoMassiveInOne turner = new TwoMassiveInOne();
        int[] oneinput = new int[] {1, 3, 5, 7, 9, 10, 11, 15};
        int[] twoinput = new int[] {2, 8, 15, 16, 20, 25, 26, 27, 28};
        int[] result = turner.twoInOne(oneinput, twoinput);
        int[] expect = new int[] {1, 2, 3, 5, 7, 8, 9, 10, 11, 15, 15, 16, 20, 25, 26, 27, 28};
        assertThat(result, is(expect));
    }
}