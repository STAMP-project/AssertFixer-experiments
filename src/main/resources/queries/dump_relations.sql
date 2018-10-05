SELECT
  (SELECT uid FROM nodes WHERE id = node.id) relation_uid,
  (SELECT uid FROM creators WHERE id = node.created_by) creator_uid,
  (SELECT label FROM relation_keys WHERE id = r."key") relation_label,
  (SELECT uid FROM nodes WHERE id = r.target) target_uid,
  (SELECT uid FROM nodes WHERE id = r.source) source_uid,
  (SELECT uid FROM graphs WHERE id = (SELECT graph FROM nodes WHERE id = node.id)) graph,
  (SELECT uid FROM graphs WHERE id = (SELECT graph FROM nodes WHERE id = source.id)) source_graph,
  (SELECT uid FROM graphs WHERE id = (SELECT graph FROM nodes WHERE id = target.id)) target_graph,
  node.created_on
FROM live_relations r
JOIN nodes node ON r.node = node.id
JOIN nodes source ON r.source = source.id
JOIN nodes target ON r.target = target.id
WHERE
(? or
  (? and node.graph = (SELECT id FROM graphs WHERE uid IS NULL)) or
  (node.graph IN (SELECT id FROM graphs WHERE uid = ANY (?))))
AND
(? or
  (? and source.graph = (SELECT id FROM graphs WHERE uid IS NULL)) or
  (source.graph IN (SELECT id FROM graphs WHERE uid = ANY (?))))
AND
(? or
  (? and target.graph = (SELECT id FROM graphs WHERE uid IS NULL)) or
  (target.graph IN (SELECT id FROM graphs WHERE uid = ANY (?))))
ORDER BY node.created_on ASC;
