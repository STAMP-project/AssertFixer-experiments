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
 * Simple implementation of {@link ServerEncryptionOptions.Builder}.
 *
 * @author Dmytro Nosan
 */
final class ServerEncryptionOptionsBuilder implements ServerEncryptionOptions.Builder {
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
	private InternodeEncryption internodeEncryption;

	@Nonnull
	@Override
	public ServerEncryptionOptions.Builder setKeystore(@Nullable String keystore) {
		this.keystore = keystore;
		return this;
	}

	@Nonnull
	@Override
	public ServerEncryptionOptions.Builder setKeystorePassword(@Nullable String keystorePassword) {
		this.keystorePassword = keystorePassword;
		return this;
	}

	@Nonnull
	@Override
	public ServerEncryptionOptions.Builder setTruststore(@Nullable String truststore) {
		this.truststore = truststore;
		return this;
	}

	@Nonnull
	@Override
	public ServerEncryptionOptions.Builder setTruststorePassword(@Nullable
			String truststorePassword) {
		this.truststorePassword = truststorePassword;
		return this;
	}


	@Nonnull
	@Override
	public ServerEncryptionOptions.Builder addCipherSuites(@Nullable String... ciphers) {
		if (ciphers == null) {
			return this;
		}
		addCipherSuites(Arrays.asList(ciphers));
		return this;
	}

	@Nonnull
	@Override
	public ServerEncryptionOptions.Builder setCipherSuites(@Nullable Collection<String> ciphers) {
		this.cipherSuites = ciphers;
		return this;
	}

	@Nonnull
	@Override
	public ServerEncryptionOptions.Builder addCipherSuites(@Nullable Collection<String> ciphers) {
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
	public ServerEncryptionOptions.Builder setProtocol(@Nullable String protocol) {
		this.protocol = protocol;
		return this;
	}

	@Nonnull
	@Override
	public ServerEncryptionOptions.Builder setAlgorithm(@Nullable String algorithm) {
		this.algorithm = algorithm;
		return this;
	}

	@Nonnull
	@Override
	public ServerEncryptionOptions.Builder setStoreType(@Nullable String storeType) {
		this.storeType = storeType;
		return this;
	}

	@Nonnull
	@Override
	public ServerEncryptionOptions.Builder setRequireClientAuth(@Nullable
			Boolean requireClientAuth) {
		this.requireClientAuth = requireClientAuth;
		return this;
	}

	@Nonnull
	@Override
	public ServerEncryptionOptions.Builder setRequireEndpointVerification(@Nullable
			Boolean requireEndpointVerification) {
		this.requireEndpointVerification = requireEndpointVerification;
		return this;
	}

	@Nonnull
	@Override
	public ServerEncryptionOptions.Builder setInternodeEncryption(@Nullable
			InternodeEncryption internodeEncryption) {
		this.internodeEncryption = internodeEncryption;
		return this;
	}

	@Nonnull
	@Override
	public ServerEncryptionOptions build() {
		return new ImmutableServerEncryptionOptions(this);
	}


	/**
	 * Immutable implementation of {@link ServerEncryptionOptions}.
	 */
	private static final class ImmutableServerEncryptionOptions
			implements ServerEncryptionOptions {

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
		private final InternodeEncryption internodeEncryption;

		private ImmutableServerEncryptionOptions(ServerEncryptionOptionsBuilder builder) {
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
			this.internodeEncryption = builder.internodeEncryption;
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
		public InternodeEncryption getInternodeEncryption() {
			return this.internodeEncryption;
		}

	}
}
