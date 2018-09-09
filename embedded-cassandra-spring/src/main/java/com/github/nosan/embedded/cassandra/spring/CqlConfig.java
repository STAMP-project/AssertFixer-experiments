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

package com.github.nosan.embedded.cassandra.spring;

import javax.annotation.Nullable;

/**
 * {@code CqlConfig} encapsulates the
 * attributes declared via {@link EmbeddedCassandra} or {@link Cql}.
 *
 * @author Dmytro Nosan
 */
class CqlConfig {

	@Nullable
	private Class<?> testClass;

	@Nullable
	private String[] scripts;

	@Nullable
	private String[] statements;

	@Nullable
	private String encoding;

	@Nullable
	public Class<?> getTestClass() {
		return this.testClass;
	}

	void setTestClass(@Nullable Class<?> testClass) {
		this.testClass = testClass;
	}

	@Nullable
	String[] getScripts() {
		return this.scripts;
	}

	void setScripts(@Nullable String[] scripts) {
		this.scripts = scripts;
	}

	@Nullable
	String[] getStatements() {
		return this.statements;
	}

	void setStatements(@Nullable String[] statements) {
		this.statements = statements;
	}

	@Nullable
	String getEncoding() {
		return this.encoding;
	}

	void setEncoding(@Nullable String encoding) {
		this.encoding = encoding;
	}
}
