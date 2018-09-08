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

import java.util.Objects;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

import com.github.nosan.embedded.cassandra.configuration.BootstrapSettings;
import com.github.nosan.embedded.cassandra.configuration.Config;
import com.github.nosan.embedded.cassandra.cql.CqlScript;
import com.github.nosan.embedded.cassandra.cql.CqlScriptUtils;

/**
 * {@link Cassandra} extension which adds functionality not only to start Apache Cassandra, but a
 * {@link Cluster} creation as well.
 *
 * @author Dmytro Nosan
 * @see Cassandra
 * @see CqlScriptUtils
 */
public class EmbeddedCassandra extends Cassandra {

	private final Object monitor = new Object();

	private final CqlScript[] scripts;

	private volatile Cluster cluster;

	private volatile boolean initialized = false;


	/**
	 * Create Apache Casandra with a custom {@code BootstrapSettings}.
	 *
	 * @param settings Bootstrap Settings (can be {@code null})
	 * @param scripts CQL scripts to execute (can be {@code null})
	 * @see BootstrapSettings.Builder
	 */
	public EmbeddedCassandra(BootstrapSettings settings, CqlScript... scripts) {
		super(settings);
		this.scripts = scripts;
	}

	/**
	 * Create Apache Casandra with a default {@code BootstrapSettings}.
	 *
	 * @param scripts CQL scripts to execute (can be {@code null})
	 */
	public EmbeddedCassandra(CqlScript... scripts) {
		this(null, scripts);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Creates a {@link Cluster} to Apache Cassandra and executes
	 * {@link CqlScript CqlScripts}
	 */
	@Override
	public void start() throws CassandraException {
		synchronized (this.monitor) {
			if (this.initialized) {
				return;
			}
			this.initialized = true;
			super.start();
			try {
				this.cluster = getCluster(getSettings());
				Objects.requireNonNull(this.cluster, "Cluster must not be null");
				CqlScriptUtils.execute(getSession(), this.scripts);
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
	 * {@inheritDoc}
	 * <p>
	 * Closes a {@link Cluster} to Apache Cassandra.
	 */
	@Override
	public void stop() throws CassandraException {
		synchronized (this.monitor) {
			if (!this.initialized) {
				return;
			}
			this.initialized = false;
			if (this.cluster != null) {
				this.cluster.closeAsync();
			}
			super.stop();
		}
	}


	/**
	 * Return a {@code Cluster} which is associated with Apache Cassandra.
	 *
	 * @return a Cluster
	 */
	public Cluster getCluster() {
		synchronized (this.monitor) {
			if (!this.initialized) {
				throw new IllegalStateException(
						"Cluster is not initialized. Did you call a start method ?");
			}
			return this.cluster;
		}
	}

	/**
	 * Creates a new session on {@link #getCluster() Cluster} and initialize it.
	 *
	 * @return a new session on this cluster sets to no keyspace.
	 * @see Cluster#connect()
	 */
	public Session getSession() {
		return getCluster().connect();
	}


	/**
	 * Creates a new {@link Cluster} which is associated with Apache Cassandra.
	 *
	 * @param settings {@code Bootstrap Settings}.
	 * @return a Cluster.
	 * @see Cluster#builder()
	 * @see BootstrapSettings#getConfig()
	 */
	protected Cluster getCluster(BootstrapSettings settings) {
		Config config = settings.getConfig();
		return Cluster.builder()
				.withoutMetrics()
				.withoutJMXReporting()
				.addContactPoint(config.getRpcAddress())
				.withPort(config.getNativeTransportPort())
				.build();
	}

}
