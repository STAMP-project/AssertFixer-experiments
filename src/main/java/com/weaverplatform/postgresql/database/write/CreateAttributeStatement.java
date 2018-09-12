package com.weaverplatform.postgresql.database.write;

import com.weaverplatform.postgresql.database.Query;
import com.weaverplatform.postgresql.database.exceptions.WeaverDatabaseException;
import com.weaverplatform.postgresql.util.DateTimeParser;
import com.weaverplatform.protocol.model.CreateAttributeOperation;
import com.weaverplatform.util.DataTypeUtil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.weaverplatform.postgresql.util.WeaverError.DATATYPE_UNSUPPORTED;

/**
 * @author Mohamad Alamili
 */
public class CreateAttributeStatement  implements WriteStatement  {

  private CreateAttributeOperation operation;

  public CreateAttributeStatement() {
  }

  public CreateAttributeStatement(CreateAttributeOperation operation) {
    this.operation = operation;
  }

  @Override
  public String getUpdateQuery() {
    return Query.CREATE_ATTRIBUTE;
  }

  @Override
  public void addToBatch(PreparedStatement statement) throws SQLException, WeaverDatabaseException {
    if (operation.getDatatype() == null) {
      throw new WeaverDatabaseException(DATATYPE_UNSUPPORTED,
        "Unknown or no datatype provided for operation: " + operation.toJson());
    }

    statement.setString(1, operation.getId());
    statement.setString(2, operation.getGraph());
    statement.setString(3, operation.getSourceId());
    statement.setString(4, operation.getSourceGraph());
    statement.setString(5, operation.getKey());

    // Attribute values default null except for one
    statement.setNull(6, 0);
    statement.setNull(7, 0);
    statement.setNull(8, 0);
    statement.setNull(9, 0);

    Object value = operation.getValue();
    statement.setString(10, DataTypeUtil.getDatatypeCode(operation.getDatatype()));

    switch (DataTypeUtil.primitiveDataType(operation.getDatatype())) {

      case DOUBLE:
        statement.setDouble(6, (double) value);
        break;

      case STRING:
        statement.setString(7, value.toString());
        break;

      case BOOLEAN:
        statement.setBoolean(8, (boolean) value);
        break;

      case DATE:
        statement.setTimestamp(9, DateTimeParser.getUTCTimestamp(value), UTC_CALENDAR);
        break;
    }

    statement.addBatch();
  }
}
