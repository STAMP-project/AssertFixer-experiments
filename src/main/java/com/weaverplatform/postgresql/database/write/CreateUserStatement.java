package com.weaverplatform.postgresql.database.write;

import com.weaverplatform.postgresql.database.Query;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Mohamad Alamili
 */
public class CreateUserStatement implements WriteStatement {
  private String creator;

  public CreateUserStatement() {
  }

  public CreateUserStatement(String creator) {
    this.creator = creator;
  }

  @Override
  public String getUpdateQuery() {
    return Query.CREATE_USER;
  }

  @Override
  public void addToBatch(PreparedStatement statement) throws SQLException {
    statement.setString(1, creator);
    statement.addBatch();
  }
}
