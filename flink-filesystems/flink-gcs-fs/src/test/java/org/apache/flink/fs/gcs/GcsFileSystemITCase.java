/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.fs.gcs;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.core.fs.FSDataInputStream;
import org.apache.flink.core.fs.FSDataOutputStream;
import org.apache.flink.core.fs.FileSystem;
import org.apache.flink.core.fs.FileSystem.WriteMode;
import org.apache.flink.core.fs.Path;
import org.apache.flink.util.TestLogger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for the File System to GCS.
 *
 * <p>This test can only run when the required credentials for the "gs://flink-it-cases" bucket
 * have been set up.
 */
public class GcsFileSystemITCase extends TestLogger {

	private static final String BUCKET = "flink-it-cases";
	private static final String TEST_DATA_DIR = "tests-" + UUID.randomUUID();
	private static final Path BASE_DIR = new Path("gs://" + BUCKET + '/' + TEST_DATA_DIR);

	private static boolean cleanUp;

	@BeforeClass
	public static void checkAccess() throws IOException {
		final FileSystem fs = BASE_DIR.getFileSystem();

		assertFalse(fs.exists(BASE_DIR));
		assertTrue(fs.mkdirs(BASE_DIR));

		cleanUp = true;
	}

	@AfterClass
	public static void cleanUp() throws Exception {
		if (cleanUp) {
			BASE_DIR.getFileSystem().delete(BASE_DIR, true);
		}

		// reset configuration
		FileSystem.initialize(new Configuration());
	}

	@Test
	public void testSimpleFileWriteAndRead() throws Exception {
		final Path path = new Path(BASE_DIR, "test-" + UUID.randomUUID() + ".txt");
		final FileSystem fs = path.getFileSystem();

		final String testLine = "Hello GCS - Happy to meet you!";

		try (FSDataOutputStream out = fs.create(path, WriteMode.OVERWRITE);
					OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8)) {
				writer.write(testLine);
		}

		assertTrue(fs.exists(path));

		try (FSDataInputStream in = fs.open(path);
					InputStreamReader ir = new InputStreamReader(in, StandardCharsets.UTF_8);
					BufferedReader reader = new BufferedReader(ir)) {

			String line = reader.readLine();
			assertEquals(testLine, line);
		}

		fs.delete(path, false);
		assertFalse(fs.exists(path));
	}
}
