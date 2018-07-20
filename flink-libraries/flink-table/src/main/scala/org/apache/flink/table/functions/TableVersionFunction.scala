/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.table.functions

import java.sql.Timestamp

import org.apache.flink.api.common.typeinfo.TypeInformation
import org.apache.flink.api.java.typeutils.RowTypeInfo
import org.apache.flink.table.api.Table
import org.apache.flink.types.Row

/**
  * Class represnting table version functions over some history table.
  */
class TableVersionFunction private(
    @transient private val _table: Table,
    private[flink] val versionField: String,
    private[flink] val primaryKey: String,
    private[flink] val resultType: RowTypeInfo,
    private[flink] val isProctime: Boolean)
  extends TableFunction[Row] {

  def eval(row: Timestamp): Unit = {
    throw new IllegalStateException("This should never be called")
  }

  override def getResultType: RowTypeInfo = {
    resultType
  }

  private[flink] def table: Table = {
    if (_table == null) {
      throw new IllegalStateException("Accessing table field after planing/serialization")
    }
    _table
  }
}

object TableVersionFunction {
  def create(
      table: Table,
      versionField: String,
      primaryKey: String,
      isProctime: Boolean): TableVersionFunction = {
    return new TableVersionFunction(
      table,
      versionField,
      primaryKey,
      new RowTypeInfo(
        table.getSchema.getTypes,
        table.getSchema.getColumnNames),
      isProctime)
  }
}
