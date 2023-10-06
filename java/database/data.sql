BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, is_premium) VALUES ('User','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('Schrodinger','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','USER_AND_NOT_A_USER', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('Admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user1', 'user1', 'ROLE_USER', false);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user2', 'user2', 'ROLE_USER', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user3', 'user3', 'ROLE_USER', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('saker132', '$2a$10$/QCit8V1TCeJc6T2oEeck.80jFB4fgMcCyj.0Mc9L6ccJBeEMbpEC', 'ROLE_ADMIN', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('john', '$2a$10$0KNXXA/DFDxF8sfgE5LszeY2GmjSyUaEmhjTFbXtx3p.qhEaVtm6K', 'ROLE_ADMIN', true); --this was removed for some reason, added 10/02

INSERT INTO records (record_id, record_title, record_image, record_artist) VALUES ('1353040', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg', 'Miles Davis');
INSERT INTO records (record_id, record_title, record_image, record_artist) VALUES ('1486272', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg', 'Bob Dylan');
INSERT INTO records (record_id, record_title, record_image, record_artist) VALUES ('498868', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg', 'Neil Young');
INSERT INTO records (record_id, record_title, record_image, record_artist) VALUES ('372778', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg', 'The Beatles');
INSERT INTO records (record_id, record_title, record_image, record_artist) VALUES ('168314', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg', 'Stevie Wonder');

INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('10611337','Space Jesus','Space Jesus', 'https://i.discogs.com/L2xQUYmvKUkUYwuIIIeKIOiKvxcOJ9_uxqFGnSGvJQo/rs:fit/g:sm/q:90/h:450/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNjEx/MzM3LTE1MDA5MTQ4/NzgtMTgyNy5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('11207632','Squeeze Box: The Complete Works Of "Weird Al" Yankovic','"Weird Al" Yankovic','https://i.discogs.com/9PGnbvmJzN3KpmA_10kABxgfDt7CqjIiPyx3B1s-428/rs:fit/g:sm/q:90/h:603/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTExMjA3/NjMyLTE1MTE4NzY2/MTItMjA5Mi5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('12113933','The Most Hated','Polyphia','https://i.discogs.com/mr5S7Gsc00FMCva6_hoGkD2KBX2xzUIonsIXJZbZ_xo/rs:fit/g:sm/q:90/h:604/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEyMTEz/OTMzLTE1Mjg1Nzgz/MDAtNTU5Mi5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('13132722','Super 90s','KADINJA','https://i.discogs.com/LQIvMb-_K2wHb3CYKV26F6RLwpYBpDe5ruFtoRJO2R4/rs:fit/g:sm/q:90/h:609/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMTMy/NzIyLTE1NDg2MTky/NjctNjc3Mi5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('14166343','Grands Prix Sacem 2017','Various','https://i.discogs.com/IwkoMm4mkwg-c08Lsu9RqgxM-RvsLZyLtZcYACMoHNM/rs:fit/g:sm/q:90/h:580/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MTY2/MzQzLTE1NjkwOTA0/MTctNDQwNi5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('14542275','Jettison Mind Hatch','Tipper', 'https://i.discogs.com/4PWYU2fkTV01kiioEn_M98VKOdUmYgS_SAg2hMvnmKY/rs:fit/g:sm/q:90/h:600/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0NTQy/Mjc1LTE1NzcyMDg1/MjQtNjYyMS5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('15069758','Dedication.Nostalgia.Addiction','KADINJA','https://i.discogs.com/CENiqbV5zWz15l3oRrjFjZc8cfJHIv8hw60eckGYqlI/rs:fit/g:sm/q:90/h:536/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE1MDY5/NzU4LTE2MzAxODYz/MTctNDE2MC5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('17596780','Broken Soul Jamboree','Tipper','https://i.discogs.com/w1xLDv4fiiPJLLy5LbAVJnGMiP9eSgCxLt5gGb3xFhY/rs:fit/g:sm/q:90/h:250/w:250/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE3NTk2/NzgwLTE2MTQzNzgz/MzMtNzI3NC5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('26615120','Remember That You Will Die','Polyphia','https://i.discogs.com/WK7XQ-17U-sAKbtrSJ7ECYnlH9nQyEZxU8ym-gQE6lE/rs:fit/g:sm/q:90/h:603/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTI2NjE1/MTIwLTE2ODAzNTU0/NjktNzQ1Ni5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('2718','The Fat Of The Land','Some Dude', 'https://i.discogs.com/m1J21BFLhqpt57-sZXrXelxJCCx96CjAJOukfI8p-yU/rs:fit/g:sm/q:90/h:601/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTI3MTgt/MTY3MjI1OTU4MS04/MzYyLmpwZWc.jpeg');

INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('15069758','Dedication.Nostalgia.Addiction','KADINJA','https://i.discogs.com/CENiqbV5zWz15l3oRrjFjZc8cfJHIv8hw60eckGYqlI/rs:fit/g:sm/q:90/h:536/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE1MDY5/NzU4LTE2MzAxODYz/MTctNDE2MC5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('15069758','Dedication.Nostalgia.Addiction','KADINJA','https://i.discogs.com/CENiqbV5zWz15l3oRrjFjZc8cfJHIv8hw60eckGYqlI/rs:fit/g:sm/q:90/h:536/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE1MDY5/NzU4LTE2MzAxODYz/MTctNDE2MC5qcGVn.jpeg');


INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('6212203','Forward Escape', 'Tipper', 'https://i.discogs.com/xXLtdZSbtFVlG4RqSqXyQCc5yKugA726ddpSAwun0VU/rs:fit/g:sm/q:90/h:600/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTYyMTIy/MDMtMTQxMzg0MDc4/OS0zMjI1LmpwZWc.jpeg');

INSERT INTO collections (user_id, collection_name, is_public) VALUES (1001, 'The Test Collection', true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1001, 'Collection Cool', true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1002, 'Private Collection', true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1002, 'Ambient Mix', true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1003, 'The Best of a Test', true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1003, 'The Best of the Test 2', false);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1004, 'The Best of Tests', true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1005, 'The Best of Tests 2', false);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1005, 'The Best of Tests is the best', true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1005, 'This is the Best Test',true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1006, 'This is the Best Test 2', true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1006, 'Best Test', false);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1007, 'Best Test 2', true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1007, 'lala2', false);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1008, 'aghh', true);
INSERT INTO collections (user_id, collection_name, is_public) VALUES (1008, 'funky', false);


INSERT INTO collection_record (collection_id, record_id) VALUES (101, '1353040');
INSERT INTO collection_record (collection_id, record_id) VALUES (102, '498868');
INSERT INTO collection_record (collection_id, record_id) VALUES (103, '1486272');
INSERT INTO collection_record (collection_id, record_id) VALUES (104, '372778');
INSERT INTO collection_record (collection_id, record_id) VALUES (105, '168314');
INSERT INTO collection_record (collection_id, record_id) VALUES (106, '1353040');
INSERT INTO collection_record (collection_id, record_id) VALUES (103, '498868');
INSERT INTO collection_record (collection_id, record_id) VALUES (104, '1486272');
INSERT INTO collection_record (collection_id, record_id) VALUES (104, '372778');
INSERT INTO collection_record (collection_id, record_id) VALUES (105, '168314');

INSERT INTO collection_record (collection_id, record_id) VALUES (105, '1353040');
INSERT INTO collection_record (collection_id, record_id) VALUES (106, '498868');
INSERT INTO collection_record (collection_id, record_id) VALUES (107, '1486272');

INSERT INTO collection_record (collection_id, record_id) VALUES (111, '1353040');
INSERT INTO collection_record (collection_id, record_id) VALUES (110,'1486272');
INSERT INTO collection_record (collection_id, record_id) VALUES (102, '498868');
INSERT INTO collection_record (collection_id, record_id) VALUES (103, '372778');

INSERT INTO collection_record (collection_id, record_id) VALUES (112, '1486272');
INSERT INTO collection_record (collection_id, record_id) VALUES (105, '498868');


INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '1353040', 'I like this', 'Good');--user 1 / record 1--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '498868', 'I like this', 'Good');--user 1 / record 3--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '1486272', 'I like this', 'Good');--user 1 / record 2--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '372778', 'I like this', 'Good');--user 1 / record 4--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '168314', 'I like this', 'Good');--user 1 / record 5, (SHOULD CAUSE ERROR)--
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1008, '1486272', 'Me gusta mucho', 'Good');
INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1008, '372778', 'Muy bueno', 'Good');

INSERT INTO tags (tag_name) VALUES ('Jazz');
INSERT INTO tags (tag_name) VALUES ('Johns Favorites');
INSERT INTO tags (tag_name) VALUES ('Kirbys Favorites');
INSERT INTO tags (tag_name) VALUES ('Rock');
INSERT INTO tags (tag_name) VALUES ('Funk');

INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Jazz', '1353040', 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Johns Favorites', '1353040', 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Kirbys Favorites', '1353040', 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Rock', '1353040', 1001);
INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Funk', '1353040', 1001);
--
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('User','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('Schrodinger','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','USER_AND_NOT_A_USER', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('Admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user1', 'user1', 'ROLE_USER', false);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user2', 'user2', 'ROLE_USER', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user3', 'user3', 'ROLE_USER', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('seth', '$2a$10$/QCit8V1TCeJc6T2oEeck.80jFB4fgMcCyj.0Mc9L6ccJBeEMbpEC', 'ROLE_ADMIN', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('john', '$2a$10$0KNXXA/DFDxF8sfgE5LszeY2GmjSyUaEmhjTFbXtx3p.qhEaVtm6K', 'ROLE_ADMIN', true); --this was removed for some reason, added 10/02
--
--INSERT INTO records (record_id, record_title, record_image) VALUES ('1', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('2', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('3', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('4', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('5', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('6', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('7', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('8', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('9', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('10', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('11', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('12', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('13', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('14', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('15', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('16', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('17', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('18', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('19', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('20', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('21', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('22', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('23', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('24', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('25', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('26', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1004, 'The Testingbass Collection', true);
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '1');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '2');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '3');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '4');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '5');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '6');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '7');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '8');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '9');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '10');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '11');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '12');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '13');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '14');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '15');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '16');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '17');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '18');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '19');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '20');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '21');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '22');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '23');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '24');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '25');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '26');




--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('User','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('Schrodinger','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','USER_AND_NOT_A_USER', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('Admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user1', 'user1', 'ROLE_USER', false);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user2', 'user2', 'ROLE_USER', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user3', 'user3', 'ROLE_USER', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('seth', '$2a$10$/QCit8V1TCeJc6T2oEeck.80jFB4fgMcCyj.0Mc9L6ccJBeEMbpEC', 'ROLE_ADMIN', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('john', '$2a$10$0KNXXA/DFDxF8sfgE5LszeY2GmjSyUaEmhjTFbXtx3p.qhEaVtm6K', 'ROLE_ADMIN', true); --this was removed for some reason, added 10/02
--
--INSERT INTO records (record_id, record_title, record_image, record_artist) VALUES ('1353040', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg', 'Miles Davis');
--INSERT INTO records (record_id, record_title, record_image, record_artist) VALUES ('1486272', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg', 'Bob Dylan');
--INSERT INTO records (record_id, record_title, record_image, record_artist) VALUES ('498868', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg', 'Neil Young');
--INSERT INTO records (record_id, record_title, record_image, record_artist) VALUES ('372778', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg', 'The Beatles');
--INSERT INTO records (record_id, record_title, record_image, record_artist) VALUES ('168314', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg', 'Stevie Wonder');
--
--INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('10611337','Space Jesus','Space Jesus', 'https://i.discogs.com/L2xQUYmvKUkUYwuIIIeKIOiKvxcOJ9_uxqFGnSGvJQo/rs:fit/g:sm/q:90/h:450/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNjEx/MzM3LTE1MDA5MTQ4/NzgtMTgyNy5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('11207632','Squeeze Box: The Complete Works Of "Weird Al" Yankovic','"Weird Al" Yankovic','https://i.discogs.com/9PGnbvmJzN3KpmA_10kABxgfDt7CqjIiPyx3B1s-428/rs:fit/g:sm/q:90/h:603/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTExMjA3/NjMyLTE1MTE4NzY2/MTItMjA5Mi5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('12113933','The Most Hated','Polyphia','https://i.discogs.com/mr5S7Gsc00FMCva6_hoGkD2KBX2xzUIonsIXJZbZ_xo/rs:fit/g:sm/q:90/h:604/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEyMTEz/OTMzLTE1Mjg1Nzgz/MDAtNTU5Mi5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('13132722','Super 90s','KADINJA','https://i.discogs.com/LQIvMb-_K2wHb3CYKV26F6RLwpYBpDe5ruFtoRJO2R4/rs:fit/g:sm/q:90/h:609/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMTMy/NzIyLTE1NDg2MTky/NjctNjc3Mi5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('14166343','Grands Prix Sacem 2017','Various','https://i.discogs.com/IwkoMm4mkwg-c08Lsu9RqgxM-RvsLZyLtZcYACMoHNM/rs:fit/g:sm/q:90/h:580/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MTY2/MzQzLTE1NjkwOTA0/MTctNDQwNi5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('14542275','Jettison Mind Hatch','Tipper', 'https://i.discogs.com/4PWYU2fkTV01kiioEn_M98VKOdUmYgS_SAg2hMvnmKY/rs:fit/g:sm/q:90/h:600/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0NTQy/Mjc1LTE1NzcyMDg1/MjQtNjYyMS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('15069758','Dedication.Nostalgia.Addiction','KADINJA','https://i.discogs.com/CENiqbV5zWz15l3oRrjFjZc8cfJHIv8hw60eckGYqlI/rs:fit/g:sm/q:90/h:536/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE1MDY5/NzU4LTE2MzAxODYz/MTctNDE2MC5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('17596780','Broken Soul Jamboree','Tipper','https://i.discogs.com/w1xLDv4fiiPJLLy5LbAVJnGMiP9eSgCxLt5gGb3xFhY/rs:fit/g:sm/q:90/h:250/w:250/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE3NTk2/NzgwLTE2MTQzNzgz/MzMtNzI3NC5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('26615120','Remember That You Will Die','Polyphia','https://i.discogs.com/WK7XQ-17U-sAKbtrSJ7ECYnlH9nQyEZxU8ym-gQE6lE/rs:fit/g:sm/q:90/h:603/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTI2NjE1/MTIwLTE2ODAzNTU0/NjktNzQ1Ni5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('2718','The Fat Of The Land','Some Dude', 'https://i.discogs.com/m1J21BFLhqpt57-sZXrXelxJCCx96CjAJOukfI8p-yU/rs:fit/g:sm/q:90/h:601/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTI3MTgt/MTY3MjI1OTU4MS04/MzYyLmpwZWc.jpeg');
--
--INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('323003','Home Invasion & The Last Temptation Of Ice','Ice-T','https://i.discogs.com/IhCLsJOYvdrbEg9-OZCcArirF04sLl4PufygTXEjBV4/rs:fit/g:sm/q:90/h:600/w:596/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTMyMzAw/My0xMzg4NzYyMDAz/LTY1MTYuanBlZw.jpeg');
--INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('4582264','Bachs Greatest Fugues Scored For Double Orchestra','Johann Sebastian Bach','https://i.discogs.com/Wtjx8DBOjkIGX9BxJRbwqkNAwD36bac_KghxIbNOBTI/rs:fit/g:sm/q:90/h:600/w:597/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTQ1ODIy/NjQtMTM3NTIxODAw/Ny04OTk5LmpwZWc.jpeg');
--
--
--INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('6212203','Forward Escape', 'Tipper', 'https://i.discogs.com/xXLtdZSbtFVlG4RqSqXyQCc5yKugA726ddpSAwun0VU/rs:fit/g:sm/q:90/h:600/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTYyMTIy/MDMtMTQxMzg0MDc4/OS0zMjI1LmpwZWc.jpeg');
--
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1001, 'The Test Collection', true);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1001, 'Collection Cool', true);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1002, 'Private Collection', true);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1002, 'Ambient Mix', true);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1003, 'The Best of a Test', true);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1003, 'The Best of the Test 2', false);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1004, 'The Best of Tests', true);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1005, 'The Best of Tests 2', false);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1005, 'The Best of Tests is the best', true);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1006, 'This is the Best Test',true);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1016, 'This is the Best Test 2', true);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1017, 'Best Test', false);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1007, 'Best Test 2', true);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1008, 'lala2', false);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1008, 'aghh', true);
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1009, 'funky', false);


--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '1353040');
--INSERT INTO collection_record (collection_id, record_id) VALUES (102, '1486272');
--INSERT INTO collection_record (collection_id, record_id) VALUES (103, '498868');
--INSERT INTO collection_record (collection_id, record_id) VALUES (104, '372778');
--INSERT INTO collection_record (collection_id, record_id) VALUES (105, '10611337');
--INSERT INTO collection_record (collection_id, record_id) VALUES (106, '11207632');
--INSERT INTO collection_record (collection_id, record_id) VALUES (107, '12113933');
--INSERT INTO collection_record (collection_id, record_id) VALUES (108, '14166343');
--INSERT INTO collection_record (collection_id, record_id) VALUES (109, '14542275');
--INSERT INTO collection_record (collection_id, record_id) VALUES (110, '15069758');
--
--INSERT INTO collection_record (collection_id, record_id) VALUES (111, '17596780');
--INSERT INTO collection_record (collection_id, record_id) VALUES (112, '26615120');
--INSERT INTO collection_record (collection_id, record_id) VALUES (113, '2718');
--
--INSERT INTO collection_record (collection_id, record_id) VALUES (114, '323003');
--INSERT INTO collection_record (collection_id, record_id) VALUES (115, '1486272');
--INSERT INTO collection_record (collection_id, record_id) VALUES (104, '4582264');
--INSERT INTO collection_record (collection_id, record_id) VALUES (104, '372778');
--
--INSERT INTO collection_record (collection_id, record_id) VALUES (105, '6212203');
--INSERT INTO collection_record (collection_id, record_id) VALUES (106, '498868');
--
--
--INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '1353040', 'I like this', 'Good');--user 1 / record 1--
--INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '498868', 'I like this', 'Good');--user 1 / record 3--
--INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '1486272', 'I like this', 'Good');--user 1 / record 2--
--INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '372778', 'I like this', 'Good');--user 1 / record 4--
--INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1001, '168314', 'I like this', 'Good');--user 1 / record 5, (SHOULD CAUSE ERROR)--
--INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1008, '1486272', 'Me gusta mucho', 'Good');
--INSERT INTO user_record (user_id, record_id, user_note, record_condition ) VALUES (1008, '372778', 'Muy bueno', 'Good');
--
--INSERT INTO tags (tag_name) VALUES ('Jazz');
--INSERT INTO tags (tag_name) VALUES ('Johns Favorites');
--INSERT INTO tags (tag_name) VALUES ('Kirbys Favorites');
--INSERT INTO tags (tag_name) VALUES ('Rock');
--INSERT INTO tags (tag_name) VALUES ('Funk');
--
--INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Jazz', '1353040', 1001);
--INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Johns Favorites', '1353040', 1001);
--INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Kirbys Favorites', '1353040', 1001);
--INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Rock', '1353040', 1001);
--INSERT INTO user_record_tag (tag_name, record_id, user_id) VALUES ('Funk', '1353040', 1001);
----
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('User','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('Schrodinger','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','USER_AND_NOT_A_USER', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('Admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user1', 'user1', 'ROLE_USER', false);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user2', 'user2', 'ROLE_USER', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user3', 'user3', 'ROLE_USER', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('seth', '$2a$10$/QCit8V1TCeJc6T2oEeck.80jFB4fgMcCyj.0Mc9L6ccJBeEMbpEC', 'ROLE_ADMIN', true);
--INSERT INTO users (username,password_hash,role, is_premium) VALUES ('john', '$2a$10$0KNXXA/DFDxF8sfgE5LszeY2GmjSyUaEmhjTFbXtx3p.qhEaVtm6K', 'ROLE_ADMIN', true); --this was removed for some reason, added 10/02
--
--INSERT INTO records (record_id, record_title, record_image) VALUES ('1', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('2', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('3', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('4', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('5', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('6', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('7', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('8', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('9', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('10', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('11', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('12', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('13', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('14', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('15', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('16', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('17', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('18', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('19', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('20', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('21', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('22', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('23', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('24', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('25', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
--INSERT INTO records (record_id, record_title, record_image) VALUES ('26', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
--INSERT INTO collections (user_id, collection_name, is_public) VALUES (1004, 'The Testingbass Collection', true);
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '1');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '2');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '3');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '4');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '5');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '6');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '7');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '8');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '9');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '10');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '11');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '12');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '13');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '14');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '15');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '16');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '17');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '18');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '19');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '20');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '21');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '22');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '23');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '24');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '25');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '26');

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
