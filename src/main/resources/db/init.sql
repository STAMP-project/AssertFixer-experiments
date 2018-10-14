drop sequence if exists global_seq CASCADE;
drop table if exists appuser CASCADE;
drop table if exists blog CASCADE;
drop table if exists coin CASCADE;
drop table if exists event CASCADE;
drop table if exists ico CASCADE;
drop table if exists ico_categories CASCADE;
drop table if exists ico_crew CASCADE;
drop table if exists ico_exchanges CASCADE;
drop table if exists ico_finance CASCADE;
drop table if exists ico_links CASCADE;
drop table if exists item CASCADE;
drop table if exists blog_item CASCADE;
drop table if exists role CASCADE;
drop table if exists appuser_role CASCADE;
drop table if exists whitelist CASCADE;

create sequence global_seq;

create table appuser
(
  id       integer not null
    constraint appuser_pkey
    primary key,
  email    varchar(255)
    constraint uk_hcij6hlq32eras7xlmvbx2sbm
    unique,
  name     varchar(20)
    constraint uk_ee3cmxp6jvhe7rqksp12a80w5
    unique,
  password varchar(255)
);

create table blog
(
  id      integer      not null
    constraint blog_pkey
    primary key,
  name    varchar(255) not null
    constraint uk_40tvjgj9hcufyefk7w0x4edmg
    unique,
  url     varchar(255) not null
    constraint uk_sbwxdwftwe78l1cqba42g73a7
    unique,
  user_id integer      not null
    constraint fksuo4b2bvbco37ao6ynjiovnqp
    references appuser
);

create table coin
(
  id                 integer          not null
    constraint coin_pkey
    primary key,
  circulating_supply numeric(19, 2)   not null,
  dataavailable      boolean          not null,
  image              varchar(255),
  market_cap         numeric(19, 2)   not null,
  name               varchar(255)
    constraint uk_t5dk6mtph8m328rejpscb0jym
    unique,
  percent_change_1h  double precision not null,
  percent_change_24h double precision not null,
  percent_change_7d  double precision not null,
  price              double precision not null,
  rank               integer          not null,
  symbol             varchar(255)
    constraint uk_okchk4xbrpoc9nh4k7tn0pk85
    unique,
  volume_24h         numeric(19, 2)   not null
);

create table event
(
  id          integer      not null
    constraint event_pkey
    primary key,
  coinname    varchar(255) not null,
  date_event  timestamp    not null,
  description varchar(255) not null,
  ishot       boolean      not null,
  name        varchar(255) not null,
  proof       varchar(255) not null,
  source      varchar(255) not null,
  title       varchar(255)
    constraint uk_p5m91ptppqxy57n6m7epv617a
    unique,
  twitter     varchar(255) not null
);

create table ico
(
  id           integer          not null
    constraint ico_pkey
    primary key,
  intro        varchar(1024),
  description  varchar(255)     not null,
  icoend       timestamp,
  icostart     timestamp,
  logolink     varchar(255)
    constraint uk_od5gb62vqnwpmfr3p9auog8ty
    unique,
  name         varchar(255)
    constraint uk_qjrh8xnyqfghcn8fht7xayq7a
    unique,
  preicoend    timestamp,
  preicostart  timestamp,
  rating       double precision not null,
  website_link varchar(255)     not null
);

create table ico_categories
(
  ico_id         integer      not null
    constraint fknm7w94kinfp2tnt7eot6dbpoq
    references ico,
  categories     varchar(255),
  categories_key varchar(255) not null,
  constraint ico_categories_pkey
  primary key (ico_id, categories_key)
);

create table ico_crew
(
  ico_id integer not null
    constraint fkncs0em6gmvmt00bla6kt2ctaq
    references ico,
  links  varchar(255),
  name   varchar(255),
  photo  varchar(255),
  title  varchar(255),
  url    varchar(255)
);

create table ico_exchanges
(
  ico_id   integer not null
    constraint fkdp0d7sghmmwdjg6h91ukvj0bs
    references ico,
  currency varchar(255),
  logo     varchar(255),
  name     varchar(255),
  price    varchar(255),
  roi      varchar(255)
);

create table ico_finance
(
  ico_id      integer      not null
    constraint fki2ou37yw2e9y6srnyamo4yinu
    references ico,
  finance     varchar(255),
  finance_key varchar(255) not null,
  constraint ico_finance_pkey
  primary key (ico_id, finance_key)
);


create table ico_links
(
  ico_id    integer      not null
    constraint fkqe31xfp793w2bjt3k3jkuvd23
    references ico,
  links     varchar(255),
  links_key varchar(255) not null,
  constraint ico_links_pkey
  primary key (ico_id, links_key)
);


create table item
(
  id          integer      not null
    constraint item_pkey
    primary key,
  description varchar(255) not null,
  link        varchar(255) not null,
  publishdate timestamp    not null,
  source      varchar(255) not null,
  title       varchar(255) not null
    constraint uk_dp2x1lasb798ua1955wpae6ac
    unique
);


create table blog_item
(
  blog_id  integer not null
    constraint fk32f389j6v0x6d8xqljyq497i6
    references blog,
  items_id integer not null
    constraint uk_g5hofsrmhtrnmv9uc3bvx8ouk
    unique
    constraint fkhvbfmnvy55b7ggk6999gcbi2a
    references item
);


create table role
(
  role varchar(255) not null,
  id   integer      not null,
  constraint role_pkey
  primary key (role, id)
);

create table appuser_role
(
  user_id    integer      not null
    constraint fk8w10r99i8a1toidvjh1akl8nd
    references appuser,
  roles_role varchar(255) not null,
  roles_id   integer      not null,
  constraint uk_38drpe4jlvq9box4eaj39we46
  unique (roles_role, roles_id),
  constraint fk9sxd4lrxr61h7puctc7w1x58u
  foreign key (roles_role, roles_id) references role
);

create table whitelist
(
  id       integer not null
    constraint whitelist_pkey
    primary key,
  category varchar(255),
  logo     varchar(255),
  name     varchar(255),
  status   varchar(255)
);

