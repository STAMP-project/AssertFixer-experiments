package ru.vorotov.library.dao;

import ru.vorotov.library.model.Book;

import java.util.ArrayList;
import java.util.Arrays;

import static ru.vorotov.library.dao.AuthorTestData.AUTHOR1;
import static ru.vorotov.library.dao.AuthorTestData.AUTHOR3;
import static ru.vorotov.library.dao.GenreTestData.GENRE2;

public class BookTestData {

    public static final Book BOOK1 = new Book("1", "Черновик", Arrays.asList(AUTHOR1, AUTHOR3), GENRE2, new ArrayList<>());
}
