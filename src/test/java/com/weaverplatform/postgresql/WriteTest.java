package com.weaverplatform.postgresql;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by gijs on 28/11/2017.
 */
public class WriteTest extends BaseTest {

  @Test
  public void testSimpleWrite() {
    getDatabase().write(
      new WritesBuilder()
        .withUser("test")
        .addNode("test-node")
        .getWrites()
    );

    try {
      ResultSet rs = executeQuery("SELECT (SELECT u.uid FROM creators u WHERE u.id = n.created_by) FROM nodes n WHERE n.uid = 'test-node'");
      assertEquals("Expected user", "test", rs.getString(1));
      assertFalse( "Expected a single node", rs.next());
    } catch (SQLException e) {
      fail("Exception checking result " + e);
    }
  }

  @Test
  public void testGraphWrites() {
    getDatabase().write(new WritesBuilder()
      .withGraph("testGraph")
      .addNode("another-test")
      .getWrites()
    );

    try {
      ResultSet rs = executeQuery("SELECT graphs.uid FROM nodes, graphs WHERE nodes.uid = 'another-test' AND nodes.graph = graphs.id");
      assertEquals("Expected graph", "testGraph", rs.getString(1));
      assertFalse( "Expected a single node", rs.next());
    } catch (SQLException e) {
      fail("Exception checking result " + e);
    }

  }

}
