package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.TestQuery;
import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import com.weaverplatform.postgresql.util.WeaverError;
import com.weaverplatform.protocol.model.CreateNodeOperation;
import com.weaverplatform.protocol.model.RemoveNodeOperation;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Ignore("Tests hang")
public class NodesTest extends BaseTest {

  @Test
  public void run1_wipe() {
    wipe();
  }

  @Test
  public void run2_createNodeOperation() throws SQLException {
    String nodeName = "node-uid-test";
    String createNode = new CreateNodeOperation("unknown", nodeName).toJson();

    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body("[" + createNode + "]")
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .post("http://localhost:4567/write");

    ResultSet rs = listNode(nodeName);
    assertEquals(rs.getString(1), nodeName);
  }

  @Test
  public void run3_removeNodeOperation() throws SQLException {
    String nodeName = "removed-uid-node";
    String removeNode = new RemoveNodeOperation("unknown", "node-uid-test", nodeName).toJson();

    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body("[" + removeNode + "]")
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .post("/write");

    ResultSet rs = listNode(nodeName);
    assertEquals(rs.getString(1), nodeName);
  }

  @Test
  public void run4_checkForRemovedNode() throws SQLException {
    PreparedStatement ps = prepareQuery(TestQuery.TEST_REMOVED_NODE);
    ps.setInt(1, 2);
    ps.setInt(2, 1);
    ResultSet rs = ps.executeQuery();
    rs.next();
    assertEquals(rs.getInt(1), 1);
  }


  @Test
  public void deleteAndRecreateNode() {
    final String graph  = "deleteAndRecreate";
    final String nodeId = "testid";
    getDatabase().write(
      new WritesBuilder()
        .withGraph(graph)
        .addNode(nodeId)
        .getWrites()
    );
    getDatabase().write(
      new WritesBuilder()
        .withGraph(graph)
        .removeNode(nodeId)
        .getWrites()
    );
    FindQueryResult res1 = (FindQueryResult) getDatabase().query(query()
      .addInGraph(graph)
      .restrict(nodeId)
    );
    assertEquals("Number of nodes existing after delete", 0, res1);
    getDatabase().write(
      new WritesBuilder()
        .withGraph(graph)
        .addNode(nodeId)
        .getWrites()
    );
    FindQueryResult res2 = (FindQueryResult) getDatabase().query(query()
      .addInGraph(graph)
      .restrict(nodeId)
    );
    assertEquals("Number of nodes existing after recreate", 1, res2);
  }

  @Test
  public void testMultipleAttributesWithTheSameKey() {
    try {
      getDatabase().write(new WritesBuilder()
        .addNode("test")
        .setAttribute("key", "value1")
        .setAttribute("key", "value2")
        .getWrites()
      );
      fail("This should not be writable");
    }
    catch (WeaverError e) {
      assertTrue("Error contains attribute already exists: " + e.getMessage(), e.getMessage().contains("Attribute already exists"));
    }
  }

}
