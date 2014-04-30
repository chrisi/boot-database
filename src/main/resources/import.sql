INSERT INTO address (id, street, zip, city) VALUES (1, 'Asternweg 10', '63322', 'Rödermark');
INSERT INTO person (id, first_name, last_name, birth_date, address_id) VALUES (1, 'Christian', 'Gebauer', '1976-01-14 00:00:00', 1);
INSERT INTO book (id, name, author_id, release, isbn) VALUES (1, 'Spring Boot in Action', 1, '2014-05-01 00:00:00', 'ISBN 978-3-86632-192-9');
COMMIT;
