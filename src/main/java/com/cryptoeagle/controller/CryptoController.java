package com.cryptoeagle.controller;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.Ico;
import com.cryptoeagle.entity.crypto.Chart;
import com.cryptoeagle.service.abst.CoinService;
import com.cryptoeagle.service.abst.IcoService;
import com.cryptoeagle.service.abst.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CryptoController {

    @Autowired
    IcoService icoService;

    @Autowired
    CoinService coinService;

    @Autowired
    RestService restService;

    @RequestMapping("/ico-stats")
    public String icoStats(Model model) {
        List<Ico> icos = icoService.getAll();
        model.addAttribute("icos", icos);
        return "ico-stats";
    }

    @RequestMapping("/ico-list")
    public String icoList(Model model) {

        List<Ico> activeIco = icoService.getActive().stream().limit(10).collect(Collectors.toList());
        List<Ico> upcoming = icoService.getUpcoming().stream().limit(10).collect(Collectors.toList());
        List<Ico> finished = icoService.getFinished().stream().limit(10).collect(Collectors.toList());

        model.addAttribute("activeIco", activeIco);
        model.addAttribute("upcoming", upcoming);
        model.addAttribute("finished", finished);

        return "ico-list";
    }

    @RequestMapping("/ico-list/active")
    public String icoListActive(Model model) {
        List<Ico> activeIco = icoService.getActive().stream().limit(10).collect(Collectors.toList());
        model.addAttribute("category", "Active Ico");
        model.addAttribute("icos", activeIco);
        return "ico-category";
    }

    @RequestMapping("/ico-list/upcoming")
    public String icoListUpcoming(Model model) {
        List<Ico> upcoming = icoService.getUpcoming().stream().limit(10).collect(Collectors.toList());
        model.addAttribute("category", "Upcoming Ico");
        model.addAttribute("icos", upcoming);
        return "ico-category";
    }

    @RequestMapping("/ico-list/finished")
    public String icoListFinished(Model model) {
        List<Ico> finished = icoService.getFinished().stream()
                .limit(10)
                .collect(Collectors.toList());
        model.addAttribute("category", "Finished Ico");
        model.addAttribute("icos", finished);
        return "ico-category";
    }

    @RequestMapping("/coin-list")
    public String coinList(Model model) {
        List<Coin> coins = coinService.getAllCoins();
        model.addAttribute("coins", coins);
        return "coin-list";
    }

    @RequestMapping("/ico-page/{name}")
    public String icoPage(@PathVariable String name, Model model) {
        Ico ico = icoService.getByName(name);
        model.addAttribute("ico", ico);
        return "ico-page";
    }

    @RequestMapping("/coin-page/{symbol}")
    public String coinPage(Model model, @PathVariable String symbol) {
        Coin eth = coinService.getBySymbol(symbol);
        List<Chart> charts = restService.getChartCoin(symbol);
        model.addAttribute("coin", eth);
        model.addAttribute("chart", eth);
        return "coin-page";
    }

}
