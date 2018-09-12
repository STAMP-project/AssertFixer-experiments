-- List some relation
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
  relation_keys AS (
    SELECT id
    FROM "relation_keys"
    WHERE label=?
  )
  SELECT node.id, source.id, relation_keys.id
  FROM node, source, relation_keys;