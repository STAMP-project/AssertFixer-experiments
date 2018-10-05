-- Key was previously there but removed for the delete node functionality which enters multiple rows under the same
-- node. Indexing is still nice to have however.
CREATE INDEX removed_nodes_node_index ON removed_nodes (node);

-- Fixes live views with additional constraints.

CREATE OR REPLACE VIEW live_individuals AS
  SELECT * FROM nodes n
  WHERE
    NOT EXISTS (SELECT 1 FROM attributes WHERE node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM relations WHERE node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM removed_nodes WHERE removed_node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM removed_nodes WHERE node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM replaced_attributes WHERE node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM replaced_relations WHERE node = n.id LIMIT 1);

CREATE OR REPLACE VIEW live_attributes AS
  SELECT * FROM attributes a
  WHERE
    NOT EXISTS (SELECT 1 FROM removed_nodes r WHERE r.removed_node = a.node LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM replaced_attributes r WHERE a.id = r.replaced LIMIT 1);

CREATE OR REPLACE VIEW live_relations AS
  SELECT * FROM relations e
  WHERE
    NOT EXISTS (SELECT 1 FROM removed_nodes r WHERE r.removed_node = e.node LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM replaced_relations r WHERE e.id = r.replaced LIMIT 1);


-- Query result views.

CREATE OR REPLACE VIEW query_result_nodes_view AS
SELECT
      nodes.id                       as "node_id",
      nodes.uid                      as "node_uid",
      nodes.created_on               as "node_created",
      (SELECT uid FROM creators WHERE id = nodes.created_by)               as "node_created_by",
      removed_by_nodes.uid           as "node_removed_by",
      CAST (NULL as text)            as "property_uid",
      CAST (NULL as timestamp)       as "property_created",
      CAST (NULL as text)            as "property_creator",
      CAST (NULL as text)            as "key",
      CAST (NULL as double precision)as "double_value",
      CAST (NULL as boolean)         as "boolean_value",
      CAST (NULL as timestamp)       as "datetime_value",
      CAST (NULL as text)            as "string_value",
      0                              as "target_id",
      CAST (NULL as text)            as "target_uid",
      timestamp '1970-01-01 00:00'   as "target_created",
      CAST (NULL as text)                          as "target_creator",
      CAST (NULL as text)                          as "replaced_by",
      CAST (NULL as text)                        as "property_removed_by"

    FROM nodes as nodes

    -- Get node removed by
    LEFT JOIN removed_nodes ON removed_node = nodes.id
    LEFT JOIN nodes removed_by_nodes ON removed_nodes.node=removed_by_nodes.id

    WHERE TRUE
      AND NOT EXISTS (SELECT 1 FROM attributes WHERE node = nodes.id LIMIT 1)
      AND NOT EXISTS (SELECT 1 FROM relations  WHERE node = nodes.id LIMIT 1)
;


CREATE OR REPLACE VIEW query_result_attributes_view AS
    SELECT
      nodes.id                                  as "node_id",
      CAST(NULL as text)                        as "node_uid",
      CAST(NULL as timestamp)                   as "node_created",
      CAST(NULL as text)                        as "node_created_by",
      CAST(NULL as text)                 as "node_removed_by",
      attr_nodes.uid                            as "property_uid",
      attr_nodes.created_on                     as "property_created",
      (SELECT uid from creators WHERE id = attr_nodes.created_by)  as "property_creator",
      (SELECT label from attribute_keys WHERE id = attributes.key) as "key",
      attributes.double_value      as "double_value",
      attributes.boolean_value     as "boolean_value",
      attributes.datetime_value    as "datetime_value",
      attributes.string_value      as "string_value",
      CAST( NULL as integer)                    as "target_id",
      CAST(NULL as text)                        as "target_uid",
      timestamp '1970-01-01 00:00'              as "target_created",
      CAST(NULL as text)                        as "target_creator",
      replaced_by_nodes.uid                     as "replaced_by",
      removed_by_nodes.uid                      as "property_removed_by"

    FROM nodes

    -- Get attributes
    JOIN attributes ON nodes.id=attributes.source

    ---- Get attribute nodes
    JOIN nodes attr_nodes ON attributes.node=attr_nodes.id

    -- Get non replaced by
    LEFT JOIN replaced_attributes ON replaced = attributes.id
    LEFT JOIN nodes replaced_by_nodes ON replaced_attributes.replaced_by=replaced_by_nodes.id

    -- Get property removed by
    LEFT JOIN removed_nodes removed_attr_nodes ON removed_attr_nodes.removed_node = attributes.node
    LEFT JOIN nodes removed_by_nodes ON removed_attr_nodes.node=removed_by_nodes.id
;

CREATE OR REPLACE VIEW query_result_relations_view AS     SELECT
      nodes.id                                as "node_id",
      CAST(NULL as text)                      as "node_uid",
      CAST(NULL as timestamp)                        as "node_created",
      CAST(NULL as text)                     as "node_created_by",
      CAST(NULL as text)              as "node_removed_by",
      relation_nodes.uid                      as "property_uid",
      relation_nodes.created_on               as "property_created",
      (SELECT c.uid FROM creators c WHERE c.id = relation_nodes.created_by)        as "property_creator",
      (SELECT k.label FROM relation_keys k WHERE k.id = relations.key)            as "key",
      CAST(NULL as double precision)          as "double_value",
      CAST(NULL as boolean)                   as "boolean_value",
      CAST(NULL as timestamp)                 as "datetime_value",
      CAST(NULL as text)                      as "string_value",
      relations.target           as "target_id",
      target_nodes.uid       as "target_uid",
      target_nodes.created_on   as "target_created",
      (SELECT c.uid FROM creators c WHERE c.id = target_nodes.created_by)as "target_creator",
      replaced_by_nodes.uid                   as "replaced_by",
      removed_by_nodes.uid                    as "property_removed_by"


    FROM nodes

    -- Get relations
    JOIN relations ON nodes.id=relations.source
    JOIN nodes target_nodes ON target_nodes.id = relations.target

    ---- Get relation nodes
    JOIN nodes relation_nodes ON relations.node=relation_nodes.id

    -- Get non replaced by
    LEFT JOIN replaced_relations ON replaced = relations.id
    LEFT JOIN nodes replaced_by_nodes ON replaced_relations.replaced_by=replaced_by_nodes.id

    -- Get property removed by
    LEFT JOIN removed_nodes ON removed_node = relations.node
    LEFT JOIN nodes removed_by_nodes ON removed_nodes.node=removed_by_nodes.id

    -- Get node removed by
    LEFT JOIN removed_nodes removed_node_nodes ON removed_node_nodes.removed_node = nodes.id
    LEFT JOIN nodes removed_by_node_nodes ON removed_node_nodes.node=removed_by_node_nodes.id;

CREATE OR REPLACE VIEW query_result AS
  SELECT * FROM query_result_nodes_view
  UNION ALL
  SELECT * FROM query_result_attributes_view
  UNION ALL
  SELECT * FROM query_result_relations_view;

-- Live query result views
CREATE OR REPLACE VIEW live_query_result_nodes_view AS
SELECT
      nodes.id                       as "node_id",
      nodes.uid                      as "node_uid",
      nodes.created_on               as "node_created",
      (SELECT uid FROM creators WHERE id = nodes.created_by)               as "node_created_by",
      CAST (NULL as text)            as "node_removed_by",
      CAST (NULL as text)            as "property_uid",
      CAST (NULL as timestamp)       as "property_created",
      CAST (NULL as text)            as "property_creator",
      CAST (NULL as text)            as "key",
      CAST (NULL as double precision)as "double_value",
      CAST (NULL as boolean)         as "boolean_value",
      CAST (NULL as timestamp)       as "datetime_value",
      CAST (NULL as text)            as "string_value",
      0                              as "target_id",
      CAST (NULL as text)            as "target_uid",
      timestamp '1970-01-01 00:00'   as "target_created",
      CAST (NULL as text)            as "target_creator",
      CAST (NULL as text)            as "replaced_by",
      CAST (NULL as text)            as "property_removed_by"

    FROM live_individuals nodes
;


CREATE OR REPLACE VIEW live_query_result_attributes_view AS
    SELECT
      nodes.id                                  as "node_id",
      CAST(NULL as text)                        as "node_uid",
      CAST(NULL as timestamp)                   as "node_created",
      CAST(NULL as text)                        as "node_created_by",
      CAST (NULL as text)            as "node_removed_by",
      attr_nodes.uid                            as "property_uid",
      attr_nodes.created_on                     as "property_created",
      (SELECT uid from creators WHERE id = attr_nodes.created_by)  as "property_creator",
      (SELECT label from attribute_keys WHERE id = attributes.key) as "key",
      attributes.double_value      as "double_value",
      attributes.boolean_value     as "boolean_value",
      attributes.datetime_value    as "datetime_value",
      attributes.string_value      as "string_value",
      CAST( NULL as integer)                    as "target_id",
      CAST(NULL as text)                        as "target_uid",
      timestamp '1970-01-01 00:00'              as "target_created",
      CAST(NULL as text)                        as "target_creator",
      CAST (NULL as text)            as "replaced_by",
      CAST (NULL as text)            as "property_removed_by"
    FROM live_attributes attributes

    -- Get attributes
    JOIN nodes ON nodes.id=attributes.source

    ---- Get attribute nodes
    JOIN nodes attr_nodes ON attributes.node=attr_nodes.id
;

CREATE OR REPLACE VIEW live_query_result_relations_view AS     SELECT
      nodes.id                                as "node_id",
      CAST(NULL as text)                      as "node_uid",
      CAST(NULL as timestamp)                        as "node_created",
      CAST(NULL as text)                     as "node_created_by",
      CAST (NULL as text)            as "node_removed_by",
      relation_nodes.uid                      as "property_uid",
      relation_nodes.created_on               as "property_created",
      (SELECT c.uid FROM creators c WHERE c.id = relation_nodes.created_by)        as "property_creator",
      (SELECT k.label FROM relation_keys k WHERE k.id = relations.key)            as "key",
      CAST(NULL as double precision)          as "double_value",
      CAST(NULL as boolean)                   as "boolean_value",
      CAST(NULL as timestamp)                 as "datetime_value",
      CAST(NULL as text)                      as "string_value",
      relations.target           as "target_id",
      target_nodes.uid       as "target_uid",
      target_nodes.created_on   as "target_created",
      (SELECT c.uid FROM creators c WHERE c.id = target_nodes.created_by)as "target_creator",
      CAST (NULL as text)            as "replaced_by",
      CAST (NULL as text)            as "property_removed_by"
    -- Get relations
    FROM live_relations relations
    JOIN nodes ON nodes.id=relations.source
    JOIN nodes target_nodes ON target_nodes.id = relations.target

    ---- Get relation nodes
    JOIN nodes relation_nodes ON relations.node=relation_nodes.id;

CREATE OR REPLACE VIEW live_query_result AS
  SELECT * FROM live_query_result_nodes_view
  UNION ALL
  SELECT * FROM live_query_result_attributes_view
  UNION ALL
  SELECT * FROM live_query_result_relations_view;
