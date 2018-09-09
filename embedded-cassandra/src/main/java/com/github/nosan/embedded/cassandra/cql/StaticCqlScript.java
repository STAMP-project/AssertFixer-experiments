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

package com.github.nosan.embedded.cassandra.cql;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

/**
 * {@link CqlScript} implementation for a given CQL statements.
 *
 * @author Dmytro Nosan
 */
public class StaticCqlScript implements CqlScript {

	@Nonnull
	private final List<String> statements;

	public StaticCqlScript(@Nonnull String... statements) {
		this.statements = Collections.unmodifiableList(Arrays.asList(Objects.requireNonNull(statements, "Statements " +
				"must not be null")));
	}

	@Nonnull
	@Override
	public Collection<String> getStatements() {
		return this.statements;
	}

	@Override
	public String toString() {
		return "Script: 'Static CQL Statements'";
	}
}
