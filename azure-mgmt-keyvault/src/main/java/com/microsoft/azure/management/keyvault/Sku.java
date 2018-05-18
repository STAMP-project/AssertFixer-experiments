/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.keyvault;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SKU details.
 */
public class Sku {
    /**
     * SKU family name.
     */
    @JsonProperty(value = "family", required = true)
    private String family;

    /**
     * SKU name to specify whether the key vault is a standard vault or a
     * premium vault. Possible values include: 'standard', 'premium'.
     */
    @JsonProperty(value = "name", required = true)
    private SkuName name;

    /**
     * Creates an instance of Sku class.
     */
    public Sku() {
        family = "A";
    }

    /**
     * Get the family value.
     *
     * @return the family value
     */
    public String family() {
        return this.family;
    }

    /**
     * Set the family value.
     *
     * @param family the family value to set
     * @return the Sku object itself.
     */
    public Sku withFamily(String family) {
        this.family = family;
        return this;
    }

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public SkuName name() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     * @return the Sku object itself.
     */
    public Sku withName(SkuName name) {
        this.name = name;
        return this;
    }

}
