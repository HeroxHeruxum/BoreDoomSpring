INSERT INTO user (username, email, password, registration_date)
  VALUES ('user1', 'user1@test.com', 'abcde123', now());
INSERT INTO user (username, email, password, registration_date)
  VALUES ('aang_avatar', 'aang@avatar.com', 'momoAndAppa', now());
INSERT INTO user (username, email, password, registration_date)
  VALUES ('funnyname', 'funnyname@jokster.com', 'knockknock', now());
INSERT INTO user (username, email, password, registration_date)
  VALUES ('admin', 'admin@fl4shh-gmbh.com', 'random123password', now());
INSERT INTO user (username, email, password, registration_date)
  VALUES ('test', 'test@fl4shh-gmbh.com', '123xyz', now());

# image_urls anpassen, sodass echte Werte drinstehen
UPDATE book 
SET image_url = 'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551320117_1614251170000_xxl.jpg'
WHERE id = 1;
UPDATE book 
SET image_url = 'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551557421_1571835614000_xxl.jpg'
WHERE id = 2;
UPDATE book 
SET image_url = 'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551557438_1571835614000_xxl.jpg'
WHERE id = 3;
UPDATE book 
SET image_url = 'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551557445_1571835610000_xxl.jpg'
WHERE id = 4;
UPDATE book 
SET image_url = 'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551557452_1571835612000_xxl.jpg'
WHERE id = 5;
UPDATE book 
SET image_url = 'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551557469_1571835614000_xxl.jpg'
WHERE id = 6;
UPDATE book 
SET image_url = 'https://images.lovelybooks.de/img/260x/cover.allsize.lovelybooks.de/9783551557476_1571835616000_xxl.jpg'
WHERE id = 7;

-- Actors, Directors, movie genres
INSERT INTO director (full_name)
  VALUES ('Steven Spielberg');
INSERT INTO director (full_name)
  VALUES ('Quentin Tarantino');
INSERT INTO director (full_name)
  VALUES ('David Fincher');
INSERT INTO director (full_name)
  VALUES ('Robert Zemeckis');
INSERT INTO director (full_name)
  VALUES ('Hayao Miyazaki');
INSERT INTO director (full_name)
  VALUES ('Thomas Kail');
INSERT INTO director (full_name)
  VALUES ('The Wachowski Brothers');
INSERT INTO director (full_name)
  VALUES ('Joss Whedon');
INSERT INTO director (full_name)
  VALUES ('Anthony Russo');
INSERT INTO director (full_name)
  VALUES ('Joe Russo');
INSERT INTO director (full_name)
  VALUES ('James Gunn');
INSERT INTO director (full_name)
  VALUES ('Joe Johnston');
INSERT INTO director (full_name)
  VALUES ('Ryan Coogler');
INSERT INTO director (full_name)
  VALUES ('Scott Derrickson');
INSERT INTO director (full_name)
  VALUES ('Michel Gondry');
INSERT INTO director (full_name)
  VALUES ('Michael Dante DiMartino & Bryan Konietzko');

INSERT INTO actor (full_name)
  VALUES ('John Travolta');
INSERT INTO actor (full_name)
  VALUES ('Uma Thurman');
INSERT INTO actor (full_name)
  VALUES ('Samuel L. Jackson');
INSERT INTO actor (full_name)
  VALUES ('Brad Pitt');
INSERT INTO actor (full_name)
  VALUES ('Edward Norton');
INSERT INTO actor (full_name)
  VALUES ('Meat Loaf');
INSERT INTO actor (full_name)
  VALUES ('Tom Hanks');
INSERT INTO actor (full_name)
  VALUES ('Robin Wright');
INSERT INTO actor (full_name)
  VALUES ('Gary Sinise');
INSERT INTO actor (full_name)
  VALUES ('Daveigh Chase');
INSERT INTO actor (full_name)
  VALUES ('Suzanne Pleshette');
INSERT INTO actor (full_name)
  VALUES ('Miyu Irino');
INSERT INTO actor (full_name)
  VALUES ('Hitoshi Takagi');
INSERT INTO actor (full_name)
  VALUES ('Noriko Hidaka');
INSERT INTO actor (full_name)
  VALUES ('Chika Sakamoto');
INSERT INTO actor (full_name)
  VALUES ('Cate Blanchett');
INSERT INTO actor (full_name)
  VALUES ('Matt Damon');
INSERT INTO actor (full_name)
  VALUES ('Liam Neeson');
INSERT INTO actor (full_name)
  VALUES ('Chieko Baishô');
INSERT INTO actor (full_name)
  VALUES ('Takuya Kimura');
INSERT INTO actor (full_name)
  VALUES ('Tatsuya Gashûin');
INSERT INTO actor (full_name)
  VALUES ('Kirsten Dunst');
INSERT INTO actor (full_name)
  VALUES ('Minami Takayama');
INSERT INTO actor (full_name)
  VALUES ('Yôji Matsuda');
INSERT INTO actor (full_name)
  VALUES ('Yuriko Ishida');
INSERT INTO actor (full_name)
  VALUES ('Yûko Tanaka');
INSERT INTO actor (full_name)
  VALUES ('Lin-Manuel Miranda');
INSERT INTO actor (full_name)
  VALUES ('Phillipa Soo');
INSERT INTO actor (full_name)
  VALUES ('Leslie Odom Jr.');
INSERT INTO actor (full_name)
  VALUES ('Keanu Reeves');
INSERT INTO actor (full_name)
  VALUES ('Laurence Fishburne');
INSERT INTO actor (full_name)
  VALUES ('Carrie-Anne Moss');
INSERT INTO actor (full_name)
  VALUES ('Robert Downey Jr.');
INSERT INTO actor (full_name)
  VALUES ('Chris Evans');
INSERT INTO actor (full_name)
  VALUES ('Chris Pratt');
INSERT INTO actor (full_name)
  VALUES ('Scarlett Johansson');
INSERT INTO actor (full_name)
  VALUES ('Mark Ruffalo');
INSERT INTO actor (full_name)
  VALUES ('Chris Hemsworth');
INSERT INTO actor (full_name)
  VALUES ('Vin Diesel');
INSERT INTO actor (full_name)
  VALUES ('Bradley Cooper');
INSERT INTO actor (full_name)
  VALUES ('Zoe Saldana');
INSERT INTO actor (full_name)
  VALUES ('Dave Bautista');
INSERT INTO actor (full_name)
  VALUES ('Hugo Weaving');
INSERT INTO actor (full_name)
  VALUES ('Chadwick Boseman');
INSERT INTO actor (full_name)
  VALUES ('Michael B. Jordan');
INSERT INTO actor (full_name)
  VALUES ('Lupita Nyong''o');
INSERT INTO actor (full_name)
  VALUES ('Benedict Cumberbatch');
INSERT INTO actor (full_name)
  VALUES ('Chiwetel Ejiofor');
INSERT INTO actor (full_name)
  VALUES ('Rachel McAdams');
INSERT INTO actor (full_name)
  VALUES ('Jim Carrey');
INSERT INTO actor (full_name)
  VALUES ('Tom Wilkinson');
INSERT INTO actor (full_name)
  VALUES ('Kate Winslet');
INSERT INTO actor (full_name)
  VALUES ('Dante Basco');
INSERT INTO actor (full_name)
  VALUES ('Zach Tyler');
INSERT INTO actor (full_name)
  VALUES ('Mae Whitman');
INSERT INTO actor (full_name)
  VALUES ('Jack De Sena');
INSERT INTO actor (full_name)
  VALUES ('Michaela Jill Murphy');

INSERT INTO movie_genre (genre)
  VALUES ('Crime');
INSERT INTO movie_genre (genre)
  VALUES ('Drama');
INSERT INTO movie_genre (genre)
  VALUES ('Animation');
INSERT INTO movie_genre (genre)
  VALUES ('Adventure');
INSERT INTO movie_genre (genre)
  VALUES ('Family');
INSERT INTO movie_genre (genre)
  VALUES ('Comedy');
INSERT INTO movie_genre (genre)
  VALUES ('Fantasy');
INSERT INTO movie_genre (genre)
  VALUES ('Romance');
INSERT INTO movie_genre (genre)
  VALUES ('Action');
INSERT INTO movie_genre (genre)
  VALUES ('Biography');
INSERT INTO movie_genre (genre)
  VALUES ('History');
INSERT INTO movie_genre (genre)
  VALUES ('Science-Fiction');