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
 * Simple implementation of {@link RequestSchedulerOptions.Builder}.
 *
 * @author Dmytro Nosan
 */
final class RequestSchedulerOptionsBuilder implements RequestSchedulerOptions.Builder {
	@Nullable
	private Integer throttleLimit;

	@Nullable
	private Integer defaultWeight;

	@Nullable
	private Map<String, Integer> weights;

	@Nonnull
	@Override
	public RequestSchedulerOptions.Builder setThrottleLimit(@Nullable Integer throttleLimit) {
		this.throttleLimit = throttleLimit;
		return this;
	}

	@Nonnull
	@Override
	public RequestSchedulerOptions.Builder setDefaultWeight(@Nullable Integer defaultWeight) {
		this.defaultWeight = defaultWeight;
		return this;
	}

	@Nonnull
	@Override
	public RequestSchedulerOptions.Builder putWeights(@Nonnull String key, @Nullable Integer value) {
		Objects.requireNonNull(key, "Key must not be null");
		if (this.weights == null) {
			this.weights = new HashMap<>();
		}
		this.weights.put(key, value);
		return this;
	}

	@Nonnull
	@Override
	public RequestSchedulerOptions.Builder setWeights(@Nullable Map<String, Integer> weights) {
		this.weights = weights;
		return this;
	}

	@Nonnull
	@Override
	public RequestSchedulerOptions.Builder putWeights(@Nullable Map<String, Integer> weights) {
		if (weights == null) {
			return this;
		}
		if (this.weights == null) {
			this.weights = weights;
		}
		else {
			this.weights.putAll(weights);
		}
		return this;
	}

	@Nonnull
	@Override
	public RequestSchedulerOptions build() {
		return new ImmutableRequestSchedulerOptions(this);
	}

	/**
	 * Immutable implementation of {@link RequestSchedulerOptions}.
	 */
	private static final class ImmutableRequestSchedulerOptions
			implements RequestSchedulerOptions {

		@Nullable
		private final Integer throttleLimit;

		@Nullable
		private final Integer defaultWeight;

		@Nullable
		private final Map<String, Integer> weights;

		private ImmutableRequestSchedulerOptions(@Nonnull RequestSchedulerOptionsBuilder builder) {
			this.throttleLimit = builder.throttleLimit;
			this.defaultWeight = builder.defaultWeight;
			this.weights = (builder.weights != null) ? Collections.unmodifiableMap(builder.weights) : null;
		}

		@Nullable
		@Override
		public Integer getThrottleLimit() {
			return this.throttleLimit;
		}

		@Nullable
		@Override
		public Integer getDefaultWeight() {
			return this.defaultWeight;
		}

		@Nullable
		@Override
		public Map<String, Integer> getWeights() {
			return this.weights;
		}
	}
}
