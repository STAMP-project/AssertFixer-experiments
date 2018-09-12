package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.controllers.DatabaseController;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gijs on 04/08/2017.
 */
public class DatabaseNamesTest {
  private void assertLegal(String s)  {
    Assert.assertTrue(String.format("%s should be legal", s), DatabaseController.isLegalDatabaseName(s));
  }

  private void assertNotLegal(String s)  {
    Assert.assertFalse(String.format("%s should not be legal", s), DatabaseController.isLegalDatabaseName(s));
  }

  @Test
  public void testLegalNames() {
    assertLegal("test");
    assertLegal("test-database");
    assertLegal("test_database");
    assertLegal("AreCapitalsAllowed");
    assertLegal("Number2");
    assertLegal("_-360NoSc.peBlz420-_");
  }

  @Test
  public void testIllegalNames() {
    assertNotLegal("a");
    assertNotLegal("12");
    assertNotLegal("\"inject");
    assertNotLegal(";that");
    assertNotLegal("ThisisaverylongidentifierwhichshouldberejectedIguesseventhoughitsotherwisecomprisedoflegaltargetsconfigurationmanagementsystemwords");
    assertNotLegal("but no spaces");
  }
}
