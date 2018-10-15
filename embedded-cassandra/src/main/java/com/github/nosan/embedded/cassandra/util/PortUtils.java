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

import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

/**
 * Utility methods for dealing with ports.
 *
 * @author Dmytro Nosan
 * @since 1.0.0
 */
public abstract class PortUtils {

	private final static int MIN = 49152;

	private final static int MAX = 65535;

	private static final Set<Integer> CLOSED = new HashSet<>();

	/**
	 * Find a free {@code TCP} port.
	 *
	 * @return a port
	 * @throws IllegalStateException if port could not be found
	 */
	public synchronized static int getPort() {
		int port = getFreeTcpPort();
		if (port == -1) {
			CLOSED.clear();
			port = getFreeTcpPort();
		}
		if (port == -1) {
			throw new IllegalStateException("Could not find available TCP port");
		}
		CLOSED.add(port);
		return port;
	}

	private static int getFreeTcpPort() {
		for (int i = MIN; i <= PortUtils.MAX; i++) {
			if (CLOSED.contains(i)) {
				continue;
			}
			try (ServerSocket ss = new ServerSocket(i)) {
				return ss.getLocalPort();
			}
			catch (Throwable ignore) {
			}
		}
		return -1;
	}

}
