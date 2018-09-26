package com.bindstone.portfolio.validator.impl;

import com.bindstone.portfolio.entity.Currency;
import com.bindstone.portfolio.exceptions.Messages;
import com.bindstone.portfolio.validator.CurrencyValidator;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

/**
 * Currency validation rules
 */
@Component
public class CurrencyValidatorImpl implements CurrencyValidator {

    public void onSave(Currency currency) {
        Validate.notNull(currency, Messages.CURRENCY_NULL.message(), Messages.CURRENCY_NULL);
        Validate.notEmpty(currency.getIso(), Messages.CURRENCY_ISO_NULL.message(), Messages.CURRENCY_ISO_NULL);
    }
}
