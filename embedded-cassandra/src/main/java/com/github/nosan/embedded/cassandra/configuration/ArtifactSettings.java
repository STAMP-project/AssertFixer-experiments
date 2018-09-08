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

/**
 * TODO.
 *
 * @author Dmytro Nosan
 */
public interface ArtifactSettings {

	/**
	 * Directory to save and extract Apache Cassandra. If not specified, user.dir
	 * will be used.
	 *
	 * @return The value of the {@code directory} attribute
	 */
	Path getDirectory();

	/**
	 * Connection timeout to be used
	 * when opening a communications link to the resource referenced
	 * by URLConnection.
	 *
	 * @return The value of the {@code connectTimeout} attribute
	 */
	Duration getConnectTimeout();

	/**
	 * Read timeout specifies the timeout when reading from Input stream
	 * when a connection is established to a resource.
	 *
	 * @return The value of the {@code readTimeout} attribute
	 */
	Duration getReadTimeout();

	/**
	 * Version to use.
	 *
	 * @return The value of the {@code version} attribute
	 */
	Version getVersion();

	/**
	 * Proxy settings (can be {@code null}).
	 *
	 * @return @return The value of the {@code proxy} attribute
	 */
	Proxy getProxy();

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
		 * Initializes the value for the {@link ArtifactSettings#getDirectory() directory} attribute.
		 *
		 * @param directory The value for directory (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setDirectory(Path directory);

		/**
		 * Initializes the value for the {@link ArtifactSettings#getConnectTimeout() connectTimeout} attribute.
		 *
		 * @param connectTimeout The value for connectTimeout (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setConnectTimeout(Duration connectTimeout);

		/**
		 * Initializes the value for the {@link ArtifactSettings#getReadTimeout() readTimeout} attribute.
		 *
		 * @param readTimeout The value for readTimeout (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setReadTimeout(Duration readTimeout);

		/**
		 * Initializes the value for the {@link ArtifactSettings#getVersion() version} attribute.
		 *
		 * @param version The value for version (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setVersion(Version version);

		/**
		 * Initializes the value for the {@link ArtifactSettings#getProxy() proxy} attribute.
		 *
		 * @param proxy The value for proxy (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setProxy(Proxy proxy);

		/**
		 * Builds a new {@link ArtifactSettings ArtifactSettings}.
		 *
		 * @return An instance of ArtifactSettings
		 */
		ArtifactSettings build();
	}

}



