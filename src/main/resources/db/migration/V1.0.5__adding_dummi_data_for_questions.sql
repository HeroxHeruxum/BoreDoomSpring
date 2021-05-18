
INSERT INTO question_type (question_type) values ('Einfachauswahl');  # Id = 1
INSERT INTO question_type (question_type) values ('Mehrfachauswahl'); # Id = 2
INSERT INTO question_type (question_type) values ('Slider');          # Id = 3

INSERT INTO question (question, question_type_id)
values ('Wie viel Zeit hast du heute?', 2);

INSERT INTO question (question, question_type_id)
values ('Bist du alleine oder sind mehrere Personen bei dir?', 1);

INSERT INTO question (question, question_type_id)
values ('Wie viele Personen sind bei dir?', 2);

INSERT INTO question (question, question_type_id)
values ('Auf welches Genre hast du heute Lust?', 2);

INSERT INTO choice (choice) VALUES ('eine Stunde'), ('zwei Stunden'), ('drei Stunden');
INSERT INTO question2choice (question_id, choice_id) VALUES (1, 1), (1,2), (1,3);

INSERT INTO choice (choice) VALUES ('Ja'), ('Nein');
INSERT INTO question2choice (question_id, choice_id) VALUES (2, 4), (2, 5);

INSERT INTO choice (choice) VALUES ('1'), ('2'), ('3'), ('4'), ('>5');
INSERT INTO question2choice (question_id, choice_id) VALUES (3, 6), (3,7), (3,8), (3,9), (3,10);

INSERT INTO choice (choice) VALUES ('Horror'), ('Fantasy'), ('Romance'), ('Science Fiction');
INSERT INTO question2choice (question_id, choice_id) VALUES (4, 11), (4,12), (4,13), (4, 14);