package com.weaverplatform.postgresql.database.write;

import com.weaverplatform.postgresql.database.Query;
import com.weaverplatform.protocol.model.TruncateGraphOperation;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Mohamad Alamili
 */
public class TruncateGraphStatement implements WriteStatement {
  private TruncateGraphOperation operation;

  public TruncateGraphStatement() {
  }

  public TruncateGraphStatement(TruncateGraphOperation operation) {
    this.operation = operation;
  }

  @Override
  public String getUpdateQuery() {
    return Query.TRUNCATE_GRAPH;
  }

  @Override
  public void addToBatch(PreparedStatement statement) throws SQLException {
    statement.setString(1, operation.getGraph());
    statement.setString(2, operation.getRemoveId());
    statement.setString(3, operation.getRemoveGraph());
    statement.addBatch();
  }
}
