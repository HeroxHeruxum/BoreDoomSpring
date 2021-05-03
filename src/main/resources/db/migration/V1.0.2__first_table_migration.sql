#multiple media related tables
CREATE TABLE setting (
    id INT NOT NULL AUTO_INCREMENT,
    setting VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE activity_type (
	id INT NOT NULL AUTO_INCREMENT,
    activity_type VARCHAR(200) NOT NULL,
    primary key (id)
) ENGINE=INNODB;
     
#movie related tables
CREATE TABLE movie_genre (
	id INT NOT NULL AUTO_INCREMENT,
    genre VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=INNODB;

CREATE TABLE actor (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(750),
    last_name VARCHAR(750),
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE director (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(750),
    last_name VARCHAR(750),
    PRIMARY KEY (id)
)  ENGINE=INNODB;

CREATE TABLE movie (
    id INT NOT NULL AUTO_INCREMENT,
    setting_id INT NOT NULL,
    director_id INT NOT NULL,
    title VARCHAR(300) NOT NULL,
    description TEXT(2000) NOT NULL,
    publishing_year DATE NOT NULL,
    min_age SMALLINT NOT NULL,
    duration_minutes SMALLINT NOT NULL,
    image_url TEXT(2048),
    PRIMARY KEY (id),
    INDEX (setting_id),
    INDEX (director_id),
    FOREIGN KEY (setting_id)
        REFERENCES setting (id),
    FOREIGN KEY (director_id)
        REFERENCES director (id)
)  ENGINE=INNODB;

#book related tables 
CREATE TABLE book_genre (
	id INT NOT NULL AUTO_INCREMENT,
    genre VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=INNODB;
    
CREATE TABLE author (
    id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(750) NOT NULL,
    last_name VARCHAR(750) NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
     
CREATE TABLE book (
    id INT NOT NULL AUTO_INCREMENT,
    setting_id INT NOT NULL,
    author_id INT NOT NULL,
    title VARCHAR(300) NOT NULL,
    description TEXT(2000) NOT NULL,
    publishing_year DATE NOT NULL,
    min_age SMALLINT NOT NULL,
    duration_hour SMALLINT NOT NULL,
    page_count MEDIUMINT NOT NULL,
    image_url TEXT(2048),
    PRIMARY KEY (id),
    INDEX (setting_id),
    INDEX (author_id),
    FOREIGN KEY (setting_id)
        REFERENCES setting (id),
    FOREIGN KEY (author_id)
        REFERENCES author (id)
)  ENGINE=INNODB;
     
#connector relation tables
CREATE TABLE book2book_genre (
	book_id INT NOT NULL,
    book_genre_id INT NOT NULL,
    PRIMARY KEY (book_id, book_genre_id),
    index (book_id),
    index (book_genre_id),
    foreign key (book_id) references book (id),
    foreign key (book_genre_id) references book_genre (id)
) ENGINE=INNODB;

CREATE TABLE book2activity_type (
	book_id INT NOT NULL,
    activity_type_id INT NOT NULL,
    PRIMARY KEY (book_id, activity_type_id),
    index (book_id),
    index (activity_type_id),
    foreign key (book_id) references book (id),
    foreign key (activity_type_id) references activity_type (id)
) ENGINE=INNODB;

CREATE TABLE movie2movie_genre (
	movie_id INT NOT NULL,
    movie_genre_id INT NOT NULL,
    PRIMARY KEY (movie_id, movie_genre_id),
    index (movie_id),
    index (movie_genre_id),
    foreign key (movie_id) references movie (id),
    foreign key (movie_genre_id) references movie_genre (id)
) ENGINE=INNODB;

CREATE TABLE movie2activity_type (
	movie_id INT NOT NULL,
    activity_type_id INT NOT NULL,
    PRIMARY KEY (movie_id, activity_type_id),
    index (movie_id),
    index (activity_type_id),
    foreign key (movie_id) references movie (id),
    foreign key (activity_type_id) references activity_type (id)
) ENGINE=INNODB;

CREATE TABLE movie2actor (
	movie_id INT NOT NULL,
    actor_id INT NOT NULL,
    PRIMARY KEY (movie_id, actor_id),
    index (movie_id),
    index (actor_id),
    foreign key (movie_id) references movie (id),
    foreign key (actor_id) references actor (id)
) ENGINE=INNODB;

#Question related tables
CREATE TABLE question_type (
	id INT NOT NULL AUTO_INCREMENT,
    question_type VARCHAR(40) NOT NULL,
    primary key (id)
) ENGINE=INNODB;

CREATE TABLE question (
	id INT NOT NULL AUTO_INCREMENT,
    question TEXT(6000) NOT NULL,
    question_type_id INT NOT NULL,
    primary key (id),
    index (question_type_id),
    foreign key (question_type_id) references question_type (id)
) ENGINE=INNODB;

CREATE TABLE choice (
	id INT NOT NULL AUTO_INCREMENT,
    choice VARCHAR(1000) NOT NULL,
    primary key (id)
) ENGINE=INNODB;

CREATE TABLE question2choice (
	question_id INT NOT NULL,
    choice_id INT NOT NULL,
    PRIMARY KEY (question_id, choice_id),
    index (question_id),
    index (choice_id),
    foreign key (question_id) references question (id),
    foreign key (choice_id) references choice (id)
) ENGINE=INNODB;

#user related tables 
CREATE TABLE user (
	id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    email TEXT(1000) NOT NULL,
    password VARCHAR(30) NOT NULL,
    registration_date DATE NOT NULL,
    PRIMARY KEY (id)
) ENGINE=INNODB;

CREATE 
    TRIGGER  today_user
 BEFORE INSERT ON user FOR EACH ROW 
    SET @registration_date = CURDATE();
    
CREATE TABLE user2book (
	user_id INT NOT NULL,
    book_id INT NOT NULL,
    PRIMARY KEY (user_id, book_id),
    index (user_id),
    index (book_id),
    foreign key (user_id) references user (id),
    foreign key (book_id) references book (id)
) ENGINE=INNODB;

CREATE TABLE user2movie (
	user_id INT NOT NULL,
    movie_id INT NOT NULL,
    PRIMARY KEY (user_id, movie_id),
    index (user_id),
    index (movie_id),
    foreign key (user_id) references user (id),
    foreign key (movie_id) references movie (id)
) ENGINE=INNODB;