--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: pg_trgm; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS pg_trgm WITH SCHEMA public;


--
-- Name: EXTENSION pg_trgm; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION pg_trgm IS 'text similarity measurement and index searching based on trigrams';


SET search_path = public, pg_catalog;

--
-- Name: attribute_keys_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE attribute_keys_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE attribute_keys_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: attribute_keys; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE attribute_keys (
    id integer DEFAULT nextval('attribute_keys_id_seq'::regclass) NOT NULL,
    label text NOT NULL
);


ALTER TABLE attribute_keys OWNER TO postgres;

--
-- Name: attributes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE attributes (
    id integer NOT NULL,
    node integer NOT NULL,
    source integer NOT NULL,
    key integer NOT NULL,
    double_value double precision,
    string_value text,
    boolean_value boolean,
    datetime_value timestamp without time zone
);


ALTER TABLE attributes OWNER TO postgres;

--
-- Name: attributes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE attributes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE attributes_id_seq OWNER TO postgres;

--
-- Name: attributes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE attributes_id_seq OWNED BY attributes.id;


--
-- Name: creators_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE creators_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE creators_id_seq OWNER TO postgres;

--
-- Name: creators; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE creators (
    id integer DEFAULT nextval('creators_id_seq'::regclass) NOT NULL,
    uid text NOT NULL
);


ALTER TABLE creators OWNER TO postgres;

--
-- Name: nodes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE nodes (
    id integer NOT NULL,
    uid text NOT NULL,
    created_on timestamp without time zone NOT NULL,
    created_by integer NOT NULL
);


ALTER TABLE nodes OWNER TO postgres;

--
-- Name: nodes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE nodes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE nodes_id_seq OWNER TO postgres;

--
-- Name: nodes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE nodes_id_seq OWNED BY nodes.id;


--
-- Name: relation_keys_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE relation_keys_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE relation_keys_id_seq OWNER TO postgres;

--
-- Name: relation_keys; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE relation_keys (
    id integer DEFAULT nextval('relation_keys_id_seq'::regclass) NOT NULL,
    label text NOT NULL
);


ALTER TABLE relation_keys OWNER TO postgres;

--
-- Name: relations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE relations (
    id integer NOT NULL,
    node integer NOT NULL,
    source integer NOT NULL,
    key integer NOT NULL,
    target integer NOT NULL
);


ALTER TABLE relations OWNER TO postgres;

--
-- Name: relations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE relations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE relations_id_seq OWNER TO postgres;

--
-- Name: relations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE relations_id_seq OWNED BY relations.node;


--
-- Name: relations_id_seq1; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE relations_id_seq1
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE relations_id_seq1 OWNER TO postgres;

--
-- Name: relations_id_seq1; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE relations_id_seq1 OWNED BY relations.id;


--
-- Name: removed_nodes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE removed_nodes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE removed_nodes_id_seq OWNER TO postgres;

--
-- Name: removed_nodes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE removed_nodes (
    id integer DEFAULT nextval('removed_nodes_id_seq'::regclass) NOT NULL,
    node integer NOT NULL,
    removed_node integer NOT NULL
);


ALTER TABLE removed_nodes OWNER TO postgres;

--
-- Name: replaced_attributes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE replaced_attributes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE replaced_attributes_id_seq OWNER TO postgres;

--
-- Name: replaced_attributes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE replaced_attributes (
    id integer DEFAULT nextval('replaced_attributes_id_seq'::regclass) NOT NULL,
    node integer NOT NULL,
    replaced integer NOT NULL,
    replaced_by integer NOT NULL
);


ALTER TABLE replaced_attributes OWNER TO postgres;

--
-- Name: replaced_nodes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE replaced_nodes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE replaced_nodes_id_seq OWNER TO postgres;

--
-- Name: replaced_relations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE replaced_relations (
    id integer DEFAULT nextval('replaced_nodes_id_seq'::regclass) NOT NULL,
    node integer NOT NULL,
    replaced integer NOT NULL,
    replaced_by integer NOT NULL
);


ALTER TABLE replaced_relations OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY creators.id;


--
-- Name: write_operations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE write_operations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE write_operations_id_seq OWNER TO postgres;

--
-- Name: write_operations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE write_operations (
    id integer DEFAULT nextval('write_operations_id_seq'::regclass) NOT NULL,
    created_on timestamp without time zone DEFAULT now(),
    created_by integer NOT NULL,
    operation jsonb NOT NULL
);


ALTER TABLE write_operations OWNER TO postgres;

--
-- Name: attributes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY attributes ALTER COLUMN id SET DEFAULT nextval('attributes_id_seq'::regclass);


--
-- Name: nodes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY nodes ALTER COLUMN id SET DEFAULT nextval('nodes_id_seq'::regclass);


--
-- Name: relations id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relations ALTER COLUMN id SET DEFAULT nextval('relations_id_seq'::regclass);


--
-- Data for Name: attribute_keys; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: attribute_keys_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('attribute_keys_id_seq', 1, false);


--
-- Data for Name: attributes; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: attributes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('attributes_id_seq', 1, false);


--
-- Data for Name: creators; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: creators_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('creators_id_seq', 1, false);


--
-- Data for Name: nodes; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: nodes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('nodes_id_seq', 1, false);


--
-- Data for Name: relation_keys; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: relation_keys_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('relation_keys_id_seq', 1, false);


--
-- Data for Name: relations; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: relations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('relations_id_seq', 1, false);


--
-- Name: relations_id_seq1; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('relations_id_seq1', 1, false);


--
-- Data for Name: removed_nodes; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: removed_nodes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('removed_nodes_id_seq', 1, false);


--
-- Data for Name: replaced_attributes; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: replaced_attributes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('replaced_attributes_id_seq', 1, false);


--
-- Name: replaced_nodes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('replaced_nodes_id_seq', 1, false);


--
-- Data for Name: replaced_relations; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 2, true);


--
-- Data for Name: write_operations; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- Name: write_operations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('write_operations_id_seq', 1, false);


--
-- Name: attribute_keys attribute_keys_label_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY attribute_keys
    ADD CONSTRAINT attribute_keys_label_key UNIQUE (label);


--
-- Name: attribute_keys attribute_keys_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY attribute_keys
    ADD CONSTRAINT attribute_keys_pkey PRIMARY KEY (id);


--
-- Name: attributes attributes_node_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY attributes
    ADD CONSTRAINT attributes_node_key UNIQUE (node);


--
-- Name: attributes attributes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY attributes
    ADD CONSTRAINT attributes_pkey PRIMARY KEY (id);


--
-- Name: creators creators_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY creators
    ADD CONSTRAINT creators_pkey PRIMARY KEY (id);


--
-- Name: creators creators_uid_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY creators
    ADD CONSTRAINT creators_uid_key UNIQUE (uid);


--
-- Name: nodes nodes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY nodes
    ADD CONSTRAINT nodes_pkey PRIMARY KEY (id);


--
-- Name: nodes nodes_uid_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY nodes
    ADD CONSTRAINT nodes_uid_key UNIQUE (uid);


--
-- Name: relation_keys relation_keys_label_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relation_keys
    ADD CONSTRAINT relation_keys_label_key UNIQUE (label);


--
-- Name: relation_keys relation_keys_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relation_keys
    ADD CONSTRAINT relation_keys_pkey PRIMARY KEY (id);


--
-- Name: relations relations_node_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relations
    ADD CONSTRAINT relations_node_key UNIQUE (node);


--
-- Name: relations relations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relations
    ADD CONSTRAINT relations_pkey PRIMARY KEY (id);

--
-- Name: removed_nodes removed_nodes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY removed_nodes
    ADD CONSTRAINT removed_nodes_pkey PRIMARY KEY (id);


--
-- Name: removed_nodes removed_nodes_removed_node_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY removed_nodes
    ADD CONSTRAINT removed_nodes_removed_node_key UNIQUE (removed_node);


--
-- Name: replaced_attributes replaced_attributes_node_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_attributes
    ADD CONSTRAINT replaced_attributes_node_key UNIQUE (node);


--
-- Name: replaced_attributes replaced_attributes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_attributes
    ADD CONSTRAINT replaced_attributes_pkey PRIMARY KEY (id);


--
-- Name: replaced_attributes replaced_attributes_replaced_by_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_attributes
    ADD CONSTRAINT replaced_attributes_replaced_by_key UNIQUE (replaced_by);


--
-- Name: replaced_attributes replaced_attributes_replaced_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_attributes
    ADD CONSTRAINT replaced_attributes_replaced_key UNIQUE (replaced);


--
-- Name: replaced_relations replaced_nodes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_relations
    ADD CONSTRAINT replaced_nodes_pkey PRIMARY KEY (id);


--
-- Name: replaced_relations replaced_relations_node_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_relations
    ADD CONSTRAINT replaced_relations_node_key UNIQUE (node);


--
-- Name: replaced_relations replaced_relations_replaced_by_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_relations
    ADD CONSTRAINT replaced_relations_replaced_by_key UNIQUE (replaced_by);


--
-- Name: replaced_relations replaced_relations_replaced_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_relations
    ADD CONSTRAINT replaced_relations_replaced_key UNIQUE (replaced);


--
-- Name: write_operations write_operations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY write_operations
    ADD CONSTRAINT write_operations_pkey PRIMARY KEY (id);


--
-- Name: attributes_boolean_value_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX attributes_boolean_value_idx ON attributes USING btree (boolean_value);


--
-- Name: attributes_datetime_value_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX attributes_datetime_value_idx ON attributes USING btree (datetime_value);


--
-- Name: attributes_double_value_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX attributes_double_value_idx ON attributes USING btree (double_value);


--
-- Name: attributes_key_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX attributes_key_idx ON attributes USING btree (key);


--
-- Name: attributes_source_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX attributes_source_idx ON attributes USING btree (source);


--
-- Name: attributes_string_value_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX attributes_string_value_idx ON attributes USING gin (string_value gin_trgm_ops);


--
-- Name: nodes_created_by_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX nodes_created_by_idx ON nodes USING btree (created_by);


--
-- Name: nodes_created_on_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX nodes_created_on_idx ON nodes USING btree (created_on);


--
-- Name: relations_key_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX relations_key_idx ON relations USING btree (key);


--
-- Name: relations_source_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX relations_source_idx ON relations USING btree (source);


--
-- Name: relations_target_idx; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX relations_target_idx ON relations USING btree (target);


--
-- Name: attributes attributes_key_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY attributes
    ADD CONSTRAINT attributes_key_fkey FOREIGN KEY (key) REFERENCES attribute_keys(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: attributes attributes_node_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY attributes
    ADD CONSTRAINT attributes_node_fkey FOREIGN KEY (node) REFERENCES nodes(id);


--
-- Name: attributes attributes_source_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY attributes
    ADD CONSTRAINT attributes_source_fkey FOREIGN KEY (source) REFERENCES nodes(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: nodes nodes_created_by_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY nodes
    ADD CONSTRAINT nodes_created_by_fkey FOREIGN KEY (created_by) REFERENCES creators(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: relations relations_key_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relations
    ADD CONSTRAINT relations_key_fkey FOREIGN KEY (key) REFERENCES relation_keys(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: relations relations_node_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relations
    ADD CONSTRAINT relations_node_fkey FOREIGN KEY (node) REFERENCES nodes(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: relations relations_source_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relations
    ADD CONSTRAINT relations_source_fkey FOREIGN KEY (source) REFERENCES nodes(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: relations relations_target_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY relations
    ADD CONSTRAINT relations_target_fkey FOREIGN KEY (target) REFERENCES nodes(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: removed_nodes removed_nodes_node_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY removed_nodes
    ADD CONSTRAINT removed_nodes_node_fkey FOREIGN KEY (node) REFERENCES nodes(id);


--
-- Name: removed_nodes removed_nodes_removed_node_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY removed_nodes
    ADD CONSTRAINT removed_nodes_removed_node_fkey FOREIGN KEY (removed_node) REFERENCES nodes(id);


--
-- Name: replaced_attributes replaced_attributes_node_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_attributes
    ADD CONSTRAINT replaced_attributes_node_fkey FOREIGN KEY (node) REFERENCES nodes(id);


--
-- Name: replaced_attributes replaced_attributes_replaced_by_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_attributes
    ADD CONSTRAINT replaced_attributes_replaced_by_fkey FOREIGN KEY (replaced_by) REFERENCES attributes(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: replaced_attributes replaced_attributes_replaced_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_attributes
    ADD CONSTRAINT replaced_attributes_replaced_fkey FOREIGN KEY (replaced) REFERENCES attributes(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- Name: replaced_relations replaced_relations_node_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_relations
    ADD CONSTRAINT replaced_relations_node_fkey FOREIGN KEY (node) REFERENCES nodes(id);


--
-- Name: replaced_relations replaced_relations_replaced_by_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_relations
    ADD CONSTRAINT replaced_relations_replaced_by_fkey FOREIGN KEY (replaced_by) REFERENCES relations(id);


--
-- Name: replaced_relations replaced_relations_replaced_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY replaced_relations
    ADD CONSTRAINT replaced_relations_replaced_fkey FOREIGN KEY (replaced) REFERENCES relations(id);


--
-- Name: write_operations write_operations_created_by_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY write_operations
    ADD CONSTRAINT write_operations_created_by_fkey FOREIGN KEY (created_by) REFERENCES creators(id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- PostgreSQL database dump complete
--


--
-- Handcrafted things by gijs
--

CREATE VIEW live_individuals AS
  SELECT * FROM nodes
  WHERE
    id NOT IN (SELECT node FROM attributes)
    AND id NOT IN (SELECT node FROM relations)
    AND id NOT IN (SELECT removed_node FROM removed_nodes);

CREATE VIEW live_attributes AS
  SELECT * FROM attributes
  WHERE node NOT IN (SELECT removed_node FROM removed_nodes)
    AND id NOT IN (SELECT replaced FROM replaced_attributes);

CREATE VIEW live_relations AS
  SELECT * FROM relations
  WHERE node NOT IN (SELECT removed_node FROM removed_nodes)
    AND id NOT IN (SELECT replaced FROM replaced_relations);


CREATE OR REPLACE FUNCTION remove_node(remove_node_uid text, removed_node_uid text) RETURNS integer AS
$$
DECLARE
  current_count integer;
  previous_count integer;
BEGIN
  previous_count = 0;

  CREATE TEMP TABLE to_remove AS
    SELECT id FROM nodes
    WHERE uid=removed_node_uid AND id NOT IN (SELECT removed_node FROM removed_nodes);

  current_count = count(*) FROM to_remove;

  WHILE current_count > previous_count LOOP
    previous_count = current_count;

    INSERT INTO to_remove
    SELECT node
    FROM live_attributes
    WHERE source IN (SELECT id FROM to_remove)
      AND node NOT IN (SELECT id FROM to_remove);

    INSERT INTO to_remove
    SELECT node
    FROM live_relations
    WHERE source IN (SELECT id FROM to_remove)
      AND node NOT IN (SELECT id FROM to_remove);

    INSERT INTO to_remove
    SELECT node
    FROM live_relations
    WHERE target IN (SELECT id FROM to_remove)
      AND node NOT IN (SELECT id FROM to_remove);

    current_count = count(*) FROM to_remove;
  END LOOP;


  INSERT INTO removed_nodes (node, removed_node)
    SELECT DISTINCT (SELECT id FROM nodes WHERE uid = remove_node_uid), id
    FROM to_remove
  ;

  DROP TABLE to_remove;

  RETURN current_count;
END;
$$

LANGUAGE 'plpgsql' VOLATILE;


CREATE VIEW "public"."nodes_view" AS   SELECT
 nodes.*,
 creators.uid as created_by_uid
FROM nodes

JOIN creators ON nodes.created_by=creators.id;


CREATE VIEW "public"."removed_nodes_view" AS SELECT
   meta.id  			AS meta_id,
   meta.uid 			AS meta_uid,
   meta.created_ON 	AS meta_created_ON,
   meta_creators.uid AS meta_created_by,

   removed.id  			AS removed_node,
   removed.uid 			AS removed_uid,
   removed.created_ON 	AS removed_created_ON,
   removed_creators.uid 	AS removed_created_by

  FROM removed_nodes

  JOIN nodes    meta             ON meta.id=removed_nodes.node
  JOIN creators meta_creators    ON meta_creators.id=meta.created_by
  JOIN nodes    removed          ON removed.id=removed_nodes.removed_node
  JOIN creators removed_creators ON removed_creators.id=removed.created_by;


CREATE VIEW "public"."attributes_view" AS SELECT
  attributes.id,
  attributes.node,
  nodes.uid as node_uid,
  nodes.created_on as created_on,
  creators.uid as created_by,
  attributes.source,
  source_nodes.uid as source_uid,
  attributes.key,
  attribute_keys.label as key_label,
  attributes.double_value,
  attributes.string_value,
  attributes.boolean_value,
  attributes.datetime_value

  FROM attributes

  JOIN nodes on nodes.id=node
  JOIN creators on nodes.created_by=creators.id
  JOIN nodes source_nodes on source_nodes.id=source
  JOIN attribute_keys on attribute_keys.id=key;


CREATE VIEW "public"."relations_view" AS SELECT

 relations.id,
 relations.node,
 relation_nodes.uid as node_uid,
 relation_nodes.created_on as created_on,
 relation_nodes.created_by_uid as created_by,

 relations.source,
 source_nodes.uid as source_uid,
 source_nodes.created_on as source_created_on,
 source_nodes.created_by_uid as source_created_by_uid,


 relations.key,
 relation_keys.label as key_label,

 relations.target,
 target_nodes.uid as target_uid,
 target_nodes.created_on as target_created_on,
 target_nodes.created_by_uid as target_created_by_uid

  FROM relations

 JOIN nodes_view relation_nodes on relation_nodes.id=node
 JOIN nodes_view source_nodes   on source_nodes.id=source
 JOIN nodes_view target_nodes   on target_nodes.id=target
 JOIN relation_keys             on relation_keys.id=key;

CREATE VIEW "public"."trackerdb" AS SELECT
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
      'create-relation'       as "action",
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

