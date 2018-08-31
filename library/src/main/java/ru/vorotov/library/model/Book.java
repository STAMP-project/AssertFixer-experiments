package ru.vorotov.library.model;

import java.util.List;

public class Book extends AbstractEntity {
    public Book() {
    }

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    private List<Author> authors;

    private Genre genre;

    private List<Comment> comments;

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Book(String id, String title, List<Author> authors, Genre genre, List<Comment> comments) {
        super(id);
        this.title = title;
        this.authors = authors;
        this.genre = genre;
        this.comments = comments;
    }

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", genre=" + genre +
                ", comments=" + comments +
                '}';
    }
}