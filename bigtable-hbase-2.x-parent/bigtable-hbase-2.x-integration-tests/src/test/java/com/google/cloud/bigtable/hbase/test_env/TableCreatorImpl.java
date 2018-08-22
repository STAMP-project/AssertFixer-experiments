/*
 * Copyright 2018 Google LLC All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.hbase.test_env;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;

import java.io.IOException;

/**
 * Creates a table for HBase 2.*.
 */
public class TableCreatorImpl implements TableCreator {
  @Override
  public void createTable(Admin admin, TableName tableName) throws IOException {
    HColumnDescriptor hcd = new HColumnDescriptor(SharedTestEnvRule.COLUMN_FAMILY)
        .setMaxVersions(SharedTestEnvRule.MAX_VERSIONS);
    HColumnDescriptor family2 = new HColumnDescriptor(SharedTestEnvRule.COLUMN_FAMILY2)
        .setMaxVersions(SharedTestEnvRule.MAX_VERSIONS);
    admin.createTable(new HTableDescriptor(tableName).addFamily(hcd).addFamily(family2));
  }
}
