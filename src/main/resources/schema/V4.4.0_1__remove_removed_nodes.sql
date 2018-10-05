ALTER TABLE nodes
  ADD COLUMN deleted_by integer DEFAULT NULL,
  DROP CONSTRAINT nodes_uid_graph_key,
  ADD CONSTRAINT nodes_deleted_by_fkey FOREIGN KEY (deleted_by) REFERENCES nodes(id) ON UPDATE RESTRICT ON DELETE RESTRICT;

CREATE UNIQUE INDEX nodes_uid_graph_deleted_key ON nodes (uid, graph) WHERE deleted_by IS NULL;

UPDATE nodes
  SET deleted_by = (SELECT d.node FROM removed_nodes d WHERE d.removed_node = nodes.id);

CREATE OR REPLACE VIEW live_relations AS
 SELECT e.id,
    e.node,
    e.source,
    e.key,
    e.target
   FROM relations e
  WHERE NOT (EXISTS ( SELECT 1
           FROM nodes r
          WHERE r.id = e.node AND r.deleted_by IS NOT NULL
         LIMIT 1)) AND NOT (EXISTS ( SELECT 1
           FROM replaced_relations r
          WHERE e.id = r.replaced
         LIMIT 1));

CREATE OR REPLACE VIEW live_attributes AS
 SELECT attributes.id,
    attributes.node,
    attributes.source,
    attributes.key,
    attributes.double_value,
    attributes.string_value,
    attributes.boolean_value,
    attributes.datetime_value,
    attributes.datatype
   FROM attributes
  WHERE NOT (EXISTS (SELECT 1
                     FROM nodes r
                     WHERE r.id = attributes.node AND r.deleted_by IS NOT NULL
                    ))
           AND NOT (attributes.id IN ( SELECT replaced_attributes.replaced
           FROM replaced_attributes));

CREATE OR REPLACE VIEW removed_nodes_view AS
 SELECT meta.id AS meta_id,
    meta.uid AS meta_uid,
    meta.created_on AS meta_created_on,
    meta_creators.uid AS meta_created_by,
    removed.id AS removed_node,
    removed.uid AS removed_uid,
    removed.created_on AS removed_created_on,
    removed_creators.uid AS removed_created_by
   FROM nodes removed
     JOIN nodes meta ON meta.id = removed.deleted_by
     JOIN creators meta_creators ON meta_creators.id = meta.created_by
     JOIN creators removed_creators ON removed_creators.id = removed.created_by
   WHERE removed.deleted_by IS NOT NULL;

CREATE OR REPLACE VIEW trackerdb AS
 SELECT row_number() OVER (ORDER BY individuals.id) AS seqnr,
    individuals.datetime,
    individuals."user",
    individuals.action,
    individuals.node,
    individuals.key,
    individuals."from",
    individuals."to",
    individuals."oldTo",
    individuals.value
           FROM ( SELECT nodes.id,
            nodes.created_on AS datetime,
            nodes.created_by_uid AS "user",
            'create-node'::text AS action,
            nodes.uid AS node,
            NULL::text AS key,
            NULL::text AS "from",
            NULL::text AS "to",
            NULL::text AS "oldTo",
            NULL::text AS value
           FROM nodes_view nodes
          WHERE true
            AND NOT (nodes.id IN ( SELECT relations.node FROM relations))
            AND NOT (nodes.id IN ( SELECT attributes.node FROM attributes))
            AND NOT (nodes.id IN ( SELECT removed_nodes.deleted_by FROM nodes removed_nodes WHERE deleted_by IS NOT NULL))
            AND NOT (nodes.id IN ( SELECT replaced_attributes.node FROM replaced_attributes))
            AND NOT (nodes.id IN ( SELECT replaced_relations.node FROM replaced_relations))
        UNION ALL
         SELECT rnv.meta_id AS id,
            rnv.meta_created_on AS datetime,
            rnv.meta_created_by AS "user",
            'remove-node'::text AS action,
            rnv.removed_uid AS node,
            NULL::text AS key,
            NULL::text AS "from",
            NULL::text AS "to",
            NULL::text AS "oldTo",
            NULL::text AS value
           FROM removed_nodes_view rnv
          WHERE true
            AND NOT (rnv.removed_node IN ( SELECT relations.node FROM relations))
            AND NOT (rnv.removed_node IN ( SELECT attributes.node FROM attributes))
            AND NOT (rnv.removed_node IN ( SELECT removed_nodes.deleted_by FROM nodes removed_nodes WHERE deleted_by IS NOT NULL))
            AND NOT (rnv.removed_node IN ( SELECT replaced_attributes.node FROM replaced_attributes))
            AND NOT (rnv.removed_node IN ( SELECT replaced_relations.node FROM replaced_relations))
        UNION ALL
         SELECT attributes.node AS id,
            attributes.created_on AS datetime,
            attributes.created_by AS "user",
            'create-attribute'::text AS action,
            attributes.source_uid AS node,
            attributes.key_label AS key,
            NULL::text AS "from",
            NULL::text AS "to",
            NULL::text AS "oldTo",
            COALESCE(attributes.string_value, attributes.double_value::text, to_char(attributes.datetime_value, 'YYYY-DD-MM HH24:MI:SS'::text), attributes.boolean_value::text) AS value
           FROM attributes_view attributes
          WHERE true
            AND NOT (attributes.id IN ( SELECT replaced_attributes.replaced_by FROM replaced_attributes))
        UNION ALL
         SELECT rnv.meta_id AS id,
            rnv.meta_created_on AS datetime,
            rnv.meta_created_by AS "user",
            'remove-attribute'::text AS action,
            attributes.source_uid AS node,
            attributes.key_label AS key,
            NULL::text AS "from",
            NULL::text AS "to",
            NULL::text AS "oldTo",
            COALESCE(attributes.string_value, attributes.double_value::text, to_char(attributes.datetime_value, 'YYYY-DD-MM HH24:MI:SS'::text), attributes.boolean_value::text) AS value
           FROM removed_nodes_view rnv
             JOIN attributes_view attributes ON rnv.removed_node = attributes.node
        UNION ALL
         SELECT attributes.node AS id,
            attributes.created_on AS datetime,
            attributes.created_by AS "user",
            'update-attribute'::text AS action,
            attributes.source_uid AS node,
            attributes.key_label AS key,
            NULL::text AS "from",
            NULL::text AS "to",
            NULL::text AS "oldTo",
            COALESCE(attributes.string_value, attributes.double_value::text, to_char(attributes.datetime_value, 'YYYY-DD-MM HH24:MI:SS'::text), attributes.boolean_value::text) AS value
           FROM attributes_view attributes
          WHERE true AND (attributes.id IN ( SELECT replaced_attributes.replaced_by
                   FROM replaced_attributes))
        UNION ALL
         SELECT relations.node AS id,
            relations.created_on AS datetime,
            relations.created_by AS "user",
            'create-relation'::text AS action,
            relations.node_uid AS node,
            relations.key_label AS key,
            relations.source_uid AS "from",
            relations.target_uid AS "to",
            NULL::text AS "oldTo",
            NULL::text AS value
           FROM relations_view relations
          WHERE true AND NOT (relations.id IN ( SELECT replaced_relations.replaced_by
                   FROM replaced_relations))
        UNION ALL
         SELECT rnv.meta_id AS id,
            rnv.meta_created_on AS datetime,
            rnv.meta_created_by AS "user",
            'remove-relation'::text AS action,
            relations.node_uid AS node,
            relations.key_label AS key,
            relations.source_uid AS "from",
            relations.target_uid AS "to",
            NULL::text AS "oldTo",
            NULL::text AS value
           FROM removed_nodes_view rnv
             JOIN relations_view relations ON rnv.removed_node = relations.node
        UNION ALL
         SELECT relations.node AS id,
            relations.created_on AS datetime,
            relations.created_by AS "user",
            'update-relation'::text AS action,
            relations.node_uid AS node,
            relations.key_label AS key,
            relations.source_uid AS "from",
            relations.target_uid AS "to",
            old_relations.node_uid AS "oldTo",
            NULL::text AS value
           FROM relations_view relations
             JOIN replaced_relations ON replaced_relations.replaced_by = relations.id
             JOIN relations_view old_relations ON old_relations.id = replaced_relations.replaced) individuals
  ORDER BY individuals.id;

CREATE OR REPLACE VIEW live_individuals AS
 SELECT n.id,
    n.uid,
    n.created_on,
    n.created_by,
    n.graph
   FROM nodes n
  WHERE NOT (EXISTS ( SELECT 1
           FROM attributes
          WHERE attributes.node = n.id
         LIMIT 1)) AND NOT (EXISTS ( SELECT 1
           FROM relations
          WHERE relations.node = n.id
         LIMIT 1)) AND deleted_by IS NULL
         AND NOT (EXISTS ( SELECT 1
           FROM nodes rn
          WHERE rn.deleted_by = n.id
         LIMIT 1)) AND NOT (EXISTS ( SELECT 1
           FROM replaced_attributes
          WHERE replaced_attributes.node = n.id
         LIMIT 1)) AND NOT (EXISTS ( SELECT 1
           FROM replaced_relations
          WHERE replaced_relations.node = n.id
         LIMIT 1));

CREATE OR REPLACE VIEW query_result_nodes_view AS
   SELECT nodes.id AS node_id,
    nodes.uid AS node_uid,
    ( SELECT graphs.uid
           FROM graphs
          WHERE graphs.id = nodes.graph) AS node_graph,
    nodes.created_on AS node_created,
    ( SELECT creators.uid
           FROM creators
          WHERE creators.id = nodes.created_by) AS node_created_by,
    removed_by_nodes.uid AS node_removed_by,
    ( SELECT graphs.uid
           FROM graphs
          WHERE graphs.id = removed_by_nodes.graph) AS node_removed_by_graph,
    NULL::text AS property_uid,
    NULL::text AS property_graph,
    NULL::timestamp without time zone AS property_created,
    NULL::text AS property_creator,
    NULL::text AS key,
    NULL::double precision AS double_value,
    NULL::boolean AS boolean_value,
    NULL::timestamp without time zone AS datetime_value,
    NULL::text AS string_value,
    0 AS target_id,
    NULL::text AS target_uid,
    NULL::text AS target_graph,
    '1970-01-01 00:00:00'::timestamp without time zone AS target_created,
    NULL::text AS target_creator,
    NULL::text AS replaced_by,
    NULL::text AS replaced_by_graph,
    NULL::text AS property_removed_by,
    NULL::text AS property_removed_by_graph
   FROM nodes nodes
     LEFT JOIN nodes removed_by_nodes ON nodes.deleted_by = removed_by_nodes.id
  WHERE true AND NOT (EXISTS ( SELECT 1
           FROM attributes
          WHERE attributes.node = nodes.id
         LIMIT 1)) AND NOT (EXISTS ( SELECT 1
           FROM relations
          WHERE relations.node = nodes.id
         LIMIT 1));

CREATE OR REPLACE VIEW query_result_attributes_view AS
 SELECT nodes.id AS node_id,
    NULL::text AS node_uid,
    NULL::text AS node_graph,
    NULL::timestamp without time zone AS node_created,
    NULL::text AS node_created_by,
    NULL::text AS node_removed_by,
    NULL::text AS node_removed_by_graph,
    attr_nodes.uid AS property_uid,
    ( SELECT graphs.uid
           FROM graphs
          WHERE graphs.id = attr_nodes.graph) AS property_graph,
    attr_nodes.created_on AS property_created,
    ( SELECT creators.uid
           FROM creators
          WHERE creators.id = attr_nodes.created_by) AS property_creator,
    ( SELECT attribute_keys.label
           FROM attribute_keys
          WHERE attribute_keys.id = attributes.key) AS key,
    attributes.double_value,
    attributes.boolean_value,
    attributes.datetime_value,
    attributes.string_value,
    NULL::integer AS target_id,
    NULL::text AS target_uid,
    NULL::text AS target_graph,
    '1970-01-01 00:00:00'::timestamp without time zone AS target_created,
    NULL::text AS target_creator,
    replaced_by_nodes.uid AS replaced_by,
    ( SELECT graphs.uid
           FROM graphs
          WHERE graphs.id = replaced_by_nodes.graph) AS replaced_by_graph,
    removed_by_nodes.uid AS property_removed_by,
    ( SELECT graphs.uid
           FROM graphs
          WHERE graphs.id = removed_by_nodes.graph) AS property_removed_by_graph
   FROM nodes
     JOIN attributes ON nodes.id = attributes.source
     JOIN nodes attr_nodes ON attributes.node = attr_nodes.id
     LEFT JOIN replaced_attributes ON replaced_attributes.replaced = attributes.id
     LEFT JOIN nodes replaced_by_nodes ON replaced_attributes.replaced_by = replaced_by_nodes.id
     LEFT JOIN nodes removed_by_nodes ON attr_nodes.deleted_by = removed_by_nodes.id;

CREATE OR REPLACE VIEW query_result_relations_view AS
 SELECT nodes.id AS node_id,
    NULL::text AS node_uid,
    NULL::text AS node_graph,
    NULL::timestamp without time zone AS node_created,
    NULL::text AS node_created_by,
    NULL::text AS node_removed_by,
    NULL::text AS node_removed_by_graph,
    relation_nodes.uid AS property_uid,
    ( SELECT graphs.uid
           FROM graphs
          WHERE graphs.id = relation_nodes.graph) AS property_graph,
    relation_nodes.created_on AS property_created,
    ( SELECT c.uid
           FROM creators c
          WHERE c.id = relation_nodes.created_by) AS property_creator,
    ( SELECT k.label
           FROM relation_keys k
          WHERE k.id = relations.key) AS key,
    NULL::double precision AS double_value,
    NULL::boolean AS boolean_value,
    NULL::timestamp without time zone AS datetime_value,
    NULL::text AS string_value,
    relations.target AS target_id,
    target_nodes.uid AS target_uid,
    ( SELECT graphs.uid
           FROM graphs
          WHERE graphs.id = target_nodes.graph) AS target_graph,
    target_nodes.created_on AS target_created,
    ( SELECT c.uid
           FROM creators c
          WHERE c.id = target_nodes.created_by) AS target_creator,
    replaced_by_nodes.uid AS replaced_by,
    ( SELECT graphs.uid
           FROM graphs
          WHERE graphs.id = replaced_by_nodes.graph) AS replaced_by_graph,
    removed_by_nodes.uid AS property_removed_by,
    ( SELECT graphs.uid
           FROM graphs
          WHERE graphs.id = removed_by_nodes.graph) AS property_removed_by_graph
   FROM nodes
     JOIN relations ON nodes.id = relations.source
     JOIN nodes target_nodes ON target_nodes.id = relations.target
     JOIN nodes relation_nodes ON relations.node = relation_nodes.id
     LEFT JOIN replaced_relations ON replaced_relations.replaced = relations.id
     LEFT JOIN nodes replaced_by_nodes ON replaced_relations.replaced_by = replaced_by_nodes.id
     LEFT JOIN nodes removed_by_nodes ON relation_nodes.deleted_by = removed_by_nodes.id
     LEFT JOIN nodes removed_by_node_nodes ON nodes.deleted_by = removed_by_node_nodes.id;

DROP TABLE removed_nodes;
DROP SEQUENCE removed_nodes_id_seq;


CREATE OR REPLACE FUNCTION clean_up_database() RETURNS integer AS
$$
DECLARE
  result integer;
BEGIN

  -- Build a list of nodes to remove

  DROP TABLE IF EXISTS to_delete;
  CREATE TEMPORARY TABLE to_delete ON COMMIT DROP AS SELECT id AS removed_node FROM nodes WHERE deleted_by IS NOT NULL;

  INSERT INTO to_delete (SELECT node FROM replaced_relations);
  INSERT INTO to_delete (SELECT node FROM replaced_attributes);

  INSERT INTO to_delete SELECT node FROM attributes WHERE id IN (SELECT replaced FROM replaced_attributes);
  INSERT INTO to_delete SELECT node FROM relations WHERE id IN (SELECT replaced FROM replaced_relations);

  INSERT INTO to_delete SELECT node FROM attributes WHERE source IN (SELECT removed_node FROM to_delete);
  INSERT INTO to_delete SELECT node FROM relations WHERE source IN (SELECT removed_node FROM to_delete);
  INSERT INTO to_delete SELECT node FROM relations WHERE target IN (SELECT removed_node FROM to_delete);

  INSERT INTO to_delete SELECT deleted_by FROM nodes WHERE deleted_by IS NOT NULL;

  -- Clear tables with 'historic' removes | removes all foreign key relations
  TRUNCATE replaced_relations;
  TRUNCATE replaced_attributes;

  -- delete to_delete nodes from database | first delete all relations and attributes, then delete all nodes
  DELETE FROM attributes WHERE source IN (SELECT removed_node FROM to_delete);
  DELETE FROM attributes WHERE node IN (SELECT removed_node FROM to_delete);
  DELETE FROM relations WHERE source IN (SELECT removed_node FROM to_delete);
  DELETE FROM relations WHERE target IN (SELECT removed_node FROM to_delete);
  DELETE FROM relations WHERE node IN (SELECT removed_node FROM to_delete);
  DELETE FROM nodes WHERE id IN (SELECT removed_node FROM to_delete);

  result = COUNT(*) FROM to_delete;

  RETURN result;
END;
$$

LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION public.remove_node(remove_node_uid text, remove_node_graph text, removed_node_uid text, removed_node_graph text)
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
DECLARE
  current_count integer;
  previous_count integer;
  remove_node_id integer;
BEGIN
  previous_count = 0;

  DROP TABLE IF EXISTS to_remove;
  CREATE TEMPORARY TABLE to_remove ON COMMIT DROP AS
    SELECT id FROM nodes
    WHERE uid=removed_node_uid
      AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM removed_node_graph)
      AND deleted_by IS NULL;

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

  remove_node_id = id FROM nodes WHERE uid = remove_node_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM remove_node_graph);

  UPDATE nodes
    SET deleted_by = remove_node_id
    WHERE id IN (SELECT id FROM to_remove);

  RETURN current_count;
END;
$function$
;


CREATE OR REPLACE FUNCTION public.clone_node(source_node_uid text, source_node_graph text, target_node_uid text, target_node_graph text, user_id integer, relationstotraverse text[])
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
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
  DROP TABLE IF EXISTS nodes_to_clone;
  CREATE TEMPORARY TABLE nodes_to_clone ON COMMIT DROP AS
    SELECT n.id as old_id, target_node_uid as new_uid
    FROM nodes n
    WHERE n.uid = source_node_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM source_node_graph)
      AND n.deleted_by IS NULL;

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

  DROP TABLE IF EXISTS relations_to_create;
  -- Get all relations associated with the old segment of nodes that are going to be cloned
  CREATE TEMPORARY TABLE relations_to_create ON COMMIT DROP AS
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

  RETURN result;
END;
$function$
;

CREATE OR REPLACE FUNCTION public.remove_node_unrecoverable(node_uid text, node_graph_uid text)
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
DECLARE
  current_count integer;
  previous_count integer;
  delete_array integer[];
BEGIN
  previous_count = 0;

  DROP TABLE IF EXISTS to_delete;
  CREATE TEMPORARY TABLE to_delete ON COMMIT DROP AS
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
    SELECT deleted_by
      FROM nodes
     WHERE id IN (SELECT id FROM to_delete)
       AND deleted_by NOT IN (SELECT id FROM to_delete);

    current_count = count(*) FROM to_delete;
  END LOOP;
  delete_array = array(SELECT id FROM to_delete);

-- Delete from replaced tables second
  DELETE FROM replaced_relations
        WHERE node = ANY (delete_array)
           OR replaced IN (SELECT id FROM relations
              WHERE (source = ANY (delete_array)
                 OR target = ANY (delete_array)))
           OR replaced_by IN (SELECT id FROM relations
              WHERE (source = ANY (delete_array)
                 OR target = ANY (delete_array)));  DELETE FROM replaced_attributes
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

  RETURN current_count;
END;
$function$
;

CREATE OR REPLACE FUNCTION public.find_existing_nodes(nodeuidlist text[], graphlist text[])
 RETURNS TABLE(uid text, graph text)
 LANGUAGE plpgsql
AS $function$
DECLARE
BEGIN

  CREATE TEMPORARY TABLE result_table ON COMMIT DROP AS SELECT uid, graph;
  FOR i IN array_lower(nodeUidList, 1)..array_upper(nodeUidList, 1)
  LOOP
    INSERT INTO result_table
      SELECT n.uid AS uid, (SELECT g.uid FROM graphs g WHERE n.graph = g.id) AS graph
        FROM nodes n
       WHERE n.uid = nodeUidList[i]
         AND n.graph IN (SELECT g.id FROM graphs g WHERE g.uid = graphList[i] OR (g.uid IS NULL AND graphList[i] IS NULL))
         AND n.deleted_by IS NULL;
  END LOOP;
  RETURN QUERY SELECT rt.uid AS uid, rt.graph AS graph FROM result_table rt;
END;
$function$
;

