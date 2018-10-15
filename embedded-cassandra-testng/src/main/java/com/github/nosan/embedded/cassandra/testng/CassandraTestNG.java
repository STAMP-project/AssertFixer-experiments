/*
 * Copyright 2018-2018 the original author or authors.
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.github.nosan.embedded.cassandra.Cassandra;
import com.github.nosan.embedded.cassandra.CassandraException;
import com.github.nosan.embedded.cassandra.CassandraFactory;
import com.github.nosan.embedded.cassandra.cql.CqlScript;
import com.github.nosan.embedded.cassandra.local.LocalCassandraFactory;

/**
 * Base class to start Apache Cassandra.
 * <p>
 * The typical usage is:
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
public class CassandraTestNG {
	@Nonnull
	private final CqlScript[] scripts;

	@Nonnull
	private final Cassandra cassandra;

	/**
	 * Creates a {@code CassandraTestNG}.
	 *
	 * @param scripts CQL scripts to execute
	 */
	public CassandraTestNG(@Nullable CqlScript... scripts) {
		this(null, scripts);
	}

	/**
	 * Creates a {@code CassandraTestNG}.
	 *
	 * @param factory factory to create a {@link Cassandra}
	 * @param scripts CQL scripts to execute
	 */
	public CassandraTestNG(@Nullable CassandraFactory factory, @Nullable CqlScript... scripts) {
		this.cassandra = (factory != null) ? factory.create() : new LocalCassandraFactory().create();
		this.scripts = (scripts != null) ? scripts : new CqlScript[0];
	}

	@BeforeClass(alwaysRun = true)
	public void start() throws CassandraException {
		this.cassandra.start();
		if (this.scripts.length > 0) {
//			CqlScriptUtils.execute(getSession(), this.scripts);
		}
	}

	@AfterClass(alwaysRun = true)
	public void stop() throws CassandraException {
		this.cassandra.stop();
	}

}
