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

package org.apache.flink.table.plan.logical.rel

import java.util.Collections

import org.apache.calcite.plan.{RelOptCluster, RelTraitSet}
import org.apache.calcite.rel.RelNode
import org.apache.calcite.rel.core._
import org.apache.calcite.rex.{RexBuilder, RexNode}
import org.apache.calcite.sql.`type`.{OperandTypes, ReturnTypes}
import org.apache.calcite.sql.{SqlFunction, SqlFunctionCategory, SqlKind}
import org.apache.flink.util.Preconditions.checkArgument

/**
  * Represents a join between a table and [[org.apache.flink.table.functions.TableVersionFunction]]
  *
  * @param cluster
  * @param traitSet
  * @param left stream
  * @param right table scan of underlying [[org.apache.flink.table.functions.TableVersionFunction]]
  * @param condition must contain [[LogicalVersionedJoin#VERSIONING_JOIN_CONDITION()]] with
  *                  correctly defined references to rightVersioneExpression,
  *                  rightPrimaryKeyExpression and leftVersionExpression. We can not implement
  *                  those references as separate fields, because of problems with Calcite's
  *                  optimization rules like projections push downs, column
  *                  pruning/renaming/reordering, etc. Later rightVersioneExpression,
  *                  rightPrimaryKeyExpression and leftVersionExpression will be extracted from
  *                  the condition.
  */
class LogicalVersionedJoin private (
    cluster: RelOptCluster,
    traitSet: RelTraitSet,
    left: RelNode,
    right: RelNode,
    condition: RexNode)
  extends Join(
    cluster,
    traitSet,
    left,
    right,
    condition,
    Collections.emptySet().asInstanceOf[java.util.Set[CorrelationId]],
    JoinRelType.INNER) {

  override def copy(
       traitSet: RelTraitSet,
       condition: RexNode,
       left: RelNode,
       right: RelNode,
       joinType: JoinRelType,
       semiJoinDone: Boolean): LogicalVersionedJoin = {
    checkArgument(joinType == this.getJoinType,
      "Can not change join type".asInstanceOf[Object])
    checkArgument(semiJoinDone == this.isSemiJoinDone,
      "Can not change semiJoinDone".asInstanceOf[Object])
    new LogicalVersionedJoin(
      cluster,
      traitSet,
      left,
      right,
      condition)
  }
}

object LogicalVersionedJoin {
  /**
    * See [[LogicalVersionedJoin#condition]]
    */
  val VERSIONING_JOIN_CONDITION = new SqlFunction(
    "__VERSIONING_JOIN_CONDITION",
    SqlKind.OTHER_FUNCTION,
    ReturnTypes.BOOLEAN_NOT_NULL,
    null,
    OperandTypes.or(
      OperandTypes.sequence(
        "'(LEFT_VERSION, RIGHT_VERSION, PRIMARY_KEY)'",
        OperandTypes.DATETIME,
        OperandTypes.DATETIME,
        OperandTypes.ANY),
      OperandTypes.sequence(
        "'(LEFT_VERSION, PRIMARY_KEY)'",
        OperandTypes.DATETIME,
        OperandTypes.ANY)),
    SqlFunctionCategory.SYSTEM)

  def makeRowTimeVersioningJoinConditionCall(
      rexBuilder: RexBuilder,
      leftVersionExpression: RexNode,
      rightVersionExpression: RexNode,
      rightPrimaryKeyExpression: RexNode): RexNode = {
    rexBuilder.makeCall(
      VERSIONING_JOIN_CONDITION,
      leftVersionExpression,
      rightVersionExpression,
      rightPrimaryKeyExpression)
  }

  def makeProcTimeVersioningJoinConditionCall(
        rexBuilder: RexBuilder,
        leftVersionExpression: RexNode,
        rightPrimaryKeyExpression: RexNode): RexNode = {
    rexBuilder.makeCall(
      VERSIONING_JOIN_CONDITION,
      leftVersionExpression,
      rightPrimaryKeyExpression)
  }

  /**
    * See [[LogicalVersionedJoin]]
    */
  def create(
      rexBuilder: RexBuilder,
      cluster: RelOptCluster,
      traitSet: RelTraitSet,
      left: RelNode,
      right: RelNode,
      leftVersionExpression: RexNode,
      rightVersionExpression: RexNode,
      rightPrimaryKeyExpression: RexNode)
    : LogicalVersionedJoin = {
    new LogicalVersionedJoin(
      cluster,
      traitSet,
      left,
      right,
      makeRowTimeVersioningJoinConditionCall(
        rexBuilder,
        leftVersionExpression,
        rightVersionExpression,
        rightPrimaryKeyExpression))
  }

  /**
    * See [[LogicalVersionedJoin]]
    */
  def create(
      rexBuilder: RexBuilder,
      cluster: RelOptCluster,
      traitSet: RelTraitSet,
      left: RelNode,
      right: RelNode,
      leftVersionExpression: RexNode,
      rightPrimaryKeyExpression: RexNode)
    : LogicalVersionedJoin = {
    new LogicalVersionedJoin(
      cluster,
      traitSet,
      left,
      right,
      makeProcTimeVersioningJoinConditionCall(
        rexBuilder,
        leftVersionExpression,
        rightPrimaryKeyExpression))
  }
}
