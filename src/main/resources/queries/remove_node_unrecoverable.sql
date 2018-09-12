-- Remove node
-- This is now a stored function, see the structure definition
-- sig: remove_node_unrecoverable(node_uid, graph_uid)
SELECT remove_node_unrecoverable(?, ?);
