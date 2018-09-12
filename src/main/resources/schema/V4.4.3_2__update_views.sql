CREATE OR REPLACE VIEW live_individuals AS
SELECT n.id,
    n.uid,
    n.created_on,
    n.created_by,
    n.graph
   FROM nodes n
     LEFT JOIN attributes a ON a.node = n.id
     LEFT JOIN relations r ON r.node = n.id
     LEFT JOIN replaced_attributes ra ON ra.node = n.id
     LEFT JOIN replaced_relations rr ON rr.node = n.id
   WHERE n.deleted_by = -1
     AND a.node IS NULL
     AND r.node IS NULL
     AND rr.node IS NULL
     AND ra.node IS NULL
;

CREATE OR REPLACE VIEW live_attributes AS
 SELECT a.id,
    a.node,
    a.source,
    a.key,
    a.double_value,
    a.string_value,
    a.boolean_value,
    a.datetime_value,
    a.datatype
   FROM attributes a
     LEFT JOIN nodes an ON a.node = an.id
     LEFT JOIN replaced_attributes ra ON ra.replaced = a.id
   WHERE
     an.deleted_by = -1
     AND ra.replaced IS NULL
;

CREATE OR REPLACE VIEW live_relations AS
 SELECT e.id,
    e.node,
    e.source,
    e.key,
    e.target
  FROM relations e
    LEFT JOIN nodes ne ON ne.id = e.node
    LEFT JOIN replaced_relations re ON re.replaced = e.id
  WHERE
    ne.deleted_by = -1
    AND re.replaced IS NULL
;
