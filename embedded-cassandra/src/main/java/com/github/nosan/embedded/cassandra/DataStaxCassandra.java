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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

import com.github.nosan.embedded.cassandra.configuration.BootstrapSettings;
import com.github.nosan.embedded.cassandra.configuration.Config;
import com.github.nosan.embedded.cassandra.cql.CqlScriptUtils;
import com.github.nosan.embedded.cassandra.util.StringUtils;

/**
 * {@link Cassandra} extension which adds functionality not only to start Apache Cassandra, but a
 * {@link Cluster} creation as well.
 * <p>
 * The typical usage is:
 * <pre>
 * public class CassandraTests {
 * private final static DataStaxCassandra cassandra = new DataStaxCassandra();
 * &#64;BeforeClass
 * public static void start() {
 * cassandra.start();
 * }
 * &#64;Test
 * public void test() {
 * Session session = cassandra.getSession();
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
 * @see Cassandra
 * @see CqlScriptUtils
 */
public class DataStaxCassandra extends Cassandra {

	@Nonnull
	private final ClusterFactory clusterFactory;

	@Nullable
	private volatile Cluster cluster;


	/**
	 * Create Apache Casandra with a default {@code BootstrapSettings} and {@code ClusterFactory}.
	 */
	public DataStaxCassandra() {
		this(null, null);
	}

	/**
	 * Create Apache Casandra with a custom {@code BootstrapSettings} and default {@code ClusterFactory}.
	 *
	 * @param settings Bootstrap Settings
	 * @see BootstrapSettings.Builder
	 */
	public DataStaxCassandra(@Nullable BootstrapSettings settings) {
		this(settings, null);
	}

	/**
	 * Create Apache Casandra with a custom {@code ClusterFactory} and default {@code BootstrapSettings}.
	 *
	 * @param clusterFactory Cluster Factory to create a {@code Cluster}
	 * @see ClusterFactory
	 */
	public DataStaxCassandra(@Nullable ClusterFactory clusterFactory) {
		this(null, clusterFactory);
	}

	/**
	 * Create Apache Casandra with a custom {@code BootstrapSettings} and {@code ClusterFactory}.
	 *
	 * @param settings Bootstrap Settings
	 * @param clusterFactory Cluster Factory to create a {@code Cluster}
	 * @see BootstrapSettings.Builder
	 * @see ClusterFactory
	 */
	public DataStaxCassandra(@Nullable BootstrapSettings settings, @Nullable ClusterFactory clusterFactory) {
		super(settings);
		this.clusterFactory = (clusterFactory != null) ?
				new DelegateClusterFactory(clusterFactory) : DefaultClusterFactory.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Closes a {@link Cluster} to Apache Cassandra.
	 */
	@Override
	public void stop() throws CassandraException {
		synchronized (this) {
			try {
				Cluster cluster = this.cluster;
				if (cluster != null) {
					cluster.close();
				}
			}
			catch (Throwable ignore) {
			}
			finally {
				this.cluster = null;
			}
			super.stop();
		}
	}

	/**
	 * Return a {@code Cluster} which is associated with Apache Cassandra.
	 *
	 * @return a Cluster
	 */
	@Nonnull
	public Cluster getCluster() {
		if (this.cluster == null) {
			synchronized (this) {
				if (this.cluster == null) {
					this.cluster = this.clusterFactory.create(getSettings());
				}
			}
		}
		return Objects.requireNonNull(this.cluster, "Cluster must not be null");
	}

	/**
	 * Creates a new session on this cluster but does not initialize it.
	 *
	 * @return a new, non-initialized session on this cluster.
	 * @see Cluster#newSession()
	 */
	@Nonnull
	public Session getSession() {
		return getCluster().newSession();
	}

	/**
	 * Factory to create a {@link Cluster}.
	 *
	 * @author Dmytro Nosan
	 */
	public interface ClusterFactory {
		/**
		 * Creates a new {@link Cluster} which is associated with Apache Cassandra.
		 *
		 * @param settings {@code Bootstrap Settings}.
		 * @return a Cluster.
		 * @see Cluster#builder()
		 * @see BootstrapSettings#getConfig()
		 */
		@Nonnull
		Cluster create(@Nonnull BootstrapSettings settings);
	}


	private static final class DefaultClusterFactory implements ClusterFactory {

		private final static ClusterFactory INSTANCE = new DefaultClusterFactory();

		@Nonnull
		@Override
		public Cluster create(@Nonnull BootstrapSettings settings) {
			Config config = settings.getConfig();
			return Cluster.builder()
					.withoutMetrics()
					.withoutJMXReporting()
					.addContactPoint(StringUtils.hasText(config.getRpcAddress()) ? config.getRpcAddress() : "localhost")
					.withPort(config.getNativeTransportPort())
					.build();
		}

	}

	private static final class DelegateClusterFactory implements ClusterFactory {

		@Nonnull
		private final ClusterFactory delegate;

		private DelegateClusterFactory(@Nonnull ClusterFactory delegate) {
			this.delegate = delegate;
		}

		@Nonnull
		@Override
		public Cluster create(@Nonnull BootstrapSettings settings) {
			Cluster cluster = this.delegate.create(settings);
			return Objects.requireNonNull(cluster, this.delegate + " return a null Cluster");
		}
	}


}
