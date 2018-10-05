package com.weaverplatform.postgresql.query;

import com.weaverplatform.postgresql.database.query.WeaverQueryBuilder;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import com.weaverplatform.postgresql.util.SetClipboard;

public class QueryExamples {

  public static void main(String[] args) {
    WeaverQuery query = new WeaverQueryBuilder()
//      .limit(200)
//      .skip(20)
//      .restrict("some-node", "another")
//      .count()
//      .equalsTo("Hook", "PestCloudAgreement")
//      .contains("AreaGeorge", "eef")
//      .hasRelationOut("SnowRainstorm")
//      .hasRelationOut("SnowRainstorm", "cj5rywhrx0034wi86gtwu687r")
//        .hasNoRelationOut("SnowRainstorm")
//        .hasRelationIn("SnowRainstorm")
        .hasRelationIn("SnowRainstorm", "cj5rywhrx0034wi86gtwu687r")
      .build();


    String sql = query.compileToPostgresQuery();
    System.out.println(sql);
    SetClipboard.with(sql);
  }
}
