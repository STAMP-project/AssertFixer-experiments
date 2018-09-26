package com.bindstone.portfolio.controller;

import com.bindstone.portfolio.service.CurrencyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/currency/history")
public class CurrencyHistoryController {

    CurrencyHistoryService currencyHistoryService;

    @Autowired
    public CurrencyHistoryController(CurrencyHistoryService currencyHistoryService) {
        this.currencyHistoryService = currencyHistoryService;
    }

}
