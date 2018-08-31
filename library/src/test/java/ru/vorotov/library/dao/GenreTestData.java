package ru.vorotov.library.dao;

import ru.vorotov.library.model.Genre;

import java.util.Arrays;
import java.util.List;

public class GenreTestData {

    public static final Genre GENRE1 = new Genre("1", "Классика");
    public static final Genre GENRE2 = new Genre("2", "Фантастика");
    public static final Genre GENRE3 = new Genre("3", "Детские книги");

    public static final List<Genre> GENRES = Arrays.asList(GENRE1, GENRE2, GENRE3);

}
