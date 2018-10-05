package com.weaverplatform.postgresql;

import com.weaverplatform.postgresql.database.query.model.FindQueryResult;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import com.weaverplatform.protocol.model.AttributeDataType;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class AttributeDataTypeTest extends BaseTest {

  @Test
  public void dataTypeRetrievalOld() {
    String graph = "testDataTypeOld";
    getDatabase().write(new WritesBuilder()
      .withGraph(graph)
      .addNode()
      .setTypedAttribute("someValue", AttributeDataType.XSD_HEXBINARY, "0xCAFEBABE").getWrites());

    FindQueryResult res = (FindQueryResult) getDatabase().query(new WeaverQuery().setNoRelations(false).addInGraph(graph));
    assertEquals("Types matches", AttributeDataType.XSD_HEXBINARY, res.getNodes().get(0).getAttributes().get("someValue").get(0).getDataType());
  }

  @Test
  public void dataTypeRetrievalNew() {
    String graph = "testDataTypeNew";
    getDatabase().write(new WritesBuilder()
      .withGraph(graph)
      .addNode()
      .setTypedAttribute("someValue", AttributeDataType.XSD_HEXBINARY, "0xCAFEBABE").getWrites());

    FindQueryResult res = (FindQueryResult) getDatabase().query(new WeaverQuery().addInGraph(graph));
    assertEquals("Types matches", AttributeDataType.XSD_HEXBINARY, res.getNodes().get(0).getAttributes().get("someValue").get(0).getDataType());
  }
}
