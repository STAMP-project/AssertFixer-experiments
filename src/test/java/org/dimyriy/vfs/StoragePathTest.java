package org.dimyriy.vfs;

import org.dimyriy.vfs.impl.InfileFileSystem;
import org.dimyriy.vfs.impl.exceptions.PathContainsIllegalCharactersException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Dmitrii Bogdanov
 * Created at 28.09.18
 */
class StoragePathTest {
  private InfileFileSystem infileFileSystem = null;

  @BeforeEach
  void setUp() {
    infileFileSystem = Mockito.mock(InfileFileSystem.class);
    Mockito.when(StorageFileSystem.separator()).thenReturn('/');
  }

  @Test
  void newInstance_ThrowsException_WhenUnixPathContainsInvalidSymbols() {
    Assertions.assertThrows(PathContainsIllegalCharactersException.class, () -> new StoragePath("/=±", infileFileSystem));
  }

  @Test
  void newInstance_DoesNotThrow_WhenUnixPathDoesNotContainInvalidSymbols() {
    Assertions.assertDoesNotThrow(() -> {
      new StoragePath("/as.jfhjgh/38171hnb143/dasfr_--/dksf", infileFileSystem);
    });
  }

  @Test
  void parent_ReturnsCorrectParent_WhenMoreThanOneSlashInPath() {
    assertThat(new StoragePath("/some/some/child", infileFileSystem).parent()).isEqualTo(new StoragePath("/some/some", infileFileSystem));
  }

  @Test
  void parent_ReturnsRoot_WhenOnlyOneSlashInPath() {
    final StoragePath rootPath = new StoragePath("/", infileFileSystem);
    Mockito.when(infileFileSystem.root()).thenReturn(rootPath);
    assertThat(new StoragePath("/rootChild", infileFileSystem).parent().isRoot()).isTrue();
  }

  @Test
  void parent_ReturnsSameObject_WhenCalledOnRoot() {
    final StoragePath storagePath = new StoragePath("/", infileFileSystem);
    assertThat(storagePath.parent()).isSameAs(storagePath);
  }

  @Test
  void equals_ReturnsTrue_WhenCalledOnRootPathWithDifferentInstanceOfRootPath() {
    assertThat(new StoragePath("/", infileFileSystem)).isEqualTo(new StoragePath("/", infileFileSystem));
  }

  @Test
  void equals_IsTrue_WhenCalledWithEqualPath() {
    assertThat(new StoragePath("/some/some/path", infileFileSystem)).isEqualTo(new StoragePath("/some/some/path", infileFileSystem));
  }

  @Test
  void equals_IsFalse_WhenCalledWithDifferentPath() {
    assertThat(new StoragePath("/some/some/path", infileFileSystem)).isNotEqualTo(new StoragePath("/some/some/path1", infileFileSystem));
  }

  @Test
  void equals_IsFalse_WhenCalledWithSubPath() {
    assertThat(new StoragePath("/some/some", infileFileSystem)).isNotEqualTo(new StoragePath("/some/some/path1", infileFileSystem));
  }
}