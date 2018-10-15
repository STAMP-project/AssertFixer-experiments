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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for dealing with {@link Process}.
 *
 * @author Dmytro Nosan
 * @since 1.0.0
 */
public final class RunProcess {

	private static final Logger log = LoggerFactory.getLogger(RunProcess.class);

	@Nullable
	private final Path workingDirectory;

	/**
	 * Creates new {@link RunProcess} instance for the specified working directory.
	 *
	 * @param workingDirectory the working directory of the child process
	 * to run in the working directory of the current Java process
	 */
	public RunProcess(@Nullable Path workingDirectory) {
		this.workingDirectory = workingDirectory;
	}

	/**
	 * Creates new {@link RunProcess} instance.
	 */
	public RunProcess() {
		this(null);
	}


	/**
	 * Starts a new process using the arguments and delegates output to the {@link Output}.
	 * Causes the current thread to wait, if necessary, until the process represented by process object has
	 * terminated.
	 *
	 * @param outputs output consumers.
	 * @param arguments the program to execute and its arguments
	 * @return the exit value of the subprocess represented by {@code Process} object. By convention, the value
	 * {@code 0} indicates normal termination.
	 * @throws IOException if an I/O error occurs
	 */
	public int runAndWait(@Nonnull List<String> arguments, @Nullable Output... outputs)
			throws IOException {
		try {
			return run(arguments, outputs).waitFor();
		}
		catch (InterruptedException ex) {
			if (log.isDebugEnabled()) {
				log.error("Thread Interrupted", ex);
			}
			Thread.currentThread().interrupt();
			return -1;
		}
	}


	/**
	 * Starts a new process using the arguments and delegates output to the {@link Output}.
	 *
	 * @param outputs output consumers.
	 * @param arguments the program to execute and its arguments
	 * @return a new process object for managing the subprocess
	 * @throws IOException if an I/O error occurs
	 */
	public Process run(@Nonnull List<String> arguments, @Nullable Output... outputs)
			throws IOException {
		ProcessBuilder processBuilder = new ProcessBuilder(arguments);
		if (this.workingDirectory != null) {
			processBuilder.directory(this.workingDirectory.toFile());
		}
		processBuilder.redirectErrorStream(true);
		Process process = processBuilder.start();
		if (outputs != null && outputs.length > 0) {
			Thread thread = new Thread(new ProcessReader(process, outputs));
			thread.setDaemon(true);
			thread.start();
		}
		return process;
	}


	/**
	 * Output consumer.
	 */
	@FunctionalInterface
	public interface Output extends Consumer<String> {

		/**
		 * Consumes the given line.
		 *
		 * @param line a source line (never empty or null)
		 */
		@Override
		void accept(@Nonnull String line);
	}

	private static final class ProcessReader implements Runnable {

		@Nonnull
		private final List<Output> targets;

		@Nonnull
		private final Process process;


		ProcessReader(@Nonnull Process process, @Nonnull Output... targets) {
			this.process = process;
			this.targets = Arrays.asList(targets);
		}

		@Override
		public void run() {
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.process.getInputStream()), 32)) {
				String line;
				while ((line = reader.readLine()) != null) {
					if (StringUtils.hasText(line)) {
						for (Output output : this.targets) {
							output.accept(line);
						}
					}
				}
			}
			catch (IOException ex) {
				if (log.isDebugEnabled()) {
					log.error("Could not read process output", ex);
				}
			}
		}
	}


}
