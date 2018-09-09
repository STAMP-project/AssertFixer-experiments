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

package com.github.nosan.embedded.cassandra.core;

import java.util.Objects;

import javax.annotation.Nonnull;

import com.github.nosan.embedded.cassandra.Cassandra;
import com.github.nosan.embedded.cassandra.configuration.BootstrapSettings;

/**
 * TODO leave javadoc here.
 *
 * @author Dmytro Nosan
 */
public final class Executable {

	@Nonnull
	private final BootstrapSettings settings;

	public Executable(@Nonnull BootstrapSettings settings) {
		this.settings = Objects.requireNonNull(settings, "Bootstrap Settings must not be null");
	}

	public void start() {
		assertCallerClass();
	}


	public void stop() {
		assertCallerClass();
	}


	private static void assertCallerClass() {
		StackTraceElement[] stack = Thread.currentThread().getStackTrace();
		for (StackTraceElement e : stack) {
			if (Cassandra.class.getName().equals(e.getClassName())) {
				return;
			}
		}
		throw new IllegalStateException(Executable.class.getName() + " is an internal Class. Only " + Cassandra.class
				.getName() + " can use it.");

	}
}
