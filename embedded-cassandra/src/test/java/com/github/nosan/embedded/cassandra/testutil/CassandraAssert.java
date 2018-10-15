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

import java.io.IOException;
import java.net.Socket;
import java.util.Objects;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.error.BasicErrorMessageFactory;

import com.github.nosan.embedded.cassandra.Cassandra;
import com.github.nosan.embedded.cassandra.Settings;

/**
 * {@link AbstractAssert} for Cassandra.
 *
 * @author Dmytro Nosan
 */
public final class CassandraAssert extends AbstractAssert<CassandraAssert, Cassandra> {

	@Nullable
	private final Throwable throwable;

	CassandraAssert(@Nonnull Cassandra cassandra, @Nullable Throwable throwable) {
		super(Objects.requireNonNull(cassandra), CassandraAssert.class);
		this.throwable = throwable;
	}


	/**
	 * Does port bind to.
	 *
	 * @param mapper port function
	 * @return this instance
	 */
	public CassandraAssert bindTo(@Nonnull Function<Settings, Integer> mapper) {
		Settings settings = this.actual.getSettings();
		Integer port = mapper.apply(settings);
		try (Socket socket = new Socket(settings.getAddress(), port)) {
			return this;
		}
		catch (IOException ignore) {
			throwAssertionError(new BasicErrorMessageFactory("(%s) is not a busy.", port));
		}
		return this;
	}

	/**
	 * Does not port bind to.
	 *
	 * @param mapper port function
	 * @return this instance
	 */
	public CassandraAssert doesNotBindTo(@Nonnull Function<Settings, Integer> mapper) {
		Settings settings = this.actual.getSettings();
		Integer port = mapper.apply(settings);
		try (Socket socket = new Socket(settings.getAddress(), port)) {
			throwAssertionError(new BasicErrorMessageFactory("(%s) is a busy.", port));
		}
		catch (IOException ignore) {
			return this;
		}
		return this;
	}

	/**
	 * Check cassandra has failed or not.
	 *
	 * @return this instance
	 */
	public CassandraAssert hasFailed() {
		if (this.throwable == null) {
			throwAssertionError(new BasicErrorMessageFactory("Cassandra has been started correctly."));
		}
		return this;
	}

	/**
	 * Check cassandra has started or not.
	 *
	 * @return this instance
	 */
	public CassandraAssert hasNotFailed() {
		if (this.throwable != null) {
			throwAssertionError(new BasicErrorMessageFactory("Cassandra has failed (%s) - (%s)", this.throwable,
					this.throwable.getCause()));
		}
		return this;
	}


}
