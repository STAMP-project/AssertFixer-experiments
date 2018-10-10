package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.*;
import org.dimyriy.vfs.impl.constants.FileAllocationTableConstants;
import org.dimyriy.vfs.impl.exceptions.DescriptorAlreadyOpenException;
import org.dimyriy.vfs.impl.exceptions.InitializationException;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.misc.SimpleObjectHolder;
import org.dimyriy.vfs.impl.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
@ThreadSafe
public class InfileFileSystem extends GuarderProcessor.RWLockBlocking implements StorageFileSystem {
  private static final Logger LOGGER = LoggerFactory.getLogger(InfileFileSystem.class);
  private final Storage storage;
  private final AtomicBoolean isInitialized = new AtomicBoolean(false);
  private final WeakHashMap<String, StoragePath> cachedPaths = new WeakHashMap<>();
  private final Map<StoragePath, StorageFileEntryHeader> openDescriptors = new ConcurrentHashMap<>();
  private final ScheduledExecutorService corruptedEntriesProcessor = Executors.newSingleThreadScheduledExecutor();
  private final AtomicBoolean isClosed = new AtomicBoolean(false);
  private final DescriptorsCache descriptorsCache;
  private InfileFileSystemFactory fileSystemFactory = null;
  private StoragePath rootPath = null;

  InfileFileSystem(@Nonnull final Storage storage, @Nonnull final Storage.Configuration configuration) {
    this.storage = storage;
    this.descriptorsCache = new DescriptorsCache(configuration);
  }

  @Override
  public long getFreeSpace() {
    return dataManager().getFreeSpace();
  }

  @Override
  public StoragePath rootPath() {
    return rootPath;
  }

  @Override
  public StoragePath createPath(@Nonnull final String unixPath) {
    return cachedPaths.computeIfAbsent(unixPath, s -> new StoragePath(s, this));
  }

  @Override
  public AbstractStorageRecordDescriptorImpl open(@Nonnull final StoragePath path) {
    if (openDescriptors.containsKey(path)) {
      throw new DescriptorAlreadyOpenException();
    }
    return inCreateContext(() -> {
      if (openDescriptors.containsKey(path)) {
        throw new DescriptorAlreadyOpenException();
      }
      Assertions.numberOfOpenDescriptorsIsNotExceeded(openDescriptors.size());
      if (path.isRoot()) {
        return openRoot();
      } else {
        return openRoot().search(path);
      }
    });
  }

  @Override
  public void close() throws IOException {
    if (!isClosed.get()) {
      LOGGER.trace("Closing fs started");
      final SimpleObjectHolder<IOException> thrown = new SimpleObjectHolder<>(null);
      inWriteContext(() -> {
        if (!isClosed.get()) {
          LOGGER.trace("Closing storage");
          ExceptionUtil.closeAndStoreExceptionIfOccurred(thrown, storage);
          LOGGER.trace("Clearing cache");
          descriptorsCache.clear();
          LOGGER.trace("Shutting down corrupted entries processor");
          corruptedEntriesProcessor.shutdown();
          if (fileSystemFactory != null) {
            LOGGER.trace("Notifying fs factory that fs is closed");
            fileSystemFactory.notifyClosed(this);
          }
        }
        isClosed.set(true);
      });
      if (thrown.getValue() != null) {
        LOGGER.warn("Closing fs failed", thrown.getValue());
        throw thrown.getValue();
      }
      LOGGER.trace("Closing fs finished");
    }
  }

  @Override
  public StorageDirectoryDescriptor createDirectoryRecursively(@Nonnull final StoragePath path) {
    return inCreateContext(() -> {
      if (path.isRoot()) {
        return openRoot();
      } else {
        try (final StorageDirectoryDescriptorImpl root = openRoot()) {
          return root.createChildDirectoryRecursively(path);
        }
      }
    });
  }

  @Override
  public StorageFileDescriptor createFileRecursively(@Nonnull final StoragePath path) {
    return inCreateContext(() -> {
      try (final StorageDirectoryDescriptor parent = createDirectoryRecursively(path.parent())) {
        return parent.createChildFile(path.getFilename());
      }
    });
  }

  StorageDataManager dataManager() {
    return storage.getStorageDataManager();
  }

  void init(@Nonnull final InfileFileSystemFactory factory) {
    if (isInitialized.get()) {
      throw new InitializationException("already initialized");
    } else {
      this.fileSystemFactory = factory;
      this.rootPath = new StoragePath("/", this);
      this.descriptorsCache.put(rootPath, openRoot());
      isInitialized.set(true);
    }
  }

  void notifyRenamed(@Nonnull final AbstractStorageRecordDescriptorImpl descriptor, @Nonnull final StoragePath oldPath) {
    notifyDeleted(oldPath);
    notifyCreated(descriptor);
  }

  void notifyCreated(@Nonnull final AbstractStorageRecordDescriptorImpl descriptor) {
    descriptorsCache.put(descriptor.getPath(), descriptor);
    cachedPaths.put(descriptor.getPath().toString(), descriptor.getPath());
    if (descriptor.isFile()) {
      openDescriptors.put(descriptor.getPath(), (StorageFileEntryHeader) descriptor.header());
    }
  }

  void notifyDeleted(@Nonnull final StorageRecordDescriptor descriptor) {
    notifyDeleted(descriptor.getPath());
  }

  DescriptorsCache descriptorsCache() {
    return descriptorsCache;
  }

  void notifyClosed(@Nonnull final StorageRecordDescriptor descriptor) {
    inWriteContext(() -> this.openDescriptors.remove(descriptor.getPath()));
  }

  String getAbsoluteFullPathOfStorageFile() {
    return storage.getAbsoluteFullPathOfStorageFile();
  }

  void processCorruptedEntry(final StorageEntryHeader header) {
    if (FileAllocationTableConstants.isBadCluster(header.getStartingCluster())) {
      corruptedEntriesProcessor.execute(() -> inWriteContext(() -> {
        dataManager().processCorruptedEntry(header.getStartingCluster(), header.getFileSize());
        header.setStartingCluster(FileAllocationTableConstants.badCluster());
        header.rewrite(header.getFilename());
      }));
    }
  }

  private StorageDirectoryDescriptorImpl openRoot() {
    return new StorageDirectoryDescriptorImpl(rootPath(), storage.getRoot(), this);
  }

  private void notifyDeleted(@Nonnull final StoragePath path) {
    openDescriptors.remove(path);
    descriptorsCache.remove(path);
    cachedPaths.remove(path.toString());
  }
}
