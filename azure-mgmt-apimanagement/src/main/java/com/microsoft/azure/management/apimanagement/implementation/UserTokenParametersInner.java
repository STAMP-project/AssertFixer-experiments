/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.implementation;

import com.microsoft.azure.management.apimanagement.KeyType;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Parameters supplied to the Get User Token operation.
 */
public class UserTokenParametersInner {
    /**
     * The Key to be used to generate token for user. Possible values include:
     * 'primary', 'secondary'.
     */
    @JsonProperty(value = "keyType", required = true)
    private KeyType keyType;

    /**
     * The Expiry time of the Token. Maximum token expiry time is set to 30
     * days. The date conforms to the following format: `yyyy-MM-ddTHH:mm:ssZ`
     * as specified by the ISO 8601 standard.
     */
    @JsonProperty(value = "expiry", required = true)
    private DateTime expiry;

    /**
     * Get the keyType value.
     *
     * @return the keyType value
     */
    public KeyType keyType() {
        return this.keyType;
    }

    /**
     * Set the keyType value.
     *
     * @param keyType the keyType value to set
     * @return the UserTokenParametersInner object itself.
     */
    public UserTokenParametersInner withKeyType(KeyType keyType) {
        this.keyType = keyType;
        return this;
    }

    /**
     * Get the expiry value.
     *
     * @return the expiry value
     */
    public DateTime expiry() {
        return this.expiry;
    }

    /**
     * Set the expiry value.
     *
     * @param expiry the expiry value to set
     * @return the UserTokenParametersInner object itself.
     */
    public UserTokenParametersInner withExpiry(DateTime expiry) {
        this.expiry = expiry;
        return this;
    }

}
