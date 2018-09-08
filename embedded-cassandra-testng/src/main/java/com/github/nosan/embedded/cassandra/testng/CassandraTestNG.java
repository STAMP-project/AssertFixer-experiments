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

package com.github.nosan.embedded.cassandra.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.github.nosan.embedded.cassandra.CassandraException;
import com.github.nosan.embedded.cassandra.EmbeddedCassandra;
import com.github.nosan.embedded.cassandra.configuration.BootstrapSettings;
import com.github.nosan.embedded.cassandra.cql.CqlScript;

/**
 * Base class to start Apache Cassandra.
 * <pre>
 * public class CassandraTestNGTests extends CassandraTestNG {
 * &#64;Test
 * public void select() {
 * assertThat(getSession().execute(...).wasApplied())
 * .isTrue();
 * }
 * }
 * </pre>
 *
 * @author Dmytro Nosan
 */
public class CassandraTestNG extends EmbeddedCassandra {
	/**
	 * Create Apache Casandra with a custom {@code BootstrapSettings}.
	 *
	 * @param settings Bootstrap Settings (can be {@code null})
	 * @param scripts CQL scripts to execute (can be {@code null})
	 * @see BootstrapSettings.Builder
	 */
	public CassandraTestNG(BootstrapSettings settings, CqlScript... scripts) {
		super(settings, scripts);
	}

	/**
	 * Create Apache Casandra with a default {@code BootstrapSettings}.
	 *
	 * @param scripts CQL scripts to execute (can be {@code null})
	 */
	public CassandraTestNG(CqlScript... scripts) {
		super(scripts);
	}


	@Override
	@BeforeClass(alwaysRun = true)
	public void start() throws CassandraException {
		super.start();
	}

	@Override
	@AfterClass(alwaysRun = true)
	public void stop() throws CassandraException {
		super.stop();
	}

}
