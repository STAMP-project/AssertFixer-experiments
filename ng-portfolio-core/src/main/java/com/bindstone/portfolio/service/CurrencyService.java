package com.bindstone.portfolio.service;

import com.bindstone.portfolio.entity.Currency;
import reactor.core.publisher.Mono;

/**
 * Currency Service
 */
public interface CurrencyService extends AbstractService<Currency> {

    Mono<Currency> getByIso(String iso);

    Mono<Currency> getByIsoWithHistory(String iso);

}
