/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.notificationhubs;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Sku description for a namespace.
 */
public class Sku {
    /**
     * Name of the notification hub sku. Possible values include: 'Free',
     * 'Basic', 'Standard'.
     */
    @JsonProperty(value = "name", required = true)
    private SkuName name;

    /**
     * The tier of particular sku.
     */
    @JsonProperty(value = "tier")
    private String tier;

    /**
     * The Sku size.
     */
    @JsonProperty(value = "size")
    private String size;

    /**
     * The Sku Family.
     */
    @JsonProperty(value = "family")
    private String family;

    /**
     * The capacity of the resource.
     */
    @JsonProperty(value = "capacity")
    private Integer capacity;

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

    /**
     * Get the tier value.
     *
     * @return the tier value
     */
    public String tier() {
        return this.tier;
    }

    /**
     * Set the tier value.
     *
     * @param tier the tier value to set
     * @return the Sku object itself.
     */
    public Sku withTier(String tier) {
        this.tier = tier;
        return this;
    }

    /**
     * Get the size value.
     *
     * @return the size value
     */
    public String size() {
        return this.size;
    }

    /**
     * Set the size value.
     *
     * @param size the size value to set
     * @return the Sku object itself.
     */
    public Sku withSize(String size) {
        this.size = size;
        return this;
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
     * Get the capacity value.
     *
     * @return the capacity value
     */
    public Integer capacity() {
        return this.capacity;
    }

    /**
     * Set the capacity value.
     *
     * @param capacity the capacity value to set
     * @return the Sku object itself.
     */
    public Sku withCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

}
