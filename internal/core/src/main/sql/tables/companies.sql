CREATE TABLE IF NOT EXISTS companies
(
    ID int PRIMARY KEY AUTO_INCREMENT,
    company_name varchar(100) NOT NULL,
    address_number int NOT NULL,
    street_name varchar(60) NOT NULL,
    state_abbreviation varchar(2) NOT NULL COMMENT 'Two character state identifier',
    phone_number varchar(10) NOT NULL,
    attention varchar(60),
    zip varchar(5) NOT NULL,
    fax_number varchar(10),
    is_brokerage boolean NOT NULL,
    is_agency boolean NOT NULL,
    is_customer boolean NOT NULL
);