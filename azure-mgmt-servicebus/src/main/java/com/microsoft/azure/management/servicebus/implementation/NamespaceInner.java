/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.servicebus.implementation;

import com.microsoft.azure.Resource;
import com.microsoft.azure.management.servicebus.Sku;
import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Description of a namespace resource.
 */
@JsonFlatten
public class NamespaceInner extends Resource {
    /**
     * The sku property.
     */
    @JsonProperty(value = "sku")
    private Sku sku;

    /**
     * Provisioning state of the namespace.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private String provisioningState;

    /**
     * The time the namespace was created.
     */
    @JsonProperty(value = "properties.createdAt", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime createdAt;

    /**
     * The time the namespace was updated.
     */
    @JsonProperty(value = "properties.updatedAt", access = JsonProperty.Access.WRITE_ONLY)
    private DateTime updatedAt;

    /**
     * Endpoint you can use to perform Service Bus operations.
     */
    @JsonProperty(value = "properties.serviceBusEndpoint", access = JsonProperty.Access.WRITE_ONLY)
    private String serviceBusEndpoint;

    /**
     * Identifier for Azure Insights metrics.
     */
    @JsonProperty(value = "properties.metricId", access = JsonProperty.Access.WRITE_ONLY)
    private String metricId;

    /**
     * Get the sku value.
     *
     * @return the sku value
     */
    public Sku sku() {
        return this.sku;
    }

    /**
     * Set the sku value.
     *
     * @param sku the sku value to set
     * @return the NamespaceInner object itself.
     */
    public NamespaceInner withSku(Sku sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get the provisioningState value.
     *
     * @return the provisioningState value
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the createdAt value.
     *
     * @return the createdAt value
     */
    public DateTime createdAt() {
        return this.createdAt;
    }

    /**
     * Get the updatedAt value.
     *
     * @return the updatedAt value
     */
    public DateTime updatedAt() {
        return this.updatedAt;
    }

    /**
     * Get the serviceBusEndpoint value.
     *
     * @return the serviceBusEndpoint value
     */
    public String serviceBusEndpoint() {
        return this.serviceBusEndpoint;
    }

    /**
     * Get the metricId value.
     *
     * @return the metricId value
     */
    public String metricId() {
        return this.metricId;
    }

}
