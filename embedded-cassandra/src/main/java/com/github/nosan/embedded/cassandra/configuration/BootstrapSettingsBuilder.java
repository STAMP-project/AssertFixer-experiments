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
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

/**
 * Simple implementation of {@link BootstrapSettings.Builder}.
 *
 * @author Dmytro Nosan
 */
final class BootstrapSettingsBuilder implements BootstrapSettings.Builder {

	@Nonnull
	private final List<String> arguments = new ArrayList<>();

	@Nonnull
	private Duration timeout = Duration.ofMinutes(1);

	@Nonnull
	private Config config = Config.builder().build();

	@Nonnull
	private Path workingDirectory = Paths.get(System
			.getProperty("java.io.tmpdir"));

	@Nonnull
	private ArtifactSettings artifactSettings = ArtifactSettings.builder().build();

	@Nonnull
	@Override
	public BootstrapSettings.Builder setTimeout(@Nonnull Duration timeout) {
		this.timeout = Objects.requireNonNull(timeout, "Timeout must not be null");
		return this;
	}

	@Nonnull
	@Override
	public BootstrapSettings.Builder addArguments(@Nonnull String... arguments) {
		Objects.requireNonNull(arguments, "Arguments must not be null");
		addArguments(Arrays.asList(arguments));
		return this;
	}

	@Nonnull
	@Override
	public BootstrapSettings.Builder setArguments(@Nonnull Collection<String> arguments) {
		Objects.requireNonNull(arguments, "Arguments must not be null");
		this.arguments.clear();
		return addArguments(arguments);
	}

	@Nonnull
	@Override
	public BootstrapSettings.Builder addArguments(@Nonnull Collection<String> arguments) {
		Objects.requireNonNull(arguments, "Arguments must not be null");
		this.arguments.addAll(arguments);
		return this;
	}

	@Nonnull
	@Override
	public BootstrapSettings.Builder setConfig(@Nonnull Config config) {
		this.config = Objects.requireNonNull(config, "Config must not be null");
		return this;
	}

	@Nonnull
	@Override
	public BootstrapSettings.Builder setWorkingDirectory(@Nonnull Path workingDirectory) {
		this.workingDirectory = Objects.requireNonNull(workingDirectory, "Working Directory must not be null");
		return this;
	}

	@Nonnull
	@Override
	public BootstrapSettings.Builder setArtifactSettings(@Nonnull ArtifactSettings artifactSettings) {
		this.artifactSettings = Objects.requireNonNull(artifactSettings, "Artifact Settings must not be null");
		return this;
	}

	@Nonnull
	@Override
	public BootstrapSettings build() {
		return new ImmutableBootstrapSettings(this);
	}

	/**
	 * Immutable implementation of {@link BootstrapSettings}.
	 */
	private static final class ImmutableBootstrapSettings implements BootstrapSettings {

		@Nonnull
		private final Duration timeout;

		@Nonnull
		private final List<String> arguments;

		@Nonnull
		private final Config config;

		@Nonnull
		private final Path workingDirectory;

		@Nonnull
		private final ArtifactSettings artifactSettings;

		private ImmutableBootstrapSettings(@Nonnull BootstrapSettingsBuilder builder) {
			this.timeout = builder.timeout;
			this.arguments = Collections.unmodifiableList(builder.arguments);
			this.config = builder.config;
			this.workingDirectory = builder.workingDirectory;
			this.artifactSettings = builder.artifactSettings;
		}

		@Nonnull
		@Override
		public Duration getTimeout() {
			return this.timeout;
		}

		@Nonnull
		@Override
		public List<String> getArguments() {
			return this.arguments;
		}

		@Nonnull
		@Override
		public Config getConfig() {
			return this.config;
		}

		@Nonnull
		@Override
		public Path getWorkingDirectory() {
			return this.workingDirectory;
		}

		@Nonnull
		@Override
		public ArtifactSettings getArtifactSettings() {
			return this.artifactSettings;
		}
	}
}
