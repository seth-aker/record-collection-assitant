BEGIN TRANSACTION;

DROP TABLE IF EXISTS collection_record, user_record_tag, user_record, record_track, record_artist, record_label, artist_genre, labels, genres, tracks, artists, records, collections, users;

DROP SEQUENCE IF EXISTS seq_user_id, seq_collection_id, seq_label_id;

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
	record_title varChar(50) NOT NULL,
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

CREATE TABLE user_record_tag (
    tag_name varChar(20) NOT NULL,
    record_id varChar(30) NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT PK_tag_name PRIMARY KEY (tag_name),
    CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT FK_record_id FOREIGN KEY (record_id) REFERENCES records(record_id)
);


INSERT INTO users (username,password_hash,role) VALUES ('User','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Schrodinger','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


INSERT INTO records (record_id, record_title) VALUES ('1353040','Kind of Blue');
INSERT INTO records (record_id, record_title) VALUES ('1486272','Nashville Skyline');
INSERT INTO records (record_id, record_title) VALUES ('498868','Harvest');
INSERT INTO records (record_id, record_title) VALUES ('372778','Sgt. Peppers Lonely Hearts Club Band');
INSERT INTO records (record_id, record_title) VALUES ('168314','Songs In The Key Of Life');

INSERT INTO collections (user_id, collection_name,is_public) VALUES (1002,'The Test Collection', true);
INSERT INTO collections (user_id, collection_name,is_public) VALUES (1002,'Collection Cool', true);
INSERT INTO collections (user_id, collection_name,is_public) VALUES (1002,'Private Collection', false);
INSERT INTO collections (user_id, collection_name,is_public) VALUES (1001,'Ambient Mix', false);

INSERT INTO collection_record (collection_id, record_id) VALUES (101, '1353040');--record 1--
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '498868');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '1486272');--record 2--
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '372778');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '168314');

INSERT INTO collection_record (collection_id, record_id) VALUES (102, '1353040');
INSERT INTO collection_record (collection_id, record_id) VALUES (102, '498868');--record 3--
INSERT INTO collection_record (collection_id, record_id) VALUES (102, '1486272');
INSERT INTO collection_record (collection_id, record_id) VALUES (102, '372778');--record 4--
INSERT INTO collection_record (collection_id, record_id) VALUES (102, '168314');

INSERT INTO collection_record (collection_id, record_id) VALUES (103, '1353040');--record 1--
INSERT INTO collection_record (collection_id, record_id) VALUES (103, '498868');--record 5--
INSERT INTO collection_record (collection_id, record_id) VALUES (103, '1486272');--record 2--

INSERT INTO collection_record (collection_id, record_id) VALUES (104, '1353040');
INSERT INTO collection_record (collection_id, record_id) VALUES (104, '1486272');
INSERT INTO collection_record (collection_id, record_id) VALUES (104, '498868');
INSERT INTO collection_record (collection_id, record_id) VALUES (104, '372778');


INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '1353040', 'I like this', 'Good');--user 1 / record 1--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '498868', 'I like this', 'Good');--user 1 / record 3--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '1486272', 'I like this', 'Good');--user 1 / record 2--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '372778', 'I like this', 'Good');--user 1 / record 4--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '168314', 'I like this', 'Good');--user 1 / record 5, (SHOULD CAUSE ERROR)--


INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Jazz', '1353040', 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Johns Favorites', '1353040', 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Kirbys Favorites', '1353040', 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Rock', '1353040', 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Funk', '1353040', 1001);



COMMIT;
