SELECT
  rn.uid,
  rn.created_on,
  (SELECT uid FROM creators c WHERE c.id = rn.created_by),
  (SELECT uid FROM nodes n WHERE n.id = r.source),
  (SELECT label FROM relation_keys rk WHERE rk.id = r.key),
  rt.uid,
  (SELECT uid FROM graphs g WHERE g.id = rt.graph)
FROM live_relations r JOIN nodes rn ON rn.id = r.node JOIN nodes rt ON rt.id = r.target
WHERE
  source = ANY((SELECT array(SELECT id FROM live_individuals WHERE uid = ANY(?)))::integer[])
  AND key = ANY((SELECT array(SELECT id FROM relation_keys WHERE label = ANY(?)))::integer[]);
