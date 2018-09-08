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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Simple implementation of {@link BootstrapSettings.Builder}.
 *
 * @author Dmytro Nosan
 */
final class BootstrapSettingsBuilder implements BootstrapSettings.Builder {

	private Duration timeout;

	private List<String> arguments = new ArrayList<>();

	private Config config;

	private Path workingDirectory;

	private ArtifactSettings artifactSettings;


	@Override
	public BootstrapSettings.Builder setTimeout(Duration timeout) {
		this.timeout = timeout;
		return this;
	}


	@Override
	public BootstrapSettings.Builder addArguments(String element) {
		this.arguments.add(element);
		return this;
	}


	@Override
	public BootstrapSettings.Builder addArguments(String... elements) {
		addArguments(Arrays.asList(elements));
		return this;
	}


	@Override
	public BootstrapSettings.Builder setArguments(Iterable<String> elements) {
		this.arguments.clear();
		return addArguments(elements);
	}

	@Override
	public BootstrapSettings.Builder addArguments(Iterable<String> elements) {
		for (String element : elements) {
			this.arguments.add(element);
		}
		return this;
	}

	@Override
	public BootstrapSettings.Builder setConfig(Config config) {
		this.config = config;
		return this;
	}


	@Override
	public BootstrapSettings.Builder setWorkingDirectory(Path workingDirectory) {
		this.workingDirectory = workingDirectory;
		return this;
	}


	@Override
	public BootstrapSettings.Builder setArtifactSettings(
			ArtifactSettings artifactSettings) {
		this.artifactSettings = artifactSettings;
		return this;
	}


	@Override
	public BootstrapSettings build() {
		return new ImmutableBootstrapSettings(this);
	}

	/**
	 * Immutable implementation of {@link BootstrapSettings}.
	 */
	static final class ImmutableBootstrapSettings implements BootstrapSettings {

		private final Duration timeout;

		private final List<String> jvmOptions;

		private final Config config;

		private final Path workingDirectory;

		private final ArtifactSettings artifactSettings;

		private ImmutableBootstrapSettings(BootstrapSettingsBuilder builder) {
			this.timeout = builder.timeout;
			this.jvmOptions = Collections.unmodifiableList(builder.arguments);
			this.config = builder.config;
			this.workingDirectory = builder.workingDirectory;
			this.artifactSettings = builder.artifactSettings;
		}


		@Override
		public Duration getTimeout() {
			return this.timeout;
		}

		@Override
		public List<String> getArguments() {
			return this.jvmOptions;
		}

		@Override
		public Config getConfig() {
			return this.config;
		}


		@Override
		public Path getWorkingDirectory() {
			return this.workingDirectory;
		}

		@Override
		public ArtifactSettings getArtifactSettings() {
			return this.artifactSettings;
		}
	}
}
