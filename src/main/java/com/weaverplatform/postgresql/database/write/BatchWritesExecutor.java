package com.weaverplatform.postgresql.database.write;

import com.google.common.collect.Lists;
import com.weaverplatform.postgresql.database.Database;
import com.weaverplatform.postgresql.database.exceptions.WeaverDatabaseException;
import com.weaverplatform.postgresql.util.WeaverError;
import com.weaverplatform.protocol.model.WriteOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.weaverplatform.postgresql.util.WeaverError.WRITE_OPERATION_FAILED;

/**
 * @author Mohamad Alamili
 */
public class BatchWritesExecutor implements AutoCloseable {

  private static Logger logger = LoggerFactory.getLogger(BatchWritesExecutor.class);

  public static final int MAX_BATCH_SIZE = 500;

  private final Database database;
  private final Connection connection;
  private List<WriteOperation> writeOperations;
  private BatchWrites batchWrites;


  public BatchWritesExecutor(Database database) {
    this.database   = database;
    this.connection = database.getConnection();
  }

  /**
   * Write all supplied write operations
   */
  public void write(List<WriteOperation> writeOperations) {

    this.writeOperations = writeOperations;
    this.batchWrites = new BatchWrites(writeOperations);

    try {
      connection.setAutoCommit(false);
    } catch (SQLException e) {
      throw new WeaverError(WRITE_OPERATION_FAILED, "Could not set autocommit to false");
    }

    for (WriteStatement stmt : batchWrites.keySet()) {

      List<WriteStatement> writes = batchWrites.get(stmt);
      if(writes.isEmpty()) {
        continue;
      }

      for(List<WriteStatement> cappedWrites: Lists.partition(writes, MAX_BATCH_SIZE)){

        PreparedStatement preparedStatement = null;
        try {
          preparedStatement = connection.prepareStatement(stmt.getUpdateQuery());
        } catch (SQLException e) {
          logger.error("Error creating prepared statement", e);
        }
        batchWrite(preparedStatement, cappedWrites);
      }
    }

    try {
      connection.commit();
    } catch (SQLException e) {
      throw new WeaverError(WRITE_OPERATION_FAILED, "Could not commit: " + e.getMessage());
    }
  }

  private void batchWrite(PreparedStatement preparedStatement, List<WriteStatement> writes) {
    try {

      for(WriteStatement statement : writes) {
        statement.addToBatch(preparedStatement);
      }
      preparedStatement.executeBatch();

    } catch (SQLException | WeaverDatabaseException e) {

      logger.error("Error executing batchWrite, will rollback", e);

      try {
        connection.rollback();
      } catch (SQLException e1) {
        throw new WeaverError(WRITE_OPERATION_FAILED, "Could rollback");
      }

      throw new WeaverError(WRITE_OPERATION_FAILED, "Failed executing batch, reason: " + e.getMessage());
    }
  }

  @Override
  public void close() {
    try {
      connection.close();
    } catch (SQLException e) {
      throw new WeaverError(WRITE_OPERATION_FAILED, "Error closing connection");
    }
  }
}
