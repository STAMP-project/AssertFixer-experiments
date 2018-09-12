CREATE OR REPLACE FUNCTION clone_node(source_node_uid text, target_node_uid text, user_id integer, relationsToTraverse text[]) RETURNS integer AS
$$
DECLARE
  traverse_ids integer[];
  previous_count integer;
  current_count integer;
  result integer;
BEGIN
  -- Get the relation keys which determine what nodes we have to copy
  traverse_ids = ARRAY(SELECT id FROM relation_keys WHERE label = ANY(relationsToTraverse));

  -- Initial node to clone
  CREATE TABLE nodes_to_clone AS
    SELECT n.id as old_id, target_node_uid as new_uid
    FROM nodes n
    WHERE n.uid = source_node_uid
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
    INSERT INTO nodes (uid, created_on, created_by)
      SELECT ntc.new_uid, NOW(), user_id
      FROM nodes_to_clone ntc
    RETURNING uid as new_uid, id as new_id
  ), -- Create the new relation nodes
    relation_node_ids AS (
    INSERT INTO nodes (uid, created_on, created_by)
      SELECT node_uid, NOW(), user_id
      FROM relations_to_create
    RETURNING uid as new_uid, id as new_id
  ), -- Create attribute nodes
    new_attribute_nodes AS (
    INSERT INTO nodes (uid, created_on, created_by)
      SELECT concat(target_node_uid, '#', la.node), now(), user_id
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
