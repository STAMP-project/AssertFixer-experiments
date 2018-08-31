package ru.vorotov.library.dao;

import ru.vorotov.library.model.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> getAll();

    Author get(String id);

    Author save(Author genre);

    boolean delete(String id);
}
