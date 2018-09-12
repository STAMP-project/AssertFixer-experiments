-- List some attribute
WITH
  node AS (
    SELECT id
    FROM "nodes"
    WHERE uid=?
  ),
  source AS (
    SELECT id
    FROM "nodes"
    WHERE uid=?
  ),
  attribute_key AS (
    SELECT id
    FROM "attribute_keys"
    WHERE label=?
  )
  SELECT node.id, source.id, attribute_key.id, attributes.double_value, attributes.string_value, attributes.boolean_value, attributes.datetime_value
  FROM node, source, attribute_key, attributes WHERE attributes.node = node.id;