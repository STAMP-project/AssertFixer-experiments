package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.model.WeaverNode;
import com.weaverplatform.postgresql.database.query.model.ConditionMap;
import com.weaverplatform.postgresql.database.query.model.CountQueryResult;
import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CountTest extends BaseTest {
  @Test
  public void testCount() {
    getDatabase().write(new WritesBuilder()
      .addNode("one-source")
      .addRelation("1")
      .addNode("target")
      .addNode("other-source")
      .addRelationBetweenNodes("other-source", "other-relation", "target")
      .getWrites());

    CountQueryResult res = (CountQueryResult) getDatabase().query(new WeaverQuery().count());
    assertEquals(3, res.getCount());
  }

  @Test
  public void testHasRelationsCount() {
    getDatabase().write(new WritesBuilder()
      .withGraph("testHasRelationsCount")
      .addNode("one-source")
      .addRelation("1")
      .addNode("target")
      .addNode("other-source")
      .addRelationBetweenNodes("other-source", "other-relation", "target")
      .addRelationBetweenNodes("other-source", "another-relation", "target")
      .getWrites());

    ConditionMap map = new ConditionMap();
    List<String> values = new ArrayList<>();
    values.add("target");
    map.put("$relOut", values);
    WeaverQuery query = query().addCondition("*", map);

    CountQueryResult res = (CountQueryResult) getDatabase().query(
      query.count());
    assertEquals(2, res.getCount());
  }

  @Test
  public void testGraphCount() {
    getDatabase().write(new WritesBuilder()
      .withGraph("graph-count-1")
      .addNode()
      .addNode()
      .addNode()
      .withGraph("graph-count-2")
      .addNode()
      .addNode()
      .addNode()
      .addNode()
      .addNode()
      .getWrites());

    WeaverQuery query = query().addInGraph("graph-count-1").addInGraph("graph-count-2").addInGraph(null);

    CountQueryResult res = (CountQueryResult) getDatabase().query(
      query.countPerGraph());
    assertEquals("Number of nodes in graph-count-1", 3, res.getGraphCount("graph-count-1"));
    assertEquals("Number of nodes in graph-count-2", 5, res.getGraphCount("graph-count-2"));
  }

  @Test
  public void testGraphWithRelationOutCount() {
    getDatabase().write(new WritesBuilder()
      .addNode("graphcountrelouttarget")
      .withGraph("graph-count-relout-1")
      .addNode("11")
      .addNode("12")
      .addNode("13")
      .addRelationBetweenNodes("11", "link", "graphcountrelouttarget")
      .addRelationBetweenNodes("12", "link", "graphcountrelouttarget")
      .addRelationBetweenNodes("12", "otherlink", "graphcountrelouttarget")
      .withGraph("graph-count-relout-2")
      .addNode("21")
      .addNode("22")
      .addNode("23")
      .addNode("24")
      .addNode("25")
      .addRelationBetweenNodes("21", "link", "graphcountrelouttarget")
      .addRelationBetweenNodes("22", "link", "graphcountrelouttarget")
      .addRelationBetweenNodes("24", "link", "graphcountrelouttarget")
      .addRelationBetweenNodes("24", "otherlink", "graphcountrelouttarget")
      .addRelationBetweenNodes("24", "morelink", "graphcountrelouttarget")
      .getWrites());

    ConditionMap map = new ConditionMap();
    List<String> values = new ArrayList<>();
    values.add("graphcountrelouttarget");
    map.put("$relOut", values);

    WeaverQuery query = query().addInGraph("graph-count-relout-1").addInGraph("graph-count-relout-2").addInGraph(null).addCondition("*", map);

    CountQueryResult res = (CountQueryResult) getDatabase().query(
      query.countPerGraph());
    assertEquals("Number of nodes in graph-count-relout-1", 2, res.getGraphCount("graph-count-relout-1"));
    assertEquals("Number of nodes in graph-count-relout-2", 3, res.getGraphCount("graph-count-relout-2"));
  }

  @Test
  public void testQueryWithSubquery() {
    String testName = "testQueryWithSubquery";
    getDatabase().write(
      new WritesBuilder()
        .addNode(testName + "1")
        .addNode(testName + "2")
        .addNode(testName + "3")
        .addRelationBetweenNodes(testName+"2", "link", testName+"3")
        .addRelationBetweenNodes(testName+"1", "link", testName+"3")
        .addRelationBetweenNodes(testName+"1", "link-two", testName+"3")
      .getWrites()
    );
    int expectedCount = 2;

    List<WeaverQuery> nestedQueries = new ArrayList<>();
    nestedQueries.add(new WeaverQuery().restrict(testName + "3"));
    ConditionMap relationOutCondition = new ConditionMap();
    relationOutCondition.put("$relOut", nestedQueries);
    WeaverQuery q = query().addCondition("*", relationOutCondition).setLimit(2);

    FindQueryResult result = (FindQueryResult)getDatabase().query(q);
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", expectedCount, nodes.size());
  }
}
