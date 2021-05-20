
#erstellen der evaluation_type und der evaluation_value Tabellen

CREATE TABLE evaluation_type (id INT NOT NULL, evaluation_type VARCHAR(100), 
  PRIMARY KEY (id), UNIQUE (evaluation_type));
CREATE TABLE evaluation_value (id INT NOT NULL, evaluation_value VARCHAR(100), 
  evaluation_type_id INT, FOREIGN KEY (evaluation_type_id) REFERENCES evaluation_type (id), 
  PRIMARY KEY (id), UNIQUE (evaluation_value));

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

INSERT INTO question_type (id, question_type) VALUES (1, 'Einfachauswahl');  
INSERT INTO question_type (id, question_type) VALUES (2, 'Mehrfachauswahl'); 
INSERT INTO question_type (id, question_type) VALUES (3, 'Slider');         

# befüllen der question Tabelle

INSERT INTO question (id, question, question_type_id) VALUES (1, 'Welche Genres interessieren dich?', 2);
INSERT INTO question (id, question, question_type_id) VALUES (2, 'Wie soll der Abend verlaufen?', 1);
INSERT INTO question (id, question, question_type_id) VALUES (3, 'Wie lange willst du maximal beschäftigt sein?', 1);
INSERT INTO question (id, question, question_type_id) VALUES (4, 'Welche Settings sprechen dich an?', 2);
INSERT INTO question (id, question, question_type_id) VALUES (5, 'Was sind deine Lieblings Creator', 2);
INSERT INTO question (id, question, question_type_id) VALUES (6, 'Würdest du vom Auenland nach Mordor gehen?', 1);
INSERT INTO question (id, question, question_type_id) VALUES (7, 'Was sind die besten Pizzatoppings?', 2);

#Spalte für weight und evaluation_value_id hinzüfügen
ALTER TABLE choice ADD evaluation_value_id INT;
ALTER TABLE choice ADD FOREIGN KEY (evaluation_value_id) REFERENCES evaluation_value (id);
ALTER TABLE choice ADD weight DECIMAL (5,2);
ALTER TABLE choice ADD CONSTRAINT uqx_chc_wgt UNIQUE (choice, weight);

# befüllen der choice und der question2choice Tabellen
INSERT INTO choice (id, choice, evaluation_value_id, weight) VALUES (1,'Horror', 8, 1), (2,'Action',9,1), (3,'Abenteuer',10,1),
                                                                    (4,'Fantasy',11,1), (5,'Krimi',12,1), (6,'Comedy',13,1);

INSERT INTO choice (id, choice, evaluation_value_id, weight) VALUES (7,'ruhig',1,1), (8,'actionreich',2,1), (9,'gruselig',3,1),
                                                                    (10,'dramatisch',4,1),(11,'humorvoll',5,1), (12,'spannend',6,1),
                                                                    (13,'lehrreich',7,1);

INSERT INTO choice (id, choice, evaluation_value_id, weight) VALUES (14,'sehr kurz',18,1), (15,'kurz',19,1), (16,'mittel',20,1), (17,'lang',21,1),
                                                                    (18,'unbegrenzt',22,1);

INSERT INTO choice (id, choice, evaluation_value_id, weight) VALUES (19,'Fantasie Welt',14,1), (20,'Zukunft',15,1), (21,'Gegenwart',16,1),
                                                                    (22,'Vergangenheit',17,1);

INSERT INTO choice (id, choice, evaluation_value_id, weight) VALUES (23,'Astrid Lindgren',5,0.5), (24,'Stephen King', 3,0.5),
                                                                    (25,'J. R. R. Tolkien', 6,0.5),(26,'Steven Spielberg', 4,0.5),
																    (27,'Michael Moore', 7,0.5), (28,'Hayao Miyazaki', 1,0.5), 
                                                                    (29,'Michael Bay', 2,0.5);

INSERT INTO choice (id, choice, evaluation_value_id, weight) VALUES (30,'Ja', 6, 1), (31,'Nein',6,0), (32,'Häh?', 11,0);

INSERT INTO choice (id, choice, evaluation_value_id, weight) VALUES (33,'Hollandaise',8,0.3), (34,'Jalapenos',9,0.3 ), (35,'Pasta',10,0.3),
                                                                    (36,'Gummibärsaft',11,0.3), (37,'Nur Tomatensauce',12,0.3),
                                                                    (38,'Ananas', 13,0.3);

INSERT INTO question2choice (question_id, choice_id) VALUES (1, 1), (1,2), (1,3), (1,4), (1,5), (1,6);
INSERT INTO question2choice (question_id, choice_id) VALUES (2,7), (2,8), (2,9), (2,10), (2,11), (2,12), (2,13);
INSERT INTO question2choice (question_id, choice_id) VALUES (3,14), (3,15), (3,16), (3,17), (3,18);
INSERT INTO question2choice (question_id, choice_id) VALUES (4, 19), (4, 22), (4,20), (4,21);
INSERT INTO question2choice (question_id, choice_id) VALUES (5, 29), (5,23), (5,24), (5,25), (5,26), (5,27), (5,28);
INSERT INTO question2choice (question_id, choice_id) VALUES (6, 32), (6,30), (6,31);
INSERT INTO question2choice (question_id, choice_id) VALUES (7,38), (7,33), (7,34), (7,35), (7,36), (7,37);

