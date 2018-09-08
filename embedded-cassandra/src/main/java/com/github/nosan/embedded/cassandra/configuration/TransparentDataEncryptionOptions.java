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

/**
 * Enables encryption of data at rest (on-disk).
 *
 * @author Dmytro Nosan
 */
public interface TransparentDataEncryptionOptions {


	Integer getChunkLengthKb();

	String getCipher();

	String getKeyAlias();

	Integer getIvLength();

	ParameterizedClass getKeyProvider();

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
		 * @param chunkLengthKb The value for chunkLengthKb (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setChunkLengthKb(Integer chunkLengthKb);

		/**
		 * Initializes the value for the {@link TransparentDataEncryptionOptions#getCipher() cipher} attribute.
		 *
		 * @param cipher The value for cipher (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCipher(String cipher);

		/**
		 * Initializes the value for the {@link TransparentDataEncryptionOptions#getKeyAlias() keyAlias} attribute.
		 *
		 * @param keyAlias The value for keyAlias (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setKeyAlias(String keyAlias);

		/**
		 * Initializes the value for the {@link TransparentDataEncryptionOptions#getIvLength() ivLength} attribute.
		 *
		 * @param ivLength The value for ivLength (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setIvLength(Integer ivLength);

		/**
		 * Initializes the value for the {@link TransparentDataEncryptionOptions#getKeyProvider() keyProvider}
		 * attribute.
		 *
		 * @param keyProvider The value for keyProvider (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setKeyProvider(ParameterizedClass keyProvider);

		/**
		 * Builds a new {@link TransparentDataEncryptionOptions TransparentDataEncryptionOptions}.
		 *
		 * @return An  instance of TransparentDataEncryptionOptions
		 */
		TransparentDataEncryptionOptions build();
	}
}
