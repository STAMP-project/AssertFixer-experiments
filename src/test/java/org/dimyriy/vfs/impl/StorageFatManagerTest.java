package org.dimyriy.vfs.impl;

import org.dimyriy.vfs.impl.constants.FileAllocationTableConstants;
import org.dimyriy.vfs.impl.exceptions.NotEnoughSpaceLeftException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Dmitrii Bogdanov
 * Created at 30.09.18
 */
class StorageFatManagerIntegrationTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorageFatManagerIntegrationTest.class);

  private File file = null;
  private Storage.Configuration configuration = null;

  @BeforeEach
  void setUp() throws IOException {
    file = Files.createTempFile("tmp", "vfs").toFile();
    configuration = new Storage.Configuration().createNew().withNumberOfClusters(4);
    final boolean newFile = file.createNewFile();
    LOGGER.trace("Created temp file {}", newFile);
  }

  @Test
  void getClusterValue_ReturnsEmptyClusterForAllClusters_WhenFatJustCreated() {
    final StorageFatManager storageFatManager = new StorageFatManager(file, configuration);
    assertThat(storageFatManager.getNumberOfEmptyClusters()).isEqualTo(configuration.getNumberOfClusters() - 1);
    for (int i = 0; i < configuration.getNumberOfClusters(); i++) {
      assertThat(storageFatManager.getValueOfCluster(i)).isEqualTo(FileAllocationTableConstants.emptyCluster());
    }
  }

  @Test
  void getNextFreeCluster_ReturnsSecondClusterAndSetsCorrectValueInTable_WhenFatJustCreated() {
    final StorageFatManager storageFatManager = new StorageFatManager(file, configuration);
    assertThat(storageFatManager.getNextFreeCluster(0)).isEqualTo(1);
    assertThat(storageFatManager.getNextFreeCluster(1)).isEqualTo(2);
    assertThat(storageFatManager.getNextFreeCluster(2)).isEqualTo(3);
    assertThat(storageFatManager.getValueOfCluster(0)).isEqualTo(1);
    assertThat(storageFatManager.getValueOfCluster(1)).isEqualTo(2);
    assertThat(storageFatManager.getValueOfCluster(2)).isEqualTo(3);
    assertThat(storageFatManager.getNumberOfEmptyClusters()).isEqualTo(configuration.getNumberOfClusters() - 4);
    for (int i = 0; i < 3; i++) {
      assertThat(storageFatManager.getValueOfCluster(i)).isNotEqualTo(FileAllocationTableConstants.emptyCluster());
    }
    for (int i = 3; i < configuration.getNumberOfClusters(); i++) {
      assertThat(storageFatManager.getValueOfCluster(i)).isEqualTo(FileAllocationTableConstants.emptyCluster());
    }
  }

  @Test
  void getNextFreeCluster_ThrowsException_WhenNoClustersLeft() throws IOException {
    try (final StorageFatManager storageFatManager = new StorageFatManager(file, configuration)) {
      storageFatManager.executeTransactional(() -> {
        assertThat(storageFatManager.getNextFreeCluster(0)).isEqualTo(1);
        assertThat(storageFatManager.getNextFreeCluster(1)).isEqualTo(2);
        assertThat(storageFatManager.getNextFreeCluster(2)).isEqualTo(3);
        assertThrows(NotEnoughSpaceLeftException.class, () -> storageFatManager.getNextFreeCluster(3));
      });
      assertThat(storageFatManager.getValueOfCluster(0)).isEqualTo(1);
      assertThat(storageFatManager.getValueOfCluster(1)).isEqualTo(2);
      assertThat(storageFatManager.getValueOfCluster(2)).isEqualTo(3);
      assertThrows(NotEnoughSpaceLeftException.class, () -> storageFatManager.getNextFreeCluster(2));
    }
  }

  @Test
  void readingFatFromFile_ReadsSameState() throws IOException {
    try (final StorageFatManager storageFatManager = new StorageFatManager(file, configuration)) {
      storageFatManager.executeTransactional(() -> {
        assertThat(storageFatManager.getNextFreeCluster(0)).isEqualTo(1);
        assertThat(storageFatManager.getNextFreeCluster(1)).isEqualTo(2);
        assertThat(storageFatManager.getNextFreeCluster(2)).isEqualTo(3);
      });
      assertThat(storageFatManager.getValueOfCluster(0)).isEqualTo(1);
      assertThat(storageFatManager.getValueOfCluster(1)).isEqualTo(2);
      assertThat(storageFatManager.getValueOfCluster(2)).isEqualTo(3);
      assertThat(storageFatManager.getNumberOfEmptyClusters()).isEqualTo(configuration.getNumberOfClusters() - 4);
    }
    configuration.loadExisting();
    try (final StorageFatManager storageFatManager = new StorageFatManager(file, configuration)) {
      for (int i = 0; i < 3; i++) {
        assertThat(storageFatManager.getValueOfCluster(i)).isNotEqualTo(FileAllocationTableConstants.emptyCluster());
      }
      for (int i = 3; i < configuration.getNumberOfClusters(); i++) {
        assertThat(storageFatManager.getValueOfCluster(i)).isEqualTo(FileAllocationTableConstants.emptyCluster());
      }
      assertThat(storageFatManager.getValueOfCluster(1)).isEqualTo(2);
    }
  }
}