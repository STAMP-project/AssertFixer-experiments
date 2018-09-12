package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.BaseTest;
import com.weaverplatform.postgresql.database.Database;
import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RelationQueryTest extends BaseTest {
  @Test
  public void testQueryDirect() {
    Database db = getDatabase();
    db.write(
      new WritesBuilder()
        .addNode("from")
        .addRelation("go", "relationId")
        .addNode("to")
        .getWrites()
    );

    FindQueryResult res = (FindQueryResult) db.query(
      query()
        .restrict("relationId")
        .setNoRelations(false)
    );
    assertEquals("Expected number of results", 1, res.getNodes().size());

    assertEquals("Expected relationSource", "from", res.getNodes().get(0).getRelationSource().getNodeId());
    assertEquals("Expected relationTarget", "to", res.getNodes().get(0).getRelationTarget().getNodeId());
    assertEquals("Expected relationKey", "go", res.getNodes().get(0).getRelationKey());
  }

  @Test
  public void testQueryDirectWithAttribute() {
    Database db = getDatabase();
    db.write(
      new WritesBuilder()
        .withGraph("testQueryDirectWithAttribute")
        .addNode("from")
        .addRelation("go", "anotherRelationId")
        .addAttributeOnRelation("thing", "value")
        .addNode("to")
        .getWrites()
    );

    FindQueryResult res = (FindQueryResult) db.query(
      query()
        .addInGraph("testQueryDirectWithAttribute")
        .restrict("anotherRelationId")
        .setNoRelations(false)
    );
    assertEquals("Expected number of results", 1, res.getNodes().size());

    assertEquals("Expected relationSource", "from", res.getNodes().get(0).getRelationSource().getNodeId());
    assertEquals("Expected relationTarget", "to", res.getNodes().get(0).getRelationTarget().getNodeId());
    assertEquals("Expected relationKey", "go", res.getNodes().get(0).getRelationKey());
  }

  @Test
  public void testQueryIndirect() {
    Database db = getDatabase();
    db.write(
      new WritesBuilder()
        .addNode("a")
        .addRelation("to", "q")
        .addNode("b")
        .addNode("c")
        .addRelationBetweenNodes("q", "meta", "c", "3")
        .getWrites()
    );

    FindQueryResult res = (FindQueryResult) db.query(
      query()
        .hasRelationOut("meta", "c")
        .setNoRelations(false)
    );
    assertEquals("Expected number of results", 1, res.getNodes().size());

    assertEquals("Expected relationSource", "a", res.getNodes().get(0).getRelationSource().getNodeId());
    assertEquals("Expected relationTarget", "b", res.getNodes().get(0).getRelationTarget().getNodeId());
    assertEquals("Expected relationKey", "to", res.getNodes().get(0).getRelationKey());
  }

}
