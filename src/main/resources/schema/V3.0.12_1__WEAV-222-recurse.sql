CREATE OR REPLACE FUNCTION nodeids_with_recursive_relation_out(relation_key text, target_uid text, include_self boolean) RETURNS integer[] AS
$$
DECLARE
  current_count integer;
  previous_count integer;
  relation_key_id integer;
  target_id integer;
  result integer[];
BEGIN
  previous_count = 0;
  target_id = id FROM live_individuals WHERE uid = target_uid;
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


CREATE OR REPLACE FUNCTION nodeids_with_recursive_relation_in(relation_key text, source_uid text, include_self boolean) RETURNS integer[] AS
$$
DECLARE
  current_count integer;
  previous_count integer;
  relation_key_id integer;
  source_id integer;
  result integer[];
BEGIN
  previous_count = 0;
  source_id = id FROM live_individuals WHERE uid = source_uid;
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

