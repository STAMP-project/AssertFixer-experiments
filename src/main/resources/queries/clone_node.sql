-- Clone node
-- This is a stored function, see the structure definition
-- sig: clone_node(source_node_uid, source_node_graph, target_node_id, target_node_graph, user_id, relationsToTraverse)
SELECT clone_node(?, ?, ?, ?, (SELECT id from creators WHERE uid=?), ?);
