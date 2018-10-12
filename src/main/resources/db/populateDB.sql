DELETE FROM user_roles;
DELETE FROM votes;
DELETE FROM meals;
DELETE FROM restaurants;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', '{noop}password'),
  ('Admin', 'admin@gmail.com','{noop}admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO restaurants(name)
VALUES ('Cafe Maya'),
       ('Little Wonder Cafe'),
       ('Cafe Loren');

INSERT INTO meals (name, price, restaurant_id)
VALUES ('Beef steak', 3.00, 100002),
       ('Borsch', 2.00, 100002),
       ('Pancake', 1.00, 100002),
       ('Deep fried potatoes', 1.00, 100003),
       ('Macaroni', 2.00, 100003),
       ('Bouillon', 1.00, 100003),
       ('Porridge', 1.50, 100004),
       ('Pizza', 2.50, 100004);

INSERT INTO votes (restaurant_id, user_id)
VALUES (100002, 100001);

