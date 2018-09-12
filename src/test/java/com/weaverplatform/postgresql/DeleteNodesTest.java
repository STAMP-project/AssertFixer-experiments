package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteNodesTest extends BaseTest {
  @Test
  public void deleteAndRecreateNode() {
    final String graph  = "deleteAndRecreate";
    final String nodeId = "testid";
    getDatabase().write(
      new WritesBuilder()
        .withGraph(graph)
        .addNode(nodeId)
        .getWrites()
    );
    getDatabase().write(
      new WritesBuilder()
        .withGraph(graph)
        .removeNode(nodeId)
        .getWrites()
    );
    FindQueryResult res1 = (FindQueryResult) getDatabase().query(query()
      .addInGraph(graph)
      .restrict(nodeId)
    );
    assertEquals("Number of nodes existing after delete", 0, res1.getNodes().size());
    getDatabase().write(
      new WritesBuilder()
        .withGraph(graph)
        .addNode(nodeId)
        .getWrites()
    );
    FindQueryResult res2 = (FindQueryResult) getDatabase().query(query()
      .addInGraph(graph)
      .restrict(nodeId)
    );
    assertEquals("Number of nodes existing after recreate", 1, res2.getNodes().size());
  }
}
