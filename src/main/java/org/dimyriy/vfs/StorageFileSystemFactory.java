package org.dimyriy.vfs;

import org.dimyriy.vfs.impl.constants.StorageConstants;
import org.dimyriy.vfs.impl.exceptions.FileSystemLockedByAnotherProcessException;
import org.dimyriy.vfs.impl.exceptions.InitializationException;

import javax.annotation.Nonnull;

/**
 * @author Dmitrii Bogdanov
 * Created at 26.09.18
 */
public interface StorageFileSystemFactory {

  /**
   * Load previously created {@link StorageFileSystem} from cache.
   *
   * @param absolutePathToParentDirectory Absolute path of parent directory for underlying storage file.
   * @param filename                      Filename of underlying storage file.
   * @return Previously created instance of fully initialized {@link StorageFileSystem} from if it exists in cache, otherwise returns {@code null}.
   */
  StorageFileSystem loadFileSystemFromCache(@Nonnull final String absolutePathToParentDirectory, final String filename);

  /**
   * Load {@link StorageFileSystem} from already existing storage file specified by {@code absolutePathToParentDirectory} and filename.
   *
   * @param absolutePathToParentDirectory Absolute path of parent for underlying storage file.
   * @param filename                      Filename of underlying storage file.
   * @param forceUnlock                   When true, forcibly acquires the underlying storage file lock regardless of whether it's locked by another process or not.
   * @return Instance of fully initialized {@link StorageFileSystem}
   * @throws InitializationException                   if filesystem for this path already exists in cache.
   * @throws InitializationException                   if specified {@code absolutePathToParentDirectory} is not absolute path.
   * @throws FileSystemLockedByAnotherProcessException if filesystem stored in the specified file already locked by other process.
   */
  StorageFileSystem loadFileSystemFromFile(@Nonnull final String absolutePathToParentDirectory,
                                           @Nonnull final String filename,
                                           final boolean forceUnlock);

  /**
   * Load {@link StorageFileSystem} from already existing storage file specified by {@code absolutePathToParentDirectory} and filename.
   *
   * @param absolutePathToParentDirectory Absolute path of parent for underlying storage file.
   * @param filename                      Filename of underlying storage file.
   * @param fsSizeInBytes                 FS size in bytes (should be divisible by clusterSize).
   * @param clusterSize                   Cluster size in bytes.
   * @return Instance of fully initialized {@link StorageFileSystem}
   * @throws InitializationException                   if filesystem for this path already exists in cache.
   * @throws InitializationException                   if specified {@code absolutePathToParentDirectory} is not absolute path.
   * @throws InitializationException                   if specified {@code fsSizeInBytes} is not divisible by specified {@code clusterSize}.
   * @throws InitializationException                   if the resulting number of clusters in FS ({@code fsSizeInBytes/clusterSize}) is greater than
   *                                                   {@link Integer#MAX_VALUE}.
   * @throws InitializationException                   if specified {@code absolutePathToParentDirectory} is not absolute path.
   * @throws FileSystemLockedByAnotherProcessException if filesystem stored in the specified file already locked by other process.
   */
  StorageFileSystem createNewFileSystemOfSizeInBytes(@Nonnull String absolutePathToParentDirectory,
                                                     @Nonnull String filename,
                                                     long fsSizeInBytes,
                                                     int clusterSize);

  /**
   * Creates new {@link StorageFileSystem} with default cluster size {@link StorageConstants#getDefaultClusterSizeInBytes()} backed by a file specified by {@code absolutePathToParentDirectory}.
   *
   * @param absolutePathToParentDirectory Absolute path of parent directory for underlying storage file.
   * @param filename                      Filename of underlying storage file.
   * @param numberOfClusters              Number of clusters of {@link }in a file system.
   * @return Instance of fully initialized {@link StorageFileSystem}
   * @throws InitializationException if filesystem for this path already exists in cache
   * @throws InitializationException if specified {@code absolutePathToParentDirectory} is not absolute path.
   */
  StorageFileSystem createNewFileSystem(@Nonnull final String absolutePathToParentDirectory,
                                        @Nonnull final String filename,
                                        final int numberOfClusters);

  /**
   * Creates new {@link StorageFileSystem} backed by a file specified by {@code absolutePathToParentDirectory}.
   *
   * @param absolutePathToParentDirectory Absolute path of parent directory for underlying storage file.
   * @param filename                      Filename of underlying storage file.
   * @param numberOfClusters              Number of clusters of {@link }in a file system.
   * @param clusterSizeInBytes            Cluster size in bytes.
   * @return Instance of fully initialized {@link StorageFileSystem}
   * @throws InitializationException if filesystem for this path already exists in cache
   * @throws InitializationException if specified {@code absolutePathToParentDirectory} is not absolute path.
   */
  StorageFileSystem createNewFileSystem(@Nonnull final String absolutePathToParentDirectory,
                                        @Nonnull final String filename,
                                        final int numberOfClusters,
                                        final int clusterSizeInBytes);
}
