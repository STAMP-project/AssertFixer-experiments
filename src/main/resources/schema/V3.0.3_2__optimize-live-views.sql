CREATE OR REPLACE VIEW live_individuals AS
  SELECT * FROM nodes
  WHERE
    NOT EXISTS (SELECT 1 FROM attributes WHERE node = id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM relations WHERE node = id LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM removed_nodes WHERE removed_node = id LIMIT 1);

CREATE OR REPLACE VIEW live_attributes AS
  SELECT * FROM attributes
  WHERE
    NOT EXISTS (SELECT 1 FROM removed_nodes WHERE removed_node = node LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM replaced_attributes WHERE id = replaced LIMIT 1);

CREATE OR REPLACE VIEW live_relations AS
  SELECT * FROM relations
  WHERE
    NOT EXISTS (SELECT 1 FROM removed_nodes WHERE removed_node = node LIMIT 1)
    AND NOT EXISTS (SELECT 1 FROM replaced_relations WHERE id = replaced LIMIT 1);
