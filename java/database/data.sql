BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO records (record_id, record_title) VALUES ('1353040','Kind of Blue');
INSERT INTO records (record_id, record_title) VALUES ('1486272','Nashville Skyline');
INSERT INTO records (record_id, record_title) VALUES ('498868','Harvest');
INSERT INTO records (record_id, record_title) VALUES ('372778','Sgt. Peppers Lonely Hearts Club Band');
INSERT INTO records (record_id, record_title) VALUES ('168314','Songs In The Key Of Life');

INSERT INTO collections (user_id, collection_name,is_public) VALUES (1001,'The Test Collection', true);
INSERT INTO collections (user_id, collection_name,is_public) VALUES (1001,'Collection Cool', true);
INSERT INTO collections (user_id, collection_name,is_public) VALUES (1001,'Private Collection', false);

INSERT INTO collection_record (collection_id, record_id) VALUES (101, 1353040);
INSERT INTO collection_record (collection_id, record_id) VALUES (101, 498868);
INSERT INTO collection_record (collection_id, record_id) VALUES (101, 1486272);
INSERT INTO collection_record (collection_id, record_id) VALUES (101, 372778);
INSERT INTO collection_record (collection_id, record_id) VALUES (101, 168314);

INSERT INTO collection_record (collection_id, record_id) VALUES (102, 1353040);
INSERT INTO collection_record (collection_id, record_id) VALUES (102, 498868);
INSERT INTO collection_record (collection_id, record_id) VALUES (102, 1486272);
INSERT INTO collection_record (collection_id, record_id) VALUES (102, 372778);
INSERT INTO collection_record (collection_id, record_id) VALUES (102, 168314);

INSERT INTO collection_record (collection_id, record_id) VALUES (103, 1353040);
INSERT INTO collection_record (collection_id, record_id) VALUES (103, 498868);
INSERT INTO collection_record (collection_id, record_id) VALUES (103, 1486272);


INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, 1353040, 'I like this', 'Good');
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, 498868, 'I like this', 'Good');
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, 1486272, 'I like this', 'Good');
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, 372778, 'I like this', 'Good');
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, 168314, 'I like this', 'Good');


INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Jazz', 1353040, 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Johns Favorites', 1353040, 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Kirbys Favorites', 1353040, 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Rock', 1353040, 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Funk', 1353040, 1001);

--INSERT INTO artists
--(artist_id, artist_name)
--VALUES
--(0,'The Tests');
--
--INSERT INTO genres
--(genre_id, genre_name)
--VALUES
--(0,'Oldies');
--
--INSERT INTO labels
--(label_id, label_name)
--VALUES
--(0, 'Start Testing Records');
--
--INSERT INTO tracks
--(track_id, title, duration, track_number)
--VALUES
--('tteesstt0','One', 222222, 1),
--('tteesstt1','Two', 220000, 2),
--('tteesstt2','Three', 210000, 3),
--('tteesstt3','Four', 230000, 4),
--('tteesstt4','Five', 200000, 5),
--('tteesstt5','Six', 290000, 6),
--('tteesstt6','Seven', 330000, 7);

COMMIT TRANSACTION;
