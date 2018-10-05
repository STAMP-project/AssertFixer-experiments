package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.model.WeaverNode;
import com.weaverplatform.postgresql.database.model.WeaverRelation;
import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gijs on 07/12/2017.
 */
public class SelectOutTest extends BaseTest {

  private static boolean _beforeRan = false;

  @Before
  public void setUp() {
    if(!_beforeRan) {
      getDatabase().write(new WritesBuilder()
        .withGraph("SelectOutTest")
        .addNode("some-type")
        .addNode("multiple-relation-target1")
        .addRelation("mrt1-type", "type", "some-type")
        .addNode("multiple-relation-target2")
        .addRelation("mrt2-type", "type", "some-type")
        .addNode("level1a")
        .addNode("root")
        .addRelation("multiple-relation-1", "multiple", "multiple-relation-target1")
        .addRelation("multiple-relation-2", "multiple", "multiple-relation-target2")
        .addRelation("root-type-relation", "type", "some-type")
        .addRelation("level1rel", "hasLevel1a", "level1a")
        .addRelation("hasLevel1Relation")
        .addNode("level1")
        .addRelation("level1-type-relation", "type", "some-type")
        .addRelation("hasLevel2Relation")
        .addNode()
        .addRelation("ultimate-type-relation", "type", "some-type")
        .setAttribute("name", "The ultimate target")
        .getWrites());
      _beforeRan = true;
    }
  }

  private void testExpectedResult(List<WeaverNode> r) {
    assertEquals("Number of nodes", 1, r.size());
    assertEquals("hasLevel1Relations", true, r.get(0).getRelations().containsKey("hasLevel1Relation"));
    assertEquals("number of hasLevel1Relations", 1, r.get(0).getRelations().get("hasLevel1Relation").size());
    WeaverNode level1 = r.get(0).getRelations().get("hasLevel1Relation").get(0).getTarget();
    assertEquals("hasLevel2Relations", true, level1.getRelations().containsKey("hasLevel2Relation"));
    assertEquals("Number of Level2Relations", 1, level1.getRelations().get("hasLevel2Relation").size());
    WeaverNode level2 = level1.getRelations().get("hasLevel2Relation").get(0).getTarget();
    assertEquals("Attribute at level 2", "The ultimate target", level2.getAttributes().get("name").get(0).getValue());
  }

  private void testExpectedType(WeaverNode n) {
    assertEquals(String.format("%s has the type relation", n.getNodeId()), true, n.getRelations().containsKey("type"));
    assertEquals(String.format("%s has 1 type", n.getNodeId()), 1, n.getRelations().get("type").size());
    assertEquals(String.format("%s has the right type relation", n.getNodeId()), "some-type", n.getRelations().get("type").get(0).getTarget().getNodeId());
  }

  private void testExpectedResultWithType(List<WeaverNode> r) {
    testExpectedResult(r);
    testExpectedType(r.get(0));
    WeaverNode level1 = r.get(0).getRelations().get("hasLevel1Relation").get(0).getTarget();
    testExpectedType(level1);
    WeaverNode level2 = level1.getRelations().get("hasLevel2Relation").get(0).getTarget();
    testExpectedType(level2);
  }
  @Test
  public void testSingleSelectOut() {
    FindQueryResult result = ((FindQueryResult)getDatabase()
    .query(new WeaverQuery()
    .restrict("root")
    .addSelectOut(new String[]{"hasLevel1Relation", "hasLevel2Relation"})
    .addInGraph("SelectOutTest")
    ));
    testExpectedResult(result.getNodes());
  }

  @Test
  public void testDifferentLevels() {
    FindQueryResult result = ((FindQueryResult)getDatabase()
    .query(new WeaverQuery()
    .restrict("root")
    .addInGraph("SelectOutTest")
    .addSelectOut(new String[]{"hasLevel1a"})
    .addSelectOut(new String[]{"hasLevel1Relation", "hasLevel2Relation"})
    ));
    testExpectedResult(result.getNodes());
  }

  @Test
  public void testDifferentLevelsOtherOrder() {
    FindQueryResult result = ((FindQueryResult)getDatabase()
    .query(new WeaverQuery()
    .restrict("root")
    .addInGraph("SelectOutTest")
    .addSelectOut(new String[]{"hasLevel1Relation", "hasLevel2Relation"})
    .addSelectOut(new String[]{"hasLevel1a"})
    ));
    testExpectedResult(result.getNodes());
  }

  @Test
  public void testAlwaysLoadRelation() {
    FindQueryResult result = ((FindQueryResult)getDatabase()
    .query(new WeaverQuery()
    .restrict("root")
    .addInGraph("SelectOutTest")
    .addSelectOut(new String[]{"hasLevel1Relation", "hasLevel2Relation"})
    .addAlwaysLoadRelation("type")
    ));
    testExpectedResult(result.getNodes());
  }

  @Test
  public void testAlwaysLoadRelationDifferentLevels() {
    FindQueryResult result = ((FindQueryResult)getDatabase()
    .query(new WeaverQuery()
    .restrict("root")
    .addInGraph("SelectOutTest")
    .addSelectOut(new String[]{"hasLevel1Relation", "hasLevel2Relation"})
    .addSelectOut(new String[]{"hasLevel1a"})
    .addAlwaysLoadRelation("type")
    ));
    testExpectedResult(result.getNodes());
  }

  @Test
  public void testAlwaysLoadRelationDifferentLevelsOtherOrder() {
    FindQueryResult result = ((FindQueryResult)getDatabase()
    .query(new WeaverQuery()
    .restrict("root")
    .addInGraph("SelectOutTest")
    .addSelectOut(new String[]{"hasLevel1a"})
    .addSelectOut(new String[]{"hasLevel1Relation", "hasLevel2Relation"})
    .addAlwaysLoadRelation("type")
    ));
    testExpectedResult(result.getNodes());
  }

  @Test
  public void testMultipleRelationsOut() {

    FindQueryResult result = ((FindQueryResult)getDatabase()
    .query(new WeaverQuery().restrict("root").addAlwaysLoadRelation("type")));
    List<WeaverNode> list = result.getNodes();
    assertEquals("Number of nodes", 1, list.size());
    WeaverNode root = list.get(0);
    assertTrue("Has multiple relation", root.getRelations().containsKey("multiple"));
    assertEquals("Number of multiple relations", 2, root.getRelations().get("multiple").size());
    for(WeaverRelation rel: root.getRelations().get("multiple")) {
      Map<String, List<WeaverRelation>> relations = rel.getTarget().getRelations();
      assertTrue(String.format("Node %s has a type", rel.getTarget().getNodeId()), relations.containsKey("type"));
      List<WeaverRelation> typeRelations = relations.get("type");
      assertEquals(String.format("Node %s number of types", rel.getTarget()), 1, typeRelations.size());
      assertEquals(String.format("Node %s type", rel.getTarget()), "some-type", typeRelations.get(0).getTarget().getNodeId());
    }
  }
}
