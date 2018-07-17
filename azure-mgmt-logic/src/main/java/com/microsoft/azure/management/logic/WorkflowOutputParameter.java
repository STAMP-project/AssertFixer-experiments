/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.logic;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The workflow output parameter.
 */
public class WorkflowOutputParameter extends WorkflowParameter {
    /**
     * Gets the error.
     */
    @JsonProperty(value = "error", access = JsonProperty.Access.WRITE_ONLY)
    private Object error;

    /**
     * Get the error value.
     *
     * @return the error value
     */
    public Object error() {
        return this.error;
    }

}
