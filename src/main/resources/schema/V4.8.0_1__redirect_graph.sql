-- Function to

CREATE OR REPLACE FUNCTION redirect_graph (source_graph text, old_target_graph text, new_target_graph text, dryrun boolean, do_partial boolean)
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
DECLARE
  source_graph_id integer;
  old_target_graph_id integer;
  new_target_graph_id integer;
  issue_count integer;
  issue_list text;
BEGIN
  source_graph_id = id FROM graphs WHERE uid IS NOT DISTINCT FROM source_graph;
  old_target_graph_id = id FROM graphs WHERE uid IS NOT DISTINCT FROM old_target_graph;
  new_target_graph_id = id FROM graphs WHERE uid IS NOT DISTINCT FROM new_target_graph;

  CREATE TEMPORARY TABLE proposed_mapping ON COMMIT DROP AS
    SELECT
      live_relations.source,
      live_relations.key,
      target_nodes.uid,
      new_target.id,
      relation_nodes.uid AS ruid,
      relation_nodes.id AS rid,
      relation_nodes.created_by,
      relation_nodes.created_on
    FROM live_relations
    JOIN nodes relation_nodes ON relation_nodes.id = node
    JOIN nodes source_nodes ON source_nodes.id = source
    JOIN nodes target_nodes ON target_nodes.id = target
    LEFT JOIN nodes new_target ON new_target.graph = new_target_graph_id AND new_target.uid = target_nodes.uid
    LEFT JOIN live_relations existing_new_relation ON existing_new_relation.key = live_relations.key and existing_new_relation.source = live_relations.source AND existing_new_relation.id != live_relations.id
    LEFT JOIN nodes existing_new_relation_targets ON existing_new_relation.target = new_target.id
    WHERE source_nodes.graph = source_graph_id
      AND target_nodes.graph = old_target_graph_id
      AND existing_new_relation_targets.id IS NULL
      ;

  issue_count = COUNT(*) FROM proposed_mapping WHERE id IS NULL;
  IF issue_count > 0 AND NOT do_partial THEN
    issue_list = string_agg(uid, ',') FROM proposed_mapping WHERE id IS NULL;
    RAISE EXCEPTION 'Relations to the following nodes could not be mapped: %', issue_list;
  END IF;

  IF NOT dryrun THEN
    CREATE TEMPORARY TABLE new_nodes ON COMMIT DROP AS
      SELECT rid AS old_id, CONCAT(ruid, '#', new_target_graph_id) AS uid, created_by, created_on
      FROM proposed_mapping
      WHERE id IS NOT NULL;

    CREATE TEMPORARY TABLE new_node_relations ON COMMIT DROP AS
    SELECT live_relations.*, CONCAT(new_nodes.uid, '#', live_relations.node) as relation_node_uid
    FROM new_nodes
    JOIN live_relations ON new_nodes.old_id = live_relations.source
    LEFT JOIN new_nodes already_exists ON already_exists.old_id = live_relations.node
    WHERE already_exists.old_id IS NULL;

    INSERT INTO new_node_relations
    SELECT live_relations.*, already_exists.uid as relation_node_uid
    FROM new_nodes
    JOIN live_relations ON new_nodes.old_id = live_relations.source
    JOIN new_nodes already_exists ON already_exists.old_id = live_relations.node;

    CREATE TEMPORARY TABLE new_node_attributes ON COMMIT DROP AS
    SELECT live_attributes.*, CONCAT(new_nodes.uid, '#', live_attributes.node) as attribute_node_uid
    FROM new_nodes
    JOIN live_attributes ON new_nodes.old_id = live_attributes.source;

    INSERT INTO new_nodes (old_id, uid, created_by, created_on)
      SELECT node, relation_node_uid, nodes.created_by, nodes.created_on
      FROM new_node_relations
       JOIN nodes ON nodes.id = new_node_relations.node
       LEFT JOIN new_nodes already_exists ON already_exists.uid = relation_node_uid
      WHERE already_exists.old_id IS NULL;

    INSERT INTO new_nodes (old_id, uid, created_by, created_on)
      SELECT node, attribute_node_uid, nodes.created_by, nodes.created_on
      FROM new_node_attributes
       JOIN nodes ON nodes.id = new_node_attributes.node;

    WITH created_nodes AS  -- Create all required new nodes
      (INSERT INTO nodes (uid, created_on, created_by, graph)
        SELECT uid, created_on, created_by, source_graph_id
        FROM new_nodes
        RETURNING nodes.id, nodes.uid
      ),
      created_relations AS  -- Create all relations from source to the new target
        (INSERT INTO
            relations (node, source, key, target)
            SELECT
              created_nodes.id,
              coalesce(
                (
                  SELECT created_nodes.id
                  FROM created_nodes
                  JOIN new_nodes ON new_nodes.uid = created_nodes.uid
                  WHERE new_nodes.old_id = proposed_mapping.source
                ),
                proposed_mapping.source
              ),
              proposed_mapping.key,
              proposed_mapping.id
            FROM proposed_mapping
            JOIN new_nodes ON proposed_mapping.rid = new_nodes.old_id
            JOIN created_nodes ON new_nodes.uid = created_nodes.uid
         RETURNING relations.id, relations.node),
      created_attributes AS (  -- Give those relations their attributes
          INSERT INTO attributes (node, source, key, double_value, string_value, boolean_value, datetime_value, datatype)
            SELECT
              attribute_node.id,
              source.id,
              new_node_attributes.key,
              new_node_attributes.double_value,
              new_node_attributes.string_value,
              new_node_attributes.boolean_value,
              new_node_attributes.datetime_value,
              new_node_attributes.datatype
            FROM
              new_node_attributes
              JOIN new_nodes on new_node_attributes.source = new_nodes.old_id
              JOIN created_nodes source ON source.uid = new_nodes.uid
              JOIN created_nodes attribute_node ON attribute_node.uid = new_node_attributes.attribute_node_uid
            RETURNING attributes.id
      )
      INSERT INTO relations (node, source, key, target) -- Give those relations their relations
      SELECT
        relation_node.id,
        source.id,
        new_node_relations.key,
        coalesce((
              SELECT created_nodes.id
              FROM created_nodes
              JOIN new_nodes ON new_nodes.uid = created_nodes.uid
              WHERE new_nodes.old_id = new_node_relations.target
            ),new_node_relations.target
        )
      FROM
        new_node_relations
        JOIN new_nodes on new_node_relations.source = new_nodes.old_id
        JOIN created_nodes source ON source.uid = new_nodes.uid
        JOIN created_nodes relation_node ON relation_node.uid = new_node_relations.relation_node_uid
        LEFT JOIN created_relations ON created_relations.node = relation_node.id
        WHERE created_relations.node IS NULL
      ;
  END IF;
  RETURN COUNT(*) FROM proposed_mapping WHERE id IS NOT NULL;
END;
$function$
;
