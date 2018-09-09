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

import java.nio.file.Path;
import java.time.Duration;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nonnull;


/**
 * Bootstrap settings to start Apache Cassandra.
 *
 * @author Dmytro Nosan
 */
public interface BootstrapSettings {

	/**
	 * Startup timeout.
	 *
	 * @return The value of the {@code timeout} attribute
	 */
	@Nonnull
	Duration getTimeout();

	/**
	 * Arguments that should be associated with the Apache Cassandra.
	 *
	 * @return The value of the {@code arguments} attribute
	 */
	@Nonnull
	List<String> getArguments();

	/**
	 * Apache Cassandra Config.
	 *
	 * @return The value of the {@code config} attribute
	 */
	@Nonnull
	Config getConfig();

	/**
	 * Working directory to use for the Apache Cassandra.
	 *
	 * @return The value of the {@code workingDirectory} attribute
	 */
	@Nonnull
	Path getWorkingDirectory();

	/**
	 * Apache Cassandra artifact settings.
	 *
	 * @return The value of the {@code artifactSettings} attribute
	 */
	@Nonnull
	ArtifactSettings getArtifactSettings();

	/**
	 * Create a new builder to build a {@link BootstrapSettings}.
	 *
	 * @return a fresh {@code Builder}.
	 */
	@Nonnull
	static Builder builder() {
		return new BootstrapSettingsBuilder();
	}

	/**
	 * Builds instances of type {@link BootstrapSettings BootstrapSettings}. Initialize attributes and then invoke the
	 * {@link #build()} method to create an instance.
	 * <p><em>{@code BootstrapSettingsBuilder} is not thread-safe and generally should not be stored in a field or
	 * collection, but instead used immediately to create instances.</em>
	 *
	 * @author Dmytro Nosan
	 */
	interface Builder {

		/**
		 * Initializes the value for the {@link BootstrapSettings#getTimeout() timeout} attribute.
		 *
		 * @param timeout The value for timeout
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setTimeout(@Nonnull Duration timeout);

		/**
		 * Adds arguments to {@link BootstrapSettings#getArguments() arguments} list.
		 *
		 * @param arguments An array of arguments elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder addArguments(@Nonnull String... arguments);

		/**
		 * Sets or replaces all arguments for {@link BootstrapSettings#getArguments() arguments} list.
		 *
		 * @param arguments A collection of arguments elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setArguments(@Nonnull Collection<String> arguments);

		/**
		 * Adds arguments to {@link BootstrapSettings#getArguments() arguments} list.
		 *
		 * @param arguments A collection of arguments elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder addArguments(@Nonnull Collection<String> arguments);

		/**
		 * Initializes the value for the {@link BootstrapSettings#getConfig() config} attribute.
		 *
		 * @param config The value for config
		 * @return {@code this} builder for use in a chained invocation
		 * @see Config.Builder
		 */
		@Nonnull
		Builder setConfig(@Nonnull Config config);

		/**
		 * Initializes the value for the {@link BootstrapSettings#getWorkingDirectory() workingDirectory} attribute. If
		 * not specified, {@code java.io.tmpdir} will be used.
		 *
		 * @param workingDirectory The value for workingDirectory
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setWorkingDirectory(@Nonnull Path workingDirectory);

		/**
		 * Initializes the value for the {@link BootstrapSettings#getArtifactSettings() artifactSettings} attribute.
		 *
		 * @param artifactSettings The value for artifactSettings
		 * @return {@code this} builder for use in a chained invocation
		 * @see ArtifactSettings.Builder
		 */
		@Nonnull
		Builder setArtifactSettings(@Nonnull ArtifactSettings artifactSettings);

		/**
		 * Builds a new {@link BootstrapSettings BootstrapSettings}.
		 *
		 * @return An  instance of BootstrapSettings
		 */
		@Nonnull
		BootstrapSettings build();
	}

}
