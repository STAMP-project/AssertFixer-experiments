/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.relay.implementation;

import com.microsoft.azure.management.relay.KeyType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Parameters supplied to the Regenerate Authorization Rule operation,
 * specifies which key neeeds to be reset.
 */
public class RegenerateAccessKeyParametersInner {
    /**
     * The access key to regenerate. Possible values include: 'PrimaryKey',
     * 'SecondaryKey'.
     */
    @JsonProperty(value = "keyType", required = true)
    private KeyType keyType;

    /**
     * Optional, if the key value provided, is set for KeyType or autogenerated
     * Key value set for keyType.
     */
    @JsonProperty(value = "key")
    private String key;

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
     * @return the RegenerateAccessKeyParametersInner object itself.
     */
    public RegenerateAccessKeyParametersInner withKeyType(KeyType keyType) {
        this.keyType = keyType;
        return this;
    }

    /**
     * Get the key value.
     *
     * @return the key value
     */
    public String key() {
        return this.key;
    }

    /**
     * Set the key value.
     *
     * @param key the key value to set
     * @return the RegenerateAccessKeyParametersInner object itself.
     */
    public RegenerateAccessKeyParametersInner withKey(String key) {
        this.key = key;
        return this;
    }

}
