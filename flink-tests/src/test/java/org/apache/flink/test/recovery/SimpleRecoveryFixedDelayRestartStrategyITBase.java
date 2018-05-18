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

package org.apache.flink.test.recovery;

import org.apache.flink.configuration.ConfigConstants;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.test.util.MiniClusterResource;

import org.junit.ClassRule;

/**
 * Test cluster configuration with fixed-delay recovery.
 */
public class SimpleRecoveryFixedDelayRestartStrategyITBase extends SimpleRecoveryITCaseBase {

	@ClassRule
	public static final MiniClusterResource MINI_CLUSTER_RESOURCE = new MiniClusterResource(
		new MiniClusterResource.MiniClusterResourceConfiguration(
			getConfiguration(),
			2,
			2));

	private static Configuration getConfiguration() {
		Configuration config = new Configuration();
		config.setString(ConfigConstants.RESTART_STRATEGY, "fixed-delay");
		config.setInteger(ConfigConstants.RESTART_STRATEGY_FIXED_DELAY_ATTEMPTS, 1);
		config.setString(ConfigConstants.RESTART_STRATEGY_FIXED_DELAY_DELAY, "100 ms");

		return config;
	}
}
