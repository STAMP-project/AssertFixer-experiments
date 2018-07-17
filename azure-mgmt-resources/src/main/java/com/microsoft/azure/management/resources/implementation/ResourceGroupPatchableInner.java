/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.resources.implementation;

import com.microsoft.azure.management.resources.ResourceGroupProperties;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Resource group information.
 */
public class ResourceGroupPatchableInner {
    /**
     * The name of the resource group.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * The properties property.
     */
    @JsonProperty(value = "properties")
    private ResourceGroupProperties properties;

    /**
     * The ID of the resource that manages this resource group.
     */
    @JsonProperty(value = "managedBy")
    private String managedBy;

    /**
     * The tags attached to the resource group.
     */
    @JsonProperty(value = "tags")
    private Map<String, String> tags;

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name value.
     *
     * @param name the name value to set
     * @return the ResourceGroupPatchableInner object itself.
     */
    public ResourceGroupPatchableInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the properties value.
     *
     * @return the properties value
     */
    public ResourceGroupProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties value.
     *
     * @param properties the properties value to set
     * @return the ResourceGroupPatchableInner object itself.
     */
    public ResourceGroupPatchableInner withProperties(ResourceGroupProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get the managedBy value.
     *
     * @return the managedBy value
     */
    public String managedBy() {
        return this.managedBy;
    }

    /**
     * Set the managedBy value.
     *
     * @param managedBy the managedBy value to set
     * @return the ResourceGroupPatchableInner object itself.
     */
    public ResourceGroupPatchableInner withManagedBy(String managedBy) {
        this.managedBy = managedBy;
        return this;
    }

    /**
     * Get the tags value.
     *
     * @return the tags value
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set the tags value.
     *
     * @param tags the tags value to set
     * @return the ResourceGroupPatchableInner object itself.
     */
    public ResourceGroupPatchableInner withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

}
