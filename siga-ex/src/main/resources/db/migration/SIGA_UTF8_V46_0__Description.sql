--------------------------------------------------------------------------
--	SCRIPT: Corrigir erro na geração dos dados da tabela EX_CLASSIFICAÇÂO
--------------------------------------------------------------------------

update SIGA.EX_CLASSIFICACAO SET CODIFICACAO = '00.00.00.00' where ID_CLASSIFICACAO = 1;
update SIGA.EX_CLASSIFICACAO SET CODIFICACAO = '00.01.00.00' where ID_CLASSIFICACAO = 2;
update SIGA.EX_CLASSIFICACAO SET DESCR_CLASSIFICACAO = 'ORGANIZAÇÃO ADMINISTRATIVA', CODIFICACAO = '00.01.01.00' where ID_CLASSIFICACAO = 3;
update SIGA.EX_CLASSIFICACAO SET CODIFICACAO = '00.01.01.01' where ID_CLASSIFICACAO = 4;
Insert into SIGA.EX_CLASSIFICACAO (ID_CLASSIFICACAO, DESCR_CLASSIFICACAO, HIS_ID_INI, HIS_DT_INI, HIS_ATIVO, CODIFICACAO) values (5, 'FISCALIZAÇÃO CONTÁBIL, FINANCEIRA, ORÇAMENTÁRIA', 5, to_date('13/03/09','DD/MM/RR'), 1, '00.06.00.00');
Insert into SIGA.EX_CLASSIFICACAO (ID_CLASSIFICACAO, DESCR_CLASSIFICACAO, HIS_ID_INI, HIS_DT_INI, HIS_ATIVO, CODIFICACAO) values (6, 'AUDITORIA', 6, to_date('13/03/09','DD/MM/RR'), 1, '00.06.01.00');
Insert into SIGA.EX_CLASSIFICACAO (ID_CLASSIFICACAO, DESCR_CLASSIFICACAO, HIS_ID_INI, HIS_DT_INI, HIS_ATIVO, CODIFICACAO) values (7, 'Auditoria externa', 7, to_date('13/03/09','DD/MM/RR'), 1, '00.06.01.01');
Insert into SIGA.EX_CLASSIFICACAO (ID_CLASSIFICACAO, DESCR_CLASSIFICACAO, HIS_ID_INI, HIS_DT_INI, HIS_ATIVO, CODIFICACAO) values (8, 'Auditoria  interna', 8, to_date('13/03/09','DD/MM/RR'), 1, '00.06.01.02');
Insert into SIGA.EX_CLASSIFICACAO (ID_CLASSIFICACAO, DESCR_CLASSIFICACAO, HIS_ID_INI, HIS_DT_INI, HIS_ATIVO, CODIFICACAO) values (10, 'APRESTAÇÃO DE CONTAS', 10, to_date('13/03/09','DD/MM/RR'), 1, '00.06.02.00');
Insert into SIGA.EX_CLASSIFICACAO (ID_CLASSIFICACAO, DESCR_CLASSIFICACAO, HIS_ID_INI, HIS_DT_INI, HIS_ATIVO, CODIFICACAO) values (11, 'Tomada de contas especial', 11, to_date('13/03/09','DD/MM/RR'), 1, '00.06.02.01');
Insert into SIGA.EX_CLASSIFICACAO (ID_CLASSIFICACAO, DESCR_CLASSIFICACAO, HIS_ID_INI, HIS_DT_INI, HIS_ATIVO, CODIFICACAO) values (12, 'Decisão do TCU sobre as contas', 12, to_date('13/03/09','DD/MM/RR'), 1, '00.06.02.03');

Insert into SIGA.EX_VIA (ID_VIA, ID_CLASSIFICACAO, ID_DESTINACAO, COD_VIA, ID_TEMPORAL_ARQ_COR, OBS, ID_DESTINACAO_FINAL, HIS_ID_INI, HIS_DT_INI, HIS_ATIVO) values (2, 7, 58,	1, 85, '-',	1, 2,	to_date('13/03/09','DD/MM/RR'),1);

Insert into SIGA.EX_VIA (ID_VIA, ID_CLASSIFICACAO, ID_DESTINACAO, COD_VIA, ID_TEMPORAL_ARQ_COR, OBS, ID_DESTINACAO_FINAL, HIS_ID_INI, HIS_DT_INI, HIS_ATIVO) values (3, 8, 58,	1, 85, '-',	1, 3,	to_date('13/03/09','DD/MM/RR'),1);

Insert into SIGA.EX_VIA (ID_VIA, ID_CLASSIFICACAO, ID_DESTINACAO, COD_VIA, ID_TEMPORAL_ARQ_COR, OBS, ID_DESTINACAO_FINAL, HIS_ID_INI, HIS_DT_INI, HIS_ATIVO) values (4, 11, 58,	1, 85, '-',	1, 4,	to_date('13/03/09','DD/MM/RR'),1);

Insert into SIGA.EX_VIA (ID_VIA, ID_CLASSIFICACAO, ID_DESTINACAO, COD_VIA, ID_TEMPORAL_ARQ_COR, OBS, ID_DESTINACAO_FINAL, HIS_ID_INI, HIS_DT_INI, HIS_ATIVO) values (5, 12, 58,	1, 85, '-',	1, 5,	to_date('13/03/09','DD/MM/RR'),1);
