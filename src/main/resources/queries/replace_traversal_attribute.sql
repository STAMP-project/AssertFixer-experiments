-- Replace attribute
INSERT INTO replaced_attributes (node, replaced, replaced_by)
VALUES (
  (SELECT id from nodes WHERE uid=? AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM ?)),
  getLiveAttributeForUid(?, ?),
  (SELECT attributes.id FROM attributes JOIN nodes ON nodes.id=attributes.node WHERE nodes.uid=? AND graph = (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM ?))
);
