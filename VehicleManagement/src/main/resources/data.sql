/**
 * CREATE Script for init of DB
 */

-- Create 5  manufacturers
insert into manufacturer (id, date_created, name, origin)
values(1, NOW(), 'BMW', 'German');

insert into manufacturer (id, date_created, name, origin)
values(2, NOW(), 'Mercedes', 'German');

insert into manufacturer (id, date_created, name, origin)
values(3, NOW(), 'Volvo', 'Sweden');

insert into manufacturer (id, date_created, name, origin)
values(4, NOW(), 'Mazda', 'Japan');

insert into manufacturer (id, date_created, name, origin)
values(5, NOW(), 'Nissan', 'Japan');

-- Create 5  vehicles
insert into vehicle (id, date_created, vin, registeration_number, manufacturer_id, model, customer_id) 
values (1, now(), 'YS2R4X20005399401', 'ABC123', 1, 'M4', 1);

insert into vehicle (id, date_created, vin, registeration_number, manufacturer_id, model, customer_id) 
values (2, now(), 'VLUR4X20009093588', 'DEF456', 3, 'S90', 1);

insert into vehicle (id, date_created, vin, registeration_number, manufacturer_id, model, customer_id) 
values (3, now(), 'VLUR4X20009048066', 'GHI789', 2, 'GLE', 1);

insert into vehicle (id, date_created, vin, registeration_number, manufacturer_id, model, customer_id) 
values (4, now(), 'YS2R4X20005388011', 'JKL012', 5, 'leaf', 2);

insert into vehicle (id, date_created, vin, registeration_number, manufacturer_id, model, customer_id) 
values (5, now(), 'YS2R4X20005387949', 'MNO345', 4, 'CX-3', 2);



insert into vehicle (id, date_created, vin, registeration_number, manufacturer_id, model, customer_id) 
values (6, now(), 'VLUR4X20009048066', 'PQR678', 5, 'leaf', 3);

insert into vehicle (id, date_created, vin, registeration_number, manufacturer_id, model, customer_id) 
values (7 , now(), 'YS2R4X20005387055', 'STU901', 3, 'S90', 3);