/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.calcite.rel.rules;

import org.apache.calcite.rel.core.RelFactories;
import org.apache.calcite.rel.core.SemiJoin;
import org.apache.calcite.tools.RelBuilderFactory;

/**
 * Rule that converts a {@link org.apache.calcite.rel.core.SemiJoin}
 * into a {@link org.apache.calcite.rel.logical.LogicalCorrelate}, which can
 * then be implemented using nested loops.
 */
public class SemiJoinToCorrelateRule extends JoinToCorrelateRule {
  //~ Static fields/initializers ---------------------------------------------

  public static final SemiJoinToCorrelateRule INSTANCE =
          new SemiJoinToCorrelateRule(RelFactories.LOGICAL_BUILDER);

  //~ Constructors -----------------------------------------------------------

  /**
   * Creates a SemiJoinToCorrelate.
   */
  public SemiJoinToCorrelateRule(RelBuilderFactory relBuilderFactory) {
    super(SemiJoin.class, relBuilderFactory);
  }
}

// End SemiJoinToCorrelateRule.java
