package com.weaverplatform.postgresql.database.write;

import com.weaverplatform.postgresql.database.Query;
import com.weaverplatform.protocol.model.WriteOperation;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @author Mohamad Alamili
 */
public class CreateNodeStatement implements WriteStatement  {
  private WriteOperation operation;
  private String id;
  private String graph;

  public CreateNodeStatement() {
  }

  public CreateNodeStatement(WriteOperation operation) {
    this.operation = operation;
    this.id = operation.getId();
    this.graph = operation.getGraph();
  }

  public CreateNodeStatement(WriteOperation operation, String id, String graph) {
    this.operation = operation;
    this.id = id;
    this.graph = graph;
  }

  @Override
  public String getUpdateQuery() {
    return Query.CREATE_NODE;
  }

  @Override
  public void addToBatch(PreparedStatement statement) throws SQLException {
    statement.setString(1, id);
    statement.setTimestamp(2, new Timestamp(operation.getTimestamp()), UTC_CALENDAR);
    statement.setString(3, operation.getUser());
    statement.setString(4, graph);
    statement.addBatch();
  }
}
