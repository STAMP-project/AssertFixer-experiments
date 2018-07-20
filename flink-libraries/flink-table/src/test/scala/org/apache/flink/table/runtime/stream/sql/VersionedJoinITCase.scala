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

package org.apache.flink.table.runtime.stream.sql

import org.apache.flink.api.scala._
import org.apache.flink.streaming.api.TimeCharacteristic
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.table.api.scala._
import org.apache.flink.table.api.{TableEnvironment, Types}
import org.apache.flink.table.expressions.Null
import org.apache.flink.table.runtime.utils.{StreamITCase, StreamingWithStateTestBase}
import org.apache.flink.types.Row
import org.junit._

import scala.collection.mutable

class VersionedJoinITCase extends StreamingWithStateTestBase {

  @Test
  def testProcessTimeInnerJoin(): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val tEnv = TableEnvironment.getTableEnvironment(env)
    env.setStateBackend(getStateBackend)
    StreamITCase.clear
    env.setParallelism(1)
    env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime)

    val sqlQuery =
      """
        |SELECT
        |  o.amount * r.rate AS amount
        |FROM
        |  Orders AS o,
        |  LATERAL TABLE (Rates(o.proctime)) AS r
        |WHERE r.currency = o.currency
        |""".stripMargin

    val ordersData = new mutable.MutableList[(Long, String)]
    ordersData.+=((2L, "Euro"))
    ordersData.+=((1L, "US Dollar"))
    ordersData.+=((50L, "Yen"))
    ordersData.+=((3L, "Euro"))
    ordersData.+=((5L, "US Dollar"))

    val ratesHistoryData = new mutable.MutableList[(String, Long)]
    ratesHistoryData.+=(("US Dollar", 102L))
    ratesHistoryData.+=(("Euro", 114L))
    ratesHistoryData.+=(("Yen", 1L))
    ratesHistoryData.+=(("Euro", 116L))
    ratesHistoryData.+=(("Euro", 119L))

    val orders = env
      .fromCollection(ordersData)
      .toTable(tEnv, 'amount, 'currency, 'proctime.proctime)
    val ratesHistory = env
      .fromCollection(ratesHistoryData)
      .toTable(tEnv, 'currency, 'rate, 'proctime.proctime)

    tEnv.registerTable("Orders", orders)
    tEnv.registerTable("RatesHistory", ratesHistory)
    tEnv.registerFunction(
      "Rates",
      ratesHistory.createTableVersionFunction('proctime.proctime, 'currency))

    val result = tEnv.sqlQuery(sqlQuery).toAppendStream[Row]
    result.addSink(new StreamITCase.StringSink[Row])
    env.execute()
  }
}
