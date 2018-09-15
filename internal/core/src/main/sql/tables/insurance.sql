USE ibs;

CREATE TABLE IF NOT EXISTS insurance_terms
(
    ID int PRIMARY KEY AUTO_INCREMENT,
    insurance_policy_ID int NOT NULL,
    FOREIGN KEY (insurance_policy_ID)
        references insurance_policy(ID),
    effective_date timestamp
        DEFAULT "1970-01-01 00:00:01"
        NOT NULL,
    expiration_date timestamp
        DEFAULT "1970-01-01 00:00:01"
        NOT NULL,
    due_date timestamp
        DEFAULT "1970-01-01 00:00:01"
        NOT NULL
);

CREATE TABLE IF NOT EXISTS insurance_policy
(
    ID int PRIMARY KEY AUTO_INCREMENT,
    insurance_number VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS insurance_bond
(
    ID int PRIMARY KEY AUTO_INCREMENT,
    insurance_number VARCHAR(60) NOT NULL,
    bond_type VARCHAR(12) NOT NULL
);

CREATE TABLE IF NOT EXISTS insurance_endorsement
(
    ID int PRIMARY KEY AUTO_INCREMENT,
    policy_ID int NOT NULL,
    insurance_number VARCHAR(60) NOT NULL,
    policy_change VARCHAR(100) NOT NULL,

    FOREIGN KEY(policy_ID)
        references insurance_policy(ID)
);