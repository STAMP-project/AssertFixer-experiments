package com.weaverplatform.postgresql.database.write;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import com.weaverplatform.postgresql.database.Query;
import com.weaverplatform.postgresql.util.DateTimeParser;
import com.weaverplatform.postgresql.util.Props;
import com.weaverplatform.postgresql.util.UTCTimestamp;
import com.weaverplatform.protocol.WeaverError;
import com.weaverplatform.protocol.model.*;
import com.weaverplatform.util.DataTypeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import static com.weaverplatform.protocol.WeaverError.RESULTSET_ERROR;

/**
 * @author bastbijl, Sysunite 2017
 */
public class ChunkedWriter {

  private static final Logger log = LoggerFactory.getLogger(ChunkedWriter.class);

  public static int SNAPSHOT_CHUNK_SIZE;
  static {
    SNAPSHOT_CHUNK_SIZE = Integer.parseInt(Props.get("SNAPSHOT_CHUNK_SIZE", "file.snapshot_chunk_size"));
  }

  protected Connection connection;
  private List<String> graphs = new ArrayList<>();
  private List<String> fromGraphs = new ArrayList<>();
  private List<String> toGraphs = new ArrayList<>();
  private PreparedStatement statement;
  private ResultSet resultSet;
  private JsonWriter writer;
  private Gson gson = new Gson();

  private boolean finishedNodes = false;
  private boolean finishedAttributes = false;
  private boolean finishedRelations = false;

  public ChunkedWriter() {
  }
  public ChunkedWriter(List<String> graphs) {
    this.graphs = graphs;
  }

  private boolean includeDefaultGraph(List<String> list) {
    if(list == null || list.isEmpty()) {
      return true;
    }
    if(list.contains(null)) {
      return true;
    }
    return false;
  }

  private boolean noGraphFilter() {
    return graphs == null || graphs.isEmpty();
  }

  private boolean noSourceGraphFilter() {
    return fromGraphs == null || fromGraphs.isEmpty();
  }

  private boolean noTargetGraphFilter() {
    return toGraphs == null || toGraphs.isEmpty();
  }

  public void setFromGraphs(List<String> fromGraphs) {
    this.fromGraphs = fromGraphs;
  }

  public void setToGraphs(List<String> toGraphs) {
    this.toGraphs = toGraphs;
  }

  public void stream(Connection connection, OutputStream outputStream, boolean compress) {
    this.connection = connection;
    try {
      if(compress) {
        outputStream = new GZIPOutputStream(outputStream);
      }
      writer = new JsonWriter(new OutputStreamWriter(outputStream, "UTF-8"));
      writer.setIndent("  ");
      writer.beginArray();
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("Error during streaming dump");
    } catch (IOException e) {
      throw new RuntimeException("Error during streaming dump");
    }
  }

  private void checkInitialized() {
    if(connection == null || writer == null) {
      throw new RuntimeException("Initialize the ChunkedWriter");
    }
  }

  public boolean hasNext() {
    checkInitialized();
    return !finishedNodes || !finishedAttributes || !finishedRelations;
  }

  public void close() {
    checkInitialized();
    try {
      writer.endArray();
      writer.close();
    } catch (IOException e) {
      throw new RuntimeException("Error during streaming dump");
    }
  }

  protected ResultSet queryNodes() {
    try {
      if(!noGraphFilter()) {
        statement = connection.prepareStatement(Query.DUMP_NODES_IN_GRAPH);
        statement.setBoolean(1, includeDefaultGraph(graphs));
        statement.setArray(2, connection.createArrayOf("text", graphs.toArray()));
        return statement.executeQuery();
      } else {
        return connection.createStatement().executeQuery(Query.DUMP_NODES);
      }
    } catch(SQLException e) {
      throw new WeaverError(RESULTSET_ERROR, "Unable to get data for snapshot: " + e.getMessage());
    }
  }

  protected ResultSet queryAttributes() {
    try {
      statement = connection.prepareStatement(Query.DUMP_ATTRIBUTES);
      statement.setBoolean(1, noGraphFilter());
      statement.setBoolean(2, includeDefaultGraph(graphs));
      statement.setArray(3, connection.createArrayOf("text", graphs.toArray()));
      statement.setBoolean(4, noSourceGraphFilter());
      statement.setBoolean(5, includeDefaultGraph(fromGraphs));
      statement.setArray(6, connection.createArrayOf("text", fromGraphs.toArray()));
      return statement.executeQuery();
    } catch(SQLException e) {
      throw new WeaverError(RESULTSET_ERROR, "Unable to get data for snapshot: " + e.getMessage());
    }
  }

  protected ResultSet queryRelations() {
    try {
      statement = connection.prepareStatement(Query.DUMP_RELATIONS);
      statement.setBoolean(1, noGraphFilter());
      statement.setBoolean(2, includeDefaultGraph(graphs));
      statement.setArray(3, connection.createArrayOf("text", graphs.toArray()));
      statement.setBoolean(4, noSourceGraphFilter());
      statement.setBoolean(5, includeDefaultGraph(fromGraphs));
      statement.setArray(6, connection.createArrayOf("text", fromGraphs.toArray()));
      statement.setBoolean(7, noTargetGraphFilter());
      statement.setBoolean(8, includeDefaultGraph(toGraphs));
      statement.setArray(9, connection.createArrayOf("text", toGraphs.toArray()));
      return statement.executeQuery();
    } catch(SQLException e) {
      throw new WeaverError(RESULTSET_ERROR, "Unable to get data for snapshot: " + e.getMessage());
    }
  }


  public void streamNext(int chunkSize) {
    checkInitialized();
    int count = 0;
    try {

      if(!finishedNodes && count < chunkSize) {
        if(resultSet == null) {
          resultSet = queryNodes();
        }
        while(resultSet.next()) {
          gson.toJson(createNodeCreationOperation(resultSet), CreateNodeOperation.class, writer);
          if(++count == chunkSize) {
            break;
          }
        }
        // Reached end of resultSet
        if(count != chunkSize) {
          log.info("Finished writing nodes");
          finishedNodes = true;
          resultSet = null;
        }
      }

      if(!finishedAttributes && count < chunkSize) {
        if(resultSet == null) {
          resultSet = queryAttributes();
        }
        while(resultSet.next()) {
          gson.toJson(createAttributeCreationOperation(resultSet), CreateAttributeOperation.class, writer);
          if(++count == chunkSize) {
            break;
          }
        }
        // Reached end of resultSet
        if(count != chunkSize) {
          log.info("Finished writing attributes");
          finishedAttributes = true;
          resultSet = null;
        }
      }

      if(!finishedRelations && count < chunkSize) {
        if(resultSet == null) {
          resultSet = queryRelations();
        }
        while(resultSet.next()) {
          gson.toJson(createRelationCreationOperation(resultSet), CreateRelationOperation.class, writer);
          if(++count == chunkSize) {
            break;
          }
        }
        // Reached end of resultSet
        if(count != chunkSize) {
          log.info("Finished writing relations");
          finishedRelations = true;
          resultSet = null;
        }
      }

      log.info("Done, got "+count+" write operations");
    } catch(SQLException e) {
      throw new WeaverError(RESULTSET_ERROR, "Unable to get data for snapshot: " + e.getMessage());
    }
  }

  private CreateNodeOperation createNodeCreationOperation(ResultSet rs) throws SQLException {
    CreateNodeOperation operation = new CreateNodeOperation(rs.getString("creator_uid"), rs.getString("node_uid"));
    operation.setGraph(rs.getString("graph"));
    return operation;
  }

  private CreateAttributeOperation createAttributeCreationOperation(ResultSet rs) throws SQLException {
    Object value = null;
    switch(resolvePrimitiveTypeOfResultSet(rs)) {
      case DATE:
        value = DateTimeParser.getUTCTime(rs.getTimestamp("datetime_value", UTCTimestamp.UTC_CALENDAR).getTime());
        break;
      case BOOLEAN:
        value = rs.getBoolean("boolean_value");
        break;
      case STRING:
        value = rs.getString("string_value");
        break;
      case DOUBLE:
        value = rs.getDouble("double_value");
        break;
    }

    String user = rs.getString("creator_uid");
    String id = rs.getString("attribute_uid");
    String sourceId = rs.getString("source_uid");
    String key = rs.getString("attribute_label");
    AttributeDataType ad = DataTypeUtil.parse(rs.getString("datatype"));

    CreateAttributeOperation operation = new CreateAttributeOperation(user, id, sourceId, key, value, ad);
    operation.setGraph(rs.getString("graph"));
    operation.setSourceGraph(rs.getString("source_graph"));
    return operation;
  }

  private CreateRelationOperation createRelationCreationOperation(ResultSet rs) throws SQLException {
    CreateRelationOperation operation = new CreateRelationOperation(rs.getString("creator_uid"), rs.getString("relation_uid"), rs.getString("source_uid"), rs.getString("relation_label"), rs.getString("target_uid"));
    operation.setGraph(rs.getString("graph"));
    operation.setSourceGraph(rs.getString("source_graph"));
    operation.setTargetGraph(rs.getString("target_graph"));
    return operation;
  }

  /**
   * Resolves attribute type based on a ResultSet.
   * @param rs the ResultSet.
   * @return a AttributeDataType or null when it couldn't be decided.
   * @throws SQLException if the columnLabel is not valid; if a database
   * access error occurs or this method is called on a closed result set
   */
  private PrimitiveDataType resolvePrimitiveTypeOfResultSet(ResultSet rs) throws SQLException {
    if(rs.getObject("datetime_value") != null)
      return PrimitiveDataType.DATE;
    if(rs.getObject("boolean_value") != null)
      return PrimitiveDataType.BOOLEAN;
    if(rs.getObject("string_value") != null)
      return PrimitiveDataType.STRING;
    if(rs.getObject("double_value") != null)
      return PrimitiveDataType.DOUBLE;
    return null;
  }
}
