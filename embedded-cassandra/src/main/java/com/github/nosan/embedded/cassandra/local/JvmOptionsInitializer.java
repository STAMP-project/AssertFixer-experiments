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
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nosan.embedded.cassandra.Version;

/**
 * {@link DirectoryInitializer} to initialize {@code jvm.options}.
 *
 * @author Dmytro Nosan
 * @since 1.0.0
 */
final class JvmOptionsInitializer implements DirectoryInitializer {

	private static final Logger log = LoggerFactory.getLogger(JvmOptionsInitializer.class);

	@Nonnull
	private final List<String> jvmOptions;

	JvmOptionsInitializer(@Nullable List<String> jvmOptions) {
		this.jvmOptions = (jvmOptions != null) ? new ArrayList<>(jvmOptions) : Collections.emptyList();
	}

	@Override
	public void initialize(@Nonnull Path directory, @Nonnull Version version) throws Exception {
		if (!this.jvmOptions.isEmpty()) {
			Path target;
			if (version.getMajor() >= 4) {
				target = directory.resolve("conf/jvm-server.options");
			}
			else if (version.getMajor() >= 3) {
				target = directory.resolve("conf/jvm.options");
			}
			else {
				log.error("Cassandra ({}) doesn't support JVM options.", version);
				return;
			}
			try (BufferedWriter bufferedWriter = Files.newBufferedWriter(target, StandardOpenOption.APPEND)) {
				bufferedWriter.newLine();
				for (String option : this.jvmOptions) {
					bufferedWriter.append(option);
					bufferedWriter.newLine();
				}
			}
		}
	}
}
