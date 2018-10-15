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

package com.github.nosan.embedded.cassandra.artifact;

import java.net.Proxy;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.nosan.embedded.cassandra.Version;
import com.github.nosan.embedded.cassandra.util.FileUtils;

/**
 * {@link ArtifactFactory} to create a remote {@link Artifact}.
 *
 * @author Dmytro Nosan
 * @see RemoteArtifactFactoryBuilder
 * @since 1.0.0
 */
public final class RemoteArtifactFactory implements ArtifactFactory {

	@Nullable
	private Path directory;

	@Nullable
	private UrlFactory urlFactory;

	@Nullable
	private Proxy proxy;

	@Nullable
	private Duration readTimeout;

	@Nullable
	private Duration connectTimeout;

	/**
	 * The directory where {@link Artifact} should save an artifact({@code archive}) from
	 * {@link UrlFactory#create(Version) URL}. <p>Default directory is: {@link FileUtils#getUserHomeDirectory()
	 * user.home}
	 *
	 * @return The value of the {@code directory} attribute
	 */
	@Nullable
	public Path getDirectory() {
		return this.directory;
	}

	/**
	 * Initializes the value for the {@link RemoteArtifactFactory#getDirectory() directory} attribute.
	 *
	 * @param directory The value for directory
	 */
	public void setDirectory(@Nullable Path directory) {
		this.directory = directory;
	}

	/**
	 * Set factory that creates {@link URL}.
	 *
	 * @return The value of the {@code urlFactory} attribute
	 */
	@Nullable
	public UrlFactory getUrlFactory() {
		return this.urlFactory;
	}

	/**
	 * Initializes the value for the {@link RemoteArtifactFactory#getUrlFactory() urlFactory} attribute.
	 *
	 * @param urlFactory The value for urlFactory
	 */
	public void setUrlFactory(@Nullable UrlFactory urlFactory) {
		this.urlFactory = urlFactory;
	}

	/**
	 * Proxy settings.
	 *
	 * @return The value of the {@code proxy} attribute
	 */
	@Nullable
	public Proxy getProxy() {
		return this.proxy;
	}

	/**
	 * Initializes the value for the {@link RemoteArtifactFactory#getProxy() proxy} attribute.
	 *
	 * @param proxy The value for proxy
	 */
	public void setProxy(@Nullable Proxy proxy) {
		this.proxy = proxy;
	}

	/**
	 * Read timeout specifies the timeout when reading from InputStream when a connection is established to a resource.
	 *
	 * @return The value of the {@code readTimeout} attribute
	 */
	@Nullable
	public Duration getReadTimeout() {
		return this.readTimeout;
	}

	/**
	 * Initializes the value for the {@link RemoteArtifactFactory#getReadTimeout() readTimeout} attribute.
	 *
	 * @param readTimeout The value for readTimeout
	 */
	public void setReadTimeout(@Nullable Duration readTimeout) {
		this.readTimeout = readTimeout;
	}

	/**
	 * Connection timeout to be used when opening a communications link to the resource referenced
	 * by URLConnection.
	 *
	 * @return The value of the {@code connectTimeout} attribute
	 */
	@Nullable
	public Duration getConnectTimeout() {
		return this.connectTimeout;
	}

	/**
	 * Initializes the value for the {@link RemoteArtifactFactory#getConnectTimeout() connectTimeout} attribute.
	 *
	 * @param connectTimeout The value for connectTimeout
	 */
	public void setConnectTimeout(@Nullable Duration connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	@Nonnull
	@Override
	public Artifact create(@Nonnull Version version) {
		Objects.requireNonNull(version, "Version must not be null");
		Path directory = getDirectory();
		if (directory == null) {
			directory = FileUtils.getUserHomeDirectory();
		}
		UrlFactory urlFactory = getUrlFactory();
		if (urlFactory == null) {
			urlFactory = new DefaultUrlFactory();
		}
		return new RemoteArtifact(version, directory, urlFactory,
				getProxy(), getReadTimeout(), getConnectTimeout());
	}

}
