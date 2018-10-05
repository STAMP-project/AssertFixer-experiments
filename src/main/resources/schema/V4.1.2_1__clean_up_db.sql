
-- 4.1.2_1 clean up database

CREATE OR REPLACE FUNCTION clean_up_database() RETURNS integer AS
$$
DECLARE
  result integer;
BEGIN

  -- Build a list of nodes to remove

  CREATE TEMPORARY TABLE to_delete AS SELECT removed_node FROM removed_nodes;

  INSERT INTO to_delete (SELECT node FROM replaced_relations);
  INSERT INTO to_delete (SELECT node FROM replaced_attributes);

  INSERT INTO to_delete SELECT node FROM attributes WHERE id IN (SELECT replaced FROM replaced_attributes);
  INSERT INTO to_delete SELECT node FROM relations WHERE id IN (SELECT replaced FROM replaced_relations);

  INSERT INTO to_delete SELECT node FROM attributes WHERE source IN (SELECT removed_node FROM to_delete);
  INSERT INTO to_delete SELECT node FROM relations WHERE source IN (SELECT removed_node FROM to_delete);
  INSERT INTO to_delete SELECT node FROM relations WHERE target IN (SELECT removed_node FROM to_delete);

  INSERT INTO to_delete SELECT node FROM removed_nodes;

  -- Clear tables with 'historic' removes | removes all foreign key relations
  TRUNCATE removed_nodes;
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
