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

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import javax.annotation.Nonnull;

import com.sun.net.httpserver.HttpServer;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * {@link TestRule} to start HttpServer.
 *
 * @author Dmytro Nosan
 */
public final class WebServer implements TestRule {

	private final HttpServer server;

	/**
	 * Creates a http server.
	 */
	public WebServer() {
		try {
			this.server = HttpServer.create(new InetSocketAddress("localhost", 0), 0);
			this.server.setExecutor(Executors.newCachedThreadPool());
		}
		catch (Throwable ex) {
			throw new IllegalStateException(ex);
		}
	}


	@Override
	public Statement apply(Statement base, Description description) {
		HttpServer server = this.server;
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					server.start();
					base.evaluate();
				}
				finally {
					server.stop(0);
				}
			}
		};
	}

	/**
	 * Get a http server.
	 *
	 * @return a server
	 */
	@Nonnull
	public HttpServer get() {
		return this.server;
	}
}
