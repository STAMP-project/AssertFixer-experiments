package com.weaverplatform.postgresql.database.write;

import com.weaverplatform.postgresql.database.Query;
import com.weaverplatform.protocol.model.RemoveNodeUnrecoverableOperation;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Mathieu Brouwers
 */
public class RemoveNodeUnrecoverableStatement implements WriteStatement {
  private RemoveNodeUnrecoverableOperation operation;

  public RemoveNodeUnrecoverableStatement() {
  }

  public RemoveNodeUnrecoverableStatement(RemoveNodeUnrecoverableOperation operation) {
    this.operation = operation;
  }

  @Override
  public String getUpdateQuery() {
    return Query.REMOVE_NODE_UNRECOVERABLE;
  }

  @Override
  public void addToBatch(PreparedStatement statement) throws SQLException {
    statement.setString(1, operation.getId());
    statement.setString(2, operation.getGraph());
    statement.addBatch();
  }
}
