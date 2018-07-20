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
package org.apache.flink.table.runtime.harness

import java.sql.Timestamp
import java.util.concurrent.ConcurrentLinkedQueue

import org.apache.calcite.rel.core.{JoinInfo, JoinRelType}
import org.apache.calcite.rex.{RexBuilder, RexNode}
import org.apache.calcite.sql.fun.SqlStdOperatorTable
import org.apache.calcite.util.ImmutableIntList
import org.apache.flink.api.common.time.Time
import org.apache.flink.api.common.typeinfo.{BasicTypeInfo, TypeInformation}
import org.apache.flink.api.java.functions.KeySelector
import org.apache.flink.api.java.typeutils.RowTypeInfo
import org.apache.flink.streaming.api.functions.co.CoProcessFunction
import org.apache.flink.streaming.api.operators.co.KeyedCoProcessOperator
import org.apache.flink.streaming.runtime.streamrecord.StreamRecord
import org.apache.flink.streaming.util.KeyedTwoInputStreamOperatorTestHarness
import org.apache.flink.table.api.{TableConfig, Types, ValidationException}
import org.apache.flink.table.calcite.{FlinkTypeFactory, FlinkTypeSystem}
import org.apache.flink.table.functions.sql.ProctimeSqlFunction
import org.apache.flink.table.plan.logical.rel.LogicalVersionedJoin
import org.apache.flink.table.plan.logical.rel.LogicalVersionedJoin.VERSIONING_JOIN_CONDITION
import org.apache.flink.table.plan.nodes.datastream.DataStreamVersionedJoinToCoProcessTranslator
import org.apache.flink.table.plan.schema.RowSchema
import org.apache.flink.table.runtime.CRowKeySelector
import org.apache.flink.table.runtime.harness.HarnessTestBase.{RowResultSortComparator, TestStreamQueryConfig}
import org.apache.flink.table.runtime.types.CRow
import org.hamcrest.Matchers.startsWith
import org.junit.rules.ExpectedException
import org.junit.{Rule, Test}

class VersionedJoinHarnessTest extends HarnessTestBase {
  // used for accurate exception information checking.
  val expectedException = ExpectedException.none()

  @Rule
  def thrown = expectedException

  private val typeFactory = new FlinkTypeFactory(new FlinkTypeSystem)

  private val tableConfig = new TableConfig

  private val queryConfig =
    new TestStreamQueryConfig(Time.milliseconds(2), Time.milliseconds(4))

  private val ordersRowtimeType = new RowTypeInfo(
    Array[TypeInformation[_]](
      Types.LONG,
      Types.STRING,
      Types.SQL_TIMESTAMP),
    Array("o_amount", "o_currency", "o_rowtime"))

  private val ordersProctimeType = new RowTypeInfo(
    Array[TypeInformation[_]](
      Types.LONG,
      Types.STRING),
    Array("o_amount", "o_currency"))

  private val ratesRowtimeType = new RowTypeInfo(
    Array[TypeInformation[_]](
      Types.STRING,
      Types.LONG,
      Types.SQL_TIMESTAMP),
    Array("r_currency", "r_rate", "r_rowtime"))

  private val ratesProctimeType = new RowTypeInfo(
    Array[TypeInformation[_]](
      Types.STRING,
      Types.LONG),
    Array("r_currency", "r_rate"))

  private val joinRowtimeType = new RowTypeInfo(
    ordersRowtimeType.getFieldTypes ++ ratesRowtimeType.getFieldTypes,
    ordersRowtimeType.getFieldNames ++ ratesRowtimeType.getFieldNames)

  private val rexBuilder = new RexBuilder(typeFactory)

  @Test
  def testProctime() {
    val testHarness = createTestHarness(
      new ProctimeVersionedJoinInfo(ordersProctimeType, ratesProctimeType, 1, 0, 0))

    testHarness.open()
    val expectedOutput = new ConcurrentLinkedQueue[Object]()

    // process without conversion rates
    testHarness.processElement1(new StreamRecord(CRow(2L, "Euro")))

    // initiate conversion rates
    testHarness.processElement2(new StreamRecord(CRow("US Dollar", 102L)))
    testHarness.processElement2(new StreamRecord(CRow("Euro", 114L)))
    testHarness.processElement2(new StreamRecord(CRow("Yen", 1L)))

    // process with conversion rates
    testHarness.processElement1(new StreamRecord(CRow(2L, "Euro")))
    testHarness.processElement1(new StreamRecord(CRow(1L, "US Dollar")))
    testHarness.processElement1(new StreamRecord(CRow(50L, "Yen")))

    expectedOutput.add(new StreamRecord(CRow(2L, "Euro", "Euro", 114L)))
    expectedOutput.add(new StreamRecord(CRow(1L, "US Dollar", "US Dollar", 102L)))
    expectedOutput.add(new StreamRecord(CRow(50L, "Yen", "Yen", 1L)))

    // update Euro
    testHarness.processElement2(new StreamRecord(CRow("Euro", 116L)))

    // process Euro
    testHarness.processElement1(new StreamRecord(CRow(3L, "Euro")))

    expectedOutput.add(new StreamRecord(CRow(3L, "Euro", "Euro", 116L)))

    // again update Euro
    testHarness.processElement2(new StreamRecord(CRow("Euro", 119L)))

    // process US Dollar
    testHarness.processElement1(new StreamRecord(CRow(5L, "US Dollar")))

    expectedOutput.add(new StreamRecord(CRow(5L, "US Dollar", "US Dollar", 102L)))

    verify(expectedOutput, testHarness.getOutput, new RowResultSortComparator())

    testHarness.close()
  }

  @Test
  def testNonEquiProctime() {
    val testHarness = createTestHarness(
      new ProctimeVersionedJoinInfo(ordersRowtimeType, ratesRowtimeType, 1, 0, 0) {
        /**
          * @return __VERSIONING_JOIN_CONDITION(...) AND leftInputRef(2) > rightInputRef(2)
          */
        override def getRemaining(rexBuilder: RexBuilder): RexNode = {
          rexBuilder.makeCall(
            SqlStdOperatorTable.AND,
            super.getRemaining(rexBuilder),
            rexBuilder.makeCall(
              SqlStdOperatorTable.GREATER_THAN,
              makeLeftInputRef(2),
              makeRightInputRef(2)))
        }
      })

    testHarness.open()
    val expectedOutput = new ConcurrentLinkedQueue[Object]()

    // initiate conversion rates
    testHarness.processElement2(new StreamRecord(CRow("Euro", 114L, new Timestamp(42))))
    testHarness.processElement2(new StreamRecord(CRow("Yen", 1L, new Timestamp(42))))

    // process with conversion rates
    testHarness.processElement1(new StreamRecord(CRow(2L, "Euro", new Timestamp(0))))
    testHarness.processElement1(new StreamRecord(CRow(50L, "Yen", new Timestamp(44))))

    expectedOutput.add(new StreamRecord(CRow(
      50L, "Yen", new Timestamp(44),
      "Yen", 1L, new Timestamp(42))))

    // update Euro
    testHarness.processElement2(new StreamRecord(CRow("Euro", 116L, new Timestamp(44))))

    // process Euro
    testHarness.processElement1(new StreamRecord(CRow(3L, "Euro", new Timestamp(42))))
    testHarness.processElement1(new StreamRecord(CRow(4L, "Euro", new Timestamp(44))))
    testHarness.processElement1(new StreamRecord(CRow(5L, "Euro", new Timestamp(1337))))

    expectedOutput.add(new StreamRecord(CRow(
      5L, "Euro", new Timestamp(1337),
      "Euro", 116L, new Timestamp(44))))

    // process US Dollar
    testHarness.processElement1(new StreamRecord(CRow(5L, "US Dollar", new Timestamp(1337))))

    verify(expectedOutput, testHarness.getOutput, new RowResultSortComparator())

    testHarness.close()
  }

  @Test
  def testRowtime() {
    expectedException.expect(classOf[ValidationException])
    expectedException.expectMessage(startsWith(s"Currently only proctime"))

    translateJoin(new RowtimeVersionedJoinInfo(ordersRowtimeType, ratesRowtimeType, 1, 0, 2, 2, 0))
  }

  @Test
  def testMissingVersioningJoinCondition() {
    expectedException.expect(classOf[IllegalStateException])
    expectedException.expectMessage(startsWith(s"Missing ${VERSIONING_JOIN_CONDITION.getName}"))

    translateJoin(new VersionedJoinInfo(ordersProctimeType, ratesProctimeType, 1, 0) {

      override def isEqui: Boolean = true

      override def getRemaining(rexBuilder: RexBuilder): RexNode = rexBuilder.makeLiteral(true)
    })
  }

  @Test
  def testNonEquiMissingVersioningJoinCondition() {
    expectedException.expect(classOf[IllegalStateException])
    expectedException.expectMessage(startsWith(s"Missing ${VERSIONING_JOIN_CONDITION.getName}"))

    translateJoin(new VersionedJoinInfo(ordersProctimeType, ratesProctimeType, 1, 0) {

      override def isEqui: Boolean = true

      override def getRemaining(rexBuilder: RexBuilder): RexNode = {
        rexBuilder.makeCall(
          SqlStdOperatorTable.GREATER_THAN,
          rexBuilder.makeCall(
            SqlStdOperatorTable.CONCAT,
            rexBuilder.makeLiteral("A"),
            makeLeftInputRef(1)),
          makeRightInputRef(0))
      }
    })
  }

  @Test
  def testTwoVersioningJoinConditions() {
    expectedException.expect(classOf[ValidationException])
    expectedException.expectMessage(startsWith(s"Multiple ${VERSIONING_JOIN_CONDITION} functions"))

    translateJoin(
      new ProctimeVersionedJoinInfo(ordersRowtimeType, ratesRowtimeType, 1, 0, 0) {
        override def getRemaining(rexBuilder: RexBuilder): RexNode = {
          rexBuilder.makeCall(
            SqlStdOperatorTable.OR,
            super.getRemaining(rexBuilder),
            super.getRemaining(rexBuilder))
        }
      })
  }

  @Test
  def testIncorrectVersioningJoinCondition() {
    expectedException.expect(classOf[IllegalStateException])
    expectedException.expectMessage(startsWith(s"Unsupported invocation"))

    translateJoin(
      new ProctimeVersionedJoinInfo(ordersRowtimeType, ratesRowtimeType, 1, 0, 0) {
        override def getRemaining(rexBuilder: RexBuilder): RexNode = {
          rexBuilder.makeCall(
            VERSIONING_JOIN_CONDITION,
            makeLeftInputRef(leftKey),
            makeLeftInputRef(leftKey),
            makeLeftInputRef(leftKey),
            makeRightInputRef(rightPrimaryKey))
        }
      })
  }

  @Test
  def testUnsupportedPrimaryKeyInVersioningJoinCondition() {
    expectedException.expect(classOf[ValidationException])
    expectedException.expectMessage(startsWith("Unsupported right primary key expression"))

    translateJoin(
      new ProctimeVersionedJoinInfo(ordersRowtimeType, ratesRowtimeType, 1, 0, 0) {
        override def getRemaining(rexBuilder: RexBuilder): RexNode = {
          LogicalVersionedJoin.makeProcTimeVersioningJoinConditionCall(
            rexBuilder,
            rexBuilder.makeCall(
              ProctimeSqlFunction,
              makeLeftInputRef(1)),
            rexBuilder.makeCall(
              SqlStdOperatorTable.CONCAT,
              rexBuilder.makeLiteral("A"),
              makeRightInputRef(0)))
        }
      })
  }

  @Test
  def testMultipleJoinKeys() {
    expectedException.expect(classOf[ValidationException])
    expectedException.expectMessage(startsWith(s"Only single column join key"))

    translateJoin(
      new VersionedJoinInfo(
        ordersRowtimeType,
        ratesRowtimeType,
        ImmutableIntList.of(0, 1),
        ImmutableIntList.of(1, 0)) {

        override def getRemaining(rexBuilder: RexBuilder): RexNode = {
          LogicalVersionedJoin.makeProcTimeVersioningJoinConditionCall(
            rexBuilder,
            rexBuilder.makeCall(
              ProctimeSqlFunction,
              makeLeftInputRef(1)),
            makeRightInputRef(0))
        }
      })
  }

  @Test
  def testNonInnerVersionedJoin() {
    expectedException.expect(classOf[ValidationException])
    expectedException.expectMessage(startsWith(s"Only ${JoinRelType.INNER} versioned join"))

    translateJoin(
      new ProctimeVersionedJoinInfo(ordersRowtimeType, ratesRowtimeType, 1, 0, 0),
      JoinRelType.FULL)
  }

  def createTestHarness(versionedJoinInfo: VersionedJoinInfo)
  : KeyedTwoInputStreamOperatorTestHarness[String, CRow, CRow, CRow] = {

    val (leftKeySelector, rightKeySelector, joinCoProcessFunction) =
      translateJoin(versionedJoinInfo)

    val operator: KeyedCoProcessOperator[String, CRow, CRow, CRow] =
      new KeyedCoProcessOperator[String, CRow, CRow, CRow](joinCoProcessFunction)

    new KeyedTwoInputStreamOperatorTestHarness[String, CRow, CRow, CRow](
      operator,
      leftKeySelector.asInstanceOf[KeySelector[CRow, String]],
      rightKeySelector.asInstanceOf[KeySelector[CRow, String]],
      BasicTypeInfo.STRING_TYPE_INFO,
      1,
      1,
      0)
  }

  def translateJoin(joinInfo: VersionedJoinInfo, joinRelType: JoinRelType = JoinRelType.INNER)
    : (CRowKeySelector, CRowKeySelector, CoProcessFunction[CRow, CRow, CRow]) = {

    val leftType = joinInfo.leftRowType
    val rightType = joinInfo.rightRowType
    val joinType = new RowTypeInfo(
      leftType.getFieldTypes ++ rightType.getFieldTypes,
      leftType.getFieldNames ++ rightType.getFieldNames)

    val joinTranslator = new DataStreamVersionedJoinToCoProcessTranslator(
      "VersionedJoin",
      tableConfig,
      joinType,
      new RowSchema(typeFactory.createTypeFromTypeInfo(leftType, false)),
      new RowSchema(typeFactory.createTypeFromTypeInfo(rightType, false)),
      joinInfo,
      rexBuilder)

    val joinCoProcessFunction = joinTranslator.getCoProcessFunction(
      joinRelType,
      joinType.getFieldNames,
      "VersionedJoin",
      queryConfig)

    (joinTranslator.getLeftKeySelector(),
      joinTranslator.getRightKeySelector(),
      joinCoProcessFunction)
  }

  abstract class VersionedJoinInfo(
      val leftRowType: RowTypeInfo,
      val rightRowType: RowTypeInfo,
      leftKeys: ImmutableIntList,
      rightKeys: ImmutableIntList)
    extends JoinInfo(leftKeys, rightKeys) {

    def this(
      leftRowType: RowTypeInfo,
      rightRowType: RowTypeInfo,
      leftKey: Int,
      rightKey: Int) =
      this(leftRowType, rightRowType, ImmutableIntList.of(leftKey), ImmutableIntList.of(rightKey))

    override def isEqui: Boolean = false

    def makeLeftInputRef(leftInputRef: Int): RexNode = {
      rexBuilder.makeInputRef(
        typeFactory.createTypeFromTypeInfo(leftRowType.getTypeAt(leftInputRef), false),
        leftInputRef)
    }

    def makeRightInputRef(rightInputRef: Int): RexNode = {
      rexBuilder.makeInputRef(
        typeFactory.createTypeFromTypeInfo(rightRowType.getTypeAt(rightInputRef), false),
        rightInputRef + leftRowType.getFieldTypes.length)
    }
  }

  class ProctimeVersionedJoinInfo(
      leftRowType: RowTypeInfo,
      rightRowType: RowTypeInfo,
      val leftKey: Int,
      val rightKey: Int,
      val rightPrimaryKey: Int)
    extends VersionedJoinInfo(leftRowType, rightRowType, leftKey, rightKey) {

    override def getRemaining(rexBuilder: RexBuilder): RexNode = {
      LogicalVersionedJoin.makeProcTimeVersioningJoinConditionCall(
        rexBuilder,
        rexBuilder.makeCall(
          ProctimeSqlFunction,
          makeLeftInputRef(leftKey)),
        makeRightInputRef(rightPrimaryKey))
    }
  }

  class RowtimeVersionedJoinInfo(
      leftRowType: RowTypeInfo,
      rightRowType: RowTypeInfo,
      leftKey: Int,
      rightKey: Int,
      leftVersionExpression: Int,
      rightVersionExpression: Int,
      rightPrimaryKey: Int)
    extends VersionedJoinInfo(
      leftRowType,
      rightRowType,
      leftKey,
      rightKey) {

    override def getRemaining(rexBuilder: RexBuilder): RexNode = {
      LogicalVersionedJoin.makeRowTimeVersioningJoinConditionCall(
        rexBuilder,
        makeLeftInputRef(leftVersionExpression),
        makeRightInputRef(rightVersionExpression),
        makeRightInputRef(rightPrimaryKey))
    }
  }

  class MissingVersioningJoinConditionJoinInfo(
      leftRowType: RowTypeInfo,
      rightRowType: RowTypeInfo,
      leftKey: Int,
      rightKey: Int,
      isEquiJoin: Boolean)
    extends VersionedJoinInfo(leftRowType, rightRowType, leftKey, rightKey) {

    override def isEqui: Boolean = isEquiJoin

    override def getRemaining(rexBuilder: RexBuilder): RexNode = if (isEquiJoin) {
      rexBuilder.makeLiteral(true)
    }
    else {
      rexBuilder.makeCall(
        SqlStdOperatorTable.GREATER_THAN,
        rexBuilder.makeCall(
          SqlStdOperatorTable.CONCAT,
          rexBuilder.makeLiteral("A"),
          makeLeftInputRef(leftKey)),
        makeRightInputRef(rightKey))
    }
  }
}
