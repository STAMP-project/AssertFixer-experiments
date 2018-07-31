/*
 * Copyright 2018 the original author or authors.
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
package org.springframework.vault.core;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.Map;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.vault.VaultException;
import org.springframework.vault.support.VaultResponse;
import org.springframework.vault.support.VaultResponseSupport;
import org.springframework.vault.support.VaultToken;
import org.springframework.vault.support.WrappedMetadata;
import org.springframework.vault.util.IntegrationTestSupport;
import org.springframework.vault.util.Version;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assume.assumeTrue;

/**
 * Integration tests for {@link VaultWrappingTemplate} through
 * {@link VaultWrappingOperations}.
 *
 * @author Mark Paluch
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = VaultIntegrationTestConfiguration.class)
public class VaultWrappingTemplateIntegrationTests extends IntegrationTestSupport {

	private static final Version WRAPPING_ENDPOINT_INTRODUCED_IN_VERSION = Version
			.parse("0.6.2");

	@Autowired
	private VaultOperations vaultOperations;

	private VaultWrappingOperations wrappingOperations;

	private Version vaultVersion;

	@Before
	public void before() {

		wrappingOperations = vaultOperations.opsForWrapping();

		vaultVersion = prepare().getVersion();

		assumeTrue(vaultVersion
				.isGreaterThanOrEqualTo(WRAPPING_ENDPOINT_INTRODUCED_IN_VERSION));
	}

	@Test
	public void shouldCreateWrappedSecret() {

		Map<String, String> map = Collections.singletonMap("key", "value");

		WrappedMetadata metadata = wrappingOperations.wrap(map, Duration.ofSeconds(100));

		assertThat(metadata.getPath()).isEqualTo("sys/wrapping/wrap");
		assertThat(metadata.getTtl()).isEqualTo(Duration.ofSeconds(100));
		assertThat(metadata.getToken()).isNotNull();
		assertThat(metadata.getCreationTime()).isBefore(Instant.now().plusSeconds(60))
				.isAfter(Instant.now().minusSeconds(60));
	}

	@Test
	public void shouldLookupWrappedSecret() {

		Map<String, String> map = Collections.singletonMap("key", "value");

		WrappedMetadata metadata = wrappingOperations.wrap(map, Duration.ofSeconds(100));

		WrappedMetadata lookup = wrappingOperations.lookup(metadata.getToken());

		assertThat(lookup.getPath()).isEqualTo("sys/wrapping/wrap");
		assertThat(lookup.getTtl()).isEqualTo(Duration.ofSeconds(100));
		assertThat(lookup.getToken()).isNotNull();
		assertThat(lookup.getCreationTime()).isBefore(Instant.now().plusSeconds(60))
				.isAfter(Instant.now().minusSeconds(60));
	}

	@Test
	public void shouldReadWrappedSecret() {

		Map<String, String> map = Collections.singletonMap("key", "value");

		WrappedMetadata metadata = wrappingOperations.wrap(map, Duration.ofSeconds(100));
		VaultResponse response = wrappingOperations.read(metadata.getToken());

		assertThat(response.getData())
				.isEqualTo(Collections.singletonMap("key", "value"));
	}

	@Test
	public void shouldReadWrappedTypedSecret() {

		Map<String, String> map = Collections.singletonMap("key", "value");

		WrappedMetadata metadata = wrappingOperations.wrap(map, Duration.ofSeconds(100));
		VaultResponseSupport<Secret> response = wrappingOperations.read(
				metadata.getToken(), Secret.class);

		assertThat(response.getData()).isEqualTo(new Secret("value"));
	}

	@Test
	public void shouldReturnNullForNonExistentSecret() {

		assertThat(wrappingOperations.read(VaultToken.of("foo"))).isNull();
		assertThat(wrappingOperations.read(VaultToken.of("foo"), Map.class)).isNull();
	}

	@Test
	public void shouldLookupAbsentSecret() {

		WrappedMetadata lookup = wrappingOperations.lookup(VaultToken.of("foo"));

		assertThat(lookup).isNull();
	}

	@Test
	public void shouldRewrapSecret() {

		Map<String, String> map = Collections.singletonMap("key", "value");

		WrappedMetadata metadata = wrappingOperations.wrap(map, Duration.ofSeconds(100));

		WrappedMetadata rewrap = wrappingOperations.rewrap(metadata.getToken());

		assertThat(rewrap.getPath()).isEqualTo("sys/wrapping/wrap");
		assertThat(rewrap.getTtl()).isEqualTo(Duration.ofSeconds(100));
		assertThat(rewrap.getToken()).isNotEqualTo(metadata.getToken());
		assertThat(rewrap.getCreationTime()).isBefore(Instant.now().plusSeconds(60))
				.isAfter(Instant.now().minusSeconds(60));
	}

	@Test(expected = VaultException.class)
	public void shouldRewrapAbsentSecret() {
		wrappingOperations.rewrap(VaultToken.of("foo"));
	}

	@Value
	@EqualsAndHashCode
	static class Secret {
		final String key;
	}
}
