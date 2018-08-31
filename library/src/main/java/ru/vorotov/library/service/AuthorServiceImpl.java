package ru.vorotov.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vorotov.library.dao.AuthorDao;
import ru.vorotov.library.dao.data.DataJpaAuthorRepository;
import ru.vorotov.library.model.Author;

import java.util.List;

@Repository
public class AuthorServiceImpl implements AuthorService {

    private DataJpaAuthorRepository authorDao;

    @Autowired
    public AuthorServiceImpl(DataJpaAuthorRepository authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public List<Author> getAll() {
        return authorDao.findAll();
    }

    @Override
    public Author get(String id) {
        return authorDao.findById(id).get();
    }

    @Override
    public Author save(Author author) {
        return authorDao.save(author);
    }

    @Override
    public Author save(String fullName) {
        return authorDao.save(new Author(fullName));
    }

    @Override
    public boolean delete(String id) {
        try {
            authorDao.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
