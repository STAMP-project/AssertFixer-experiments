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

package com.github.nosan.embedded.cassandra;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.nosan.embedded.cassandra.configuration.BootstrapSettings;

/**
 * Simple class that represents Apache Cassandra. Allows the cassandra to be {@link #start() started} and {@link #stop()
 * stopped}.
 * <pre>
 * public class CassandraTests {
 *        &#64;Test
 * 	public void test() {
 * 		Cassandra cassandra = new Cassandra();
 * 		try {
 * 			cassandra.start();
 *        }
 * 		finally {
 * 			cassandra.stop();
 *        }
 *    }
 * }
 * </pre>
 *
 * @author Dmytro Nosan
 * @see EmbeddedCassandra
 */
public class Cassandra {

	@Nonnull
	private final BootstrapSettings settings;

	@Nonnull
	private final Executable executable;

	private final Object monitor = new Object();

	private volatile boolean initialized = false;

	/**
	 * Create Apache Casandra with a custom {@code BootstrapSettings}.
	 *
	 * @param settings Bootstrap Settings
	 * @see BootstrapSettings.Builder
	 */
	public Cassandra(@Nullable BootstrapSettings settings) {
		this.settings = (settings != null) ? settings : BootstrapSettings.builder()
				.build();
		this.executable = new Executable(this.settings);
		Runtime.getRuntime().addShutdownHook(new Thread(this::stop));
	}

	/**
	 * Create Apache Casandra with a default {@code BootstrapSettings}.
	 */
	public Cassandra() {
		this(null);
	}

	/**
	 * Starts the Apache Cassandra. Calling this method on an already started {@code Apache Cassandra} has no
	 * effect.
	 *
	 * @throws CassandraException if the Apache Cassandra cannot be started
	 */
	public void start() throws CassandraException {
		synchronized (this.monitor) {
			if (this.initialized) {
				return;
			}
			this.initialized = true;
			try {
				this.executable.start();
			}
			catch (Throwable ex) {
				try {
					stop();
				}
				catch (Throwable ignore) {
				}
				throw new CassandraException(ex);
			}
		}

	}

	/**
	 * Stops the Apache Cassandra. Calling this method on an already stopped {@code Apache Cassandra} has no
	 * effect.
	 *
	 * @throws CassandraException if the Apache Cassandra cannot be stopped
	 */
	public void stop() throws CassandraException {
		synchronized (this.monitor) {
			if (!this.initialized) {
				return;
			}
			this.initialized = false;
			try {
				this.executable.stop();
			}
			catch (Throwable ex) {
				throw new CassandraException(ex);
			}
		}
	}

	/**
	 * Return a {@link BootstrapSettings}.
	 *
	 * @return The value of the {@code settings} attribute
	 * @see BootstrapSettings
	 */
	@Nonnull
	public final BootstrapSettings getSettings() {
		return this.settings;
	}

}
