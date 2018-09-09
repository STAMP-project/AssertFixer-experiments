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

package com.github.nosan.embedded.cassandra.configuration;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Enables encryption of data at rest (on-disk).
 *
 * @author Dmytro Nosan
 */
public interface TransparentDataEncryptionOptions {

	/**
	 * Chunk length to use.
	 *
	 * @return The value of the {@code chunkLengthKb} attribute
	 */
	@Nullable
	Integer getChunkLengthKb();

	/**
	 * Cipher to use.
	 *
	 * @return The value of the {@code cipher} attribute
	 */
	@Nullable
	String getCipher();

	/**
	 * Key alias to use.
	 *
	 * @return The value of the {@code keyAlias} attribute
	 */
	@Nullable
	String getKeyAlias();

	/**
	 * Iv length to use.
	 *
	 * @return The value of the {@code ivLength} attribute
	 */
	@Nullable
	Integer getIvLength();

	/**
	 * Key Provider to use.
	 *
	 * @return The value of the {@code keyProvider} attribute
	 */
	@Nullable
	ParameterizedClass getKeyProvider();

	/**
	 * Create a new builder to build a {@link TransparentDataEncryptionOptions}.
	 *
	 * @return a fresh {@code Builder}.
	 */
	@Nonnull
	static Builder builder() {
		return new TransparentDataEncryptionOptionsBuilder();
	}

	/**
	 * Builds instances of type {@link TransparentDataEncryptionOptions TransparentDataEncryptionOptions}. Initialize
	 * attributes and then invoke the {@link #build()} method to create an instance.
	 * <p><em>{@code TransparentDataEncryptionOptionsBuilder} is not thread-safe and generally should not be stored in
	 * a field or collection, but instead used immediately to create instances.</em>
	 *
	 * @author Dmytro Nosan
	 */
	interface Builder {

		/**
		 * Initializes the value for the {@link TransparentDataEncryptionOptions#getChunkLengthKb() chunkLengthKb}
		 * attribute.
		 *
		 * @param chunkLengthKb The value for chunkLengthKb
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setChunkLengthKb(@Nullable Integer chunkLengthKb);

		/**
		 * Initializes the value for the {@link TransparentDataEncryptionOptions#getCipher() cipher} attribute.
		 *
		 * @param cipher The value for cipher
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setCipher(@Nullable String cipher);

		/**
		 * Initializes the value for the {@link TransparentDataEncryptionOptions#getKeyAlias() keyAlias} attribute.
		 *
		 * @param keyAlias The value for keyAlias
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setKeyAlias(@Nullable String keyAlias);

		/**
		 * Initializes the value for the {@link TransparentDataEncryptionOptions#getIvLength() ivLength} attribute.
		 *
		 * @param ivLength The value for ivLength
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setIvLength(@Nullable Integer ivLength);

		/**
		 * Initializes the value for the {@link TransparentDataEncryptionOptions#getKeyProvider() keyProvider}
		 * attribute.
		 *
		 * @param keyProvider The value for keyProvider
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setKeyProvider(@Nullable ParameterizedClass keyProvider);

		/**
		 * Builds a new {@link TransparentDataEncryptionOptions TransparentDataEncryptionOptions}.
		 *
		 * @return An  instance of TransparentDataEncryptionOptions
		 */
		@Nonnull
		TransparentDataEncryptionOptions build();
	}
}
