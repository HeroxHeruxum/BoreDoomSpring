
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