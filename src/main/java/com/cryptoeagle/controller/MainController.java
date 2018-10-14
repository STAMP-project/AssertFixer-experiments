package com.cryptoeagle.controller;

import com.cryptoeagle.entity.*;
import com.cryptoeagle.service.abst.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    ItemService itemService;

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;

    @Autowired
    IcoService icoService;

    @Autowired
    RssService rssService;

    @Autowired
    CoinService coinService;

    @Autowired
    EventService eventService;

    @Autowired
    WhiteListService whiteListService;

    @RequestMapping(value = {"/", "/welcome"})
    public String welcome(Model model, HttpServletRequest request) {

        List<Item> items = itemService.getAll().stream().limit(10).collect(Collectors.toList());
        List<Item> lowerItems = new ArrayList<>();
        List<Item> averageItems = new ArrayList<>();

        Item topItem = items.get(0);
        averageItems.add(items.get(1));
        averageItems.add(items.get(2));

        lowerItems.add(items.get(3));
        lowerItems.add(items.get(4));
        lowerItems.add(items.get(5));

        List<Event> events = eventService.getEvents(5);
        List<Ico> icos = icoService.getActive().stream().limit(4).collect(Collectors.toList());

        model.addAttribute("topItem", topItem);
        model.addAttribute("lowerItems", lowerItems);
        model.addAttribute("averageItems", averageItems);

        model.addAttribute("icos", icos);
        model.addAttribute("events", events);

        return "welcome";
    }

    @RequestMapping("/whitelist")
    public String whitelist(Model model) {
        List<WhiteList> whiteLists = whiteListService.getWhiteList();
        model.addAttribute("whiteLists", whiteLists);
        return "white-list";
    }

    @RequestMapping("/news")
    public String news(Model model) {
        List<Item> items = itemService.getAll().stream().limit(10).collect(Collectors.toList());
        List<String> sources = itemService.getSources();
        model.addAttribute("items", items);
        model.addAttribute("sources", sources);
        return "news-page";
    }

    @RequestMapping("/news/{source}")
    public String newsBySource(Model model, @PathVariable String source) {
        List<Item> items = itemService.getBySource(source);
        List<String> sources = itemService.getSources();
        model.addAttribute("items", items);
        model.addAttribute("sources", sources);
        return "news-page";
    }

    @RequestMapping("/blogs")
    public String blogs(Model model) {
        List<Blog> blogs = blogService.getAll().stream().limit(10).collect(Collectors.toList());
        model.addAttribute("blogs", blogs);
        return "blogs";
    }

    @RequestMapping("/events")
    public String events(Model model) {
        List<Event> events = eventService.getAll();
        model.addAttribute("events", events);
        return "events-page";
    }

    @RequestMapping("/admin-page")
    public String admin(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "admin-page";
    }

}
