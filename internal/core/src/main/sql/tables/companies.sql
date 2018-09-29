USE ibs;
CREATE TABLE IF NOT EXISTS companies
(
    ID int PRIMARY KEY AUTO_INCREMENT,
    company_name varchar(100) NOT NULL,
    street_number int NOT NULL,
    street_name varchar(60) NOT NULL,
    city varchar(60) NOT NULL,
    state varchar(2) NOT NULL COMMENT 'Two character state identifier',
    phone_number int NOT NULL,
    phone_area_code int NOT NULL,
    zip int NOT NULL,
    fax_number int,
    fax_area_code int,
    is_brokerage boolean NOT NULL,
    is_agency boolean NOT NULL,
    is_customer boolean NOT NULL,
    attention_first_name varchar(25) NOT NULL,
    attention_last_name varchar(50) NOT NULL,
    attention_street_number int,
    attention_street_name varchar(60),
    attention_city varchar(60),
    attention_state varchar(2),
    attention_zip int,
    attention_phone_number int,
    attention_phone_area_code int
);