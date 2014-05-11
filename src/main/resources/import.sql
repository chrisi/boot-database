INSERT INTO address (id, street, zip, city) VALUES (1, 'Asternweg 10', '63322', 'Roedermark');
INSERT INTO address (id, street, zip, city) VALUES (2, 'Schillerstr. 1', '63322', 'Roedermark');
INSERT INTO address (id, street, zip, city) VALUES (3, 'Spitzwegstr. 11', '63322', 'Roedermark');
INSERT INTO address (id, street, zip, city) VALUES (4, 'Hauptstr. 1', '63322', 'Roedermark');
INSERT INTO address (id, street, zip, city) VALUES (5, 'Germanenweg 23', '63128', 'Dietzenbach');

INSERT INTO person (id, first_name, last_name, birth_date, address_id) VALUES (1, 'Christian', 'Gebauer', '1976-01-14 00:00:00', 1);
INSERT INTO person (id, first_name, last_name, birth_date, address_id) VALUES (2, 'Stefanie', 'Cremer', '1978-01-28 00:00:00', 1);
INSERT INTO person (id, first_name, last_name, birth_date, address_id) VALUES (3, 'Daniel', 'Strauch', '1975-01-10 00:00:00', 3);
INSERT INTO person (id, first_name, last_name, birth_date, address_id) VALUES (4, 'Robert', 'Kasunic', '1976-07-25 00:00:00', 5);
INSERT INTO person (id, first_name, last_name, birth_date, address_id) VALUES (5, 'Marc', 'Pradel', '1977-05-9 00:00:00', 2);

INSERT INTO book (id, name, author_id, release, isbn) VALUES (1, 'Spring Boot in Action', 1, '2014-05-01 00:00:00', 'ISBN 978-3-86632-192-9');
INSERT INTO book (id, name, author_id, release, isbn) VALUES (2, 'Hausbau in Action', 4, '2013-11-10 00:00:00', 'ISBN 978-3-12345-192-9');

--insert into department (id, name) values (1, 'JX IE CPS','Customer Portal Services');


INSERT INTO role (id, name) VALUES (1, 'ADMIN');
INSERT INTO role (id, name) VALUES (2, 'USER');
INSERT INTO role (id, name) VALUES (3, 'JMX_ADMIN');
INSERT INTO role (id, name) VALUES (4, 'JMX_USER');
INSERT INTO role (id, name) VALUES (5, 'JMS_ADMIN');
INSERT INTO role (id, name) VALUES (6, 'JMS_USER');
INSERT INTO role (id, name) VALUES (7, 'ATLAS_USER');

INSERT INTO role_role (role_id, childrole_id) VALUES (1, 3);
INSERT INTO role_role (role_id, childrole_id) VALUES (1, 5);
INSERT INTO role_role (role_id, childrole_id) VALUES (2, 4);
INSERT INTO role_role (role_id, childrole_id) VALUES (2, 6);
INSERT INTO role_role (role_id, childrole_id) VALUES (2, 7);

COMMIT;
