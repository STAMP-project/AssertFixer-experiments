package org.dimyriy.vfs.impl;

import org.assertj.core.api.Assertions;
import org.dimyriy.vfs.StorageDirectoryDescriptor;
import org.dimyriy.vfs.StorageFileDescriptor;
import org.dimyriy.vfs.StoragePath;
import org.dimyriy.vfs.StorageRecordDescriptor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Dmitrii Bogdanov
 * Created at 01.10.18
 */
class InfileFileSystemBenchmarkIntegrationTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(InfileFileSystemBenchmarkIntegrationTest.class);
  private static final ExecutorService executor = Executors.newFixedThreadPool(2);
  private static final int READ_WRITES_LIMIT = 127;
  private final Queue<String> createdFiles = new ConcurrentLinkedDeque<>();
  private final Collection<String> deletedFiles = new ConcurrentLinkedDeque<>();
  private final Collection<String> renamedFiles = new ConcurrentLinkedDeque<>();
  private final AtomicInteger createdEntries = new AtomicInteger(0);
  private final Random random = new Random();
  private InfileFileSystem fs = null;
  private Queue<Future<String>> submittedTasks = null;
  private static final int NUMBER_OF_ITERATIONS_FOR_SUBSEQUENT_CONCURRENT_CREATION = 1000;
  private static final int NUMBER_OF_THREADS_FOR_SUBSEQUENT_CONCURRENT_CREATION = 2;

  @BeforeEach
  void setUp() throws IOException {
    final Path tmp = Files.createTempDirectory("tmp");
    assertThat(tmp.toFile().createNewFile()).isFalse();
    submittedTasks = new ArrayDeque<>();
    fs = InfileFileSystemFactory.getInstance().createNewFileSystem(tmp.toAbsolutePath().toString(), "temporary.vfs", 4096);
  }

  @Test
  void testConcurrentSubsequentCreationOfFilesWithSameName() throws InterruptedException {
    final long start = System.currentTimeMillis();
    final Thread[] threads = new Thread[NUMBER_OF_THREADS_FOR_SUBSEQUENT_CONCURRENT_CREATION];
    final CyclicBarrier lock = new CyclicBarrier(NUMBER_OF_THREADS_FOR_SUBSEQUENT_CONCURRENT_CREATION);
    int numberOfIterations = 0;
    while (numberOfIterations < NUMBER_OF_ITERATIONS_FOR_SUBSEQUENT_CONCURRENT_CREATION) {
      for (int i = 0; i < NUMBER_OF_THREADS_FOR_SUBSEQUENT_CONCURRENT_CREATION; i++) {
        threads[i] = new Thread(new Writer(fs, TestUtil.createRandomByteArray(10000), "a" + i, lock));
      }

      for (final Thread thread : threads) {
        thread.start();
      }
      for (final Thread thread : threads) {
        thread.join();
      }
      numberOfIterations++;
    }
    final long operationTime = System.currentTimeMillis() - start;
    final int numberOfCreatedFiles = NUMBER_OF_ITERATIONS_FOR_SUBSEQUENT_CONCURRENT_CREATION * NUMBER_OF_THREADS_FOR_SUBSEQUENT_CONCURRENT_CREATION;
    LOGGER.info("[testConcurrentSubsequentCreationOfFilesWithSameName] => Operation time: {}s; number of created entries: {}; average per second: {}.",
                operationTime / 1000.,
                numberOfCreatedFiles,
                Math.round((numberOfCreatedFiles + 0.) / operationTime * 1000));
  }

  @Test
  void testConcurrentReadsOfConcurrentWritesAndDeletesReadCorrectContent() throws Throwable {
    final long start = System.currentTimeMillis();
    final Path tmp = Files.createTempDirectory("tmp");
    assertThat(tmp.toFile().createNewFile()).isFalse();
    for (int i = 0; i < READ_WRITES_LIMIT; i++) {
      submittedTasks.add(executor.submit(() -> {
        final String randomPath = generateRandomPath();
        final StoragePath path = fs.createPath(randomPath);
        try (final StorageDirectoryDescriptor open = fs.createDirectoryRecursively(path.parent())) {
          assertThat(open).isNotNull();
        }
        try (final StorageFileDescriptor file = fs.createFileRecursively(path)) {
          assertThat(file).isNotNull();
          final byte[] writtenContent = TestUtil.createRandomByteArray(random.nextInt(40960));
          file.write(writtenContent);
          final byte[] a = file.read();
          assertThat(a).isEqualTo(writtenContent);
        }
        createdEntries.incrementAndGet();
        createdFiles.add(randomPath);
        return randomPath;
      }));
      if (i % 2 == 0) {
        submittedTasks.add(executor.submit(() -> {
          final String pathToDelete = createdFiles.poll();
          if (pathToDelete != null) {
            final StoragePath storagePath = fs.createPath(pathToDelete);
            try (final StorageRecordDescriptor open = storagePath.open()) {
              assertThat(open).isNotNull();
              open.delete();
              deletedFiles.add(pathToDelete);
              return pathToDelete;
            }
          } else {
            return "";
          }
        }));
      }
      if (i % 2 != 0) {
        submittedTasks.add(executor.submit(() -> {
          final String pathToRename = createdFiles.poll();
          if (pathToRename != null) {
            try (final StorageFileDescriptor open = (StorageFileDescriptor) fs.createPath(pathToRename).open()) {
              assertThat(open).isNotNull();
              open.rename(generateFileName());
              renamedFiles.add(open.getPath().toString());
              return pathToRename;
            }
          } else {
            return "";
          }
        }));
      }
    }
    for (final Future<String> future : submittedTasks) {
      try {
        final Object o = future.get();
        assertThat(o).isNotNull();
      } catch (final ExecutionException e) {
        throw e.getCause();
      }
    }
    assertThat(renamedFiles.isEmpty()).isFalse();
    assertThat(deletedFiles.isEmpty()).isFalse();
    final long operationTime = System.currentTimeMillis() - start;
    LOGGER.info(
      "[testConcurrentReadsOfConcurrentWritesAndDeletesReadCorrectContent] => Operation time: {}s; number of created entries: {}; average per second: {}.",
      operationTime / 1000.,
      createdEntries.get(),
      Math.round((createdEntries.get() + 0.) / operationTime * 1000));
  }

  static class Writer implements Runnable {
    private final InfileFileSystem fs;
    private final byte[] data;
    private final String fileName;
    private final CyclicBarrier lock;

    Writer(final InfileFileSystem fs, final byte[] data, final String fileName, final CyclicBarrier lock) {
      this.fs = fs;
      this.data = data;
      this.fileName = fileName;
      this.lock = lock;
    }

    @Override
    public void run() {
      try (final StorageFileDescriptor file = fs.createFileRecursively(fs.createPath("/" + fileName))) {
        lock.await();
        file.append(data);
        lock.await();
        Assertions.assertThat(file.read()).isEqualTo(data);
      } catch (final Exception e) {
        throw new RuntimeException(e);
      }
      try {
        lock.await();
        try (final StorageRecordDescriptor file = fs.open(new StoragePath("/" + fileName, fs))) {
          lock.await();
          file.delete();
        }
      } catch (final Exception e) {
        throw new RuntimeException(e);
      }
    }
  }


  @AfterEach
  void tearDown() throws IOException {
    fs.close();
  }

  private String generateRandomPath() {
    final int pathLength = random.nextInt(5) + 2;
    final StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < pathLength; i++) {
      stringBuilder.append("/").append(generateFileName());
    }
    return stringBuilder.toString();
  }

  private String generateFileName() {
    return String.valueOf(random.nextGaussian()).substring(0, 10);
  }
}
