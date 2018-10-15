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

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link PortUtils}.
 *
 * @author Dmytro Nosan
 */
public class PortUtilsTests {


	@Rule
	public ExpectedException throwable = ExpectedException.none();

	@Test
	public void shouldGetRandomPort() throws IOException {
		Set<Integer> ports = new HashSet<>();
		for (int i = 0; i < 100; i++) {
			int port = PortUtils.getPort();
			ports.add(port);
			try (ServerSocket ignore = new ServerSocket(port)) {
				ignore.getLocalPort();
			}
		}
		assertThat(ports).hasSize(100);
	}

}
