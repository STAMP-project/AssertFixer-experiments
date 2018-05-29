-- Generated by ebean unknown at 2018-05-29T01:32:01.287Z
create table e_basic (
  id                            integer auto_increment not null,
  status                        varchar(1),
  name                          varchar(127),
  description                   varchar(255),
  some_date                     timestamp,
  constraint ck_e_basic_status check ( status in ('N','A','I')),
  constraint pk_e_basic primary key (id)
);

create table ecustom_id (
  id                            varchar(127) not null,
  name                          varchar(255),
  constraint pk_ecustom_id primary key (id)
);

create index ix_e_basic_name on e_basic (name);
