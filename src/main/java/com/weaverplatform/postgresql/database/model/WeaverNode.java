package com.weaverplatform.postgresql.database.model;

import java.util.*;

/**
 * @author Mohamad Alamili
 */
public class WeaverNode {

  private String nodeId, creator, graph;
  private Date created;

  private WeaverNode removedBy;

  private Map<String, List<WeaverAttribute>>  attributes;
  private Map<String, List<WeaverRelation>>   relations;
  private Map<String, List<WeaverRelationIn>> relationsIn;

  private WeaverNode relationSource;
  private WeaverNode relationTarget;
  private String     relationKey;

  private transient int databaseId;

  public WeaverNode() {
    this.attributes = new HashMap<>();
    this.relations  = new HashMap<>();
  }

  public WeaverNode(String nodeId) {
    this();
    this.nodeId = nodeId;
  }

  public WeaverNode(String nodeId, String creator, Date created) {
    this(nodeId);
    this.creator = creator;
    this.created = created;
  }

  public boolean identityEquals(WeaverNode other) {
    return (other != null
      && other.getNodeId().equals(getNodeId())
      && ((getGraph() == null && other.getGraph() == null)
           || (getGraph() != null && getGraph().equals(other.getGraph())))
    );
  }

  public String getRelationKey() {
    return relationKey;
  }

  public void setRelationKey(String relationKey) {
    this.relationKey = relationKey;
  }

  public WeaverNode getRelationSource() {
    return relationSource;
  }

  public void setRelationSource(WeaverNode relationSource) {
    this.relationSource = relationSource;
  }

  public WeaverNode getRelationTarget() {
    return relationTarget;
  }

  public void setRelationTarget(WeaverNode relationTarget) {
    this.relationTarget = relationTarget;
  }

  public String getGraph() {
    return graph;
  }

  public void setGraph(String graph) {
    this.graph = graph;
  }

  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public WeaverNode getRemovedBy() {
    return removedBy;
  }

  public void setRemovedBy(WeaverNode removedBy) {
    this.removedBy = removedBy;
  }

  public Map<String, List<WeaverAttribute>> getAttributes() {
    return attributes;
  }

  public Map<String, List<WeaverRelationIn>> getRelationsIn() {
    return relationsIn;
  }

  public Map<String, List<WeaverRelation>> getRelations() {
    return relations;
  }

  public void setAttributes(Map<String, List<WeaverAttribute>> attributes) {
    this.attributes = attributes;
  }

  public void setRelations(Map<String, List<WeaverRelation>> relations) {
    this.relations = relations;
  }

  public void addRelationIn(WeaverRelationIn relation){
    if(relationsIn == null) {
      relationsIn = new HashMap<>();
    }

    if(!relationsIn.containsKey(relation.getKey())){
      relationsIn.put(relation.getKey(), new ArrayList<>());
    }

    relationsIn.get(relation.getKey()).add(relation);
  }
  public void addRelation(WeaverRelation relation){
    if(!relations.containsKey(relation.getKey())){
      relations.put(relation.getKey(), new ArrayList<>());
    }

    relations.get(relation.getKey()).add(relation);
  }

  public void addAttribute(WeaverAttribute attribute){
    if(!attributes.containsKey(attribute.getKey())){
      attributes.put(attribute.getKey(), new ArrayList<>());
    }

    attributes.get(attribute.getKey()).add(attribute);
  }

  public int getDatabaseId() {
    return databaseId;
  }

  public void setDatabaseId(int databaseId) {
    this.databaseId = databaseId;
  }
}
