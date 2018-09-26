package com.bindstone.portfolio.repository;

import com.bindstone.portfolio.entity.CurrencyHistory;
import org.springframework.data.repository.CrudRepository;

/**
 * Currency History Repository
 */
public interface CurrencyHistoryRepository extends CrudRepository<CurrencyHistory, Long> {
}
