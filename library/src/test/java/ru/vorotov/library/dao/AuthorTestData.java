package ru.vorotov.library.dao;

import ru.vorotov.library.model.Author;

import java.util.Arrays;
import java.util.List;

public class AuthorTestData {

    public static final Author AUTHOR1 = new Author("1", "Сергей Лукьяненко");
    public static final Author AUTHOR2 = new Author("2", "Алексей Пехов");
    public static final Author AUTHOR3 = new Author("3", "Лондон Джек");
    public static final Author AUTHOR4 = new Author("4", "Брэм Стокер");

    public static final Author AUTHOR5 = new Author("5", "Борис Акунин");

    public static final List<Author> AUTHORS = Arrays.asList(AUTHOR1, AUTHOR2, AUTHOR3, AUTHOR4, AUTHOR5);

}
