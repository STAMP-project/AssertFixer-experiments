-- Add relation
INSERT INTO relations (node, source, key, target)
VALUES (
  (SELECT id from nodes WHERE uid=? AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM ?) AND deleted_by = -1),
  (SELECT id from nodes WHERE uid=? AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM ?) AND deleted_by = -1),
  (SELECT id from relation_keys WHERE label=?),
  (SELECT id from nodes WHERE uid=? AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM ?) AND deleted_by = -1)
);
