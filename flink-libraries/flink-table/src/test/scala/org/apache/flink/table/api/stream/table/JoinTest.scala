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
import org.apache.flink.table.api.scala._
import org.apache.flink.table.utils.TableTestBase
import org.apache.flink.table.utils.TableTestUtil._
import org.junit.Test

/**
  * Currently only time-windowed joins can be processed in a streaming fashion.
  */
class JoinTest extends TableTestBase {

  // Tests for inner join
  @Test
  def testRowTimeWindowInnerJoin(): Unit = {
    val util = streamTestUtil()
    val left = util.addTable[(Long, Int, String)]('a, 'b, 'c, 'lrtime.rowtime)
    val right = util.addTable[(Long, Int, String)]('d, 'e, 'f, 'rrtime.rowtime)

    val resultTable = left.join(right)
      .where('a === 'd && 'lrtime >= 'rrtime - 5.minutes && 'lrtime < 'rrtime + 3.seconds)
      .select('a, 'e, 'lrtime)

    val expected =
      unaryNode(
        "DataStreamCalc",
        binaryNode(
          "DataStreamWindowJoin",
          unaryNode(
            "DataStreamCalc",
            streamTableNode(0),
            term("select", "a", "lrtime")
          ),
          unaryNode(
            "DataStreamCalc",
            streamTableNode(1),
            term("select", "d", "e", "rrtime")
          ),
          term("where", "AND(=(a, d), >=(lrtime, -(rrtime, 300000))," +
            " <(lrtime, DATETIME_PLUS(rrtime, 3000)))"),
          term("join", "a", "lrtime", "d", "e", "rrtime"),
          term("joinType", "InnerJoin")
        ),
        term("select", "a", "e", "lrtime")
      )
    util.verifyTable(resultTable, expected)
  }

  @Test
  def testProcTimeWindowInnerJoin(): Unit = {
    val util = streamTestUtil()
    val left = util.addTable[(Long, Int, String)]('a, 'b, 'c, 'lptime.proctime)
    val right = util.addTable[(Long, Int, String)]('d, 'e, 'f, 'rptime.proctime)

    val resultTable = left.join(right)
      .where('a === 'd && 'lptime >= 'rptime - 1.second && 'lptime < 'rptime)
      .select('a, 'e, 'lptime)

    val expected =
      unaryNode(
        "DataStreamCalc",
        binaryNode(
          "DataStreamWindowJoin",
          unaryNode(
            "DataStreamCalc",
            streamTableNode(0),
            term("select", "a", "lptime")
          ),
          unaryNode(
            "DataStreamCalc",
            streamTableNode(1),
            term("select", "d", "e", "rptime")
          ),
          term("where", "AND(=(a, d), >=(lptime, -(rptime, 1000)), <(lptime, rptime))"),
          term("join", "a", "lptime", "d", "e", "rptime"),
          term("joinType", "InnerJoin")
        ),
        term("select", "a", "e", "PROCTIME(lptime) AS lptime")
      )
    util.verifyTable(resultTable, expected)
  }

  @Test
  def testProcTimeWindowInnerJoinWithEquiTimeAttrs(): Unit = {
    val util = streamTestUtil()
    val left = util.addTable[(Long, Int, String)]('a, 'b, 'c, 'lptime.proctime)
    val right = util.addTable[(Long, Int, String)]('d, 'e, 'f, 'rptime.proctime)

    val resultTable = left.join(right)
      .where('a === 'd && 'lptime === 'rptime)
      .select('a, 'e, 'lptime)

    val expected =
      unaryNode(
        "DataStreamCalc",
        binaryNode(
          "DataStreamWindowJoin",
          unaryNode(
            "DataStreamCalc",
            streamTableNode(0),
            term("select", "a", "lptime")
          ),
          unaryNode(
            "DataStreamCalc",
            streamTableNode(1),
            term("select", "d", "e", "rptime")
          ),
          term("where", "AND(=(a, d), =(lptime, rptime))"),
          term("join", "a", "lptime", "d", "e", "rptime"),
          term("joinType", "InnerJoin")
        ),
        term("select", "a", "e", "PROCTIME(lptime) AS lptime")
      )
    util.verifyTable(resultTable, expected)
  }

  /**
    * The time indicator can be accessed from non-time predicates now.
    */
  @Test
  def testRowTimeInnerJoinWithTimeAccessed(): Unit = {
    val util = streamTestUtil()
    val left = util.addTable[(Long, Int, Timestamp)]('a, 'b, 'c, 'lrtime.rowtime)
    val right = util.addTable[(Long, Int, Timestamp)]('d, 'e, 'f, 'rrtime.rowtime)

    val resultTable = left.join(right)
      .where('a ==='d && 'lrtime >= 'rrtime - 5.minutes && 'lrtime < 'rrtime && 'lrtime > 'f)

    val expected =
      binaryNode(
        "DataStreamWindowJoin",
        streamTableNode(0),
        streamTableNode(1),
        term("where",
          "AND(=(a, d), >=(lrtime, -(rrtime, 300000)), <(lrtime, rrtime), >(lrtime, " + "f))"),
        term("join", "a", "b", "c", "lrtime", "d", "e", "f", "rrtime"),
        term("joinType", "InnerJoin")
      )
    util.verifyTable(resultTable, expected)
  }

  // Tests for left outer join
  @Test
  def testRowTimeWindowLeftOuterJoin(): Unit = {
    val util = streamTestUtil()
    val left = util.addTable[(Long, Int, String)]('a, 'b, 'c, 'lrtime.rowtime)
    val right = util.addTable[(Long, Int, String)]('d, 'e, 'f, 'rrtime.rowtime)

    val resultTable = left
      .leftOuterJoin(
        right,
        'a === 'd && 'lrtime >= 'rrtime - 5.minutes && 'lrtime < 'rrtime + 3.seconds)
      .select('a, 'e, 'lrtime)

    val expected =
      unaryNode(
        "DataStreamCalc",
        binaryNode(
          "DataStreamWindowJoin",
          unaryNode(
            "DataStreamCalc",
            streamTableNode(0),
            term("select", "a", "lrtime")
          ),
          unaryNode(
            "DataStreamCalc",
            streamTableNode(1),
            term("select", "d", "e", "rrtime")
          ),
          term("where", "AND(=(a, d), >=(lrtime, -(rrtime, 300000))," +
            " <(lrtime, DATETIME_PLUS(rrtime, 3000)))"),
          term("join", "a", "lrtime", "d", "e", "rrtime"),
          term("joinType", "LeftOuterJoin")
        ),
        term("select", "a", "e", "lrtime")
      )
    util.verifyTable(resultTable, expected)
  }

  @Test
  def testProcTimeWindowLeftOuterJoin(): Unit = {
    val util = streamTestUtil()
    val left = util.addTable[(Long, Int, String)]('a, 'b, 'c, 'lptime.proctime)
    val right = util.addTable[(Long, Int, String)]('d, 'e, 'f, 'rptime.proctime)

    val resultTable = left
      .leftOuterJoin(right, 'a === 'd && 'lptime >= 'rptime - 1.second && 'lptime < 'rptime)
      .select('a, 'e, 'lptime)

    val expected =
      unaryNode(
        "DataStreamCalc",
        binaryNode(
          "DataStreamWindowJoin",
          unaryNode(
            "DataStreamCalc",
            streamTableNode(0),
            term("select", "a", "lptime")
          ),
          unaryNode(
            "DataStreamCalc",
            streamTableNode(1),
            term("select", "d", "e", "rptime")
          ),
          term("where", "AND(=(a, d), >=(lptime, -(rptime, 1000)), <(lptime, rptime))"),
          term("join", "a", "lptime", "d", "e", "rptime"),
          term("joinType", "LeftOuterJoin")
        ),
        term("select", "a", "e", "PROCTIME(lptime) AS lptime")
      )
    util.verifyTable(resultTable, expected)
  }

  // Tests for right outer join
  @Test
  def testRowTimeWindowRightOuterJoin(): Unit = {
    val util = streamTestUtil()
    val left = util.addTable[(Long, Int, String)]('a, 'b, 'c, 'lrtime.rowtime)
    val right = util.addTable[(Long, Int, String)]('d, 'e, 'f, 'rrtime.rowtime)

    val resultTable = left
      .rightOuterJoin(
        right,
        'a === 'd && 'lrtime >= 'rrtime - 5.minutes && 'lrtime < 'rrtime + 3.seconds)
      .select('a, 'e, 'lrtime)

    val expected =
      unaryNode(
        "DataStreamCalc",
        binaryNode(
          "DataStreamWindowJoin",
          unaryNode(
            "DataStreamCalc",
            streamTableNode(0),
            term("select", "a", "lrtime")
          ),
          unaryNode(
            "DataStreamCalc",
            streamTableNode(1),
            term("select", "d", "e", "rrtime")
          ),
          term("where", "AND(=(a, d), >=(lrtime, -(rrtime, 300000))," +
            " <(lrtime, DATETIME_PLUS(rrtime, 3000)))"),
          term("join", "a", "lrtime", "d", "e", "rrtime"),
          term("joinType", "RightOuterJoin")
        ),
        term("select", "a", "e", "lrtime")
      )
    util.verifyTable(resultTable, expected)
  }

  @Test
  def testProcTimeWindowRightOuterJoin(): Unit = {
    val util = streamTestUtil()
    val left = util.addTable[(Long, Int, String)]('a, 'b, 'c, 'lptime.proctime)
    val right = util.addTable[(Long, Int, String)]('d, 'e, 'f, 'rptime.proctime)

    val resultTable = left
      .rightOuterJoin(right, 'a === 'd && 'lptime >= 'rptime - 1.second && 'lptime < 'rptime)
      .select('a, 'e, 'lptime)

    val expected =
      unaryNode(
        "DataStreamCalc",
        binaryNode(
          "DataStreamWindowJoin",
          unaryNode(
            "DataStreamCalc",
            streamTableNode(0),
            term("select", "a", "lptime")
          ),
          unaryNode(
            "DataStreamCalc",
            streamTableNode(1),
            term("select", "d", "e", "rptime")
          ),
          term("where", "AND(=(a, d), >=(lptime, -(rptime, 1000)), <(lptime, rptime))"),
          term("join", "a", "lptime", "d", "e", "rptime"),
          term("joinType", "RightOuterJoin")
        ),
        term("select", "a", "e", "PROCTIME(lptime) AS lptime")
      )
    util.verifyTable(resultTable, expected)
  }

  // Tests for full outer join
  @Test
  def testRowTimeWindowFullOuterJoin(): Unit = {
    val util = streamTestUtil()
    val left = util.addTable[(Long, Int, String)]('a, 'b, 'c, 'lrtime.rowtime)
    val right = util.addTable[(Long, Int, String)]('d, 'e, 'f, 'rrtime.rowtime)

    val resultTable = left
      .fullOuterJoin(
        right,
        'a === 'd && 'lrtime >= 'rrtime - 5.minutes && 'lrtime < 'rrtime + 3.seconds)
      .select('a, 'e, 'lrtime)

    val expected =
      unaryNode(
        "DataStreamCalc",
        binaryNode(
          "DataStreamWindowJoin",
          unaryNode(
            "DataStreamCalc",
            streamTableNode(0),
            term("select", "a", "lrtime")
          ),
          unaryNode(
            "DataStreamCalc",
            streamTableNode(1),
            term("select", "d", "e", "rrtime")
          ),
          term("where", "AND(=(a, d), >=(lrtime, -(rrtime, 300000))," +
            " <(lrtime, DATETIME_PLUS(rrtime, 3000)))"),
          term("join", "a", "lrtime", "d", "e", "rrtime"),
          term("joinType", "FullOuterJoin")
        ),
        term("select", "a", "e", "lrtime")
      )
    util.verifyTable(resultTable, expected)
  }

  @Test
  def testProcTimeWindowFullOuterJoin(): Unit = {
    val util = streamTestUtil()
    val left = util.addTable[(Long, Int, String)]('a, 'b, 'c, 'lptime.proctime)
    val right = util.addTable[(Long, Int, String)]('d, 'e, 'f, 'rptime.proctime)

    val resultTable = left
      .fullOuterJoin(right, 'a === 'd && 'lptime >= 'rptime - 1.second && 'lptime < 'rptime)
      .select('a, 'e, 'lptime)

    val expected =
      unaryNode(
        "DataStreamCalc",
        binaryNode(
          "DataStreamWindowJoin",
          unaryNode(
            "DataStreamCalc",
            streamTableNode(0),
            term("select", "a", "lptime")
          ),
          unaryNode(
            "DataStreamCalc",
            streamTableNode(1),
            term("select", "d", "e", "rptime")
          ),
          term("where", "AND(=(a, d), >=(lptime, -(rptime, 1000)), <(lptime, rptime))"),
          term("join", "a", "lptime", "d", "e", "rptime"),
          term("joinType", "FullOuterJoin")
        ),
        term("select", "a", "e", "PROCTIME(lptime) AS lptime")
      )
    util.verifyTable(resultTable, expected)
  }

  // Test for outer join optimization
  @Test
  def testRowTimeWindowOuterJoinOpt(): Unit = {
    val util = streamTestUtil()
    val left = util.addTable[(Long, Int, String)]('a, 'b, 'c, 'lrtime.rowtime)
    val right = util.addTable[(Long, Int, String)]('d, 'e, 'f, 'rrtime.rowtime)

    val resultTable = left.leftOuterJoin(right)
      .where('a === 'd && 'lrtime >= 'rrtime - 5.minutes && 'lrtime < 'rrtime + 3.seconds)
      .select('a, 'e, 'lrtime)

    val expected =
      unaryNode(
        "DataStreamCalc",
        binaryNode(
          "DataStreamWindowJoin",
          unaryNode(
            "DataStreamCalc",
            streamTableNode(0),
            term("select", "a", "lrtime")
          ),
          unaryNode(
            "DataStreamCalc",
            streamTableNode(1),
            term("select", "d", "e", "rrtime")
          ),
          term("where", "AND(=(a, d), >=(lrtime, -(rrtime, 300000))," +
            " <(lrtime, DATETIME_PLUS(rrtime, 3000)))"),
          term("join", "a", "lrtime", "d", "e", "rrtime"),
          // Since we filter on attributes of the left table after the join, the left outer join
          // will be automatically optimized to inner join.
          term("joinType", "InnerJoin")
        ),
        term("select", "a", "e", "lrtime")
      )
    util.verifyTable(resultTable, expected)
  }

}
