package org.molgenis.util.file;

import org.zeroturnaround.zip.NameMapper;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ZipFileUtil
{
	private ZipFileUtil()
	{
	}

	public static void unzip(InputStream is, File outputDir)
	{
		try
		{
			ZipUtil.unpack(is, outputDir);
		}
		catch (Exception ex)
		{
			throw new UnzipException(ex);
		}
	}

	/**
	 * Unzips a zipfile into the directory it resides in.
	 * Skips files starting with '.' or '_' (typically hidden files).
	 *
	 * @param file the file to unzip
	 * @return List of Files that got extracted
	 * @throws UnzipException if something went wrong
	 */
	public static List<File> unzip(File file)
	{
		return unzip(file, name -> name.startsWith(".") || name.startsWith("_") ? null : name);
	}

	/**
	 * Unzips a zipfile into the directory it resides in.
	 *
	 * @param file       the zipfile to unzip
	 * @param nameMapper the {@link NameMapper} to use when unzipping
	 * @return List of Files that got extracted
	 * @throws UnzipException if something went wrong
	 */
	public static List<File> unzip(File file, NameMapper nameMapper)
	{
		try
		{
			List<File> unzippedFiles = new ArrayList<>();
			File parentFile = file.getParentFile();
			Path parentPath = parentFile.toPath();
			ZipUtil.unpack(file, parentFile, name ->
			{
				String mappedName = nameMapper.map(name);
				unzippedFiles.add(parentPath.resolve(mappedName).toFile());
				return mappedName;
			});
			return unzippedFiles;
		}
		catch (Exception ex)
		{
			throw new UnzipException(ex);
		}
	}
}