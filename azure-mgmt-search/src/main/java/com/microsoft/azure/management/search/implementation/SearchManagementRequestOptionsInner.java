/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.search.implementation;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Additional parameters for a set of operations.
 */
public class SearchManagementRequestOptionsInner {
    /**
     * A client-generated GUID value that identifies this request. If
     * specified, this will be included in response information as a way to
     * track the request.
     */
    @JsonProperty(value = "")
    private UUID clientRequestId;

    /**
     * Get the clientRequestId value.
     *
     * @return the clientRequestId value
     */
    public UUID clientRequestId() {
        return this.clientRequestId;
    }

    /**
     * Set the clientRequestId value.
     *
     * @param clientRequestId the clientRequestId value to set
     * @return the SearchManagementRequestOptionsInner object itself.
     */
    public SearchManagementRequestOptionsInner withClientRequestId(UUID clientRequestId) {
        this.clientRequestId = clientRequestId;
        return this;
    }

}
