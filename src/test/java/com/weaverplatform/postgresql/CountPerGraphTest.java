package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.Postgres;
import com.weaverplatform.postgresql.database.model.WeaverNode;
import com.weaverplatform.postgresql.database.query.model.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

/**
 * @author Gijs van der Ent
 */
public class CountPerGraphTest extends BaseTest {
  String testId = "countPerGraphTest";

  @Before
  public void setUp() {
    getDatabase().write(new WritesBuilder()
      .withGraph(testId)
      .addNode("a")
      .addRelation("relation")
      .addNode("b")
      .setAttribute("name", "somethingrather")
      .getWrites()
    );
  }
  @Test
  public void countPerGraphTest() {
    WeaverQuery q = query().countPerGraph();
    CountQueryResult qr = (CountQueryResult) getDatabase().query(q);

    assertEquals("Number of individuals counted", 2, qr.getGraphCount(testId));

    q = query().setNoRelations(false).countPerGraph();
    qr = (CountQueryResult) getDatabase().query(q);

    assertEquals("Number of individuals with relations counted", 3, qr.getGraphCount(testId));

    q = query().setNoRelations(false).setNoAttributes(false).countPerGraph();
    qr = (CountQueryResult) getDatabase().query(q);

    assertEquals("Number of individuals with relations and attributes counted", 4, qr.getGraphCount(testId));
  }
}
