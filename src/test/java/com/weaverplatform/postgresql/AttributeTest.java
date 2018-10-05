package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.TestQuery;
import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import com.weaverplatform.protocol.model.AttributeDataType;
import com.weaverplatform.protocol.model.CreateAttributeOperation;
import com.weaverplatform.protocol.model.CreateNodeOperation;
import com.weaverplatform.protocol.model.RemoveAttributeOperation;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AttributeTest extends BaseTest {

  @Test
  public void run1_createNodeTest() throws SQLException {
    // Create a node first
    String nodeName = "node-1";
    String json = new CreateNodeOperation("unknown", nodeName).toJson();

    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body("[" + json + "]")
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .post("/write");

    ResultSet rs = listNode(nodeName);
    assertEquals(rs.getString(1), nodeName);
  }

  @Test
  public void run2_createAttributeStringTest() throws SQLException {
    String json = new CreateAttributeOperation("unknown", "node-attribute-1", "node-1",
        "name", "alex", AttributeDataType.STRING).toJson();

    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body("[" + json + "]")
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .post("/write");

    ResultSet rs = listAttribute("node-attribute-1", "node-1", "name");
    assertEquals(rs.getInt(1), 2);
    assertEquals(rs.getInt(2), 1);
    assertEquals(rs.getInt(3), 1);
    assertEquals(rs.getString(5), "alex");
    assertFalse(rs.next());
  }

  @Test
  public void run3_createAttributeBooleanTest() throws SQLException {
    String json = new CreateAttributeOperation("unknown", "node-attribute-2",
        "node-1", "isOnline", true, AttributeDataType.BOOLEAN).toJson();

    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body("[" + json + "]")
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .post("/write");

    ResultSet rs = listAttribute("node-attribute-2", "node-1", "isOnline");
    assertEquals(rs.getInt(1), 3);
    assertEquals(rs.getInt(2), 1);
    assertEquals(rs.getInt(3), 2);
    assertEquals(rs.getBoolean(6), true);
    assertFalse(rs.next());
  }

  @Test
  public void run4_createAttributeDoubleTest() throws SQLException {
    String json = new CreateAttributeOperation("unknown", "node-attribute-3",
        "node-1", "bank", 3.14, AttributeDataType.DOUBLE).toJson();

    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body("[" + json + "]")
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .post("/write");

    ResultSet rs = listAttribute("node-attribute-3", "node-1", "bank");
    assertEquals(rs.getInt(1), 4);
    assertEquals(rs.getInt(2), 1);
    assertEquals(rs.getInt(3), 3);
    assertEquals(rs.getDouble(4), 3.14, 0);
    assertFalse(rs.next());
  }

  @Test
  public void run5_createAttributeDateTest() throws SQLException {
    String json = new CreateAttributeOperation("unknown", "node-attribute-4",
        "node-1", "transferedCurrencyOn", 1220220000L, AttributeDataType.DATE).toJson();

    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body("[" + json + "]")
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .post("/write");

    ResultSet rs = listAttribute("node-attribute-4", "node-1", "transferedCurrencyOn");
    assertEquals(rs.getInt(1), 5);
    assertEquals(rs.getInt(2), 1);
    assertEquals(rs.getInt(3), 4);
    assertFalse(rs.next());
  }

  @Test
  public void run6_removeAttributeDateTest() throws SQLException {
    String json = new RemoveAttributeOperation("unknown", "node-attribute-4", "node-removed-1").toJson();

    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body("[" + json + "]")
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .post("/write");

    PreparedStatement ps = prepareQuery(TestQuery.TEST_REMOVED_NODE);
    ps.setInt(1, 6);
    ps.setInt(2, 5);
    ResultSet rs = ps.executeQuery();
    assertTrue("There is a result", rs.next());
  }

  @Test
  public void run7_replaceAttributeDoubleTest() throws SQLException {
    String json = new CreateAttributeOperation("unknown", "node-attribute-5",
        "node-1", "bank", 6.5, AttributeDataType.DOUBLE, "FILLED-BY-CLASS", "node-attribute-3").toJson();

    given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body("[" + json + "]")
      .expect()
      .statusCode(200)
      .body(equalTo("Success"))
      .when()
      .post("/write");

    ResultSet rs = listAttribute("node-attribute-5", "node-1", "bank");
    assertEquals(rs.getInt(1), 7);
    assertEquals(rs.getInt(2), 1);
    assertEquals(rs.getInt(3), 3);
    assertEquals(rs.getDouble(4), 6.5, 0);
    assertFalse(rs.next());
  }

  private ResultSet listAttribute(String node, String source, String attributeKey) throws SQLException {
    PreparedStatement ps = prepareQuery(TestQuery.TEST_LIST_ATTRIBUTE);
    ps.setString(1, node);
    ps.setString(2, source);
    ps.setString(3, attributeKey);
    ResultSet rs = ps.executeQuery();
    rs.next();
    return rs;
  }

}
