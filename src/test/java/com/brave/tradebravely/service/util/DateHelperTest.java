package com.brave.tradebravely.service.util;

import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.*;

public class DateHelperTest {

    @Test
    public void parseInstant() {
        final long expectedSeconds = 1531589967L;
        final Instant instant = DateHelper.parseInstant("Sat, 14 Jul 2018 17:39:27 GMT");
        final long actualSeconds = instant.getEpochSecond();
        assertEquals(expectedSeconds, actualSeconds);
    }
}
