package com.weaverplatform.postgresql.database;

import com.google.gson.Gson;
import com.weaverplatform.postgresql.database.query.WeaverQueryExecutor;
import com.weaverplatform.postgresql.database.query.model.CloneOperation;
import com.weaverplatform.postgresql.database.query.model.FindExistingNodesOperation;
import com.weaverplatform.postgresql.database.query.model.QueryResult;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import com.weaverplatform.postgresql.database.write.BatchWritesExecutor;
import com.weaverplatform.postgresql.database.write.ChunkedWriter;
import com.weaverplatform.postgresql.util.WeaverError;
import com.weaverplatform.protocol.model.WriteOperation;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.weaverplatform.postgresql.database.write.ChunkedWriter.SNAPSHOT_CHUNK_SIZE;
import static com.weaverplatform.postgresql.util.WeaverError.*;

/**
 * @author Mohamad Alamili
 */
public class Database {

  private static final Logger log = LoggerFactory.getLogger(Database.class);

  private String databaseName;

  public Database(String databaseName) {
    this.databaseName = databaseName;
  }

  public Connection getConnection() {
    try {
      return Postgres.INSTANCE.getConnection(databaseName);
    } catch (SQLException e) {
      throw new WeaverError(DATABASE_CONNECTION, "Could not get connection for database " + databaseName);
    }
  }

  public void write(List<WriteOperation> writeOperations) {
    try(BatchWritesExecutor exec = new BatchWritesExecutor(this)) {
      exec.write(writeOperations);
    } catch (Exception e) {
      String errorString = e.getLocalizedMessage();
      if (errorString.contains("duplicate key value violates unique constraint \"nodes_uid_graph_deleted_key\"")) {
        throw new WeaverError(NODE_ALREADY_EXISTS, "The id " + errorString.split("\'")[1] + " already exists");
      } else if (errorString.contains("replaced_attributes_replaced_key")) {
        throw new WeaverError(WRITE_OPERATION_INVALID, "The attribute that you are trying to update is out of synchronization with the database, therefore it wasn\'t saved");
      } else if (errorString.contains("replaced_relations_replaced_key")) {
        throw new WeaverError(WRITE_OPERATION_INVALID, "The relation that you are trying to update is out of synchronization with the database, therefore it wasn\'t saved");
      } else {
        throw e;
      }
    }
  }

  /**
   * Removes the database from existence. This operation forces
   * a DELETE query on the database, killing all active
   * sessions.
   *
   * @return true if it got removed, false otherwise.
   */
  public void delete() {
    log.debug(String.format("Going to delete database %s", databaseName));
    try (Connection connection = Postgres.INSTANCE.getConnection()) {
      PreparedStatement ps = connection.prepareStatement(String.format(Query.DELETE_DATABASE, databaseName, databaseName));
      ps.setString(1, databaseName);
      ps.execute();
      log.info(String.format("Deleted database %s", databaseName));
    } catch (SQLException e) {
      throw new WeaverError(DATABASE_CONNECTION, "" + ((PSQLException)e).getServerErrorMessage());
    }

    Postgres.INSTANCE.removeFromConnectionPool(databaseName);
  }

  public void wipe() {
    try (Connection connection = getConnection()) {
      connection.createStatement().execute(Query.WIPE);
    } catch (SQLException e) {
      log.error("Exception on wipe: ", e);
      throw new WeaverError(DATABASE_CONNECTION, "Could not execute wipe on " + databaseName);
    }
  }

  public List<String> getRelationKeys() {
    try (Connection connection = getConnection()) {
      ResultSet rs = connection.createStatement().executeQuery(Query.RELATION_KEYS);
      List<String> relationKeys = new ArrayList<>();

      while (rs.next()) {
        relationKeys.add(rs.getString("label"));
      }

      return relationKeys;
    } catch (SQLException e) {
      throw new WeaverError(RESULTSET_ERROR, "Could not read relationKeys");
    }
  }

  public QueryResult query(WeaverQuery query) {
    return new WeaverQueryExecutor(this).execute(query);
  }

  public void streamDump(OutputStream outputStream, boolean compress) {

    ChunkedWriter chunkedWriter = new ChunkedWriter();
    try(Connection conn = getConnection()) {
      chunkedWriter.stream(conn, outputStream, compress);
      while(chunkedWriter.hasNext()) {
        chunkedWriter.streamNext(SNAPSHOT_CHUNK_SIZE);
      }
    } catch(SQLException e) {
      throw new WeaverError(RESULTSET_ERROR, "Unable to get data for snapshot: " + e.getMessage());
    } finally {
      chunkedWriter.close();
    }
  }

  public void streamGraphDump(OutputStream outputStream, List<String> graphs, List<String> fromGraphs, List<String> toGraphs, boolean compress) {

    ChunkedWriter chunkedWriter = new ChunkedWriter(graphs);
    chunkedWriter.setFromGraphs(fromGraphs);
    chunkedWriter.setToGraphs(toGraphs);
    try(Connection conn = getConnection()) {
      chunkedWriter.stream(conn, outputStream, compress);
      while(chunkedWriter.hasNext()) {
        chunkedWriter.streamNext(SNAPSHOT_CHUNK_SIZE);
      }
    } catch(SQLException e) {
      throw new WeaverError(RESULTSET_ERROR, "Unable to get data for snapshot: " + e.getMessage());
    } finally {
      chunkedWriter.close();
    }
  }

  public List<Map<String, Object>> executePostgresQuery(String query) {
    try (Connection connection = getConnection()) {

      query = query.replace("\\", "");
      query = query.substring(1,query.length()-1);
      ResultSet rs = connection.createStatement().executeQuery(query);

      ResultSetMetaData rsmd = rs.getMetaData();

      List<String> columns = new ArrayList<>();

      for (int i = 1; i <= rsmd.getColumnCount(); i++) {
        columns.add(rsmd.getColumnName(i));
      }

      List<Map<String, Object>> rows = new ArrayList<>();

      while (rs.next()) {
        Map<String, Object> map = new HashMap<>();
        for (String columnName: columns) {
          map.put(columnName,rs.getObject(columnName) != null ? rs.getObject(columnName) : "null");
        }
        rows.add(map);
      }

      return rows;

    } catch (SQLException e) {
      System.out.println(e.getLocalizedMessage());
      throw new WeaverError(DATABASE_CONNECTION, "" + ((PSQLException)e).getServerErrorMessage());
    }
  }

  public int redirectGraph(String sourceGraph, String oldTargetGraph, String newTargetGraph, boolean dryrun, boolean doPartial) {
    log.debug(String.format("Got request to redirect relations from %s to %s to %s (dryrun %b, doPartial %b)", sourceGraph, oldTargetGraph, newTargetGraph, dryrun, doPartial));
    try(Connection connection = getConnection()) {
      PreparedStatement ps = connection.prepareStatement(Query.REDIRECT_GRAPH);
      ps.setString(1, sourceGraph);
      ps.setString(2, oldTargetGraph);
      ps.setString(3, newTargetGraph);
      ps.setBoolean(4, dryrun);
      ps.setBoolean(5, doPartial);

      ResultSet result = ps.executeQuery();
      result.next();
      return result.getInt(1);

    } catch (SQLException e) {
      throw new WeaverError(DATABASE_CONNECTION, "Redirection failed: " + e.getMessage());
    }
  }

  public void clone(CloneOperation cloneOperation) {
    log.debug(String.format("Going to clone node %s", cloneOperation.getSourceNodeId()));
    try (Connection connection = getConnection()) {
      PreparedStatement ps = connection.prepareStatement(Query.CREATE_USER);
      ps.setString(1,cloneOperation.getUserUid());
      ps.execute();

      if(null != cloneOperation.getTargetNodeGraph()) {
        ps = connection.prepareStatement(Query.CREATE_GRAPH);
        ps.setString(1, cloneOperation.getTargetNodeGraph());
        ps.execute();
      }

      ps = connection.prepareStatement(Query.CLONE_NODE);
      ps.setString(1, cloneOperation.getSourceNodeId());
      ps.setString(2, cloneOperation.getSourceNodeGraph());
      ps.setString(3, cloneOperation.getTargetNodeId());
      ps.setString(4, cloneOperation.getTargetNodeGraph());
      ps.setString(5, cloneOperation.getUserUid());
      ps.setArray(6, connection.createArrayOf("text", cloneOperation.getRelationsToTraverse().toArray()));
      ps.execute();
      log.info(String.format("Cloned node %s to %s", cloneOperation.getSourceNodeId(), cloneOperation.getTargetNodeId()));
    } catch (SQLException e) {
      log.warn(e.getMessage());
      throw new WeaverError(DATABASE_CONNECTION, "" + ((PSQLException)e).getServerErrorMessage());
    }
  }

  public void cleanupDatabase() {
    try (Connection connection = getConnection()) {
      PreparedStatement ps = connection.prepareStatement(Query.CLEAN_UP_DATABASE);
      ps.execute();
    } catch (SQLException e) {
      log.warn(e.getMessage());
      throw new WeaverError(DATABASE_CONNECTION, "" + ((PSQLException)e).getServerErrorMessage());
    }
  }

  public String findExistingNodes(FindExistingNodesOperation findExistingNodesOperation) {
    findExistingNodesOperation.setNodes(findExistingNodesOperation.getNodes());

    try (Connection connection = getConnection()) {
      List<HashMap<String, String>> existingNodes = new ArrayList<>();

      PreparedStatement ps = connection.prepareStatement(Query.FIND_EXISTING_NODES, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
      ps.setArray(1, connection.createArrayOf("text", findExistingNodesOperation.getNodeIds().toArray()));
      ps.setArray(2, connection.createArrayOf("text", findExistingNodesOperation.getGraphs().toArray()));

      boolean isResultSet = ps.execute();
      ResultSet rs;
      while (isResultSet) {
        rs = ps.getResultSet();

        while (rs.next()) {
          HashMap<String, String> h = new HashMap<>();

          String uid = rs.getString("uid");
          if (uid != null) {
            String graph = rs.getString("graph");

            if (graph == null)
              graph = "undefined";

            h.put(uid, graph);
            existingNodes.add(h);
          }
        }

        rs.close();
        isResultSet = ps.getMoreResults();
      }

      return new Gson().toJson(existingNodes);

    } catch (SQLException e) {
      log.warn(e.getMessage());
      throw new WeaverError(DATABASE_CONNECTION, "" + ((PSQLException)e).getServerErrorMessage());
    }
  }
}
