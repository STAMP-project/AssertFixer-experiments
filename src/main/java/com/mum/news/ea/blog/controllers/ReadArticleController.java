package com.mum.news.ea.blog.controllers;

import com.mum.news.ea.blog.repositories.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: franc
 * Date: 21/09/2018
 * Time: 2:43
 */
@Controller
public class ReadArticleController {

    @Autowired
    ArticleDao articleDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("articles", this.articleDao.findAll());
        return "index";
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public String detail(@PathVariable long id, Model model) {
        model.addAttribute("article", this.articleDao.findById(id).get());
        return "articleDetail";
    }
}
