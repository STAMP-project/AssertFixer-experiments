package com.cryptoeagle.controller;

import com.cryptoeagle.service.abst.CoinService;
import com.cryptoeagle.service.abst.EventService;
import com.cryptoeagle.service.abst.IcoService;
import com.cryptoeagle.service.abst.WhiteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TestController {

    @Autowired
    IcoService icoService;

    @Autowired
    CoinService coinService;

    @Autowired
    EventService eventService;

    @Autowired
    WhiteListService whiteListService;

    @RequestMapping("/test")
    public String test(Model model) {
        return "test";
    }

    @RequestMapping("/populate")
    public String populateAll() {
        icoService.update();
        coinService.updateCoins();
        eventService.update();
        whiteListService.updateWhitelist();
        return "redirect:/welcome ";
    }
}
