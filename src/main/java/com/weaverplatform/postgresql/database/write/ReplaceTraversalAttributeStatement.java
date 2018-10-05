package com.weaverplatform.postgresql.database.write;

import com.weaverplatform.postgresql.database.Query;
import com.weaverplatform.protocol.model.CreateAttributeOperation;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Mohamad Alamili
 */
public class ReplaceTraversalAttributeStatement implements WriteStatement  {

  private CreateAttributeOperation operation;

  public ReplaceTraversalAttributeStatement() {
  }

  public ReplaceTraversalAttributeStatement(CreateAttributeOperation operation) {
    this.operation = operation;
  }

  @Override
  public String getUpdateQuery() {
    return Query.REPLACE_TRAVERSAL_ATTRIBUTE;
  }

  @Override
  public void addToBatch(PreparedStatement statement) throws SQLException {
    statement.setString(1, operation.getReplaceId());
    statement.setString(2, operation.getReplaceGraph());
    statement.setString(3, operation.getReplacesId());
    statement.setString(4, operation.getReplacesGraph());
    statement.setString(5, operation.getId());
    statement.setString(6, operation.getGraph());
    statement.addBatch();
  }
}
