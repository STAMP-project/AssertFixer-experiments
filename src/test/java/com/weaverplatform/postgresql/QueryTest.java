package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.Postgres;
import com.weaverplatform.postgresql.database.model.WeaverNode;
import com.weaverplatform.postgresql.database.query.model.*;
import com.weaverplatform.postgresql.util.WeaverError;
import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Mohamad Alamili
 */
public class QueryTest extends BaseTest {

  @Test
  @Ignore
  public void shouldSelectAll(){

    QueryResult result = Postgres.INSTANCE.getDatabase(database).query(query());


    String body = given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body(query().toJson())
      .expect()
      .statusCode(200)
      .when()
      .post("http://localhost:4567/query")
      .thenReturn().asString();

    System.out.println();
    System.out.println(body);
  }


  @Test
  @Ignore
  public void shouldRestrictToSingleNode(){

    String json = query()
      .restrict("node-uid-test-2")
      .toJson();

    System.out.println(json);

    String body = given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .body(json)
      .expect()
      .statusCode(200)
      .when()
      .post("http://localhost:4567/query")
      .thenReturn().asString();

    System.out.println();
    System.out.println(body);
  }

  @Test
  @Ignore
  public void shouldQueryAgainstHistoryDummyTrackerTable() {
    String body = given()
      .contentType("application/json")
      .with()
      .queryParam("database", BaseTest.database)
      .queryParam("query","SELECT \"seqnr\", \"datetime\", \"user\", \"action\", \"node\", \"key\", \"from\", \"to\", \"oldTo\", \"value\" FROM \"dummy_tracker\" WHERE \"from\" IN ('cj5wil696000ubgxx1dimuhmg')")
      .expect()
      .statusCode(200)
      .when()
      .post("http://localhost:4567/postgresQuery")
      .thenReturn().asString();
    System.out.println();
    System.out.println(body);
  }


  @Test
  public void testBasicQuery() {
    FindQueryResult qr = (FindQueryResult)getDatabase().query(query());
    assertTrue(0 <= qr.getNodes().size());
  }

  @Test
  public void testReloutSortCombination() {
    WeaverQuery query = query();

    ConditionMap map = new ConditionMap();
    List<String> nodes = new ArrayList<>();
    nodes.add("ILSObject");
    map.put("$relOut", nodes);

    query.getConditions().put("rdf:type", map);
    query.getOrder().add("sebim:hasNameByLiteral");

    query.setNoRelations(true);


    FindQueryResult qr = (FindQueryResult)Postgres.INSTANCE.getDatabase(database).query(query);
    assertEquals(0, qr.getNodes().size());
  }

  @Test
  public void testEmptyRelationTargetArray() {
    WeaverQuery query = query();

    ConditionMap map = new ConditionMap();
    List<String> nodes = new ArrayList<>();
    map.put("$relOut", nodes);

    query.getConditions().put("rdf:type", map);
    query.getOrder().add("sebim:hasNameByLiteral");

    query.setNoRelations(true);

    try {
      Postgres.INSTANCE.getDatabase(database).query(query);
      assertTrue("Should throw an error", false);
    } catch (WeaverError e) {
      // This is expected behaviour
    }
  }

  @Test
  public void testRecursiveRelationOutGraphQuery() {
    String testId = "testRecursiveRelationOutGraphQuery";
    getDatabase().write(new WritesBuilder()
      .withGraph(testId)
      .withUser(testId)
      .addNode("relation-target")
      .addNode("relation-source")
      .addRelation("relation1", "hasRelation", "relation-target")
      .getWrites()
    );

    WeaverQuery query = query();
    RecursiveCondition r = new RecursiveCondition();
    r.setIncludeSelf(false);
    r.setNodeId("relation-target");
    r.setNodeGraph(testId);
    r.setOperation("$relOut");
    r.setRelation("hasRelation");
    query.addRecursiveCondition(r);

    FindQueryResult qr = (FindQueryResult)getDatabase().query(query);
    assertEquals("Expected a single result node", 1, qr.getNodes().size());
  }

  @Test
  public void selectRelationEmpty() {
    String testId = "selectRelationEmpty";
    getDatabase().write(new WritesBuilder()
        .withGraph(testId)
        .addNode("a")
        .addRelation("relation")
        .addNode("b")
        .getWrites()
    );

    WeaverQuery q = query();
    q.restrict("a");
    q.addInGraph(testId);
    q.selectRelations();

    FindQueryResult qr = (FindQueryResult)getDatabase().query(q);

    assertEquals("No relations should be returned", 0, qr.getNodes().get(0).getRelations().size());
  }

  @Test
  public void selectRelation() {
    String testId = "selectRelation";
    getDatabase().write(new WritesBuilder()
      .withGraph(testId)
      .addNode("a")
      .addRelation("relation")
      .addNode("b")
      .addNode("c")
      .addRelationBetweenNodes("a", "otherRelation", "c")
      .getWrites()
    );

    WeaverQuery q = query();
    q.restrict("a");
    q.addInGraph(testId);
    q.selectRelations("relation");

    FindQueryResult qr = (FindQueryResult)getDatabase().query(q);

    assertEquals("No other relations should be returned", null, qr.getNodes().get(0).getRelations().get("otherRelation"));
    assertEquals("The selected relation should be returned", 1, qr.getNodes().get(0).getRelations().get("relation").size());
  }

  @Test
  public void testRecursiveRelationInGraphQuery() {
    String testId = "testRecursiveRelationInGraphQuery";
    getDatabase().write(new WritesBuilder()
      .withGraph("testRecursiveRelationInGraphQueryAlternative")
      .addNode("something")
      .addRelation("goesInto")
      .addNode()
      .withGraph(testId)
      .withUser(testId)
      .addNode("something")
      .addRelation("goesInto")
      .addNode()
      .getWrites()
    );

    WeaverQuery query = query();
    RecursiveCondition r = new RecursiveCondition();
    r.setIncludeSelf(false);
    r.setNodeId("something");
    r.setNodeGraph(testId);
    r.setOperation("$relIn");
    r.setRelation("goesInto");
    query.addRecursiveCondition(r);

    FindQueryResult qr = (FindQueryResult)getDatabase().query(query);
    assertEquals("Expected a single result node", 1, qr.getNodes().size());
  }

  @Test
  public void testNodesInGraphQuery() {
    getDatabase().write(new WritesBuilder()
      .withGraph("nodesInGraphExclude")
      .addNode()
      .withGraph("nodesInGraphInclude")
      .addNode()
      .getWrites()
    );

    WeaverQuery query = query();
    query.addInGraph("nodesInGraphInclude");
    FindQueryResult result = (FindQueryResult)getDatabase().query(query);
    assertEquals("Expected a single node in defined graph", 1, result.getNodes().size());
  }

  @Test
  public void testRelationOut() {
    getDatabase().write(new WritesBuilder()
      .withGraph("testRelationOut")
      .addNode()
      .addRelation("hasRelation")
      .withGraph(null)
      .addNode("relationTarget")
      .getWrites()
    );

    ConditionMap map = new ConditionMap();
    List<String> values = new ArrayList<>();
    values.add("relationTarget");
    map.put("$relOut", values);
    WeaverQuery query = query().addCondition("hasRelation", map);
    FindQueryResult result = (FindQueryResult)getDatabase().query(query);
    assertEquals("Number of matching nodes", 1, result.getNodes().size());
  }

  @Test
  public void testRelationRelationIn() {
    getDatabase().write(new WritesBuilder()
      .withGraph("testRelationRelationIn")
      .addNode()
      .addRelation("hasRelation")
      .addNode("relationTarget")
      .getWrites()
    );

    ConditionMap map = new ConditionMap();
    List<String> values = new ArrayList<>();
    values.add("*");
    map.put("$relIn", values);
    WeaverQuery query = query().addCondition("hasRelation", map).setNoRelations(false);
    // Next level testing is actually returning nodes here
    FindQueryResult result = (FindQueryResult)getDatabase().query(query);
    assertTrue("At least some nodes", result.getNodes().size() > 0);
  }

  @Test
  public void testRelationRelationInMap() {
    getDatabase().write(new WritesBuilder()
      .withGraph("alternateTestRelationRelationInMap")
      .addNode("relationSource")
      .addRelation("hasRelation")
      .addNode("alternateNonMatchingTarget")
      .withGraph("testRelationRelationInMap")
      .addNode("relationSource")
      .addRelation("hasRelation")
      .addNode("relationTarget")
      .getWrites()
    );

    ConditionMap map = new ConditionMap();
    List<Object> values = new ArrayList<>();
    Map<String, String> value = new HashMap<>();
    value.put("id", "relationSource");
    value.put("graph", "testRelationRelationInMap"); //only nodes with relations from relationSource in this graph
    values.add(value);
    map.put("$relIn", values);
    WeaverQuery query = query().addCondition("hasRelation", map).setNoRelations(false);
    // Next level testing is actually returning nodes here
    FindQueryResult result = (FindQueryResult)getDatabase().query(query);
    assertEquals("Number of matching nodes", 1, result.getNodes().size());
  }

  @Test
  public void testRelationRelationOut() {
    getDatabase().write(new WritesBuilder()
      .withGraph("testRelationRelationOut")
      .addNode()
      .addRelation("hasRelation")
      .addNode("relationTarget")
      .getWrites()
    );

    ConditionMap map = new ConditionMap();
    List<String> values = new ArrayList<>();
    values.add("*");
    map.put("$relOut", values);
    WeaverQuery query = query().addCondition("hasRelation", map).setNoRelations(false);
    // Next level testing is actually returning nodes here
    FindQueryResult result = (FindQueryResult)getDatabase().query(query);
    assertTrue("There is at least some node", result.getNodes().size() > 0);
  }

  @Test
  public void testRelationOutMultipleChoice() {
    getDatabase().write(new WritesBuilder()
      .withGraph("testRelationOutMultipleChoice")
      .addNode()
      .addRelation("hasRelation")
      .withGraph(null)
      .addNode("relationTarget2")
      .getWrites()
    );

    ConditionMap map = new ConditionMap();
    List<String> values = new ArrayList<>();
    values.add("relationTarget2");
    values.add("nonExistent");
    map.put("$relOut", values);
    WeaverQuery query = query();
    query.addInGraph("testRelationOutMultipleChoice");
    query.addCondition("hasRelation", map);
    FindQueryResult result = (FindQueryResult)getDatabase().query(query);
    assertEquals("Number of matching nodes", 1, result.getNodes().size());
  }

  @Test
  public void testReturnsGraph() {
    final String testId = "testReturnsGraph";
    getDatabase().write(new WritesBuilder()
      .withGraph(testId )
      .addNode()
      .getWrites()
    );

    WeaverQuery query = query();
    query.addInGraph(testId);
    FindQueryResult result = (FindQueryResult)getDatabase().query(query);
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", 1, nodes.size());
    assertEquals("Graph", testId, nodes.get(0).getGraph());
  }

  @Test
  public void testOldTemplateReturnsGraph() {
    final String testId = "testReturnsGraph";
    getDatabase().write(new WritesBuilder()
      .addNode()
      .getWrites()
    );

    WeaverQuery query = query();
    query.setNoRelations(false);
    FindQueryResult result = (FindQueryResult)getDatabase().query(query);
    List<WeaverNode> nodes = result.getNodes();
    assertTrue("Some nodes returned", nodes.size() > 0);
  }

  @Test
  public void testReturnsRelationsGraph() {
    final String testId = "testReturnsRelationsGraph";
    getDatabase().write(new WritesBuilder()
      .withGraph(testId)
      .addNode("source")
      .addRelation("hasRelation")
      .addNode()
      .getWrites()
    );

    WeaverQuery query = query();
    query.addInGraph(testId);
    query.restrict("source");
    FindQueryResult result = (FindQueryResult)getDatabase().query(query);
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", 1, nodes.size());
    WeaverNode node = nodes.get(0);
    assertEquals("Number of relations", 1, node.getRelations().size());
    assertEquals("RelationGraph", testId, node.getRelations().values().iterator().next().get(0).getGraph());
    assertEquals("RelationTargetGraph", testId, node.getRelations().values().iterator().next().get(0).getTarget().getGraph());
  }

  @Test
  public void testRelationOutNoRelationInOnSameKey() {
    final String testId = "testRelationOutNoRelationInOnSameKey";
    getDatabase().write(new WritesBuilder()
      .withGraph(testId)
      .addNode()
      .addRelation("relation")
      .addNode()
      .addRelation("relation")
      .addNode()
      .getWrites()
    );

    WeaverQuery query = query().addInGraph(testId);
    ConditionMap map = new ConditionMap();
    List<String> values = new ArrayList<>();
    values.add("*");
    map.put("$relOut", values);
    map.put("$noRelIn", values);
    query.addCondition("relation", map);

    FindQueryResult result = (FindQueryResult)getDatabase().query(query);
    assertEquals("Number of nodes", 1, result.getNodes().size());
  }

  @Test
  public void testNoRelationOutRelationInOnSameKey() {
    final String testId = "testNoRelationOutRelationInOnSameKey";
    getDatabase().write(new WritesBuilder()
      .withGraph(testId)
      .addNode()
      .addRelation("relation")
      .addNode()
      .addRelation("relation")
      .addNode()
      .getWrites()
    );

    WeaverQuery query = query().addInGraph(testId);
    ConditionMap map = new ConditionMap();
    List<String> values = new ArrayList<>();
    values.add("*");
    map.put("$noRelOut", values);
    map.put("$relIn", values);
    query.addCondition("relation", map);
    FindQueryResult result = (FindQueryResult)getDatabase().query(query);
    assertEquals("Number of nodes", 1, result.getNodes().size());
  }

  @Test
  public void testTrueExists() {
    final String testId = "testTrueExists";

    getDatabase().write(new WritesBuilder()
      .withGraph(testId)
      .addNode()
      .setAttribute("test", "value")
      .addNode()
    .getWrites());

    WeaverQuery query = query().addInGraph(testId);
    ConditionMap map = new ConditionMap();
    map.put("$exists", true);
    query.addCondition("test", map);
    FindQueryResult result = (FindQueryResult) getDatabase().query(query);
    assertEquals("Number of nodes", 1, result.getNodes().size());
    assertEquals("Value", "value", result.getNodes().get(0).getAttributes().get("test").get(0).getValue());
  }

  @Test
  public void testFalseExists() {
    final String testId = "testFalseExists";

    getDatabase().write(new WritesBuilder()
      .withGraph(testId)
      .addNode()
      .setAttribute("test", "value")
      .addNode()
      .getWrites());

    WeaverQuery query = query().addInGraph(testId);
    ConditionMap map = new ConditionMap();
    map.put("$exists", false);
    query.addCondition("test", map);
    FindQueryResult result = (FindQueryResult) getDatabase().query(query);
    assertEquals("Number of nodes", 1, result.getNodes().size());
    assertEquals("Value", null, result.getNodes().get(0).getAttributes().get("test"));
  }

  @Test
  public void testTargettedRelationCondition() {
    final String testId = "testTargettedRelationCondition";

    getDatabase().write(new WritesBuilder()
      .withGraph(testId)
      .addNode("node1")
      .addRelation("link")
      .addNode("node2")
      .addRelation("link")
      .addNode("node3")
      .addRelationBetweenNodes("node1", "link", "node3")
      .getWrites());


    WeaverQuery query = query().addInGraph(testId);
    ConditionMap map = new ConditionMap();
    List<Object> relOutValues = new ArrayList<>();
    List<String> noRelInValues = new ArrayList<>();

    Map<String, String> nodeInGraphReference = new HashMap<>();
    nodeInGraphReference.put("id", "node3");
    nodeInGraphReference.put("graph", testId);

    relOutValues.add(nodeInGraphReference);
    noRelInValues.add("*");
    map.put("$relOut", relOutValues);
    map.put("$noRelIn", noRelInValues);
    query.addCondition("link", map);
    FindQueryResult result = (FindQueryResult)getDatabase().query(query);
    assertEquals("Number of nodes", 1, result.getNodes().size());
  }

  @Test
  public void testAlwaysLoadLeafs() {
    String testId = "testAlwaysLoadLeafs";

    getDatabase().write(
      new WritesBuilder()
      .withGraph(testId)
      .addNode("start")
      .addRelation("key")
      .addNode()
      .addRelation("key")
      .addNode()
      .getWrites()
    );

    FindQueryResult result = (FindQueryResult) getDatabase().query(new WeaverQuery().restrict("start").addAlwaysLoadRelation("key"));
    assertEquals("Number of nodes", 1, result.getNodes().size());
    WeaverNode aNode = result.getNodes().get(0);
    assertEquals("First level graph", testId, aNode.getGraph());
    assertEquals("First level relation count", 1, aNode.getRelations().get("key").size());
    WeaverNode leafNode = aNode.getRelations().get("key").get(0).getTarget();
    assertEquals("Leaf node graph", testId, leafNode.getGraph());
  }

  @Test
  public void testAlwaysLoadMultipleLeafs() {
    String testId = "testAlwaysLoadMultipleLeafs";
    String firstRel = "first", secondRel = "second";

    getDatabase().write(
      new WritesBuilder()
        .withGraph(testId)
        .addNode("start")
        .addRelation(firstRel)
        .addNode("intermediate")
        .addRelation(secondRel)
        .addNode("one")
        .addNode("other")
        .addRelationBetweenNodes("intermediate", secondRel,"other")
        .getWrites()
    );

    FindQueryResult result = (FindQueryResult) getDatabase().query(new WeaverQuery().addInGraph(testId).restrict("start").addAlwaysLoadRelation(secondRel));
    assertEquals("Number of nodes", 1, result.getNodes().size());
    WeaverNode aNode = result.getNodes().get(0);
    assertEquals("start-intermediate relation count", 1, aNode.getRelations().get(firstRel).size());
    WeaverNode intermediateNode = aNode.getRelations().get(firstRel).get(0).getTarget();
    assertEquals("Leaf node relations", 1, intermediateNode.getRelations().size());
    assertNotNull("Leaf node secondRel relation", intermediateNode.getRelations().get(secondRel));
    assertEquals("Leaf node secondRel targets", 2, intermediateNode.getRelations().get(secondRel).size());
  }
}
