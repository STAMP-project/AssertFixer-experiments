package com.bindstone.portfolio.service;

import com.bindstone.portfolio.entity.Currency;
import com.bindstone.portfolio.entity.CurrencyHistory;
import com.bindstone.portfolio.factories.CurrencyFactory;
import com.bindstone.portfolio.factories.CurrencyHistoryFactory;
import org.junit.Test;
import reactor.core.publisher.Flux;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


public class CurrencyHistoryServiceTest extends AbstractServiceTest {

    @Test
    public void currencyHistoryBaseTest() {

        Currency currency = CurrencyFactory.CURRENCY_1();
        currency.getHistory().add(CurrencyHistoryFactory.CURRENCY_HISTORY_1(currency));
        currency.getHistory().add(CurrencyHistoryFactory.CURRENCY_HISTORY_2(currency));

        currencyService.save(currency);

        Flux<CurrencyHistory> all = currencyHistoryService.getAll();
        assertNotNull(all);
        CurrencyHistory currencyHistory = all.blockFirst();
        assertNotNull(currencyHistory);
        assertNotNull(currencyHistory.getId());
        assertNotNull(currencyHistory.getCurrency());
        assertNotNull(currencyHistory.getValueDate());
        assertNotNull(currencyHistory.getRate());

        assertNotNull(currencyHistory.toString());
        assertNotNull(currencyHistory.hashCode());
        assertFalse(currencyHistory.equals(CurrencyHistoryFactory.CURRENCY_HISTORY_1(currency)));
    }

}
