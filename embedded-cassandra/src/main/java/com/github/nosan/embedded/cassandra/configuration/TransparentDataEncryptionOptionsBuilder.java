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
 * Simple implementation of {@link TransparentDataEncryptionOptions.Builder}.
 *
 * @author Dmytro Nosan
 */
final class TransparentDataEncryptionOptionsBuilder
		implements TransparentDataEncryptionOptions.Builder {

	private Integer chunkLengthKb;

	private String cipher;

	private String keyAlias;

	private Integer ivLength;

	private ParameterizedClass keyProvider;

	@Override
	public TransparentDataEncryptionOptions.Builder setChunkLengthKb(
			Integer chunkLengthKb) {
		this.chunkLengthKb = chunkLengthKb;
		return this;
	}

	@Override
	public TransparentDataEncryptionOptions.Builder setCipher(String cipher) {
		this.cipher = cipher;
		return this;
	}

	@Override
	public TransparentDataEncryptionOptions.Builder setKeyAlias(String keyAlias) {
		this.keyAlias = keyAlias;
		return this;
	}

	@Override
	public TransparentDataEncryptionOptions.Builder setIvLength(Integer ivLength) {
		this.ivLength = ivLength;
		return this;
	}

	@Override
	public TransparentDataEncryptionOptions.Builder setKeyProvider(
			ParameterizedClass keyProvider) {
		this.keyProvider = keyProvider;
		return this;
	}

	@Override
	public TransparentDataEncryptionOptions build() {
		return new ImmutableTransparentDataEncryptionOptions(this);
	}

	/**
	 * Immutable implementation of {@link TransparentDataEncryptionOptions}.
	 */
	static final class ImmutableTransparentDataEncryptionOptions
			implements TransparentDataEncryptionOptions {
		private final Integer chunkLengthKb;

		private final String cipher;

		private final String keyAlias;

		private final Integer ivLength;

		private final ParameterizedClass keyProvider;

		private ImmutableTransparentDataEncryptionOptions(
				TransparentDataEncryptionOptionsBuilder builder) {
			this.chunkLengthKb = builder.chunkLengthKb;
			this.cipher = builder.cipher;
			this.keyAlias = builder.keyAlias;
			this.ivLength = builder.ivLength;
			this.keyProvider = builder.keyProvider;
		}

		@Override
		public Integer getChunkLengthKb() {
			return this.chunkLengthKb;
		}

		@Override
		public String getCipher() {
			return this.cipher;
		}

		@Override
		public String getKeyAlias() {
			return this.keyAlias;
		}

		@Override
		public Integer getIvLength() {
			return this.ivLength;
		}

		@Override
		public ParameterizedClass getKeyProvider() {
			return this.keyProvider;
		}

	}
}
