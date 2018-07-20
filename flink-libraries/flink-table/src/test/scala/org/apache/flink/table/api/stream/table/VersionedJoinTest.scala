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

package org.apache.flink.table.api.stream.table

import java.sql.Timestamp

import org.apache.flink.api.scala._
import org.apache.flink.table.api.ValidationException
import org.apache.flink.table.api.scala._
import org.apache.flink.table.functions.TableVersionFunction
import org.apache.flink.table.utils.TableTestUtil._
import org.apache.flink.table.utils._
import org.hamcrest.Matchers.startsWith
import org.junit.Assert.{assertArrayEquals, assertEquals}
import org.junit.Test

class VersionedJoinTest extends TableTestBase {

  val util: TableTestUtil = streamTestUtil()

  val orders = util.addTable[(Long, String, Timestamp)](
    "Orders", 'o_amount, 'o_currency, 'o_rowtime.rowtime)

  val ratesHistory = util.addTable[(String, Int, Timestamp)](
    "RatesHistory", 'currency, 'rate, 'rowtime.rowtime)

  val rates = util.addFunction(
    "Rates",
    ratesHistory.createTableVersionFunction('rowtime.rowtime, 'currency))

  @Test
  def testSimpleVersionedJoin(): Unit = {
    val result = orders
      .join(rates('o_rowtime), "currency = o_currency")
      .select("o_amount * rate").as("rate")

    util.verifyTable(result, VersionedJoinTest.getExpectedSimpleVersionedJoinPlan())
  }

  /**
    * Test versioned joins with more complicated query.
    * Important thing here is that we have complex OR join condition
    * and there are some columns that are not being used (are being pruned).
    */
  @Test
  def testComplexVersionedJoin(): Unit = {
    val util = streamTestUtil()
    val thirdTable = util.addTable[(String, Int)]("ThirdTable", 't3_comment, 't3_secondary_key)
    val orders = util.addTable[(Timestamp, String, Long, String, Int)](
      "Orders", 'o_rowtime.rowtime, 'o_comment, 'o_amount, 'o_currency, 'o_secondary_key)

    val ratesHistory = util.addTable[(Timestamp, String, String, Int, Int)](
      "RatesHistory", 'rowtime.rowtime, 'comment, 'currency, 'rate, 'secondary_key)
    val rates = ratesHistory.createTableVersionFunction('rowtime, 'currency)
    util.addFunction("Rates", rates)

    val result = orders
      .join(rates('o_rowtime))
      .filter('currency === 'o_currency || 'secondary_key === 'o_secondary_key)
      .select('o_amount * 'rate, 'secondary_key).as('rate, 'secondary_key)
      .join(thirdTable, 't3_secondary_key === 'secondary_key)

    util.verifyTable(result, VersionedJoinTest.getExpectedComplexVersionedJoinPlan())
  }

  @Test
  def testTableVersionFunctionOnTopOfQuery(): Unit = {
    val filteredRatesHistory = ratesHistory
      .filter('rate > 100)
      .select('currency, 'rate * 2, 'rowtime)
      .as('currency, 'rate, 'rowtime)

    val filteredRates = util.addFunction(
      "FilteredRates",
      filteredRatesHistory.createTableVersionFunction('rowtime, 'currency))

    val result = orders
      .join(filteredRates('o_rowtime), "currency = o_currency")
      .select("o_amount * rate")
      .as('rate)

    util.verifyTable(result, VersionedJoinTest.getExpectedTableVersionFunctionOnTopOfQueryPlan())
  }

  @Test
  def testUncorrelatedVersionedJoin(): Unit = {
    expectedException.expect(classOf[ValidationException])
    expectedException.expectMessage(startsWith("Unsupported argument"))

    val result = orders
      .join(rates(
        java.sql.Timestamp.valueOf("2016-06-27 10:10:42.123")),
        "o_currency = currency")
      .select("o_amount * rate")

    util.printTable(result)
  }

  @Test
  def testVersionFunctionScan(): Unit = {
    expectedException.expect(classOf[ValidationException])
    expectedException.expectMessage(
      "Cannot translate a query with an unbounded table function call")

    val result = rates(java.sql.Timestamp.valueOf("2016-06-27 10:10:42.123"))
    util.printTable(result)
  }

  @Test
  def testInvalidFieldReference(): Unit = {
    expectedException.expect(classOf[ValidationException])
    expectedException.expectMessage("Unknown field [foobar]")

    ratesHistory.createTableVersionFunction('rowtime.rowtime, 'foobar)
  }

  @Test
  def testInvalidStringFieldReference(): Unit = {
    expectedException.expect(classOf[ValidationException])
    expectedException.expectMessage("Unknown field [foobar]")

    ratesHistory.createTableVersionFunction("rowtime", "foobar")
  }

  @Test
  def testNonTimeIndicatorVersion(): Unit = {
    expectedException.expect(classOf[ValidationException])
    expectedException.expectMessage(
      "Version expression [rate] must point to rowtime or proctime field")

    val util: TableTestUtil = streamTestUtil()
    val ratesHistory = util.addTable[(String, Int, Timestamp)](
      "RatesHistory", 'currency, 'rate, 'rowtime)
    ratesHistory.createTableVersionFunction("rate", "currency")
  }

  @Test
  def testProcessingTimeIndicatorVersion(): Unit = {
    val util: TableTestUtil = streamTestUtil()
    val ratesHistory = util.addTable[(String, Int)](
      "RatesHistory", 'currency, 'rate, 'rowtime.proctime)
    val rates = ratesHistory.createTableVersionFunction('proctime.proctime, 'currency)
    assertRatesFunction(rates, true)
  }

  @Test
  def testValidStringFieldReference(): Unit = {
    val rates = ratesHistory.createTableVersionFunction("rowtime", "currency")
    assertRatesFunction(rates)
  }

  private def assertRatesFunction(
      rates: TableVersionFunction,
      proctime: Boolean = false): Unit = {
    assertEquals("currency", rates.primaryKey)
    assertEquals(if (proctime) "proctime" else "rowtime", rates.versionField)
    assertArrayEquals(
      ratesHistory.getSchema.getColumnNames.asInstanceOf[Array[Object]],
      rates.getResultType.getFieldNames.asInstanceOf[Array[Object]])
    assertArrayEquals(
      ratesHistory.getSchema.getTypes.asInstanceOf[Array[Object]],
      rates.getResultType.getFieldTypes.asInstanceOf[Array[Object]])
  }
}

object VersionedJoinTest {
  def getExpectedSimpleVersionedJoinPlan(): String = {
    unaryNode(
      "DataStreamCalc",
      binaryNode(
        "DataStreamVersionedJoin",
        streamTableNode(0),
        streamTableNode(1),
        term("where",
          "AND(" +
            "__VERSIONING_JOIN_CONDITION(CAST(o_rowtime), rowtime, currency), " +
            "=(currency, o_currency))"),
        term("join", "o_amount", "o_currency", "o_rowtime", "currency", "rate", "rowtime"),
        term("joinType", "InnerJoin")
      ),
      term("select", "*(o_amount, rate) AS rate")
    )
  }

  def getExpectedComplexVersionedJoinPlan(): String = {
    binaryNode(
      "DataStreamJoin",
      unaryNode(
        "DataStreamCalc",
        binaryNode(
          "DataStreamVersionedJoin",
          unaryNode(
            "DataStreamCalc",
            streamTableNode(1),
            term("select", "o_rowtime, o_amount, o_currency, o_secondary_key")
          ),
          unaryNode(
            "DataStreamCalc",
            streamTableNode(2),
            term("select", "rowtime, currency, rate, secondary_key")
          ),
          term("where",
            "AND(" +
              "__VERSIONING_JOIN_CONDITION(CAST(o_rowtime), rowtime, currency), " +
              "OR(=(currency, o_currency), =(secondary_key, o_secondary_key)))"),
          term("join",
            "o_rowtime",
            "o_amount",
            "o_currency",
            "o_secondary_key",
            "rowtime",
            "currency",
            "rate",
            "secondary_key"),
          term("joinType", "InnerJoin")
        ),
        term("select", "*(o_amount, rate) AS rate", "secondary_key")
      ),
      streamTableNode(0),
      term("where", "=(t3_secondary_key, secondary_key)"),
      term("join", "rate, secondary_key, t3_comment, t3_secondary_key"),
      term("joinType", "InnerJoin")
    )
  }

  def getExpectedTableVersionFunctionOnTopOfQueryPlan(): String = {
    unaryNode(
      "DataStreamCalc",
      binaryNode(
        "DataStreamVersionedJoin",
        streamTableNode(0),
        unaryNode(
          "DataStreamCalc",
          streamTableNode(1),
          term("select", "currency", "*(rate, 2) AS rate", "rowtime"),
          term("where", ">(rate, 100)")),
        term("where",
          "AND(" +
            "__VERSIONING_JOIN_CONDITION(CAST(o_rowtime), rowtime, currency), " +
            "=(currency, o_currency))"),
        term("join", "o_amount", "o_currency", "o_rowtime", "currency", "rate", "rowtime"),
        term("joinType", "InnerJoin")
      ),
      term("select", "*(o_amount, rate) AS rate")
    )
  }
}
