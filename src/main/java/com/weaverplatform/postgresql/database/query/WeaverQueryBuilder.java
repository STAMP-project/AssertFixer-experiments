package com.weaverplatform.postgresql.database.query;

import com.weaverplatform.postgresql.database.query.model.ConditionMap;
import com.weaverplatform.postgresql.database.query.model.WeaverQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author Mohamad Alamili
 */
public class WeaverQueryBuilder {

  static Logger logger = LoggerFactory.getLogger(WeaverQueryBuilder.class);
  private List<List<String>>        _selectOut;
  private List<WeaverQuery>         _orQueries;
  private Set<String>               _restrict;
  private Map<String, Object>       _equals;
  private Map<String, Object>       _notEquals;
  private Map<String, Object>       _greaterThan;
  private Map<String, Object>       _greaterThanOrEqual;
  private Map<String, Object>       _lessThan;
  private Map<String, Object>       _lessThanOrEqual;
  private Map<String, ConditionMap> _conditions;
  private List<String>              _include;
  private List<String>              _select;
  private List<String>              _order;
  private boolean                   _noRelations = false;
  private boolean                   _hollow = false;
  private boolean                   _ascending = true;
  private boolean                   _count = false;
  private boolean                   _countPerGraph = false;
  private int                       _limit = WeaverQuery.DEFAULT_LIMIT;
  private int                       _skip;

  public WeaverQueryBuilder() {
    _orQueries          = new ArrayList<>();
    _restrict           = new HashSet<>();
    _equals             = new HashMap<>();
    _notEquals          = new HashMap<>();
    _greaterThan        = new HashMap<>();
    _greaterThanOrEqual = new HashMap<>();
    _lessThan           = new HashMap<>();
    _lessThanOrEqual    = new HashMap<>();
    _conditions         = new HashMap<>();
    _include            = new ArrayList<>();
    _select             = new ArrayList<>();
    _order              = new ArrayList<>();
    _selectOut          = new ArrayList<>();
  }

  public WeaverQueryBuilder limit(int limit) {
    _limit = limit;
    return this;
  }

  public WeaverQuery build(){
    return new WeaverQuery(_orQueries, _restrict, _equals, _conditions, _include, _select, _order, _noRelations, _hollow, _ascending, _count, _countPerGraph, _limit, _skip, _selectOut, _notEquals, _greaterThan, _greaterThanOrEqual, _lessThan, _lessThanOrEqual);
  }

  public WeaverQueryBuilder skip(int skip) {
    _skip = skip;
    return this;
  }

  public WeaverQueryBuilder restrict(String... restricts) {
    Collections.addAll(_restrict, restricts);
    return this;
  }

  public WeaverQueryBuilder count() {
    _count = true;
    return this;
  }

  public WeaverQueryBuilder countPerGraph() {
    _countPerGraph = true;
    return this;
  }

  public WeaverQueryBuilder equalsTo(String attribute, Object value) {
    _equals.put(attribute, value);

    // We cant have conditions on this key if equals is set
    _conditions.remove(attribute);
    return this;
  }

  private WeaverQueryBuilder addCondition(String key, String condition, Object value) {
    if (!_conditions.containsKey(key)){
      _conditions.put(key, new ConditionMap());
    }

    _conditions.get(key).put(condition, value);
    return this;
  }

  public WeaverQueryBuilder notEqualTo(String attributeKey, Object value) {
    return addCondition(attributeKey, "$ne",  value);
  }

  public WeaverQueryBuilder lessThan(String attributeKey, Object value) {
    return addCondition(attributeKey, "$lt",  value);
  }

  public WeaverQueryBuilder lessThanOrEqualTo(String attributeKey, Object value) {
    return addCondition(attributeKey, "$lte",  value);
  }

  public WeaverQueryBuilder greaterThan(String attributeKey, Object value) {
    return addCondition(attributeKey, "$gt",  value);
  }

  public WeaverQueryBuilder greaterThanOrEqualTo(String attributeKey, Object value) {
    return addCondition(attributeKey, "$gte",  value);
  }

  public WeaverQueryBuilder containedIn(String attributeKey, Object value) {
    return addCondition(attributeKey, "$in",  value);
  }

  public WeaverQueryBuilder contains(String attributeKey, Object value) {
    return addCondition(attributeKey, "$contains",  value);
  }

  public WeaverQueryBuilder notContainedIn(String attributeKey, Object value) {
    return addCondition(attributeKey, "$nin",  value);
  }

  public WeaverQueryBuilder hasRelationOut(String relation, String target) {
    return addCondition(relation, "$relOut",  target);
  }

  public WeaverQueryBuilder hasRelationOut(String relation) {
    return addCondition(relation, "$relOut",  "*");
  }

  public WeaverQueryBuilder hasNoRelationOut(String relation, String target) {
    return addCondition(relation, "$noRelOut",  target);
  }

  public WeaverQueryBuilder hasNoRelationOut(String relation) {
    return addCondition(relation, "$noRelOut",  "*");
  }

  public WeaverQueryBuilder hasRelationIn(String relation, String target) {
    return addCondition(relation, "$relIn",  target);
  }

  public WeaverQueryBuilder hasRelationIn(String relation) {
    return addCondition(relation, "$relIn",  "*");
  }

  public WeaverQueryBuilder hasNoRelationIn(String relation, String target) {
    return addCondition(relation, "$noRelIn",  target);
  }

  public WeaverQueryBuilder hasNoRelationIn(String relation) {
    return addCondition(relation, "$noRelIn",  "*");
  }
}
