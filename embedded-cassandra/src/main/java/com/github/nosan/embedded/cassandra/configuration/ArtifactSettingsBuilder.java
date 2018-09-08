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
 * Simple implementation of {@link ArtifactSettings.Builder}.
 *
 * @author Dmytro Nosan
 */
final class ArtifactSettingsBuilder implements ArtifactSettings.Builder {

	private Path directory;

	private Duration connectTimeout;

	private Duration readTimeout;

	private Version version;

	private Proxy proxy;

	@Override
	public ArtifactSettings.Builder setDirectory(Path directory) {
		this.directory = directory;
		return this;
	}


	@Override
	public ArtifactSettings.Builder setConnectTimeout(Duration connectTimeout) {
		this.connectTimeout = connectTimeout;
		return this;
	}


	@Override
	public ArtifactSettings.Builder setReadTimeout(Duration readTimeout) {
		this.readTimeout = readTimeout;
		return this;
	}

	@Override
	public ArtifactSettings.Builder setVersion(Version version) {
		this.version = version;
		return this;
	}

	@Override
	public ArtifactSettings.Builder setProxy(Proxy proxy) {
		this.proxy = proxy;
		return this;
	}

	@Override
	public ArtifactSettings build() {
		return new ImmutableArtifactSettings(this);
	}

	/**
	 * Immutable implementation of {@link ArtifactSettings}.
	 */
	static final class ImmutableArtifactSettings implements ArtifactSettings {

		private final Path directory;

		private final Duration connectTimeout;

		private final Duration readTimeout;

		private final Version version;

		private final Proxy proxy;

		private ImmutableArtifactSettings(ArtifactSettingsBuilder builder) {
			this.directory = builder.directory;
			this.connectTimeout = builder.connectTimeout;
			this.readTimeout = builder.readTimeout;
			this.version = builder.version;
			this.proxy = builder.proxy;
		}


		@Override
		public Path getDirectory() {
			return this.directory;
		}

		@Override
		public Duration getConnectTimeout() {
			return this.connectTimeout;
		}

		@Override
		public Duration getReadTimeout() {
			return this.readTimeout;
		}

		@Override
		public Version getVersion() {
			return this.version;
		}

		@Override
		public Proxy getProxy() {
			return this.proxy;
		}

	}
}
