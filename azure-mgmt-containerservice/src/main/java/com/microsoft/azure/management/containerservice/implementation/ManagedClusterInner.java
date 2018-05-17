/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerservice.implementation;

import java.util.List;
import com.microsoft.azure.management.containerservice.ContainerServiceAgentPoolProfile;
import com.microsoft.azure.management.containerservice.ContainerServiceLinuxProfile;
import com.microsoft.azure.management.containerservice.ContainerServiceServicePrincipalProfile;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.Resource;

/**
 * Managed cluster.
 */
@JsonFlatten
public class ManagedClusterInner extends Resource {
    /**
     * The current deployment or provisioning state, which only appears in the
     * response.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private String provisioningState;

    /**
     * DNS prefix specified when creating the managed cluster.
     */
    @JsonProperty(value = "properties.dnsPrefix")
    private String dnsPrefix;

    /**
     * FDQN for the master pool.
     */
    @JsonProperty(value = "properties.fqdn", access = JsonProperty.Access.WRITE_ONLY)
    private String fqdn;

    /**
     * Version of Kubernetes specified when creating the managed cluster.
     */
    @JsonProperty(value = "properties.kubernetesVersion")
    private String kubernetesVersion;

    /**
     * Properties of the agent pool.
     */
    @JsonProperty(value = "properties.agentPoolProfiles")
    private List<ContainerServiceAgentPoolProfile> agentPoolProfiles;

    /**
     * Profile for Linux VMs in the container service cluster.
     */
    @JsonProperty(value = "properties.linuxProfile")
    private ContainerServiceLinuxProfile linuxProfile;

    /**
     * Information about a service principal identity for the cluster to use
     * for manipulating Azure APIs. Either secret or keyVaultSecretRef must be
     * specified.
     */
    @JsonProperty(value = "properties.servicePrincipalProfile")
    private ContainerServiceServicePrincipalProfile servicePrincipalProfile;

    /**
     * Get the provisioningState value.
     *
     * @return the provisioningState value
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the dnsPrefix value.
     *
     * @return the dnsPrefix value
     */
    public String dnsPrefix() {
        return this.dnsPrefix;
    }

    /**
     * Set the dnsPrefix value.
     *
     * @param dnsPrefix the dnsPrefix value to set
     * @return the ManagedClusterInner object itself.
     */
    public ManagedClusterInner withDnsPrefix(String dnsPrefix) {
        this.dnsPrefix = dnsPrefix;
        return this;
    }

    /**
     * Get the fqdn value.
     *
     * @return the fqdn value
     */
    public String fqdn() {
        return this.fqdn;
    }

    /**
     * Get the kubernetesVersion value.
     *
     * @return the kubernetesVersion value
     */
    public String kubernetesVersion() {
        return this.kubernetesVersion;
    }

    /**
     * Set the kubernetesVersion value.
     *
     * @param kubernetesVersion the kubernetesVersion value to set
     * @return the ManagedClusterInner object itself.
     */
    public ManagedClusterInner withKubernetesVersion(String kubernetesVersion) {
        this.kubernetesVersion = kubernetesVersion;
        return this;
    }

    /**
     * Get the agentPoolProfiles value.
     *
     * @return the agentPoolProfiles value
     */
    public List<ContainerServiceAgentPoolProfile> agentPoolProfiles() {
        return this.agentPoolProfiles;
    }

    /**
     * Set the agentPoolProfiles value.
     *
     * @param agentPoolProfiles the agentPoolProfiles value to set
     * @return the ManagedClusterInner object itself.
     */
    public ManagedClusterInner withAgentPoolProfiles(List<ContainerServiceAgentPoolProfile> agentPoolProfiles) {
        this.agentPoolProfiles = agentPoolProfiles;
        return this;
    }

    /**
     * Get the linuxProfile value.
     *
     * @return the linuxProfile value
     */
    public ContainerServiceLinuxProfile linuxProfile() {
        return this.linuxProfile;
    }

    /**
     * Set the linuxProfile value.
     *
     * @param linuxProfile the linuxProfile value to set
     * @return the ManagedClusterInner object itself.
     */
    public ManagedClusterInner withLinuxProfile(ContainerServiceLinuxProfile linuxProfile) {
        this.linuxProfile = linuxProfile;
        return this;
    }

    /**
     * Get the servicePrincipalProfile value.
     *
     * @return the servicePrincipalProfile value
     */
    public ContainerServiceServicePrincipalProfile servicePrincipalProfile() {
        return this.servicePrincipalProfile;
    }

    /**
     * Set the servicePrincipalProfile value.
     *
     * @param servicePrincipalProfile the servicePrincipalProfile value to set
     * @return the ManagedClusterInner object itself.
     */
    public ManagedClusterInner withServicePrincipalProfile(ContainerServiceServicePrincipalProfile servicePrincipalProfile) {
        this.servicePrincipalProfile = servicePrincipalProfile;
        return this;
    }

}
