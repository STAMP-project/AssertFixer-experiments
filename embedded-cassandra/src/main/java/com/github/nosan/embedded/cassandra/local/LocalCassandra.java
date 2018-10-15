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
import java.io.InputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.compress.utils.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import com.github.nosan.embedded.cassandra.Cassandra;
import com.github.nosan.embedded.cassandra.MapSettings;
import com.github.nosan.embedded.cassandra.Settings;
import com.github.nosan.embedded.cassandra.util.OS;
import com.github.nosan.embedded.cassandra.util.PortUtils;
import com.github.nosan.embedded.cassandra.util.RunProcess;
import com.github.nosan.embedded.cassandra.util.StreamUtils;
import com.github.nosan.embedded.cassandra.util.StringUtils;

/**
 * Utility class to run Cassandra.
 *
 * @author Dmytro Nosan
 * @since 1.0.0
 */
final class LocalCassandra {

	private static final Logger log = LoggerFactory.getLogger(Cassandra.class);

	@Nonnull
	private final Supplier<Path> directory;


	@Nullable
	private Process process;

	LocalCassandra(@Nonnull Supplier<Path> directory) {
		this.directory = directory;
	}

	/**
	 * Starts the Cassandra.
	 *
	 * @throws Exception if the Cassandra cannot be started
	 */
	void start() throws Exception {
		List<String> cmd = new ArrayList<>();
		if (OS.isWindows()) {
			cmd.add("powershell");
			cmd.add("-ExecutionPolicy");
			cmd.add("Unrestricted");
		}
		cmd.add(String.valueOf(getExecutable().toAbsolutePath()));
		cmd.add("-f");
		cmd.add("-p");
		cmd.add(String.valueOf(getPidFile().toAbsolutePath()));
		cmd.add(String.format("%s-Dcassandra.jmx.local.port=%s", OS.isWindows() ? "`" : "", PortUtils.getPort()));
		Errors errors = new Errors();
		Process process = new RunProcess(this.directory.get()).run(cmd, log::info, errors);

		this.process = process;
		Settings settings = getSettings();

		if (settings.isStartRpc() || settings.isStartNativeTransport()) {
			String address = StringUtils.hasText(settings.getAddress()) ? settings.getAddress() : "localhost";
			int port = settings.isStartNativeTransport() ? settings.getPort() : settings.getRpcPort();
			boolean await = await(Duration.ofMinutes(1), () -> {
				if (!process.isAlive()) {
					throwException("Cassandra has not be started. Please see logs for more details.", errors);
				}
				try (Socket ignore = new Socket(address, port)) {
					return true;
				}
				catch (IOException ex) {
					return false;
				}
			});
			if (!await) {
				throwException(String.format("Cassandra transport (%s:%s) has not been started.", address, port),
						errors);
			}
		}
		else {
			if (await(Duration.ofSeconds(15), () -> !process.isAlive())) {
				throwException("Cassandra has not be started. Please see logs for more details.", errors);
			}
		}

	}

	/**
	 * Stops the Cassandra.
	 *
	 * @throws Exception if the Cassandra cannot be stopped
	 */
	void stop() throws Exception {
		Process process = this.process;
		if (process != null) {
			try {
				long pid = getPid();
				IOUtils.closeQuietly(process.getInputStream());
				IOUtils.closeQuietly(process.getErrorStream());
				IOUtils.closeQuietly(process.getOutputStream());
				if (pid > 0) {
					log.info("kill the process by id ({})", pid);
					kill(pid);
				}
				boolean waitFor = process.destroyForcibly().waitFor(1, TimeUnit.MINUTES);
				if (!waitFor) {
					throw new IOException("Casandra Process has not been stopped correctly");
				}
				log.info("Cassandra process has been destroyed");
			}
			catch (InterruptedException ex) {
				if (log.isDebugEnabled()) {
					log.error("Thread Interrupted", ex);
				}
				Thread.currentThread().interrupt();
			}
		}
	}


	/**
	 * Returns the settings this Cassandra is running on.
	 *
	 * @return the settings
	 * @throws Exception if could not get a settings
	 */
	@Nonnull
	Settings getSettings() throws Exception {
		Path target = this.directory.get().resolve("conf/cassandra.yaml");
		try (InputStream is = Files.newInputStream(target)) {
			Yaml yaml = new Yaml();
			return new MapSettings(yaml.loadAs(is, Map.class));
		}
	}


	private void kill(long pid) throws IOException {
		RunProcess runProcess = new RunProcess();
		if (OS.isWindows()) {
			runProcess.runAndWait(Arrays.asList("TASKKILL", "/F", "/T", "/pid", "" + pid), log::info);
		}
		else {
			runProcess.runAndWait(Arrays.asList("kill", "-9", "" + pid), log::info);
		}
	}

	private Path getExecutable() {
		Path path = this.directory.get();
		return OS.isWindows() ? path.resolve("bin/cassandra.ps1") : path.resolve("bin/cassandra");
	}

	private Path getPidFile() {
		return this.directory.get().resolve("pid");
	}

	private long getPid() {
		Path pidFile = getPidFile();
		try {
			if (Files.exists(pidFile)) {
				String pid = StreamUtils.toString(Files.newBufferedReader(pidFile))
						.replaceAll("\\D+", "");
				if (StringUtils.hasText(pid)) {
					return Long.parseLong(pid);
				}
			}
		}
		catch (Throwable ex) {
			if (log.isDebugEnabled()) {
				log.error(String.format("Could not read a pid from : (%s)", pidFile), ex);
			}
		}
		return 0;
	}


	private static boolean await(Duration timeout, Callable<Boolean> callable) throws Exception {
		long start = System.nanoTime();
		long rem = timeout.toNanos();
		do {
			if (callable.call()) {
				return true;
			}
			if (rem > 0) {
				try {
					Thread.sleep(Math.min(TimeUnit.NANOSECONDS.toMillis(rem) + 1, 100));
				}
				catch (InterruptedException ex) {
					if (log.isDebugEnabled()) {
						log.error("Thread Interrupted", ex);
					}
					Thread.currentThread().interrupt();
				}
			}
			rem = timeout.toNanos() - (System.nanoTime() - start);
		}
		while (rem > 0);
		return false;
	}


	private void throwException(String message, Errors errors) throws IOException {
		StringBuilder msg = new StringBuilder(String.format("%s%n", message));
		for (String error : errors.getLines()) {
			msg.append(String.format("\t--- %s%n", error));
		}
		throw new IOException(msg.toString());
	}

	/**
	 * {@link RunProcess.Output} to keep errors.
	 */
	private static final class Errors implements RunProcess.Output {


		@Nonnull
		private final List<String> lines = new ArrayList<>();

		@Override
		public void accept(@Nonnull String line) {
			if (isError(line)) {
				this.lines.add(line);
			}
		}

		@Nonnull
		List<String> getLines() {
			return this.lines;
		}

		private static boolean isError(String candidate) {
			String lowerCase = candidate.toLowerCase(Locale.ENGLISH);
			return lowerCase.contains("error") || lowerCase.contains("exception");
		}
	}


}
