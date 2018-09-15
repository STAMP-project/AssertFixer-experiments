USE ibs;

CREATE TABLE IF NOT EXISTS invoices
(
  ID int PRIMARY KEY AUTO_INCREMENT,
  customer_ID int NOT NULL,
  insurance_ID int NOT NULL,
  created timestamp
    DEFAULT "1970-01-01 00:00:01"
    NOT NULL,
  due timestamp
    DEFAULT "1970-01-01 00:00:01"
    NOT NULL,
  comment VARCHAR(500),

  FOREIGN KEY(customer_ID)
    REFERENCES companies(ID),

  FOREIGN KEY(insurance_ID)
    REFERENCES insurance_policy(ID)
);

CREATE TABLE IF NOT EXISTS debit_transactions
(
  ID int PRIMARY KEY AUTO_INCREMENT,
  invoice_ID int NOT NULL,
  amount double NOT NULL,
  FOREIGN KEY(invoice_ID)
    REFERENCES invoices(ID)
);

CREATE TABLE IF NOT EXISTS credit_transactions
(
  ID int PRIMARY KEY AUTO_INCREMENT,
  invoice_ID int NOT NULL,
  amount double NOT NULL,
  FOREIGN KEY(invoice_ID)
    REFERENCES invoices(ID)
);