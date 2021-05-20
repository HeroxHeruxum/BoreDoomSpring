#Hier die Erstellung und den Insert für die Genre Tabelle hinzufügen
CREATE TABLE genre (
	id INT NOT NULL,
    genre VARCHAR(200) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (genre)
) ENGINE=INNODB;

INSERT INTO genre (id, genre) VALUES (1,'Horror'), (2,'Action'), (3,'Abenteuer'), (4, 'Fantasy'),
                                     (5, 'Krimi'), (6, 'Comedy');

#Dependencies von book2genre und movie2genre aendern und ueberfluessige Tabellen anschließend loeschen
SET FOREIGN_KEY_CHECKS = 0;

ALTER TABLE movie2movie_genre 
DROP FOREIGN KEY `movie2movie_genre_ibfk_2`;
ALTER TABLE movie2movie_genre ADD CONSTRAINT `fk_mgenre_id` FOREIGN KEY (movie_genre_id) REFERENCES genre (id);

ALTER TABLE book2book_genre 
DROP FOREIGN KEY `book2book_genre_ibfk_2`;
ALTER TABLE book2book_genre ADD CONSTRAINT `fk_bgenre_id` FOREIGN KEY (book_genre_id) REFERENCES genre (id);

SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE movie_genre;
DROP TABLE book_genre;

#activity_types und settings hinzufuegen
INSERT INTO activity_type (id, activity_type) values (1,'ruhig');
INSERT INTO activity_type (id, activity_type) values (2,'actionreich');
INSERT INTO activity_type (id, activity_type) values (3,'gruselig');
INSERT INTO activity_type (id, activity_type) values (4,'dramatisch');
INSERT INTO activity_type (id, activity_type) values (5,'humorvoll');
INSERT INTO activity_type (id, activity_type) values (6,'spannend');
INSERT INTO activity_type (id, activity_type) values (7,'lehrreich');

INSERT INTO setting (id,setting) values (1,'Zukunft');
INSERT INTO setting (id,setting) values (2,'Fantasy');
INSERT INTO setting (id,setting) values (3,'Gegenwart');
INSERT INTO setting (id,setting) values (4,'Geschichte');

INSERT INTO author (id, first_name, last_name) VALUES (1, 'Joanne K.', 'Rowling');