/*
 * Copyright (C) 2004-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.warehouse;

import com.gooddata.collections.PageableListDeserializer;
import com.gooddata.collections.Paging;

import java.util.List;
import java.util.Map;

class WarehouseS3CredentialsListDeserializer extends PageableListDeserializer<WarehouseS3CredentialsList, WarehouseS3Credentials> {

    WarehouseS3CredentialsListDeserializer() {
        super(WarehouseS3Credentials.class);
    }

    @Override
    protected WarehouseS3CredentialsList createList(List<WarehouseS3Credentials> items, Paging paging, Map<String, String> links) {
        return new WarehouseS3CredentialsList(items, links);
    }
}
