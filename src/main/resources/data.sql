INSERT INTO `role` (`role_id`, `role`) VALUES
	(1, 'ADMIN');

INSERT INTO `user` (`id`, `active`, `email`, `firstname`, `lastname`, `password`) VALUES

	(1, 1, 'edwin@gmail.com', 'Edwin', '', '$2a$10$AhVPYAt/wPQfgQ3PQUsjteF81dxK0JNPPkVyYBstlPgzNn8d6JFC2'),

	(2, 1, 'theo@gmail.com', 'Theo', '', '$2a$10$AhVPYAt/wPQfgQ3PQUsjteF81dxK0JNPPkVyYBstlPgzNn8d6JFC2');

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
	(1, 1);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
	(2, 1);

INSERT INTO category (name) VALUES ('HEALTH');
INSERT INTO category (name) VALUES ('COMPRO');
INSERT INTO category (name) VALUES ('VEDIC SCIENCE');

INSERT INTO article (title, content, publication_date, author_id, image, category_id)
VALUES ('VEDIC SCIENCE', 'What is Lorem Ipsum? \n Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
now(), 1, 'http://synerg.org/wp-content/uploads/2018/05/health-wellness.jpg', 1);

INSERT INTO article (title, content, publication_date, author_id, image, category_id)
VALUES ('SPORTS IN MUM',
'What is Lorem Ipsum? \n Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
now(), 2, 'https://cryptocurry.com/wp-content/uploads/2017/10/Blockchain-Technology-And-The-Sports-Industry.jpg', 2);



