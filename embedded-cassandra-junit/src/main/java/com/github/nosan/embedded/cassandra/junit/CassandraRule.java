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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.github.nosan.embedded.cassandra.DataStaxCassandra;
import com.github.nosan.embedded.cassandra.configuration.BootstrapSettings;
import com.github.nosan.embedded.cassandra.cql.CqlScript;
import com.github.nosan.embedded.cassandra.cql.CqlScriptUtils;

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
public class CassandraRule extends DataStaxCassandra implements TestRule {

	@Nonnull
	private final CqlScript[] scripts;

	/**
	 * Create Apache Casandra with a default {@code BootstrapSettings} and {@code ClusterFactory}.
	 *
	 * @param scripts CQL scripts to execute
	 */
	public CassandraRule(@Nullable CqlScript... scripts) {
		this(null, null, scripts);
	}

	/**
	 * Create Apache Casandra with a custom {@code BootstrapSettings} and default {@code ClusterFactory}.
	 *
	 * @param settings Bootstrap Settings
	 * @param scripts CQL scripts to execute
	 * @see BootstrapSettings.Builder
	 */
	public CassandraRule(@Nullable BootstrapSettings settings, @Nullable CqlScript... scripts) {
		this(settings, null, scripts);
	}

	/**
	 * Create Apache Casandra with a custom {@code ClusterFactory} and default {@code BootstrapSettings}.
	 *
	 * @param clusterFactory Cluster Factory to create a {@code Cluster}
	 * @param scripts CQL scripts to execute
	 * @see ClusterFactory
	 */
	public CassandraRule(@Nullable ClusterFactory clusterFactory, @Nullable CqlScript... scripts) {
		this(null, clusterFactory, scripts);
	}

	/**
	 * Create Apache Casandra with a custom {@code BootstrapSettings} and {@code ClusterFactory}.
	 *
	 * @param settings Bootstrap Settings
	 * @param clusterFactory Cluster Factory to create a {@code Cluster}
	 * @param scripts CQL scripts to execute
	 * @see BootstrapSettings.Builder
	 * @see ClusterFactory
	 */
	public CassandraRule(@Nullable BootstrapSettings settings, @Nullable ClusterFactory clusterFactory,
			@Nullable CqlScript... scripts) {
		super(settings, clusterFactory);
		this.scripts = (scripts != null) ? scripts : new CqlScript[0];
	}


	@Override
	public Statement apply(Statement base, Description description) {
		CqlScript[] scripts = this.scripts;
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					start();
					if (scripts.length > 0) {
						CqlScriptUtils.execute(getSession(), scripts);
					}
					base.evaluate();
				}
				finally {
					stop();
				}
			}
		};
	}

}
