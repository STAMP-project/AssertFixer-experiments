package com.bindstone.portfolio.service.impl;

import com.bindstone.portfolio.entity.CurrencyHistory;
import com.bindstone.portfolio.repository.CurrencyHistoryRepository;
import com.bindstone.portfolio.service.CurrencyHistoryService;
import com.bindstone.portfolio.validator.NoValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Currency History Service
 */
@Service
@Slf4j
public class CurrencyHistoryServiceImpl extends AbstractServiceImpl<CurrencyHistory> implements CurrencyHistoryService {

    /**
     * Constructor
     *
     * @param currencyHistoryRepository Currency History Repository
     * @param validation                No Validation
     */
    @Autowired
    public CurrencyHistoryServiceImpl(CurrencyHistoryRepository currencyHistoryRepository, NoValidation validation) {
        super(currencyHistoryRepository, validation);
    }
}
