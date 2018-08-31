package ru.vorotov.library.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vorotov.library.AbstractServiceTest;
import ru.vorotov.library.model.Author;
import ru.vorotov.library.model.Book;
import ru.vorotov.library.model.Comment;
import ru.vorotov.library.model.Genre;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ru.vorotov.library.dao.BookTestData.BOOK1;

public class BookServiceTest extends AbstractServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testGet() {
        Book actual = bookService.get("1");
        String actual1 = BOOK1.toString();
        assertThat(actual1, is(actual.toString()));
    }

    @Test
    public void saveBook() {
        Book book = new Book("title1");
        book.setGenre(new Genre("genre1"));
        book.setAuthors(Collections.singletonList(new Author("author1")));
        book.setComments(Collections.singletonList(new Comment("Comment1")));

        Book save = bookService.save(book);

        Book expectedBook = bookService.get(book.getId());

        book.setId(save.getId());

        assertThat(expectedBook.toString(), is(save.toString()));

    }


}