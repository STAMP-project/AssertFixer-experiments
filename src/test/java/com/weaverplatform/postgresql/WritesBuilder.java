package com.weaverplatform.postgresql;

import com.weaverplatform.protocol.model.*;

import java.util.*;

/**
 * Created by gijs on 28/11/2017.
 */
class WritesBuilder {
  private final List<WriteOperation> writes;
  private String user = "default";
  private String graph;
  private Map<String, WriteOperation> nodes = new HashMap<>();
  private CreateNodeOperation lastNode;
  private String pendingRelation;
  private String pendingRelationGraph;
  private String pendingRelationId;

  WritesBuilder() {
    this.writes = new ArrayList<WriteOperation>();
  }

  private WritesBuilder addNode(CreateNodeOperation op) {
    op.setGraph(graph);
    nodes.put(op.getId(), op);
    writes.add(op);
    if(null != pendingRelation) {
      addRelation(pendingRelationId != null? pendingRelationId : UUID.randomUUID().toString(), pendingRelation, op.getId(), pendingRelationGraph);
      pendingRelation = null;
      pendingRelationGraph = null;
      pendingRelationId = null;
    }
    lastNode = op;
    return this;
  }

  public WritesBuilder addNode() {
    return addNode(new CreateNodeOperation(user, UUID.randomUUID().toString()));
  }

  public WritesBuilder addNode(String id) {
    return addNode(new CreateNodeOperation(user, id));
  }

  public WritesBuilder removeNode(String id) {
    RemoveNodeOperation rn = new RemoveNodeOperation(user, id, UUID.randomUUID().toString());
    rn.setGraph(graph);
    writes.add(rn);
    return this;
  }

  public WritesBuilder withUser(String user) {
    this.user = user;
    return this;
  }

  public WritesBuilder withGraph(String graph) {
    this.graph = graph;
    return this;
  }

  public WritesBuilder addRelation(String key, String id) {
    if(null == pendingRelation) {
      pendingRelation = key;
      pendingRelationGraph = graph;
      pendingRelationId = id;
    } else {
      throw new RuntimeException("Unable to create multiple relations with a to be defined target");
    }
    return this;
  }

  public WritesBuilder addRelation(String key) {
    return addRelation(key, null);
  }

  public WritesBuilder addRelationBetweenNodes(String sourceNodeId, String key, String targetNodeId) {
    return addRelationBetweenNodes(sourceNodeId, key, targetNodeId, UUID.randomUUID().toString());
  }

  public WritesBuilder addRelationBetweenNodes(String sourceNodeId, String key, String targetNodeId, String relationId) {
    WriteOperation target = nodes.get(targetNodeId);
    WriteOperation source = nodes.get(sourceNodeId);
    CreateRelationOperation op = new CreateRelationOperation(user, relationId, source.getId(), key, target.getId());
    nodes.put(relationId, op);
    op.setTargetGraph(target.getGraph());
    op.setSourceGraph(source.getGraph());
    op.setGraph(graph);
    writes.add(op);
    return this;
  }

  public WritesBuilder addRelation(String relationId, String key, String targetNodeId) {
    return addRelation(relationId, key, targetNodeId, graph);
  }

  public WritesBuilder addRelation(String relationId, String key, String targetNodeId, String graph) {
    WriteOperation target = nodes.get(targetNodeId);
    CreateRelationOperation op = new CreateRelationOperation(user, relationId, lastNode.getId(), key, target.getId());
    nodes.put(relationId, op);
    op.setTargetGraph(target.getGraph());
    op.setSourceGraph(lastNode.getGraph());
    op.setGraph(graph);
    writes.add(op);
    return this;
  }

  public List<WriteOperation> getWrites() {
    if(null != pendingRelation) {
      throw new RuntimeException("A relation still needs a target");
    }
    return writes;
  }

  public WritesBuilder setAttribute(String id, String key, String value, AttributeDataType datatype) {
    CreateAttributeOperation op = new CreateAttributeOperation(user, id, lastNode.getId(), key, value, datatype);
    op.setSourceGraph(lastNode.getGraph());
    op.setGraph(graph);
    writes.add(op);
    return this;
  }

  public WritesBuilder setAttribute(String id, String key, Boolean value, AttributeDataType datatype) {
    CreateAttributeOperation op = new CreateAttributeOperation(user, id, lastNode.getId(), key, value, datatype);
    op.setSourceGraph(lastNode.getGraph());
    op.setGraph(graph);
    writes.add(op);
    return this;
  }

  public WritesBuilder setAttribute(String id, String key, Double value, AttributeDataType datatype) {
    CreateAttributeOperation op = new CreateAttributeOperation(user, id, lastNode.getId(), key, value, datatype);
    op.setSourceGraph(lastNode.getGraph());
    op.setGraph(graph);
    writes.add(op);
    return this;
  }

  public WritesBuilder setAttribute(String id, String key, String value) {
    return setAttribute(id, key, value, AttributeDataType.STRING);
  }

  public WritesBuilder setTypedAttribute(String key, AttributeDataType datatype, String value) {
    return setAttribute(UUID.randomUUID().toString(), key, value, datatype);
  }

  public WritesBuilder setTypedAttribute(String key, AttributeDataType datatype, Boolean value) {
    return setAttribute(UUID.randomUUID().toString(), key, value, datatype);
  }

  public WritesBuilder setTypedAttribute(String key, AttributeDataType datatype, Double value) {
    return setAttribute(UUID.randomUUID().toString(), key, value, datatype);
  }

  public WritesBuilder setAttribute(String key, String value) {
    return setAttribute(UUID.randomUUID().toString(), key, value);
  }

  public WritesBuilder addAttributeOnRelation(String thing, String value) {
    CreateAttributeOperation op = new CreateAttributeOperation(user, UUID.randomUUID().toString(), pendingRelationId, thing, value, AttributeDataType.STRING);
    op.setSourceGraph(pendingRelationGraph);
    op.setGraph(graph);
    writes.add(op);
    return this;
  }
}
