package com.bindstone.portfolio.factories;

import com.bindstone.portfolio.entity.Currency;
import com.bindstone.portfolio.entity.CurrencyHistory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CurrencyHistoryFactory {

    public static CurrencyHistory CURRENCY_HISTORY_1(Currency currency) {
        return CurrencyHistory.builder()
                .currency(currency)
                .valueDate(LocalDateTime.of(2018, 1, 1, 12, 0))
                .rate(new BigDecimal(1))
                .build();
    }

    public static CurrencyHistory CURRENCY_HISTORY_2(Currency currency) {
        return CurrencyHistory.builder()
                .currency(currency)
                .valueDate(LocalDateTime.of(2018, 1, 2, 12, 0))
                .rate(new BigDecimal(2))
                .build();
    }
}
