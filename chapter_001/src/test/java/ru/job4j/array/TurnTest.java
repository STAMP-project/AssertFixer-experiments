package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void when123then321() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[]{1, 2, 3});
        int[] expected = new int[]{3, 2, 1};
        assertThat(result, is(expected));
    }
    @Test
    public void when1234then4321() {
        Turn turn = new Turn();
        int[] result = turn.back(new int[]{1, 2, 3, 4});
        int[] expected = new int[]{4, 3, 2, 1};
        assertThat(result, is(expected));
    }
}
