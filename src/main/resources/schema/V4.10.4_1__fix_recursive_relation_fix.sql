CREATE OR REPLACE FUNCTION nodeids_with_recursive_relation_out(relation_key text, target_uid text, target_graph_uid text, include_self boolean) RETURNS TABLE(qid integer) AS
$$
DECLARE
  current_count integer;
  previous_count integer;
  relation_key_id integer;
  target_id integer;
  result_ids integer[];
BEGIN
  previous_count = 0;
  target_id = id FROM live_individuals WHERE uid = target_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM target_graph_uid);
  relation_key_id = id FROM relation_keys WHERE label = relation_key;

  result_ids = array[target_id];
  current_count = cardinality(result_ids);

  WHILE current_count > previous_count LOOP
    previous_count = current_count;

    result_ids = result_ids || array(
      SELECT source
      FROM live_relations
      WHERE key = relation_key_id
      AND target = ANY(result_ids)
      AND source != ALL(result_ids)
    );

    current_count = cardinality(result_ids);
  END LOOP;

  IF include_self THEN
    RETURN QUERY SELECT * FROM unnest(result_ids);
  ELSE
    RETURN QUERY SELECT * FROM (SELECT * FROM unnest(result_ids)) a WHERE unnest != target_id;
  END IF;
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
  result_ids integer[];
BEGIN
  previous_count = 0;
  source_id = id FROM live_individuals WHERE uid = source_uid AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM source_graph_uid);
  relation_key_id = id FROM relation_keys WHERE label = relation_key;

  result_ids = array[source_id];
  current_count = cardinality(result_ids);

  WHILE current_count > previous_count LOOP
    previous_count = current_count;

    result_ids = result_ids || array(
      SELECT target
      FROM live_relations
      WHERE key = relation_key_id
      AND source = ANY(result_ids)
      AND target != ALL(result_ids)
    );

    current_count = cardinality(result_ids);
  END LOOP;

  IF include_self THEN
    RETURN QUERY SELECT * FROM unnest(result_ids);
  ELSE
    RETURN QUERY SELECT * FROM (SELECT * FROM unnest(result_ids)) a WHERE unnest != source_id;
  END IF;
 END;
$$

LANGUAGE plpgsql;
