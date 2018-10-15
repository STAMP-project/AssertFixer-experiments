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

package com.github.nosan.embedded.cassandra.testutil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.github.nosan.embedded.cassandra.Cassandra;
import com.github.nosan.embedded.cassandra.CassandraException;
import com.github.nosan.embedded.cassandra.CassandraFactory;
import com.github.nosan.embedded.cassandra.Settings;
import com.github.nosan.embedded.cassandra.cql.CqlScript;
import com.github.nosan.embedded.cassandra.local.LocalCassandraFactory;

/**
 * JUnit {@link TestRule TestRule} to start Apache Cassandra.
 * <p>
 * The typical usage is:
 * <pre>
 * public class CassandraRuleTests {
 * &#64;ClassRule
 * public static CassandraRule cassandra = new CassandraRule();
 * &#64;Test
 * public void select() {
 * assertThat(cassandra.getSession().execute(...).wasApplied())
 * .isTrue();
 * }
 * }
 * </pre>
 *
 * @author Dmytro Nosan
 */
public class CassandraRule implements TestRule {

	@Nonnull
	private final CqlScript[] scripts;

	@Nonnull
	private final Cassandra cassandra;

	/**
	 * Creates a {@code CassandraRule}.
	 *
	 * @param scripts CQL scripts to execute
	 */
	public CassandraRule(@Nullable CqlScript... scripts) {
		this(null, scripts);
	}

	/**
	 * Creates a {@code CassandraRule}.
	 *
	 * @param factory factory to create a {@link Cassandra}
	 * @param scripts CQL scripts to execute
	 */
	public CassandraRule(@Nullable CassandraFactory factory, @Nullable CqlScript... scripts) {
		this.cassandra = (factory != null) ? factory.create() : new LocalCassandraFactory().create();
		this.scripts = (scripts != null) ? scripts : new CqlScript[0];
	}

	@Override
	public Statement apply(Statement base, Description description) {
		CqlScript[] scripts = this.scripts;
		Cassandra cassandra = this.cassandra;
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					cassandra.start();
					base.evaluate();
				}
				finally {
					cassandra.stop();
				}
			}
		};
	}


	/**
	 * Returns the settings this Cassandra is running on.
	 *
	 * @return the settings
	 * @throws CassandraException if Cassandra has not been started
	 */
	@Nonnull
	public Settings getSettings() {
		return this.cassandra.getSettings();
	}


}
