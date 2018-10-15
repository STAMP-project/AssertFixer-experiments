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

package com.github.nosan.embedded.cassandra.local;

import java.io.IOException;

import javax.annotation.Nonnull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.github.nosan.embedded.cassandra.Cassandra;
import com.github.nosan.embedded.cassandra.CassandraException;
import com.github.nosan.embedded.cassandra.Settings;
import com.github.nosan.embedded.cassandra.Version;
import com.github.nosan.embedded.cassandra.testutil.CassandraAssert;
import com.github.nosan.embedded.cassandra.testutil.CassandraRunner;
import com.github.nosan.embedded.cassandra.testutil.CauseMatcher;
import com.github.nosan.embedded.cassandra.testutil.Output;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Abstract test-class for {@link LocalCassandra}.
 *
 * @author Dmytro Nosan
 */
public abstract class AbstractLocalCassandraTests {

	public final LocalCassandraFactory factory;

	@Rule
	public ExpectedException throwable = ExpectedException.none();

	@Rule
	public Output output = new Output();


	AbstractLocalCassandraTests(@Nonnull Version version) {
		this.factory = new LocalCassandraFactoryBuilder()
				.setVersion(version)
				.build();
	}


	@Test
	public void several() {
		LocalCassandraFactory factory = this.factory;
		new CassandraRunner(factory).run((cassandraAssert) -> {
			cassandraAssert.hasNotFailed().bindTo(Settings::getPort);
			new CassandraRunner(factory).run(
					(cassandraAssert1) -> cassandraAssert1.hasNotFailed().bindTo(Settings::getPort));
		});
	}

	@Test
	public void noSettings() {
		this.throwable.expect(CassandraException.class);
		this.throwable.expectMessage("Please start it before calling this method");
		this.factory.create().getSettings();
	}


	@Test
	public void onlyRpc() {
		this.factory.setConfigurationFile(getClass().getResource("/cassandra-rpc.yaml"));
		new CassandraRunner(this.factory)
				.run((cassandraAssert) -> cassandraAssert.hasNotFailed().bindTo(Settings::getRpcPort)
						.doesNotBindTo(Settings::getPort));
	}

	@Test
	public void invalidConfiguration() {
		this.throwable.expect(CassandraException.class);
		this.throwable.expectCause(new CauseMatcher(IOException.class, "invalid_property"));
		this.factory.setConfigurationFile(getClass().getResource("/cassandra-invalid.yaml"));
		new CassandraRunner(this.factory).run(CassandraAssert::hasFailed);

	}


	@Test
	public void invalidConfigurationNoTransport() {
		this.throwable.expect(CassandraException.class);
		this.throwable.expectCause(new CauseMatcher(IOException.class, "invalid_property"));
		this.factory.setConfigurationFile(getClass().getResource("/cassandra-disabled-transport-invalid.yaml"));
		new CassandraRunner(this.factory).run(CassandraAssert::hasFailed);

	}

	@Test
	public void noTransport() {
		this.factory.setConfigurationFile(getClass().getResource("/cassandra-disabled-transport.yaml"));
		new CassandraRunner(this.factory)
				.run((cassandraAssert) -> cassandraAssert.hasNotFailed().doesNotBindTo(Settings::getPort)
						.doesNotBindTo(Settings::getRpcPort));
		assertThat(this.output.toString()).containsIgnoringCase("Not starting RPC");
		assertThat(this.output.toString()).containsIgnoringCase("Not starting native transport");
	}

	@Test
	public void restart() {
		this.factory.setConfigurationFile(getClass().getResource("/cassandra-static.yaml"));
		Cassandra cassandra = this.factory.create();
		cassandra.start();
		cassandra.stop();
		cassandra.start();
		cassandra.stop();
	}
}
