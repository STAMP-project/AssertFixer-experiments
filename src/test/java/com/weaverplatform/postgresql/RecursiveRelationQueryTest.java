package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.Postgres;
import com.weaverplatform.postgresql.database.model.WeaverNode;
import com.weaverplatform.postgresql.database.query.model.*;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

/**
 * @author Mohamad Alamili
 */
public class RecursiveRelationQueryTest extends BaseTest {
  @Test
  public void selectRecursiveRelationOut() {
    String testId = "selectRecursiveRelationOut";
    getDatabase().write(new WritesBuilder()
      .withGraph(testId)
      .addNode("a")
      .addRelation("relation")
      .addNode("b")
      .addRelation("relation")
      .addNode("c")
      .getWrites()
    );

    RecursiveCondition r = new RecursiveCondition();
    r.setIncludeSelf(false);
    r.setNodeGraph(testId);
    r.setNodeId("c");
    r.setOperation("$relOut");
    r.setRelation("relation");

    WeaverQuery q = query()
      .addInGraph(testId)
      .addRecursiveCondition(r);

    FindQueryResult qr = (FindQueryResult) getDatabase().query(q);

    assertEquals("Number of results", 2, qr.getNodes().size());
  }

  @Test
  public void selectRecursiveRelationIn() {
    String testId = "selectRecursiveRelationIn";
    getDatabase().write(new WritesBuilder()
      .withGraph(testId)
      .addNode("a")
      .addRelation("relation")
      .addNode("b")
      .addRelation("relation")
      .addNode("c")
      .getWrites()
    );

    RecursiveCondition r = new RecursiveCondition();
    r.setIncludeSelf(false);
    r.setNodeGraph(testId);
    r.setNodeId("a");
    r.setOperation("$relIn");
    r.setRelation("relation");

    WeaverQuery q = query()
      .addInGraph(testId)
      .addRecursiveCondition(r);

    FindQueryResult qr = (FindQueryResult) getDatabase().query(q);

    assertEquals("Number of results", 2, qr.getNodes().size());
  }

  @Test
  public void selectMultipleRecursiveRelationOut() {
    String testId = "selectMultipleRecursiveRelationOut";
    getDatabase().write(new WritesBuilder()
      .withGraph(testId)
      .addNode("a")
      .addRelation("relation")
      .addNode("b")
      .addRelation("relation")
      .addNode("c")
      .addNode("d")
      .addRelation("other")
      .addNode("e")
      .addRelationBetweenNodes("a", "other", "d")
      .getWrites()
    );

    RecursiveCondition r = new RecursiveCondition();
    r.setIncludeSelf(false);
    r.setNodeGraph(testId);
    r.setNodeId("c");
    r.setOperation("$relOut");
    r.setRelation("relation");

    RecursiveCondition r2 = new RecursiveCondition();
    r2.setIncludeSelf(false);
    r2.setNodeGraph(testId);
    r2.setNodeId("e");
    r2.setOperation("$relOut");
    r2.setRelation("other");

    WeaverQuery q = query()
      .addInGraph(testId)
      .addRecursiveCondition(r)
      .addRecursiveCondition(r2);

    FindQueryResult qr = (FindQueryResult) getDatabase().query(q);

    assertEquals("Number of results", 1, qr.getNodes().size());
  }
}
