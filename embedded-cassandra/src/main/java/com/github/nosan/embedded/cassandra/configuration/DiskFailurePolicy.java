/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.nosan.embedded.cassandra.configuration;

/**
 * Policy for data disk failures.
 *
 * @author Dmytro Nosan
 */
public enum DiskFailurePolicy {
	/**
	 * Stop using the failed disk and respond to requests based on the remaining available SSTables. This allows
	 * obsolete data at consistency level of ONE.
	 */
	best_effort,
	/**
	 * Shut down gossip and Thrift, leaving the node effectively dead, but available for inspection using JMX.
	 */
	stop,
	/**
	 * Ignore fatal errors and lets the requests fail; all file system errors are logged but otherwise ignored.
	 * Cassandra acts as in versions prior to 1.2.
	 */
	ignore,
	/**
	 * Shut down gossip and Thrift even for single SSTable errors.
	 */
	stop_paranoid,
	/**
	 * Shut down gossip and Thrift and kill the JVM for any file system errors or single SSTable errors, so the node can
	 * be replaced.
	 */
	die
}
