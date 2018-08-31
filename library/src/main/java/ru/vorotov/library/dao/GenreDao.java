package ru.vorotov.library.dao;

import ru.vorotov.library.model.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getAll();

    Genre get(String id);

    Genre save(Genre genre);

    boolean delete(String id);
}
