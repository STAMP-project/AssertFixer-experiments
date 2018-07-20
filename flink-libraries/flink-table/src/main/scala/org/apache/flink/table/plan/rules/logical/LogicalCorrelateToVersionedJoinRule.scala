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

package org.apache.flink.table.plan.rules.logical

import java.util
import java.util.Collections

import org.apache.calcite.plan.RelOptRule.{any, none, operand, some}
import org.apache.calcite.plan.{RelOptRule, RelOptRuleCall}
import org.apache.calcite.rel.RelNode
import org.apache.calcite.rel.core.TableFunctionScan
import org.apache.calcite.rel.logical.LogicalCorrelate
import org.apache.calcite.rex._
import org.apache.calcite.sql.fun.SqlCastFunction
import org.apache.flink.table.api.{Table, ValidationException}
import org.apache.flink.table.functions.TableVersionFunction
import org.apache.flink.table.functions.sql.ProctimeSqlFunction
import org.apache.flink.table.functions.utils.TableSqlFunction
import org.apache.flink.table.plan.logical.rel.LogicalVersionedJoin
import org.apache.flink.table.plan.schema.TimeIndicatorRelDataType
import org.apache.flink.table.plan.util.RexDefaultVisitor
import org.apache.flink.table.typeutils.TypeStringUtils
import org.apache.flink.util.Preconditions.checkState

class LogicalCorrelateToVersionedJoinRule
  extends RelOptRule(
    operand(classOf[LogicalCorrelate],
      some(
        operand(classOf[RelNode], any()),
        operand(classOf[TableFunctionScan], none()))),
    "LogicalCorrelateToVersionedJoinRule") {

  override def onMatch(call: RelOptRuleCall): Unit = {
    val logicalCorrelate: LogicalCorrelate = call.rel(0)
    val leftNode: RelNode = call.rel(1)
    val rightTableFunctionScan: TableFunctionScan = call.rel(2)

    val cluster = logicalCorrelate.getCluster

    new GetTableVersionFunctionCall(cluster.getRexBuilder, leftNode)
      .visit(rightTableFunctionScan.getCall) match {
      case Some(rightVersionedTableCall) =>
        val underlyingTableHistory: Table = rightVersionedTableCall.tableVersionFunction.table
        val relBuilder = this.relBuilderFactory.create(
          cluster,
          underlyingTableHistory.relBuilder.getRelOptSchema)
        val rexBuilder = cluster.getRexBuilder

        val rightNode: RelNode = underlyingTableHistory.logicalPlan.toRelNode(relBuilder)

        val rightVersionExpression = createRightExpression(
          rexBuilder,
          leftNode,
          rightNode,
          rightVersionedTableCall.tableVersionFunction.versionField)

        val rightPrimaryKeyExpression = createRightExpression(
          rexBuilder,
          leftNode,
          rightNode,
          rightVersionedTableCall.tableVersionFunction.primaryKey)

        relBuilder.push(
          if (rightVersionedTableCall.tableVersionFunction.isProctime) {
            LogicalVersionedJoin.create(
              rexBuilder,
              cluster,
              logicalCorrelate.getTraitSet,
              leftNode,
              rightNode,
              rightVersionedTableCall.versionExpression,
              rightPrimaryKeyExpression)
          }
          else {
            LogicalVersionedJoin.create(
              rexBuilder,
              cluster,
              logicalCorrelate.getTraitSet,
              leftNode,
              rightNode,
              rightVersionedTableCall.versionExpression,
              rightVersionExpression,
              rightPrimaryKeyExpression)
          })
        call.transformTo(relBuilder.build())
      case None =>
    }
  }

  private def createRightExpression(
      rexBuilder: RexBuilder,
      leftNode: RelNode,
      rightNode: RelNode,
      field: String): RexNode = {
    val rightReferencesOffset = leftNode.getRowType.getFieldCount
    val rightDataTypeField = rightNode.getRowType.getField(field, false, false)
    rexBuilder.makeInputRef(
      rightDataTypeField.getType, rightReferencesOffset + rightDataTypeField.getIndex)
  }
}

object LogicalCorrelateToVersionedJoinRule {
  val INSTANCE: RelOptRule = new LogicalCorrelateToVersionedJoinRule
}

/**
  * Simple pojo class for extracted [[TableVersionFunction]] with version expression
  * extracted by [[VersionExpressionExtractor]].
  */
class TableVersionFunctionCall(
    var tableVersionFunction: TableVersionFunction,
    var versionExpression: RexNode) {
}

/**
  * Find [[TableVersionFunction]] call and run [[VersionExpressionExtractor]] on it's operand.
  */
class GetTableVersionFunctionCall(
    var rexBuilder: RexBuilder,
    var leftSide: RelNode)
  extends RexVisitorImpl[TableVersionFunctionCall](false) {

  def visit(node: RexNode): Option[TableVersionFunctionCall] = {
    val result = node.accept(this)
    if (result == null) {
      return None
    }
    Some(result)
  }

  override def visitCall(rexCall: RexCall): TableVersionFunctionCall = {
    if (!rexCall.getOperator.isInstanceOf[TableSqlFunction]) {
      return null
    }
    val tableFunction = rexCall.getOperator.asInstanceOf[TableSqlFunction]
    if (!tableFunction.getTableFunction.isInstanceOf[TableVersionFunction]) {
      return null;
    }
    extractVersionExpression(
      tableFunction.getTableFunction.asInstanceOf[TableVersionFunction],
      rexCall.getOperands())
  }

  def extractVersionExpression(
      tableVersionFunction: TableVersionFunction,
      operands: util.List[RexNode]): TableVersionFunctionCall = {
    if (!operands.size().equals(1)) {
      throw new ValidationException("Table Version Function call must have exactly one argument")
    }
    val versionExpressionExtractor =
      new VersionExpressionExtractor(tableVersionFunction, rexBuilder, leftSide)
    val versionExpression: RexNode = operands.get(0).accept(versionExpressionExtractor)

    new TableVersionFunctionCall(tableVersionFunction, versionExpression)
  }
}

/**
  * This class extracts version expression from [[TableVersionFunction]] call and converts it
  * into an expression that can be used in join condition. Currently support for expressions
  * is very limited and boils down to CAST(some column reference AS TIMESTAMP).
  *
  * More expressions could be supported, for example:
  * CAST(some column reference AS TIMESTAMP) + INTERVAL 1 'SECOND'
  * But that would require to offset/transform watermarks in the operator implementing versioned
  * join.
  */
class VersionExpressionExtractor(
    var tableVersionFunction: TableVersionFunction,
    var rexBuilder: RexBuilder,
    var leftSide: RelNode) extends RexDefaultVisitor[RexNode] {

  /**
    * Convert correlated field access into input reference.
    */
  override def visitFieldAccess(fieldAccess: RexFieldAccess): RexNode = {
    val leftIndex = leftSide.getRowType.getFieldList.indexOf(fieldAccess.getField)
    if (leftIndex < 0) {
      throw new IllegalStateException(
        s"Failed to find reference to field [${fieldAccess.getField}] in node [$leftSide]")
    }
    rexBuilder.makeInputRef(leftSide, leftIndex)
  }

  /**
    * We only support CAST as calls at the moment.
    */
  override def visitCall(call: RexCall): RexNode = {
    if (call.getType.getSqlTypeName.name() != TypeStringUtils.TIMESTAMP.key) {
      visitNode(call)
    }
    call.getOperator match {
      case castFunction: SqlCastFunction =>
      case ProctimeSqlFunction =>
      case _ =>
        visitNode(call)
    }
    checkState(
      call.getOperands.size() == 1,
      "{} should have only one operand but found {}",
      classOf[SqlCastFunction],
      call)

    val originalOperand = call.getOperands.get(0)
    if (!originalOperand.getType.isInstanceOf[TimeIndicatorRelDataType]) {
      throw new ValidationException("Argument of a Table Version Function must be a TIME ATTRIBUTE")
    }

    val rewrittenOperand = originalOperand.accept(this)
    if (rewrittenOperand == originalOperand) {
      return call
    }

    rexBuilder.makeCall(call.getType, call.getOperator, Collections.singletonList(rewrittenOperand))
  }

  override def visitInputRef(inputRef: RexInputRef): RexNode = {
    inputRef
  }

  override def visitNode(rexNode: RexNode): RexNode = {
    throw new ValidationException(
      s"Unsupported argument [${rexNode}] " +
        s"in ${classOf[TableVersionFunction].getSimpleName} call of " +
        s"[${tableVersionFunction.table}] table")
  }
}
