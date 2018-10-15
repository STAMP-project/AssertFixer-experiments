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

package com.github.nosan.embedded.cassandra.cql;

import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link UrlCqlScript}.
 *
 * @author Dmytro Nosan
 */
public class UrlCqlScriptTests {


	@Test
	public void getStatements() {
		UrlCqlScript urlCqlScript = new UrlCqlScript(ClassLoader.getSystemResource("roles.cql"));
		assertThat(urlCqlScript.getStatements())
				.containsExactly("CREATE TABLE IF NOT EXISTS test.roles (id text PRIMARY KEY)");
	}

	@Test
	public void helpers() {
		assertThat(new UrlCqlScript(ClassLoader.getSystemResource("roles.cql")))
				.isEqualTo(new UrlCqlScript(ClassLoader.getSystemResource("roles.cql")));
		assertThat(new UrlCqlScript(ClassLoader.getSystemResource("roles.cql")).toString())
				.contains("roles.cql");
	}

	@Test(expected = UncheckedIOException.class)
	public void invalidResource() throws MalformedURLException {
		new UrlCqlScript(new URL("http://localhost:111/hz.cql")).getStatements();
	}
}
