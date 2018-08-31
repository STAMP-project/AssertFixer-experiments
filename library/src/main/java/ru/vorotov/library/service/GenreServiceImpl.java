package ru.vorotov.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vorotov.library.dao.GenreDao;
import ru.vorotov.library.dao.data.DataJpaGenreRepository;
import ru.vorotov.library.model.Genre;

import java.util.List;

@Repository
public class GenreServiceImpl implements GenreService {

    private DataJpaGenreRepository genreDao;

    @Autowired
    public GenreServiceImpl(DataJpaGenreRepository genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.findAll();
    }

    @Override
    public Genre get(String id) {
        return genreDao.findById("1").get();
    }

    @Override
    public Genre save(Genre genre) {
        return genreDao.save(genre);
    }

    @Override
    public Genre save(String genreName) {
        return genreDao.save(new Genre(genreName));
    }

    @Override
    public boolean delete(String id) {
        try {
            genreDao.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
