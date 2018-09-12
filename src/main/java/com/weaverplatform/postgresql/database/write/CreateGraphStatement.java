package com.weaverplatform.postgresql.database.write;

import com.weaverplatform.postgresql.database.Query;
import com.weaverplatform.postgresql.database.exceptions.WeaverDatabaseException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by gijs on 20/11/2017.
 */
public class CreateGraphStatement implements WriteStatement {
  private String graph;

  public CreateGraphStatement() {
  }

  public CreateGraphStatement(String graph) {
    this.graph = graph;
  }

  @Override
  public String getUpdateQuery() {
    return Query.CREATE_GRAPH;
  }

  @Override
  public void addToBatch(PreparedStatement statement) throws SQLException {
    statement.setString(1, graph);
    statement.addBatch();
  }
}
