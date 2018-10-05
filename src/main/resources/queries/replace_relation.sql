-- Replace relation
INSERT INTO replaced_relations (node, replaced, replaced_by)
VALUES (
  (SELECT id from nodes WHERE uid=? AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM ?)),
  (SELECT relations.id FROM relations JOIN nodes ON nodes.id=relations.node WHERE nodes.uid=? AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM ?)),
  (SELECT relations.id FROM relations JOIN nodes ON nodes.id=relations.node WHERE nodes.uid=? AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM ?))
);
