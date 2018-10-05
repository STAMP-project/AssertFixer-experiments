package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.model.WeaverNode;
import com.weaverplatform.postgresql.database.query.model.ConditionMap;
import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author Gijs van der Ent
 */
public class MultipleConditionsOnSameRelationQueryTest extends BaseTest {

  private static boolean setUpRan = false; // Needs to be static because each test method gets its own instance
  private static String relLabel = "type";
  private static String testId = MultipleConditionsOnSameRelationQueryTest.class.getSimpleName();


  @Before
  public void createGraph() {
    if(!setUpRan) {  // Ensure this construct only runs once before the class
      getDatabase().write(
        new WritesBuilder()
          .withGraph(testId)
          .withUser(testId + "user")
          .addNode("leaf")
          .addRelation(relLabel)
          .addNode("root")
          .addRelation(relLabel)
          .addNode("itsclass")
          .addRelationBetweenNodes("leaf", relLabel, "itsclass")
        .getWrites()
      );
      setUpRan = true;
    }
  }

  private WeaverQuery getTypeQuery() {
    WeaverQuery innerQuery = query().addInGraph(testId);
    ConditionMap relationOutCondition = new ConditionMap();
    Map<String, String> target = new HashMap<>();
    target.put("id", "itsclass");
    target.put("graph", testId);
    List<Object> lala = new ArrayList<>();
    lala.add(target);
    relationOutCondition.put("$relOut", lala);
    innerQuery.addCondition(relLabel, relationOutCondition);
    return innerQuery;
  }

  @Test
  public void testAllWithRelation() {
    WeaverQuery innerQuery = getTypeQuery();
    FindQueryResult result = (FindQueryResult) getDatabase().query(innerQuery);
    assertEquals("Number of nodes", 2, result.getNodes().size());
  }

  @Test
  public void testNestedQueryWithMultipleRestrictions() {
    WeaverQuery outerQuery = query().addInGraph(testId);
    ConditionMap typeConditions = new ConditionMap();
    Map<String, String> target = new HashMap<>();
    target.put("id", "itsclass");
    target.put("graph", testId);
    List<Object> relationOutTargets = new ArrayList<>();
    relationOutTargets.add(target);
    List<Object> noRelationOutTargets = new ArrayList<>();
    typeConditions.put("$relOut", relationOutTargets);
    noRelationOutTargets.add(getTypeQuery());
    typeConditions.put("$noRelOut", noRelationOutTargets);
    outerQuery.addCondition(relLabel, typeConditions);
    FindQueryResult result = (FindQueryResult) getDatabase().query(outerQuery);
    assertEquals("Number of nodes", 1, result.getNodes().size());
    assertEquals("The expected node id", "root", result.getNodes().get(0).getNodeId());
  }

}
