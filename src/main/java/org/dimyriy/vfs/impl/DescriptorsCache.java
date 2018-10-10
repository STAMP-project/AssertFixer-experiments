package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.StoragePath;

import javax.annotation.Nonnull;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Dmitrii Bogdanov
 * Created at 09.10.18
 */
class DescriptorsCache {
  private final LinkedHashMap<StoragePath, AbstractStorageRecordDescriptorImpl> lruMap;

  DescriptorsCache(@Nonnull final Storage.Configuration configuration) {
    this.lruMap = new LinkedHashMap<StoragePath, AbstractStorageRecordDescriptorImpl>() {
      @Override
      protected boolean removeEldestEntry(@Nonnull final Map.Entry<StoragePath, AbstractStorageRecordDescriptorImpl> eldest) {
        return size() > configuration.getPathsCacheSize();
      }
    };
  }

  AbstractStorageRecordDescriptorImpl computeIfAbsent(@Nonnull final StoragePath storagePath, @Nonnull final Function<StoragePath,
    AbstractStorageRecordDescriptorImpl> mappingFunction) {
    return lruMap.computeIfAbsent(storagePath, mappingFunction);
  }

  AbstractStorageRecordDescriptorImpl get(@Nonnull final StoragePath storagePath) {
    return lruMap.get(storagePath);
  }

  void remove(@Nonnull final StoragePath path) {
    lruMap.remove(path);
  }

  void put(@Nonnull final StoragePath path, @Nonnull final AbstractStorageRecordDescriptorImpl descriptor) {
    lruMap.put(path, descriptor);
  }

  void clear() {
    lruMap.clear();
  }
}
