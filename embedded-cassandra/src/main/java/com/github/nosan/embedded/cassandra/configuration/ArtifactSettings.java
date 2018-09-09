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

import java.net.Proxy;
import java.nio.file.Path;
import java.time.Duration;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * Apache Cassandra artifact settings.
 *
 * @author Dmytro Nosan
 */
public interface ArtifactSettings {

	/**
	 * Directory to use for Apache Cassandra archive and extract files.
	 *
	 * @return The value of the {@code directory} attribute
	 */
	@Nonnull
	Path getDirectory();

	/**
	 * Connection timeout to be used
	 * when opening a communications link to the resource referenced
	 * by URLConnection.
	 *
	 * @return The value of the {@code connectTimeout} attribute
	 */
	@Nullable
	Duration getConnectTimeout();

	/**
	 * Read timeout specifies the timeout when reading from Input stream
	 * when a connection is established to a resource.
	 *
	 * @return The value of the {@code readTimeout} attribute
	 */
	@Nullable
	Duration getReadTimeout();

	/**
	 * Version of Apache Cassandra.
	 *
	 * @return The value of the {@code version} attribute
	 */
	@Nonnull
	Version getVersion();

	/**
	 * Proxy settings.
	 *
	 * @return @return The value of the {@code proxy} attribute
	 */
	@Nullable
	Proxy getProxy();

	/**
	 * Create a new builder to build a {@link ArtifactSettings}.
	 *
	 * @return a fresh {@code Builder}.
	 */
	@Nonnull
	static Builder builder() {
		return new ArtifactSettingsBuilder();
	}

	/**
	 * Builds instances of type {@link ArtifactSettings ArtifactSettings}. Initialize attributes and then invoke the
	 * {@link #build()} method to create an instance.
	 * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
	 * but instead used immediately to create instances.</em>
	 *
	 * @author Dmytro Nosan
	 */
	interface Builder {
		/**
		 * Initializes the value for the {@link ArtifactSettings#getDirectory() directory} attribute. If not specified,
		 * {@code user.home}  will be used.
		 *
		 * @param directory The value for directory
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setDirectory(@Nonnull Path directory);

		/**
		 * Initializes the value for the {@link ArtifactSettings#getConnectTimeout() connectTimeout} attribute.
		 *
		 * @param connectTimeout The value for connectTimeout
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setConnectTimeout(@Nullable Duration connectTimeout);

		/**
		 * Initializes the value for the {@link ArtifactSettings#getReadTimeout() readTimeout} attribute.
		 *
		 * @param readTimeout The value for readTimeout
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setReadTimeout(@Nullable Duration readTimeout);

		/**
		 * Initializes the value for the {@link ArtifactSettings#getVersion() version} attribute.
		 *
		 * @param version The value for version
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setVersion(@Nonnull Version version);

		/**
		 * Initializes the value for the {@link ArtifactSettings#getProxy() proxy} attribute.
		 *
		 * @param proxy The value for proxy
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setProxy(@Nullable Proxy proxy);

		/**
		 * Builds a new {@link ArtifactSettings ArtifactSettings}.
		 *
		 * @return An instance of ArtifactSettings
		 */
		@Nonnull
		ArtifactSettings build();
	}

}


