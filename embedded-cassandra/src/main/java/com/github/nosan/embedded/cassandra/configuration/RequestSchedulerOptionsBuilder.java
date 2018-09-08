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
 * Simple implementation of {@link RequestSchedulerOptions.Builder}.
 *
 * @author Dmytro Nosan
 */
final class RequestSchedulerOptionsBuilder implements RequestSchedulerOptions.Builder {

	private Integer throttleLimit;

	private Integer defaultWeight;

	private Map<String, Integer> weights = new LinkedHashMap<>();

	@Override
	public RequestSchedulerOptions.Builder setThrottleLimit(Integer throttleLimit) {
		this.throttleLimit = throttleLimit;
		return this;
	}

	@Override
	public RequestSchedulerOptions.Builder setDefaultWeight(Integer defaultWeight) {
		this.defaultWeight = defaultWeight;
		return this;
	}

	@Override
	public RequestSchedulerOptions.Builder putWeights(String key, Integer value) {
		this.weights.put(
				Objects.requireNonNull(key, "weights key"),
				Objects.requireNonNull(value, "weights value"));
		return this;
	}


	@Override
	public RequestSchedulerOptions.Builder setWeights(
			Map<String, ? extends Integer> entries) {
		this.weights.clear();
		return putWeights(entries);
	}

	@Override
	public RequestSchedulerOptions.Builder putWeights(
			Map<String, ? extends Integer> entries) {
		for (Map.Entry<String, ? extends Integer> e : entries.entrySet()) {
			String k = e.getKey();
			Integer v = e.getValue();
			this.weights.put(
					Objects.requireNonNull(k, "weights key"),
					Objects.requireNonNull(v, "weights value"));
		}
		return this;
	}

	@Override
	public RequestSchedulerOptions build() {
		return new ImmutableRequestSchedulerOptions(this);
	}

	/**
	 * Immutable implementation of {@link RequestSchedulerOptions}.
	 */
	static final class ImmutableRequestSchedulerOptions
			implements RequestSchedulerOptions {
		private final Integer throttleLimit;

		private final Integer defaultWeight;

		private final Map<String, Integer> weights;

		private ImmutableRequestSchedulerOptions(RequestSchedulerOptionsBuilder builder) {
			this.throttleLimit = builder.throttleLimit;
			this.defaultWeight = builder.defaultWeight;
			this.weights = Collections.unmodifiableMap(builder.weights);
		}

		@Override
		public Integer getThrottleLimit() {
			return this.throttleLimit;
		}


		@Override
		public Integer getDefaultWeight() {
			return this.defaultWeight;
		}


		@Override
		public Map<String, Integer> getWeights() {
			return this.weights;
		}
	}
}
