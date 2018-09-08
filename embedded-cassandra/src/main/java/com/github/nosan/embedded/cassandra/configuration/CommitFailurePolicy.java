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
 * Policy for commit disk failures.
 *
 * @author Dmytro Nosan
 */
public enum CommitFailurePolicy {
	/**
	 * Shut down gossip and Thrift, leaving the node effectively dead, available for inspection using JMX.
	 */
	stop,
	/**
	 * Shut down the commit log, letting writes collect but continuing to service reads (as in pre-2.0.5 Cassandra).
	 */
	stop_commit,
	/**
	 * Ignore fatal errors and let the batches fail.
	 */
	ignore,
	/**
	 * Shut down gossip and Thrift and kill the JVM, so the node can be replaced.
	 */
	die,
}
