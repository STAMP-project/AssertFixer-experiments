package ru.vorotov.library.service;

import ru.vorotov.library.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAll();

    Author get(String id);

    Author save(Author genre);

    Author save(String fullName);

    boolean delete(String id);
}
