package com.bindstone.portfolio.repository;

import com.bindstone.portfolio.entity.Currency;
import org.springframework.data.repository.CrudRepository;

/**
 * Currency Repository
 */
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

    Currency findByIso(String iso);
}
