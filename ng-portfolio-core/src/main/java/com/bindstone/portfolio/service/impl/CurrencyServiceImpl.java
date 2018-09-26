package com.bindstone.portfolio.service.impl;

import com.bindstone.portfolio.entity.Currency;
import com.bindstone.portfolio.repository.CurrencyRepository;
import com.bindstone.portfolio.service.CurrencyService;
import com.bindstone.portfolio.validator.CurrencyValidator;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

/**
 * Currency Service
 */
@Service
@Slf4j
public class CurrencyServiceImpl extends AbstractServiceImpl<Currency> implements CurrencyService {

    private CurrencyRepository currencyRepository;

    /**
     * Constructor
     *
     * @param currencyRepository Currency Repository
     * @param validator          Currency Validator
     */
    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository, CurrencyValidator validator) {
        super(currencyRepository, validator);
        this.currencyRepository = currencyRepository;
    }

    /**
     * Get Currency by ISO code
     * @param iso ISO code
     * @return Currency
     */
    @Override
    @Transactional(readOnly = true)
    public Mono<Currency> getByIso(String iso) {
        return Mono.justOrEmpty(currencyRepository.findByIso(iso));
    }

    /**
     * Get Currency by ISO with eager loading of the history
     * @param iso ISO code
     * @return Currency
     */
    @Override
    @Transactional(readOnly = true)
    public Mono<Currency> getByIsoWithHistory(String iso) {
        Currency byIso = currencyRepository.findByIso(iso);
        if (byIso != null) {
            Hibernate.initialize(byIso.getHistory());
            return Mono.just(byIso);
        } else {
            return Mono.justOrEmpty(byIso);
        }
    }
}
