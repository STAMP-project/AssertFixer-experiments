-- Create a removal node for this changeset
INSERT INTO creators (uid) VALUES ('database-changes');
INSERT INTO NODES (uid, created_on, created_by) VALUES ('dbChange$4.6.0_1', NOW(), (SELECT id FROM creators WHERE uid = 'database-changes'));

-- Select the nodes of the duplicate attributes to remove (all the earliest)
CREATE TEMPORARY VIEW attribute_duplicate_removal AS
  SELECT
    la.node
  FROM (
    SELECT source, key, count(*)
    FROM live_attributes
    GROUP BY source, key
    HAVING count(*) > 1
  ) a JOIN live_attributes la ON la.source = a.source AND la.key = a.key
  GROUP BY la.node, a.source, a.key
  HAVING la.node != (SELECT MAX(node) FROM live_attributes la1 WHERE a.source = la1.source AND a.key = la1.key)
;

-- Perform the delete
UPDATE nodes SET deleted_by = LASTVAL()
WHERE id IN (SELECT * FROM attribute_duplicate_removal)
;

-- This checks that a live attribute does not currently exist, and will give an
-- error if it does
CREATE OR REPLACE FUNCTION allow_insert()
RETURNS trigger
LANGUAGE plpgsql
AS $function$
BEGIN
  IF (SELECT COUNT(*) FROM live_attributes WHERE source = NEW.source AND key = NEW.key) > 1 THEN
    RAISE EXCEPTION 'Attribute already exists';
  END IF;

  RETURN NEW;
END;
$function$
;

CREATE CONSTRAINT TRIGGER check_attribute_uniqueness
  AFTER INSERT
  ON attributes
  INITIALLY DEFERRED
  FOR EACH ROW
  EXECUTE PROCEDURE allow_insert()
;

