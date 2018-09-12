package com.weaverplatform.postgresql.database;

import com.weaverplatform.postgresql.util.Resource;

/**
 * Serves as pre-loading the queries to not read each time
 * # TODO: Make internal map cache instead
 * @author Mohamad Alamili
 */
public class Query {

  public static final String
    WIPE, RELATION_KEYS, CREATE_NODE, CREATE_USER,
    REMOVE_NODE, REMOVE_NODE_UNRECOVERABLE, CREATE_RELATION, CREATE_RELATION_KEY,
    CREATE_ATTRIBUTE, CREATE_ATTRIBUTE_KEY, REPLACE_ATTRIBUTE,
    REPLACE_RELATION, CREATE_DATABASE, DELETE_DATABASE,
    NODES,
    DUMP_NODES, DUMP_ATTRIBUTES, DUMP_RELATIONS,
    DUMP_NODES_IN_GRAPH,
    LIST_DATABASES, REMOVE_NODE_CASCADE,
    CREATE_DATABASE_TEMPLATED, CLOSE_CONNECTIONS,
    CLONE_NODE,
    REPLACE_TRAVERSAL_ATTRIBUTE, REPLACE_TRAVERSAL_RELATION,
    ALWAYS_LOAD_RELATIONS,
    FIND_EXISTING_NODES,
    CREATE_GRAPH,
    CLEAN_UP_DATABASE,
    TRUNCATE_GRAPH,
    REDIRECT_GRAPH;

  private static String read(String fileName) {
    return Resource.get("queries/" + fileName);
  }

  static {
    WIPE                        = read("wipe.sql");
    RELATION_KEYS               = read("relation_keys.sql");
    CREATE_NODE                 = read("create_node.sql");
    CREATE_USER                 = read("create_user.sql");
    REMOVE_NODE                 = read("remove_node.sql");
    REMOVE_NODE_CASCADE         = read("remove_node_cascade.sql");
    REMOVE_NODE_UNRECOVERABLE   = read("remove_node_unrecoverable.sql");
    CREATE_RELATION             = read("create_relation.sql");
    CREATE_RELATION_KEY         = read("create_relation_key.sql");
    CREATE_ATTRIBUTE            = read("create_attribute.sql");
    CREATE_ATTRIBUTE_KEY        = read("create_attribute_key.sql");
    REPLACE_ATTRIBUTE           = read("replace_attribute.sql");
    REPLACE_RELATION            = read("replace_relation.sql");
    CREATE_DATABASE             = read("create_database.sql");
    DELETE_DATABASE             = read("delete_database.sql");
    LIST_DATABASES              = read("list_databases.sql");
    NODES                       = read("nodes.sql");
    DUMP_NODES                  = read("dump_nodes.sql");
    DUMP_ATTRIBUTES             = read("dump_attributes.sql");
    DUMP_RELATIONS              = read("dump_relations.sql");
    DUMP_NODES_IN_GRAPH         = read("dump_nodes_in_graph.sql");
    CREATE_DATABASE_TEMPLATED   = read("create_database_templated.sql");
    CLOSE_CONNECTIONS           = read("close_connections.sql");
    CLONE_NODE                  = read("clone_node.sql");
    REPLACE_TRAVERSAL_ATTRIBUTE = read("replace_traversal_attribute.sql");
    REPLACE_TRAVERSAL_RELATION  = read("replace_traversal_relation.sql");
    ALWAYS_LOAD_RELATIONS       = read("always_load_relations.sql");
    CLEAN_UP_DATABASE           = read( "clean_up_database.sql");
    FIND_EXISTING_NODES         = read("find_existing_nodes.sql");
    CREATE_GRAPH                = read("create_graph.sql");
    TRUNCATE_GRAPH              = read("truncate_graph.sql");
    REDIRECT_GRAPH              = read("redirect_graph.sql");
  }

  protected Query(){}
}
