package org.molgenis.data.file;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.io.File.separator;
import static org.testng.Assert.*;

public class FileStoreTest
{
	private FileStore fileStore;
	private File tempDir;

	@BeforeMethod
	public void beforeMethod() throws IOException
	{
		tempDir = Files.createTempDir();
		fileStore = new FileStore(tempDir.getCanonicalPath());
	}

	@AfterMethod
	public void afterMethod() throws IOException
	{
		FileUtils.deleteDirectory(tempDir);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void testConstructor()
	{
		new FileStore(null);
	}

	@Test
	public void testCreateDirectory()
	{
		assertTrue(fileStore.createDirectory("testDir"));
		assertTrue(fileStore.getFile("testDir").isDirectory());
		fileStore.delete("testDir");
	}

	@Test
	public void testStore() throws IOException
	{
		File file = fileStore.store(new ByteArrayInputStream(new byte[] { 1, 2, 3 }), "bytes.bin");
		Assert.assertEquals(FileUtils.readFileToByteArray(file), new byte[] { 1, 2, 3 });
	}

	@Test
	public void testMoveTopLevelDir() throws IOException
	{
		assertTrue(fileStore.createDirectory("testDir1"));
		fileStore.store(new ByteArrayInputStream(new byte[] { 1, 2, 3 }), "testDir1" + separator + "bytes.bin");
		fileStore.move("testDir1", "testDir2");
		File file = fileStore.getFile("testDir2" + separator + "bytes.bin");
		Assert.assertEquals(FileUtils.readFileToByteArray(file), new byte[] { 1, 2, 3 });
	}

	@Test
	public void testMoveSubLevelDir() throws IOException
	{
		assertTrue(fileStore.createDirectory("testDir1" + separator + "testDir2"));
		assertTrue(fileStore.createDirectory("testDir2"));
		fileStore.store(new ByteArrayInputStream(new byte[] { 1, 2, 3 }),
				"testDir1" + separator + "testDir2" + separator + "bytes.bin");
		fileStore.move("testDir1" + separator + "testDir2", "testDir2" + separator + "testDir3");
		File file = fileStore.getFile("testDir2" + separator + "testDir3" + separator + "bytes.bin");
		Assert.assertEquals(FileUtils.readFileToByteArray(file), new byte[] { 1, 2, 3 });
	}

	@Test
	public void testGetFile() throws IOException
	{
		String fileName = "bytes.bin";
		File file = fileStore.store(new ByteArrayInputStream(new byte[] { 1, 2, 3 }), fileName);
		Assert.assertEquals(fileStore.getFile(fileName).getAbsolutePath(), file.getAbsolutePath());
	}

	@Test
	public void testDeletePath() throws IOException
	{
		String fileName = "bytes.bin";
		File file = fileStore.store(new ByteArrayInputStream(new byte[] { 1, 2, 3 }), fileName);
		assertTrue(file.exists());

		fileStore.delete(Paths.get("bytes.bin"));

		assertFalse(file.exists());
	}

	@Test
	public void testDeleteDirectoryPath() throws IOException
	{
		fileStore.createDirectory("dir");
		Path dir = Paths.get("dir");
		Path relativeTmpDirPath = fileStore.createTempDirectory(dir, "blah");

		assertTrue(fileStore.exists(relativeTmpDirPath));

		fileStore.deleteDirectory(relativeTmpDirPath);

		assertFalse(fileStore.exists(relativeTmpDirPath));
		assertTrue(fileStore.exists(dir));
	}

	@Test
	public void testUnpack()
	{
		InputStream is = getClass().getResourceAsStream("/valid-app.zip");
		assertNotNull(is);
		Path path = Paths.get("testUnpack");
		fileStore.unpack(is, path);
		assertTrue(fileStore.exists(path.resolve("index.html")));
		assertTrue(fileStore.exists(path.resolve("config.json")));
	}

	@Test(expectedExceptions = org.molgenis.util.file.UnzipException.class, expectedExceptionsMessageRegExp = ".*trying to leave the target output directory.*")
	public void testUnpackInvalidZip()
	{
		InputStream is = getClass().getResourceAsStream("/flip.zip");
		Path path = Paths.get("testUnpackInvalidZip");
		fileStore.unpack(is, path);
	}

	@Test
	public void testMove() throws IOException
	{
		fileStore.store(getClass().getResourceAsStream("/valid-app.zip"), "from");
		assertTrue(fileStore.exists(Paths.get("from")));

		fileStore.move(Paths.get("from"), Paths.get("to"));

		assertFalse(fileStore.exists(Paths.get("from")));
		assertTrue(fileStore.exists(Paths.get("to")));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testResolveAbsolute() throws IOException
	{
		fileStore.streamFileContent(Paths.get("/blah"));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testResolveOutside() throws IOException
	{
		fileStore.streamFileContent(Paths.get("../blah"));
	}

	@Test
	public void testStreamFileContent() throws IOException
	{
		fileStore.store(new StringBufferInputStream("blah"), "stored");

		InputStream is = fileStore.streamFileContent(Paths.get("stored"));
		Scanner scanner = new Scanner(new BufferedInputStream(is));
		assertEquals(scanner.nextLine(), "blah");
	}
}
