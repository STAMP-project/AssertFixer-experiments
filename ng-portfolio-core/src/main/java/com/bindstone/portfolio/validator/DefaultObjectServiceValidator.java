package com.bindstone.portfolio.validator;

/**
 * Default contract rules to apply on Service level
 * for validating the operations. As all Services including
 * AbstractService are forced to provide a validator, the
 * developer is encouraged for including in his strategy well
 * validations. In case the no validation is wanted, the NoValidation
 * Service can be used.
 *
 * @param <T>
 */
public interface DefaultObjectServiceValidator<T> {

    /**
     * Validate before save rules
     *
     * @param object objects to save
     */
    void onSave(T object);
}
