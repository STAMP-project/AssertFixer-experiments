package com.weaverplatform.postgresql.database.write;

import com.weaverplatform.postgresql.database.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Mohamad Alamili
 */
public class CreateRelationKeyStatement implements WriteStatement {

  private String relationKey;

  public CreateRelationKeyStatement() {
  }

  public CreateRelationKeyStatement(String relationKey) {
    this.relationKey = relationKey;
  }

  @Override
  public String getUpdateQuery() {
    return Query.CREATE_RELATION_KEY;
  }

  @Override
  public void addToBatch(PreparedStatement statement) throws SQLException {
    statement.setString(1, relationKey);
    statement.addBatch();
  }
}
