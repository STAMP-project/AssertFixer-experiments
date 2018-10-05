package com.weaverplatform.postgresql.database.query;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.weaverplatform.postgresql.database.Database;
import com.weaverplatform.postgresql.database.Query;
import com.weaverplatform.postgresql.database.model.*;
import com.weaverplatform.postgresql.database.query.model.*;
import com.weaverplatform.postgresql.util.WeaverError;
import com.weaverplatform.protocol.model.AttributeDataType;
import com.weaverplatform.util.DataTypeUtil;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;
import java.util.Date;

import static com.weaverplatform.postgresql.util.WeaverError.QUERY_INVALID;

/**
 * @author Mohamad Alamili
 */
public class WeaverQueryExecutor {

  static Logger log = LoggerFactory.getLogger(WeaverQueryExecutor.class);
  private Database database;

  public static final Calendar UTC_CALENDAR = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

  public WeaverQueryExecutor(Database database) {
    this.database = database;
  }

  public QueryResult execute(WeaverQuery query) {
    if (log.isTraceEnabled()) {
      log.trace(String.format("Query received: %s", query.toJson()));
    }

    if(query.isNoLimits()) {
      throw new WeaverError(-1, "No limits is not allowed to be specified by the user");
    }

    StopWatch totalStopWatch    = new StopWatch();
    StopWatch executionStopwatch = new StopWatch();
    StopWatch processingStopwatch = new StopWatch();

    QueryResult result = null;

    totalStopWatch.start();
    try (Connection connection = database.getConnection()) {
      String selectQuery;
      Map<String, WeaverNode> uidNodeMap = new HashMap<>(); // node uid -> node
      try {
        prepare(query);
        selectQuery = query.compileToPostgresQuery();
      }
      catch (EmptySubQueryException e ) {
        return new FindQueryResult(-1);
      }
      catch (Exception e){
        e.printStackTrace();
        throw new WeaverError(QUERY_INVALID, "Could not process query " + query.toJson());
      }

      Statement stmt = connection.createStatement();

      executionStopwatch.start();
      final ResultSet rs;
      try {
          rs = stmt.executeQuery(selectQuery);
        } catch (SQLException e) {
          System.err.println("Error in query:");
          System.err.println(selectQuery);
          e.printStackTrace();
          throw new WeaverError(-1, "A SQL Error occurred");
        }
      executionStopwatch.stop();
      long executionTime = executionStopwatch.getTime();

      if(log.isTraceEnabled()) {
        log.trace(String.format("Query execution time %d: %s", executionTime, query.toJson()));
      } else if (log.isInfoEnabled() && executionTime > 200) {
        log.info(String.format("Query execution time greater than 200: %d: %s", executionTime, query.toJson()));
      }

      processingStopwatch.start();
      result = new FindQueryResult(executionTime);
      result.setExecutionTimeStart(executionStopwatch.getStartTime());

      Map<Integer, WeaverNode> nodeMap = new HashMap<>();
      List<WeaverNode> orderedResult = new ArrayList<>();

      if(query.isCount()){
        rs.next();
        int count = rs.getInt("count");
        CountQueryResult countResult = new CountQueryResult(executionTime);
        countResult.setCount(count);
        result = countResult;
      } else if(query.isCountPerGraph()){
        CountQueryResult countResult = new CountQueryResult(executionTime);
        while(rs.next()) {
          String graph = rs.getString("uid");
          long count = rs.getLong("count");

          if(graph == null) {
            countResult.setDefaultGraph(count);
          } else {
            countResult.setGraphCount(graph, count);
          }
          countResult.setCount(countResult.getCount() + count);
        }
        result = countResult;
      }
      else {
        extractNodesFromQueryResult(query, rs, nodeMap, orderedResult, uidNodeMap);
        // Add all to result
        ((FindQueryResult)result).getNodes().addAll(orderedResult);
        prePostLoad(connection, orderedResult, query);
        loadAlwaysLoadRelations(connection, ((FindQueryResult)result).getNodes(), query.getAlwaysLoadRelations());
        loadRelationsIn(connection, ((FindQueryResult)result).getNodes(), query);
        ((FindQueryResult)result).setTemplateUsed(query.getTemplateUsed());
      }
      processingStopwatch.stop();
    } catch (SQLException e) {
      e.printStackTrace();
      throw new WeaverError(-1, "A SQL Error occurred");
    }
    long processingTime = processingStopwatch.getTime();
    result.setProcessingTime(processingTime);
    result.setProcessingTimeEnd(processingStopwatch.getStartTime() + processingTime);
    totalStopWatch.stop();
    result.setTotalTime(totalStopWatch.getTime());
    return result;
  }

  private Set<String> collect(List<List<String>> strings, int index) {
    Set<String> result = new HashSet<>();
    for(List<String> sl: strings) {
      if(index < sl.size())
        result.add(sl.get(index));
    }
    return result;
  }

  private void loadRelationsIn(Connection connection, List<WeaverNode> nodes, WeaverQuery query) throws SQLException {
    loadRelationsIn(connection, nodes, query, 0);
  }

  private void loadRelationsIn(Connection connection, Collection<WeaverNode> nodes, WeaverQuery query, int index) throws SQLException {
    if(query.getSelectIn() == null || nodes.isEmpty())
      return;

    Set<String> relationKeys = collect(query.getSelectIn(), index);
    Set<WeaverNode> newNodes = new HashSet<>();

    // We need to query these individually for now, performance optimization possible
    for(String key: relationKeys) {
      WeaverQuery q = new WeaverQuery().setSelect(query.getSelect()).hasRelationOut(key, nodes).setNoLimits(true);

      Statement statement = connection.createStatement();
      String queryString = q.compileToPostgresQuery();

      ResultSet rs = statement.executeQuery(queryString);

      // At this point, the stepNewNodes still have all relations (including those not specified by the root query)
      Collection<WeaverNode> stepNewNodes = extractNodesFromQueryResult(q, rs);
      // o(n^2), room for optimization here
      for(WeaverNode stepNode: stepNewNodes) {
        for (String relationKey: stepNode.getRelations().keySet()) {
          for (WeaverRelation rel : stepNode.getRelations().get(relationKey)) {
            for (WeaverNode n : nodes) {
              if (n.identityEquals(rel.getTarget())) {
                n.addRelationIn(new WeaverRelationIn(rel.getNodeId(), rel.getCreator(), rel.getCreated(), relationKey, stepNode));
              }
            }
          }
        }
      }

      removeUnwantedRelations(stepNewNodes, query.getSelectRelations());

      newNodes.addAll(stepNewNodes);
    }

    if(relationKeys.size() > 0)
      loadRelationsIn(connection, newNodes, query, ++index);
  }

  /**
   * Removed outgoing relations from nodes that have a key not in the acceptedRelation collection
   *
   * @param nodes
   * @param acceptedRelations can be null to disable filtering
   */
  private void removeUnwantedRelations(Collection<WeaverNode> nodes, Collection<String> acceptedRelations) {
    if(null == acceptedRelations)
      return;

    for(WeaverNode node: nodes) {
      Iterator<Map.Entry<String, List<WeaverRelation>>> finger = node.getRelations().entrySet().iterator();
      while(finger.hasNext()) {
        if (!acceptedRelations.contains(finger.next().getKey())) {
          finger.remove();
        }
      }
    }
  }

  private void collectAlwaysLoadRelationNodes(WeaverNode node, List<String> alwaysLoads, HashMap<String, List<WeaverNode>> nodesMap) {
    for(Map.Entry<String, List<WeaverRelation>> mapEntry: node.getRelations().entrySet()) {
      for(WeaverRelation relation: mapEntry.getValue()) {
        if(!nodesMap.containsKey(relation.getTarget().getNodeId())) {
          nodesMap.put(relation.getTarget().getNodeId(), new ArrayList<>());
        }
        nodesMap.get(relation.getTarget().getNodeId()).add(relation.getTarget());
        collectAlwaysLoadRelationNodes(relation.getTarget(), alwaysLoads, nodesMap);
      }
    }
  }
  private void collectAlwaysLoadRelationNodes(List<WeaverNode> nodes, List<String> alwaysLoads, HashMap<String, List<WeaverNode>> nodesMap) {
    for(WeaverNode node: nodes) {
      collectAlwaysLoadRelationNodes(node, alwaysLoads, nodesMap);
    }
  }

  private void loadAlwaysLoadRelations(Connection connection, List<WeaverNode> nodes, List<String> alwaysLoads) throws SQLException {
    HashMap<String, List<WeaverNode>> nodesMap = new HashMap<>();
    collectAlwaysLoadRelationNodes(nodes, alwaysLoads, nodesMap);

    PreparedStatement statement = connection.prepareStatement(Query.ALWAYS_LOAD_RELATIONS);
    statement.setArray(1, connection.createArrayOf("text", nodesMap.keySet().toArray()));
    statement.setArray(2, connection.createArrayOf("text", alwaysLoads.toArray()));

    ResultSet rs = statement.executeQuery();
    while(rs.next()) {
      String relationId = rs.getString(1);
      Date   createdOn  = rs.getDate(2);
      String creator    = rs.getString(3);
      String sourceId = rs.getString(4);
      String relation = rs.getString(5);
      String targetId = rs.getString(6);
      String targetGraph = rs.getString(7);

      log.trace(String.format("Got %s -%s-> %s", sourceId, relation, targetId));

      for(WeaverNode node: nodesMap.get(sourceId)) {
        // Add if it doesn't have this relations yet
        boolean add = null == node.getRelations().get(relation);

        // or it does but doesn't have the target
        if(!add) {
          for(WeaverRelation r : node.getRelations().get(relation)) {
            add = !r.getTarget().getNodeId().equals(targetId) || !Objects.equals(targetGraph, r.getTarget().getGraph());

            if(add)
              break;
          }
        }

        if(add) {
          WeaverNode target = new WeaverNode(targetId);
          target.setGraph(targetGraph);
          WeaverRelation r = new WeaverRelation(relationId, creator, createdOn, relation, target);
          node.addRelation(r);
        }
      }
    }
  }

  private void prePostLoad(Connection connection, Collection<WeaverNode> loadedNodes, WeaverQuery query) throws SQLException {
    prePostLoad(connection, loadedNodes, query.getSelectOut(), query, new HashSet<>());
  }

  private void prePostLoad(Connection connection, Collection<WeaverNode> loadedNodes, List<List<String>> selectOut, WeaverQuery query, HashSet<String> recursiveLoadedNodes) throws SQLException {
    Map<String, List<List<String>>> loadSplit = new HashMap<>();
    for(List<String> path: selectOut) {
      if(path.size() > 0) {
        String head = path.remove(0);

        if(!loadSplit.containsKey(head))
          loadSplit.put(head, new ArrayList<>());

        loadSplit.get(head).add(path);
      }
    }

    boolean recurseOnly = loadSplit.keySet().size() == 0;

    for(String rec: query.getSelectRecusiveOut())
      if (!loadSplit.containsKey(rec))
        loadSplit.put(rec, new ArrayList<>());


    for(String relationKey: loadSplit.keySet())
      postLoad(connection, loadedNodes, relationKey, loadSplit.get(relationKey), query, recursiveLoadedNodes, recurseOnly);
  }

  private void postLoad(Connection connection, Collection<WeaverNode> loadedNodes, String relationToLoad, List<List<String>> selectOut, WeaverQuery originalQuery, HashSet<String> recursiveLoadedNodes, boolean addToRecursiveLoadedNodes) throws SQLException {
    if(log.isTraceEnabled())
      log.trace(String.format("Postloading for relation %s", relationToLoad));

    WeaverQuery q = new WeaverQuery();
    q.setNoRelations(true);
    q.setNoLimits(true);
    Map<Integer, WeaverNode> nodesToLoad = new HashMap<>();
    for(WeaverNode node: loadedNodes) {
      for(String relationKey: node.getRelations().keySet()) {
        if(relationToLoad.equals(relationKey) || "*".equals(relationToLoad)) {
          for(WeaverRelation rtl: node.getRelations().get(relationKey)) {
            WeaverNode ntl = rtl.getTarget();

            if(!recursiveLoadedNodes.contains(ntl.getNodeId()))
              nodesToLoad.put(ntl.getDatabaseId(), ntl);

            if(addToRecursiveLoadedNodes)
              recursiveLoadedNodes.add(ntl.getNodeId());
          }
        }
      }
    }

    int[] ids = new int[nodesToLoad.size()];
    int i = 0;
    for(WeaverNode n: nodesToLoad.values()) {
      ids[i++] = n.getDatabaseId();
    }

    if (ids.length == 0){
      return;
    }

    q.restrictDatabaseIds(nodesToLoad.keySet());

    Statement statement = connection.createStatement();
    String query = q.compileToPostgresQuery();

    ResultSet rs = statement.executeQuery(query);

    fillNodesByDatabaseId(nodesToLoad, rs, originalQuery);

    prePostLoad(connection, nodesToLoad.values(), selectOut, originalQuery, recursiveLoadedNodes);
  }

  private void fillNodesByDatabaseId(Map<Integer, WeaverNode> nodesToLoad, ResultSet rs, WeaverQuery originalQuery) throws SQLException {
    Map<Integer, WeaverNode> relationTargetNodes = new HashMap<>();
    while (rs.next()) {
      int nodeId = rs.getInt("node_id");
      log.trace("Adding details for node " + nodeId);
      final WeaverNode node = nodesToLoad.get(nodeId);
      addNodeDetails(originalQuery, rs, relationTargetNodes, node);
    }
  }

  private Collection<WeaverNode> extractNodesFromQueryResult(WeaverQuery query, ResultSet rs) throws SQLException {
    Map<Integer, WeaverNode> nodes = new HashMap<>();
    extractNodesFromQueryResult(query, rs, nodes, new ArrayList<>(), new HashMap<>());
    return nodes.values();
  }

  private void extractNodesFromQueryResult(WeaverQuery query, ResultSet rs, Map<Integer, WeaverNode> nodeMap, List<WeaverNode> orderedResult, Map<String, WeaverNode> uidMap) throws SQLException {
    Map<Integer, WeaverNode> relationTargetNodes = new HashMap<>();
    while (rs.next()) {
      int nodeId = rs.getInt("node_id");
      String nodeUid = rs.getString("node_uid");
      String nodeGraph = rs.getString("node_graph");

      // Init node
      final WeaverNode node;
      if (!nodeMap.containsKey(nodeId)) {
        node = new WeaverNode();
        node.setDatabaseId(nodeId);
        nodeMap.put(nodeId, node);
        orderedResult.add(node);
      } else {
        node = nodeMap.get(nodeId);
      }

      if(null != nodeUid) {
        node.setNodeId(nodeUid);
        if(!uidMap.containsKey(nodeUid))
          uidMap.put(nodeUid, node);
      }
      if(null != nodeGraph)
        node.setGraph(nodeGraph);

      addNodeDetails(query, rs, relationTargetNodes, node);
    }
  }

  private void addNodeDetails(WeaverQuery query, ResultSet rs, Map<Integer, WeaverNode> relationTargetNodes, WeaverNode node) throws SQLException {
    String node_creator = rs.getString("node_created_by");
    Date node_created = getDate(rs.getTimestamp("node_created"));
    if(null != node_creator)
      node.setCreator(node_creator);
    if(null != node_created)
      node.setCreated(node_created);

    // Set removedNode is available
    String nodeRemovedBy = rs.getString("node_removed_by");
    if (nodeRemovedBy != null) {
      WeaverNode r = new WeaverNode(nodeRemovedBy);
      r.setGraph(rs.getString("node_removed_by_graph"));
    }

    String relationTargetUid = rs.getString("relation_target_uid");
    if (null != relationTargetUid) {
      WeaverNode t = new WeaverNode(relationTargetUid);
      t.setGraph(rs.getString("relation_target_graph"));
      node.setRelationTarget(t);

      WeaverNode s = new WeaverNode(rs.getString("relation_source_uid"));
      s.setGraph(rs.getString("relation_source_graph"));
      node.setRelationSource(s);
      node.setRelationKey(rs.getString("relation_key"));
    }

    // Shared property values
    String propertyId = rs.getString("property_uid");
    String propertyGraph = rs.getString("property_graph");
    String property_creator = rs.getString("property_creator");
    Date property_created = getDate(rs.getTimestamp("property_created"));
    String key = rs.getString("key");


    // Relations
    String target = rs.getString("target_uid");
    Integer targetId = rs.getInt("target_id");
    String targetGraph = rs.getString("target_graph");
    String target_creator = rs.getString("target_creator");
    Date target_created = rs.getTimestamp("target_created", Calendar.getInstance(TimeZone.getTimeZone("UTC")));

    String replacedBy = rs.getString("replaced_by");
    String propertyRemovedBy = rs.getString("property_removed_by");

    WeaverProperty property = null;
    //Is Relation
    if (target != null) {
      if(query.getSelectRelations() == null || query.getSelectRelations().contains(key)) {
        WeaverNode targetNode = relationTargetNodes.get(targetId);
        if (null == targetNode) {
          targetNode = new WeaverNode(target);
          targetNode.setGraph(targetGraph);
          targetNode.setDatabaseId(targetId);
          relationTargetNodes.put(targetId, targetNode);
        }
        WeaverRelation relation = new WeaverRelation(propertyId, property_creator, property_created, key, targetNode);

        node.addRelation(relation);
        property = relation;
      }
    } else if (propertyId != null && (query.getSelect() == null || query.getSelect().size() == 0 || query.getSelect().contains(key))) {
      // Attributes
      double doubleValue = rs.getDouble("double_value");
      boolean booleanValue = rs.getBoolean("boolean_value");
      Date dateValue = getDate(rs.getTimestamp("datetime_value",  Calendar.getInstance(TimeZone.getTimeZone("UTC"))));
      String stringValue = rs.getString("string_value");

      WeaverAttribute attribute = new WeaverAttribute(propertyId, property_creator, property_created, key);


      attribute.setDataType(DataTypeUtil.parse(rs.getString("attribute_datatype")));

      if (stringValue != null) {
        attribute.setValue(stringValue);
      } else if (dateValue != null) {
        attribute.setValue(dateValue.getTime());
      } else if (rs.getString("boolean_value") != null) {
        attribute.setValue(booleanValue);
      } else if (rs.getString("double_value") != null) {
        attribute.setValue(doubleValue);
      }

      node.addAttribute(attribute);
      property = attribute;
    }

    if (null != property) {
      if (null != propertyGraph)
        property.setGraph(propertyGraph);

      if (replacedBy != null) {
        property.setReplacedBy(new WeaverNode(replacedBy));
      }

      if (propertyRemovedBy != null) {
        property.setRemovedBy(new WeaverNode(propertyRemovedBy));
      }
    }
  }

  private void prepare(WeaverQuery query) throws EmptySubQueryException {
    for(String propertyName: query.getConditions().keySet()) {
      ConditionMap conditionValue = query.getConditions().get(propertyName);
      for(Map.Entry<String, Object> entry: new ArrayList<Map.Entry<String, Object>>(conditionValue.entrySet())) {
        String comparator = entry.getKey();
        Object value = entry.getValue();
        if(Arrays.asList(new String[] { "$relIn", "$relOut", "$noRelIn", "$noRelOut" }).contains(comparator)) {
          // So only these can contain references to other nodes or subqueries referencing them
          if (value instanceof List) {
            for (Object possibleObject : (List) value) {
              if (possibleObject instanceof Map || possibleObject instanceof WeaverQuery) {
                // If it is not one of the above, it's a string. That'll be treated as a NULL graph node id instead.
                // Otherwise it's either a query, or a nodeKey like. The Query we'll process, the nodekey is treated as above

                log.trace("Going to trace extractedNestedCondition");
                if(!(possibleObject instanceof Map &&  // If the map contains the id key, this is a node id-graph id
                  ((Map) possibleObject).containsKey("id"))) {
                  extractNestedCondition(conditionValue, comparator, possibleObject);
                } // Else this has id and should be used as a map
              } else {
                log.trace("No HashMap or query: " + possibleObject.getClass().getCanonicalName());
              }
            }
          } else {
            throw new WeaverError(WeaverError.QUERY_INVALID, String.format("Unexpected non list value %s for property %s", value.getClass().getCanonicalName(), propertyName));
          }
        }
      }
    }
  }

  private void extractNestedCondition(ConditionMap conditionValue, String key, Object possibleObject) throws EmptySubQueryException {
    Gson gson = new Gson();
    String json = gson.toJson(possibleObject);
    try {
      WeaverQuery q = gson.fromJson(json, WeaverQuery.class);
      q.setNoLimits(true);
      q.setDatabaseIdsOnly();
      // If the previous line does not throw a JSON formatting exception:
      // This is a sub query. get the database id's of the qualified nodes and modify queries

      conditionValue.remove(key);
      conditionValue.put(key, q);
      prepare(q);
    } catch (JsonSyntaxException e) {
      log.trace("No query: " + possibleObject.getClass().getCanonicalName());
      // This is fine, just means it is not a query, must be a nodereference instead
    }
  }

  private Date getDate(Timestamp timestamp){
    if (timestamp == null){
      return null;
    }

    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    cal.setTimeInMillis(timestamp.getTime());
    return cal.getTime();
  }

  private class EmptySubQueryException extends Exception {
  }
}
