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

package com.github.nosan.embedded.cassandra.util;

import java.nio.file.Path;
import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link RunProcess}.
 *
 * @author Dmytro Nosan
 */
public class RunProcessTests {


	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void echo() throws Exception {
		StringBuilder buffer = new StringBuilder();
		Path workingDirectory = this.temporaryFolder.newFolder().toPath();
		int exit = new RunProcess(workingDirectory)
				.runAndWait(Arrays.asList("echo", "Hello World"), buffer::append);
		assertThat(exit).isEqualTo(0);
		Thread.sleep(1000);
		assertThat(buffer.toString()).contains("Hello World");
	}

}
