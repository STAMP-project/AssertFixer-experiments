package com.mum.news.ea.blog.controllers;

import com.mum.news.ea.blog.models.Article;
import com.mum.news.ea.blog.repositories.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: franc
 * Date: 21/09/2018
 * Time: 2:43
 */

public interface CreateArticleController {

    @Autowired
    public ArticleDao articleDao = null;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    default public String createArticle(Article article) {
        articleDao.save(article);
        return "redirect:/articles";
    }

    @RequestMapping(value = "/createArticle", method = RequestMethod.GET)
    default public String newForm(Model model) {
        return "addArticle";
    }

}
