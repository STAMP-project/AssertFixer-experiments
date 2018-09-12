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
      AND deleted_by = -1;

  current_count = count(*) FROM to_remove;

  WHILE current_count > previous_count LOOP
    previous_count = current_count;

    INSERT INTO to_remove
    SELECT node
    FROM live_attributes
    JOIN to_remove ON source = to_remove.id
    LEFT JOIN to_remove existing ON node = existing.id
    WHERE existing.id IS NULL;

    INSERT INTO to_remove
    SELECT node
    FROM live_relations
    JOIN to_remove ON source = to_remove.id
    LEFT JOIN to_remove existing ON node = existing.id
    WHERE existing.id IS NULL;

    INSERT INTO to_remove
    SELECT node
    FROM live_relations
    JOIN to_remove ON target = to_remove.id
    LEFT JOIN to_remove existing ON node = existing.id
    WHERE existing.id IS NULL;

    current_count = count(*) FROM to_remove;
  END LOOP;

  remove_node_id = id FROM nodes WHERE uid = remove_node_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM remove_node_graph);

  UPDATE nodes
    SET deleted_by = remove_node_id
  FROM to_remove
    WHERE nodes.id = to_remove.id;

  RETURN current_count;
END;
$function$
