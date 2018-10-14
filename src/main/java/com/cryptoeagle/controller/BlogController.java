package com.cryptoeagle.controller;


import com.cryptoeagle.entity.Blog;
import com.cryptoeagle.entity.User;
import com.cryptoeagle.service.abst.BlogService;
import com.cryptoeagle.service.abst.RssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    private static final Logger log = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    BlogService blogService;

    @Autowired
    RssService rssService;

    @RequestMapping("/blog/remove")
    public String remove(@RequestParam String name) {

        blogService.deleteByName(name);
        return "redirect:/user-profile";
    }

    @RequestMapping("/blog/add")
    public String add(@ModelAttribute Blog blog, @AuthenticationPrincipal User user) {
        blogService.save(blog, user.getId());
        return "redirect:/user-profile";
    }
}
