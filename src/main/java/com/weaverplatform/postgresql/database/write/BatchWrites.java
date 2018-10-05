package com.weaverplatform.postgresql.database.write;

import com.google.gson.Gson;
import com.weaverplatform.protocol.WeaverError;
import com.weaverplatform.protocol.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author Mohamad Alamili
 */
public class BatchWrites extends LinkedHashMap<WriteStatement, List<WriteStatement>> {

  private static final Logger log = LoggerFactory.getLogger(BatchWrites.class);

  private List<WriteOperation> writeOperations;
  private Set<String> creators, attributeKeys, relationKeys, graphs;

  // Static instances for keys to get preparedStatement
  public static final WriteStatement
    CREATE_USER                 = new CreateUserStatement(),
    CREATE_NODE                 = new CreateNodeStatement(),
    CREATE_ATTRIBUTE            = new CreateAttributeStatement(),
    CREATE_ATTRIBUTE_KEY        = new CreateAttributeKeyStatement(),
    CREATE_RELATION             = new CreateRelationStatement(),
    CREATE_RELATION_KEY         = new CreateRelationKeyStatement(),
    REPLACE_ATTRIBUTE           = new ReplaceAttributeStatement(),
    REPLACE_TRAVERSAL_ATTRIBUTE = new ReplaceTraversalAttributeStatement(),
    REPLACE_RELATION            = new ReplaceRelationStatement(),
    REPLACE_TRAVERSAL_RELATION  = new ReplaceTraversalRelationStatement(),
    REMOVE_NODE                 = new RemoveNodeStatement(),
    REMOVE_NODE_CASCADE         = new RemoveNodeCascadeStatement(),
    CREATE_GRAPH                = new CreateGraphStatement(),
    REMOVE_NODE_UNRECOVERABLE   = new RemoveNodeUnrecoverableStatement(),
    TRUNCATE_GRAPH              = new TruncateGraphStatement();



  public BatchWrites(List<WriteOperation> writeOperations) {
    this.writeOperations = writeOperations;
    this.creators        = new HashSet<>();
    this.attributeKeys   = new HashSet<>();
    this.relationKeys    = new HashSet<>();
    this.graphs          = new HashSet<>();

    // This is the order of the batch
    put(CREATE_USER,                 new ArrayList<>());
    put(CREATE_RELATION_KEY,         new ArrayList<>());
    put(CREATE_ATTRIBUTE_KEY,        new ArrayList<>());
    put(CREATE_GRAPH,                new ArrayList<>());
    put(CREATE_NODE,                 new ArrayList<>());
    put(CREATE_RELATION,             new ArrayList<>());
    put(CREATE_ATTRIBUTE,            new ArrayList<>());
    put(REPLACE_RELATION,            new ArrayList<>());
    put(REPLACE_ATTRIBUTE,           new ArrayList<>());
    put(REMOVE_NODE,                 new ArrayList<>());
    put(REMOVE_NODE_CASCADE,         new ArrayList<>());
    put(REMOVE_NODE_UNRECOVERABLE,   new ArrayList<>());
    put(REPLACE_TRAVERSAL_ATTRIBUTE, new ArrayList<>());
    put(REPLACE_TRAVERSAL_RELATION,  new ArrayList<>());
    put(TRUNCATE_GRAPH,              new ArrayList<>());

    prepareBatch();
  }

  private void prepareBatch() {

    // Loop through operations
    for (WriteOperation operation : writeOperations) {

      if(log.isTraceEnabled()) {
        Gson gson = new Gson();
        log.trace("preparing batch write operations");
        log.trace(gson.toJson(operation));
      }

      // In any case make the creator
      creators.add(operation.getUser());

      graphs.add(operation.getGraph());

      switch (operation.getAction()){
        case CREATE_NODE:
          get(CREATE_NODE).add(new CreateNodeStatement(operation));
          break;

        case CREATE_RELATION:
          get(CREATE_NODE).add(new CreateNodeStatement(operation));

          CreateRelationOperation opRel = (CreateRelationOperation) operation;
          relationKeys.add(opRel.getKey());
          get(CREATE_RELATION).add(new CreateRelationStatement(opRel));

          if (opRel.isReplacing()){
            get(CREATE_NODE).add(new CreateNodeStatement(operation, opRel.getReplaceId(), opRel.getReplaceGraph()));
            graphs.add(opRel.getReplaceGraph());

            if(opRel.getTraverseReplaces())
              get(REPLACE_TRAVERSAL_RELATION).add(new ReplaceTraversalRelationStatement(opRel));
            else
              get(REPLACE_RELATION).add(new ReplaceRelationStatement(opRel));
          }
          break;

        case CREATE_ATTRIBUTE:
          get(CREATE_NODE).add(new CreateNodeStatement(operation));

          CreateAttributeOperation opAttr = (CreateAttributeOperation) operation;
          if("id".equals(opAttr.getKey())) {
            throw new WeaverError(-1, "Cannot set attribute with key 'id'");
          }
          attributeKeys.add(opAttr.getKey());
          get(CREATE_ATTRIBUTE).add(new CreateAttributeStatement(opAttr));

          if (opAttr.isReplacing()){
            get(CREATE_NODE).add(new CreateNodeStatement(operation, opAttr.getReplaceId(), opAttr.getReplaceGraph()));
            graphs.add(opAttr.getReplaceGraph());

            if(opAttr.getTraverseReplaces())
              get(REPLACE_TRAVERSAL_ATTRIBUTE).add(new ReplaceTraversalAttributeStatement(opAttr));
            else
              get(REPLACE_ATTRIBUTE).add(new ReplaceAttributeStatement(opAttr));
          }
          break;

        case REMOVE_NODE:
        case REMOVE_RELATION:
        case REMOVE_ATTRIBUTE:
          RemoveNodeOperation opRemNode = (RemoveNodeOperation) operation;
          get(CREATE_NODE).add(new CreateNodeStatement(opRemNode, opRemNode.getRemoveId(), opRemNode.getRemoveGraph()));
          graphs.add(opRemNode.getRemoveGraph());
          if(opRemNode.isCascade()) {
            get(REMOVE_NODE_CASCADE).add(new RemoveNodeCascadeStatement(opRemNode));
          } else {
            get(REMOVE_NODE).add(new RemoveNodeStatement(opRemNode));
          }
          break;
        case TRUNCATE_GRAPH:
          TruncateGraphOperation op = (TruncateGraphOperation) operation;
          get(TRUNCATE_GRAPH).add(new TruncateGraphStatement(op));
          break;
        case REMOVE_NODE_UNRECOVERABLE:
          RemoveNodeUnrecoverableOperation opRemNodeUnrecoverable = (RemoveNodeUnrecoverableOperation) operation;
          get(REMOVE_NODE_UNRECOVERABLE).add(new RemoveNodeUnrecoverableStatement(opRemNodeUnrecoverable));
          break;

      }
    }

    // Make statements from creators and keys
    for (String creator : creators){
      get(CREATE_USER).add(new CreateUserStatement(creator));
    }
    for (String attributeKey : attributeKeys){
      get(CREATE_ATTRIBUTE_KEY).add(new CreateAttributeKeyStatement(attributeKey));
    }
    for (String relationKey : relationKeys){
      get(CREATE_RELATION_KEY).add(new CreateRelationKeyStatement(relationKey));
    }
    for (String graph: graphs) {
      if(graph != null)
        get(CREATE_GRAPH).add(new CreateGraphStatement(graph));
    }
  }
}
