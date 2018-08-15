CREATE TABLE empresa (
id BIGINT(20) NOT NULL,
cnpj VARCHAR(25) NOT NULL,
data_criacao datetime NOT NULL,
data_atualizacao datetime NOT NULL,
razao_social VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE funcionario (
id BIGINT(20) NOT NULL,
cpf VARCHAR(25) NOT NULL,
data_criacao datetime NOT NULL,
data_atualizacao datetime NOT NULL,
email VARCHAR(50) NOT NULL,
nome  VARCHAR(75) NOT NULL,
perfil VARCHAR(50) NOT NULL,
qtd_horas_almoco FLOAT DEFAULT NULL,
qtd_horas_trabalho_dia FLOAT DEFAULT NULL,
senha VARCHAR(50) NOT NULL,
valor_hora DECIMAL(19, 2) DEFAULT NULL,
empresa_id BIGINT(20) DEFAULT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE lancamento (
id BIGINT(20) NOT NULL,
data datetime NOT NULL,
data_criacao datetime NOT NULL,
data_atualizacao datetime NOT NULL,
descricao VARCHAR(255) DEFAULT NULL,
localizacao VARCHAR(255) DEFAULT NULL,
tipo VARCHAR(255) NOT NULL,
funcionario_id BIGINT(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE empresa ADD PRIMARY KEY(id);

ALTER TABLE funcionario ADD PRIMARY KEY(id), ADD KEY fk_empresa (empresa_id);

ALTER TABLE lancamento ADD PRIMARY KEY(id), ADD KEY fk_funcionario (funcionario_id);

ALTER TABLE empresa MODIFY id BIGINT(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE funcionario MODIFY id BIGINT(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE lancamento MODIFY id BIGINT(20) NOT NULL AUTO_INCREMENT;

ALTER TABLE funcionario ADD CONSTRAINT fkdfafsd FOREIGN KEY(empresa_id) REFERENCES empresa(id);

ALTER TABLE lancamento ADD CONSTRAINT fkfddae9 FOREIGN KEY(funcionario_id) REFERENCES funcionario(id);


