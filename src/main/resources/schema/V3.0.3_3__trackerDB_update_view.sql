CREATE OR REPLACE VIEW "public"."trackerdb" AS SELECT
  row_number() over(order by individuals.id nulls last) as "seqnr",
  "datetime", "user", "action", "node", "key", "from", "to", "oldTo", "value"
  FROM
  (

    -- create-node
    SELECT
      nodes.id               as "id",
      nodes.created_on       as "datetime",
      nodes.created_by_uid   as "user",
      'create-node'          as "action",
      nodes.uid              as "node",
      NULL                   as "key",
      NULL                   as "from",
      NULL                   as "to",
      NULL                   as "oldTo",
      NULL                   as "value"

    FROM nodes_view as nodes

    WHERE TRUE

          -- Exclude relations and attributes
          AND nodes.id not in (select node from relations)
          AND nodes.id not in (select node from attributes)

          -- Exclude meta remove and replace nodes
          AND nodes.id not in (select node from removed_nodes)
          AND nodes.id not in (select node from replaced_attributes)
          AND nodes.id not in (select node from replaced_relations)

    UNION ALL


    -- remove-node
    SELECT
      rnv.meta_id            as "id",
      rnv.meta_created_on    as "datetime",
      rnv.meta_created_by    as "user",
      'remove-node'          as "action",
      rnv.removed_uid        as "node",
      NULL                   as "key",
      NULL                   as "from",
      NULL                   as "to",
      NULL                   as "oldTo",
      NULL                   as "value"

    FROM removed_nodes_view as rnv

    WHERE TRUE

          -- Exclude relations and attributes
          AND rnv.removed_node not in (select node from relations)
          AND rnv.removed_node not in (select node from attributes)

          -- Exclude meta remove and replace nodes
          AND rnv.removed_node not in (select node from removed_nodes)
          AND rnv.removed_node not in (select node from replaced_attributes)
          AND rnv.removed_node not in (select node from replaced_relations)

    UNION ALL


    -- create-attribute
    SELECT
      attributes.node         as "id",
      attributes.created_on   as "datetime",
      attributes.created_by   as "user",
      'create-attribute'      as "action",
      attributes.source_uid   as "node",
      attributes.key_label    as "key",
      NULL                    as "from",
      NULL                    as "to",
      NULL                    as "oldTo",
      COALESCE(
        attributes.string_value,
        attributes.double_value::text,
        to_char(attributes.datetime_value, 'YYYY-DD-MM HH24:MI:SS'),
        attributes.boolean_value::text
      ) as "value"

    FROM attributes_view as attributes

    WHERE TRUE
          AND attributes.id not in (SELECT replaced_by from replaced_attributes)


    UNION ALL


    -- remove-attribute
    SELECT
      rnv.meta_id            as "id",
      rnv.meta_created_on    as "datetime",
      rnv.meta_created_by    as "user",
      'remove-attribute'     as "action",
      attributes.source_uid  as "node",
      attributes.key_label   as "key",
      NULL                   as "from",
      NULL                   as "to",
      NULL                   as "oldTo",
      COALESCE(
        attributes.string_value,
        attributes.double_value::text,
        to_char(attributes.datetime_value, 'YYYY-DD-MM HH24:MI:SS'),
        attributes.boolean_value::text      ) as "value"

    FROM removed_nodes_view as rnv

      JOIN attributes_view attributes ON rnv.removed_node=attributes.node



    UNION ALL


    -- update-attribute
    SELECT
      attributes.node        as "id",
      attributes.created_on  as "datetime",
      attributes.created_by  as "user",
      'update-attribute'     as "action",
      attributes.source_uid  as "node",
      attributes.key_label   as "key",
      NULL                   as "from",
      NULL                   as "to",
      NULL                   as "oldTo",
      COALESCE(
        attributes.string_value,
        attributes.double_value::text,
        to_char(attributes.datetime_value, 'YYYY-DD-MM HH24:MI:SS'),
        attributes.boolean_value::text
      ) as "value"

    FROM attributes_view as attributes


    WHERE TRUE

          AND attributes.id in (SELECT replaced_by from replaced_attributes)


    UNION ALL


    -- create-relation
    SELECT
      relations.node         as "id",
      relations.created_on   as "datetime",
      relations.created_by   as "user",
      'create-relation'      as "action",
      relations.node_uid     as "node",
      relations.key_label    as "key",
      relations.source_uid   as "from",
      relations.target_uid   as "to",
      NULL                   as "oldTo",
      NULL                   as "value"

    FROM relations_view as relations

    WHERE TRUE
          AND relations.id not in (SELECT replaced_by from replaced_relations)


    UNION ALL

    -- remove-relation
    SELECT
      rnv.meta_id            as "id",
      rnv.meta_created_on    as "datetime",
      rnv.meta_created_by    as "user",
      'remove-relation'      as "action",
      relations.node_uid     as "node",
      relations.key_label    as "key",
      relations.source_uid   as "from",
      relations.target_uid   as "to",
      NULL                   as "oldTo",
      NULL                   as "value"

    FROM removed_nodes_view as rnv

      JOIN relations_view relations ON rnv.removed_node=relations.node


    UNION ALL

    -- update-relation
    SELECT
      relations.node          as "id",
      relations.created_on    as "datetime",
      relations.created_by    as "user",
      'update-relation'       as "action",
      relations.node_uid      as "node",
      relations.key_label     as "key",
      relations.source_uid    as "from",
      relations.target_uid    as "to",
      old_relations.node_uid  as "oldTo",
      NULL                    as "value"

    FROM relations_view as relations

      JOIN replaced_relations on replaced_relations.replaced_by=relations.id
      JOIN relations_view old_relations on old_relations.id=replaced_relations.replaced

  ) as individuals ORDER BY id;
