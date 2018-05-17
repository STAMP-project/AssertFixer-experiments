/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.azure.management.appservice.KeyVaultSecretStatus;

/**
 * Key Vault container for a certificate that is purchased through Azure.
 */
public class AppServiceCertificateInner {
    /**
     * Key Vault resource Id.
     */
    @JsonProperty(value = "keyVaultId")
    private String keyVaultId;

    /**
     * Key Vault secret name.
     */
    @JsonProperty(value = "keyVaultSecretName")
    private String keyVaultSecretName;

    /**
     * Status of the Key Vault secret. Possible values include: 'Initialized',
     * 'WaitingOnCertificateOrder', 'Succeeded', 'CertificateOrderFailed',
     * 'OperationNotPermittedOnKeyVault',
     * 'AzureServiceUnauthorizedToAccessKeyVault', 'KeyVaultDoesNotExist',
     * 'KeyVaultSecretDoesNotExist', 'UnknownError', 'ExternalPrivateKey',
     * 'Unknown'.
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private KeyVaultSecretStatus provisioningState;

    /**
     * Get the keyVaultId value.
     *
     * @return the keyVaultId value
     */
    public String keyVaultId() {
        return this.keyVaultId;
    }

    /**
     * Set the keyVaultId value.
     *
     * @param keyVaultId the keyVaultId value to set
     * @return the AppServiceCertificateInner object itself.
     */
    public AppServiceCertificateInner withKeyVaultId(String keyVaultId) {
        this.keyVaultId = keyVaultId;
        return this;
    }

    /**
     * Get the keyVaultSecretName value.
     *
     * @return the keyVaultSecretName value
     */
    public String keyVaultSecretName() {
        return this.keyVaultSecretName;
    }

    /**
     * Set the keyVaultSecretName value.
     *
     * @param keyVaultSecretName the keyVaultSecretName value to set
     * @return the AppServiceCertificateInner object itself.
     */
    public AppServiceCertificateInner withKeyVaultSecretName(String keyVaultSecretName) {
        this.keyVaultSecretName = keyVaultSecretName;
        return this;
    }

    /**
     * Get the provisioningState value.
     *
     * @return the provisioningState value
     */
    public KeyVaultSecretStatus provisioningState() {
        return this.provisioningState;
    }

}
