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

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Contains a list of properties that define configuration options fo RequestScheduler.
 *
 * @author Dmytro Nosan
 */
public interface RequestSchedulerOptions {

	/**
	 * The number of in-flight requests per client. Requests beyond this limit are queued up until running requests
	 * complete.
	 *
	 * @return @return The value of the {@code throttleLimit} attribute
	 */
	@Nullable
	Integer getThrottleLimit();

	/**
	 * How many requests are handled during each turn of the RoundRobin.
	 *
	 * @return The value of the {@code defaultWeight} attribute
	 */
	@Nullable
	Integer getDefaultWeight();

	/**
	 * Takes a list of keyspaces. It sets how many requests are handled during each turn of the RoundRobin, based on the
	 * request_scheduler_id.
	 *
	 * @return The value of the {@code weights} attribute
	 */
	@Nullable
	Map<String, Integer> getWeights();

	/**
	 * Create a new builder to build a {@link RequestSchedulerOptions}.
	 *
	 * @return a fresh {@code Builder}.
	 */
	@Nonnull
	static Builder builder() {
		return new RequestSchedulerOptionsBuilder();
	}

	/**
	 * Builds instances of type {@link RequestSchedulerOptions RequestSchedulerOptions}. Initialize attributes and then
	 * invoke the {@link #build()} method to create an instance.
	 * <p><em>{@code RequestSchedulerOptionsBuilder} is not thread-safe and generally should not be stored in a field
	 * or
	 * collection, but instead used immediately to create instances.</em>
	 *
	 * @author Dmytro Nosan
	 */
	interface Builder {

		/**
		 * Initializes the value for the {@link RequestSchedulerOptions#getThrottleLimit() throttleLimit} attribute.
		 *
		 * @param throttleLimit The value for throttleLimit
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setThrottleLimit(@Nullable Integer throttleLimit);

		/**
		 * Initializes the value for the {@link RequestSchedulerOptions#getDefaultWeight() defaultWeight} attribute.
		 *
		 * @param defaultWeight The value for defaultWeight
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setDefaultWeight(@Nullable Integer defaultWeight);

		/**
		 * Put one entry to the {@link RequestSchedulerOptions#getWeights() weights} map.
		 *
		 * @param key The key in the weights map
		 * @param value The associated value in the weights map
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder putWeights(@Nonnull String key, @Nullable Integer value);

		/**
		 * Sets or replaces all mappings from the specified map as entries for the {@link
		 * RequestSchedulerOptions#getWeights() weights} map.
		 *
		 * @param weights The weights that will be added to the weights map
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setWeights(@Nullable Map<String, Integer> weights);

		/**
		 * Put all mappings from the specified map as entries to {@link RequestSchedulerOptions#getWeights() weights}
		 * map.
		 *
		 * @param weights The weights that will be added to the weights map
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder putWeights(@Nullable Map<String, Integer> weights);

		/**
		 * Builds a new {@link RequestSchedulerOptions RequestSchedulerOptions}.
		 *
		 * @return An  instance of RequestSchedulerOptions
		 */
		@Nonnull
		RequestSchedulerOptions build();
	}
}
