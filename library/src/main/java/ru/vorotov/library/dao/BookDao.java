package ru.vorotov.library.dao;

import ru.vorotov.library.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAll();

    Book get(String id);

    Book save(Book genre);

    boolean delete(String id);
}
