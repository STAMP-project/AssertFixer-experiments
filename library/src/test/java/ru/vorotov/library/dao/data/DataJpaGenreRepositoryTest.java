package ru.vorotov.library.dao.data;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vorotov.library.AbstractServiceTest;
import ru.vorotov.library.dao.TestUtil;
import ru.vorotov.library.model.Genre;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ru.vorotov.library.dao.GenreTestData.*;

public class DataJpaGenreRepositoryTest extends AbstractServiceTest {

    @Autowired
    public DataJpaGenreRepository genreDao;

    @Test
    public void testGetAll() {
        genreDao.save(GENRE1);
        genreDao.save(GENRE2);
        genreDao.save(GENRE3);

        List<Genre> all = genreDao.findAll();
        assertThat(TestUtil.of.toListString(GENRES) , is(TestUtil.of.toListString(all)));
    }

    @Test
    public void testGet() {

        genreDao.save(GENRE1);

        Genre actual = genreDao.findById("1").get();
        assertThat(GENRE1.toString(), is(actual.toString()));
    }

    @Test
    @Transactional
    public void testSave() {
        genreDao.save(GENRE1);

        Genre genreSave = genreDao.findById(GENRE1.getId()).get();
        String newGenre = "newgenre";
        genreSave.setName(newGenre);
        genreDao.save(genreSave);

        assertThat(genreSave.toString(), is(genreDao.findById(GENRE1.getId()).get().toString()));
    }

    @Test
    @Transactional
    public void testDelete() {
        genreDao.save(GENRE1);
        genreDao.save(GENRE2);
        genreDao.save(GENRE3);

        List<Genre> GENRES = Arrays.asList(GENRE1, GENRE2);

        genreDao.deleteById(GENRE3.getId());
        assertThat(TestUtil.of.toListString(genreDao.findAll()),
                is(TestUtil.of.toListString(GENRES)));
    }
}