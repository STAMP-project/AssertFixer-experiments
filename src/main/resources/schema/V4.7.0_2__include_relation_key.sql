DROP VIEW live_query_result;
DROP VIEW live_query_result_relations_view;
DROP VIEW live_query_result_attributes_view;
DROP VIEW live_query_result_nodes_view;

CREATE VIEW live_query_result_nodes_view AS
  SELECT nodes.id AS node_id,
    nodes.uid AS node_uid,
    ( SELECT graphs.uid
           FROM graphs
          WHERE graphs.id = nodes.graph) AS node_graph,
    nodes.created_on AS node_created,
    ( SELECT creators.uid
           FROM creators
          WHERE creators.id = nodes.created_by) AS node_created_by,
    NULL::text AS node_removed_by,
    NULL::text AS node_removed_by_graph,
    NULL::text AS property_uid,
    NULL::text AS property_graph,
    NULL::timestamp without time zone AS property_created,
    NULL::text AS property_creator,
    NULL::text AS key,
    NULL::double precision AS double_value,
    NULL::boolean AS boolean_value,
    NULL::timestamp without time zone AS datetime_value,
    NULL::text AS string_value,
    0 AS target_id,
    NULL::text AS target_uid,
    NULL::text AS target_graph,
    '1970-01-01 00:00:00'::timestamp without time zone AS target_created,
    NULL::text AS target_creator,
    NULL::text AS replaced_by,
    NULL::text AS replaced_by_graph,
    NULL::text AS property_removed_by,
    NULL::text AS property_removed_by_graph,
    rs.uid AS relation_source_uid,
    (SELECT graphs.uid FROM graphs WHERE graphs.id = rs.graph) AS relation_source_graph,
    rt.uid AS relation_target_uid,
    (SELECT graphs.uid FROM graphs WHERE graphs.id = rt.graph) AS relation_target_graph,
    (SELECT label FROM relation_keys WHERE relation_keys.id = relations.key) AS relation_key
  FROM live_individuals nodes
    LEFT JOIN relations ON relations.node = nodes.id
    LEFT JOIN nodes rs ON rs.id = relations.source
    LEFT JOIN nodes rt ON rt.id = relations.target;

CREATE VIEW live_query_result_attributes_view AS
 SELECT nodes.id AS node_id,
    NULL::text AS node_uid,
    NULL::text AS node_graph,
    NULL::timestamp without time zone AS node_created,
    NULL::text AS node_created_by,
    NULL::text AS node_removed_by,
    NULL::text AS node_removed_by_graph,
    attr_nodes.uid AS property_uid,
    ( SELECT graphs.uid
           FROM graphs
          WHERE graphs.id = attr_nodes.graph) AS property_graph,
    attr_nodes.created_on AS property_created,
    ( SELECT creators.uid
           FROM creators
          WHERE creators.id = attr_nodes.created_by) AS property_creator,
    ( SELECT attribute_keys.label
           FROM attribute_keys
          WHERE attribute_keys.id = attributes.key) AS key,
    attributes.double_value,
    attributes.boolean_value,
    attributes.datetime_value,
    attributes.string_value,
    NULL::integer AS target_id,
    NULL::text AS target_uid,
    NULL::text AS target_graph,
    '1970-01-01 00:00:00'::timestamp without time zone AS target_created,
    NULL::text AS target_creator,
    NULL::text AS replaced_by,
    NULL::text AS replaced_by_graph,
    NULL::text AS property_removed_by,
    NULL::text AS property_removed_by_graph,
    NULL::text AS relation_source_uid,
    NULL::text AS relation_source_graph,
    NULL::text AS relation_target_uid,
    NULL::text AS relation_target_graph,
    NULL::text AS relation_key
   FROM live_attributes attributes
     JOIN nodes ON nodes.id = attributes.source
     JOIN nodes attr_nodes ON attributes.node = attr_nodes.id;


CREATE VIEW live_query_result_relations_view AS
 SELECT nodes.id AS node_id,
    NULL::text AS node_uid,
    NULL::text AS node_graph,
    NULL::timestamp without time zone AS node_created,
    NULL::text AS node_created_by,
    NULL::text AS node_removed_by,
    NULL::text AS node_removed_by_graph,
    relation_nodes.uid AS property_uid,
    ( SELECT graphs.uid
           FROM graphs
          WHERE graphs.id = relation_nodes.graph) AS property_graph,
    relation_nodes.created_on AS property_created,
    ( SELECT c.uid
           FROM creators c
          WHERE c.id = relation_nodes.created_by) AS property_creator,
    ( SELECT k.label
           FROM relation_keys k
          WHERE k.id = relations.key) AS key,
    NULL::double precision AS double_value,
    NULL::boolean AS boolean_value,
    NULL::timestamp without time zone AS datetime_value,
    NULL::text AS string_value,
    relations.target AS target_id,
    target_nodes.uid AS target_uid,
    ( SELECT graphs.uid
           FROM graphs
          WHERE graphs.id = target_nodes.graph) AS target_graph,
    target_nodes.created_on AS target_created,
    ( SELECT c.uid
           FROM creators c
          WHERE c.id = target_nodes.created_by) AS target_creator,
    NULL::text AS replaced_by,
    NULL::text AS replaced_by_graph,
    NULL::text AS property_removed_by,
    NULL::text AS property_removed_by_graph,
    NULL::text AS relation_source_uid,
    NULL::text AS relation_source_graph,
    NULL::text AS relation_target_uid,
    NULL::text AS relation_target_graph,
    NULL::text AS relation_key
   FROM live_relations relations
     JOIN nodes ON nodes.id = relations.source
     JOIN nodes target_nodes ON target_nodes.id = relations.target
     JOIN nodes relation_nodes ON relations.node = relation_nodes.id;



CREATE VIEW live_query_result AS
SELECT live_query_result_nodes_view.node_id,
    live_query_result_nodes_view.node_uid,
    live_query_result_nodes_view.node_graph,
    live_query_result_nodes_view.node_created,
    live_query_result_nodes_view.node_created_by,
    live_query_result_nodes_view.node_removed_by,
    live_query_result_nodes_view.node_removed_by_graph,
    live_query_result_nodes_view.property_uid,
    live_query_result_nodes_view.property_graph,
    live_query_result_nodes_view.property_created,
    live_query_result_nodes_view.property_creator,
    live_query_result_nodes_view.key,
    live_query_result_nodes_view.double_value,
    live_query_result_nodes_view.boolean_value,
    live_query_result_nodes_view.datetime_value,
    live_query_result_nodes_view.string_value,
    live_query_result_nodes_view.target_id,
    live_query_result_nodes_view.target_uid,
    live_query_result_nodes_view.target_graph,
    live_query_result_nodes_view.target_created,
    live_query_result_nodes_view.target_creator,
    live_query_result_nodes_view.replaced_by,
    live_query_result_nodes_view.replaced_by_graph,
    live_query_result_nodes_view.property_removed_by,
    live_query_result_nodes_view.property_removed_by_graph,
    live_query_result_nodes_view.relation_source_uid,
    live_query_result_nodes_view.relation_source_graph,
    live_query_result_nodes_view.relation_target_uid,
    live_query_result_nodes_view.relation_target_graph,
    live_query_result_nodes_view.relation_key
   FROM live_query_result_nodes_view
UNION ALL
 SELECT live_query_result_attributes_view.node_id,
    live_query_result_attributes_view.node_uid,
    live_query_result_attributes_view.node_graph,
    live_query_result_attributes_view.node_created,
    live_query_result_attributes_view.node_created_by,
    live_query_result_attributes_view.node_removed_by,
    live_query_result_attributes_view.node_removed_by_graph,
    live_query_result_attributes_view.property_uid,
    live_query_result_attributes_view.property_graph,
    live_query_result_attributes_view.property_created,
    live_query_result_attributes_view.property_creator,
    live_query_result_attributes_view.key,
    live_query_result_attributes_view.double_value,
    live_query_result_attributes_view.boolean_value,
    live_query_result_attributes_view.datetime_value,
    live_query_result_attributes_view.string_value,
    live_query_result_attributes_view.target_id,
    live_query_result_attributes_view.target_uid,
    live_query_result_attributes_view.target_graph,
    live_query_result_attributes_view.target_created,
    live_query_result_attributes_view.target_creator,
    live_query_result_attributes_view.replaced_by,
    live_query_result_attributes_view.replaced_by_graph,
    live_query_result_attributes_view.property_removed_by,
    live_query_result_attributes_view.property_removed_by_graph,
    live_query_result_attributes_view.relation_source_uid,
    live_query_result_attributes_view.relation_source_graph,
    live_query_result_attributes_view.relation_target_uid,
    live_query_result_attributes_view.relation_target_graph,
    live_query_result_attributes_view.relation_key
   FROM live_query_result_attributes_view
UNION ALL
 SELECT live_query_result_relations_view.node_id,
    live_query_result_relations_view.node_uid,
    live_query_result_relations_view.node_graph,
    live_query_result_relations_view.node_created,
    live_query_result_relations_view.node_created_by,
    live_query_result_relations_view.node_removed_by,
    live_query_result_relations_view.node_removed_by_graph,
    live_query_result_relations_view.property_uid,
    live_query_result_relations_view.property_graph,
    live_query_result_relations_view.property_created,
    live_query_result_relations_view.property_creator,
    live_query_result_relations_view.key,
    live_query_result_relations_view.double_value,
    live_query_result_relations_view.boolean_value,
    live_query_result_relations_view.datetime_value,
    live_query_result_relations_view.string_value,
    live_query_result_relations_view.target_id,
    live_query_result_relations_view.target_uid,
    live_query_result_relations_view.target_graph,
    live_query_result_relations_view.target_created,
    live_query_result_relations_view.target_creator,
    live_query_result_relations_view.replaced_by,
    live_query_result_relations_view.replaced_by_graph,
    live_query_result_relations_view.property_removed_by,
    live_query_result_relations_view.property_removed_by_graph,
    live_query_result_relations_view.relation_source_uid,
    live_query_result_relations_view.relation_source_graph,
    live_query_result_relations_view.relation_target_uid,
    live_query_result_relations_view.relation_target_graph,
    live_query_result_relations_view.relation_key
   FROM live_query_result_relations_view;
