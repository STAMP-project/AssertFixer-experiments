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

package com.github.nosan.embedded.cassandra.artifact;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.nosan.embedded.cassandra.Version;
import com.github.nosan.embedded.cassandra.util.FileUtils;
import com.github.nosan.embedded.cassandra.util.StringUtils;

/**
 * {@link Artifact} which implements a remote {@code archive}. It checks if {@code archive} doesn't exist locally, it
 * tries to download it using {@link UrlFactory#create(Version) URL} and store locally. Artifact name generates based
 * on {@code URL}.
 *
 * @author Dmytro Nosan
 * @since 1.0.0
 */
final class RemoteArtifact implements Artifact {

	private static final Logger log = LoggerFactory.getLogger(Artifact.class);

	@Nonnull
	private final Version version;

	@Nonnull
	private final Path directory;

	@Nonnull
	private final UrlFactory urlFactory;

	@Nullable
	private final Proxy proxy;

	@Nullable
	private final Duration readTimeout;

	@Nullable
	private final Duration connectTimeout;

	RemoteArtifact(@Nonnull Version version, @Nonnull Path directory,
			@Nonnull UrlFactory urlFactory, @Nullable Proxy proxy,
			@Nullable Duration readTimeout, @Nullable Duration connectTimeout) {
		this.version = Objects.requireNonNull(version, "Version must not be null");
		this.directory = Objects.requireNonNull(directory, "Directory must not be null");
		this.urlFactory = Objects.requireNonNull(urlFactory, "URL Factory must not be null");
		this.proxy = proxy;
		this.readTimeout = readTimeout;
		this.connectTimeout = connectTimeout;
	}

	@Override
	@Nonnull
	public Path get() throws IOException {
		URL url = this.urlFactory.create(this.version);
		Objects.requireNonNull(url, "URL must not be null");
		if (!Files.exists(this.directory)) {
			Files.createDirectories(this.directory);
		}
		if (!Files.isDirectory(this.directory)) {
			throw new IllegalArgumentException(
					String.format("(%s) exists and is a file, directory or path expected.", this.directory));
		}
		if (!Files.isWritable(this.directory)) {
			throw new IllegalArgumentException(String.format("(%s) is not writable", this.directory));
		}
		Path target = this.directory.resolve(getName(url));

		if (!Files.exists(target)) {
			Path source = download(url);
			try {
				if (target.getParent() != null) {
					Files.createDirectories(target.getParent());
				}
				log.info("Store ({}) as ({})", source, target);
				return Files.move(source, target);
			}
			catch (IOException ex) {
				if (log.isDebugEnabled()) {
					log.error(String.format("Could not rename (%s) as (%s)", source, target), ex);
				}
				return source;
			}
		}

		return target;
	}


	private String getName(URL url) {
		String file = url.getFile();
		if (StringUtils.hasText(file) && file.lastIndexOf("/") != -1) {
			file = file.substring(file.lastIndexOf("/") + 1);
		}
		if (!StringUtils.hasText(file)) {
			throw new IllegalArgumentException(
					String.format("There is no way to determine a file name from (%s)", url));
		}
		return file;
	}


	private Path download(URL url) throws IOException {
		URLConnection urlConnection = (this.proxy != null) ? url.openConnection(this.proxy) : url.openConnection();
		if (urlConnection instanceof HttpURLConnection) {
			HttpURLConnection connection = (HttpURLConnection) urlConnection;
			if (this.connectTimeout != null) {
				connection.setConnectTimeout(Math.toIntExact(this.connectTimeout.toMillis()));
			}
			if (this.readTimeout != null) {
				connection.setReadTimeout(Math.toIntExact(this.readTimeout.toMillis()));
			}
		}
		Path tempFile = FileUtils.getTmpDirectory()
				.resolve(String.format("%s-%s", UUID.randomUUID(), getName(url)));
		Files.createFile(tempFile);
		try {
			tempFile.toFile().deleteOnExit();
		}
		catch (Throwable ex) {
			if (log.isDebugEnabled()) {
				log.error(String.format("Shutdown hook is not registered for (%s)", tempFile), ex);
			}
		}
		long size = urlConnection.getContentLengthLong();
		log.info("Downloading Cassandra from ({}). It takes a while...", url);
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		if (size > 0) {
			executorService.scheduleAtFixedRate(() -> {
				try {
					long current = Files.size(tempFile);
					log.info("Downloaded {} / {}  {}%", current, size, (current * 100) / size);
				}
				catch (IOException ex) {
					if (log.isDebugEnabled()) {
						log.error(String.format("Could not get a size for (%s)", tempFile), ex);
					}
				}
			}, 0, 3, TimeUnit.SECONDS);
		}
		try {
			try (FileChannel fileChannel = new FileOutputStream(tempFile.toFile()).getChannel();
					ReadableByteChannel urlChannel = Channels.newChannel(urlConnection.getInputStream())) {
				fileChannel.transferFrom(urlChannel, 0, Long.MAX_VALUE);
			}
		}
		catch (IOException ex) {
			throw new IOException(String.format("Could not download Cassandra from (%s)", url), ex);
		}
		finally {
			executorService.shutdown();
		}
		log.info("Cassandra has been downloaded");
		return tempFile;
	}


}
