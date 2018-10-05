DROP TABLE IF EXISTS result_table;

DROP FUNCTION nodeids_with_recursive_relation_out(text,text,text,boolean);
CREATE OR REPLACE FUNCTION nodeids_with_recursive_relation_out(relation_key text, target_uid text, target_graph_uid text, include_self boolean) RETURNS TABLE(qid integer) AS
$$
DECLARE
  current_count integer;
  previous_count integer;
  relation_key_id integer;
  target_id integer;
BEGIN
  previous_count = 0;
  target_id = id FROM live_individuals WHERE uid = target_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM target_graph_uid);
  relation_key_id = id FROM relation_keys WHERE label = relation_key;

  -- Create the table that holds the results
  CREATE TEMPORARY TABLE result_table ON COMMIT DROP AS SELECT target_id AS id;
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


  RETURN QUERY SELECT id AS qid FROM result_table;
 END;
$$
LANGUAGE plpgsql;

DROP FUNCTION nodeids_with_recursive_relation_in(text,text,text,boolean);
CREATE OR REPLACE FUNCTION nodeids_with_recursive_relation_in(relation_key text, source_uid text, source_graph_uid text, include_self boolean) RETURNS TABLE(qid integer) AS
$$
DECLARE
  current_count integer;
  previous_count integer;
  relation_key_id integer;
  source_id integer;
BEGIN
  previous_count = 0;
  source_id = id FROM live_individuals WHERE uid = source_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM source_graph_uid);
  relation_key_id = id FROM relation_keys WHERE label = relation_key;

  CREATE TEMPORARY TABLE result_table ON COMMIT DROP AS SELECT source_id AS id;
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


  RETURN QUERY SELECT id AS qid FROM result_table;
 END;
$$

LANGUAGE plpgsql;

