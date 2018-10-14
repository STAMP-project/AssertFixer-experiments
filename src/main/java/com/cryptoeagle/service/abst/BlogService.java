package com.cryptoeagle.service.abst;

import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.Item;

import java.util.List;

public interface BlogService {

    void save(Blog blog, int user_id);

    void update(Blog blog, int user_id);

    void delete(int blog_int, int user_id);

    void delete(Blog blog);

    void deleteByName(String name);

    void deleteAll();

    List<Blog> findAllByUser(int user_id);

    List<Blog> getAll();

    Blog getByName(String name);

    public void update();

}
