package org.molgenis.data.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.molgenis.util.file.ZipFileUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static java.io.File.separator;

public class FileStore
{
	private final String storageDir;
	private final Path storageDirPath;

	public FileStore(String storageDir)
	{
		this.storageDir = Objects.requireNonNull(storageDir);
		storageDirPath = Paths.get(storageDir).toAbsolutePath();
	}

	public boolean createDirectory(String dirName)
	{
		return new File(storageDir + separator + dirName).mkdirs();
	}

	public void deleteDirectory(String dirName) throws IOException
	{
		FileUtils.deleteDirectory(getFile(dirName));
	}

	public File store(InputStream is, String fileName) throws IOException
	{
		File file = new File(storageDir + separator + fileName);
		try (FileOutputStream fos = new FileOutputStream(file))
		{
			IOUtils.copy(is, fos);
		}
		return file;
	}

	/**
	 * Move directories in FileStore
	 * Pleae provide the path from the relative root of the fileStore
	 * <p>
	 * So if you want to move a top-level  directory the following syntax is sufficient:
	 * <code>
	 * move("dir1", "dir2");
	 * </code>
	 * Sub-level directory can be moved by typing:
	 * <code>
	 * move("dir1/subdir1", "dir2/subdir1");
	 * </code>
	 * Make sure the top-level directories are existing
	 *
	 * @param sourceDir directory yo want to move
	 * @param targetDir target directory you want to move to
	 * @throws IOException
	 */
	public void move(String sourceDir, String targetDir) throws IOException
	{
		Files.move(Paths.get(getStorageDir() + File.separator + sourceDir),
				Paths.get(getStorageDir() + File.separator + targetDir));
	}

	public File getFile(String fileName)
	{
		return new File(storageDir + separator + fileName);
	}

	public boolean delete(String fileName)
	{
		File file = new File(storageDir + separator + fileName);
		return file.delete();
	}

	public String getStorageDir()
	{
		return storageDir;
	}

	public void writeToFile(InputStream inputStream, String fileName) throws IOException
	{
		FileUtils.copyInputStreamToFile(inputStream, getFile(fileName));
	}

	////// Created a couple new methods based on relative Paths rather than Files.

	/**
	 * Deletes a file.
	 *
	 * @param path relative path for the file
	 * @throws IOException              if deletion fails
	 * @throws IllegalArgumentException if the path resolution fails
	 */
	public void delete(Path path) throws IOException
	{
		Files.deleteIfExists(resolve(path));
	}

	/**
	 * Recursively deletes a directory.
	 *
	 * @param path relative path for the directory
	 * @throws IOException              if deletion fails
	 * @throws IllegalArgumentException if the path resolution fails
	 */
	public void deleteDirectory(Path path) throws IOException
	{
		FileUtils.deleteDirectory(resolve(path).toFile());
	}

	/**
	 * Creates a temporary directory with a unique name.
	 * Creates all directories needed in between as well.
	 *
	 * @param path   path where the directory should be created.
	 * @param prefix prefix for the temporary directory name
	 * @return Path of the created directory
	 * @throws IOException              if the file creation fails
	 * @throws IllegalArgumentException if the path resolution fails
	 */
	public Path createTempDirectory(Path path, String prefix) throws IOException
	{
		Path parent = resolve(path);
		Files.createDirectories(parent);
		Path result = Files.createTempDirectory(parent, prefix);
		return storageDirPath.relativize(result);
	}

	/**
	 * Unpacks a zipfile to a directory.
	 *
	 * @param is   InputStream containing the zip file contents
	 * @param path path of the directory where the zip file should be unpacked
	 * @throws org.molgenis.util.file.UnzipException if something goes wrong unzipping the file
	 */
	public void unpack(InputStream is, Path path)
	{
		File file = resolve(path).toFile();
		ZipFileUtil.unzip(is, file);
	}

	/**
	 * Checks if a path exists.
	 *
	 * @param path Path to check
	 * @return boolean indicating if a file or directory exists at the given path
	 */
	public boolean exists(Path path)
	{
		return resolve(path).toFile().exists();
	}

	/**
	 * Moves one relative path to another.
	 *
	 * @param from the relative path to move from
	 * @param to   the relative path to move to
	 * @throws IOException              if the move operation fails
	 * @throws IllegalArgumentException if either path cannot be resolved
	 */
	public void move(Path from, Path to) throws IOException
	{
		Files.move(resolve(from), resolve(to));
	}

	/**
	 * Streams file content.
	 *
	 * @param path the relative path for the file
	 * @return InputStream for the file contents
	 * @throws IOException if an IO operation fails
	 */
	public InputStream streamFileContent(Path path) throws IOException
	{
		return Files.newInputStream(resolve(path));
	}

	private Path resolve(Path path)
	{
		if (path.isAbsolute())
		{
			throw new IllegalArgumentException("Path should be relative: " + path);
		}
		Path result = storageDirPath.resolve(path).normalize().toAbsolutePath();
		if (!result.startsWith(storageDirPath))
		{
			throw new IllegalArgumentException("Path should be inside storage dir: " + path);
		}
		return result;
	}
}
