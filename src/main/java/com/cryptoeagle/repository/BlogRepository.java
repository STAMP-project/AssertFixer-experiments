package com.cryptoeagle.repository;

import com.cryptoeagle.entity.Blog;


import java.util.List;

public interface BlogRepository {

    Blog save(Blog blog, int user );

    void delete(Blog blog);

    void delete(int id, int user);

    void deleteByName(String name);

    Blog getByName(String name);

    List<Blog> getAllByUser(int user);

    List<Blog> getAll();
}
