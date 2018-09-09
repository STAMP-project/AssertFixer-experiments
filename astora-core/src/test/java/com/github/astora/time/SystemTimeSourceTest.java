package com.github.astora.time;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SystemTimeSourceTest {

    private SystemTimeSource underTest;

    @Before
    public void setUp() {
        underTest = new SystemTimeSource();
    }

    @Test
    public void shouldReturnCurrentTimeInMilliseconds() {
        assertTrue(underTest.currentTimeMillis() > 0L);
    }

    @Test
    public void shouldReturnCurrentTimeInMicroseconds() {
        assertTrue(underTest.currentTimeMicros() > 0L);
    }

    @Test
    public void shouldReturnCurrentTimeInNanoseconds() {
        assertTrue(underTest.currentTimeNanos() > 0L);
    }
}
