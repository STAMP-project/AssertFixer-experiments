package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.model.WeaverAttribute;
import com.weaverplatform.postgresql.database.model.WeaverNode;
import com.weaverplatform.postgresql.database.model.WeaverRelation;
import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import com.weaverplatform.protocol.model.TruncateGraphOperation;
import com.weaverplatform.protocol.model.WriteOperation;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RedirectGraphTest extends BaseTest {
  @Test
  public void singleRelation() {
    String test = "testSingleRelationGraphRedirection";
    String sourceGraph = test + "source";
    String oldTargetGraph = test + "oldTarget";
    String newTargetGraph = test + "newTarget";

    getDatabase().write(new WritesBuilder()
      .withGraph(sourceGraph)
      .addNode("sauce")
      .addRelation("rel")
      .withGraph(oldTargetGraph)
      .addNode("kewl")
      .withGraph(newTargetGraph)
      .addNode("kewl")
      .getWrites()
    );

    FindQueryResult contents = (FindQueryResult) getDatabase().query(query().restrict("sauce").addInGraph(sourceGraph));
    assertEquals("Number of nodes", 1, contents.getNodes().size());
    assertEquals(
      "Number of relations before redirect",
      1,
      contents.getNodes().get(0).getRelations().get("rel").size());

    getDatabase().redirectGraph(sourceGraph, oldTargetGraph, newTargetGraph, false, false);

    FindQueryResult contents2 = (FindQueryResult) getDatabase().query(query().restrict("sauce").addInGraph(sourceGraph));
    assertEquals("Number of nodes", 1, contents2.getNodes().size());
    assertEquals(
      "Number of relations after redirect",
      2,
      contents2.getNodes().get(0).getRelations().get("rel").size());
  }

  @Test
  public void dryrun() {
    String test = "dryrun";
    String sourceGraph = test + "source";
    String oldTargetGraph = test + "oldTarget";
    String newTargetGraph = test + "newTarget";

    getDatabase().write(new WritesBuilder()
      .withGraph(sourceGraph)
      .addNode("sauce")
      .addRelation("rel")
      .withGraph(oldTargetGraph)
      .addNode("kewl")
      .withGraph(newTargetGraph)
      .addNode("kewl")
      .getWrites()
    );

    getDatabase().redirectGraph(sourceGraph, oldTargetGraph, newTargetGraph, true, true);

    FindQueryResult contents2 = (FindQueryResult) getDatabase().query(query().restrict("sauce").addInGraph(sourceGraph));
    assertEquals("Number of nodes", 1, contents2.getNodes().size());
    assertEquals(
      "Number of relations after redirect",
      1,
      contents2.getNodes().get(0).getRelations().get("rel").size());
  }

  @Test
  public void multipleRuns() {
    String test = "multipleredirects";
    String sourceGraph = test + "source";
    String oldTargetGraph = test + "oldTarget";
    String newTargetGraph = test + "newTarget";

    getDatabase().write(new WritesBuilder()
      .withGraph(sourceGraph)
      .addNode("sauce")
      .addRelation("rel")
      .withGraph(oldTargetGraph)
      .addNode("kewl")
      .withGraph(newTargetGraph)
      .addNode("kewl")
      .getWrites()
    );

    getDatabase().redirectGraph(sourceGraph, oldTargetGraph, newTargetGraph, false, true);
    getDatabase().redirectGraph(sourceGraph, oldTargetGraph, newTargetGraph, false, true);

    FindQueryResult contents2 = (FindQueryResult) getDatabase().query(query().restrict("sauce").addInGraph(sourceGraph));
    assertEquals("Number of nodes", 1, contents2.getNodes().size());
    assertEquals(
      "Number of relations after redirect",
      2,
      contents2.getNodes().get(0).getRelations().get("rel").size());
  }

  @Test
  public void unmappable() {
    String test = "testUnmappableSingleRelationGraphRedirection";
    String sourceGraph = test + "source";
    String oldTargetGraph = test + "oldTarget";
    String newTargetGraph = test + "newTarget";

    getDatabase().write(new WritesBuilder()
      .withGraph(sourceGraph)
      .addNode("sauce")
      .addRelation("rel")
      .withGraph(oldTargetGraph)
      .addNode("kewl")
      .withGraph(newTargetGraph)
      .addNode("notkewl")
      .getWrites()
    );

    try {
      getDatabase().redirectGraph(sourceGraph, oldTargetGraph, newTargetGraph, false, false);
      Assert.fail("Should not do mapping");
    } catch (Exception e) {
      // This is expected
    }
  }

  @Test
  public void partial() {
    String test = "testPartialRedirect";
    String sourceGraph = test + "source";
    String oldTargetGraph = test + "oldTarget";
    String newTargetGraph = test + "newTarget";

    getDatabase().write(new WritesBuilder()
      .withGraph(sourceGraph)
      .addNode("othersource")
      .addNode("sauce")
      .addRelation("rel")
      .withGraph(oldTargetGraph)
      .addNode("kewl")
      .addNode("othertarget")
      .addRelationBetweenNodes("othersource", "relation", "othertarget")
      .withGraph(newTargetGraph)
      .addNode("kewl")
      .getWrites()
    );

    getDatabase().redirectGraph(sourceGraph, oldTargetGraph, newTargetGraph, false, true);

    FindQueryResult contents2 = (FindQueryResult) getDatabase().query(query().restrict("sauce").addInGraph(sourceGraph));
    assertEquals("Number of source nodes", 1, contents2.getNodes().size());
    assertEquals(
      "Number of relations after redirect",
      2,
      contents2.getNodes().get(0).getRelations().get("rel").size());

    FindQueryResult contents3 = (FindQueryResult) getDatabase().query(query().restrict("othersource").addInGraph(sourceGraph));
    assertEquals("Number of source nodes", 1, contents3.getNodes().size());
    assertEquals(
      "Number of relations after redirect",
      1,
      contents3.getNodes().get(0).getRelations().get("relation").size());
  }

  @Test
  public void twoDifferentTargets() {
    String test = "testDifferentTargets";
    String sourceGraph = test + "source";
    String oldTargetGraph = test + "oldTarget";
    String newTargetGraph = test + "newTarget";
    String newerTargetGraph = test + "newerTarget";

    getDatabase().write(new WritesBuilder()
      .withGraph(sourceGraph)
      .addNode("sauce")
      .addRelation("rel")
      .withGraph(oldTargetGraph)
      .addNode("kewl")
      .withGraph(newTargetGraph)
      .addNode("kewl")
      .withGraph(newerTargetGraph)
      .addNode("kewl")
      .getWrites()
    );

    getDatabase().redirectGraph(sourceGraph, oldTargetGraph, newTargetGraph, false, false);
    getDatabase().redirectGraph(sourceGraph, oldTargetGraph, newerTargetGraph, false, false);

    FindQueryResult contents3 = (FindQueryResult) getDatabase().query(query().restrict("sauce").addInGraph(sourceGraph));
    assertEquals("Number of source nodes", 1, contents3.getNodes().size());
    assertEquals(
      "Number of relations after redirect",
      3,
      contents3.getNodes().get(0).getRelations().get("rel").size());
  }

  @Test
  public void redirectRelationRelation() {
    String test = "relationRelation";
    String sourceGraph = test + "source";
    String oldTargetGraph = test + "oldTarget";
    String newTargetGraph = test + "newTarget";

    getDatabase().write(new WritesBuilder()
      .withGraph(sourceGraph)
      .addNode("a")
      .addRelation("rel","ingraphlink")
      .addNode("b")
      .addRelation("rel")
      .withGraph(oldTargetGraph)
      .addNode("c")
      .addNode("d")
      .withGraph(sourceGraph)
      .addRelationBetweenNodes("ingraphlink", "to-d", "d")
      .withGraph(newTargetGraph)
      .addNode("c")
      .addNode("d")
      .getWrites()
    );

    /*
      setup: a -rel(ingraphlink) -> b -rel-> c(oldTargetGraph)
             ingraphlink -to-d-> d(oldTargetGraph)

      Now a new graph newTargetGraph is introduced, and the relation from a to b should
      get a relation to the appropriate node in d as well.
     */

    getDatabase().redirectGraph(sourceGraph, oldTargetGraph, newTargetGraph, false, false);

    WeaverNode relationNode = ((FindQueryResult) getDatabase().query(
      query().setNoRelations(false).restrict("ingraphlink").addInGraph(sourceGraph)
    )).getNodes().get(0);

    assertEquals("The relation also has its relation transferred", 2, relationNode.getRelations().get("to-d").size());
  }

  @Test
  public void redirectRelationWithAttribute() {
    String test = "relationWithAttribute";
    String sourceGraph = test + "source";
    String oldTargetGraph = test + "oldTarget";
    String newTargetGraph = test + "newTarget";

    getDatabase().write(new WritesBuilder()
      .withGraph(sourceGraph)
      .addNode("a")
      .addRelation("rel", "relationId")
      .addAttributeOnRelation("someAttribute", "someValue")
      .withGraph(oldTargetGraph)
      .addNode("c")
      .withGraph(sourceGraph)
      .withGraph(newTargetGraph)
      .addNode("c")
      .getWrites()
    );

    /*
      setup: a -rel[someAttribute="someValue"] -> c

      The newly created relation should also have this attribute
     */

    getDatabase().redirectGraph(sourceGraph, oldTargetGraph, newTargetGraph, false, false);

    WeaverNode a = ((FindQueryResult) getDatabase().query(
      query().restrict("a").addInGraph(sourceGraph)
    )).getNodes().get(0);

    List<WeaverRelation> aRelRelations = a.getRelations().get("rel");
    assertEquals("Number of rel relations", 2, aRelRelations.size());

    for(WeaverRelation r: aRelRelations) {
      WeaverNode loadedR = ((FindQueryResult) getDatabase().query(query()
        .setNoRelations(false)
        .restrict(r.getNodeId())
        .addInGraph(r.getGraph()))
      ).getNodes().get(0);

      assertEquals(String.format("The relation to graph %s should have attributes", r.getGraph()), 1, loadedR.getAttributes().size());
      List<WeaverAttribute> attribute = loadedR.getAttributes().get("someAttribute");
      assertEquals(String.format("The relation to graph %s should have a someAttribute attribute", r.getGraph()), 1, attribute.size());
      String value = (String) attribute.get(0).getValue();
      assertEquals(String.format("Expected value of the attribute of relation to graph %s", r.getGraph()), "someValue", value);
    }
  }

  @Test
  public void redirectRelationToNonTargetGraphRelation() {
    String test = "relationToNonTargetGraphRelation";
    String sourceGraph = test + "source";
    String oldTargetGraph = test + "oldTarget";
    String newTargetGraph = test + "newTarget";

    getDatabase().write(new WritesBuilder()
      .withGraph(sourceGraph)
      .addNode("unrelated")
      .addNode("a")
      .addRelation("rel", "relationId")
      .withGraph(oldTargetGraph)
      .addNode("c")
      .withGraph(sourceGraph)
      .addRelationBetweenNodes("relationId", "otherrel", "unrelated")
      .withGraph(newTargetGraph)
      .addNode("c")
      .getWrites()
    );

    /*
      setup: a -rel(relationId) -> c
             relationId -tricksy-> unrelated

      Now a new graph newTargetGraph is introduced, and the relationId should be cloned
      to the new graph, and get the relation to the unrelated node
     */

    getDatabase().redirectGraph(sourceGraph, oldTargetGraph, newTargetGraph, false, false);

    WeaverNode a = ((FindQueryResult) getDatabase().query(
      query().restrict("a").addInGraph(sourceGraph)
    )).getNodes().get(0);

    List<WeaverRelation> aRelRelations = a.getRelations().get("rel");
    assertEquals("Number of rel relations", 2, aRelRelations.size());

    for(WeaverRelation r: aRelRelations) {
      WeaverNode loadedR = ((FindQueryResult) getDatabase().query(query()
        .setNoRelations(false)
        .restrict(r.getNodeId())
        .addInGraph(r.getGraph()))
      ).getNodes().get(0);

      assertEquals("The relation should have a relation", 1, loadedR.getRelations().size());
      List<WeaverRelation> otherRelation = loadedR.getRelations().get("otherrel");
      assertEquals("The relation should have a tricksy relation", 1, otherRelation.size());
      WeaverNode otherRelTarget = otherRelation.get(0).getTarget();
      assertEquals("And the target is in the same graph as the relation target", sourceGraph, otherRelTarget.getGraph());
    }
  }

  @Test
  public void redirectRelationToTargetGraphRelation() {
    String test = "relationToTargetGraphRelation";
    String sourceGraph = test + "source";
    String oldTargetGraph = test + "oldTarget";
    String newTargetGraph = test + "newTarget";

    getDatabase().write(new WritesBuilder()
      .withGraph(sourceGraph)
      .addNode("a")
      .addRelation("rel", "relationId")
      .withGraph(oldTargetGraph)
      .addNode("c")
      .addNode("d")
      .withGraph(sourceGraph)
      .addRelationBetweenNodes("relationId", "tricksy", "d")
      .withGraph(newTargetGraph)
      .addNode("c")
      .addNode("d")
      .getWrites()
    );

    /*
      setup: a -rel(relationId) -> c
             relationId -tricksy-> d(oldTargetGraph)

      Now a new graph newTargetGraph is introduced, and the relationId should be cloned
      to the new graph, and get the relation to the new graph
     */

    getDatabase().redirectGraph(sourceGraph, oldTargetGraph, newTargetGraph, false, false);

    WeaverNode a = ((FindQueryResult) getDatabase().query(
      query().restrict("a").addInGraph(sourceGraph)
    )).getNodes().get(0);

    List<WeaverRelation> aRelRelations = a.getRelations().get("rel");
    assertEquals("Number of rel relations", 2, aRelRelations.size());

    for(WeaverRelation r: aRelRelations) {
      WeaverNode loadedR = ((FindQueryResult) getDatabase().query(query()
        .setNoRelations(false)
        .restrict(r.getNodeId())
        .addInGraph(r.getGraph()))
      ).getNodes().get(0);

      assertEquals("The relation should have a relation", 1, loadedR.getRelations().size());
      List<WeaverRelation> tricksyRelations = loadedR.getRelations().get("tricksy");
      assertEquals("The relation should have a tricksy relation", 1, tricksyRelations.size());
      WeaverNode tricksyTarget = tricksyRelations.get(0).getTarget();
      assertEquals("And the target is in the same graph as the relation target", r.getTarget().getGraph(), tricksyTarget.getGraph());
    }
  }

}
