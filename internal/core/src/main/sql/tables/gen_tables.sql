create table companies
(
  ID                        int auto_increment
    primary key,
  company_name              varchar(100) not null,
  street_number             int          not null,
  street_name               varchar(60)  not null,
  city                      varchar(60)  not null,
  state                     varchar(2)   not null
  comment 'Two character state identifier',
  phone_number              int          not null,
  phone_area_code           int          not null,
  zip                       int          not null,
  fax_number                int          null,
  fax_area_code             int          null,
  is_brokerage              tinyint(1)   not null,
  is_agency                 tinyint(1)   not null,
  is_customer               tinyint(1)   not null,
  attention_first_name      varchar(25)  not null,
  attention_last_name       varchar(50)  not null,
  attention_street_number   int          null,
  attention_street_name     varchar(60)  null,
  attention_city            varchar(60)  null,
  attention_state           varchar(2)   null,
  attention_phone_number    int          null,
  attention_phone_area_code int          null,
  attention_zip             int          null
);

create table insurance
(
  ID                   int auto_increment
    primary key,
  insurance_number     varchar(60) not null,
  term_effective_date  timestamp   null,
  term_expiration_date timestamp   null,
  term_due_date        timestamp   null,
  type                 varchar(20) null,
  type_id              int         null
);

create table insurance_bond
(
  ID               int auto_increment
    primary key,
  insurance_number varchar(60) not null,
  bond_type        varchar(20) not null
);

create table insurance_endorsement
(
  ID               int auto_increment
    primary key,
  policy_ID        int          not null,
  insurance_number varchar(60)  not null,
  policy_change    varchar(100) not null
);

create index policy_ID
  on insurance_endorsement (policy_ID);

create table invoices
(
  ID           int auto_increment
    primary key,
  customer_ID  int                                     not null,
  insurance_ID int                                     not null,
  created      timestamp default '1970-01-01 00:00:01' not null,
  due          timestamp default '1970-01-01 00:00:01' not null,
  comment      varchar(500)                            null,
  constraint invoices_ibfk_1
  foreign key (customer_ID) references companies (ID),
  constraint invoices_ibfk_2
  foreign key (insurance_ID) references insurance (ID)
);

create table credit_transactions
(
  ID         int auto_increment
    primary key,
  invoice_ID int    not null,
  amount     double not null,
  constraint credit_transactions_ibfk_1
  foreign key (invoice_ID) references invoices (ID)
);

create index invoice_ID
  on credit_transactions (invoice_ID);

create table debit_transactions
(
  ID         int auto_increment
    primary key,
  invoice_ID int    not null,
  amount     double not null,
  constraint debit_transactions_ibfk_1
  foreign key (invoice_ID) references invoices (ID)
);

create index invoice_ID
  on debit_transactions (invoice_ID);

create index customer_ID
  on invoices (customer_ID);

create index insurance_ID
  on invoices (insurance_ID);

