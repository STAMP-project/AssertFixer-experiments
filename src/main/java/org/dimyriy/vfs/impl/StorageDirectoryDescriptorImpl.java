package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StorageDirectoryDescriptor;
import org.dimyriy.vfs.StoragePath;
import org.dimyriy.vfs.impl.exceptions.*;
import org.dimyriy.vfs.impl.guards.Assertions;
import org.dimyriy.vfs.impl.misc.SimpleObjectHolder;
import org.dimyriy.vfs.impl.util.ByteUtil;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Dmitrii Bogdanov
 * Created at 25.09.18
 */
class StorageDirectoryDescriptorImpl extends AbstractStorageRecordDescriptorImpl implements StorageDirectoryDescriptor {
  StorageDirectoryDescriptorImpl(@Nonnull final StoragePath path,
                                 @Nonnull final StorageDirectoryEntryHeader entryHeader,
                                 @Nonnull final InfileFileSystem owner) {
    super(path, entryHeader, owner);
  }

  @Override
  public int numberOfEntries() {
    guardNotClosedNotDeleted();
    return fs().inReadContext(() -> {
      guardNotClosedNotDeleted();
      return header().getFileSize() / StorageEntryHeader.sizeInBytes();
    });
  }

  @SuppressWarnings("ConstantConditions")
  @Override
  public StorageDirectoryDescriptor createChildDirectoryRecursively(@Nonnull final StoragePath storagePath) {
    if (!isAncestorOf(storagePath)) {
      throw new StorageRecordDoesNotExistException();
    }
    return fs().inCreateContext(() -> {
      final SimpleObjectHolder<StorageDirectoryDescriptorImpl> currentParent = new SimpleObjectHolder<>(this);
      storagePath.pathWalker(getPath())
                 .forEach(fileName -> currentParent.computeAndSetNewValue(s -> s.createOrGetChildDirectory(currentParent.getValue()
                                                                                                                        .getPath()
                                                                                                                        .child(fileName))));
      return currentParent.getValue();
    });
  }

  @Override
  @Nonnull
  public StorageDirectoryEntryHeader header() {
    return (StorageDirectoryEntryHeader) super.header();
  }


  @Override
  public StorageDirectoryDescriptorImpl createChildDirectory(@Nonnull final String directoryName) {
    Assertions.filenameMatchesPattern(directoryName);
    guardNotClosedNotDeleted();
    return fs().inCreateContext(() -> {
      guardNotClosedNotDeleted();
      final byte[] filename = ByteUtil.asciiStringToByteArray(directoryName);
      if (header().childExists(filename)) {
        throw new StorageRecordAlreadyExistsException();
      } else {
        return (StorageDirectoryDescriptorImpl) createChild(directoryName, true);
      }
    });
  }

  @Override
  public StorageFileDescriptorImpl createChildFile(@Nonnull final String filename) {
    Assertions.filenameMatchesPattern(filename);
    guardNotClosedNotDeleted();
    return fs().inCreateContext(() -> {
      guardNotClosedNotDeleted();
      return (StorageFileDescriptorImpl) createChild(filename, false);
    });
  }

  @Override
  public List<StoragePath> listChildren() {
    guardNotClosedNotDeleted();
    return fs().inReadContext(() -> {
      guardNotClosedNotDeleted();
      return header().getChildrenFilenames()
                     .stream()
                     .map(ByteUtil::toAsciiString)
                     .map(filename -> getPath().child(filename))
                     .collect(Collectors.toList());
    });
  }

  @Override
  public AbstractStorageRecordDescriptorImpl search(@Nonnull final StoragePath path) {
    if (!isAncestorOf(path)) {
      throw new StorageRecordDoesNotExistException();
    }
    final SimpleObjectHolder<StorageDirectoryDescriptorImpl> currentParent = new SimpleObjectHolder<>(this);
    if (!path.parent().equals(getPath())) {
      path.parent().pathWalker(getPath()).forEach(filename -> currentParent.computeAndSetNewValue(current -> {
        final AbstractStorageRecordDescriptorImpl currentChild = fs().descriptorsCache().computeIfAbsent(current.getPath().child(filename),
                                                                                                         currentPath -> current.getChildDirectory(currentPath,
                                                                                                                                                  currentPath.byteFilename()));
        if (!currentChild.isDirectory()) {
          throw new StorageRecordDoesNotExistException();
        }
        return (StorageDirectoryDescriptorImpl) currentChild;
      }));
    }
    try {
      final StorageEntryHeader child = Objects.requireNonNull(currentParent.getValue()).header().getChild(path.byteFilename());
      return createDescriptor(path, child);
    } catch (final StorageEntryHeaderNotFoundException e) {
      throw new StorageRecordDoesNotExistException();
    }
  }

  @Override
  public void delete() {
    if (!header().isEmpty()) {
      throw new StorageDirectoryNotEmptyException();
    }
    super.delete();
  }

  @Override
  public void close() {
    fs().notifyClosed(this);
  }

  @Override
  void guardClosed() {
    //do nothing – open directory doesn't hurt application logic
  }

  @SuppressWarnings("AssertWithSideEffects")
  private StorageDirectoryDescriptorImpl createOrGetChildDirectory(@Nonnull final StoragePath storagePath) {
    guardNotClosedNotDeleted();
    assert storagePath.parent().equals(getPath()) : "path should be child";
    final AbstractStorageRecordDescriptorImpl childDirectory = fs().descriptorsCache().computeIfAbsent(storagePath, p -> {
      final byte[] filename = p.byteFilename();
      if (header().childExists(filename)) {
        return getChildDirectory(storagePath, filename);
      } else {
        return createChild(storagePath.getFilename(), isDirectory());
      }
    });
    if (!childDirectory.isDirectory()) {
      throw new StorageEntryHeaderNotDirectoryException(storagePath.toString());
    }
    return (StorageDirectoryDescriptorImpl) childDirectory;
  }

  private StorageDirectoryDescriptorImpl getChildDirectory(@Nonnull final StoragePath storagePath, final byte[] filename) {
    final StorageEntryHeader child = header().getChild(filename);
    if (!child.isDirectory()) {
      throw new StorageEntryHeaderNotDirectoryException();
    } else {
      return new StorageDirectoryDescriptorImpl(storagePath, (StorageDirectoryEntryHeader) child, fs());
    }
  }

  private AbstractStorageRecordDescriptorImpl createChild(@Nonnull final String filename, final boolean isDirectory) {
    guardNotClosedNotDeleted();
    return createDescriptor(getPath().child(filename), header().createEmptyChild(ByteUtil.asciiStringToByteArray(filename), isDirectory));
  }

  private AbstractStorageRecordDescriptorImpl createDescriptor(@Nonnull final StoragePath path, @Nonnull final StorageEntryHeader header) {
    return header.isDirectory() ?
           new StorageDirectoryDescriptorImpl(path, (StorageDirectoryEntryHeader) header, fs()) :
           new StorageFileDescriptorImpl(path, (StorageFileEntryHeader) header, fs());
  }

  @SuppressWarnings("BooleanMethodIsAlwaysInverted")
  private boolean isAncestorOf(@Nonnull final StoragePath path) {
    return path.isDescendantOf(this.getPath());
  }
}
