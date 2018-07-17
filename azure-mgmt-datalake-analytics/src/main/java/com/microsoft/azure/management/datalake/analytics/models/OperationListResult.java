/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalake.analytics.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The list of available operations for Data Lake Analytics.
 */
public class OperationListResult {
    /**
     * The results of the list operation.
     */
    @JsonProperty(value = "value", access = JsonProperty.Access.WRITE_ONLY)
    private List<Operation> value;

    /**
     * The link (url) to the next page of results.
     */
    @JsonProperty(value = "nextLink", access = JsonProperty.Access.WRITE_ONLY)
    private String nextLink;

    /**
     * Get the results of the list operation.
     *
     * @return the value value
     */
    public List<Operation> value() {
        return this.value;
    }

    /**
     * Get the link (url) to the next page of results.
     *
     * @return the nextLink value
     */
    public String nextLink() {
        return this.nextLink;
    }

}
