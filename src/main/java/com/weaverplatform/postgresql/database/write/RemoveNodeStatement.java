package com.weaverplatform.postgresql.database.write;

import com.weaverplatform.postgresql.database.Query;
import com.weaverplatform.protocol.model.RemoveNodeOperation;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Mohamad Alamili
 */
public class RemoveNodeStatement implements WriteStatement {
  private RemoveNodeOperation operation;

  public RemoveNodeStatement() {
  }

  public RemoveNodeStatement(RemoveNodeOperation operation) {
    this.operation = operation;
  }

  @Override
  public String getUpdateQuery() {
    return Query.REMOVE_NODE;
  }

  @Override
  public void addToBatch(PreparedStatement statement) throws SQLException {
    statement.setString(1, operation.getRemoveId());
    statement.setString(2, operation.getRemoveGraph());
    statement.setString(3, operation.getId());
    statement.setString(4, operation.getGraph());
    statement.addBatch();
  }
}
