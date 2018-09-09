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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Simple implementation of {@link ParameterizedClass.Builder}.
 *
 * @author Dmytro Nosan
 */
final class ParameterizedClassBuilder implements ParameterizedClass.Builder {

	@Nullable
	private String className;

	@Nullable
	private Map<String, String> parameters;

	@Nonnull
	@Override
	public ParameterizedClass.Builder setClassName(@Nullable String className) {
		this.className = className;
		return this;
	}

	@Nonnull
	@Override
	public ParameterizedClass.Builder putParameters(@Nonnull String key, @Nullable String value) {
		Objects.requireNonNull(key, "Key must not be null");
		if (this.parameters == null) {
			this.parameters = new HashMap<>();
		}
		this.parameters.put(key, value);
		return this;
	}

	@Nonnull
	@Override
	public ParameterizedClass.Builder setParameters(@Nullable Map<String, String> parameters) {
		this.parameters = parameters;
		return this;
	}

	@Nonnull
	@Override
	public ParameterizedClass.Builder putParameters(@Nullable Map<String, String> parameters) {
		if (parameters == null) {
			return this;
		}
		if (this.parameters == null) {
			this.parameters = parameters;
		}
		else {
			this.parameters.putAll(parameters);
		}
		return this;
	}

	@Nonnull
	@Override
	public ParameterizedClass build() {
		return new ImmutableParameterizedClass(this);
	}

	/**
	 * Immutable implementation of {@link ParameterizedClass}.
	 */
	private static final class ImmutableParameterizedClass
			implements ParameterizedClass {
		@Nullable
		private final String className;

		@Nullable
		private final Map<String, String> parameters;

		private ImmutableParameterizedClass(@Nonnull ParameterizedClassBuilder builder) {
			this.className = builder.className;
			this.parameters = (builder.parameters != null) ? Collections.unmodifiableMap(builder.parameters) : null;
		}

		@Nullable
		@Override
		public String getClassName() {
			return this.className;
		}

		@Nullable
		@Override
		public Map<String, String> getParameters() {
			return this.parameters;
		}
	}
}
