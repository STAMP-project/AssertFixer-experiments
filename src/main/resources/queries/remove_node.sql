-- Remove node
UPDATE nodes SET deleted_by = (SELECT id FROM nodes WHERE uid=? AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM ?) AND deleted_by = -1)
WHERE id = (SELECT id FROM nodes WHERE uid=? AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM ?) AND deleted_by = -1)
;
