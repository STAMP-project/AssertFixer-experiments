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
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * Simple implementation of {@link ArtifactSettings.Builder}.
 *
 * @author Dmytro Nosan
 */
final class ArtifactSettingsBuilder implements ArtifactSettings.Builder {

	@Nonnull
	private Path directory = Paths.get(System.getProperty("user.home"));

	@Nullable
	private Duration connectTimeout = Duration.ofSeconds(30);

	@Nullable
	private Duration readTimeout = Duration.ofSeconds(30);

	@Nonnull
	private Version version = Version.LATEST;

	@Nullable
	private Proxy proxy;

	@Nonnull
	@Override
	public ArtifactSettings.Builder setDirectory(@Nonnull Path directory) {
		this.directory = Objects.requireNonNull(directory, "Directory must not be null");
		return this;
	}

	@Nonnull
	@Override
	public ArtifactSettings.Builder setConnectTimeout(@Nullable Duration connectTimeout) {
		this.connectTimeout = connectTimeout;
		return this;
	}

	@Nonnull
	@Override
	public ArtifactSettings.Builder setReadTimeout(@Nullable Duration readTimeout) {
		this.readTimeout = readTimeout;
		return this;
	}

	@Nonnull
	@Override
	public ArtifactSettings.Builder setVersion(@Nonnull Version version) {
		this.version = Objects.requireNonNull(version, "Version must not be null");
		return this;
	}

	@Nonnull
	@Override
	public ArtifactSettings.Builder setProxy(@Nullable Proxy proxy) {
		this.proxy = proxy;
		return this;
	}

	@Nonnull
	@Override
	public ArtifactSettings build() {
		return new ImmutableArtifactSettings(this);
	}

	/**
	 * Immutable implementation of {@link ArtifactSettings}.
	 */
	private static final class ImmutableArtifactSettings implements ArtifactSettings {

		@Nonnull
		private final Path directory;

		@Nullable
		private final Duration connectTimeout;

		@Nullable
		private final Duration readTimeout;

		@Nonnull
		private final Version version;

		@Nullable
		private final Proxy proxy;

		private ImmutableArtifactSettings(@Nonnull ArtifactSettingsBuilder builder) {
			this.directory = builder.directory;
			this.connectTimeout = builder.connectTimeout;
			this.readTimeout = builder.readTimeout;
			this.version = builder.version;
			this.proxy = builder.proxy;
		}

		@Nonnull
		@Override
		public Path getDirectory() {
			return this.directory;
		}

		@Nullable
		@Override
		public Duration getConnectTimeout() {
			return this.connectTimeout;
		}

		@Nullable
		@Override
		public Duration getReadTimeout() {
			return this.readTimeout;
		}

		@Nonnull
		@Override
		public Version getVersion() {
			return this.version;
		}

		@Nullable
		@Override
		public Proxy getProxy() {
			return this.proxy;
		}

	}
}
