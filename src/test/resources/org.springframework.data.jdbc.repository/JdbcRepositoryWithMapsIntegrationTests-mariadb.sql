CREATE TABLE dummy_entity ( id BIGINT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(100));
CREATE TABLE element (id BIGINT AUTO_INCREMENT PRIMARY KEY, content VARCHAR(100), Dummy_Entity_key VARCHAR(100),dummy_entity BIGINT);
