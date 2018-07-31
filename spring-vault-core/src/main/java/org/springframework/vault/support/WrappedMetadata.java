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
package org.springframework.vault.support;

import java.time.Duration;
import java.time.Instant;

import org.springframework.util.Assert;

/**
 * Value object representing wrapped secret metadata.
 *
 * @author Mark Paluch
 * @since 2.1
 */
public class WrappedMetadata {

	private final VaultToken token;

	private final Instant creationTime;

	private final String path;

	private final Duration ttl;

	/**
	 * Creates a new {@link WrappedMetadata}.
	 * @param token must not be {@literal null}.
	 * @param ttl must not be {@literal null}.
	 * @param creationTime must not be {@literal null}.
	 * @param path must not be {@literal null}.
	 */
	public WrappedMetadata(VaultToken token, Duration ttl, Instant creationTime,
			String path) {

		Assert.notNull(token, "VaultToken must not be null");
		Assert.notNull(ttl, "TTL duration must not be null");
		Assert.notNull(creationTime, "Creation time must not be null");
		Assert.notNull(path, "Path  must not be null");

		this.token = token;
		this.creationTime = creationTime;
		this.path = path;
		this.ttl = ttl;
	}

	public VaultToken getToken() {
		return token;
	}

	public Instant getCreationTime() {
		return creationTime;
	}

	public String getPath() {
		return path;
	}

	public Duration getTtl() {
		return ttl;
	}
}
