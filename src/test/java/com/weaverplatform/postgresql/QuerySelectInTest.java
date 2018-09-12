package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.Database;
import com.weaverplatform.postgresql.database.Postgres;
import com.weaverplatform.postgresql.database.model.WeaverNode;
import com.weaverplatform.postgresql.database.query.model.*;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

/**
 * @author Mohamad Alamili
 */
public class QuerySelectInTest extends BaseTest {
  @Test
  public void testSimpleSelectIn() {
    Database db = getDatabase();
    String testName = "testSimpleSelectIn";

    db.write(new WritesBuilder()
      .withGraph(testName)
      .addNode("a")
      .addRelation("testRelation")
      .addNode("b")
      .getWrites()
    );

    WeaverQuery q = new WeaverQuery()
      .addInGraph(testName)
      .restrict("b")
      .selectIn("testRelation");

    FindQueryResult res = (FindQueryResult) db.query(q);

    assertNotNull("There should be relations in", res.getNodes().get(0).getRelationsIn());
    assertEquals("Expected one relationName in", 1, res.getNodes().get(0).getRelationsIn().size());
    assertTrue("Expected relationName", res.getNodes().get(0).getRelationsIn().keySet().contains("testRelation"));
    assertEquals("Expected number of sources", 1, res.getNodes().get(0).getRelationsIn().get("testRelation").size());
    assertEquals("Expected source", "a", res.getNodes().get(0).getRelationsIn().get("testRelation").get(0).getSource().getNodeId());
  }

  @Test
  public void testWildcardSelectIn() {
    Database db = getDatabase();
    String testName = "testWildcardSelectIn";

    db.write(new WritesBuilder()
      .withGraph(testName)
      .addNode("a")
      .addRelation("testRelation")
      .addNode("b")
      .getWrites()
    );

    WeaverQuery q = new WeaverQuery()
      .addInGraph(testName)
      .restrict("b")
      .selectIn("*");

    FindQueryResult res = (FindQueryResult) db.query(q);

    assertNotNull("There should be relations in", res.getNodes().get(0).getRelationsIn());
    assertEquals("Expected one relationName in", 1, res.getNodes().get(0).getRelationsIn().size());
  }

  @Test
  public void testNonQualifying() {
    Database db = getDatabase();
    String testName = "testNonQualifying";

    db.write(new WritesBuilder()
      .withGraph(testName)
      .addNode("a")
      .addRelation("testNonMatchingRelation")
      .addNode("b")
      .getWrites()
    );

    WeaverQuery q = new WeaverQuery()
      .addInGraph(testName)
      .restrict("b")
      .selectIn("testRelation");

    FindQueryResult res = (FindQueryResult) db.query(q);

    assertNull("There should not be relations in", res.getNodes().get(0).getRelationsIn());
  }

  @Test
  public void testPath() {
    Database db = getDatabase();
    String testName = "testPath";

    db.write(new WritesBuilder()
      .withGraph(testName)
      .addNode("a")
      .addRelation("testRelation1")
      .addNode("b")
      .addRelation("testRelation2")
      .addNode("c")
      .getWrites()
    );

    WeaverQuery q = new WeaverQuery()
      .addInGraph(testName)
      .restrict("c")
      .selectIn("testRelation2", "testRelation1");

    FindQueryResult res = (FindQueryResult) db.query(q);

    assertNotNull("There should relations in", res.getNodes().get(0).getRelationsIn());
    assertEquals("Expected 1 relationNames in", 1, res.getNodes().get(0).getRelationsIn().size());

    assertTrue("Expected relationName2", res.getNodes().get(0).getRelationsIn().keySet().contains("testRelation2"));
    assertEquals("Expected number of sources2", 1, res.getNodes().get(0).getRelationsIn().get("testRelation2").size());
    assertEquals("Expected source2", "b", res.getNodes().get(0).getRelationsIn().get("testRelation2").get(0).getSource().getNodeId());

    WeaverNode intermediate = res.getNodes().get(0).getRelationsIn().get("testRelation2").get(0).getSource();

    assertNotNull("There should relations in1", intermediate.getRelationsIn());
    assertEquals("Expected 1 relationNames in1", 1, intermediate.getRelationsIn().size());
    assertTrue("Expected relationName1", intermediate.getRelationsIn().keySet().contains("testRelation1"));
    assertEquals("Expected number of sources1", 1, intermediate.getRelationsIn().get("testRelation1").size());
    assertEquals("Expected source1", "a", intermediate.getRelationsIn().get("testRelation1").get(0).getSource().getNodeId());
  }

  @Test
  public void testMultiple() {
    Database db = getDatabase();
    String testName = "testMultipleClauses";

    db.write(new WritesBuilder()
      .withGraph(testName)
      .addNode("a")
      .addRelation("testRelation1")
      .addNode("b")
      .addNode("c")
      .addRelationBetweenNodes("c", "testRelation2", "b")
      .getWrites()
    );

    WeaverQuery q = new WeaverQuery()
      .addInGraph(testName)
      .restrict("b")
      .selectIn("testRelation1")
      .selectIn("testRelation2");

    FindQueryResult res = (FindQueryResult) db.query(q);

    assertNotNull("There should relations in", res.getNodes().get(0).getRelationsIn());
    assertEquals("Expected two relationNames in", 2, res.getNodes().get(0).getRelationsIn().size());

    assertTrue("Expected relationName1", res.getNodes().get(0).getRelationsIn().keySet().contains("testRelation1"));
    assertEquals("Expected number of sources1", 1, res.getNodes().get(0).getRelationsIn().get("testRelation1").size());
    assertEquals("Expected source1", "a", res.getNodes().get(0).getRelationsIn().get("testRelation1").get(0).getSource().getNodeId());

    assertTrue("Expected relationName2", res.getNodes().get(0).getRelationsIn().keySet().contains("testRelation2"));
    assertEquals("Expected number of sources2", 1, res.getNodes().get(0).getRelationsIn().get("testRelation2").size());
    assertEquals("Expected source2", "c", res.getNodes().get(0).getRelationsIn().get("testRelation2").get(0).getSource().getNodeId());
  }

  @Test
  public void testSelectAppliesOnSelectIn() {
    Database db = getDatabase();
    String testName = "testSelectAppliesOnSelectIn";

    db.write(new WritesBuilder()
      .withGraph(testName)
      .addNode("a")
      .setAttribute("someAttr", "a value")
      .setAttribute("someOtherAttr", "another value")
      .addRelation("testRelation")
      .addNode("b")
      .getWrites()
    );

    WeaverQuery q = new WeaverQuery()
      .addInGraph(testName)
      .restrict("b")
      .select("someAttr")
      .selectIn("*");

    FindQueryResult res = (FindQueryResult) db.query(q);
    WeaverNode nodeA = res.getNodes().get(0).getRelationsIn().get("testRelation").get(0).getSource();
    assertEquals("a value", nodeA.getAttributes().get("someAttr").get(0).getValue());
    assertNull(nodeA.getAttributes().get("someOtherAttr"));
  }

  @Test
  public void testSelectRelationAppliesOnSelectIn() {
    Database db = getDatabase();
    String testName = "testSelectRelationAppliesOnSelectIn";

    db.write(new WritesBuilder()
      .withGraph(testName)
      .addNode("a")
      .addRelation("testRelation")
      .addNode("b")
      .addNode("c")
      .addNode("d")
      .addRelationBetweenNodes("a", "includeRelation", "c")
      .addRelationBetweenNodes("a", "excludeRelation", "d")
      .getWrites()
    );

    WeaverQuery q = new WeaverQuery()
      .addInGraph(testName)
      .restrict("b")
      .selectRelations("includeRelation")
      .selectIn("*");

    FindQueryResult res = (FindQueryResult) db.query(q);
    WeaverNode nodeA = res.getNodes().get(0).getRelationsIn().get("testRelation").get(0).getSource();
    assertNotNull("Expect the included relation to be loaded", nodeA.getRelations().get("includeRelation"));
    assertNull("Expect the not specified relation to not be loaded", nodeA.getRelations().get("excludeRelation"));
  }
}


