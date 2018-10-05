SELECT n.uid node_uid, c.uid creator_uid, n.created_on created_on, g.uid graph
FROM live_individuals n, creators c, graphs g
WHERE
n.created_by = c.id and
n.graph = g.id and
(
  (? and n.graph = (SELECT id FROM graphs WHERE uid IS NULL)) or
  (n.graph IN (SELECT id FROM graphs WHERE uid = ANY (?)))
)
ORDER BY created_on ASC;
