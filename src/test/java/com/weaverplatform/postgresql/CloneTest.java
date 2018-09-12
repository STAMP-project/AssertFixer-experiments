package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.model.WeaverNode;
import com.weaverplatform.postgresql.database.query.model.CloneOperation;
import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by gijs on 01/12/2017.
 */
public class CloneTest extends BaseTest {
  @Test
  public void testCloneCall() {
    getDatabase().write(new WritesBuilder()
      .addNode("cloneTest")
      .getWrites()
    );

    CloneOperation cloneParameters = new CloneOperation();
    cloneParameters.setSourceNodeId("cloneTest");
    cloneParameters.setTargetNodeId("testClone");
    cloneParameters.setUserUid("clone-user");
    cloneParameters.setRelationsToTraverse(new ArrayList<>());
    getDatabase().clone(cloneParameters);

    FindQueryResult result = (FindQueryResult)getDatabase().query(query().restrict("testClone"));
    List<WeaverNode> nodes = result.getNodes();
    assertEquals("Number of nodes", 1, nodes.size());
  }

}
