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

import java.util.Collection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Node-to-node encryption protects data transferred between nodes in a cluster, including gossip communications, using
 * SSL (Secure Sockets Layer).
 *
 * @author Dmytro Nosan
 */
public interface ServerEncryptionOptions {

	/**
	 * The location of a Java keystore (JKS) suitable for use with Java Secure Socket Extension (JSSE), which is the
	 * Java version of the Secure Sockets Layer (SSL), and Transport Layer Security (TLS) protocols. The keystore
	 * contains the private key used to encrypt outgoing messages.
	 *
	 * @return The value of the {@code keystore} attribute
	 */
	@Nullable
	String getKeystore();

	/**
	 * Password for the keystore. This must match the password used when generating the keystore and truststore.
	 *
	 * @return The value of the {@code keystorePassword} attribute
	 */
	@Nullable
	String getKeystorePassword();

	/**
	 * Location of the truststore.
	 *
	 * @return The value of the {@code trustore} attribute
	 */
	@Nullable
	String getTruststore();

	/**
	 * Password for the truststore.
	 *
	 * @return The value of the {@code trustorePassword} attribute
	 */
	@Nullable
	String getTruststorePassword();

	/**
	 * Collection of cipher suites.
	 *
	 * @return The value of the {@code cipherSuites} attribute
	 */
	@Nullable
	Collection<String> getCipherSuites();

	/**
	 * Protocol to use.
	 *
	 * @return The value of the {@code protocol} attribute
	 */
	@Nullable
	String getProtocol();

	/**
	 * Algorithm to use.
	 *
	 * @return The value of the {@code algorithm} attribute
	 */
	@Nullable
	String getAlgorithm();

	/**
	 * Store type.
	 *
	 * @return The value of the {@code storeType} attribute
	 */
	@Nullable
	String getStoreType();

	/**
	 * Enables or disables certificate authentication.
	 *
	 * @return The value of the {@code requireClientAuth} attribute
	 */
	@Nullable
	Boolean getRequireClientAuth();

	/**
	 * Enables or disables host name verification.
	 *
	 * @return The value of the {@code requireEndpointVerification} attribute
	 */
	@Nullable
	Boolean getRequireEndpointVerification();

	/**
	 * Policy for internode encryption.
	 *
	 * @return The value of the {@code internodeEncryption} attribute
	 */
	@Nullable
	InternodeEncryption getInternodeEncryption();

	/**
	 * Create a new builder to build a {@link ServerEncryptionOptions}.
	 *
	 * @return a fresh {@code Builder}.
	 */
	@Nonnull
	static Builder builder() {
		return new ServerEncryptionOptionsBuilder();
	}

	/**
	 * Builds instances of type {@link ServerEncryptionOptions ServerEncryptionOptions}. Initialize attributes and then
	 * invoke the {@link #build()} method to create an instance.
	 * <p><em>{@code ServerEncryptionOptionsBuilder} is not thread-safe and generally should not be stored in a field
	 * or
	 * collection, but instead used immediately to create instances.</em>
	 *
	 * @author Dmytro Nosan
	 */
	interface Builder {

		/**
		 * Initializes the value for the {@link ServerEncryptionOptions#getKeystore() keystore} attribute.
		 *
		 * @param keystore The value for keystore
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setKeystore(@Nullable String keystore);

		/**
		 * Initializes the value for the {@link ServerEncryptionOptions#getKeystorePassword() keystorePassword}
		 * attribute.
		 *
		 * @param keystorePassword The value for keystorePassword
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setKeystorePassword(@Nullable String keystorePassword);

		/**
		 * Initializes the value for the {@link ServerEncryptionOptions#getTruststore() truststore} attribute.
		 *
		 * @param truststore The value for truststore
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setTruststore(@Nullable String truststore);

		/**
		 * Initializes the value for the {@link ServerEncryptionOptions#getTruststorePassword() truststorePassword}
		 * attribute.
		 *
		 * @param truststorePassword The value for truststorePassword
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setTruststorePassword(@Nullable String truststorePassword);

		/**
		 * Adds ciphers to {@link ServerEncryptionOptions#getCipherSuites() cipherSuites} list.
		 *
		 * @param ciphers An array of cipherSuites elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder addCipherSuites(@Nullable String... ciphers);

		/**
		 * Sets or replaces all ciphers for {@link ServerEncryptionOptions#getCipherSuites() cipherSuites} list.
		 *
		 * @param ciphers A collection of cipherSuites elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setCipherSuites(@Nullable Collection<String> ciphers);

		/**
		 * Adds ciphers to {@link ServerEncryptionOptions#getCipherSuites() cipherSuites} list.
		 *
		 * @param ciphers A collection of cipherSuites elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder addCipherSuites(@Nullable Collection<String> ciphers);

		/**
		 * Initializes the value for the {@link ServerEncryptionOptions#getProtocol() protocol} attribute.
		 *
		 * @param protocol The value for protocol
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setProtocol(@Nullable String protocol);

		/**
		 * Initializes the value for the {@link ServerEncryptionOptions#getAlgorithm() algorithm} attribute.
		 *
		 * @param algorithm The value for algorithm
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setAlgorithm(@Nullable String algorithm);

		/**
		 * Initializes the value for the {@link ServerEncryptionOptions#getStoreType() storeType} attribute.
		 *
		 * @param storeType The value for storeType
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setStoreType(@Nullable String storeType);

		/**
		 * Initializes the value for the {@link ServerEncryptionOptions#getRequireClientAuth() requireClientAuth}
		 * attribute.
		 *
		 * @param requireClientAuth The value for requireClientAuth
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setRequireClientAuth(@Nullable Boolean requireClientAuth);

		/**
		 * Initializes the value for the {@link ServerEncryptionOptions#getRequireEndpointVerification()
		 * requireEndpointVerification} attribute.
		 *
		 * @param requireEndpointVerification The value for requireEndpointVerification
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setRequireEndpointVerification(@Nullable Boolean requireEndpointVerification);

		/**
		 * Initializes the value for the {@link ServerEncryptionOptions#getInternodeEncryption() internodeEncryption}
		 * attribute.
		 *
		 * @param internodeEncryption The value for internodeEncryption
		 * @return {@code this} builder for use in a chained invocation
		 */
		@Nonnull
		Builder setInternodeEncryption(@Nullable InternodeEncryption internodeEncryption);

		/**
		 * Builds a new {@link ServerEncryptionOptions ServerEncryptionOptions}.
		 *
		 * @return An instance of ServerEncryptionOptions
		 */
		@Nonnull
		ServerEncryptionOptions build();
	}
}
