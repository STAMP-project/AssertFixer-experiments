

CREATE TABLE empresa (
    id bigint NOT NULL,
    cnpj character varying(255) NOT NULL,
    data_atualizacao timestamp without time zone NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    razao_social character varying(255) NOT NULL
);


CREATE SEQUENCE empresa_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE funcionario (
    id bigint NOT NULL,
    cpf character varying(255) NOT NULL,
    data_atualizacao timestamp without time zone NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    email character varying(255) NOT NULL,
    nome character varying(255) NOT NULL,
    perfil character varying(255) NOT NULL,
    qtd_horas_almoco real,
    qtd_horas_trabalho_dia real,
    senha character varying(255) NOT NULL,
    valor_hora numeric(19,2),
    empresa_id bigint
);


CREATE SEQUENCE funcionario_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


CREATE TABLE lancamento (
    id bigint NOT NULL,
    data timestamp without time zone NOT NULL,
    data_atualizacao timestamp without time zone NOT NULL,
    data_criacao timestamp without time zone NOT NULL,
    descricao character varying(255),
    localizacao character varying(255),
    tipo character varying(255) NOT NULL,
    funcionario_id bigint
);


CREATE SEQUENCE lancamento_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE ONLY empresa
    ADD CONSTRAINT empresa_pkey PRIMARY KEY (id);

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id);

ALTER TABLE ONLY lancamento
    ADD CONSTRAINT lancamento_pkey PRIMARY KEY (id);

ALTER TABLE ONLY lancamento
    ADD CONSTRAINT fk_func_lancamento FOREIGN KEY (funcionario_id) REFERENCES funcionario(id);

ALTER TABLE ONLY funcionario
    ADD CONSTRAINT fk_func_empresa FOREIGN KEY (empresa_id) REFERENCES empresa(id);
