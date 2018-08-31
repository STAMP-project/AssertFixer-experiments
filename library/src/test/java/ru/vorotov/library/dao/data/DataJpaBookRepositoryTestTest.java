package ru.vorotov.library.dao.data;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vorotov.library.AbstractServiceTest;
import ru.vorotov.library.model.Book;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static ru.vorotov.library.dao.BookTestData.BOOK1;

public class DataJpaBookRepositoryTestTest extends AbstractServiceTest {

    @Autowired
    DataJpaBookRepository bookDao;

    @Test
    public void testGet() {
        bookDao.save(BOOK1);

        Book actual = bookDao.findById("1").get();
        String value = actual.toString();

        System.out.println(value);

        String actual1 = BOOK1.toString();
        assertThat(actual1, is(value));
    }

}