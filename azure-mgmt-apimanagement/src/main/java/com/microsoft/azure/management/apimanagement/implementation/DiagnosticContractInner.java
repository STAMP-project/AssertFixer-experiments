/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * Diagnostic details.
 */
@JsonFlatten
public class DiagnosticContractInner extends Resource {
    /**
     * Indicates whether a diagnostic should receive data or not.
     */
    @JsonProperty(value = "properties.enabled", required = true)
    private boolean enabled;

    /**
     * Get the enabled value.
     *
     * @return the enabled value
     */
    public boolean enabled() {
        return this.enabled;
    }

    /**
     * Set the enabled value.
     *
     * @param enabled the enabled value to set
     * @return the DiagnosticContractInner object itself.
     */
    public DiagnosticContractInner withEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

}
