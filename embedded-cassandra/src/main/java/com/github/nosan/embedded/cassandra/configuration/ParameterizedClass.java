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

/**
 * Simple Holder for complex properties.
 *
 * @author Dmytro Nosan
 */

public interface ParameterizedClass {

	String getClassName();

	Map<String, String> getParameters();

	static Builder builder() {
		return new ParameterizedClassBuilder();
	}

	/**
	 * Builds instances of type {@link ParameterizedClass ParameterizedClass}. Initialize attributes and then invoke the
	 * {@link #build()} method to create an instance.
	 * <p><em>{@code ParameterizedClassBuilder} is not thread-safe and generally should not be stored in a field or
	 * collection, but instead used immediately to create instances.</em>
	 *
	 * @author Dmytro Nosan
	 */
	interface Builder {

		/**
		 * Initializes the value for the {@link ParameterizedClass#getClassName() className} attribute.
		 *
		 * @param className The value for className (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setClassName(String className);

		/**
		 * Put one entry to the {@link ParameterizedClass#getParameters() parameters} map.
		 *
		 * @param key The key in the parameters map
		 * @param value The associated value in the parameters map
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder putParameters(String key, String value);

		/**
		 * Sets or replaces all mappings from the specified map as entries for the {@link
		 * ParameterizedClass#getParameters() parameters} map.
		 *
		 * @param entries The entries that will be added to the parameters map
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setParameters(Map<String, ? extends String> entries);

		/**
		 * Put all mappings from the specified map as entries to {@link ParameterizedClass#getParameters() parameters}
		 * map.
		 *
		 * @param entries The entries that will be added to the parameters map
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder putParameters(Map<String, ? extends String> entries);

		/**
		 * Builds a new {@link ParameterizedClass ParameterizedClass}.
		 *
		 * @return An instance of ParameterizedClass
		 */
		ParameterizedClass build();
	}
}
