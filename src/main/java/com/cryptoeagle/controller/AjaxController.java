package com.cryptoeagle.controller;

import com.cryptoeagle.entity.Coin;
import com.cryptoeagle.entity.crypto.Chart;
import com.cryptoeagle.service.abst.CoinService;
import com.cryptoeagle.service.abst.RestService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
public class AjaxController {
    private static final String[] COINS = {"BTC", "ETH", "NEO", "EOS", "XRP"};

    @Autowired
    CoinService coinService;

    @Autowired
    RestService restService;

    @RequestMapping(value = "/ajax/coins")
    public List<Coin> getPriceCoins() {
        log.info("ajax get coins :" + COINS);
        List<Coin> coins = coinService.getCoins(COINS);
        return coins;
    }

    @RequestMapping(value = "/ajax/coins/{symbol}")
    public List<Chart> getCharts(@PathVariable String symbol) {
        log.info("ajax get charts symbol :" + symbol);
        List<Chart> charts = restService.getChartCoin(symbol);
        return charts;
    }

    @RequestMapping(value = "/ajax/topcoins")
    public List<Coin> getGetLooseCoins() {
        log.info("ajax get top gain coins");
        List<Coin> topGainCoins = coinService.getTopGainCoins();
        return topGainCoins;
    }

    @RequestMapping(value = "/ajax/loosercoins")
    public List<Coin> getGetTopCoins() {
        log.info("ajax get top looser coins");
        List<Coin> topLoserCoins = coinService.getTopLoserCoins();
        return topLoserCoins;
    }
}
