package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StorageFileSystemFactory;
import org.dimyriy.vfs.impl.exceptions.FileSystemAlreadyExistsInCacheException;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.util.PlatformFileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Creates and holds references to all InfileFileSystems.
 * Note that it's generally not a good idea to have multiple instances of this class.
 * It's the caller responsibility to make sure that application creates only one instance of {@link InfileFileSystemFactory}.
 *
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
@SuppressWarnings("WeakerAccess")
@ThreadSafe
public class InfileFileSystemFactory implements StorageFileSystemFactory {
  private static final Logger LOGGER = LoggerFactory.getLogger(InfileFileSystem.class);
  @GuardedBy("this")
  private final Map<String, InfileFileSystem> fsCache = new ConcurrentHashMap<>();


  @Override
  public synchronized InfileFileSystem loadFileSystemFromCache(@Nonnull final String absolutePathToParentDirectory, final String filename) {
    LOGGER.info("Loading FS for parent folder {} and filename {} from cache", absolutePathToParentDirectory, filename);
    final Path path = Paths.get(absolutePathToParentDirectory);
    Assertions.pathIsAbsolute(path);
    final InfileFileSystem fs = getFromCache(filename, path);
    if (fs == null) {
      LOGGER.info("FS for parent folder {} and filename {} not found in cache", absolutePathToParentDirectory, filename);
    }
    LOGGER.info("Returning FS for parent folder {} and filename {} found in cache", absolutePathToParentDirectory, filename);
    return fs;
  }

  @Override
  public synchronized InfileFileSystem loadFileSystemFromFile(@Nonnull final String absolutePathToParentDirectory,
                                                              @Nonnull final String filename,
                                                              final boolean forceUnlock) {
    LOGGER.info("Loading FS from parent folder {}, filename {} from existing file with forceUnlock {}", absolutePathToParentDirectory, filename, forceUnlock);
    final Storage.Configuration configuration = new Storage.Configuration().loadExisting().forceFileUnlock(forceUnlock);
    return createFileSystem(absolutePathToParentDirectory, filename, configuration);
  }

  @Override
  public synchronized InfileFileSystem createNewFileSystem(@Nonnull final String absolutePathToParentDirectory,
                                                           @Nonnull final String filename,
                                                           final int numberOfClusters) {
    LOGGER.info("Creating new FS in folder {}, filename {} with numberOfClusters {}", absolutePathToParentDirectory, filename, numberOfClusters);
    final Storage.Configuration configuration = new Storage.Configuration().createNew().withNumberOfClusters(numberOfClusters);
    return putToCache(createFileSystem(absolutePathToParentDirectory, filename, configuration));
  }

  private InfileFileSystem getFromCache(@Nonnull final String filename, @Nonnull final Path path) {
    return fsCache.get(PlatformFileUtil.toAbsolutePath(path.toAbsolutePath().toString(), filename));
  }

  private InfileFileSystem putToCache(@Nonnull final InfileFileSystem fileSystem) {
    fsCache.put(fileSystem.getAbsoluteFullPathOfStorageFile(), fileSystem);
    return fileSystem;
  }

  private InfileFileSystem createFileSystem(@Nonnull final String absolutePathToParentDirectory,
                                            @Nonnull final String filename,
                                            @Nonnull final Storage.Configuration configuration) {
    final InfileFileSystem infileFileSystem = loadFileSystemFromCache(absolutePathToParentDirectory, filename);
    if (infileFileSystem != null) {
      throw new FileSystemAlreadyExistsInCacheException();
    }
    final Storage storage = new Storage(PlatformFileUtil.createRegularFileInstance(absolutePathToParentDirectory, filename), configuration);
    return new InfileFileSystem(storage);
  }
}
