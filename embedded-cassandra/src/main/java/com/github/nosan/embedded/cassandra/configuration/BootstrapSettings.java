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
import java.util.List;

/**
 * TODO.
 *
 * @author Dmytro Nosan
 */
public interface BootstrapSettings {

	/**
	 * Startup timeout.
	 *
	 * @return The value of the {@code timeout} attribute
	 */
	Duration getTimeout();

	/**
	 * Arguments that should be associated with the Apache Cassandra.
	 *
	 * @return The value of the {@code arguments} attribute
	 */
	List<String> getArguments();


	/**
	 * Apache Cassandra Config.
	 *
	 * @return The value of the {@code config} attribute
	 */
	Config getConfig();

	/**
	 * Working directory to use for the Apache Cassandra. If not specified, tempdir
	 * will be used.
	 *
	 * @return The value of the {@code workingDirectory} attribute
	 */
	Path getWorkingDirectory();

	/**
	 * Apache Cassandra artifact settings.
	 *
	 * @return The value of the {@code artifactSettings} attribute
	 */
	ArtifactSettings getArtifactSettings();

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
		 * @param timeout The value for timeout (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setTimeout(Duration timeout);

		/**
		 * Adds one element to {@link BootstrapSettings#getArguments() arguments} list.
		 *
		 * @param element A arguments element
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder addArguments(String element);

		/**
		 * Adds elements to {@link BootstrapSettings#getArguments() arguments} list.
		 *
		 * @param elements An array of arguments elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder addArguments(String... elements);

		/**
		 * Sets or replaces all elements for {@link BootstrapSettings#getArguments() arguments} list.
		 *
		 * @param elements An iterable of arguments elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setArguments(Iterable<String> elements);

		/**
		 * Adds elements to {@link BootstrapSettings#getArguments() arguments} list.
		 *
		 * @param elements An iterable of arguments elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder addArguments(Iterable<String> elements);

		/**
		 * Initializes the value for the {@link BootstrapSettings#getConfig() config} attribute.
		 *
		 * @param config The value for config (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 * @see Config.Builder
		 */
		Builder setConfig(Config config);

		/**
		 * Initializes the value for the {@link BootstrapSettings#getWorkingDirectory() workingDirectory} attribute.
		 *
		 * @param workingDirectory The value for workingDirectory (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setWorkingDirectory(Path workingDirectory);

		/**
		 * Initializes the value for the {@link BootstrapSettings#getArtifactSettings() artifactSettings} attribute.
		 *
		 * @param artifactSettings The value for artifactSettings (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 * @see ArtifactSettings.Builder
		 */
		Builder setArtifactSettings(ArtifactSettings artifactSettings);

		/**
		 * Builds a new {@link BootstrapSettings BootstrapSettings}.
		 *
		 * @return An  instance of BootstrapSettings
		 */
		BootstrapSettings build();
	}


}
