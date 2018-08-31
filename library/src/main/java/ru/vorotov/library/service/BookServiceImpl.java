package ru.vorotov.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vorotov.library.dao.AuthorDao;
import ru.vorotov.library.dao.BookDao;
import ru.vorotov.library.dao.CommentDao;
import ru.vorotov.library.dao.GenreDao;
import ru.vorotov.library.dao.data.DataJpaAuthorRepository;
import ru.vorotov.library.dao.data.DataJpaBookRepository;
import ru.vorotov.library.dao.data.DataJpaCommentRepository;
import ru.vorotov.library.dao.data.DataJpaGenreRepository;
import ru.vorotov.library.model.Author;
import ru.vorotov.library.model.Book;
import ru.vorotov.library.model.Comment;
import ru.vorotov.library.model.Genre;

import java.util.List;

@Repository
public class BookServiceImpl implements BookService {

    private final DataJpaBookRepository bookDao;

    private final DataJpaAuthorRepository authorDao;

    private final DataJpaCommentRepository commentDao;

    private final DataJpaGenreRepository genreDao;

    @Autowired
    public BookServiceImpl(DataJpaBookRepository bookDao, DataJpaAuthorRepository authorDao,
                           DataJpaCommentRepository commentDao,
                           DataJpaGenreRepository genreDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.commentDao = commentDao;
        this.genreDao = genreDao;
    }


    @Override
    public List<Book> getAll() {
        return bookDao.findAll();
    }

    @Override
    public Book get(String id) {
        return bookDao.findById(id).get();
    }

    @Override
    public Book save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book save(String title) {
        return bookDao.save(new Book(title));
    }

    @Override
    public Book addGenre(String bookId, String genreId) {
        Book book = bookDao.findById(bookId).get();
        Genre genre = genreDao.findById(genreId).get();
        book.setGenre(genre);
        return book;
    }

    @Override
    public Book addAuthor(String bookId, String authorId) {
        Book book = bookDao.findById(bookId).get();
        Author author = authorDao.findById(authorId).get() ;
        book.getAuthors().add(author);
        return book;
    }

    @Override
    public Book addComment(String bookId, String commentId) {
        Book book = bookDao.findById(bookId).get();
        Comment comment = commentDao.findById(commentId).get();
        book.getComments().add(comment);
        return book;
    }

    @Override
    public boolean delete(String id) {
        try {
            bookDao.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
