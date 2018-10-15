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

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.github.nosan.embedded.cassandra.Version;
import com.github.nosan.embedded.cassandra.testutil.Output;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link JvmOptionsInitializer}.
 *
 * @author Dmytro Nosan
 */
public class JvmOptionsInitializerTests {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Rule
	public Output output = new Output();

	@Test
	public void initializeJvmOptionsV3() throws Exception {
		Path directory = this.temporaryFolder.newFolder("conf").toPath();
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(directory.resolve("jvm.options"))) {
			bufferedWriter.write("-Xmx512m");
		}
		JvmOptionsInitializer initializer = new JvmOptionsInitializer(Arrays.asList("arg1", "Arg2"));
		initializer.initialize(directory.getParent(), new Version(3, 11, 3));
		assertThat(directory.resolve("jvm.options")).hasContent("-Xmx512m\narg1\nArg2\n");
	}

	@Test
	public void initializeJvmOptionsV4() throws Exception {
		Path directory = this.temporaryFolder.newFolder("conf").toPath();
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(directory.resolve("jvm-server.options"))) {
			bufferedWriter.write("-Xmx512m");
		}
		JvmOptionsInitializer initializer = new JvmOptionsInitializer(Arrays.asList("arg1", "Arg2"));
		initializer.initialize(directory.getParent(), new Version(4, 0, 0));
		assertThat(directory.resolve("jvm-server.options")).hasContent("-Xmx512m\narg1\nArg2\n");
	}

	@Test
	public void notInitializeV2() throws Exception {
		Path directory = this.temporaryFolder.newFolder("conf").toPath();
		JvmOptionsInitializer initializer = new JvmOptionsInitializer(Arrays.asList("arg1", "Arg2"));
		initializer.initialize(directory.getParent(), new Version(2, 11, 3));
		assertThat(directory.resolve("jvm.options")).doesNotExist();
		assertThat(directory.resolve("jvm-server.options")).doesNotExist();
		assertThat(this.output.toString()).contains("Cassandra (2.11.3) doesn't support JVM options.");
	}

	@Test
	public void notInitialize() throws Exception {
		Path directory = this.temporaryFolder.newFolder("conf").toPath();
		JvmOptionsInitializer initializer = new JvmOptionsInitializer(null);
		initializer.initialize(directory.getParent(), new Version(3, 11, 3));
		assertThat(directory.resolve("jvm.options")).doesNotExist();
	}


}
