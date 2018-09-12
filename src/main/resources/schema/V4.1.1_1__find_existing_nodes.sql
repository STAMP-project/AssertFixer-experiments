-- 4.1.1_1 find existing nodes addition

CREATE OR REPLACE FUNCTION find_existing_nodes(nodeUidList text[], graphList text[]) RETURNS TABLE(uid text, graph text) AS
$$
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
         AND NOT (EXISTS (SELECT 1 FROM removed_nodes rm WHERE rm.removed_node = n.id LIMIT 1));
  END LOOP;
  RETURN QUERY SELECT rt.uid AS uid, rt.graph AS graph FROM result_table rt;
END;
$$
LANGUAGE plpgsql;
