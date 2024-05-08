INSERT INTO GENERE (nome) VALUES 
('Action'),
('Drama'),
('Comedy'),
('Science Fiction');

INSERT INTO FILM (titolo, descrizione, annoRilascio) VALUES
('The Dark Knight', 'A masked vigilante fights crime in Gotham City', 2008),
('Inception', 'A thief who steals corporate secrets through the use of dream-sharing technology', 2010),
('Forrest Gump', 'The story of a man with a low IQ who accomplished great things in his life', 1994),
('Interstellar', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity''s survival', 2014);

INSERT INTO PERSONA (categoria, nome, cognome, dataNascita) VALUES
('attore', 'Christian', 'Bale', '1974-01-30'),
('regista', 'Christopher', 'Nolan', '1970-07-30'),
('attore', 'Leonardo', 'DiCaprio', '1974-11-11'),
('attore', 'Tom', 'Hanks', '1956-07-09'),
('regista', 'Robert', 'Zemeckis', '1951-05-14'),
('attore', 'Matthew', 'McConaughey', '1969-11-04'),
('regista', 'Steven', 'Spielberg', '1946-12-18');


INSERT INTO INTERPRETA (attore, film) VALUES
(1, 1),
(3, 2),
(4, 3),
(6, 4);

INSERT INTO REGISTA (regista, film) VALUES
(2, 1),
(2, 2),
(5, 3),
(7, 4);

INSERT INTO GENERI (genere, film) VALUES
(1, 1),
(1, 2),
(2, 3),
(4, 4);

INSERT INTO DIRIGE (regista, film) VALUES
(2, 1),
(2, 2),
(5, 3),
(7, 4);