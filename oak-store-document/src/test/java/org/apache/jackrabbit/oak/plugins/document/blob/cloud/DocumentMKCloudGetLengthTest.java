/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jackrabbit.oak.plugins.document.blob.cloud;

import org.apache.jackrabbit.oak.plugins.blob.cloud.CloudBlobStore;
import org.apache.jackrabbit.oak.plugins.document.DocumentMK;
import org.apache.jackrabbit.oak.plugins.document.MongoUtils;
import org.apache.jackrabbit.oak.plugins.document.blob.DocumentMKGetLengthTest;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.assertNotNull;

/**
 * Tests for {@code DocumentMK#getLength(String)} with {@link CloudBlobStore}
 */
public class DocumentMKCloudGetLengthTest extends DocumentMKGetLengthTest {
    @BeforeClass
    public static void setUpBeforeClass() {
        try {
            Assume.assumeNotNull(CloudStoreUtils.getBlobStore());
        } catch (Exception e) {
            Assume.assumeNoException(e);
        }
    }

    @Override
    @Before
    public void setUpConnection() throws Exception {
        mongoConnection = connectionFactory.getConnection();
        assertNotNull(mongoConnection);
        MongoUtils.dropCollections(mongoConnection.getDBName());
        mk = new DocumentMK.Builder()
                .setMongoDB(mongoConnection.getMongoClient(), mongoConnection.getDBName())
                .setBlobStore(CloudStoreUtils.getBlobStore()).open();
    }

    @Override
    @After
    public void tearDownConnection() {
        ((CloudBlobStore) mk.getNodeStore().getBlobStore()).deleteBucket();
        mk.dispose();
        MongoUtils.dropCollections(connectionFactory.getConnection().getDatabase());
    }
}