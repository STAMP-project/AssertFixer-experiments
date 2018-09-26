package com.bindstone.portfolio.validator.impl;

import com.bindstone.portfolio.validator.NoValidation;
import org.springframework.stereotype.Component;

/**
 * Empty validation, no validations will be done. Even not a NOT NULL
 */

@Component
public class NoValidationImpl implements NoValidation {

    @Override
    public void onSave(Object object) {
        // No Actions
    }
}
