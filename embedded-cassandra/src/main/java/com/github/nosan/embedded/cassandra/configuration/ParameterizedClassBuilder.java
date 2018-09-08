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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Simple implementation of {@link ParameterizedClass.Builder}.
 *
 * @author Dmytro Nosan
 */
final class ParameterizedClassBuilder implements ParameterizedClass.Builder {

	private String className;

	private Map<String, String> parameters = new LinkedHashMap<>();

	@Override
	public ParameterizedClass.Builder setClassName(String className) {
		this.className = className;
		return this;
	}

	@Override
	public ParameterizedClass.Builder putParameters(String key, String value) {
		this.parameters.put(
				Objects.requireNonNull(key, "parameters key"),
				Objects.requireNonNull(value, "parameters value"));
		return this;
	}


	@Override
	public ParameterizedClass.Builder setParameters(
			Map<String, ? extends String> entries) {
		this.parameters.clear();
		return putParameters(entries);
	}

	@Override
	public ParameterizedClass.Builder putParameters(
			Map<String, ? extends String> entries) {
		for (Map.Entry<String, ? extends String> e : entries.entrySet()) {
			String k = e.getKey();
			String v = e.getValue();
			this.parameters.put(
					Objects.requireNonNull(k, "parameters key"),
					Objects.requireNonNull(v, "parameters value"));
		}
		return this;
	}


	@Override
	public ParameterizedClass build() {
		return new ImmutableParameterizedClass(this);
	}

	/**
	 * Immutable implementation of {@link ParameterizedClass}.
	 */
	static final class ImmutableParameterizedClass
			implements ParameterizedClass {
		private final String className;

		private final Map<String, String> parameters;

		private ImmutableParameterizedClass(ParameterizedClassBuilder builder) {
			this.className = builder.className;
			this.parameters = Collections.unmodifiableMap(builder.parameters);
		}

		@Override
		public String getClassName() {
			return this.className;
		}

		@Override
		public Map<String, String> getParameters() {
			return this.parameters;
		}
	}
}
