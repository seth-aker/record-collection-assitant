BEGIN TRANSACTION;

DROP TABLE IF EXISTS collection_user, collections, user_record, records, users;

DROP SEQUENCE IF EXISTS seq_user_id, seq_collection_id;

CREATE SEQUENCE seq_user_id
	INCREMENT BY 1
	START WITH 1001
	NO MAXVALUE;

CREATE TABLE users (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
	
);

CREATE SEQUENCE seq_collection_id 
	INCREMENT BY 1
	START WITH 101
	NO MAXVALUE;

CREATE TABLE collections (
   collection_id int NOT NULL DEFAULT nextval('seq_collection_id'),
   collection_name varchar(50) NOT NULL,
   is_public boolean NOT NULL DEFAULT false,
   CONSTRAINT PK_collection PRIMARY KEY (collection_id)
);

CREATE TABLE collection_user (
	user_id int NOT NULL,
	collection_id int NOT NULL,
	CONSTRAINT PK_collection_id_user_id PRIMARY KEY (collection_id, user_id),
	CONSTRAINT FK_user_id FOREIGN KEY(user_id) REFERENCES users (user_id),
	CONSTRAINT FK_collection_id FOREIGN KEY(collection_id) REFERENCES collections(collection_id)
);

CREATE TABLE records (
	record_id int NOT NULL, --Not serial because it will be created by the API
	user_note varChar(500),
	CONSTRAINT PK_record_id PRIMARY KEY (record_id)
);

CREATE TABLE collection_record (
    collection_id int NOT NULL,
    record_id int NOT NULL,
    CONSTRAINT PK_collection_id_record_id PRIMARY KEY (collection_id,record_id),
    CONSTRAINT FK_collection_id FOREIGN KEY (collection_id) REFERENCES collections(collection_id),
    CONSTRAINT FK_record_id FOREIGN KEY (record_id) REFERENCES records(record_id)
);

CREATE TABLE user_record (
	user_id int NOT NULL,
	record_id int NOT NULL,
	CONSTRAINT PK_user_id_record_id PRIMARY KEY (user_id, record_id),
	CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT FK_record_id FOREIGN KEY (record_id) REFERENCES records(record_id)
);

-- CREATE TABLE genres (
-- 	genre_id int SERIAL,
-- 	genre_name varChar(50) NOT NULL,
-- 	CONSTRAINT PK_genre_id PRIMARY KEY (genre_id),
-- );

-- CREATE TABLE record_genre (
-- 	genre_id int NOT NULL,
-- 	record_id int NOT NULL,
-- 	CONSTRAINT PK_record_id_genre_id PRIMARY KEY (genre_id, record_id),
-- 	CONSTRAINT FK_record_id FOREIGN KEY (record_id) REFERENCES records(record_id),
-- 	CONSTRAINT FK_genre_id FOREIGN KEY (genre_id) REFERENCES genres(genre_id)
-- );

-- CREATE TABLE labels (
-- 	label_id int NOT NULL, --Not serial because it will be created by the API
-- 	label_name varChar(50) NOT NULL,
-- 	CONSTRAINT PK_label_id PRIMARY KEY (label_id),
-- );

-- CREATE TABLE record_label (
-- 	record_id int NOT NULL,
-- 	label_id int NOT NULL,
-- 	CONSTRAINT PK_record_id_label_id PRIMARY KEY (record_id, label_id),
-- 	CONSTRAINT FK_record_id FOREIGN KEY record_id REFERENCES record(record_id),
-- 	CONSTRAINT FK_label_id FOREIGN KEY label_id REFERENCES labels(label_id)
-- );

-- CREATE TABLE artists (
-- 	artist_id int NOT NULL, --Not serial because it will be created by the API
-- 	artist_name varChar(50),

-- )

COMMIT TRANSACTION;
