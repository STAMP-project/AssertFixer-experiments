CREATE OR REPLACE VIEW live_attributes AS
  SELECT * FROM attributes
  WHERE node NOT IN (SELECT removed_node FROM removed_nodes)
    AND id NOT IN (SELECT replaced FROM replaced_attributes);