BEGIN TRANSACTION;

DROP TABLE IF EXISTS collection_record, tags, user_record_tag, user_record, record_track, record_artist, record_label, artist_genre, labels, genres, tracks, artists, records, collections, users CASCADE;

DROP SEQUENCE IF EXISTS seq_user_id, seq_collection_id, seq_label_id CASCADE;

CREATE SEQUENCE seq_user_id
	INCREMENT BY 1
	START WITH 1001
	NO MAXVALUE;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	is_premium boolean NOT NULL DEFAULT false,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE seq_collection_id
	INCREMENT BY 1
	START WITH 101
	NO MAXVALUE;

CREATE TABLE collections (
   collection_id int NOT NULL DEFAULT nextval('seq_collection_id'),
   user_id int NOT NULL,
   collection_name varchar(50) NOT NULL,
   is_public boolean NOT NULL DEFAULT false,
   CONSTRAINT PK_collection_id PRIMARY KEY (collection_id),
   CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);


CREATE TABLE records (
	record_id varChar(30) NOT NULL, --Not serial because it will be created by the API
	record_title varChar(200) NOT NULL,
	record_artist varChar(50),
	artist_genre varChar(50),
	record_image varChar(1000) NOT NULL,
	CONSTRAINT PK_record_id PRIMARY KEY (record_id)
);

CREATE TABLE collection_record (
    collection_id int NOT NULL,
    record_id varChar(30) NOT NULL,
    CONSTRAINT PK_collection_id_record_id PRIMARY KEY (collection_id,record_id),
    CONSTRAINT FK_collection_id FOREIGN KEY (collection_id) REFERENCES collections(collection_id),
    CONSTRAINT FK_record_id FOREIGN KEY (record_id) REFERENCES records(record_id)
);

CREATE TABLE user_record (
	user_id int NOT NULL,
	record_id varChar(30) NOT NULL,
	user_note varChar(500),
	record_condition varChar(20),
	CONSTRAINT PK_user_id_record_id PRIMARY KEY (user_id, record_id),
	CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT FK_record_id FOREIGN KEY (record_id) REFERENCES records(record_id)
);

CREATE TABLE tags (
    tag_name varChar(30) NOT NULL,
    CONSTRAINT PK_tag_name PRIMARY KEY (tag_name)
);

CREATE TABLE user_record_tag (
    tag_name varChar(30) NOT NULL,
    record_id varChar(30) NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT PK_tag_name_record_id_user_id PRIMARY KEY (tag_name, record_id, user_id),
    CONSTRAINT FK_tag_name FOREIGN KEY (tag_name) REFERENCES tags(tag_name),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT FK_record_id FOREIGN KEY (record_id) REFERENCES records(record_id)
);

-- These are database triggers.  Triggers can enforce rules, and here we are enforcing the amount of records
-- one can INSERT into the collection_record table. When it is triggered it runs the check_max_records() function.

-- The function below declares an INT called record_count, selects COUNT(*) from a specific collection_record id, and throws it
-- into record_count. If the user exceeds 25 records and his premium status = false, they cannot add more.

-- the $$ are delimiters.  They enclose and define the body of the function

CREATE OR REPLACE FUNCTION check_max_records()
RETURNS TRIGGER AS $$
DECLARE
  record_count INT;
BEGIN
  SELECT COUNT(*) INTO record_count
  FROM collection_record cr
  JOIN collections c ON cr.collection_id = c.collection_id
  JOIN users u ON c.user_id = u.user_id
  WHERE cr.collection_id = NEW.collection_id;

  IF (SELECT u.is_premium
      FROM users u
      JOIN collections c ON c.user_id = u.user_id
      WHERE c.collection_id = NEW.collection_id) = false
      AND record_count >= 25 THEN
    RAISE EXCEPTION 'Free users can have at most 25 records in a collection.';
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- the $$ indicates the method is closed, and LANGUAGE is a keyword that lets you specify a programming language to use,
-- in this case PL/pgSQL, which is an extension of SQL that allows procedural code within your database.


-- this is the actual database trigger.  The trigger must always come after the function so it has a
-- or it will have nothing to search for, and will most definitely break your code.

CREATE TRIGGER record_limit_trigger
BEFORE INSERT ON collection_record
FOR EACH ROW
EXECUTE FUNCTION  check_max_records();


CREATE OR REPLACE FUNCTION check_collection_limit()
RETURNS TRIGGER AS $$
BEGIN
  IF (SELECT u.is_premium
      FROM users u
      WHERE u.user_id = NEW.user_id) = false
  AND (SELECT COUNT(*)
      FROM collections c
      WHERE c.user_id = NEW.user_id) > 0 THEN
    RAISE EXCEPTION 'Free users can have at most 1 collection.';
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER collection_limit_trigger
BEFORE INSERT ON collections
FOR EACH ROW
EXECUTE FUNCTION check_collection_limit();

--INSERT INTO artists

--CREATE TABLE genres (
--	genre_id SERIAL,
--	genre_name varChar(50) NOT NULL,
--	CONSTRAINT PK_genre_id PRIMARY KEY (genre_id)
--);
--
--CREATE TABLE artists (
--	artist_id int NOT NULL, --Not serial because it will be created by the API
--	artist_name varChar(50) NOT NULL,
--	CONSTRAINT PK_artist_id PRIMARY KEY (artist_id)
--);
--
--CREATE TABLE artist_genre (
--	genre_id int NOT NULL,
--	artist_id int NOT NULL,
--	CONSTRAINT PK_artist_id_genre_id PRIMARY KEY (genre_id, artist_id),
--	CONSTRAINT FK_artist_id FOREIGN KEY (artist_id) REFERENCES artists(artist_id),
--	CONSTRAINT FK_genre_id FOREIGN KEY (genre_id) REFERENCES genres(genre_id)
--);
--CREATE SEQUENCE seq_label_id
--	INCREMENT BY 1
--	START WITH 1001
--	NO MAXVALUE;
--
--CREATE TABLE labels (
--	label_id int NOT NULL DEFAULT nextval('seq_label_id'),
--	label_name varChar(50) NOT NULL,
--	CONSTRAINT PK_label_id PRIMARY KEY (label_id)
--);
--
--CREATE TABLE record_label (
--	record_id varChar(30) NOT NULL,
--	label_id int NOT NULL,
--	CONSTRAINT PK_record_id_label_id PRIMARY KEY (record_id, label_id),
--	CONSTRAINT FK_record_id FOREIGN KEY (record_id) REFERENCES records(record_id),
--	CONSTRAINT FK_label_id FOREIGN KEY (label_id) REFERENCES labels(label_id)
--);
--
--CREATE TABLE record_artist (
--	record_id varChar(30) NOT NULL,
--	artist_id int NOT NULL,
--	CONSTRAINT PK_record_id_artist_id PRIMARY KEY (record_id, artist_id),
--	CONSTRAINT FK_record_id FOREIGN KEY (record_id) REFERENCES records(record_id),
--	CONSTRAINT FK_artist_id FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
--);
--
--CREATE TABLE tracks (
--	track_id varChar(30) NOT NULL,
--	title varChar(30) NOT NULL,
--	duration int,
--	track_number int,
--	CONSTRAINT PK_track_id PRIMARY KEY (track_id)
--);
--
--CREATE TABLE record_track (
--	record_id varChar(30) NOT NULL,
--	track_id varChar(30) NOT NULL,
--	CONSTRAINT PK_record_id_track_id PRIMARY KEY (record_id, track_id),
--	CONSTRAINT FK_record_id FOREIGN KEY (record_id) REFERENCES records(record_id),
--	CONSTRAINT FK_track_id FOREIGN KEY (track_id) REFERENCES tracks(track_id)
--);

COMMIT TRANSACTION;

