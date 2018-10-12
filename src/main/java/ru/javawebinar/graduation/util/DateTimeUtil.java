package ru.javawebinar.graduation.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeUtil {

    public static LocalTime TIME_END_VOTING = LocalTime.of(11, 0);

    public static final LocalDate MIN_DATE = LocalDate.of(1, 1, 1);
    public static final LocalDate MAX_DATE = LocalDate.of(3000, 1, 1);

    private DateTimeUtil() {
    }

    public static LocalDate parseLocalDate(String str) {
        return StringUtils.isEmpty(str) ? null : LocalDate.parse(str);
    }

    public static  LocalDate orElse(LocalDate value, LocalDate defaultValue) {
        return value == null ? defaultValue : value;
    }
}

