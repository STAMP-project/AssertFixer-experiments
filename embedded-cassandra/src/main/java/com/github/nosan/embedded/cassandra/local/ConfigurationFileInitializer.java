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
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.yaml.snakeyaml.reader.UnicodeReader;

import com.github.nosan.embedded.cassandra.Version;
import com.github.nosan.embedded.cassandra.util.PortUtils;
import com.github.nosan.embedded.cassandra.util.StreamUtils;

/**
 * {@link DirectoryInitializer} to initialize {@code cassandra.yaml}.
 *
 * @author Dmytro Nosan
 * @since 1.0.0
 */
final class ConfigurationFileInitializer implements DirectoryInitializer {

	@Nullable
	private final URL configurationFile;

	ConfigurationFileInitializer(@Nullable URL configurationFile) {
		this.configurationFile = configurationFile;
	}

	@Override
	public void initialize(@Nonnull Path directory, @Nonnull Version version) throws Exception {
		URL source = this.configurationFile;
		if (source == null) {
			if (version.getMajor() >= 4) {
				source = getClass().getResource("../4.x.x/cassandra.yaml");
			}
			else {
				source = getClass().getResource("../cassandra.yaml");
			}
		}
		Path target = directory.resolve("conf/cassandra.yaml");
		try (InputStream is = source.openStream()) {
			Files.copy(is, target, StandardCopyOption.REPLACE_EXISTING);
		}
		catch (IOException ex) {
			throw new IOException(String.format("Configuration file : (%s) could not be saved", source), ex);
		}
		replacePorts(target);
	}

	private static void replacePorts(Path target) throws IOException {
		String source = StreamUtils.toString(new UnicodeReader(Files.newInputStream(target)));
		Pattern pattern = Pattern.compile("^([a-z_]+)_port:\\s*([0-9]+)\\s*$", Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(source);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String name = matcher.group(1);
			int port = Integer.parseInt(matcher.group(2));
			matcher.appendReplacement(sb, String.format("%s_port: %s", name, getPort(port)));
		}
		matcher.appendTail(sb);
		try (BufferedWriter writer = Files.newBufferedWriter(target)) {
			writer.write(sb.toString());
		}
	}

	private static int getPort(int port) {
		return (port != 0) ? port : PortUtils.getPort();
	}
}
