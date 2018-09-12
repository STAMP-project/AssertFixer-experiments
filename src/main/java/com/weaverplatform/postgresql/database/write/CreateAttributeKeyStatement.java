package com.weaverplatform.postgresql.database.write;

import com.weaverplatform.postgresql.database.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Mohamad Alamili
 */
public class CreateAttributeKeyStatement implements WriteStatement {

  private String attributeKey;

  public CreateAttributeKeyStatement() {
  }

  public CreateAttributeKeyStatement(String attributeKey) {
    this.attributeKey = attributeKey;
  }

  @Override
  public String getUpdateQuery() {
    return Query.CREATE_ATTRIBUTE_KEY;
  }

  @Override
  public void addToBatch(PreparedStatement statement) throws SQLException {
    statement.setString(1, attributeKey);
    statement.addBatch();
  }
}
