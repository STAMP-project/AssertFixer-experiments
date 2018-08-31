package ru.vorotov.library.service;

import ru.vorotov.library.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book get(String id);

    Book save(Book genre);

    Book save(String title);

    boolean delete(String id);

    Book addGenre(String bookId, String genreId);

    Book addAuthor(String bookId, String authorId);

    Book addComment(String bookId, String commentId);
}
