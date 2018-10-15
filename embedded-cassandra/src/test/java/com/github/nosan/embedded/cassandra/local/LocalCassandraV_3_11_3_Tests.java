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

import org.junit.Test;

import com.github.nosan.embedded.cassandra.Version;
import com.github.nosan.embedded.cassandra.testutil.CassandraAssert;
import com.github.nosan.embedded.cassandra.testutil.CassandraRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Tests for {@link LocalCassandra}.
 *
 * @author Dmytro Nosan
 */
public class LocalCassandraV_3_11_3_Tests extends AbstractLocalCassandraTests {
	public LocalCassandraV_3_11_3_Tests() {
		super(new Version(3, 11, 3));
	}

	@Test
	public void jvmOptions() {
		this.factory.getJvmOptions().add("-Dtest.property=test");
		new CassandraRunner(this.factory).run(CassandraAssert::hasNotFailed);
		assertThat(this.output.toString()).contains("-Dtest.property=test");
	}


}
