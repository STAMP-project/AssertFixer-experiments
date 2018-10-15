/*
 * Copyright 2018-2018 the original author or authors.
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

package com.github.nosan.embedded.cassandra.local;

import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nosan.embedded.cassandra.Cassandra;
import com.github.nosan.embedded.cassandra.CassandraException;
import com.github.nosan.embedded.cassandra.Settings;
import com.github.nosan.embedded.cassandra.Version;
import com.github.nosan.embedded.cassandra.artifact.Artifact;
import com.github.nosan.embedded.cassandra.artifact.ArtifactFactory;

/**
 * Local {@link Cassandra} implementation.
 *
 * @author Dmytro Nosan
 * @since 1.0.0
 */
final class LocalCassandraDelegate implements Cassandra {

	private static final Logger log = LoggerFactory.getLogger(Cassandra.class);

	@Nonnull
	private final Version version;

	@Nonnull
	private final ArtifactFactory artifactFactory;

	@Nonnull
	private final List<? extends DirectoryInitializer> initializers;

	@Nonnull
	private final Directory directory;

	@Nonnull
	private final LocalCassandra cassandra;

	private volatile boolean initialized = false;


	LocalCassandraDelegate(@Nonnull Version version, @Nonnull ArtifactFactory artifactFactory,
			@Nonnull Path workingDirectory,
			@Nullable URL configurationFile, @Nullable URL logbackFile,
			@Nullable URL rackFile, @Nullable URL topologyFile, @Nullable List<String> jvmOptions) {
		List<DirectoryInitializer> initializers = new ArrayList<>();
		initializers.add(new LogbackFileInitializer(logbackFile));
		initializers.add(new ConfigurationFileInitializer(configurationFile));
		initializers.add(new RackFileInitializer(rackFile));
		initializers.add(new TopologyFileInitializer(topologyFile));
		initializers.add(new JvmOptionsInitializer(jvmOptions));
		this.initializers = Collections.unmodifiableList(initializers);
		this.artifactFactory = Objects.requireNonNull(artifactFactory, "Artifact Factory must not be null");
		this.version = Objects.requireNonNull(version, "Version must not be null");
		this.directory = new BaseDirectory(Objects.requireNonNull(workingDirectory, "Working Directory must not be " +
				"null"));
		this.cassandra = new LocalCassandra(this.directory);
		silently(() -> Runtime.getRuntime().addShutdownHook(new Thread(this::stop)));
	}


	@Override
	public void start() throws CassandraException {
		try {
			if (!this.initialized) {
				synchronized (this) {
					try {
						if (!this.initialized) {
							long start = System.currentTimeMillis();
							log.info("Starts Apache Cassandra");
							Artifact artifact = this.artifactFactory.create(this.version);
							Objects.requireNonNull(artifact, "Artifact must not be null");
							this.directory.initialize(artifact);
							Path directory = this.directory.get();
							for (DirectoryInitializer initializer : this.initializers) {
								initializer.initialize(directory, this.version);
							}
							this.cassandra.start();
							long end = System.currentTimeMillis();
							log.info("Apache Cassandra has been started ({} ms) ", end - start);
						}
					}
					finally {
						this.initialized = true;
					}
				}
			}
		}
		catch (Throwable ex) {
			silently(this::stop);
			throw new CassandraException("Unable to start Cassandra", ex);
		}
	}


	@Override
	public void stop() throws CassandraException {
		if (this.initialized) {
			synchronized (this) {
				if (this.initialized) {
					long start = System.currentTimeMillis();
					log.info("Stops Apache Cassandra");
					try {
						this.cassandra.stop();
					}
					catch (Throwable ex) {
						throw new CassandraException("Unable to stop Cassandra", ex);
					}
					finally {
						silently(this.directory::destroy);
						this.initialized = false;
					}
					long end = System.currentTimeMillis();
					log.info("Apache Cassandra has been stopped ({} ms) ", end - start);
				}
			}
		}
	}

	@Nonnull
	@Override
	public Settings getSettings() throws CassandraException {
		if (!this.initialized) {
			throw new CassandraException("Cassandra is not initialized. Please start it before calling this method.");
		}
		try {
			return this.cassandra.getSettings();
		}
		catch (Exception ex) {
			throw new CassandraException("Could not get a settings", ex);
		}
	}


	private static void silently(Action action) {
		try {
			action.run();
		}
		catch (Throwable ex) {
			if (log.isDebugEnabled()) {
				log.error(ex.getMessage(), ex);
			}
		}
	}


	/**
	 * Utility interface for {@link #silently(Action)} method.
	 */
	private interface Action {
		/**
		 * run an action.
		 *
		 * @throws Throwable any of errors
		 */
		void run() throws Throwable;
	}


}
