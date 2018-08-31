package ru.vorotov.library.service;

import ru.vorotov.library.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAll();

    Genre get(String id);

    Genre save(Genre genre);

    Genre save(String genreName);

    boolean delete(String id);
}
