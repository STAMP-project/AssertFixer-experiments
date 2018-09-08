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

import java.util.List;

/**
 * Client-to-node encryption protects data in flight from client machines to a database cluster using SSL (Secure
 * Sockets Layer). It establishes a secure channel between the client and the coordinator node.
 *
 * @author Dmytro Nosan
 */
public interface ClientEncryptionOptions {

	/**
	 * The location of a Java keystore (JKS) suitable for use with Java Secure Socket Extension (JSSE), which is the
	 * Java version of the Secure Sockets Layer (SSL), and Transport Layer Security (TLS) protocols. The keystore
	 * contains the private key used to encrypt outgoing messages.
	 *
	 * @return The value of the {@code keystore} attribute
	 */
	String getKeystore();

	/**
	 * Password for the keystore. This must match the password used when generating the keystore and truststore.
	 *
	 * @return The value of the {@code keystorePassword} attribute
	 */
	String getKeystorePassword();

	/**
	 * Location of the truststore.
	 *
	 * @return The value of the {@code trustore} attribute
	 */
	String getTruststore();

	/**
	 * Password for the truststore.
	 *
	 * @return The value of the {@code trustorePassword} attribute
	 */
	String getTruststorePassword();

	/**
	 * List of cipher suites.
	 *
	 * @return The value of the {@code cipherSuites} attribute
	 */
	List<String> getCipherSuites();

	/**
	 * Protocol to use.
	 *
	 * @return The value of the {@code protocol} attribute
	 */
	String getProtocol();

	/**
	 * Algorithm to use.
	 *
	 * @return The value of the {@code algorithm} attribute
	 */
	String getAlgorithm();

	/**
	 * Store type.
	 *
	 * @return The value of the {@code storeType} attribute
	 */
	String getStoreType();

	/**
	 * Enables or disables certificate authentication.
	 *
	 * @return The value of the {@code requireClientAuth} attribute
	 */
	Boolean getRequireClientAuth();

	/**
	 * Enables or disables host name verification.
	 *
	 * @return The value of the {@code requireEndpointVerification} attribute
	 */
	Boolean getRequireEndpointVerification();

	/**
	 * Whether encryption is enabled or not.
	 *
	 * @return The value of the {@code enabled} attribute
	 */
	Boolean getEnabled();

	/**
	 * If enabled and optional is set to true encrypted and unencrypted connections are handled.
	 *
	 * @return The value of the {@code optional} attribute
	 */
	Boolean getOptional();

	static Builder builder() {
		return new ClientEncryptionOptionsBuilder();
	}

	/**
	 * Builds instances of type {@link ClientEncryptionOptions ClientEncryptionOptions}. Initialize attributes and then
	 * invoke the {@link #build()} method to create an instance.
	 * <p><em>{@code ClientEncryptionOptionsBuilder} is not thread-safe and generally should not be stored in a field
	 * or
	 * collection, but instead used immediately to create instances.</em>
	 *
	 * @author Dmytro Nosan
	 */
	interface Builder {

		/**
		 * Initializes the value for the {@link ClientEncryptionOptions#getKeystore() keystore} attribute.
		 *
		 * @param keystore The value for keystore (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setKeystore(String keystore);

		/**
		 * Initializes the value for the {@link ClientEncryptionOptions#getKeystorePassword() keystorePassword}
		 * attribute.
		 *
		 * @param keystorePassword The value for keystorePassword (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setKeystorePassword(String keystorePassword);

		/**
		 * Initializes the value for the {@link ClientEncryptionOptions#getTruststore() truststore} attribute.
		 *
		 * @param truststore The value for truststore (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setTruststore(String truststore);

		/**
		 * Initializes the value for the {@link ClientEncryptionOptions#getTruststorePassword() truststorePassword}
		 * attribute.
		 *
		 * @param truststorePassword The value for truststorePassword (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setTruststorePassword(String truststorePassword);

		/**
		 * Adds one element to {@link ClientEncryptionOptions#getCipherSuites() cipherSuites} list.
		 *
		 * @param element A cipherSuites element
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder addCipherSuites(String element);

		/**
		 * Adds elements to {@link ClientEncryptionOptions#getCipherSuites() cipherSuites} list.
		 *
		 * @param elements An array of cipherSuites elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder addCipherSuites(String... elements);


		/**
		 * Sets or replaces all elements for {@link ClientEncryptionOptions#getCipherSuites() cipherSuites} list.
		 *
		 * @param elements An iterable of cipherSuites elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setCipherSuites(Iterable<String> elements);

		/**
		 * Adds elements to {@link ClientEncryptionOptions#getCipherSuites() cipherSuites} list.
		 *
		 * @param elements An iterable of cipherSuites elements
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder addCipherSuites(Iterable<String> elements);

		/**
		 * Initializes the value for the {@link ClientEncryptionOptions#getProtocol() protocol} attribute.
		 *
		 * @param protocol The value for protocol (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setProtocol(String protocol);

		/**
		 * Initializes the value for the {@link ClientEncryptionOptions#getAlgorithm() algorithm} attribute.
		 *
		 * @param algorithm The value for algorithm (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setAlgorithm(String algorithm);

		/**
		 * Initializes the value for the {@link ClientEncryptionOptions#getStoreType() storeType} attribute.
		 *
		 * @param storeType The value for storeType (can be {@code null})
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setStoreType(String storeType);

		/**
		 * Initializes the value for the {@link ClientEncryptionOptions#getRequireClientAuth() requireClientAuth}
		 * attribute.
		 *
		 * @param requireClientAuth The value for requireClientAuth
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRequireClientAuth(Boolean requireClientAuth);

		/**
		 * Initializes the value for the {@link ClientEncryptionOptions#getRequireEndpointVerification()
		 * requireEndpointVerification} attribute.
		 *
		 * @param requireEndpointVerification The value for requireEndpointVerification
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setRequireEndpointVerification(Boolean requireEndpointVerification);

		/**
		 * Initializes the value for the {@link ClientEncryptionOptions#getEnabled() enabled} attribute.
		 *
		 * @param enabled The value for enabled
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setEnabled(Boolean enabled);

		/**
		 * Initializes the value for the {@link ClientEncryptionOptions#getOptional() optional} attribute.
		 *
		 * @param optional The value for optional
		 * @return {@code this} builder for use in a chained invocation
		 */
		Builder setOptional(Boolean optional);

		/**
		 * Builds a new {@link ClientEncryptionOptions ClientEncryptionOptions}.
		 *
		 * @return An instance of ClientEncryptionOptions
		 */
		ClientEncryptionOptions build();

	}

}
