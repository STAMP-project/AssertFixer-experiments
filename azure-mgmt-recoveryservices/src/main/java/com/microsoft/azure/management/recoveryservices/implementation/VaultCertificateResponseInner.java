/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservices.implementation;

import com.microsoft.azure.management.recoveryservices.ResourceCertificateDetails;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Certificate corresponding to a vault that can be used by clients to register
 * themselves with the vault.
 */
public class VaultCertificateResponseInner {
    /**
     * The name property.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * The type property.
     */
    @JsonProperty(value = "type")
    private String type;

    /**
     * The id property.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * The properties property.
     */
    @JsonProperty(value = "properties")
    private ResourceCertificateDetails properties;

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
     * @return the VaultCertificateResponseInner object itself.
     */
    public VaultCertificateResponseInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the type value.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

    /**
     * Set the type value.
     *
     * @param type the type value to set
     * @return the VaultCertificateResponseInner object itself.
     */
    public VaultCertificateResponseInner withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get the id value.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id value.
     *
     * @param id the id value to set
     * @return the VaultCertificateResponseInner object itself.
     */
    public VaultCertificateResponseInner withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the properties value.
     *
     * @return the properties value
     */
    public ResourceCertificateDetails properties() {
        return this.properties;
    }

    /**
     * Set the properties value.
     *
     * @param properties the properties value to set
     * @return the VaultCertificateResponseInner object itself.
     */
    public VaultCertificateResponseInner withProperties(ResourceCertificateDetails properties) {
        this.properties = properties;
        return this;
    }

}
