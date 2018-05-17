/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalake.store.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The encryption configuration used to update a user managed Key Vault key.
 */
public class UpdateEncryptionConfig {
    /**
     * The updated Key Vault key to use in user managed key rotation.
     */
    @JsonProperty(value = "keyVaultMetaInfo")
    private UpdateKeyVaultMetaInfo keyVaultMetaInfo;

    /**
     * Get the keyVaultMetaInfo value.
     *
     * @return the keyVaultMetaInfo value
     */
    public UpdateKeyVaultMetaInfo keyVaultMetaInfo() {
        return this.keyVaultMetaInfo;
    }

    /**
     * Set the keyVaultMetaInfo value.
     *
     * @param keyVaultMetaInfo the keyVaultMetaInfo value to set
     * @return the UpdateEncryptionConfig object itself.
     */
    public UpdateEncryptionConfig withKeyVaultMetaInfo(UpdateKeyVaultMetaInfo keyVaultMetaInfo) {
        this.keyVaultMetaInfo = keyVaultMetaInfo;
        return this;
    }

}
