SELECT
  (SELECT uid FROM nodes WHERE id = node.id) attribute_uid,
  (SELECT label FROM attribute_keys WHERE id = a."key") attribute_label,
  (SELECT uid FROM creators WHERE id = node.created_by) creator_uid,
  (SELECT uid FROM nodes WHERE id = a.source) source_uid,
  (SELECT uid FROM graphs WHERE id = (SELECT graph FROM nodes WHERE id = node.id)) graph,
  (SELECT uid FROM graphs WHERE id = (SELECT graph FROM nodes WHERE id = source.id)) source_graph,
  node.created_on,
  a.double_value,
  a.string_value,
  a.boolean_value,
  a.datetime_value,
  a.datatype
FROM live_attributes a
JOIN nodes node ON a.node = node.id
JOIN nodes source ON a.source = source.id
WHERE
(? or
  (? and node.graph = (SELECT id FROM graphs WHERE uid IS NULL)) or
  (node.graph IN (SELECT id FROM graphs WHERE uid = ANY (?))))
AND
(? or
  (? and source.graph = (SELECT id FROM graphs WHERE uid IS NULL)) or
  (source.graph IN (SELECT id FROM graphs WHERE uid = ANY (?))))
ORDER BY node.created_on ASC;
