CREATE OR REPLACE FUNCTION truncate_graph (graphToDelete text, remove_node_uid text, remove_node_graph text)
 RETURNS integer
 LANGUAGE plpgsql
AS $function$
DECLARE
  current_count integer;
  previous_count integer;
  remove_node_id integer;
  graph_id integer;
  issue_count integer;
  issue_list text;
BEGIN
  previous_count = 0;

  graph_id = id FROM graphs WHERE uid IS NOT DISTINCT FROM graphToDelete;

  CREATE TEMPORARY TABLE issues ON COMMIT DROP AS
    SELECT CONCAT(relation_nodes.uid, '(', relation_graphs.uid, ')') AS node
      FROM relations
      JOIN nodes relation_nodes ON relations.node = relation_nodes.id
      JOIN nodes target_nodes ON relations.target = target_nodes.id
      JOIN nodes source_nodes ON relations.source = source_nodes.id
      JOIN graphs relation_graphs ON relation_nodes.graph = relation_graphs.id
      WHERE relation_nodes.deleted_by = -1
        AND relation_nodes.graph != graph_id
        AND (target_nodes.graph = graph_id OR source_nodes.graph = graph_id);

  issue_count = COUNT(*) FROM issues;

  IF issue_count > 0 THEN
     issue_list = string_agg(issues.node, ',') FROM issues;
     --issue_list = string_agg(issues.node, ',') FROM issues;
     RAISE EXCEPTION 'Live relations to/from this graph not themselves in graph %: %', graphToDelete, issue_list;
  END IF;

  CREATE TEMPORARY TABLE to_remove ON COMMIT DROP AS
    SELECT id FROM nodes
    WHERE
      graph = graph_id
      AND deleted_by = -1;

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
