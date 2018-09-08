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

package com.github.nosan.embedded.cassandra.jupiter;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.RegisterExtension;

import com.github.nosan.embedded.cassandra.EmbeddedCassandra;
import com.github.nosan.embedded.cassandra.configuration.BootstrapSettings;
import com.github.nosan.embedded.cassandra.cql.CqlScript;

/**
 * JUnit {@link RegisterExtension RegisterExtension} to start Apache Cassandra.
 * <pre>
 * public class CassandraExtensionTests {
 * &#64;RegisterExtension
 * public static CassandraExtension cassandra = new CassandraExtension();
 * &#64;Test
 *      public void select() {
 *              assertThat(cassandra.getSession().execute(...).wasApplied())
 *               .isTrue();
 *      }
 * }
 * </pre>
 *
 * @author Dmytro Nosan
 */
public class CassandraExtension extends EmbeddedCassandra
		implements BeforeAllCallback, AfterAllCallback {


	/**
	 * Create Apache Casandra with a custom {@code BootstrapSettings}.
	 *
	 * @param settings Bootstrap Settings (can be {@code null})
	 * @param scripts CQL scripts to execute (can be {@code null})
	 * @see BootstrapSettings.Builder
	 */
	public CassandraExtension(BootstrapSettings settings, CqlScript... scripts) {
		super(settings, scripts);
	}

	/**
	 * Create Apache Casandra with a default {@code BootstrapSettings}.
	 *
	 * @param scripts CQL scripts to execute (can be {@code null})
	 */
	public CassandraExtension(CqlScript... scripts) {
		super(scripts);
	}

	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		start();
	}

	@Override
	public void afterAll(ExtensionContext context) throws Exception {
		stop();
	}

}
