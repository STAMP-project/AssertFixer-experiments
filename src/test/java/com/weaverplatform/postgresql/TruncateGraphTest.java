package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import com.weaverplatform.protocol.model.TruncateGraphOperation;
import com.weaverplatform.protocol.model.WriteOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TruncateGraphTest extends BaseTest {
  @Test
  public void testNodeOnlyGraphTruncate() {
    String test = "testTruncate1";
    String toDel = test + "ToDelete";
    String toRemain = test + "ToRemain";

    getDatabase().write(new WritesBuilder()
      .withGraph(toRemain)
      .addNode("metaDelete")
      .addNode("nodeToRemain")
      .withGraph(toDel)
      .addNode("nodeToBeRemoved")
      .getWrites()
    );

    FindQueryResult contents = (FindQueryResult) getDatabase().query(query().addInGraph(toDel).addInGraph(toRemain));
    assertEquals("Number of nodes before truncate", 3, contents.getNodes().size());

    TruncateGraphOperation op = new TruncateGraphOperation("test-user", toDel, "metaDelete");
    op.setRemoveGraph(toRemain);
    List<WriteOperation> ops = new ArrayList<>();
    ops.add(op);
    getDatabase().write(ops);

    contents = (FindQueryResult) getDatabase().query(query().addInGraph(toDel).addInGraph(toRemain));
    assertEquals("Number of nodes after truncate", 2, contents.getNodes().size());
  }

  @Test
  public void testRelationInInTruncatedGraph() {
    String test = "testTruncate2";
    String toDel = test + "ToDelete";
    String toRemain = test + "ToRemain";

    getDatabase().write(new WritesBuilder()
      .withGraph(toRemain)
      .addNode("metaDelete")
      .addNode(test + "nodeToRemain")
      .withGraph(toDel)
      .addRelation("relation")
      .addNode(test + "nodeToBeRemoved")
      .getWrites()
    );

    TruncateGraphOperation op = new TruncateGraphOperation("test-user", toDel, "metaDelete");
    op.setRemoveGraph(toRemain);
    List<WriteOperation> ops = new ArrayList<>();
    ops.add(op);
    getDatabase().write(ops);

    FindQueryResult contents = (FindQueryResult) getDatabase().query(query().addInGraph(toDel).addInGraph(toRemain));
    assertEquals("Number of nodes after truncate", 2, contents.getNodes().size());
    assertEquals("Relation should be gone", 0, contents.getNodes().get(0).getRelations().size());
  }

  @Test
  public void testRelationInNotInTruncatedGraph() {
    String test = "testTruncate3";
    String toDel = test + "ToDelete";
    String toRemain = test + "ToRemain";

    getDatabase().write(new WritesBuilder()
      .withGraph("meta")
      .addNode("metaDelete")
      .withGraph(toRemain)
      .addNode("nodeToRemain")
      .addRelation("relation")
      .withGraph(toDel)
      .addNode("nodeToBeRemoved")
      .getWrites()
    );


    TruncateGraphOperation op = new TruncateGraphOperation("test-user", toDel, "metaDelete");
    op.setRemoveGraph("meta");
    List<WriteOperation> ops = new ArrayList<>();
    ops.add(op);
    try {
      getDatabase().write(ops);
      fail("Truncate went though");
    } catch (Exception e) {}

    FindQueryResult contents = (FindQueryResult) getDatabase().query(query().addInGraph(toRemain));
    assertEquals("Number of nodes after truncate", 1, contents.getNodes().size());
    assertEquals("Relation should still be there", 1, contents.getNodes().get(0).getRelations().size());
  }
}
