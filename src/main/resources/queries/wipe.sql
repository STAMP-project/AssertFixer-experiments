-- Wipe entire database
TRUNCATE "write_operations" CASCADE;
TRUNCATE "replaced_attributes" CASCADE;
TRUNCATE "replaced_relations" CASCADE;
TRUNCATE "attributes" CASCADE;
TRUNCATE "attribute_keys" CASCADE;
TRUNCATE "relations" CASCADE;
TRUNCATE "relation_keys" CASCADE;
TRUNCATE "nodes" CASCADE;
TRUNCATE "creators" CASCADE;
TRUNCATE "graphs" CASCADE;

ALTER SEQUENCE "creators_id_seq"            RESTART WITH 1;
ALTER SEQUENCE "write_operations_id_seq"    RESTART WITH 1;
ALTER SEQUENCE "replaced_nodes_id_seq"      RESTART WITH 1;
ALTER SEQUENCE "replaced_attributes_id_seq" RESTART WITH 1;
ALTER SEQUENCE "relations_id_seq"           RESTART WITH 1;
ALTER SEQUENCE "relation_keys_id_seq"       RESTART WITH 1;
ALTER SEQUENCE "nodes_id_seq"               RESTART WITH 1;
ALTER SEQUENCE "attributes_id_seq"          RESTART WITH 1;
ALTER SEQUENCE "attribute_keys_id_seq"      RESTART WITH 1;
ALTER SEQUENCE "graphs_id_seq"              RESTART WITH 2;

INSERT into graphs (id, uid) VALUES (1, NULL);
