package com.mum.news.ea.blog.repositories;

/**
 * User: franc
 * Date: 21/09/2018
 * Time: 2:08
 */

import com.mum.news.ea.blog.models.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ArticleDao extends CrudRepository<Article, Long> {
}
