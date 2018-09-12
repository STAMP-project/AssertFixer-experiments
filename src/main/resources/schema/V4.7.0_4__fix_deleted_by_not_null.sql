INSERT INTO creators (uid) VALUES ('database-changes') ON CONFLICT DO NOTHING;
INSERT INTO NODES (uid, created_on, created_by) VALUES ('dbChange$4.7.0_4', NOW(), (SELECT id FROM creators WHERE uid = 'database-changes'));

UPDATE nodes SET deleted_by = LASTVAL() WHERE deleted_by IS NULL;

ALTER TABLE nodes
  ALTER COLUMN deleted_by SET NOT NULL;
