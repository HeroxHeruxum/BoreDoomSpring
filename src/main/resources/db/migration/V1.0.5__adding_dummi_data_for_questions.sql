
#erstellen der evaluation_type und der evaluation_value Tabellen

CREATE TABLE evaluation_type (id INT NOT NULL AUTO_INCREMENT, evaluation_type VARCHAR(100), PRIMARY KEY (id));
CREATE TABLE evaluation_value (id INT NOT NULL AUTO_INCREMENT, evaluation_value VARCHAR(100), evaluation_type_id INT,
FOREIGN KEY (evaluation_type_id)
      REFERENCES evaluation_type (id), PRIMARY KEY (id) );

#befüllen der evaluation_type Tabelle

INSERT INTO evaluation_type (id, evaluation_type) VALUES (1,'ActivityType');
INSERT INTO evaluation_type (id, evaluation_type) VALUES (2,'Genre');
INSERT INTO evaluation_type (id, evaluation_type) VALUES (3,'Setting');
INSERT INTO evaluation_type (id, evaluation_type) VALUES (4,'Dauer');

#befüllen der evaluation_value Tabelle

INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (1,'ruhig', 1);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (2,'actionreich', 1);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (3,'gruselig', 1);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (4,'dramatisch', 1);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (5,'humorvoll', 1);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (6,'spannend', 1);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (7,'lehrreich', 1);

INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (8,'Horror', 2);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (9,'Action', 2);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (10,'Abenteuer', 2);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (11,'Fantasy', 2);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (12,'Krimi', 2);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (13,'Comedy', 2);

INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (14,'Fantasy', 3);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (15,'Zukunft', 3);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (16,'Gegenwart', 3);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (17,'Vergangenheit', 3);

INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (18,'sehr kurz', 4);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (19,'kurz', 4);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (20,'mittel', 4);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (21,'lang', 4);
INSERT INTO evaluation_value (id, evaluation_value, evaluation_type_id) VALUES (22,'unbegrenzt', 4);

# befüllen der question_type Tabelle

INSERT INTO question_type (question_type) VALUES ('Einfachauswahl');  # Id = 1
INSERT INTO question_type (question_type) VALUES ('Mehrfachauswahl'); # Id = 2
INSERT INTO question_type (question_type) VALUES ('Slider');          # Id = 3

# befüllen der question Tabelle

INSERT INTO question (question, question_type_id) VALUES ('Welche Genres interessieren dich?', 2);
INSERT INTO question (question, question_type_id) VALUES ('Wie soll der Abend verlaufen?', 1);
INSERT INTO question (question, question_type_id) VALUES ('Wie lange willst du maximal beschäftigt sein?', 1);
INSERT INTO question (question, question_type_id) VALUES ('Welche Settings sprechen dich an?', 2);
INSERT INTO question (question, question_type_id) VALUES ('Was sind deine Lieblings Creator', 2);
INSERT INTO question (question, question_type_id) VALUES ('Würdest du vom Auenland nach Mordor gehen?', 1);
INSERT INTO question (question, question_type_id) VALUES ('Was sind die besten Pizzatoppings?', 2);

#Spalte für weight und evaluation_value_id hinzüfügen
ALTER TABLE choice ADD evaluation_value_id INT;
ALTER TABLE choice ADD FOREIGN KEY (evaluation_value_id) REFERENCES evaluation_value (id);
ALTER TABLE choice ADD weight DECIMAL (5,2);

# befüllen der choice und der question2choice Tabellen

INSERT INTO choice (choice, evaluation_value_id, weight) VALUES ('Horror', 8, 1), ('Action',9,1), ('Abenteuer',10,1),
('Fantasy',11,1), ('Krimi',12,1), ('Comedy',13,1);
INSERT INTO question2choice (question_id, choice_id) VALUES (1, 1), (1,2), (1,3), (1,4), (1,5), (1,6);


INSERT INTO choice (choice, evaluation_value_id, weight) VALUES ('ruhig',1,1), ('actionreich',2,1), ('gruselig',3,1),
                                                                ('dramatisch',4,1),('humorvoll',5,1), ('spannend',6,1),
                                                                ('lehrreich',7,1);
INSERT INTO question2choice (question_id, choice_id) VALUES (2,7), (2,8), (2,9), (2,10), (2,11), (2,12), (2,13);


INSERT INTO choice (choice, evaluation_value_id, weight) VALUES ('sehr kurz',18,1), ('kurz',19,1), ('mittel',20,1), ('lang',21,1),
                                                                ('unbegrenzt',22,1);
INSERT INTO question2choice (question_id, choice_id) VALUES (3,14), (3,15), (3,16), (3,17), (3,18);


INSERT INTO choice (choice, evaluation_value_id, weight) VALUES ('Fantasy',14,1), ('Zukunft',15,1), ('Gegenwart',16,1),
                                                                ('Vergangenheit',17,1);
INSERT INTO question2choice (question_id, choice_id) VALUES (4, 4), (4, 19), (4,20), (4,21);


INSERT INTO choice (choice, evaluation_value_id, weight) VALUES ('Astrid Lindgren',5,0.5), ('Stephen King', 3,0.5),
                                                                ('J. R. R. Tolkien', 6,0.5),('Steven Spielberg', 4,0.5),
                                   ('Michael Moore', 7,0.5), ('Hayao Miyazaki', 1,0.5), ('Michael Bay', 2,0.5);
INSERT INTO question2choice (question_id, choice_id) VALUES (5, 22), (5,23), (5,24), (5,25), (5,26), (5,27), (5,28);


INSERT INTO choice (choice, evaluation_value_id, weight) VALUES ('Ja', 6, 1), ('Nein',6,0), ('Häh?', 11,0);
INSERT INTO question2choice (question_id, choice_id) VALUES (6, 29), (6,30), (6,31);


INSERT INTO choice (choice, evaluation_value_id, weight) VALUES ('Hollandaise',8,0.3), ('Jalapenos',9,0.3 ), ('Pasta',10,0.3),
                                                                ('Gummibärsaft',11,0.3), ('Nur Tomatensauce',12,0.3),
                                                                ('Ananas', 13,0.3);
INSERT INTO question2choice (question_id, choice_id) VALUES (7,32), (7,33), (7,34), (7,35), (7,36), (7,37);

