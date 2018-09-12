-- Check if a node was removed
SELECT * FROM nodes WHERE deleted_by = ? AND id = ?;
