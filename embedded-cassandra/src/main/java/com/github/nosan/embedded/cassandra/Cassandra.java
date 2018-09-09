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
import com.github.nosan.embedded.cassandra.core.Executable;

/**
 * Simple class that allows the Apache Cassandra to be {@link #start() started} and {@link #stop()
 * stopped}.
 * <p> Note! This class doesn't include {@code Cluster} or {@code Session} creation, use
 * {@link DataStaxCassandra} instead.
 * <p>
 * The typical usage is:
 * <pre>
 * public class CassandraTests {
 * private final static Cassandra cassandra = new Cassandra();
 * &#64;BeforeClass
 * public static void start() {
 * cassandra.start();
 * }
 * &#64;Test
 * public void test() {
 * //
 * }
 * &#64;AfterClass
 * public static void stop() {
 * cassandra.stop();
 * }
 * }
 * </pre>
 *
 * @author Dmytro Nosan
 * @see DataStaxCassandra
 */
public class Cassandra {

	@Nonnull
	private final BootstrapSettings settings;

	@Nonnull
	private final Executable executable;

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
		silently(() -> Runtime.getRuntime().addShutdownHook(new Thread(this::stop)));
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
		synchronized (this) {
			if (this.initialized) {
				return;
			}
			this.initialized = true;
			try {
				this.executable.start();
			}
			catch (Throwable ex) {
				silently(this::stop);
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
		synchronized (this) {
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


	private static void silently(@Nonnull Runnable runnable) {
		try {
			runnable.run();
		}
		catch (Throwable ignore) {

		}
	}

}
