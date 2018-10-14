package com.cryptoeagle.service;

import com.cryptoeagle.AbstractTest;
import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.service.abst.BlogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class BlogServiceImplTest extends AbstractTest {

    private static final int USER2_ID = 100092;

    private static final int USER2_BLOG_COUNT = 3;

    private static final int BLOG_COUNT = 8;

    private static final int BLOG_ID = 100172;

    private static final String BLOG_NAME = "minergate";

    @Autowired
    BlogService service;

    @Test
    public void deleteAll() {
        service.deleteAll();
        List<Blog> all = service.getAll();
        assertTrue(all.size() == 0);
    }

    @Test
    public void deleteByName() {
        service.deleteByName(BLOG_NAME);
        List<Blog> all = service.getAll();
        assertTrue(all.size() == BLOG_COUNT - 1);
    }

    @Test
    public void save() {
        Blog blog = new Blog("coingape", "https://coingape.com/feed/");
        service.save(blog, USER2_ID);
        List<Blog> all = service.getAll();
        assertTrue(all.size() == BLOG_COUNT + 1);
    }

    @Test
    public void update() {
    }

    @Test
    public void findAllByUser() {
        List<Blog> all = service.findAllByUser(USER2_ID);
        assertTrue(all.size() == USER2_BLOG_COUNT);
    }

    @Test
    public void getByName() {
        Blog blog = service.getByName(BLOG_NAME);
        assertTrue(blog.getName().equals(BLOG_NAME));
    }

    @Test
    public void delete() {
        service.delete(BLOG_ID, USER2_ID);
        List<Blog> all = service.getAll();
        assertTrue(all.size() == BLOG_COUNT - 1);
    }

    @Test
    public void getAll() {
        List<Blog> all = service.getAll();
        assertTrue(all.size() == BLOG_COUNT);
    }

//    @Test
//    public void updateFromRss() {
//        service.update();
//    }
}