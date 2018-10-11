ALTER SESSION SET CURRENT_SCHEMA = sigasr;

-- OS_FS0006 Itens 3: Alterando a tabela SR_ITEM_CONFIGURACAO para conter um novo campo
ALTER TABLE SR_ITEM_CONFIGURACAO ADD (
	DESCR_SIMILARIDADE CLOB
); 

-- OS_FS0006 Item 3: Criando tabela SR_GESTOR_ITEM para os Gestores do Item de Configura��o
CREATE TABLE SR_GESTOR_ITEM (
	ID_GESTOR_ITEM NUMBER(19, 0) NOT NULL, 
	ID_PESSOA NUMBER(19, 0), 
	ID_LOTACAO NUMBER(19, 0), 
	ID_ITEM_CONFIGURACAO NUMBER(19, 0) NOT NULL, 
	CONSTRAINT SR_GESTOR_ITEM_PK PRIMARY KEY (ID_GESTOR_ITEM) ENABLE 
);

-- Sequence para a tabela SR_GESTOR_ITEM
CREATE SEQUENCE SR_GESTOR_ITEM_SEQ 
	INCREMENT BY 1
	MAXVALUE 9999999999999999999999999999 
	MINVALUE 1 
	CACHE 20;
	
-- OS_FS0006 Item 1: Criando tabela SR_FATOR_MULTIPLICACAO para os Fatores do Item de Configura��o
CREATE TABLE SR_FATOR_MULTIPLICACAO (
  ID_FATOR_MULTIPLICACAO NUMBER(19, 0) NOT NULL,
  NUM_FATOR_MULTIPLICACAO NUMBER(19, 0) DEFAULT 1 NOT NULL,
  ID_PESSOA NUMBER(19, 0),
  ID_LOTACAO NUMBER(19, 0),
  ID_ITEM_CONFIGURACAO NUMBER(19, 0) NOT NULL,
  CONSTRAINT SR_FATOR_MULTIPLICACAO_PK PRIMARY KEY (ID_FATOR_MULTIPLICACAO) ENABLE 
);

-- OS_FS0006 Itens 1: Alterando a tabela SR_ITEM_CONFIGURACAO para conter um novo campo
ALTER TABLE SR_ITEM_CONFIGURACAO ADD (
	NUM_FATOR_MULTIPLICACAO_GERAL NUMBER(19) DEFAULT 1 NOT NULL
);

-- Sequence para a tabela SR_FATOR_MULTIPLICACAO
CREATE SEQUENCE SR_FATOR_MULTIPLICACAO_SEQ 
	INCREMENT BY 1 
	MAXVALUE 9999999999999999999999999999 
	MINVALUE 1 
	CACHE 20;

-- OS_FS0004 - Item 3: Alterando tabela para conter Tipo de Permissao 
alter table SR_CONFIGURACAO add TIPO_PERMISSAO number(2);
	
--DIA 2014-09-08
-- OS_FS0005 Item 9: Alterando a tabela SR_SOLICITACAO para conter um novo campo
ALTER TABLE SR_SOLICITACAO 
ADD (ID_SOLICITACAO_JUNTADA NUMBER(19, 0) );

-- OS_FS0005 Item 9: Inserindo na tabela SR_TIPO_MOVIMENTACAO para conter dois novos status
INSERT INTO "SIGASR"."SR_TIPO_MOVIMENTACAO" (ID_TIPO_MOVIMENTACAO, NOME_TIPO_MOVIMENTACAO) VALUES ('18', 'Junta � outra Solicita��o');
INSERT INTO "SIGASR"."SR_TIPO_MOVIMENTACAO" (ID_TIPO_MOVIMENTACAO, NOME_TIPO_MOVIMENTACAO) VALUES ('19', 'Juntou-se a esta Solicita��o');

--DIA 2014-09-11
-- OS_FS0005 Item 3: Alterando a tabela SR_SOLICITACAO para conter um novo campo
ALTER TABLE SR_SOLICITACAO 
ADD (ID_INTERLOCUTOR NUMBER(19, 0) );

--DIA 2014-09-13
-- OS_FS0005 Item 10: Inserindo na tabela SR_TIPO_MOVIMENTACAO para conter dois novos status
INSERT INTO "SIGASR"."SR_TIPO_MOVIMENTACAO" (ID_TIPO_MOVIMENTACAO, NOME_TIPO_MOVIMENTACAO) VALUES ('20', 'Vinculo de Solicita��o');

--DIA 2014-09-15
-- OS_FS0005 Item 10: Criando tabela SR_SOLICITACAO_VINCULO para as Solicita��es vinculadas na Solicita��o
CREATE TABLE SR_SOLICITACAO_VINCULO (
  ID_SOLICITACAO_VINCULO NUMBER(19, 0) NOT NULL,
  ID_SOLICITACAO_A NUMBER(19, 0) NOT NULL,
  ID_SOLICITACAO_B NUMBER(19, 0) NOT NULL,
  CONSTRAINT SR_SOLICITACAO_VINCULO_PK PRIMARY KEY (ID_SOLICITACAO_VINCULO) ENABLE 
); 

-- Sequence para a tabela SR_SOLICITACAO_VINCULO
CREATE SEQUENCE SR_SOLICITACAO_VINCULO_SEQ 
	INCREMENT BY 1 
	MAXVALUE 9999999999999999999999999999 
	MINVALUE 1 
	CACHE 20;

--DIA 2014-09-16
-- OS_FS0005 Item 8: Alterando a tabela SR_TIPO_ATRIBUTO para conter dois novos campos	
ALTER TABLE SR_TIPO_ATRIBUTO 
ADD (FORMATOCAMPO NUMBER(10, 0) );

ALTER TABLE SR_TIPO_ATRIBUTO 
ADD (DESCR_PRE_DEFINIDO VARCHAR2(255 CHAR) );

--DIA 2014-09-18
-- OS_FS0005 Item 10: Alterando a tabela SR_MOVIMENTACAO para conter um novo campo
ALTER TABLE SR_MOVIMENTACAO 
ADD (ID_SOLICITACAO_VINCULO NUMBER(19, 0) );

--DIA 2014-09-19
-- OS_FS0005 Item 06: Alterando a tabela SR_SOLICITACAO para conter um novo campo
ALTER TABLE SR_SOLICITACAO 
ADD (MEIOCOMUNICACAO NUMBER(10, 0) );

--DIA 2014-09-25
-- OS_FS0005 Item 15: Inserindo na tabela SR_TIPO_MOVIMENTACAO para conter um novo status
INSERT INTO "SIGASR"."SR_TIPO_MOVIMENTACAO" (ID_TIPO_MOVIMENTACAO, NOME_TIPO_MOVIMENTACAO) VALUES ('21', 'Replanejamento');

--DIA 2014-09-26
-- OS_FS0005 Item 01: Alterando a tabela SR_SOLICITACAO para conter um novo campo
ALTER TABLE SR_SOLICITACAO 
ADD (FG_RASCUNHO CHAR(1 CHAR) );

-- OS_FS0005 Item 01: Inserindo na tabela SR_TIPO_MOVIMENTACAO para conter um novo status
INSERT INTO "SIGASR"."SR_TIPO_MOVIMENTACAO" (ID_TIPO_MOVIMENTACAO, NOME_TIPO_MOVIMENTACAO) VALUES ('22', 'Em Elabora��o');

-- OS_FS0005 Item 01: Inserindo na tabela CP_MARCADOR para conter um novo status
INSERT INTO "CORPORATIVO"."CP_MARCADOR" (ID_MARCADOR, DESCR_MARCADOR, ID_TP_MARCADOR) VALUES ('61', 'Em Elabora��o', '1');

-- OS_FS0005 Item 01: Alterando a tabela SR_MOVIMENTACAO para permitir campo nulo
ALTER TABLE SR_MOVIMENTACAO  
MODIFY (ID_LOTA_ATENDENTE NULL);

--DIA 2014-09-29
-- OS_FS0005 Item 01: Inserindo na tabela SR_TIPO_MOVIMENTACAO para conter um novo status
INSERT INTO "SIGASR"."SR_TIPO_MOVIMENTACAO" (ID_TIPO_MOVIMENTACAO, NOME_TIPO_MOVIMENTACAO) VALUES ('23', 'Exclus�o');


-- OS_FS0006 - Item 5: Heran�a de designa��es 
create sequence SR_CONFIGURACAO_IGNORADA_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

-- OS_FS0006 - Item 5: Heran�a de designa��es - Cria��o da Tabela
create table SR_CONFIGURACAO_IGNORADA
(
  ID_CONFIGURACAO_IGNORADA NUMBER(19) not null,
  ID_ITEM_CONFIGURACAO     NUMBER(19) not null,
  ID_CONFIGURACAO          NUMBER(19) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

-- OS_FS0006 - Item 5: Heran�a de designa��es - Cria��o das constraints
alter table SR_CONFIGURACAO_IGNORADA
  add constraint PK_SR_CONFIG_IGNORADA primary key (ID_CONFIGURACAO_IGNORADA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
alter table SR_CONFIGURACAO_IGNORADA
  add constraint FK_CONF_IGN_CONFIGURACAO foreign key (ID_CONFIGURACAO)
  references SR_CONFIGURACAO (ID_CONFIGURACAO_SR);
alter table SR_CONFIGURACAO_IGNORADA
  add constraint FK_CONF_IGN_ITEM foreign key (ID_ITEM_CONFIGURACAO)
  references SR_ITEM_CONFIGURACAO (ID_ITEM_CONFIGURACAO);


-- OS_FS0005 Item 02: Alterando a tabela SR_SOLICITACAO para conter um novo campo
ALTER TABLE SR_SOLICITACAO 
ADD (DT_EDICAO_INI TIMESTAMP(6) );

--DIA 2014-09-30
-- OS_FS0005 Item 05: Alterando a tabela SR_MOVIMENTACAO para conter um novo campo
ALTER TABLE SR_MOVIMENTACAO 
ADD (MOTIVOPENDENCIA NUMBER(10, 0) );

--DIA 2014-10-01
-- OS_FS0005 Item 05: Alterando a tabela SR_MOVIMENTACAO para conter um novo campo
ALTER TABLE SR_MOVIMENTACAO 
ADD (ID_MOV_FINALIZADORA NUMBER(19, 0) );
