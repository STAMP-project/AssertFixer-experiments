package ru.vorotov.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.vorotov.library.model.Book;
import ru.vorotov.library.service.AuthorService;
import ru.vorotov.library.service.BookService;
import ru.vorotov.library.service.CommentService;
import ru.vorotov.library.service.GenreService;

import java.util.List;

@ShellComponent
public class ShellService {

    private final BookService bookService;

    private final AuthorService authorService;

    private final GenreService genreService;

    private final CommentService commentService;

    @Autowired
    public ShellService(BookService bookService,
                        AuthorService authorService,
                        GenreService genreService,
                        CommentService commentService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
        this.commentService = commentService;
    }

    @ShellMethod("List all known books")
    public void books() {
        List<Book> all = bookService.getAll();
        System.out.println(all);
    }

    @ShellMethod("getbook")
    public void getbook(String i) {
        System.out.println(bookService.get(i));
    }

    @ShellMethod("List all known authors")
    public void authors() {
        System.out.println(authorService.getAll());
    }

    @ShellMethod("comments")
    public void comments() {
        System.out.println(commentService.getAll());
    }

    @ShellMethod("saveauthor")
    public void saveauthor(String name) {
        System.out.println(authorService.save(name));
    }

    @ShellMethod("savegenre")
    public void savegenre(String genreName) {
        System.out.println(genreService.save(genreName));
    }

    @ShellMethod("savecomment")
    public void savecomment(String commentText) {
        System.out.println(commentService.save(commentText));
    }

    @ShellMethod("savebook")
    public void savebook(String name) {
        System.out.println(bookService.save(name));
    }

    @ShellMethod("addcomment")
    public void addcomment(String bookId, String commentId) {
        System.out.println(bookService.addComment(bookId, commentId));
    }

    @ShellMethod("addgenre")
    public void addgenre(String bookId, String genreId) {
        System.out.println(bookService.addGenre(bookId, genreId));
    }

    @ShellMethod("addgenre")
    public void addauthor(String bookId, String authorId) {
        System.out.println(bookService.addAuthor(bookId, authorId));
    }
}
