package ru.vorotov.library.model;


public class Comment extends AbstractEntity {

    public Comment() {
    }

    public Comment(String commentText) {
        this.text = commentText;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    private String text;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    private Book book;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + getId() + '\'' +
                "text='" + text + '\'' +
                '}';
    }
}
