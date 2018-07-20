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

package org.apache.flink.table.plan.nodes.datastream

import org.apache.calcite.rel.core.{JoinInfo, JoinRelType}
import org.apache.calcite.rex._
import org.apache.flink.api.common.functions.{FlatJoinFunction, MapFunction}
import org.apache.flink.api.common.typeinfo.TypeInformation
import org.apache.flink.streaming.api.functions.co.CoProcessFunction
import org.apache.flink.table.api.{StreamQueryConfig, TableConfig, ValidationException}
import org.apache.flink.table.codegen.{FunctionCodeGenerator, GeneratedFunction}
import org.apache.flink.table.plan.logical.rel.LogicalVersionedJoin._
import org.apache.flink.table.plan.schema.RowSchema
import org.apache.flink.table.plan.util.RexDefaultVisitor
import org.apache.flink.table.runtime.join.VersionedJoin
import org.apache.flink.table.runtime.types.{CRow, CRowTypeInfo}
import org.apache.flink.types.Row
import org.apache.flink.util.Preconditions.checkState

class DataStreamVersionedJoinToCoProcessTranslator(
    textualRepresentation: String,
    config: TableConfig,
    returnType: TypeInformation[Row],
    leftSchema: RowSchema,
    rightSchema: RowSchema,
    joinInfo: JoinInfo,
    rexBuilder: RexBuilder)
  extends DataStreamJoinToCoProcessTranslator(
    config,
    returnType,
    leftSchema,
    rightSchema,
    joinInfo,
    rexBuilder) {

  var leftVersionExpression: Option[RexNode] = None

  var rightVersionExpression: Option[RexNode] = None

  var rightPrimaryKeyExpression: Option[RexNode] = None

  override val nonEquiJoinPredicates: Option[RexNode] = extractVersioningJoinCondition()

  def extractVersioningJoinCondition(): Option[RexNode] = {
    checkState(
      !joinInfo.isEqui,
      "Missing %s in join condition",
      VERSIONING_JOIN_CONDITION)

    val nonEquiJoinRex: RexNode = joinInfo.getRemaining(rexBuilder)
    val versioningJoinConditionExtractor = new VersioningJoinConditionExtractor(
      nonEquiJoinRex.toString)

    Some(versioningJoinConditionExtractor.apply(nonEquiJoinRex))
  }

  override protected def createCoProcessFunction(
      joinType: JoinRelType,
      queryConfig: StreamQueryConfig,
      joinFunction: GeneratedFunction[FlatJoinFunction[Row, Row, Row], Row])
    : CoProcessFunction[CRow, CRow, CRow] = {

    checkState(
      leftVersionExpression.isDefined &&
        rightPrimaryKeyExpression.isDefined,
      "Missing %s in join condition",
      VERSIONING_JOIN_CONDITION)

    if (rightVersionExpression.isDefined) {
      throw new ValidationException(
        s"Currently only proctime versioned joins are supported in [${textualRepresentation}]")
    }

    joinType match {
      case JoinRelType.INNER =>
        new VersionedJoin(
          leftSchema.typeInfo,
          rightSchema.typeInfo,
          joinFunction.name,
          joinFunction.code,
          queryConfig)
      case _ =>
       throw new ValidationException(
         s"Only ${JoinRelType.INNER} versioned join is supported in [${textualRepresentation}]")
    }
  }

  def generateRightPrimaryKeyFunction(
      config: TableConfig,
      leftTypeInfo: TypeInformation[Row],
      rightTypeInfo: TypeInformation[Row],
      get: RexNode)
    : GeneratedFunction[MapFunction[Row, Object], _] = {
    val generator = new FunctionCodeGenerator(
      config,
      nullableInput = false,
      leftTypeInfo,
      Some(rightTypeInfo))

    val rightPrimaryKeyGeneratedExpression =
      generator.generateExpression(rightPrimaryKeyExpression.get)

    generator.generateFunction(
      "VersionedJoinPrimaryKeyFunction",
      classOf[MapFunction[Row, Object]],
      rightPrimaryKeyGeneratedExpression.resultTerm,
      rightPrimaryKeyGeneratedExpression.resultType)
  }


  private class VersioningJoinConditionExtractor(
      nonEquiJoinCondition: String)
    extends RexShuttle {

    override def visitCall(call: RexCall): RexNode = {
      if (call.getOperator != VERSIONING_JOIN_CONDITION) {
        return super.visitCall(call)
      }

      if (leftVersionExpression.isDefined
        || rightPrimaryKeyExpression.isDefined
        || rightVersionExpression.isDefined) {
        throw new ValidationException(
          s"Multiple ${VERSIONING_JOIN_CONDITION} functions in [${textualRepresentation}]")
      }
      if (call.getOperands.size() == 3) {
        leftVersionExpression = Some(call.getOperands.get(0))
        rightVersionExpression = Some(call.getOperands.get(1))
        rightPrimaryKeyExpression = Some(validateRightPrimaryKey(call.getOperands.get(2)))
      }
      else if (call.getOperands.size() == 2) {
        leftVersionExpression = Some(call.getOperands.get(0))
        rightPrimaryKeyExpression = Some(validateRightPrimaryKey(call.getOperands.get(1)))
      }
      else {
        throw new IllegalStateException(
          s"Unsupported invocation ${call} in [${textualRepresentation}]")
      }
      rexBuilder.makeLiteral(true)
    }
  }

  private def validateRightPrimaryKey(rightPrimaryKey: RexNode): RexNode = {
    if (joinInfo.rightKeys.size() != 1) {
      throw new ValidationException(
        s"Only single column join key is supported. " +
          s"Found ${joinInfo.rightKeys} in [${textualRepresentation}]")
    }
    val rightKey = joinInfo.rightKeys.get(0) + leftSchema.typeInfo.getTotalFields

    val primaryKeyVisitor = new PrimaryKeyVisitor
    rightPrimaryKey.accept(primaryKeyVisitor)

    primaryKeyVisitor.inputReference match {
      case None =>
        throw new IllegalStateException(
          s"Failed to find primary key reference in [${textualRepresentation}]")
      case Some(primaryKeyInputReference) if (primaryKeyInputReference != rightKey) =>
        throw new ValidationException(
          s"Join key [${rightKey}] must be the same as " +
            s"versioned table's primary key [${primaryKeyInputReference}] " +
            s"in [${textualRepresentation}]")
      case _ =>
        rightPrimaryKey
    }
  }

  /**
    * Extracts input references from primary key expression.
    */
  private class PrimaryKeyVisitor extends RexDefaultVisitor[RexNode] {
    var inputReference: Option[Int] = None

    override def visitInputRef(inputRef: RexInputRef): RexNode = {
      inputReference = Some(inputRef.getIndex)
      inputRef
    }

    override def visitNode(rexNode: RexNode): RexNode = {
      throw new ValidationException(
        s"Unsupported right primary key expression [${rexNode}] in [${textualRepresentation}]")
    }
  }
}
