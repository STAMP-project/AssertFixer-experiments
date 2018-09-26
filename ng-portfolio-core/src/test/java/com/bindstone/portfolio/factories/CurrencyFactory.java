package com.bindstone.portfolio.factories;

import com.bindstone.portfolio.entity.Currency;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CurrencyFactory {

    public static Currency CURRENCY_1() {
        return Currency.builder()
                .iso("EUR")
                .name("Euro")
                .exchange(new BigDecimal(1))
                .history(new ArrayList<>())
                .build();
    }

}
