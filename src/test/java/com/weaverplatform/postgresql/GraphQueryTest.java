package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.model.WeaverNode;
import com.weaverplatform.postgresql.database.query.model.ConditionMap;
import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

/**
 * @author Gijs van der Ent
 */
public class GraphQueryTest extends BaseTest {

  private static boolean setUpRan = false; // Needs to be static because each test method gets its own instance
  private static final String uuidNode1 = UUID.randomUUID().toString();
  private static final String uuidNode2 = UUID.randomUUID().toString();


  @Before
  public void createGraph() {
    if(!setUpRan) {  // Ensure this construct only runs once before the class
      getDatabase().write(
        // Construct equal graphs with a single node pointing to another single node

        new WritesBuilder()
          .withUser("GraphQueryTestUser")
          .addNode(uuidNode1)
          .withGraph("GraphQueryTestGraph")
          .addNode(uuidNode2)
        .getWrites()
      );
      setUpRan = true;
    }
  }

  @Test
  public void testGetNode1WithoutGraphRestriction() {
    FindQueryResult result = (FindQueryResult) getDatabase().query(query().restrict(uuidNode1));
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", 1, nodes.size());
  }

  @Test
  public void testGetNode1WithGraphRestriction() {
    FindQueryResult result = (FindQueryResult) getDatabase().query(query().restrict(uuidNode1).addInGraph(null));
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", 1, nodes.size());
  }

  @Test
  public void testNoGraphRestrictionQuery() {
    FindQueryResult result = (FindQueryResult) getDatabase().query(query());
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", 2, nodes.size());
  }

  @Test
  public void testGetNode1WithWrongGraphIncludeRelation() {
    WeaverQuery q = query().restrict(uuidNode1).addInGraph("doesntexist");
    q.setNoRelations(false);
    FindQueryResult result = (FindQueryResult) getDatabase().query(q);
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", 0, nodes.size());
  }

  @Test
  public void testGetNode1WithOnlyGraphSpecification() {
    WeaverQuery q = query().addInGraph(null);
    q.setNoRelations(false);
    FindQueryResult result = (FindQueryResult) getDatabase().query(q);
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", 1, nodes.size());
  }

  @Test
  public void testGetNode2WithMultipleWrongGraphsIncludeRelation() {
    WeaverQuery q = query().restrict(uuidNode2).addInGraph("doesntexist").addInGraph(null);
    q.setNoRelations(false);
    FindQueryResult result = (FindQueryResult) getDatabase().query(q);
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", 0, nodes.size());
  }

  @Test
  public void testGetNode2WithoutGraphRestriction() {
    FindQueryResult result = (FindQueryResult) getDatabase().query(query().restrict(uuidNode2));
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", 1, nodes.size());
  }

  @Test
  public void testGetNode2WithGraphRestriction() {
    FindQueryResult result = (FindQueryResult) getDatabase().query(query().restrict(uuidNode2).addInGraph("GraphQueryTestGraph"));
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", 1, nodes.size());
  }

  @Test
  public void testGetNode2WithWrongGraphRestriction() {
    FindQueryResult result = (FindQueryResult) getDatabase().query(query().restrict(uuidNode2).addInGraph(null));
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", 0, nodes.size());
  }

  @Test
  public void testGetNode1WithWrongGraphRestriction() {
    FindQueryResult result = (FindQueryResult) getDatabase().query(query().restrict(uuidNode1).addInGraph("GraphQueryTestGraph"));
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", 0, nodes.size());
  }
}
