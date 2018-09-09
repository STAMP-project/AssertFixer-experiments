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

package com.github.nosan.embedded.cassandra.junit;

import javax.annotation.Nullable;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.github.nosan.embedded.cassandra.EmbeddedCassandra;
import com.github.nosan.embedded.cassandra.configuration.BootstrapSettings;
import com.github.nosan.embedded.cassandra.cql.CqlScript;

/**
 * JUnit {@link TestRule TestRule} to start Apache Cassandra. <pre>
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
public class CassandraRule extends EmbeddedCassandra implements TestRule {
	/**
	 * Create Apache Casandra with a custom {@code BootstrapSettings}.
	 *
	 * @param settings Bootstrap Settings
	 * @param scripts CQL scripts to execute
	 * @see BootstrapSettings.Builder
	 */
	public CassandraRule(@Nullable BootstrapSettings settings, @Nullable CqlScript... scripts) {
		super(settings, scripts);
	}

	/**
	 * Create Apache Casandra with a default {@code BootstrapSettings}.
	 *
	 * @param scripts CQL scripts to execute
	 */
	public CassandraRule(@Nullable CqlScript... scripts) {
		super(scripts);
	}


	@Override
	public Statement apply(Statement base, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					start();
					base.evaluate();
				}
				finally {
					stop();
				}
			}
		};
	}

}
