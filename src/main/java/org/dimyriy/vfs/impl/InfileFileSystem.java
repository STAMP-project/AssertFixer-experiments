package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.*;
import org.dimyriy.vfs.impl.constants.FileAllocationTableConstants;
import org.dimyriy.vfs.impl.exceptions.*;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.misc.NoArgVoid;
import org.dimyriy.vfs.impl.misc.SimpleObjectHolder;
import org.dimyriy.vfs.impl.util.ByteUtil;
import org.dimyriy.vfs.impl.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
@ThreadSafe
public class InfileFileSystem implements StorageFileSystem {
  private static final Logger LOGGER = LoggerFactory.getLogger(InfileFileSystem.class);

  private final Storage storage;
  private final GuarderProcessor guarderProcessor = new GuarderProcessor.RWLockBlocking();
  private final AtomicBoolean isInitialized = new AtomicBoolean(false);
  private final StorageDataManager storageDataManager;
  private final WeakHashMap<String, StoragePath> cachedPaths = new WeakHashMap<>();
  private final Map<StoragePath, AbstractStorageRecordDescriptorImpl> openDescriptors = new ConcurrentHashMap<>();
  private final LinkedHashMap<StoragePath, StorageEntryHeader> lruCache;
  private final ScheduledExecutorService corruptedEntriesProcessor = Executors.newSingleThreadScheduledExecutor();
  private final AtomicBoolean isClosed = new AtomicBoolean(false);
  private final Storage.Configuration configuration;
  private InfileFileSystemFactory fileSystemFactory = null;
  private StoragePath rootPath = null;
  private ScheduledFuture<?> badClustersRepairTask = null;

  InfileFileSystem(@Nonnull final Storage storage, @Nonnull final Storage.Configuration configuration) {
    this.configuration = configuration;
    this.storage = storage;
    this.storageDataManager = storage.getStorageDataManager();
    this.lruCache = new LinkedHashMap<StoragePath, StorageEntryHeader>() {
      @Override
      protected boolean removeEldestEntry(@Nonnull final Map.Entry<StoragePath, StorageEntryHeader> eldest) {
        return size() > configuration.getPathsCacheSize();
      }
    };
  }

  @Override
  public int getFreeSpace() {
    return storageDataManager.getFreeSpace();
  }

  @Override
  public StoragePath root() {
    return rootPath;
  }

  @Override
  public void close() throws IOException {
    if (!isClosed.get()) {
      LOGGER.trace("Closing fs started");
      final SimpleObjectHolder<IOException> thrown = new SimpleObjectHolder<>(null);
      executeWrite(() -> {
        if (!isClosed.get()) {
          LOGGER.trace("Closing storage");
          ExceptionUtil.closeAndStoreExceptionIfOccurred(thrown, storage);
          LOGGER.trace("Clearing cache");
          lruCache.clear();
          if (badClustersRepairTask != null) {
            LOGGER.trace("Cancelling repair task");
            badClustersRepairTask.cancel(false);
          }
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
  public StorageDirectoryDescriptor createDirectory(@Nonnull final StoragePath path) {
    return (StorageDirectoryDescriptor) create(path, true);
  }

  @Override
  public StorageDirectoryDescriptor createDirectoryRecursively(@Nonnull final StoragePath path) {
    throw new StorageIOException(new IOException("not implemented"));
  }

  @Override
  public StorageFileDescriptor createFile(@Nonnull final StoragePath path) {
    return (StorageFileDescriptor) create(path, false);
  }

  @Override
  public StoragePath createPath(@Nonnull final String unixPath) {
    return cachedPaths.computeIfAbsent(unixPath, s -> new StoragePath(s, this));
  }

  @Override
  public StorageRecordDescriptor open(@Nonnull final StoragePath path) {
    try {
      return guarderProcessor.read(() -> {
        if (openDescriptors.containsKey(path)) {
          throw new DescriptorAlreadyOpenException();
        }
        Assertions.numberOfOpenDescriptorsIsNotExceeded(openDescriptors.size());
        try (final Stream<byte[]> pathWalker = path.bytePathWalker()) {
          storageDataManager.traverseFromRoot(pathWalker);
        }
        final StorageEntryHeader header = findDescriptor(path);
        final AbstractStorageRecordDescriptorImpl descriptor = createDescriptor(path, header);
        openDescriptor(descriptor);
        return descriptor;
      });
    } catch (final StorageEntryHeaderNotFoundException e) {
      throw new StorageRecordDoesNotExistException();
    }
  }

  @Override
  public void delete(@Nonnull final StorageRecordDescriptor storageRecordDescriptor) {
    executeWrite(() -> {
      ((AbstractStorageRecordDescriptorImpl) storageRecordDescriptor).guardClosed();
      ((AbstractStorageRecordDescriptorImpl) storageRecordDescriptor).guardDeleted();
      final StorageEntryHeader parent = findParentDescriptor(storageRecordDescriptor.getPath());
      ((AbstractStorageRecordDescriptorImpl) storageRecordDescriptor).setDeletedFlag();
      storageDataManager.deleteChild(parent, storageRecordDescriptor.getHeader());
    });
  }

  @Override
  public void rename(@Nonnull final StorageRecordDescriptor storageRecordDescriptor, @Nonnull final String newName) {
    Assertions.filenameMatchesPattern(newName);
    final byte[] oldName = storageRecordDescriptor.getHeader().getFilename();
    storageRecordDescriptor.getHeader().setFilename(ByteUtil.asciiStringToByteArray(newName));
    executeWrite(() -> storageRecordDescriptor.getHeader().rewrite(oldName, storageDataManager));
  }

  @Override
  public List<StoragePath> listChildren(@Nonnull final StorageDirectoryDescriptor directoryDescriptor) {
    return storageDataManager.readDirectoryChildren(directoryDescriptor.getHeader())
                             .stream()
                             .map(entryHeader -> directoryDescriptor.getPath().child(ByteUtil.toAsciiString(entryHeader.getFilename())))
                             .collect(Collectors.toList());
  }

  void init(@Nonnull final InfileFileSystemFactory factory) {
    if (isInitialized.get()) {
      throw new InitializationException("already initialized");
    } else {
      this.fileSystemFactory = factory;
      this.rootPath = new StoragePath("/", this);
      this.lruCache.put(rootPath, storage.getRoot());
      badClustersRepairTask = corruptedEntriesProcessor.scheduleAtFixedRate(() -> executeWrite(this.storageDataManager::repairCorruptedClusters),
                                                                            configuration.getBadClustersRepairTaskPeriodInSeconds(),
                                                                            configuration.getBadClustersRepairTaskPeriodInSeconds(),
                                                                            TimeUnit.SECONDS);
      isInitialized.set(true);
    }
  }

  void closeDescriptor(@Nonnull final StorageRecordDescriptor descriptor) {
    this.openDescriptors.remove(descriptor.getPath());
    this.cachedPaths.remove(descriptor.getPath().toString());
  }

  String getAbsoluteFullPathOfStorageFile() {
    return storage.getAbsoluteFullPathOfStorageFile();
  }

  byte[] readFileContent(@Nonnull final StorageFileDescriptorImpl descriptor) {
    descriptor.guardClosed();
    try {
      return storageDataManager.readData(descriptor.getHeader().getFileSize(), descriptor.getHeader().getStartingCluster());
    } catch (final BufferUnderflowException e) {
      processCorruptedEntry(descriptor.getHeader());
      throw new StorageRecordCorruptedException();
    }
  }

  void writeFileContent(@Nonnull final StorageFileDescriptorImpl descriptor, @Nonnull final byte[] content) {
    descriptor.guardClosed();
    assertEnoughEmptyClusters(content);
    executeWrite(() -> {
      assertEnoughEmptyClusters(content);
      storageDataManager.writeContentTransactional(descriptor.getHeader(), content);
    });
  }

  void executeWrite(@Nonnull final NoArgVoid write) {
    guarderProcessor.write(write);
  }

  private void assertEnoughEmptyClusters(@Nonnull final byte[] content) {
    if (content.length >= getFreeSpace()) {
      throw new NotEnoughSpaceLeftException();
    }
  }

  private void processCorruptedEntry(final StorageEntryHeader header) {
    if (FileAllocationTableConstants.isBadCluster(header.getStartingCluster())) {
      corruptedEntriesProcessor.execute(() -> executeWrite(() -> storageDataManager.processCorruptedEntry(header)));
    }
  }

  private AbstractStorageRecordDescriptorImpl create(@Nonnull final StoragePath path, final boolean isDirectory) {
    if (path.isRoot()) {
      throw new StorageRecordAlreadyExistsException();
    }
    if (openDescriptors.containsKey(path) || lruCache.containsKey(path)) {
      throw new StorageRecordAlreadyExistsException();
    }
    return guarderProcessor.create(() -> {
      final StorageEntryHeader parentDescriptor = findParentDescriptor(path);
      final StorageEntryHeader newEntry = storageDataManager.createEmptyChildInDirectory(parentDescriptor, path.byteFilename(), isDirectory);
      return createDescriptor(path, newEntry);
    });
  }

  private AbstractStorageRecordDescriptorImpl createDescriptor(@Nonnull final StoragePath path, final StorageEntryHeader header) {
    return header.isDirectory() ?
           new StorageDirectoryDescriptorImpl(path, header, this) :
           new StorageFileDescriptorImpl(path, header, this);
  }

  private void openDescriptor(@Nonnull final AbstractStorageRecordDescriptorImpl descriptor) {
    this.openDescriptors.put(descriptor.getPath(), descriptor);
  }

  private StorageEntryHeader findParentDescriptor(@Nonnull final StoragePath path) {
    return findDescriptor(path.parent());
  }

  private StorageEntryHeader findDescriptor(@Nonnull final StoragePath path) {
    return lruCache.computeIfAbsent(path, s -> {
      try (final Stream<byte[]> nextPathPart = s.bytePathWalker()) {
        return storageDataManager.traverseFromRoot(nextPathPart);
      }
    });
  }
}
