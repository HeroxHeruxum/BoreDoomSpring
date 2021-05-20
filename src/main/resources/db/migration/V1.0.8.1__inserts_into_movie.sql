ALTER TABLE book
    CHANGE COLUMN duration_hour duration SMALLINT COMMENT 'duration in hours';
ALTER TABLE movie
    CHANGE COLUMN duration_minutes duration SMALLINT COMMENT 'duration in minutes';
ALTER TABLE movie 
  ADD CONSTRAINT uqx_ttlm UNIQUE (title);

INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (28,3,
          3,
          'Fight Club',
          'Ein schlafloser Büroangestellter und ein pflichtbewusster Seifenhersteller gründen einen Untergrund-Kampfclub, aus dem sich viel mehr entwickelt.',
          '1999-11-11',
          18,
          139,
          'https://m.media-amazon.com/images/M/MV5BMmEzNTkxYjQtZTc0MC00YTVjLTg5ZTEtZWMwOWVlYzY0NWIwXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );

INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (29,3,
          2,
          'Pulp Fiction',
          'Die Leben von zwei Mafia-Killern, einem Boxer, einem Gangster und seiner Frau und einem Paar Diner-Banditen verflechten sich in vier Geschichten von Gewalt und Erlösung.',
          '1994-11-03',
          16,
          154,
          'https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UY268_CR1,0,182,268_AL_.jpg'
          );

INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (30,3,
          4,
          'Forrest Gump',
          'Die Präsidentschaften von Kennedy und Johnson, der Vietnamkrieg, der Watergate-Skandal und andere historische Ereignisse entfalten sich aus der Perspektive eines Mannes aus Alabama mit einem IQ von 75, dessen einziger Wunsch es ist, mit seiner Jugendliebe wiedervereint zu werden. ',
          '1994-10-13',
          12,
          142,
          'https://m.media-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_UY268_CR1,0,182,268_AL_.jpg'
          );

INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (31,2,
          5,
          'Das Schloss im Himmel',
          'Ein Junge und ein Mädchen mit einem magischen Kristall müssen auf der Suche nach einem legendären schwimmenden Schloss gegen Piraten und fremde Agenten antreten. ',
          '1986-08-02',
          6,
          125,
          'https://m.media-amazon.com/images/M/MV5BNTg0NmI1ZGQtZTUxNC00NTgxLThjMDUtZmRlYmEzM2MwOWYwXkEyXkFqcGdeQXVyMzM4MjM0Nzg@._V1_UY268_CR2,0,182,268_AL_.jpg'
          );

INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (32,2,
          5,
          'Kikis kleiner Lieferservice',
          'Eine junge Hexe, die sich in ihrem ersten Jahr der Selbstständigkeit befindet, hat Schwierigkeiten, sich in eine neue Gemeinschaft einzufügen, während sie sich mit einem Luftkurierdienst über Wasser hält. ',
          '1989-07-29',
          0,
          103,
          'https://m.media-amazon.com/images/M/MV5BOTc0ODM1Njk1NF5BMl5BanBnXkFtZTcwMDI5OTEyNw@@._V1_UY268_CR3,0,182,268_AL_.jpg'
          );

INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (33,2,
          5,
          'Das wandelnde Schloss',
          'Als eine unsichere junge Frau von einer boshaften Hexe mit einem alten Körper verflucht wird, liegt ihre einzige Chance, den Bann zu brechen, bei einem selbstverliebten, aber unsicheren jungen Zauberer und seinen Gefährten in seinem beinigen, wandelnden Schloss. ',
          '2004-09-05',
          6,
          119,
          'https://m.media-amazon.com/images/M/MV5BNmM4YTFmMmItMGE3Yy00MmRkLTlmZGEtMzZlOTQzYjk3MzA2XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );

INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (34,2,
          5,
          'Ponyo: Das grosse Abenteuer am Meer',
          'Ein fünfjähriger Junge entwickelt eine Beziehung zu Ponyo, einer jungen Goldfischprinzessin, die sich danach sehnt, ein Mensch zu werden, nachdem sie sich in ihn verliebt hat. ',
          '2008-07-19',
          0,
          101,
          'https://m.media-amazon.com/images/M/MV5BOTc3YmM3N2QtODZkMC00ZDE5LThjMTQtYTljN2Y1YTYwYWJkXkEyXkFqcGdeQXVyODEzNjM5OTQ@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (35,2,
          5,
          'Mein Nachbar Totoro',
          'Als zwei Mädchen aufs Land ziehen, um in der Nähe ihrer kranken Mutter zu sein, erleben sie Abenteuer mit den wundersamen Waldgeistern, die in der Nähe leben. ',
          '1988-04-16',
          0,
          86,
          'https://m.media-amazon.com/images/M/MV5BYzJjMTYyMjQtZDI0My00ZjE2LTkyNGYtOTllNGQxNDMyZjE0XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UY268_CR4,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (36,2,
          5,
          'Chihiros Reise ins Zauberland',
          'Während des Umzugs ihrer Familie in die Vorstadt gerät ein mürrisches 10-jähriges Mädchen in eine Welt, die von Göttern, Hexen und Geistern beherrscht wird und in der Menschen in Bestien verwandelt werden. ',
          '2001-07-20',
          0,
          125,
          'https://m.media-amazon.com/images/M/MV5BMjlmZmI5MDctNDE2YS00YWE0LWE5ZWItZDBhYWQ0NTcxNWRhXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (37,2,
          5,
          'Prinzessin Mononoke',
          'Auf einer Reise, um das Heilmittel für den Fluch eines Tatarigami zu finden, gerät Ashitaka mitten in einen Krieg zwischen den Waldgöttern und Tatara, einer Bergbaukolonie. Bei dieser Suche trifft er auch San, die Mononoke Hime. ',
          '1997-07-12',
          12,
          134,
          'https://m.media-amazon.com/images/M/MV5BNGIzY2IzODQtNThmMi00ZDE4LWI5YzAtNzNlZTM1ZjYyYjUyXkEyXkFqcGdeQXVyODEzNjM5OTQ@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (38,1,
          7,
          'The Matrix Revolutions',
          'Die menschliche Stadt Zion verteidigt sich gegen die massive Invasion der Maschinen, während Neo an einer anderen Front kämpft, um den Krieg zu beenden und sich gleichzeitig dem schurkischen Agent Smith entgegenstellt. ',
          '2003-11-05',
          16,
          129,
          'https://m.media-amazon.com/images/M/MV5BNzNlZTZjMDctZjYwNi00NzljLWIwN2QtZWZmYmJiYzQ0MTk2XkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (39,1,
          7,
          'Matrix Reloaded',
          'Die Freiheitskämpfer Neo, Trinity und Morpheus führen die Revolte gegen die Maschinenarmee an und setzen ihr Arsenal an außergewöhnlichen Fähigkeiten und Waffen gegen die systematischen Kräfte der Unterdrückung und Ausbeutung ein. ',
          '2003-05-22',
          16,
          138,
          'https://m.media-amazon.com/images/M/MV5BODE0MzZhZTgtYzkwYi00YmI5LThlZWYtOWRmNWE5ODk0NzMxXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (40,1,
          7,
          'Matrix',
          'Als eine schöne Fremde den Computer-Hacker Neo in eine abweisende Unterwelt führt, entdeckt er die schockierende Wahrheit - das Leben, das er kennt, ist die ausgeklügelte Täuschung einer bösen Cyber-Intelligenz. ',
          '1999-06-17',
          16,
          136,
          'https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (41,4,
          6,
          'Hamilton',
          'Das wahre Leben eines der bedeutendsten Gründerväter Amerikas und ersten Finanzministers, Alexander Hamilton. Aufgezeichnet live am Broadway aus dem Richard Rodgers Theater mit der Original-Broadway-Besetzung. ',
          '2020-07-03',
          13,
          160,
          'https://m.media-amazon.com/images/M/MV5BNjViNWRjYWEtZTI0NC00N2E3LTk0NGQtMjY4NTM3OGNkZjY0XkEyXkFqcGdeQXVyMjUxMTY3ODM@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (42,2,
          14,
          'Doctor Strange',
          'Auf einer Reise der körperlichen und geistigen Heilung wird ein brillanter Neurochirurg in die Welt der mystischen Künste gezogen.',
          '2016-10-27',
          12,
          115,
          'https://m.media-amazon.com/images/M/MV5BNjgwNzAzNjk1Nl5BMl5BanBnXkFtZTgwMzQ2NjI1OTE@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (43,2,
          13,
          'Black Panther',
          'T''Challa, Erbe des verborgenen, aber fortschrittlichen Königreichs Wakanda, muss vortreten, um sein Volk in eine neue Zukunft zu führen und muss sich einem Herausforderer aus der Vergangenheit seines Landes stellen. ',
          '2018-02-15',
          12,
          134,
          'https://m.media-amazon.com/images/M/MV5BMTg1MTY2MjYzNV5BMl5BanBnXkFtZTgwMTc4NTMwNDI@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (44,2,
          10,
          'The First Avenger: Civil War',
          'Die politische Einmischung in die Angelegenheiten der Avengers führt zu einem Zerwürfnis zwischen Captain America und Iron Man. ',
          '2016-04-28',
          12,
          147,
          'https://m.media-amazon.com/images/M/MV5BMjQ0MTgyNjAxMV5BMl5BanBnXkFtZTgwNjUzMDkyODE@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (45,2,
          9,
          'The Return of the First Avenger',
          'Während Steve Rogers damit kämpft, seine Rolle in der modernen Welt zu akzeptieren, tut er sich mit einer anderen Rächerin und S.H.I.E.L.D.-Agentin, Black Widow, zusammen, um eine neue Bedrohung aus der Geschichte zu bekämpfen: einen Attentäter, bekannt als der Winter Soldier. ',
          '2014-03-27',
          12,
          136,
          'https://m.media-amazon.com/images/M/MV5BMzA2NDkwODAwM15BMl5BanBnXkFtZTgwODk5MTgzMTE@._V1_UY268_CR1,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (46,2,
          12,
          'Captain America: The First Avenger',
          'Steve Rogers, ein ausgemusterter Militärsoldat, verwandelt sich nach der Einnahme einer Dosis eines "Super-Soldaten-Serums" in Captain America. Aber Captain America zu sein hat seinen Preis, als er versucht, einen Kriegstreiber und eine Terrororganisation zur Strecke zu bringen. ',
          '2011-08-18',
          12,
          124,
          'https://m.media-amazon.com/images/M/MV5BMTYzOTc2NzU3N15BMl5BanBnXkFtZTcwNjY3MDE3NQ@@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (47,2,
          11,
          'Guardians of the Galaxy Vol. 2',
          'Die Wächter kämpfen darum, als Team zusammenzuhalten, während sie sich mit ihren persönlichen Familienproblemen auseinandersetzen, vor allem Star-Lords Begegnung mit seinem Vater, dem ehrgeizigen himmlischen Wesen Ego. ',
          '2017-04-27',
          12,
          136,
          'https://m.media-amazon.com/images/M/MV5BNjM0NTc0NzItM2FlYS00YzEwLWE0YmUtNTA2ZWIzODc2OTgxXkEyXkFqcGdeQXVyNTgwNzIyNzg@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (48,2,
          11,
          'Guardians of the Galaxy',
          'Eine Gruppe intergalaktischer Krimineller muss sich zusammentun, um einen fanatischen Krieger aufzuhalten, der plant, das Universum zu säubern. ',
          '2014-08-28',
          12,
          121,
          'https://m.media-amazon.com/images/M/MV5BMTAwMjU5OTgxNjZeQTJeQWpwZ15BbWU4MDUxNDYxODEx._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (49,2,
          9,
          'Avengers: Infinity Wars',
          'Die Avengers und ihre Verbündeten müssen bereit sein, alles zu opfern, um den mächtigen Thanos zu besiegen, bevor sein Blitz der Verwüstung und des Verderbens dem Universum ein Ende setzt. ',
          '2018-04-26',
          12,
          149,
          'https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (50,2,
          10,
          'Avengers: Endgame',
          'Nach den verheerenden Ereignissen von Avengers: Infinity War (2018) liegt das Universum in Trümmern. Mit Hilfe der verbliebenen Verbündeten versammeln sich die Avengers noch einmal, um Thanos Taten rückgängig zu machen und das Gleichgewicht im Universum wiederherzustellen. ',
          '2019-04-24',
          12,
          181,
          'https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (51,2,
          8,
          'Avengers: Age of Ultron',
          'Als Tony Stark und Bruce Banner versuchen, ein ruhendes Friedensprogramm namens Ultron in Gang zu setzen, gehen die Dinge schrecklich schief und es liegt an den mächtigsten Helden der Erde, den schurkischen Ultron davon abzuhalten, seinen schrecklichen Plan in die Tat umzusetzen. ',
          '2015-04-23',
          12,
          141,
          'https://m.media-amazon.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (52,2,
          8,
          'The Avengers',
          'Die mächtigsten Helden der Erde müssen zusammenkommen und lernen, als Team zu kämpfen, wenn sie den schelmischen Loki und seine Alien-Armee davon abhalten wollen, die Menschheit zu versklaven. ',
          '2012-04-26',
          12,
          143,
          'https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (53,2,
          16,
          'Avatar - Der Herr der Elemente',
          'In einer vom Krieg zerrissenen Welt der Elementarmagie erwacht ein Junge, der sich auf eine gefährliche mystische Suche begibt, um seine Bestimmung als Avatar zu erfüllen und der Welt Frieden zu bringen. ',
          '2005-02-21',
          6,
          1426,
          'https://m.media-amazon.com/images/M/MV5BODc5YTBhMTItMjhkNi00ZTIxLWI0YjAtNTZmOTY0YjRlZGQ0XkEyXkFqcGdeQXVyODUwNjEzMzg@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
INSERT INTO movie (id, setting_id, director_id, title, description, publishing_year, min_age, duration, image_url)
  VALUES (54,
          3,
          15,
          'Eternal Sunshine of the Spotless Mind',
          'Als ihre Beziehung in die Brüche geht, unterzieht sich ein Paar einem medizinischen Eingriff, um sich gegenseitig aus dem Gedächtnis zu löschen. ',
          '2004-05-20',
          12,
          108,
          'https://m.media-amazon.com/images/M/MV5BMTY4NzcwODg3Nl5BMl5BanBnXkFtZTcwNTEwOTMyMw@@._V1_UX182_CR0,0,182,268_AL_.jpg'
          );
          
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE author;
SET FOREIGN_KEY_CHECKS = 1;
INSERT INTO author (id, full_name)
  VALUES (1, 'J.K. Rowling');

INSERT INTO book (id,
                  setting_id,
				          author_id,
                  title,
                  description,
                  publishing_year,
                  min_age,
                  duration,
                  page_count,
                  image_url)
		      values (3,
                  2,
				          1,
                  'Harry Potter und der Stein der Weisen',
                  'Bis zu seinem elften Geburtstag glaubt Harry, er sei ein ganz normaler Junge. Doch dann erfährt er, dass er sich an der Schule für Hexerei und Zauberei einfinden soll – denn er ist ein Zauberer! In Hogwarts stürzt Harry von einem Abenteuer ins nächste und muss gegen Bestien, Mitschüler und Fabelwesen kämpfen. Da ist es gut, dass er schon Freunde gefunden hat, die ihm im Kampf gegen die dunklen Mächte zur Seite stehen.',
                  '1998-07-21',
                  6,
                  17,
                  335,
                  'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551320117_1614251170000_xxl.jpg'
                  );

INSERT INTO book (id,
                  setting_id,
				          author_id,
                  title,
                  description,
                  publishing_year,
                  min_age,
                  duration,
                  page_count,
                  image_url)
		      values (4,
                  2,
				          1,
                  'Harry Potter und die Kammer des Schreckens',
                  'Endlich wieder Schule! Einen solchen Seufzer kann nur der ausstoßen, dessen Ferien scheußlich waren: Harry Potter. Doch wie im vergangenen Schuljahr stehen nicht nur Zaubertrankunterricht und Verwandlung auf dem Programm. Ein grauenhaftes Etwas treibt sein Unwesen in der Schule. Wird Harry mit Hilfe seiner Freunde Ron und Hermine das Rätsel lösen und Hogwarts von den dunklen Mächten befreien können?',
                  '1999-03-21',
                  6,
                  17,
                  352,
                  'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551557421_1571835614000_xxl.jpg'
                  );
                  
INSERT INTO book (id,
                  setting_id,
				          author_id,
                  title,
                  description,
                  publishing_year,
                  min_age,
                  duration,
                  page_count,
                  image_url)
		      values (5,
                  2,
				          1,
                  'Harry Potter und der Gefangene von Askaban',
                  'Natürlich weiß Harry, dass das Zaubern in den Ferien strengstens verboten ist, und trotzdem befördert er seine schreckliche Tante mit einem Schwebezauber an die Decke. Die Konsequenz ist normalerweise: Schulverweis! Doch Harry wird behandelt wie ein rohes Ei. Hat es etwa damit zu tun, dass ein gefürchteter Verbrecher es auf Harry abgesehen hat? Mit Ron und Hermine versucht Harry ein Geflecht aus Verrat und Rache aufzudröseln und stößt dabei auf Dinge, die ihn fast an seinem Verstand zweifeln lassen.',
                  '1999-08-21',
                  6,
                  22,
                  448,
                  'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551557438_1571835614000_xxl.jpg'
                  );
               
INSERT INTO book (id,
                  setting_id,
				          author_id,
                  title,
                  description,
                  publishing_year,
                  min_age,
                  duration,
                  page_count,
                  image_url)
		      values (6,
                  2,
				          1,
                  'Harry Potter und der Feuerkelch',
                  'Harrys viertes Schuljahr in Hogwarts beginnt und ein Wettkampf hält die Schüler in Atem: das Trimagische Turnier, in dem Harry eine Rolle übernimmt, die er sich im Traum nicht vorgestellt hätte. Natürlich steckt dahinter das Böse, das zurück an die Macht drängt: Lord Voldemort. Es wird eng für Harry. Doch auf seine Freunde und ihre Unterstützung kann er sich auch in verzweifelten Situationen verlassen.',
                  '2000-10-21',
                  10,
                  35,
                  704,
                  'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551557445_1571835610000_xxl.jpg'
                  );

INSERT INTO book (id,
                  setting_id,
				          author_id,
                  title,
                  description,
                  publishing_year,
                  min_age,
                  duration,
                  page_count,
                  image_url)
		      values (7,
                  2,
				          1,
                  'Harry Potter und der Orden des Phönix',
                  'Es sind Sommerferien und wieder einmal sitzt Harry bei den unsäglichen Dursleys fest. Doch diesmal treibt ihn größere Unruhe denn je – warum erfährt er nichts über die dunklen Mächte, die inzwischen neu erstanden sind? Noch ahnt er nicht, was der geheimnisvolle Orden des Phönix gegen Voldemort ausrichten kann ... Doch dann schlägt der Dunkle Lord wieder zu. Harry muss seine Freunde um sich scharen, sonst gibt es kein Entrinnen.',
                  '2003-11-15',
                  10,
                  48,
                  960,
                  'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551557452_1571835612000_xxl.jpg'
                  );
                  
INSERT INTO book (id,
                  setting_id,
				          author_id,
                  title,
                  description,
                  publishing_year,
                  min_age,
                  duration,
                  page_count,
                  image_url)
		      values (8,
                  2,
				          1,
                  'Harry Potter und der Halbblutprinz',
                  'Seit Voldemort, der gefährlichste schwarze Magier aller Zeiten, zurückgekehrt ist, herrschen Aufruhr und Gewalt in der magischen Welt. Als Harry und seine Freunde Ron und Hermine zu ihrem sechsten Schuljahr nach Hogwarts kommen, gelten strengste Sicherheitsmaßnahmen in der Zauberschule. Um Harry gegen das Böse zu wappnen, erforscht Dumbledore mit ihm die Geschichte des Dunklen Lords. Ob auch Harrys Zaubertrankbuch, das früher einem »Halbblutprinzen« gehörte, ihm helfen kann?',
                  '2005-10-08',
                  10,
                  32,
                  640,
                  'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551557469_1571835614000_xxl.jpg'
                  );
                  
INSERT INTO book (id,
                  setting_id,
				          author_id,
                  title,
                  description,
                  publishing_year,
                  min_age,
                  duration,
                  page_count,
                  image_url)
		      values (9,
                  2,
				          1,
                  'Harry Potter und die Heiligtümer des Todes',
                  'An eine Rückkehr nach Hogwarts ist für Harry nicht zu denken. Er muss alles daransetzen, die übrigen Horkruxe zu finden. Erst wenn sie zerstört sind, kann Voldemorts Schreckensherrschaft vergehen. Mit Ron und Hermine an seiner Seite begibt sich Harry auf eine gefährliche Reise durch das ganze Land. Als die drei auf die rätselhaften Heiligtümer des Todes stoßen, muss Harry sich entscheiden. Soll er dieser Spur folgen? Doch welche Wahl er auch trifft – am Ende des Weges wird der Dunkle Lord auf ihn warten …',
                  '2007-10-27',
                  10,
                  37,
                  752,
                  'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551557476_1571835616000_xxl.jpg'
                  );

INSERT INTO actor (id, full_name)
  VALUES (58,'Mayumi Tanaka');
INSERT INTO actor (id, full_name)
  VALUES (59,'Keiko Yokozawa');
INSERT INTO actor (id, full_name)
  VALUES (60,'Kotoe Hatsui');