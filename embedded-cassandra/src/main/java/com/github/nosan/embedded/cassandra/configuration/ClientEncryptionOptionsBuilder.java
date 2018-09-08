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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Simple implementation of {@link ClientEncryptionOptions.Builder}.
 *
 * @author Dmytro Nosan
 */
final class ClientEncryptionOptionsBuilder implements ClientEncryptionOptions.Builder {

	private String keystore;

	private String keystorePassword;

	private String truststore;

	private String truststorePassword;

	private List<String> cipherSuites = new ArrayList<>();

	private String protocol;

	private String algorithm;

	private String storeType;

	private Boolean requireClientAuth;

	private Boolean requireEndpointVerification;

	private Boolean enabled;

	private Boolean optional;


	@Override
	public ClientEncryptionOptions.Builder setKeystore(String keystore) {
		this.keystore = keystore;
		return this;
	}

	@Override
	public ClientEncryptionOptions.Builder setKeystorePassword(String keystorePassword) {
		this.keystorePassword = keystorePassword;
		return this;
	}


	@Override
	public ClientEncryptionOptions.Builder setTruststore(String truststore) {
		this.truststore = truststore;
		return this;
	}

	@Override
	public ClientEncryptionOptions.Builder setTruststorePassword(
			String truststorePassword) {
		this.truststorePassword = truststorePassword;
		return this;
	}


	@Override
	public ClientEncryptionOptions.Builder addCipherSuites(String element) {
		this.cipherSuites.add(element);
		return this;
	}


	@Override
	public ClientEncryptionOptions.Builder addCipherSuites(String... elements) {
		addCipherSuites(Arrays.asList(elements));
		return this;
	}


	@Override
	public ClientEncryptionOptions.Builder setCipherSuites(Iterable<String> elements) {
		this.cipherSuites.clear();
		return addCipherSuites(elements);
	}

	@Override
	public ClientEncryptionOptions.Builder addCipherSuites(Iterable<String> elements) {
		for (String element : elements) {
			this.cipherSuites.add(element);
		}
		return this;
	}

	@Override
	public ClientEncryptionOptions.Builder setProtocol(String protocol) {
		this.protocol = protocol;
		return this;
	}


	@Override
	public ClientEncryptionOptions.Builder setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
		return this;
	}

	@Override
	public ClientEncryptionOptions.Builder setStoreType(String storeType) {
		this.storeType = storeType;
		return this;
	}


	@Override
	public ClientEncryptionOptions.Builder setRequireClientAuth(
			Boolean requireClientAuth) {
		this.requireClientAuth = requireClientAuth;
		return this;
	}


	@Override
	public ClientEncryptionOptions.Builder setRequireEndpointVerification(
			Boolean requireEndpointVerification) {
		this.requireEndpointVerification = requireEndpointVerification;
		return this;
	}


	@Override
	public ClientEncryptionOptions.Builder setEnabled(Boolean enabled) {
		this.enabled = enabled;
		return this;
	}


	@Override
	public ClientEncryptionOptions.Builder setOptional(Boolean optional) {
		this.optional = optional;
		return this;
	}


	@Override
	public ClientEncryptionOptions build() {
		return new ImmutableClientEncryptionOptions(this);
	}

	/**
	 * Immutable implementation of {@link ClientEncryptionOptions}.
	 */
	static final class ImmutableClientEncryptionOptions
			implements ClientEncryptionOptions {
		private final String keystore;

		private final String keystorePassword;

		private final String truststore;

		private final String truststorePassword;

		private final List<String> cipherSuites;

		private final String protocol;

		private final String algorithm;

		private final String storeType;

		private final Boolean requireClientAuth;

		private final Boolean requireEndpointVerification;

		private final Boolean enabled;

		private final Boolean optional;

		private ImmutableClientEncryptionOptions(ClientEncryptionOptionsBuilder builder) {
			this.keystore = builder.keystore;
			this.keystorePassword = builder.keystorePassword;
			this.truststore = builder.truststore;
			this.truststorePassword = builder.truststorePassword;
			this.cipherSuites = Collections.unmodifiableList(builder.cipherSuites);
			this.protocol = builder.protocol;
			this.algorithm = builder.algorithm;
			this.storeType = builder.storeType;
			this.requireClientAuth = builder.requireClientAuth;
			this.requireEndpointVerification = builder.requireEndpointVerification;
			this.enabled = builder.enabled;
			this.optional = builder.optional;
		}


		@Override
		public String getKeystore() {
			return this.keystore;
		}


		@Override
		public String getKeystorePassword() {
			return this.keystorePassword;
		}


		@Override
		public String getTruststore() {
			return this.truststore;
		}

		@Override
		public String getTruststorePassword() {
			return this.truststorePassword;
		}

		@Override
		public List<String> getCipherSuites() {
			return this.cipherSuites;
		}

		@Override
		public String getProtocol() {
			return this.protocol;
		}

		@Override
		public String getAlgorithm() {
			return this.algorithm;
		}


		@Override
		public String getStoreType() {
			return this.storeType;
		}


		@Override
		public Boolean getRequireClientAuth() {
			return this.requireClientAuth;
		}


		@Override
		public Boolean getRequireEndpointVerification() {
			return this.requireEndpointVerification;
		}


		@Override
		public Boolean getEnabled() {
			return this.enabled;
		}


		@Override
		public Boolean getOptional() {
			return this.optional;
		}

	}
}
