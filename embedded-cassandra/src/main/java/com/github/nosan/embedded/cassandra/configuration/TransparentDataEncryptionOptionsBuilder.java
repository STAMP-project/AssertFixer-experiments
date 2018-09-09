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
 * Simple implementation of {@link TransparentDataEncryptionOptions.Builder}.
 *
 * @author Dmytro Nosan
 */
final class TransparentDataEncryptionOptionsBuilder
		implements TransparentDataEncryptionOptions.Builder {

	@Nullable
	private Integer chunkLengthKb;

	@Nullable
	private String cipher;

	@Nullable
	private String keyAlias;

	@Nullable
	private Integer ivLength;

	@Nullable
	private ParameterizedClass keyProvider;

	@Nonnull
	@Override
	public TransparentDataEncryptionOptions.Builder setChunkLengthKb(@Nullable Integer chunkLengthKb) {
		this.chunkLengthKb = chunkLengthKb;
		return this;
	}

	@Nonnull
	@Override
	public TransparentDataEncryptionOptions.Builder setCipher(@Nullable String cipher) {
		this.cipher = cipher;
		return this;
	}

	@Nonnull
	@Override
	public TransparentDataEncryptionOptions.Builder setKeyAlias(@Nullable String keyAlias) {
		this.keyAlias = keyAlias;
		return this;
	}

	@Nonnull
	@Override
	public TransparentDataEncryptionOptions.Builder setIvLength(@Nullable Integer ivLength) {
		this.ivLength = ivLength;
		return this;
	}

	@Nonnull
	@Override
	public TransparentDataEncryptionOptions.Builder setKeyProvider(
			@Nullable ParameterizedClass keyProvider) {
		this.keyProvider = keyProvider;
		return this;
	}

	@Nonnull
	@Override
	public TransparentDataEncryptionOptions build() {
		return new ImmutableTransparentDataEncryptionOptions(this);
	}

	/**
	 * Immutable implementation of {@link TransparentDataEncryptionOptions}.
	 */
	private static final class ImmutableTransparentDataEncryptionOptions
			implements TransparentDataEncryptionOptions {

		@Nullable
		private final Integer chunkLengthKb;

		@Nullable
		private final String cipher;

		@Nullable
		private final String keyAlias;

		@Nullable
		private final Integer ivLength;

		@Nullable
		private final ParameterizedClass keyProvider;

		private ImmutableTransparentDataEncryptionOptions(
				@Nonnull TransparentDataEncryptionOptionsBuilder builder) {
			this.chunkLengthKb = builder.chunkLengthKb;
			this.cipher = builder.cipher;
			this.keyAlias = builder.keyAlias;
			this.ivLength = builder.ivLength;
			this.keyProvider = builder.keyProvider;
		}

		@Nullable
		@Override
		public Integer getChunkLengthKb() {
			return this.chunkLengthKb;
		}

		@Nullable
		@Override
		public String getCipher() {
			return this.cipher;
		}

		@Nullable
		@Override
		public String getKeyAlias() {
			return this.keyAlias;
		}

		@Nullable
		@Override
		public Integer getIvLength() {
			return this.ivLength;
		}

		@Nullable
		@Override
		public ParameterizedClass getKeyProvider() {
			return this.keyProvider;
		}

	}
}
