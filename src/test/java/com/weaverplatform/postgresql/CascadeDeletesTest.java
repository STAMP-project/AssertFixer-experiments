package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import com.weaverplatform.protocol.model.RemoveNodeOperation;
import com.weaverplatform.protocol.model.WriteOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class CascadeDeletesTest extends BaseTest {
  @Test
  public void testCascadeDelete() {
    String testGraph = "cascadeDeleteTest";
    getDatabase().write(
      new WritesBuilder()
        .withGraph(testGraph)
        .addNode("source")
        .addRelation("in")
        .addNode("deleteTarget")
        .addRelation("out")
        .addNode("target")
      .getWrites());

    RemoveNodeOperation deleteOp = new RemoveNodeOperation("testuser", "deleteTarget", UUID.randomUUID().toString());
    deleteOp.setGraph(testGraph);

    List<WriteOperation> writes = new ArrayList<>();
    writes.add(deleteOp);

    getDatabase().write(writes);

    FindQueryResult result = (FindQueryResult) getDatabase().query(new WeaverQuery().addInGraph(testGraph).restrict("source"));
    assertEquals("source should now not have a relation out", 0, result.getNodes().get(0).getRelations().size());
  }
}
