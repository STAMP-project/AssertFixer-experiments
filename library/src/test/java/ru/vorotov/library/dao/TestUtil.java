package ru.vorotov.library.dao;

import java.util.List;
import java.util.stream.Collectors;

public class TestUtil {

    public static final TestUtil of = new TestUtil();

    public <T> List<String> toListString(List<T> list) {
        return list.stream().map(Object::toString).collect(Collectors.toList());
    }
}
