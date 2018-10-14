package com.cryptoeagle.service;

import com.cryptoeagle.AbstractTest;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.exception.IcoNotFoundException;
import com.cryptoeagle.service.abst.IcoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class IcoServiceImplTest extends AbstractTest {

    private static final int ICO_COUNT = 8;

    private static final int ICO_ID = 4634;

    private static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(2018, 10, 8, 10, 00, 00);
    private static final String ICO_NAME = "Zichain";

    @Autowired
    IcoService service;

    @Test
    public void getAll() {
        List<Ico> all = service.getAll();
        assertTrue(all.size() == ICO_COUNT);
    }

    @Test
    public void save() {
        Ico ico1 = new Ico();
        ico1.setName("test_ico1");
        ico1.setLogolink("test_logolink");
        ico1.setDescription("test_description");
        ico1.setWebsite_link("test_weblink");
        ico1.setRating(11111);

        Ico ico2 = new Ico();
        ico2.setName("test_ico2");
        ico2.setLogolink("test_logolink2");
        ico2.setDescription("test_description2");
        ico2.setWebsite_link("test_weblink2");
        ico2.setRating(333333333);
        service.save(Arrays.asList(ico1, ico2));

        List<Ico> all = service.getAll();
        assertTrue(all.size() == ICO_COUNT + 2);
    }



    @Test
    public void getUpcoming() {
        List<Ico> upcoming = service.getUpcoming();
        for (Ico ico : upcoming) {
            assertTrue(ico.getIcoStart().isAfter(LOCAL_DATE_TIME));
        }
    }

    @Test(expected = IcoNotFoundException.class)
    public void getUpcomingNotFound() {
        service.deletAll();
        List<Ico> upcoming = service.getUpcoming();
    }




    @Test(expected = IcoNotFoundException.class)
    public void getFinishedNotFound() {
        service.deletAll();
        List<Ico> finished = service.getFinished();
    }




    @Test
    public void getActiveIco() {
        List<Ico> active = service.getActive();
        for (Ico ico : active) {
            assertTrue(ico.getIcoEnd().isAfter(LocalDateTime.now()));
        }
        List<Ico> collect = service.getActive().stream().limit(6).collect(Collectors.toList());
    }

    @Test(expected = IcoNotFoundException.class)
    public void getActiveIcoNotFound() {
        service.deletAll();
        List<Ico> active = service.getActive();
    }

    @Test
    public void getById() {
        Ico ico = service.getById(ICO_ID);
        assertTrue(ico.getId() == ICO_ID);
        assertTrue(ico.getDescription() != null);
        assertTrue(ico.getLogolink() != null);
        assertTrue(ico.getWebsite_link() != null);
        assertTrue(ico.getName() != null);
    }

    @Test
    public void getByName() {
        Ico ico = service.getByName(ICO_NAME);
        assertTrue(ico.getName().equals(ICO_NAME));
        assertTrue(ico.getDescription() != null);
        assertTrue(ico.getLogolink() != null);
        assertTrue(ico.getWebsite_link() != null);
        assertTrue(ico.getName() != null);
    }

//    @Test
//    public void updateIcos() {
//        service.update();
//    }

    @Test
    public void deletAll() {
        service.deletAll();
        List<Ico> all = service.getAll();
        assertTrue(all.size() == 0);
    }

}