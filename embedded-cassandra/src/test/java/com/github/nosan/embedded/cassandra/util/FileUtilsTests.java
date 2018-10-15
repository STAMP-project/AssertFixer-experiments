/*
 * Copyright 2018-2018 the original author or authors.
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

package com.github.nosan.embedded.cassandra.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link FileUtils}.
 *
 * @author Dmytro Nosan
 */
public class FileUtilsTests {

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public void deleteFile() throws IOException {
		File file = this.temporaryFolder.newFile();
		assertThat(file).exists();
		assertThat(FileUtils.delete(file.toPath())).isTrue();
		assertThat(file).doesNotExist();
	}

	@Test
	public void deleteRecursivelyFolder() throws IOException {
		File newFolder = this.temporaryFolder.newFolder();
		File dir = new File(newFolder, "dir");
		File file = new File(dir, "file.txt");

		assertThat(dir.mkdir()).isTrue();
		assertThat(file.createNewFile()).isTrue();

		assertThat(FileUtils.delete(newFolder.toPath())).isTrue();
		assertThat(dir).doesNotExist();
		assertThat(file).doesNotExist();


	}

	@Test
	public void shouldNotDelete() throws IOException {
		assertThat(FileUtils.delete(Paths.get(UUID.randomUUID().toString()))).isFalse();
		assertThat(FileUtils.delete(null)).isFalse();
	}

	@Test
	public void shouldBeTemporary() throws IOException {
		assertThat(FileUtils.isTemporary(this.temporaryFolder.newFolder().toPath()))
				.isTrue();
		assertThat(FileUtils.isTemporary(this.temporaryFolder.newFile().toPath()))
				.isTrue();
	}

	@Test
	public void shouldNotBeTemporary() {
		assertThat(FileUtils.isTemporary(null)).isFalse();
		assertThat(FileUtils.isTemporary(new File("").toPath()))
				.isFalse();
	}

	@Test
	public void userDirectory() {
		assertThat(FileUtils.getUserDirectory())
				.isEqualTo(Paths.get(new SystemProperty("user.dir").get()));
	}

	@Test
	public void userHomeDirectory() {
		assertThat(FileUtils.getUserHomeDirectory())
				.isEqualTo(Paths.get(new SystemProperty("user.home").get()));
	}


	@Test
	public void tmpDirectory() {
		assertThat(FileUtils.getTmpDirectory())
				.isEqualTo(Paths.get(new SystemProperty("java.io.tmpdir").get()));
	}
}
