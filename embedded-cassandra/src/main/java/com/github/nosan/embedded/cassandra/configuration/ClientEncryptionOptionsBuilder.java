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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Simple implementation of {@link ClientEncryptionOptions.Builder}.
 *
 * @author Dmytro Nosan
 */
final class ClientEncryptionOptionsBuilder implements ClientEncryptionOptions.Builder {

	@Nullable
	private String keystore;

	@Nullable
	private String keystorePassword;

	@Nullable
	private String truststore;

	@Nullable
	private String truststorePassword;

	@Nullable
	private Collection<String> cipherSuites;

	@Nullable
	private String protocol;

	@Nullable
	private String algorithm;

	@Nullable
	private String storeType;

	@Nullable
	private Boolean requireClientAuth;

	@Nullable
	private Boolean requireEndpointVerification;

	@Nullable
	private Boolean enabled;

	@Nullable
	private Boolean optional;

	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder setKeystore(@Nullable String keystore) {
		this.keystore = keystore;
		return this;
	}

	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder setKeystorePassword(@Nullable String keystorePassword) {
		this.keystorePassword = keystorePassword;
		return this;
	}

	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder setTruststore(@Nullable String truststore) {
		this.truststore = truststore;
		return this;
	}

	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder setTruststorePassword(@Nullable String truststorePassword) {
		this.truststorePassword = truststorePassword;
		return this;
	}


	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder addCipherSuites(@Nullable String... ciphers) {
		if (ciphers == null) {
			return this;
		}
		addCipherSuites(Arrays.asList(ciphers));
		return this;
	}

	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder setCipherSuites(@Nullable Collection<String> ciphers) {
		this.cipherSuites = ciphers;
		return this;
	}

	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder addCipherSuites(@Nullable Collection<String> ciphers) {
		if (ciphers == null) {
			return this;
		}
		if (this.cipherSuites == null) {
			this.cipherSuites = ciphers;
		}
		else {
			this.cipherSuites.addAll(ciphers);
		}
		return this;
	}

	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder setProtocol(@Nullable String protocol) {
		this.protocol = protocol;
		return this;
	}

	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder setAlgorithm(@Nullable String algorithm) {
		this.algorithm = algorithm;
		return this;
	}

	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder setStoreType(@Nullable String storeType) {
		this.storeType = storeType;
		return this;
	}

	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder setRequireClientAuth(@Nullable Boolean requireClientAuth) {
		this.requireClientAuth = requireClientAuth;
		return this;
	}

	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder setRequireEndpointVerification(@Nullable Boolean
			requireEndpointVerification) {
		this.requireEndpointVerification = requireEndpointVerification;
		return this;
	}

	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder setEnabled(@Nullable Boolean enabled) {
		this.enabled = enabled;
		return this;
	}

	@Nonnull
	@Override
	public ClientEncryptionOptions.Builder setOptional(@Nullable Boolean optional) {
		this.optional = optional;
		return this;
	}

	@Nonnull
	@Override
	public ClientEncryptionOptions build() {
		return new ImmutableClientEncryptionOptions(this);
	}


	/**
	 * Immutable implementation of {@link ClientEncryptionOptions}.
	 */
	static final class ImmutableClientEncryptionOptions
			implements ClientEncryptionOptions {

		@Nullable
		private final String keystore;

		@Nullable
		private final String keystorePassword;

		@Nullable
		private final String truststore;

		@Nullable
		private final String truststorePassword;

		@Nullable
		private final Collection<String> cipherSuites;

		@Nullable
		private final String protocol;

		@Nullable
		private final String algorithm;

		@Nullable
		private final String storeType;

		@Nullable
		private final Boolean requireClientAuth;

		@Nullable
		private final Boolean requireEndpointVerification;

		@Nullable
		private final Boolean enabled;

		@Nullable
		private final Boolean optional;

		private ImmutableClientEncryptionOptions(@Nonnull ClientEncryptionOptionsBuilder builder) {
			this.keystore = builder.keystore;
			this.keystorePassword = builder.keystorePassword;
			this.truststore = builder.truststore;
			this.truststorePassword = builder.truststorePassword;
			this.cipherSuites =
					(builder.cipherSuites != null) ? Collections.unmodifiableCollection(builder.cipherSuites) : null;
			this.protocol = builder.protocol;
			this.algorithm = builder.algorithm;
			this.storeType = builder.storeType;
			this.requireClientAuth = builder.requireClientAuth;
			this.requireEndpointVerification = builder.requireEndpointVerification;
			this.enabled = builder.enabled;
			this.optional = builder.optional;
		}

		@Nullable
		@Override
		public String getKeystore() {
			return this.keystore;
		}

		@Nullable
		@Override
		public String getKeystorePassword() {
			return this.keystorePassword;
		}

		@Nullable
		@Override
		public String getTruststore() {
			return this.truststore;
		}

		@Nullable
		@Override
		public String getTruststorePassword() {
			return this.truststorePassword;
		}

		@Nullable
		@Override
		public Collection<String> getCipherSuites() {
			return this.cipherSuites;
		}

		@Nullable
		@Override
		public String getProtocol() {
			return this.protocol;
		}

		@Nullable
		@Override
		public String getAlgorithm() {
			return this.algorithm;
		}

		@Nullable
		@Override
		public String getStoreType() {
			return this.storeType;
		}

		@Nullable
		@Override
		public Boolean getRequireClientAuth() {
			return this.requireClientAuth;
		}

		@Nullable
		@Override
		public Boolean getRequireEndpointVerification() {
			return this.requireEndpointVerification;
		}

		@Nullable
		@Override
		public Boolean getEnabled() {
			return this.enabled;
		}

		@Nullable
		@Override
		public Boolean getOptional() {
			return this.optional;
		}

	}
}
