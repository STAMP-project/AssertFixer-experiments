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

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.nosan.embedded.cassandra.Version;
import com.github.nosan.embedded.cassandra.artifact.ArtifactFactory;

/**
 * Builder to create a {@link LocalCassandraFactory}.
 *
 * @author Dmytro Nosan
 * @since 1.0.0
 */
public final class LocalCassandraFactoryBuilder {

	@Nonnull
	private final List<String> jvmOptions = new ArrayList<>();

	@Nullable
	private Version version;

	@Nullable
	private ArtifactFactory artifactFactory;

	@Nullable
	private Path workingDirectory;

	@Nullable
	private URL configurationFile;

	@Nullable
	private URL logbackFile;

	@Nullable
	private URL rackFile;

	@Nullable
	private URL topologyFile;

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getVersion() version} attribute.
	 *
	 * @param version The value for version
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setVersion(@Nullable Version version) {
		this.version = version;
		return this;
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getArtifactFactory() artifactFactory} attribute.
	 *
	 * @param artifactFactory The value for artifactFactory
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setArtifactFactory(@Nullable ArtifactFactory artifactFactory) {
		this.artifactFactory = artifactFactory;
		return this;
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getWorkingDirectory() workingDirectory} attribute.
	 *
	 * @param workingDirectory The value for workingDirectory
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setWorkingDirectory(@Nullable Path workingDirectory) {
		this.workingDirectory = workingDirectory;
		return this;
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getWorkingDirectory() workingDirectory} attribute.
	 *
	 * @param workingDirectory The value for workingDirectory
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setWorkingDirectory(@Nullable File workingDirectory) {
		return setWorkingDirectory((workingDirectory != null) ? workingDirectory.toPath() : null);
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getConfigurationFile() configurationFile} attribute.
	 *
	 * @param configurationFile The value for configurationFile
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setConfigurationFile(@Nullable Path configurationFile) {
		try {
			return setConfigurationFile((configurationFile != null) ? configurationFile.toUri().toURL() : null);
		}
		catch (MalformedURLException ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getConfigurationFile() configurationFile} attribute.
	 *
	 * @param configurationFile The value for configurationFile
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setConfigurationFile(@Nullable File configurationFile) {
		try {
			return setConfigurationFile((configurationFile != null) ? configurationFile.toURI().toURL() : null);
		}
		catch (MalformedURLException ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getConfigurationFile() configurationFile} attribute.
	 *
	 * @param configurationFile The value for configurationFile
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setConfigurationFile(@Nullable URL configurationFile) {
		this.configurationFile = configurationFile;
		return this;
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getLogbackFile() logbackFile} attribute.
	 *
	 * @param logbackFile The value for logbackFile
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setLogbackFile(@Nullable Path logbackFile) {
		try {
			return setLogbackFile((logbackFile != null) ? logbackFile.toUri().toURL() : null);
		}
		catch (MalformedURLException ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getLogbackFile() logbackFile} attribute.
	 *
	 * @param logbackFile The value for logbackFile
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setLogbackFile(@Nullable File logbackFile) {
		try {
			return setLogbackFile((logbackFile != null) ? logbackFile.toURI().toURL() : null);
		}
		catch (MalformedURLException ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getLogbackFile() logbackFile} attribute.
	 *
	 * @param logbackFile The value for logbackFile
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setLogbackFile(@Nullable URL logbackFile) {
		this.logbackFile = logbackFile;
		return this;
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getJvmOptions() jvmOptions} attribute.
	 *
	 * @param jvmOptions The value for jvmOptions
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setJvmOptions(@Nullable String... jvmOptions) {
		this.jvmOptions.clear();
		if (jvmOptions != null) {
			this.jvmOptions.addAll(Arrays.asList(jvmOptions));
		}
		return this;
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getRackFile() rackFile} attribute.
	 *
	 * @param rackFile The value for rackFile
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setRackFile(@Nullable Path rackFile) {
		try {
			return setRackFile((rackFile != null) ? rackFile.toUri().toURL() : null);
		}
		catch (MalformedURLException ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getRackFile() rackFile} attribute.
	 *
	 * @param rackFile The value for rackFile
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setRackFile(@Nullable File rackFile) {
		try {
			return setRackFile((rackFile != null) ? rackFile.toURI().toURL() : null);
		}
		catch (MalformedURLException ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getRackFile() rackFile} attribute.
	 *
	 * @param rackFile The value for rackFile
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setRackFile(@Nullable URL rackFile) {
		this.rackFile = rackFile;
		return this;
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getTopologyFile() topologyFile} attribute.
	 *
	 * @param topologyFile The value for topologyFile
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setTopologyFile(@Nullable Path topologyFile) {
		try {
			return setTopologyFile((topologyFile != null) ? topologyFile.toUri().toURL() : null);
		}
		catch (MalformedURLException ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getTopologyFile() topologyFile} attribute.
	 *
	 * @param topologyFile The value for topologyFile
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setTopologyFile(@Nullable File topologyFile) {
		try {
			return setTopologyFile((topologyFile != null) ? topologyFile.toURI().toURL() : null);
		}
		catch (MalformedURLException ex) {
			throw new IllegalArgumentException(ex);
		}
	}


	/**
	 * Initializes the value for the {@link LocalCassandraFactory#getTopologyFile() topologyFile} attribute.
	 *
	 * @param topologyFile The value for topologyFile
	 * @return {@code this} builder for use in a chained invocation
	 */
	@Nonnull
	public LocalCassandraFactoryBuilder setTopologyFile(@Nullable URL topologyFile) {
		this.topologyFile = topologyFile;
		return this;
	}


	/**
	 * Builds a new {@link LocalCassandraFactory}.
	 *
	 * @return a new instance
	 */
	@Nonnull
	public LocalCassandraFactory build() {
		LocalCassandraFactory factory = new LocalCassandraFactory();
		factory.setVersion(this.version);
		factory.setWorkingDirectory(this.workingDirectory);
		factory.setArtifactFactory(this.artifactFactory);
		factory.setConfigurationFile(this.configurationFile);
		factory.setLogbackFile(this.logbackFile);
		factory.setTopologyFile(this.topologyFile);
		factory.setRackFile(this.rackFile);
		factory.getJvmOptions().addAll(this.jvmOptions);
		return factory;
	}

}
