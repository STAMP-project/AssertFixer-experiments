/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalake.analytics.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * The parameters used to add a new Azure Storage account while creating a new
 * Data Lake Analytics account.
 */
@JsonFlatten
public class AddStorageAccountWithAccountParameters {
    /**
     * The unique name of the Azure Storage account to add.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * The access key associated with this Azure Storage account that will be
     * used to connect to it.
     */
    @JsonProperty(value = "properties.accessKey", required = true)
    private String accessKey;

    /**
     * The optional suffix for the storage account.
     */
    @JsonProperty(value = "properties.suffix")
    private String suffix;

    /**
     * Get the unique name of the Azure Storage account to add.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the unique name of the Azure Storage account to add.
     *
     * @param name the name value to set
     * @return the AddStorageAccountWithAccountParameters object itself.
     */
    public AddStorageAccountWithAccountParameters withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the access key associated with this Azure Storage account that will be used to connect to it.
     *
     * @return the accessKey value
     */
    public String accessKey() {
        return this.accessKey;
    }

    /**
     * Set the access key associated with this Azure Storage account that will be used to connect to it.
     *
     * @param accessKey the accessKey value to set
     * @return the AddStorageAccountWithAccountParameters object itself.
     */
    public AddStorageAccountWithAccountParameters withAccessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

    /**
     * Get the optional suffix for the storage account.
     *
     * @return the suffix value
     */
    public String suffix() {
        return this.suffix;
    }

    /**
     * Set the optional suffix for the storage account.
     *
     * @param suffix the suffix value to set
     * @return the AddStorageAccountWithAccountParameters object itself.
     */
    public AddStorageAccountWithAccountParameters withSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

}
