CREATE SEQUENCE graphs_id_seq
    START WITH 2  -- Skip 1 because that will be the default
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE graphs (
    id integer DEFAULT nextval('graphs_id_seq'::regclass) NOT NULL,
    uid text
);

ALTER TABLE ONLY graphs
    ADD CONSTRAINT graphs_pkey PRIMARY KEY (id),
    ADD CONSTRAINT graphs_uid_key UNIQUE (uid);

INSERT INTO graphs (id, uid) VALUES(1, NULL);

ALTER TABLE ONLY nodes
    ADD COLUMN graph integer NOT NULL DEFAULT 1,
    ADD CONSTRAINT nodes_graph_fkey FOREIGN KEY (graph) REFERENCES graphs(id) ON UPDATE RESTRICT ON DELETE RESTRICT,
    DROP CONSTRAINT nodes_uid_key,
    ADD CONSTRAINT nodes_uid_graph_key UNIQUE (uid, graph);


-- Fixes for older views/ functions

DROP FUNCTION remove_node_unrecoverable(text);
DROP FUNCTION remove_node(text, text);
DROP FUNCTION nodeids_with_recursive_relation_out(text, text, boolean);
DROP FUNCTION nodeids_with_recursive_relation_in(text, text, boolean);
DROP FUNCTION clone_node(text, text, integer, text[]);
DROP FUNCTION getLiveAttributeForUid(text);
DROP FUNCTION getLiveRelationForUid(text);
DROP VIEW query_result;
DROP VIEW query_result_nodes_view;
DROP VIEW query_result_attributes_view;
DROP VIEW query_result_relations_view;
DROP VIEW live_query_result;
DROP VIEW live_query_result_nodes_view;
DROP VIEW live_query_result_attributes_view;
DROP VIEW live_query_result_relations_view;
DROP VIEW live_individuals;

-- Baseline

CREATE OR REPLACE VIEW live_individuals AS
  SELECT * FROM nodes n
  WHERE
    NOT EXISTS (SELECT 1 FROM attributes WHERE node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM relations WHERE node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM removed_nodes WHERE removed_node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM removed_nodes WHERE node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM replaced_attributes WHERE node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM replaced_relations WHERE node = n.id LIMIT 1);

CREATE OR REPLACE FUNCTION remove_node(remove_node_uid text, remove_node_graph text, removed_node_uid text, removed_node_graph text) RETURNS integer AS
$$
DECLARE
  current_count integer;
  previous_count integer;
BEGIN
  previous_count = 0;

  CREATE TEMP TABLE to_remove AS
    SELECT id FROM nodes
    WHERE uid=removed_node_uid
      AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM removed_node_graph)
      AND id NOT IN (SELECT removed_node FROM removed_nodes);

  current_count = count(*) FROM to_remove;

  WHILE current_count > previous_count LOOP
    previous_count = current_count;

    INSERT INTO to_remove
    SELECT node
    FROM live_attributes
    WHERE source IN (SELECT id FROM to_remove)
      AND node NOT IN (SELECT id FROM to_remove);

    INSERT INTO to_remove
    SELECT node
    FROM live_relations
    WHERE source IN (SELECT id FROM to_remove)
      AND node NOT IN (SELECT id FROM to_remove);

    INSERT INTO to_remove
    SELECT node
    FROM live_relations
    WHERE target IN (SELECT id FROM to_remove)
      AND node NOT IN (SELECT id FROM to_remove);

    current_count = count(*) FROM to_remove;
  END LOOP;


  INSERT INTO removed_nodes (node, removed_node)
    SELECT DISTINCT (
      SELECT id FROM nodes WHERE uid = remove_node_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM remove_node_graph)
      ), id
    FROM to_remove
  ;

  DROP TABLE to_remove;

  RETURN current_count;
END;
$$

LANGUAGE 'plpgsql' VOLATILE;

-- 3.0.13_1

CREATE OR REPLACE FUNCTION remove_node_unrecoverable(node_uid text, node_graph_uid text) RETURNS integer AS
$$
DECLARE
  current_count integer;
  previous_count integer;
  delete_array integer[];
BEGIN
  previous_count = 0;

  CREATE TEMP TABLE to_delete AS
    SELECT id FROM nodes
    WHERE uid=node_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM node_graph_uid);

  current_count = count(*) FROM to_delete;

  WHILE current_count > previous_count LOOP
    previous_count = current_count;

-- Attributes
    INSERT INTO to_delete
    SELECT node
      FROM attributes
     WHERE source IN (SELECT id FROM to_delete)
       AND node NOT IN (SELECT id FROM to_delete);

-- Relations
    INSERT INTO to_delete
    SELECT node
      FROM relations
     WHERE (target IN (SELECT id FROM to_delete) OR source IN (SELECT id FROM to_delete))
       AND node NOT IN (SELECT id FROM to_delete);

-- Replaced relations
    INSERT INTO to_delete
    SELECT node FROM replaced_relations
     WHERE (replaced_by IN (
           SELECT id FROM relations
            WHERE (source IN (SELECT id FROM to_delete) OR target IN (SELECT id FROM to_delete)))
        OR replaced IN (
           SELECT id FROM relations
            WHERE (source IN (SELECT id FROM to_delete) OR target IN (SELECT id FROM to_delete))))
       AND node NOT IN (SELECT id FROM to_delete);

-- Replaced attributes
    INSERT INTO to_delete
    SELECT node FROM replaced_attributes
     WHERE (replaced_by IN (
           SELECT id FROM attributes
            WHERE source IN (SELECT id FROM to_delete))
        OR replaced IN (
           SELECT id FROM attributes
            WHERE source IN (SELECT id FROM to_delete)))
      AND node NOT IN (SELECT id FROM to_delete);

-- Removed nodes
    INSERT INTO to_delete
    SELECT node
      FROM removed_nodes
     WHERE removed_node IN (SELECT id FROM to_delete)
       AND node NOT IN (SELECT id FROM to_delete);

    current_count = count(*) FROM to_delete;
  END LOOP;
  delete_array = array(SELECT id FROM to_delete);

-- Delete from removed tables first, could be deleted replaced node;;
  DELETE FROM removed_nodes
        WHERE node = ANY (delete_array)
           OR removed_node = ANY (delete_array);

-- Delete from replaced tables second
  DELETE FROM replaced_relations
        WHERE node = ANY (delete_array)
           OR replaced IN (SELECT id FROM relations
              WHERE (source = ANY (delete_array)
                 OR target = ANY (delete_array)))
           OR replaced_by IN (SELECT id FROM relations
              WHERE (source = ANY (delete_array)
                 OR target = ANY (delete_array)));

  DELETE FROM replaced_attributes
        WHERE node = ANY (delete_array)
           OR replaced IN (SELECT id FROM attributes WHERE source = ANY (delete_array))
           OR replaced_by IN (SELECT id FROM attributes WHERE source = ANY (delete_array));

-- Delete from attributes and relations third
  DELETE FROM relations WHERE node = ANY (delete_array)
                           OR source = ANY (delete_array)
                           OR target = ANY (delete_array);

  DELETE FROM attributes WHERE node = ANY (delete_array)
                            OR source = ANY (delete_array);

---- Finally delete from nodes
  DELETE FROM nodes WHERE id = ANY (delete_array);


  DROP TABLE to_delete;

  RETURN current_count;
END;
$$
LANGUAGE 'plpgsql' VOLATILE;

-- 3.0.12_1

CREATE OR REPLACE FUNCTION nodeids_with_recursive_relation_out(relation_key text, target_uid text, target_graph_uid text, include_self boolean) RETURNS integer[] AS
$$
DECLARE
  current_count integer;
  previous_count integer;
  relation_key_id integer;
  target_id integer;
  result integer[];
BEGIN
  previous_count = 0;
  target_id = id FROM live_individuals WHERE uid = target_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM target_graph_uid);
  relation_key_id = id FROM relation_keys WHERE label = relation_key;

  DROP TABLE IF EXISTS result_table;
  -- Create the table that holds the results
  CREATE TEMPORARY TABLE result_table AS SELECT target_id AS id;
  current_count = COUNT(*) FROM result_table;

  WHILE current_count > previous_count LOOP
    previous_count = current_count;

    INSERT INTO result_table
      SELECT source
      FROM live_relations
      WHERE key = relation_key_id
        AND target IN (SELECT ID FROM result_table)
        AND source NOT IN (SELECT ID FROM result_table)
     ;

     current_count = COUNT(*) FROM result_table;
  END LOOP;

  IF NOT include_self THEN
    DELETE FROM result_table WHERE id = target_id;
  END IF;


  result = array(SELECT id FROM result_table);

  return result;
 END;
$$
LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION nodeids_with_recursive_relation_in(relation_key text, source_uid text, source_graph_uid text, include_self boolean) RETURNS integer[] AS
$$
DECLARE
  current_count integer;
  previous_count integer;
  relation_key_id integer;
  source_id integer;
  result integer[];
BEGIN
  previous_count = 0;
  source_id = id FROM live_individuals WHERE uid = source_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM source_graph_uid);
  relation_key_id = id FROM relation_keys WHERE label = relation_key;

  DROP TABLE IF EXISTS result_table;

  CREATE TEMPORARY TABLE result_table AS SELECT source_id AS id;
  current_count = COUNT(*) FROM result_table;

  WHILE current_count > previous_count LOOP
    previous_count = current_count;

    INSERT INTO result_table
      SELECT target
      FROM live_relations
      WHERE key = relation_key_id
        AND source IN (SELECT ID FROM result_table)
        AND target NOT IN (SELECT ID FROM result_table)
     ;

     current_count = COUNT(*) FROM result_table;
  END LOOP;

  IF NOT include_self THEN
    DELETE FROM result_table WHERE id = source_id;
  END IF;


  result = array(SELECT id FROM result_table);

  return result;
 END;
$$

LANGUAGE 'plpgsql';


-- 3.0.11_2 clone update

CREATE OR REPLACE FUNCTION clone_node(source_node_uid text, source_node_graph text, target_node_uid text, target_node_graph text, user_id integer, relationsToTraverse text[]) RETURNS integer AS
$$
DECLARE
  traverse_ids integer[];
  previous_count integer;
  target_graph integer;
  current_count integer;
  result integer;
BEGIN
  -- Get the relation keys which determine what nodes we have to copy
  traverse_ids = ARRAY(SELECT id FROM relation_keys WHERE label = ANY(relationsToTraverse));

  target_graph = id FROM graphs WHERE uid IS NOT DISTINCT FROM target_node_graph;

  -- Initial node to clone
  CREATE TABLE nodes_to_clone AS
    SELECT n.id as old_id, target_node_uid as new_uid
    FROM nodes n
    WHERE n.uid = source_node_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM source_node_graph)
      AND NOT EXISTS(SELECT 1 FROM removed_nodes r WHERE r.removed_node = n.id);

  previous_count = 0;
  current_count = COUNT(*) FROM nodes_to_clone;

  -- Keep adding nodes to clone by checking outgoing relations from nodes to clone
  WHILE previous_count < current_count LOOP
    previous_count = current_count;

    INSERT INTO nodes_to_clone (old_id, new_uid)
      SELECT lr.target, concat(target_node_uid, '#', lr.target)
      FROM live_relations lr
      WHERE EXISTS( SELECT 1 FROM nodes_to_clone nc WHERE nc.old_id = lr.source)
        AND lr.key = ANY (traverse_ids)
        AND NOT EXISTS (SELECT 1 FROM nodes_to_clone nc WHERE nc.old_id = lr.target)
    ;

    current_count = COUNT(*) FROM nodes_to_clone;
  END LOOP;

  -- Get all relations associated with the old segment of nodes that are going to be cloned
  CREATE TABLE relations_to_create AS
    SELECT lr.source, lr.key, lr.target, CONCAT(target_node_uid, '#', lr.node) as node_uid
    FROM live_relations lr
    WHERE EXISTS (SELECT 1 FROM nodes_to_clone nc WHERE nc.old_id = lr.source)
      OR EXISTS (SELECT 1 FROM nodes_to_clone nc WHERE nc.old_id = lr.target);

  -- Create the new nodes
  WITH new_node_ids AS (
    INSERT INTO nodes (uid, graph, created_on, created_by)
      SELECT ntc.new_uid, target_graph, NOW(), user_id
      FROM nodes_to_clone ntc
    RETURNING uid as new_uid, id as new_id
  ), -- Create the new relation nodes
    relation_node_ids AS (
    INSERT INTO nodes (uid, graph, created_on, created_by)
      SELECT node_uid, target_graph, NOW(), user_id
      FROM relations_to_create
    RETURNING uid as new_uid, id as new_id
  ), -- Create attribute nodes
    new_attribute_nodes AS (
    INSERT INTO nodes (uid, graph, created_on, created_by)
      SELECT concat(target_node_uid, '#', la.node), target_graph, now(), user_id
      FROM live_attributes la
      WHERE EXISTS (SELECT 1 FROM nodes_to_clone ntc WHERE la.source = ntc.old_id)
    RETURNING uid as new_uid, id as new_id
  ), -- Create attributes for the new nodes
    new_attributes AS (
    INSERT INTO attributes (node, source, key, double_value, string_value, boolean_value, datetime_value, datatype)
      SELECT (SELECT new_id FROM new_attribute_nodes WHERE new_uid = CONCAT(target_node_uid, '#', la.node)),
      nni.new_id,
      la.key,
      la.double_value,
      la.string_value,
      la.boolean_value,
      la.datetime_value,
      la.datatype
      FROM live_attributes la, new_node_ids nni, nodes_to_clone ntc
      WHERE
        ntc.new_uid = nni.new_uid
        AND la.source = ntc.old_id
      RETURNING id
  ) -- Create the new relations, pointing to and from old or new nodes depending on whether a new node is created
    -- to represent the source and/or target of the relation.
  INSERT INTO relations (node, source, key, target)
    SELECT
      rni.new_id,
      COALESCE( (
        SELECT nni.new_id
        FROM new_node_ids nni, nodes_to_clone ntc
        WHERE
          rtc.source = ntc.old_id
          AND ntc.new_uid = nni.new_uid
      ), rtc.source),
      rtc.key,
      COALESCE( (
        SELECT nni.new_id
        FROM new_node_ids nni, nodes_to_clone ntc
        WHERE
          rtc.target = ntc.old_id
          AND ntc.new_uid = nni.new_uid
      ), rtc.target)
    FROM
      relations_to_create rtc
      JOIN relation_node_ids rni ON rtc.node_uid = rni.new_uid;


  result = COUNT(*) FROM nodes_to_clone;

  DROP TABLE nodes_to_clone;
  DROP TABLE relations_to_create;

  RETURN result;
END;
$$
LANGUAGE 'plpgsql' VOLATILE;

-- 3.0.10_1 traverse properties

CREATE OR REPLACE FUNCTION getLiveAttributeForUid(original_uid text, original_graph text) RETURNS integer AS
$$
DECLARE
  result integer;
  previous_result integer;
BEGIN
  previous_result = attributes.id FROM attributes JOIN nodes ON nodes.id=attributes.node WHERE nodes.uid=original_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM original_graph);
  result = previous_result;

  WHILE result IS NOT NULL LOOP
    previous_result = result;
    result = replaced_by FROM replaced_attributes WHERE replaced = previous_result;
  END LOOP;

  RETURN previous_result;
END;
$$
LANGUAGE 'plpgsql' VOLATILE;


CREATE OR REPLACE FUNCTION getLiveRelationForUid(original_uid text, original_graph text) RETURNS integer AS
$$
DECLARE
  result integer;
  previous_result integer;
BEGIN
  previous_result = relations.id FROM relations JOIN nodes ON nodes.id=relations.node WHERE nodes.uid=original_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM original_graph);
  result = previous_result;

  WHILE result IS NOT NULL LOOP
    previous_result = result;
    result = replaced_by FROM replaced_relations WHERE replaced = previous_result;
  END LOOP;

  RETURN previous_result;
END;
$$
LANGUAGE 'plpgsql' VOLATILE;

-- 3.0.3_4

CREATE OR REPLACE VIEW live_individuals AS
  SELECT * FROM nodes n
  WHERE
    NOT EXISTS (SELECT 1 FROM attributes WHERE node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM relations WHERE node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM removed_nodes WHERE removed_node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM removed_nodes WHERE node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM replaced_attributes WHERE node = n.id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM replaced_relations WHERE node = n.id LIMIT 1);


CREATE OR REPLACE VIEW query_result_nodes_view AS
SELECT
      nodes.id                       as "node_id",
      nodes.uid                      as "node_uid",
      (SELECT uid FROM graphs WHERE id = nodes.graph)                    as "node_graph",
      nodes.created_on               as "node_created",
      (SELECT uid FROM creators WHERE id = nodes.created_by)               as "node_created_by",
      removed_by_nodes.uid           as "node_removed_by",
      (SELECT uid FROM graphs WHERE id = removed_by_nodes.graph)         as "node_removed_by_graph",
      CAST (NULL as text)            as "property_uid",
      CAST (NULL as text)            as "property_graph",
      CAST (NULL as timestamp)       as "property_created",
      CAST (NULL as text)            as "property_creator",
      CAST (NULL as text)            as "key",
      CAST (NULL as double precision)as "double_value",
      CAST (NULL as boolean)         as "boolean_value",
      CAST (NULL as timestamp)       as "datetime_value",
      CAST (NULL as text)            as "string_value",
      0                              as "target_id",
      CAST (NULL as text)            as "target_uid",
      CAST (NULL as text)            as "target_graph",
      timestamp '1970-01-01 00:00'   as "target_created",
      CAST (NULL as text)                          as "target_creator",
      CAST (NULL as text)                          as "replaced_by",
      CAST (NULL as text)                          as "replaced_by_graph",
      CAST (NULL as text)                        as "property_removed_by",
      CAST (NULL as text)                        as "property_removed_by_graph"

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
      CAST(NULL as text)                        as "node_graph",
      CAST(NULL as timestamp)                   as "node_created",
      CAST(NULL as text)                        as "node_created_by",
      CAST(NULL as text)                 as "node_removed_by",
      CAST(NULL as text)                 as "node_removed_by_graph",
      attr_nodes.uid                            as "property_uid",
      (SELECT uid FROM graphs WHERE id = attr_nodes.graph) as "property_graph",
      attr_nodes.created_on                     as "property_created",
      (SELECT uid from creators WHERE id = attr_nodes.created_by)  as "property_creator",
      (SELECT label from attribute_keys WHERE id = attributes.key) as "key",
      attributes.double_value      as "double_value",
      attributes.boolean_value     as "boolean_value",
      attributes.datetime_value    as "datetime_value",
      attributes.string_value      as "string_value",
      CAST( NULL as integer)                    as "target_id",
      CAST(NULL as text)                        as "target_uid",
      CAST(NULL as text)                        as "target_graph",
      timestamp '1970-01-01 00:00'              as "target_created",
      CAST(NULL as text)                        as "target_creator",
      replaced_by_nodes.uid                     as "replaced_by",
      (SELECT uid from graphs WHERE id = replaced_by_nodes.graph) as "replaced_by_graph",
      removed_by_nodes.uid                      as "property_removed_by",
      (SELECT uid from graphs WHERE id = removed_by_nodes.graph) as "property_removed_by_graph"

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
      CAST(NULL as text)                      as "node_graph",
      CAST(NULL as timestamp)                        as "node_created",
      CAST(NULL as text)                     as "node_created_by",
      CAST(NULL as text)              as "node_removed_by",
      CAST(NULL as text)              as "node_removed_by_graph",
      relation_nodes.uid                      as "property_uid",
      (SELECT uid FROM graphs WHERE id =relation_nodes.graph)                    as "property_graph",
      relation_nodes.created_on               as "property_created",
      (SELECT c.uid FROM creators c WHERE c.id = relation_nodes.created_by)        as "property_creator",
      (SELECT k.label FROM relation_keys k WHERE k.id = relations.key)            as "key",
      CAST(NULL as double precision)          as "double_value",
      CAST(NULL as boolean)                   as "boolean_value",
      CAST(NULL as timestamp)                 as "datetime_value",
      CAST(NULL as text)                      as "string_value",
      relations.target           as "target_id",
      target_nodes.uid       as "target_uid",
      (SELECT uid FROM graphs WHERE id = target_nodes.graph)       as "target_graph",
      target_nodes.created_on   as "target_created",
      (SELECT c.uid FROM creators c WHERE c.id = target_nodes.created_by)as "target_creator",
      replaced_by_nodes.uid                   as "replaced_by",
      (SELECT uid FROM graphs WHERE id = replaced_by_nodes.graph)       as "replaced_by_graph",
      removed_by_nodes.uid                    as "property_removed_by",
      (SELECT uid FROM graphs WHERE id = removed_by_nodes.graph)       as "property_removed_by_graph"


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
      (SELECT uid FROM graphs WHERE id = nodes.graph) as "node_graph",
      nodes.created_on               as "node_created",
      (SELECT uid FROM creators WHERE id = nodes.created_by)               as "node_created_by",
      CAST (NULL as text)            as "node_removed_by",
      CAST (NULL as text)            as "node_removed_by_graph",
      CAST (NULL as text)            as "property_uid",
      CAST (NULL as text)            as "property_graph",
      CAST (NULL as timestamp)       as "property_created",
      CAST (NULL as text)            as "property_creator",
      CAST (NULL as text)            as "key",
      CAST (NULL as double precision)as "double_value",
      CAST (NULL as boolean)         as "boolean_value",
      CAST (NULL as timestamp)       as "datetime_value",
      CAST (NULL as text)            as "string_value",
      0                              as "target_id",
      CAST (NULL as text)            as "target_uid",
      CAST (NULL as text)            as "target_graph",
      timestamp '1970-01-01 00:00'   as "target_created",
      CAST (NULL as text)            as "target_creator",
      CAST (NULL as text)            as "replaced_by",
      CAST (NULL as text)            as "replaced_by_graph",
      CAST (NULL as text)            as "property_removed_by",
      CAST (NULL as text)            as "property_removed_by_graph"

    FROM live_individuals nodes
;


CREATE OR REPLACE VIEW live_query_result_attributes_view AS
    SELECT
      nodes.id                                  as "node_id",
      CAST(NULL as text)                        as "node_uid",
      CAST(NULL as text)                        as "node_graph",
      CAST(NULL as timestamp)                   as "node_created",
      CAST(NULL as text)                        as "node_created_by",
      CAST (NULL as text)            as "node_removed_by",
      CAST (NULL as text)            as "node_removed_by_graph",
      attr_nodes.uid                            as "property_uid",
      (SELECT uid FROM graphs WHERE id = attr_nodes.graph) as "property_graph",
      attr_nodes.created_on                     as "property_created",
      (SELECT uid from creators WHERE id = attr_nodes.created_by)  as "property_creator",
      (SELECT label from attribute_keys WHERE id = attributes.key) as "key",
      attributes.double_value      as "double_value",
      attributes.boolean_value     as "boolean_value",
      attributes.datetime_value    as "datetime_value",
      attributes.string_value      as "string_value",
      CAST( NULL as integer)                    as "target_id",
      CAST(NULL as text)                        as "target_uid",
      CAST (NULL as text)            as "target_graph",
      timestamp '1970-01-01 00:00'              as "target_created",
      CAST(NULL as text)                        as "target_creator",
      CAST (NULL as text)            as "replaced_by",
      CAST (NULL as text)            as "replaced_by_graph",
      CAST (NULL as text)            as "property_removed_by",
      CAST (NULL as text)            as "property_removed_by_graph"
    FROM live_attributes attributes

    -- Get attributes
    JOIN nodes ON nodes.id=attributes.source

    ---- Get attribute nodes
    JOIN nodes attr_nodes ON attributes.node=attr_nodes.id
;

CREATE OR REPLACE VIEW live_query_result_relations_view AS     SELECT
      nodes.id                                as "node_id",
      CAST(NULL as text)                      as "node_uid",
      CAST(NULL as text)                        as "node_graph",
      CAST(NULL as timestamp)                        as "node_created",
      CAST(NULL as text)                     as "node_created_by",
      CAST (NULL as text)            as "node_removed_by",
      CAST (NULL as text)            as "node_removed_by_graph",
      relation_nodes.uid                      as "property_uid",
      (SELECT uid FROM graphs WHERE id = relation_nodes.graph) as "property_graph",
      relation_nodes.created_on               as "property_created",
      (SELECT c.uid FROM creators c WHERE c.id = relation_nodes.created_by)        as "property_creator",
      (SELECT k.label FROM relation_keys k WHERE k.id = relations.key)            as "key",
      CAST(NULL as double precision)          as "double_value",
      CAST(NULL as boolean)                   as "boolean_value",
      CAST(NULL as timestamp)                 as "datetime_value",
      CAST(NULL as text)                      as "string_value",
      relations.target           as "target_id",
      target_nodes.uid       as "target_uid",
      (SELECT uid FROM graphs WHERE id = target_nodes.graph) as "target_graph",
      target_nodes.created_on   as "target_created",
      (SELECT c.uid FROM creators c WHERE c.id = target_nodes.created_by)as "target_creator",
      CAST (NULL as text)            as "replaced_by",
      CAST (NULL as text)            as "replaced_by_graph",
      CAST (NULL as text)            as "property_removed_by",
      CAST (NULL as text)            as "property_removed_by_graph"
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
