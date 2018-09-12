package com.weaverplatform.postgresql.database.write;

import com.weaverplatform.postgresql.database.Query;
import com.weaverplatform.protocol.model.CreateRelationOperation;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Mohamad Alamili
 */
public class CreateRelationStatement implements WriteStatement {

  private CreateRelationOperation operation;

  public CreateRelationStatement() {
  }

  public CreateRelationStatement(CreateRelationOperation operation) {
    this.operation = operation;
  }

  @Override
  public String getUpdateQuery() {
    return Query.CREATE_RELATION;
  }

  @Override
  public void addToBatch(PreparedStatement statement) throws SQLException {
    statement.setString(1, operation.getId());
    statement.setString(2, operation.getGraph());
    statement.setString(3, operation.getSourceId());
    statement.setString(4, operation.getSourceGraph());
    statement.setString(5, operation.getKey());
    statement.setString(6, operation.getTargetId());
    statement.setString(7, operation.getTargetGraph());
    statement.addBatch();
  }
}
