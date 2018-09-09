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

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * {@link CqlScript} implementation for class path resources. Uses a
 * given {@link ClassLoader} or a given {@link Class} for loading resources.
 *
 * @author Dmytro Nosan
 */
public class ClassPathCqlScript extends AbstractCqlScript {

	@Nonnull
	private final String location;

	@Nullable
	private final ClassLoader classLoader;

	@Nullable
	private final Class<?> contextClass;

	public ClassPathCqlScript(@Nonnull String location) {
		this(location, null, null, null);
	}

	public ClassPathCqlScript(@Nonnull String location, @Nullable Charset charset) {
		this(location, null, null, charset);
	}

	public ClassPathCqlScript(@Nonnull String location, @Nullable ClassLoader classLoader) {
		this(location, classLoader, null);
	}

	public ClassPathCqlScript(@Nonnull String location, @Nullable ClassLoader classLoader, @Nullable Charset charset) {
		this(location, classLoader, null, charset);
	}

	public ClassPathCqlScript(@Nonnull String location, @Nullable Class<?> contextClass) {
		this(location, null, contextClass, null);
	}

	public ClassPathCqlScript(@Nonnull String location, @Nullable Class<?> contextClass, @Nullable Charset charset) {
		this(location, null, contextClass, charset);
	}

	private ClassPathCqlScript(@Nonnull String location, @Nullable ClassLoader classLoader,
			@Nullable Class<?> contextClass, @Nullable Charset charset) {
		super(charset);
		Objects.requireNonNull(location, "Location must not be null");
		if (contextClass == null) {
			this.location = location.startsWith("/") ? location.substring(1) : location;
		}
		else {
			this.location = location;
		}
		this.classLoader = (classLoader != null) ? classLoader : Thread.currentThread()
				.getContextClassLoader();
		this.contextClass = contextClass;
	}

	/**
	 * Return the underlying classpath.
	 *
	 * @return Classpath location.
	 */
	@Nonnull
	public String getLocation() {
		return this.location;
	}

	/**
	 * Return the ClassLoader that this resource will be obtained from.
	 *
	 * @return ClassLoader to load resources.
	 */
	@Nullable
	public ClassLoader getClassLoader() {
		return this.classLoader;
	}

	/**
	 * Return the Class that this resource will be obtained from.
	 *
	 * @return Class to load resources.
	 */
	@Nullable
	public Class<?> getContextClass() {
		return this.contextClass;
	}

	@Override
	public String toString() {
		return this.location;
	}

	@Nonnull
	@Override
	public InputStream getInputStream() throws FileNotFoundException {
		InputStream stream;
		if (this.contextClass != null) {
			stream = this.contextClass.getResourceAsStream(this.location);
		}
		else if (this.classLoader != null) {
			stream = this.classLoader.getResourceAsStream(this.location);
		}
		else {
			stream = ClassLoader.getSystemResourceAsStream(this.location);
		}
		if (stream == null) {
			throw new FileNotFoundException(
					String.format("'%s' doesn't exist", this.location));
		}
		return stream;
	}
}
