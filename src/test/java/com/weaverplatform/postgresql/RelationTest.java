package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.TestQuery;
import com.weaverplatform.protocol.model.CreateNodeOperation;
import com.weaverplatform.protocol.model.CreateRelationOperation;
import com.weaverplatform.protocol.model.RemoveRelationOperation;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Ignore("This file hangs")
public class RelationTest extends BaseTest {

  @Test
  public void run1_setupNodes() {
    // Wipe database
    wipe();

    // Create a relation node first and two other nodes which are going to hold the relation.
    String node1 = new CreateNodeOperation("unknown", "node-1").toJson();
    String node2 = new CreateNodeOperation("unknown", "node-2").toJson();
    String node3 = new CreateNodeOperation("unknown", "node-3").toJson();

    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body("[" + node1 + "," + node2 + "," + node3 + "]")
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .post("http://localhost:4567/write");
  }

  @Test
  public void run2_createRelationTest() throws SQLException {

    String relation = new CreateRelationOperation("unknown", "node-relation-1", "node-1", "hasFriend", "node-2").toJson();

    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body("[" + relation + "]")
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .post("http://localhost:4567/write");

    ResultSet rs = listRelation("node-relation-1", "node-1", "hasFriend");
    assertEquals(rs.getInt(1), 4);
    assertEquals(rs.getInt(2), 1);
    assertEquals(rs.getInt(3), 1);
  }

  @Test
  public void run3_removeRelationTest() throws SQLException {
    String nodeName = "node-relation-removed-1";
    String json = new RemoveRelationOperation("unknown", "node-relation-1", nodeName).toJson();

    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body("[" + json + "]")
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .post("http://localhost:4567/write");

    ResultSet rs = listNode(nodeName);
    assertEquals(rs.getString(1), nodeName);
  }

  @Test
  public void run4_replaceRelationTest() throws SQLException{
    String json = new CreateRelationOperation("unknown", "node-relation-replaced-2", "node-1", "hasFriend", "node-3", "FILLED-BY-CLASS", "node-relation-1").toJson();

    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body("[" + json + "]")
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .post("http://localhost:4567/write");

    ResultSet rs = listRelation("node-relation-replaced-2", "node-1", "hasFriend");
    assertEquals(rs.getInt(1), 6);
    assertEquals(rs.getInt(2), 1);
    assertEquals(rs.getInt(3), 1);
  }

  private ResultSet listRelation(String node, String source, String relationKey) throws SQLException {
    PreparedStatement ps = prepareQuery(TestQuery.TEST_LIST_RELATION);
    ps.setString(1, node);
    ps.setString(2, source);
    ps.setString(3, relationKey);
    ResultSet rs = ps.executeQuery();
    rs.next();
    return rs;
  }

}
