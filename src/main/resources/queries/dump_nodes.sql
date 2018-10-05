SELECT n.uid node_uid, c.uid creator_uid, n.created_on created_on, g.uid graph
FROM live_individuals n, creators c, graphs g
WHERE n.created_by = c.id AND n.graph = g.id
ORDER BY created_on ASC;