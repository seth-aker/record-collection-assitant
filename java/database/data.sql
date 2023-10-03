BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('User','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Schrodinger','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','USER_AND_NOT_A_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('user1', 'user1', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2', 'user2', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3', 'user3', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('seth', '$2a$10$/QCit8V1TCeJc6T2oEeck.80jFB4fgMcCyj.0Mc9L6ccJBeEMbpEC', 'ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('john', '$2a$10$0KNXXA/DFDxF8sfgE5LszeY2GmjSyUaEmhjTFbXtx3p.qhEaVtm6K', 'ROLE_ADMIN'); --this was removed for some reason, added 10/02



INSERT INTO records (record_id, record_title, record_image) VALUES ('1353040', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('1486272', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('498868', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('372778', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('168314', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg');

INSERT INTO collections (user_id, collection_name, is_public) VALUES (1002, 'The Test Collection', true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1002, 'Collection Cool', true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1002, 'Private Collection', false);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1001, 'Ambient Mix', false);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1008, 'The Best of Test', true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1008, 'The Best of Test 2', false);

INSERT INTO collection_record (collection_id, record_id) VALUES (101, '1353040');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '498868');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '1486272');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '372778');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '168314');

INSERT INTO collection_record (collection_id, record_id) VALUES (102, '1353040');
INSERT INTO collection_record (collection_id, record_id) VALUES (102, '498868');
INSERT INTO collection_record (collection_id, record_id) VALUES (102, '1486272');
INSERT INTO collection_record (collection_id, record_id) VALUES (102, '372778');
INSERT INTO collection_record (collection_id, record_id) VALUES (102, '168314');

INSERT INTO collection_record (collection_id, record_id) VALUES (103, '1353040');
INSERT INTO collection_record (collection_id, record_id) VALUES (103, '498868');
INSERT INTO collection_record (collection_id, record_id) VALUES (103, '1486272');

INSERT INTO collection_record (collection_id, record_id) VALUES (104, '1353040');
INSERT INTO collection_record (collection_id, record_id) VALUES (104, '1486272');
INSERT INTO collection_record (collection_id, record_id) VALUES (104, '498868');
INSERT INTO collection_record (collection_id, record_id) VALUES (104, '372778');

INSERT INTO collection_record (collection_id, record_id) VALUES (105, '1486272');
INSERT INTO collection_record (collection_id, record_id) VALUES (106, '498868');


INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '1353040', 'I like this', 'Good');--user 1 / record 1--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '498868', 'I like this', 'Good');--user 1 / record 3--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '1486272', 'I like this', 'Good');--user 1 / record 2--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '372778', 'I like this', 'Good');--user 1 / record 4--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '168314', 'I like this', 'Good');--user 1 / record 5, (SHOULD CAUSE ERROR)--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1008, '1486272', 'Me gusta mucho', 'Good');
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1008, '372778', 'Muy bueno', 'Good');


INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Jazz', '1353040', 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Johns Favorites', '1353040', 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Kirbys Favorites', '1353040', 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Rock', '1353040', 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Funk', '1353040', 1001);

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
