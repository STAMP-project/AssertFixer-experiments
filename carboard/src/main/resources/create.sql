create table if not exists login(
  id int primary key auto_increment,
  name varchar(50),
  password varchar(50)
);
create table if not exists engine(
  id int primary key auto_increment,
  name varchar(50)
);
create table if not exists car_body(
  id int primary key auto_increment,
  name varchar(50)
);
create table  if not exists transmission(
  id int primary key auto_increment,
  name varchar(50)
);
create table  if not exists brand(
  id int primary key auto_increment,
  name varchar(50)
);
create table  if not exists photo(
  id int primary key auto_increment,
  name varchar(150),
  image varchar(70)
);
create table if not exists advertisement(
  id int primary key auto_increment,
  text varchar (200),
  login_id int,
  car_body_id int,
  transmission_id int,
  engine_id int,
  brand_id int,
  photo_id int,
  sell boolean,
  price int,
  created_at TIMESTAMP DEFAULT NOW(),
  FOREIGN KEY (login_id) REFERENCES login(id),
  FOREIGN KEY (photo_id) REFERENCES photo(id),
  FOREIGN KEY (car_body_id) REFERENCES car_body(id),
  FOREIGN KEY (transmission_id) REFERENCES transmission(id),
  FOREIGN KEY (engine_id) REFERENCES engine(id),
  FOREIGN KEY (brand_id) REFERENCES brand(id)
);
insert into login(name, password) values('admin', 'admin');
insert into login(name, password) values('user1', '123');
insert into login(name, password) values('user2', '123');
insert into login(name, password) values('user3', '123');
insert into car_body(name) values('micro compact car');
insert into car_body(name) values('station wagon');
insert into car_body(name) values('landau');
insert into car_body(name) values('pickup truck');
insert into car_body(name) values('van');
insert into car_body(name) values('minivan');
insert into car_body(name) values('sports car');
insert into car_body(name) values('phaeton');
insert into car_body(name) values('sedan');
insert into car_body(name) values('cabriolet');
insert into transmission(name) values('mechanic');
insert into transmission(name) values('automat');
insert into transmission(name) values('robot');
insert into transmission(name) values('variator');
insert into engine(name) values('petrol');
insert into engine(name) values('disel');
insert into engine(name) values('gibrid');
insert into engine(name) values('electro');
insert into engine(name) values('gas');
insert into brand(name) values('audi');
insert into brand(name) values('bmw');
insert into brand(name) values('chery');
insert into brand(name) values('chevrolet');
insert into brand(name) values('citroen');
insert into brand(name) values('daewoo');
insert into brand(name) values('ford');
insert into brand(name) values('honda');
insert into brand(name) values('hyundai');
insert into brand(name) values('mazda');
insert into brand(name) values('mercedes');
insert into brand(name) values('nissan');
insert into photo(name, image) values('pdf.png', '/resources/pdf.png');
insert into photo(name, image) values('db.png', '/resources/db.png');
insert into advertisement(text, login_id, car_body_id, transmission_id, engine_id, brand_id, photo_id, sell, price)
values ('bla0', 2, 3, 3, 3, 2, 1, false, 1200000);
insert into advertisement(text, login_id, car_body_id, transmission_id, engine_id, brand_id, photo_id, sell, price)
values ('bla1', 2, 3, 3, 3, 2, 2, true, 1300000);



