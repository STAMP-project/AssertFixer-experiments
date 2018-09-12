package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.model.WeaverNode;
import com.weaverplatform.postgresql.database.query.model.ConditionMap;
import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Gijs van der Ent
 */
public class NestedQueryTest extends BaseTest {

  private static boolean setUpRan = false; // Needs to be static because each test method gets its own instance

  @Before
  public void createGraph() {
    if(!setUpRan) {  // Ensure this construct only runs once before the class
      getDatabase().write(
        // Construct equal graphs with a single node pointing to another single node

        new WritesBuilder()
          .withUser("NestedQueryTestUser")
          .addNode()
          .addRelation("relTo")
          .addNode()
          .setAttribute("testAttribute", "match")
          .addRelation("relTo")
          .addNode()
          .setAttribute("testAttribute", "nonmatch")
        .getWrites()
      );
      setUpRan = true;
    }
  }


  @Test
  public void testNestedQueryRelationOut() {
    List<WeaverQuery> nestedQueries = new ArrayList<>();
    nestedQueries.add(new WeaverQuery().equals("testAttribute", "match"));
    ConditionMap relationOutCondition = new ConditionMap();
    relationOutCondition.put("$relOut", nestedQueries);
    FindQueryResult result = (FindQueryResult)getDatabase().query(query().addCondition("relTo", relationOutCondition));
    List<WeaverNode> nodes = result.getNodes();

    assertEquals("Number of nodes", 1, nodes.size());
  }

  @Test
  public void testDoubleNestedQueryRelationOut() {
    List<WeaverQuery> innerNestedQueries = new ArrayList<>();
    innerNestedQueries.add(new WeaverQuery().equals("testAttribute", "nonmatch"));
    ConditionMap innerCondition = new ConditionMap();
    innerCondition.put("$relOut", innerNestedQueries);

    List<WeaverQuery> outerNestedQueries = new ArrayList<>();
    outerNestedQueries.add(new WeaverQuery().addCondition("relTo", innerCondition));

    ConditionMap relationOutCondition = new ConditionMap();
    relationOutCondition.put("$relOut", outerNestedQueries);

    FindQueryResult result = (FindQueryResult)getDatabase().query(query().addCondition("relTo", relationOutCondition));
    List<WeaverNode> nodes = result.getNodes();

    assertEquals("Number of nodes", 1, nodes.size());
  }

  @Test
  public void testNestedQueryNonMatchRelationOut() {
    List<WeaverQuery> nestedQueries = new ArrayList<>();
    nestedQueries.add(new WeaverQuery().equals("testAttribute", "doesntexist"));
    ConditionMap relationOutCondition = new ConditionMap();
    relationOutCondition.put("$relOut", nestedQueries);
    FindQueryResult result = (FindQueryResult)getDatabase().query(query().addCondition("relTo", relationOutCondition));
    List<WeaverNode> nodes = result.getNodes();

    assertEquals("Number of nodes", 0, nodes.size());
  }

  @Test
  public void testNestedQueryMatchWildcardRelationOut() {
    List<WeaverQuery> nestedQueries = new ArrayList<>();
    nestedQueries.add(new WeaverQuery().equals("testAttribute", "match"));
    ConditionMap relationOutCondition = new ConditionMap();
    relationOutCondition.put("$relOut", nestedQueries);
    FindQueryResult result = (FindQueryResult)getDatabase().query(query().addCondition("*", relationOutCondition));
    List<WeaverNode> nodes = result.getNodes();

    assertEquals("Number of nodes", 1, nodes.size());
  }

  @Test
  public void testNestedQueryNonMatchWildcardRelationOut() {
    List<WeaverQuery> nestedQueries = new ArrayList<>();
    nestedQueries.add(new WeaverQuery().equals("testAttribute", "doesntexist"));
    ConditionMap relationOutCondition = new ConditionMap();
    relationOutCondition.put("$relOut", nestedQueries);
    FindQueryResult result = (FindQueryResult)getDatabase().query(query().addCondition("*", relationOutCondition));
    List<WeaverNode> nodes = result.getNodes();

    assertEquals("Number of nodes", 0, nodes.size());
  }
}
