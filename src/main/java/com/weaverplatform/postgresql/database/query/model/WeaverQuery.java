package com.weaverplatform.postgresql.database.query.model;

import com.google.gson.Gson;
import com.weaverplatform.postgresql.database.model.WeaverNode;
import com.weaverplatform.postgresql.util.FreeMarker;
import com.weaverplatform.postgresql.util.WeaverError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author Mohamad Alamili
 */
public class WeaverQuery {
  private static Logger log = LoggerFactory.getLogger(WeaverQuery.class);

  /**
   *
   TODO
   - sort / order / ascending
   - select
   *
   */


  /**
   * $ne
   * $lt
   * $gt
   * $lte
   * $gte
   * $in
   * $nin
   * $all
   * $exists (true or false)
   * $regex
   *
   * $relIn
   * $relOut
   * $noRelIn
   * $noRelOut
   *
   * $inQuery
   * $notInQuery
   * $select
   * $dontSelect
   *
   * noRelations
   */

  public static final int DEFAULT_SKIP = 0;
  public static final int DEFAULT_LIMIT = 100;
  public static final int MAXIMUM_LIMIT = 1000;

  private List<String>              _inGraph;
  private List<WeaverQuery>         _orQueries;
  private Set<String>               _restrict;
  private transient Set<Integer>    _restrictDatabaseIds; // This shouldn't leak to clients
  private Map<String, Object>       _equals;
  private Map<String, Object>       _notEquals;
  private Map<String, Object>       _greaterThan;
  private Map<String, Object>       _greaterThanOrEqual;
  private Map<String, Object>       _lessThan;
  private Map<String, Object>       _lessThanOrEqual;
  private Map<String, ConditionMap> _conditions;
  private List<List<String>>        _selectOut;
  private List<List<String>>        _selectIn;
  private List<String>              _selectRecursiveOut;
  private List<String>              _alwaysLoadRelations;

  private Map<String, ConditionMap> _containsConditions;
  private Map<String, ConditionMap> _relationConditions;
  private Map<String, ConditionMap> _relationArrayConditions;

  private List<RecursiveCondition> _recursiveConditions;

  // Include loading nodes of specific relations
  private List<String>              _include;

  // Define which attributes should be returned
  private List<String>              _select;
  // Defined which relations should be returned
  private List<String>              _selectRelations;

  private List<String>              _order;
  private boolean                   _noRelations  = true;
  private boolean                   _noAttributes = true;

  // Only return the node id and any fields if available in the select
  private boolean                   _hollow;
  private boolean                   _ascending = true;
  private boolean                   _count;
  private boolean                   _countPerGraph;
  private int                       _limit = DEFAULT_LIMIT;
  private int                       _skip;
  private String template;
  private boolean idsOnly;
  private boolean databaseIdsOnly;

  private boolean noLimits;

  public WeaverQuery() {
    this._orQueries           = new ArrayList<>();
    this._restrict            = new HashSet<>();
    this._equals              = new HashMap<>();
    this._notEquals           = new HashMap<>();
    this._greaterThan         = new HashMap<>();
    this._greaterThanOrEqual  = new HashMap<>();
    this._lessThan            = new HashMap<>();
    this._lessThanOrEqual     = new HashMap<>();
    this._conditions          = new HashMap<>();
    this._include             = new ArrayList<>();
    this._order               = new ArrayList<>();
    this._selectOut           = new ArrayList<>();
    this._selectRecursiveOut  = new ArrayList<>();
    this._alwaysLoadRelations = new ArrayList<>();
  }

  public WeaverQuery(List<WeaverQuery> _orQueries, Set<String> _restrict, Map<String, Object> _equals, Map<String, ConditionMap> _conditions, List<String> _include, List<String> _select,
                     List<String> _order, boolean _noRelations, boolean _hollow, boolean _ascending, boolean _count, boolean _countPerGraph, int _limit, int _skip, List<List<String>> _selectOut,
                     Map<String, Object> _notEquals, Map<String, Object> _greaterThan, Map<String, Object> _greaterThanOrEqual, Map<String, Object> _lessThan, Map<String, Object> _lessThanOrEqual) {
    this._orQueries = _orQueries;
    this._restrict = _restrict;
    this._equals = _equals;
    this._notEquals = _notEquals;
    this._greaterThan = _greaterThan;
    this._greaterThanOrEqual = _greaterThanOrEqual;
    this._lessThan = _lessThan;
    this._lessThanOrEqual = _lessThanOrEqual;
    this._conditions = _conditions;
    this._include = _include;
    this._select = _select;
    this._order = _order;
    this._noRelations = _noRelations;
    this._hollow = _hollow;
    this._ascending = _ascending;
    this._count = _count;
    this._countPerGraph = _countPerGraph;
    this._limit = _limit;
    this._skip = _skip;
    this._selectOut = _selectOut;
    this._selectRecursiveOut = _selectRecursiveOut;
  }

  public WeaverQuery addCondition(String key, ConditionMap value) {
    _conditions.put(key, value);
    return this;
  }

  public String compileToPostgresQuery(){
    Map<String, WeaverQuery> dataModel = new HashMap<>();
    dataModel.put("query", this);

    String result;

    if(_noRelations &&
      _noAttributes &&
      _order.size() <= 1
      && (_order.size() == 0 || _ascending)
      && _orQueries.size() == 0
      && _include.size() == 0) {
      template = "nodes-new.fsql";
    } else if(_selectRecursiveOut.size() > 0 || getRelationArrayConditions().size() > 0 || isNoLimits()) {
      throw new WeaverError(-1, "Error: unsupported combination of options");
    } else {
      template = "nodes-all.fsql";
    }
    result = FreeMarker.process(template, dataModel).replaceAll("\n\n\n+", "\n\n");
    log.debug(String.format("Using query template %s", template));
    log.trace(String.format("Resulting query %s", result));
    return result;
  }

  public Map<String, ConditionMap> getConditions(){
    if (this._conditions == null) {
      this._conditions = new HashMap<>();
    }

    return this._conditions;
  }

  public WeaverQuery selectIn(String... relationKeyPath){
    if(null == _selectIn)
      _selectIn = new ArrayList<>();

    _selectIn.add(Arrays.asList(relationKeyPath));
    return this;
  }

  public Set<String> getRestrictions(){
    if (this._restrict == null) {
      this._restrict = new HashSet<>();
    }

    return this._restrict;
  }

  public Map<String, Object> getEquals(){
    if (this._equals == null) {
      this._equals = new HashMap<>();
    }

    return this._equals;
  }

  public WeaverQuery equals(String key, String value) {
    getEquals().put(key, value);
    return this;
  }

  public Map<String, String> getStringEquals(){
    Map<String, Object> equals = getEquals();
    Map<String, String> stringEquals = new HashMap<>();
    for (String key : equals.keySet()){
      try {
        stringEquals.put(key, (String) equals.get(key));
      } catch (Exception e){}
    }

    return stringEquals;
  }

  public Map<String, Boolean> getBooleanEquals(){
    Map<String, Object> equals = getEquals();
    Map<String, Boolean> booleanEquals = new HashMap<>();
    for (String key : equals.keySet()){
      try {
        booleanEquals.put(key, (Boolean) equals.get(key));
      } catch (Exception e){}
    }

    return booleanEquals;
  }

  public Map<String, Double> getDoubleEquals(){
    Map<String, Object> equals = getEquals();
    Map<String, Double> doubleEquals = new HashMap<>();
    for (String key : equals.keySet()){
      try {
        doubleEquals.put(key, (Double) equals.get(key));
      } catch (Exception e){}
    }

    return doubleEquals;
  }

  public Map<String, Timestamp> getTimestampEquals(){
    Map<String, Object> equals = getEquals();
    Map<String, Timestamp> timestampEquals = new HashMap<>();
    for (String key : equals.keySet()){
      try {
        timestampEquals.put(key, (Timestamp) equals.get(key));
      } catch (Exception e){}
    }
    return timestampEquals;
  }


  public WeaverQuery restrict(String... nodeIds) {
    getRestrictions().addAll(Arrays.asList(nodeIds));

    return this;
  }

  public Map<String, Boolean> getExists() {
    Map<String, Boolean> result = new HashMap<>();

    for(String key: _conditions.keySet()) {
      ConditionMap map = _conditions.get(key);
      for(Object mapKey: map.keySet()) {
        if("$exists".equals(mapKey)) {
          result.put(key, (Boolean) map.get(mapKey));
        }
      }
    }

    return result;
  }

  public boolean hasRestricts(){
    return _restrict != null && !_restrict.isEmpty();
  }

  // TODO: Solve this in freemarker
  public String getCommaSeparatedRestricts(){
    String restricts = "";
    for (String r : _restrict){
      restricts += "'" + r + "',";
    }

    return restricts.substring(0, restricts.length() - 1);
  }

  public boolean hasDatabaseIdRestrictions() {
    return null != _restrictDatabaseIds;
  }

  public Set<Integer> getDatabaseIdRestrictions() {
    if(!hasDatabaseIdRestrictions())
      _restrictDatabaseIds = new HashSet<>();
    return _restrictDatabaseIds;
  }

  public WeaverQuery restrictDatabaseIds(Collection<Integer> databaseIds) {
    getDatabaseIdRestrictions().addAll(databaseIds);
    return this;
  }
  public String getCommaSeparatedDatabaseIdRestrictions(){
    String restricts = "";
    for (int r : _restrictDatabaseIds){
      restricts += r + ",";
    }

    return restricts.substring(0, restricts.length() - 1);
  }

  public int getLimit(){
    if (_limit < 0)
      return DEFAULT_LIMIT;
    else if(_limit > MAXIMUM_LIMIT)
      return MAXIMUM_LIMIT;
    else
      return _limit;
  }

  public int getOffset(){
    if (_skip < 0)
      return DEFAULT_SKIP;
    else
      return _skip;
  }

  public boolean isCount() {
    return _count;
  }
  public boolean isCountPerGraph() {
    return _countPerGraph;
  }

  public boolean getRelationNodes() {
    return !_noRelations;
  }

  public List<Condition> getExclusions() {
    return new ArrayList<>();
  }

  public String toJson(){
    return new Gson().toJson(this);
  }

  public boolean isHollow() {
    return _hollow;
  }

  public WeaverQuery setLimit(int limit) {
    this._limit = limit;
    return this;
  }

  public boolean isNoRelations() {
    return _noRelations;
  }

  public boolean isNoAttributes() {
    return _noAttributes;
  }

  public boolean hasNoConditions(){
    return getConditions().isEmpty() && getEquals().isEmpty();
  }

  public boolean hasOrder() {
    return _order != null && _order.size() > 0;
  }

  public boolean hasOffset() {
    return _skip > 0;
  }

  public List<String> getOrder() {
    return _order;
  }

  public boolean getAscending() {
    return _ascending;
  }

  public String getTemplateUsed() {
    return template;
  }

  public boolean liveIndividualsOnly() {
    return _noAttributes && _noRelations;
  }

  public void setIdsOnly() {
    idsOnly = true;
  }

  public boolean getIdsOnly() {
    return idsOnly;
  }

  private void splitConditions() {
    if(null == _containsConditions) {
      _containsConditions = new HashMap<>();
      _relationConditions = new HashMap<>();
      _relationArrayConditions = new HashMap<>();

      for(String conditionKey: _conditions.keySet()) {
        ConditionMap condition = _conditions.get(conditionKey);
        String conditionValueKey = condition.keySet().iterator().next();
        if(conditionKey.startsWith("$relationArray$")) {
          _relationArrayConditions.put(conditionKey, condition);
        } else if (conditionValueKey.equals("$contains")) {
          _containsConditions.put(conditionKey, condition);
        } else {
          _relationConditions.put(conditionKey, condition);
        }
      }
    }

  }

  public List<List<String>> getSelectOut() {
    return _selectOut;
  }

  public List<List<String>> getSelectIn() {
    return _selectIn;
  }

  public void setSelectOut(List<List<String>> _selectOut) {
    this._selectOut = _selectOut;
  }

  public Map<String, ConditionMap> getContainsConditions() {
    splitConditions();
    return _containsConditions;
  }

  public Map<String, ConditionMap> getRelationConditions() {
    splitConditions();
    return _relationConditions;
  }

  public Map<String, ConditionMap> getRelationArrayConditions() {
    splitConditions();
    return _relationArrayConditions;
  }

  public WeaverQuery setNoRelations(boolean _noRelations) {
    this._noRelations = _noRelations;
    return this;
  }

  public boolean isNoLimits() {
    return noLimits;
  }

  public WeaverQuery setNoLimits(boolean noLimits) {
    this.noLimits = noLimits;
    return this;
  }

  public List<String> getSelectRecusiveOut() {
    return _selectRecursiveOut;
  }

  public List<String> getSelect() {
    return _select;
  }

  public WeaverQuery setSelect(List<String> selects) {
    _select = selects;
    return this;
  }

  public List<String> getAlwaysLoadRelations() {
    return _alwaysLoadRelations;
  }

  public boolean hasInclusiveIDRestrictions() {
    return getInclusiveIDRestrictions().size() > 0;
  }

  public boolean hasExclusiveIDRestrictions() {
    return getExclusiveIDRestrictions().size() > 0;
  }

  /**
   * This generates the list of select statements which meet the criteria to be excluded from the
   * result set. So "has no relation X to Y" would result in a SELECT of id of nodes that actually
   * have relation X to Y, which in the template are then excluded by unioning the exclude select
   *
   * @return
   */
  public List<String> getExclusiveIDRestrictions() {
     List<String> result = getExclusiveRecursiveRestrictions();

    for(Map.Entry<String, ConditionMap> i: getRelationArrayConditions().entrySet()) {
      String conditionName = i.getKey();
      ConditionMap condition = i.getValue();
      if(condition.containsKey("$noRelIn") || condition.containsKey("$noRelOut")) {
        String clause = "SELECT " + (condition.containsKey("$noRelOut")? "source" : "target")
          + " FROM live_relations WHERE KEY = ANY ((SELECT array("
          + "SELECT rk.id FROM relation_keys rk WHERE "
          + "FALSE ";

        if(condition.values().size() != 1) {
          throw new WeaverError(-1, "A condition can only have one entry");
        }
        for (Object j: condition.values()) {
          for(String allowedRelation: (Collection<String>) j) {
            clause += " OR rk.label = '"  + allowedRelation + "' ";
          }
        }

        clause += "))::integer[])";
        result.add(clause);
      }
    }

    for(Map.Entry<String, Boolean> i: getExists().entrySet()) {
      String attribute = i.getKey();
      Boolean value    = i.getValue();

      if (!value) {
        result.add(
          " SELECT source FROM live_attributes WHERE key = (SELECT ak.id FROM attribute_keys ak WHERE ak.label = '" + attribute + "')"
        );
      }
    }

    for(Map.Entry<String, ConditionMap> i: getRelationConditions().entrySet()) {
      String conditionName = i.getKey();
      ConditionMap condition = i.getValue();
      if(condition.containsKey("$noRelIn") || condition.containsKey("$noRelOut")) {
        String clause = "SELECT " + (condition.containsKey("$noRelOut")? "source" : "target")
          + " FROM live_relations WHERE ";
        if ("*".equals(conditionName))  {
          clause += "TRUE";
        } else {
          clause += "key = (SELECT rk.id FROM relation_keys rk WHERE rk.label = '" + conditionName + "')";
        }

        for(Map.Entry<String, Object> mapEntry: condition.entrySet()) {
          boolean isNoRelInCondition = "$noRelIn".equals(mapEntry.getKey());
          boolean isNoRelOutCondition = "$noRelOut".equals(mapEntry.getKey());

          if(!isNoRelInCondition && !isNoRelOutCondition)
            continue;

          if (mapEntry.getValue() instanceof WeaverQuery) {
            clause += " AND " + (isNoRelInCondition ? "source" : "target") + " = ANY ((SELECT array(";
            clause += " SELECT tn.id FROM live_individuals tn WHERE FALSE";

            clause += " OR tn.id = ANY  ((SELECT array(";
            clause += ((WeaverQuery) mapEntry.getValue()).compileToPostgresQuery();
            clause += "))::integer[])";

            clause += "))::integer[])";
          } else {
            Collection<Object> values = (Collection<Object>) mapEntry.getValue();

            // If it is not the wildcard selector
            Object firstValue = values.iterator().next();

            if (!(firstValue instanceof String) || !"*".equals(firstValue)) {
              clause += " AND " + (isNoRelInCondition ? "source" : "target") + " = ANY ((SELECT array(";
              clause += " SELECT tn.id FROM live_individuals tn WHERE FALSE";
              // Three options: the values a strings (uids), integers (database ids), or hashMaps (nodekeys)
              if (firstValue instanceof String) {
                for (Object value : values) {
                  clause += " OR (tn.uid = '" + ((String) value) + "' AND tn.graph = 1)"; // Hard reference to the default graph here
                }
              } else if (firstValue instanceof Integer) {
                for (Object value : values) {
                  clause += " OR tn.id = " + ((Integer) value);
                }
              } else if (firstValue instanceof Map) {
                for (Object value : values) {
                  Map map = (Map) value;
                  if (null != map.get("graph"))
                    clause += " OR (tn.uid = '" + map.get("id") + "' AND tn.graph = (SELECT id FROM graphs WHERE uid = '" + map.get("graph") + "'))";
                  else
                    clause += " OR (tn.uid = '" + map.get("id") + "' AND tn.graph = (SELECT id FROM graphs WHERE uid IS NULL))";
                }
              }
              clause += "))::integer[])";
            } else {
              log.trace("Firstvalue is a string and *");
            }
          }
        }
        result.add(clause);
      }
    }

    return result;
  }

  public List<String> getExclusiveRecursiveRestrictions() {
    List<String> result = new ArrayList<>();
    if (_recursiveConditions != null) {
      for (RecursiveCondition rc : _recursiveConditions) {
        if ("$noRelOut".equals(rc.getOperation())) {
          result.add("SELECT nodeids_with_recursive_relation_out('" + rc.getRelation() + "', '" + rc.getNodeId() + "', " + (rc.getNodeGraph() == null? "NULL" : "'" + rc.getNodeGraph() + "'") + ", " + rc.isIncludeSelf() + ")");
        } else if ("$noRelIn".equals(rc.getOperation())) {
          result.add("SELECT nodeids_with_recursive_relation_in('" + rc.getRelation() + "', '" + rc.getNodeId()  + "', " + (rc.getNodeGraph() == null? "NULL" : "'" + rc.getNodeGraph() + "'") + ", " + rc.isIncludeSelf() + ")");
        }
      }
    }

    return result;
  }

  public List<String> getInclusiveRecursiveRestrictions() {
    List<String> result = new ArrayList<>();
    if (_recursiveConditions != null) {
      for (RecursiveCondition rc : _recursiveConditions) {
        if ("$relOut".equals(rc.getOperation())) {
          result.add("SELECT nodeids_with_recursive_relation_out('" + rc.getRelation() + "', '" + rc.getNodeId() + "', " + (rc.getNodeGraph() == null? "NULL" : "'" + rc.getNodeGraph() + "'") + ", " + rc.isIncludeSelf() + ") as qid");
        } else if ("$relIn".equals(rc.getOperation())) {
          result.add("SELECT nodeids_with_recursive_relation_in('" + rc.getRelation() + "', '" + rc.getNodeId() + "', " + (rc.getNodeGraph() == null ? "NULL" : "'" + rc.getNodeGraph() + "'") + ", " + rc.isIncludeSelf() + ") as qid");
        }
      }
    }

    return result;
  }

  /**
   * Generates a list of SELECT statements of node id's of nodes that do meet the requirements
   * specified in queries. These statements are then INTERSECTed in the query to find all nodes
   * that meet all the criteria.
   *
   * @return
   */
  public List<String> getInclusiveIDRestrictions() {
    List<String> result = getInclusiveRecursiveRestrictions();

    if(null != _restrictDatabaseIds && _restrictDatabaseIds.size() > 0) {
      StringBuilder builder = new StringBuilder("SELECT v.qid FROM (VALUES ");
      final int length = _restrictDatabaseIds.size();
      int count = 0;
      for(int value: _restrictDatabaseIds) {
        builder.append("(");
        builder.append(value);
        builder.append(")");
        if(++count != length) {
          builder.append(",");
        }
      }

      builder.append(") v(qid)");
      result.add(builder.toString());
    }

    for(Map.Entry<String, String> i: getStringEquals().entrySet()) {
      String attribute = i.getKey();
      String value = i.getValue();
      if ("*".equals(value)) {
        result.add(
          " SELECT source as qid FROM live_attributes WHERE key = (SELECT ak.id FROM attribute_keys ak WHERE ak.label = '" + attribute + "')"
        );
      } else {
        result.add(
          " SELECT source AS qid FROM live_attributes WHERE key = (SELECT ak.id FROM attribute_keys ak WHERE ak.label = '" + attribute + "')"
            + " AND string_value = '" + value + "' "
        );
      }
    }

    for(Map.Entry<String, Boolean> i: getBooleanEquals().entrySet()) {
      String attribute = i.getKey();
      Boolean value = i.getValue();

      result.add(
        " SELECT source AS qid FROM live_attributes WHERE key = (SELECT ak.id FROM attribute_keys ak WHERE ak.label = '" + attribute + "')"
          + " AND boolean_value = " + value + " "
      );
    }

    for(Map.Entry<String, Double> i: getDoubleEquals().entrySet()) {
      String attribute = i.getKey();
      Double value = i.getValue();

      result.add(
        " SELECT source AS qid FROM live_attributes WHERE key = (SELECT ak.id FROM attribute_keys ak WHERE ak.label = '" + attribute + "')"
          + " AND double_value = " + value + " "
      );
    }

    for(Map.Entry<String, Timestamp> i: getTimestampEquals().entrySet()) {
      String attribute = i.getKey();
      Timestamp value = i.getValue();

      result.add(
        " SELECT source AS qid FROM live_attributes WHERE key = (SELECT ak.id FROM attribute_keys ak WHERE ak.label = '" + attribute + "')"
          + " AND datetime_value = " + value + " "
      );
    }

    for(Map.Entry<String, Boolean> i: getExists().entrySet()) {
      String attribute = i.getKey();
      Boolean value    = i.getValue();

      if (value) {
        result.add(
          " SELECT source AS qid FROM live_attributes WHERE key = (SELECT ak.id FROM attribute_keys ak WHERE ak.label = '" + attribute + "')"
        );
      }
    }

    for(Map.Entry<String, ConditionMap> i: getRelationArrayConditions().entrySet()) {
      String conditionName = i.getKey();
      ConditionMap condition = i.getValue();
      if(condition.containsKey("$relIn") || condition.containsKey("$relOut")) {
        String clause = "SELECT " + (condition.containsKey("$relOut")? "source" : "target")
          + " AS qid FROM live_relations WHERE KEY = ANY ((SELECT array("
          + "SELECT rk.id FROM relation_keys rk WHERE "
          + "FALSE ";

        if(condition.values().size() != 1) {
          throw new WeaverError(-1, "A condition can only have one entry");
        }
        for (Object j: condition.values()) {
          for(String allowedRelation: (Collection<String>) j) {
            clause += " OR rk.label = '"  + allowedRelation + "' ";
          }
        }

        clause += "))::integer[])";
        result.add(clause);
      }
    }

    for(Map.Entry<String, ConditionMap> i: getRelationConditions().entrySet()) {
      String conditionName = i.getKey();
      ConditionMap condition = i.getValue();
      if(condition.containsKey("$relIn") || condition.containsKey("$relOut")) {
        String clause = "SELECT " + (condition.containsKey("$relOut")? "source" : "target")
          + " AS qid FROM live_relations WHERE ";
        if ("*".equals(conditionName))  {
          clause += "TRUE";
        } else {
          clause += "key = (SELECT rk.id FROM relation_keys rk WHERE rk.label = '" + conditionName + "')";
        }

        for(Map.Entry<String, Object> mapEntry: condition.entrySet()) {
          boolean isRelInCondition = "$relIn".equals(mapEntry.getKey());
          boolean isRelOutCondition =  "$relOut".equals(mapEntry.getKey());

          if (!isRelInCondition && !isRelOutCondition)
            continue;

          if (mapEntry.getValue() instanceof WeaverQuery) {
            clause += " AND " + (isRelInCondition ? "source" : "target") + " = ANY ((SELECT array(";
            clause += " SELECT tn.id FROM live_individuals tn WHERE FALSE";
            clause += " OR tn.id = ANY  ((SELECT array(";
            clause += ((WeaverQuery) mapEntry.getValue()).compileToPostgresQuery();
            clause += "))::integer[])";
            clause += "))::integer[])";
          } else {
            Collection<Object> values = (Collection<Object>) mapEntry.getValue();

            //  If it is not the wildcard selector
            final Object firstValue;
            try {
              firstValue = values.iterator().next();
            } catch (NoSuchElementException e) {
              throw new WeaverError(-1, String.format("Empty target array %s for %s", mapEntry.getKey(), conditionName));
            }

            if (!(firstValue instanceof String) || !"*".equals(firstValue)) {
              clause += " AND " + (isRelInCondition ? "source" : "target") + " = ANY ((SELECT array(";
              clause += " SELECT tn.id FROM live_individuals tn WHERE FALSE";
              // Three options: the values a strings (uids), integers (database ids), or hashMaps (nodekeys)
              if (firstValue instanceof String) {
                for (Object value : values) {
                  clause += " OR (tn.uid = '" + ((String) value) + "' AND tn.graph = 1)"; // Hard reference to the default graph here
                }
              } else if (firstValue instanceof Integer) {
                for (Object value : values) {
                  clause += " OR tn.id = " + ((Integer) value);
                }
              } else if (firstValue instanceof Map) {
                for (Object value : values) {
                  Map map = (Map) value;
                  if (null != map.get("graph"))
                    clause += " OR (tn.uid = '" + map.get("id") + "' AND tn.graph = (SELECT id FROM graphs WHERE uid = '" + map.get("graph") + "'))";
                  else
                    clause += " OR (tn.uid = '" + map.get("id") + "' AND tn.graph = (SELECT id FROM graphs WHERE uid IS NULL))";
                }
              }
              clause += "))::integer[])";
            } else {
              log.trace("Firstvalue is a string and *");
            }
          }
        }
        result.add(clause);
      }

      if(condition.containsKey("$gt") || condition.containsKey("$gte") || condition.containsKey("$lt") || condition.containsKey("$lte") || condition.containsKey("$ne")) {
        String clause = "SELECT source as qid FROM live_attributes WHERE TRUE";

        for (Map.Entry<String, Object> entry : condition.entrySet()) {
          Boolean addQuotes = false;
          String column = "";

          if (entry.getValue() instanceof Boolean) {
            column = "boolean_value";
          } else if (entry.getValue() instanceof Double) {
            column = "double_value";
          } else if (entry.getValue() instanceof String) {
            addQuotes = true;
            column = "string_value";

            // TODO: Datetime is not supported in the SDK yet, therefor all datetimes are in the database as a string_value
//            if (hasDateFormat((String)entry.getValue())) {
//              column = "datetime_value";
//            } else {
//              column = "string_value";
//            }
          }

          if (entry.getKey().equals("$gt") || entry.getKey().equals("$gte")) {
            clause += " AND key = (SELECT ak.id FROM attribute_keys ak WHERE ak.label = '" + conditionName + "') AND " + column + (entry.getKey().equals("$gt") ? " > " : " >= ") + (addQuotes ? "'" : "") + entry.getValue() + (addQuotes ? "'" : "");
          }

          if (entry.getKey().equals("$lt") || entry.getKey().equals("$lte")) {
            clause += " AND key = (SELECT ak.id FROM attribute_keys ak WHERE ak.label = '" + conditionName + "') AND " + column + (entry.getKey().equals("$lt") ? " < " : " <= ") + (addQuotes ? "'" : "") + entry.getValue() + (addQuotes ? "'" : "");
          }

          if (entry.getKey().equals("$ne")) {
            clause += " AND key = (SELECT ak.id FROM attribute_keys ak WHERE ak.label = '" + conditionName + "') AND " + column + "<>" + (addQuotes ? "'" : "") + entry.getValue() + (addQuotes ? "'" : "");
          }


        }
        result.add(clause);
      }
    }

    for(Map.Entry<String, ConditionMap> i: getContainsConditions().entrySet()) {
      ConditionMap condition = i.getValue();
      String conditionName = i.getKey();

      if(!"id".equals(conditionName)) {
        if (condition.size() != 1) {
          throw new WeaverError(-1, "Unsupported operation, the contains does not stand alone");
        }

        String clause = "SELECT source AS qid FROM live_attributes WHERE key = (SELECT ak.id FROM attribute_keys ak WHERE ak.label = '"
          + conditionName + "') AND LOWER(string_value) LIKE LOWER('%";

        String val = (String) condition.get("$contains");
        clause += val + "%')";

        result.add(clause);
      }
    }

    String idContains = getIdContainsRestriction();

    if(0 == result.size()
      || hasRestricts()
      || hasGraphRestrictions()
      || null != idContains
      )  {
      StringBuilder outerQuery = new StringBuilder("(SELECT id AS qid FROM live_individuals");

      List<String> restrictions = new ArrayList<>();

      if(hasRestricts()) {
        StringBuilder restrictBuilder = new StringBuilder();
        restrictBuilder.append("uid in (");
        restrictBuilder.append(getCommaSeparatedRestricts());
        restrictBuilder.append(")");
        restrictions.add(restrictBuilder.toString());
      }

      if(hasGraphRestrictions()) {
        StringBuilder restrictBuilder = new StringBuilder();
        restrictBuilder.append("graph = ANY((SELECT array(SELECT id FROM graphs WHERE ");
        for(int i = 0; i < _inGraph.size(); i++) {
          restrictBuilder.append("uid ");
          if(null == _inGraph.get(i)) {
            restrictBuilder.append("IS NULL");
          } else {
            restrictBuilder.append("= '");
            restrictBuilder.append(_inGraph.get(i));
            restrictBuilder.append("'");
          }

          if(i != _inGraph.size() - 1) {
            restrictBuilder.append(" OR ");
          }
        }
        restrictBuilder.append("))::integer[])");
        restrictions.add(restrictBuilder.toString());
      }

      if(null != idContains) {
        StringBuilder restrictBuilder = new StringBuilder();
        restrictBuilder.append("LOWER(uid) LIKE LOWER('%");
        restrictBuilder.append(idContains);
        restrictBuilder.append("%')");
        restrictions.add(restrictBuilder.toString());
      }

      if (restrictions.size() > 0) {
        outerQuery.append(" WHERE ");

        for (int i = 0; i < restrictions.size(); i++) {
          outerQuery.append(restrictions.get(i));
          if (i < restrictions.size() - 1) {
            outerQuery.append(" AND ");
          }
        }
      }

      outerQuery.append(")");
      result.add(outerQuery.toString());
    }

    return result;
  }

  private String getIdContainsRestriction() {
    String result = null;
    ConditionMap id = getContainsConditions().get("id");
    if(null != id) {
      if(id.containsKey("$contains")) {
        result = (String) id.get("$contains");
      }
    }
    return result;
  }

  public WeaverQuery setNoAttributes(boolean noAttributes) {
    this._noAttributes = noAttributes;
    return this;
  }

  public WeaverQuery addRecursiveCondition(RecursiveCondition r) {
    if(null == _recursiveConditions) {
       _recursiveConditions = new ArrayList<>();
    }
    this._recursiveConditions.add(r);
    return this;
  }

  public WeaverQuery addSelectOut(String[] path) {
    // Can't use arrays.asList straight because that returns an AbstractList that doesn't implement remove.
    List<String> pathList = new ArrayList<>();
    pathList.addAll(Arrays.asList(path));
    _selectOut.add(pathList);
    return this;
  }

  public WeaverQuery addInGraph(String graphName) {
    if(null == _inGraph) {
      _inGraph = new ArrayList<>();
    }
    this._inGraph.add(graphName);
    return this;
  }

  public List<String> getSelectRelations() {
    return _selectRelations;
  }

  public WeaverQuery selectRelations(String... relations) {
    this._selectRelations = new ArrayList<>();
    for(String s: relations) {
      this._selectRelations.add(s);
    }
    return this;
  }

  public List<String> getGraphRestrictions() {
    return _inGraph;
  }

  public boolean hasGraphRestrictions() {
    return null != _inGraph;
  }

  public String getCommaSeparatedInGraphs() {
    String restricts = "";
    for(String r : _inGraph){
      if(null != r)
        restricts += "'" + r + "',";
      else
        restricts += "NULL,";
    }

    return restricts.substring(0, restricts.length() - 1);
  }

  public WeaverQuery addAlwaysLoadRelation(String type) {
    _alwaysLoadRelations.add(type);
    return this;
  }

  public WeaverQuery count() {
    _count = true;
    return this;
  }

  public void setDatabaseIdsOnly() {
    databaseIdsOnly = true;
  }

  public boolean isDatabaseIdsOnly() {
    return databaseIdsOnly;
  }

  public WeaverQuery countPerGraph() {
    _countPerGraph = true;
    return this;
  }
  private boolean hasDateFormat(String date) {
    return date.matches("(\\d{4})-(\\d{2})-(\\d{2}) (\\d{2}):(\\d{2}):(\\d{2})");
  }

  public WeaverQuery hasRelationOut(String relationKey, Collection<WeaverNode> targets) {
    ConditionMap map = new ConditionMap();
    List<Map<String, String>> values = new ArrayList<>();
    for(WeaverNode target: targets) {
      // WeaverQuery expects a map here
      Map<String, String> nodeAsMap = new HashMap<>();

      if(target.getGraph() != null)
        nodeAsMap.put("graph", target.getGraph());

      nodeAsMap.put("id", target.getNodeId());

      values.add(nodeAsMap);
    }
    map.put("$relOut", values);
    this.addCondition(relationKey, map);
    return this;
  }

  public WeaverQuery hasRelationOut(String relationKey, String... targetId) {
    ConditionMap map = new ConditionMap();
    List<String> values = new ArrayList<>();
    for(String target: targetId) {
      values.add(target);
    }
    map.put("$relOut", values);
    this.addCondition(relationKey, map);
    return this;
  }

  public WeaverQuery select(String... attributeKeys) {
    this._select = Arrays.asList(attributeKeys);
    return this;
  }
}

