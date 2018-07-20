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

package org.apache.flink.table.plan.rules.datastream

import org.apache.calcite.plan.{RelOptRule, RelOptRuleCall, RelTraitSet}
import org.apache.calcite.rel.RelNode
import org.apache.calcite.rel.convert.ConverterRule
import org.apache.calcite.rel.core.JoinRelType
import org.apache.flink.table.api.TableConfig
import org.apache.flink.table.plan.nodes.FlinkConventions
import org.apache.flink.table.plan.nodes.datastream.DataStreamVersionedJoin
import org.apache.flink.table.plan.nodes.logical.FlinkLogicalVersionedJoin
import org.apache.flink.table.plan.schema.RowSchema
import org.apache.flink.table.runtime.join.WindowJoinUtil

class DataStreamVersionedJoinRule
  extends ConverterRule(
    classOf[FlinkLogicalVersionedJoin],
    FlinkConventions.LOGICAL,
    FlinkConventions.DATASTREAM,
    "DataStreamVersionedJoinRule") {

  override def matches(call: RelOptRuleCall): Boolean = {
    val join: FlinkLogicalVersionedJoin = call.rel(0)
    val joinInfo = join.analyzeCondition

    val (windowBounds, remainingPreds) = WindowJoinUtil.extractWindowBoundsFromPredicate(
      joinInfo.getRemaining(join.getCluster.getRexBuilder),
      join.getLeft.getRowType.getFieldCount,
      join.getRowType,
      join.getCluster.getRexBuilder,
      TableConfig.DEFAULT)

    windowBounds.isEmpty && join.getJoinType == JoinRelType.INNER
  }

  override def convert(rel: RelNode): RelNode = {
    val versionedJoin = rel.asInstanceOf[FlinkLogicalVersionedJoin]
    val traitSet: RelTraitSet = rel.getTraitSet.replace(FlinkConventions.DATASTREAM)
    val left: RelNode = RelOptRule.convert(versionedJoin.getInput(0), FlinkConventions.DATASTREAM)
    val right: RelNode = RelOptRule.convert(versionedJoin.getInput(1), FlinkConventions.DATASTREAM)
    val joinInfo = versionedJoin.analyzeCondition
    val leftRowSchema = new RowSchema(left.getRowType)
    val rightRowSchema = new RowSchema(right.getRowType)

    new DataStreamVersionedJoin(
      rel.getCluster,
      traitSet,
      left,
      right,
      versionedJoin.getCondition,
      joinInfo,
      leftRowSchema,
      rightRowSchema,
      new RowSchema(rel.getRowType),
      description)
  }
}

object DataStreamVersionedJoinRule {
  val INSTANCE: RelOptRule = new DataStreamVersionedJoinRule
}
