package ru.vorotov.library.dao.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.vorotov.library.AbstractServiceTest;
import ru.vorotov.library.dao.TestUtil;
import ru.vorotov.library.model.Author;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ru.vorotov.library.dao.AuthorTestData.*;


public class DataJpaAuthorRepositoryTest extends AbstractServiceTest {

    @Autowired
    public DataJpaAuthorRepository authorDao;

    @Test
    public void testGetAll() throws Exception {
        authorDao.save(AUTHOR1);
        authorDao.save(AUTHOR2);
        authorDao.save(AUTHOR3);
        authorDao.save(AUTHOR4);
        authorDao.save(AUTHOR5);

        List<Author> all = authorDao.findAll();
        assertThat(TestUtil.of.toListString(AUTHORS) , is(TestUtil.of.toListString(all)));
    }

    @Test
    public void testGet() throws Exception {
        authorDao.save(AUTHOR1);

        Author actual = authorDao.findById("1").get();
        assertThat(AUTHOR1.toString(), is(actual.toString()));
    }

    @Test
    @Transactional
    public void testSave() throws Exception {
        Author authorSave = authorDao.findById(AUTHOR1.getId()).get();
        String newAuthor = "newauthor";
        authorSave.setFullName(newAuthor);
        authorDao.save(authorSave);

        assertThat(authorSave.toString() , is(authorDao.findById(AUTHOR1.getId()).get().toString()));
    }

    @Test
    @Transactional
    public void testDelete() {
        authorDao.save(AUTHOR1);
        authorDao.save(AUTHOR2);
        authorDao.save(AUTHOR3);
        authorDao.save(AUTHOR4);
        authorDao.save(AUTHOR5);

        List<Author> AUTHORS = Arrays.asList(AUTHOR1, AUTHOR2, AUTHOR3, AUTHOR4);

        authorDao.deleteById(AUTHOR5.getId());
        assertThat(TestUtil.of.toListString(authorDao.findAll()) , is(TestUtil.of.toListString(AUTHORS)));
    }
}