-- Add node
INSERT INTO nodes
  (uid, created_on, created_by, graph) VALUES
  (?,
   ?,
   (SELECT id FROM creators WHERE uid=?),
   (SELECT id FROM graphs WHERE uid IS NOT DISTINCT FROM ?)
  );
