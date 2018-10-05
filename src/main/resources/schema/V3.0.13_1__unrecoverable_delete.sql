CREATE OR REPLACE FUNCTION remove_node_unrecoverable(node_uid text) RETURNS integer AS
$$
DECLARE
  current_count integer;
  previous_count integer;
  delete_array integer[];
BEGIN
  previous_count = 0;

  CREATE TEMP TABLE to_delete AS
    SELECT id FROM nodes
    WHERE uid=node_uid;

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
