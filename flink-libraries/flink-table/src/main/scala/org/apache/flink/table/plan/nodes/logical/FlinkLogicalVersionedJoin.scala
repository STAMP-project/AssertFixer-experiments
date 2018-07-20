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

package org.apache.flink.table.plan.nodes.logical

import org.apache.calcite.plan._
import org.apache.calcite.rel.RelNode
import org.apache.calcite.rel.convert.ConverterRule
import org.apache.calcite.rel.core._
import org.apache.calcite.rex.RexNode
import org.apache.flink.table.plan.logical.rel.LogicalVersionedJoin
import org.apache.flink.table.plan.nodes.FlinkConventions
import org.apache.flink.util.Preconditions.checkArgument

/**
  * Represents a join between a table and [[org.apache.flink.table.functions.TableVersionFunction]].
  * For more details please check [[LogicalVersionedJoin]].
  */
class FlinkLogicalVersionedJoin(
    cluster: RelOptCluster,
    traitSet: RelTraitSet,
    left: RelNode,
    right: RelNode,
    condition: RexNode)
  extends FlinkAbstractLogicalJoinWithCost(
    cluster,
    traitSet,
    left,
    right,
    condition,
    JoinRelType.INNER) {

  def copy(
      traitSet: RelTraitSet,
      condition: RexNode,
      left: RelNode,
      right: RelNode,
      joinType: JoinRelType,
      semiJoinDone: Boolean): FlinkLogicalVersionedJoin = {
    checkArgument(joinType == this.getJoinType,
      "Can not change join type".asInstanceOf[Object])
    checkArgument(semiJoinDone == this.isSemiJoinDone,
      "Can not change semiJoinDone".asInstanceOf[Object])
    new FlinkLogicalVersionedJoin(
      cluster,
      traitSet,
      left,
      right,
      condition)
  }
}

class FlinkLogicalVersionedJoinConverter
  extends ConverterRule(
    classOf[LogicalVersionedJoin],
    Convention.NONE,
    FlinkConventions.LOGICAL,
    "FlinkLogicalVersionedJoinConverter") {

  override def matches(call: RelOptRuleCall): Boolean = {
    true
  }

  override def convert(rel: RelNode): RelNode = {
    val versionedJoin = rel.asInstanceOf[LogicalVersionedJoin]
    val traitSet = rel.getTraitSet.replace(FlinkConventions.LOGICAL)
    val newLeft = RelOptRule.convert(versionedJoin.getLeft, FlinkConventions.LOGICAL)
    val newRight = RelOptRule.convert(versionedJoin.getRight, FlinkConventions.LOGICAL)

    new FlinkLogicalVersionedJoin(
      rel.getCluster,
      traitSet,
      newLeft,
      newRight,
      versionedJoin.getCondition)
  }
}

object FlinkLogicalVersionedJoin {
  val CONVERTER = new FlinkLogicalVersionedJoinConverter
}
