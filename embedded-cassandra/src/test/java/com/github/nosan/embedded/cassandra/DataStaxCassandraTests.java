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

package com.github.nosan.embedded.cassandra;

import org.junit.Test;

import com.github.nosan.embedded.cassandra.configuration.BootstrapSettings;

/**
 * Tests for {@link DataStaxCassandra}.
 *
 * @author Dmytro Nosan
 */
public class DataStaxCassandraTests {


	@Test
	public void shouldStartCorrectly() {
		configure(null)
				.run(cassandra -> {

				});

	}


	private CassandraRunner<DataStaxCassandra> configure(BootstrapSettings bootstrapSettings) {
		return new CassandraRunner<>(new DataStaxCassandra(bootstrapSettings));
	}


}
