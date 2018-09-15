USE ibs;

CREATE TABLE IF NOT EXISTS messages
(
  ID int PRIMARY KEY AUTO_INCREMENT,
  from_email VARCHAR(100) NOT NULL,
  subject VARCHAR(100),
  body VARCHAR(10000),
);

CREATE TABLE IF NOT EXISTS message_recipients
(
  message_ID INT NOT NULL,
  recipient_email VARCHAR(100) NOT NULL,
  FOREIGN KEY(message_ID)
    REFERENCES messages(ID)
);

CREATE TABLE IF NOT EXISTS message_insurance
(
  message_ID INT NOT NULL,
  policy_ID INT NOT NULL,
  FOREIGN KEY(message_ID)
    REFERENCES messages(ID),
  FOREIGN KEY(policy_ID)
    REFERENCES insurance_policy(ID)
);