/**
 * CREATE Script for init of DB
 */

-- Create 5  customers
insert into customer (id, date_created, name, customer_type, country, state, city, address_line1, postal_code)
values(1, NOW(), 'Kalles Grustransporter AB', 'COMPANY', 'Sweden', 'Södermanland', 'Södertälje', 'Cementvägen 8','111 11');

insert into customer (id, date_created, name, customer_type, country, state, city, address_line1, postal_code)
values(2, NOW(), 'Johans Bulk AB', 'COMPANY', 'Sweden', 'Södermanland', 'Stockholm', 'Balkvägen 12','222 22');

insert into customer (id, date_created, name, customer_type, country, state, city, address_line1, postal_code)
values(3, NOW(), 'Haralds Värdetransporter AB', 'COMPANY', 'Sweden', 'Uppland', 'Uppsala', 'Budgetvägen 1','333 33');

insert into customer (id, date_created, name, customer_type, country, state, city, address_line1, postal_code)
values(4, NOW(), 'Leza Karlson', 'INDIVIDUAL', 'Sweden', 'Södermanland', 'Eskilstuna', 'Parken 14','444 44');

insert into customer (id, date_created, name, customer_type, country, state, city, address_line1, postal_code)
values(5, NOW(), 'Ahmed Mohamed', 'INDIVIDUAL', 'Egypt', 'Giza', '6th of October', '7th district','555 55');
