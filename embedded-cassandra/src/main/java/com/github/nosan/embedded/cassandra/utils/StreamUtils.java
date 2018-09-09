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

package com.github.nosan.embedded.cassandra.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Utility methods for dealing with streams.
 *
 * @author Dmytro Nosan
 */
public abstract class StreamUtils {
	/**
	 * Copy the contents of the given InputStream into a String.
	 * Closes the stream when done.
	 *
	 * @param stream the InputStream to copy from
	 * @param charset the Charset to use
	 * @return the String that has been copied to (possibly empty)
	 * @throws IOException in case of I/O errors
	 */
	@Nonnull
	public static String toString(@Nullable InputStream stream, @Nonnull Charset charset) throws IOException {
		if (stream == null) {
			return "";
		}

		StringBuilder out = new StringBuilder();
		try (InputStreamReader reader = new InputStreamReader(stream, charset)) {
			char[] buffer = new char[4096];
			int bytesRead = -1;
			while ((bytesRead = reader.read(buffer)) != -1) {
				out.append(buffer, 0, bytesRead);
			}
		}
		return out.toString();
	}
}
