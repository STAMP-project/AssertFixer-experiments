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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * {@link CqlScript} implementation for a given CQL {@code statements}.
 *
 * @author Dmytro Nosan
 * @since 1.0.0
 */
public final class StaticCqlScript implements CqlScript {

	@Nonnull
	private final List<String> statements;

	/**
	 * Create a new StaticCqlScript based on statements.
	 *
	 * @param statements CQL statements
	 */
	public StaticCqlScript(@Nullable String... statements) {
		this.statements = Collections.unmodifiableList((statements != null) ? Arrays.asList(statements) :
				Collections.emptyList());
	}

	/**
	 * Create a new StaticCqlScript based on statements.
	 *
	 * @param statements CQL statements
	 */
	public StaticCqlScript(@Nullable Collection<String> statements) {
		this.statements = Collections.unmodifiableList(new ArrayList<>((statements != null) ? statements :
				Collections.emptyList()));
	}

	@Nonnull
	@Override
	public Collection<String> getStatements() {
		return this.statements;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.statements);
	}

	@Override
	public boolean equals(@Nullable Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		StaticCqlScript that = (StaticCqlScript) other;
		return Objects.equals(this.statements, that.statements);
	}

	@Override
	@Nonnull
	public String toString() {
		return String.format("Static CQL Statements (%s)", this.statements.size());
	}
}
