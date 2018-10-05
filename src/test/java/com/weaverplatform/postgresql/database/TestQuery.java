package com.weaverplatform.postgresql.database;

import com.weaverplatform.postgresql.util.Resource;

/**
 * Serves as pre-loading the queries to not read each time
 *
 * Test queries specific
 *
 * # TODO: Make internal map cache instead
 * @author gvdent
 */
public class TestQuery {

  public static final String
    TEST_CREATE_NODE, TEST_REMOVED_NODE, TEST_LIST_DATABASES,
    TEST_NO_DATABASE, TEST_LIST_ATTRIBUTE, TEST_LIST_RELATION;

  private static String read(String fileName) {
    return Resource.get("queries/" + fileName);
  }

  static {
    TEST_CREATE_NODE     = read("test_create_node.sql");
    TEST_REMOVED_NODE    = read("test_removed_node.sql");
    TEST_NO_DATABASE     = read("test_no_database.sql");
    TEST_LIST_DATABASES  = read("test_list_database.sql");
    TEST_LIST_ATTRIBUTE  = read("test_list_attribute.sql");
    TEST_LIST_RELATION   = read("test_list_relation.sql");
  }

  protected TestQuery(){}
}
