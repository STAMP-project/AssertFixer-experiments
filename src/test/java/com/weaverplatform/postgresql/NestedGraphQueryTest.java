package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.model.WeaverNode;
import com.weaverplatform.postgresql.database.query.model.ConditionMap;
import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Gijs van der Ent
 */
@RunWith(Parameterized.class)
public class NestedGraphQueryTest extends BaseTest {
  private static final String user = "nestedqueryuser";
  private static final String graph = "NestedQueryGraph";
  private static final String alternateGraph = "NestedQueryGraph2";
  private static final String relation = "testNestedRelation";
  private static final String nodeWithRelationIn = "nodeWithRelationIn";
  private static final String nodeWithRelationOut = "nodeWithRelationOut";
  private final boolean testRegular;

  @Parameterized.Parameters
  public static List<Object[]> getParameters() {
    return Arrays.asList(new Object[][]{
      {Boolean.TRUE},
      {Boolean.FALSE}
    });
  }

  /**
   * @param testRegular whether to test the regular graph or the alternative
   */
  public NestedGraphQueryTest(boolean testRegular) {
    this.testRegular = testRegular;
  }

  private static boolean setUpRan = false; // Needs to be static because each test method gets its own instance
  @Before
  public void createGraph() {
    if(!setUpRan) {  // Ensure this construct only runs once before the class
      getDatabase().write(
        // Construct equal graphs with a single node pointing to another single node

        new WritesBuilder()
          .withUser(user)
          .withGraph(graph)
          .addNode(nodeWithRelationOut)
          .addRelation(relation)
          .addNode(nodeWithRelationIn)
          .withGraph(alternateGraph)
          .addNode(nodeWithRelationOut)
          .addRelation(relation)
          .addNode(nodeWithRelationIn)
        .getWrites()
      );
      setUpRan = true;
    }
  }

  @Test
  public void testSelectOut() {
    FindQueryResult result = (FindQueryResult)getDatabase().query(
      query()
        .addInGraph(testRegular ? graph : alternateGraph)
        .restrict(nodeWithRelationOut)
        .addSelectOut(new String[] { relation })
    );
    List<WeaverNode> nodes = result.getNodes();

    assertEquals("Number of nodes", 1, nodes.size());
    assertEquals("Number of relation keys", 1, nodes.get(0).getRelations().size());
    assertEquals("Number of relations", 1, nodes.get(0).getRelations().get(relation).size());
    assertEquals("Relation target graph", testRegular? graph : alternateGraph, nodes.get(0).getRelations().get(relation).get(0).getTarget().getGraph());
  }

  @Test
  public void testNestedQueryRelationOut() {
    List<WeaverQuery> clauses = new ArrayList<>();
    clauses.add(new WeaverQuery().addInGraph(testRegular?graph:alternateGraph));
    ConditionMap cond = new ConditionMap();
    cond.put("$relOut", clauses);
    FindQueryResult result = (FindQueryResult) getDatabase().query(query().addCondition(relation, cond));
    List<WeaverNode> nodes = result.getNodes();

    assertEquals("Number of nodes", 1, nodes.size());
  }

  @Test
  public void testMultipleNestedQueriesWEAV368() {
    List<WeaverQuery> clauses = new ArrayList<>();
    clauses.add(new WeaverQuery().addInGraph(testRegular?graph:alternateGraph));
    List<WeaverQuery> clauses2 = new ArrayList<>();
    clauses2.add(new WeaverQuery().addInGraph(testRegular?graph:alternateGraph));

    ConditionMap cond = new ConditionMap();
    cond.put("$relOut", clauses);
    cond.put("$noRelIn", clauses2);

    FindQueryResult result = (FindQueryResult) getDatabase().query(query().addCondition(relation, cond));
    List<WeaverNode> nodes = result.getNodes();

    assertEquals("Number of nodes", 1, nodes.size());
  }
}
