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

package com.github.nosan.embedded.cassandra.cql;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.util.Collection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.github.nosan.embedded.cassandra.utils.StreamUtils;


/**
 * Convenience base class for {@link CqlScript} implementations,
 * pre-implementing CQL scripts parsing.
 *
 * @author Dmytro Nosan
 */
public abstract class AbstractCqlScript implements CqlScript {

	@Nonnull
	private final Charset encoding;

	protected AbstractCqlScript() {
		this(null);
	}

	protected AbstractCqlScript(@Nullable Charset encoding) {
		this.encoding = (encoding != null) ? encoding : Charset.defaultCharset();
	}

	@Override
	@Nonnull
	public Collection<String> getStatements() {
		try {
			String cqlScript = StreamUtils.toString(getInputStream(), getEncoding());
			return CqlScriptParser.parse(cqlScript);
		}
		catch (IOException ex) {
			throw new UncheckedIOException(
					"Could not open a stream for CQL Script (" + toString() + ")", ex);
		}
	}

	/**
	 * Return an {@link InputStream} for the content of an underlying resource.
	 * <p>It is expected that each call creates a <i>fresh</i> stream.
	 *
	 * @return the input stream for the underlying resource
	 * @throws IOException if the content stream could not be opened
	 */
	@Nonnull
	public abstract InputStream getInputStream() throws IOException;

	/**
	 * Return the encoding to use for reading from the {@link #getInputStream() Stream}.
	 *
	 * @return encoding to use.
	 */
	@Nonnull
	public Charset getEncoding() {
		return this.encoding;
	}

}
