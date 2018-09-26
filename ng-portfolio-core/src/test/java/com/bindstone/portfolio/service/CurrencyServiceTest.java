package com.bindstone.portfolio.service;

import com.bindstone.portfolio.entity.Currency;
import com.bindstone.portfolio.factories.CurrencyFactory;
import com.bindstone.portfolio.factories.CurrencyHistoryFactory;
import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CurrencyServiceTest extends AbstractServiceTest {

    @Test
    public void currencyBaseTest() {

        // Start with empty Table

        Flux<Currency> before = currencyService.getAll();
        assertNotNull(before);
        assertTrue(before.collectList().block().isEmpty());

        // Save Value

        Currency currency = CurrencyFactory.CURRENCY_1();
        currencyService.save(currency);

        // Get all Values

        Flux<Currency> after = currencyService.getAll();
        assertNotNull(after);
        assertFalse(after.collectList().block().isEmpty());

        // Validate Properties

        Currency rtnValue = after.blockFirst();

        assertNotNull(rtnValue.getId());
        assertEquals("EUR", rtnValue.getIso());
        assertEquals("Euro", rtnValue.getName());
        assertEquals(1, rtnValue.getExchange().intValue());

        // Update values

        rtnValue.setIso("EUR2");
        rtnValue.setName("Euro2");
        rtnValue.setExchange(new BigDecimal("2"));
        currencyService.save(rtnValue);

        // Get By Key

        Mono<Currency> after2 = currencyService.getById(rtnValue.getId());
        Assert.assertNotNull(after2);
        Currency rtnValue2 = after2.block();
        assertEquals("EUR2", rtnValue2.getIso());
        assertEquals("Euro2", rtnValue2.getName());
        assertEquals(2, rtnValue2.getExchange().intValue());

        assertNotNull(after2.toString());
        assertNotNull(after2.hashCode());
        assertFalse(after2.equals(after));
    }

    /**
     * EXPECT Lazy Loading Exception
     */
    @Test(expected = LazyInitializationException.class)
    public void lazyLoadingExceptionTest() {
        Currency currency = CurrencyFactory.CURRENCY_1();
        currency.getHistory().add(CurrencyHistoryFactory.CURRENCY_HISTORY_1(currency));

        currencyService.save(currency);

        Mono<Currency> eur = currencyService.getByIso("EUR");
        Currency value = eur.block();
        assertNotNull(value);

        assertNotNull(value.getHistory());
        assertFalse(value.getHistory().isEmpty());
    }

    @Test
    public void lazyLoadingTest() {
        Currency currency = CurrencyFactory.CURRENCY_1();
        currency.getHistory().add(CurrencyHistoryFactory.CURRENCY_HISTORY_1(currency));
        currency.getHistory().add(CurrencyHistoryFactory.CURRENCY_HISTORY_2(currency));

        currencyService.save(currency);

        Mono<Currency> eur = currencyService.getByIsoWithHistory("EUR");
        Currency value = eur.block();
        assertNotNull(value);

        assertNotNull(value.getHistory());
        assertEquals(2, value.getHistory().size());
    }
}
