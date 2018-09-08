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
import java.util.Collections;
import java.util.List;


/**
 * Simple implementation of {@link ServerEncryptionOptions.Builder}.
 *
 * @author Dmytro Nosan
 */
final class ServerEncryptionOptionsBuilder implements ServerEncryptionOptions.Builder {

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

	private InternodeEncryption internodeEncryption;

	@Override
	public ServerEncryptionOptions.Builder setKeystore(String keystore) {
		this.keystore = keystore;
		return this;
	}

	@Override
	public ServerEncryptionOptions.Builder setKeystorePassword(String keystorePassword) {
		this.keystorePassword = keystorePassword;
		return this;
	}

	@Override
	public ServerEncryptionOptions.Builder setTruststore(String truststore) {
		this.truststore = truststore;
		return this;
	}

	@Override
	public ServerEncryptionOptions.Builder setTruststorePassword(
			String truststorePassword) {
		this.truststorePassword = truststorePassword;
		return this;
	}

	@Override
	public ServerEncryptionOptions.Builder addCipherSuites(String element) {
		this.cipherSuites.add(element);
		return this;
	}

	@Override
	public ServerEncryptionOptions.Builder addCipherSuites(String... elements) {
		for (String element : elements) {
			this.cipherSuites.add(element);
		}
		return this;
	}

	@Override
	public ServerEncryptionOptions.Builder setCipherSuites(Iterable<String> elements) {
		this.cipherSuites.clear();
		return addCipherSuites(elements);
	}

	@Override
	public ServerEncryptionOptions.Builder addCipherSuites(Iterable<String> elements) {
		for (String element : elements) {
			this.cipherSuites.add(element);
		}
		return this;
	}

	@Override
	public ServerEncryptionOptions.Builder setProtocol(String protocol) {
		this.protocol = protocol;
		return this;
	}

	@Override
	public ServerEncryptionOptions.Builder setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
		return this;
	}

	@Override
	public ServerEncryptionOptions.Builder setStoreType(String storeType) {
		this.storeType = storeType;
		return this;
	}

	@Override
	public ServerEncryptionOptions.Builder setRequireClientAuth(
			Boolean requireClientAuth) {
		this.requireClientAuth = requireClientAuth;
		return this;
	}

	@Override
	public ServerEncryptionOptions.Builder setRequireEndpointVerification(
			Boolean requireEndpointVerification) {
		this.requireEndpointVerification = requireEndpointVerification;
		return this;
	}

	@Override
	public ServerEncryptionOptions.Builder setInternodeEncryption(
			InternodeEncryption internodeEncryption) {
		this.internodeEncryption = internodeEncryption;
		return this;
	}

	@Override
	public ServerEncryptionOptions build() {
		return new ImmutableServerEncryptionOptions(this);
	}

	/**
	 * Immutable implementation of {@link ServerEncryptionOptions}.
	 */
	static final class ImmutableServerEncryptionOptions
			implements ServerEncryptionOptions {
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

		private final InternodeEncryption internodeEncryption;

		private ImmutableServerEncryptionOptions(ServerEncryptionOptionsBuilder builder) {
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
			this.internodeEncryption = builder.internodeEncryption;
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
		public InternodeEncryption getInternodeEncryption() {
			return this.internodeEncryption;
		}

	}
}
