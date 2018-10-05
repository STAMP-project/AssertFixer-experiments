CREATE OR REPLACE FUNCTION getLiveAttributeForUid(original_uid text) RETURNS integer AS
$$
DECLARE
  result integer;
  previous_result integer;
BEGIN
  previous_result = attributes.id FROM attributes JOIN nodes ON nodes.id=attributes.node WHERE nodes.uid=original_uid;
  result = previous_result;

  WHILE result IS NOT NULL LOOP
    previous_result = result;
    result = replaced_by FROM replaced_attributes WHERE replaced = previous_result;
  END LOOP;

  RETURN previous_result;
END;
$$
LANGUAGE 'plpgsql' VOLATILE;


CREATE OR REPLACE FUNCTION getLiveRelationForUid(original_uid text) RETURNS integer AS
$$
DECLARE
  result integer;
  previous_result integer;
BEGIN
  previous_result = relations.id FROM relations JOIN nodes ON nodes.id=relations.node WHERE nodes.uid=original_uid;
  result = previous_result;

  WHILE result IS NOT NULL LOOP
    previous_result = result;
    result = replaced_by FROM replaced_relations WHERE replaced = previous_result;
  END LOOP;

  RETURN previous_result;
END;
$$
LANGUAGE 'plpgsql' VOLATILE;


