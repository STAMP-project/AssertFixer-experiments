package com.brave.tradebravely.service.util;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public final class DateHelper {

    private static final DateTimeFormatter EXPIRY_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("EEE, dd MMM yyyy HH:mm:ss zzz")
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    private DateHelper() {
    }

    public static Instant parseInstant(final CharSequence dateString) {
        return EXPIRY_FORMATTER.parse(dateString, Instant::from);
    }
}
