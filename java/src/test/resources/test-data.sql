BEGIN;

INSERT INTO users (username,password_hash,role, is_premium) VALUES ('User','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('Schrodinger','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','USER_AND_NOT_A_USER', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('Admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user1', 'user1', 'ROLE_USER', false);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user2', 'user2', 'ROLE_USER', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('user3', 'user3', 'ROLE_USER', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('seth', '$2a$10$/QCit8V1TCeJc6T2oEeck.80jFB4fgMcCyj.0Mc9L6ccJBeEMbpEC', 'ROLE_ADMIN', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('john', '$2a$10$0KNXXA/DFDxF8sfgE5LszeY2GmjSyUaEmhjTFbXtx3p.qhEaVtm6K', 'ROLE_ADMIN', true); --this was removed for some reason, added 10/02

INSERT INTO records (record_id, record_title, record_image) VALUES ('1', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('2', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('3', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('4', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('5', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('6', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('7', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('8', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('9', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('10', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('11', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('12', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('13', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('14', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('15', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('16', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('17', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('18', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('19', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('20', 'Songs In The Key Of Life','https://i.discogs.com/3PiDzC0Fn4Ot-m02vrjsGAsIbck2fU-R2b9g_EJRHP0/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwODky/NDEyLTE1MzI3NzY5/MTEtODEzMS5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('21', 'Kind of Blue', 'https://i.discogs.com/HfTjPxtmfSpll3yHaogArZEhqh8fSFRXiyAzec2aQaY/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTkzMjI4/MTYtMTQ3ODU3NTcy/OC03OTMwLmpwZWc.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('22', 'Nashville Skyline', 'https://i.discogs.com/iWfKlsFIuysQE-EysfZKtV6muCjpPBCDc4_DPDdSnTs/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTE0MDM3/ODAwLTE1Njg2NjQx/MTAtNjk0MS5qcGVn.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('23', 'Harvest', 'https://i.discogs.com/y5YpQDGFxagrQmMwiI2ThRGCdXxoZxF046meBjNd3Tw/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEwNDQy/ODctMTQwMDMyNzM1/OS02OTM1LmpwZWc.jpeg');
INSERT INTO records (record_id, record_title, record_image) VALUES ('26', 'Sgt. Peppers Lonely Hearts Club Band', 'https://i.discogs.com/X9qfdXjTtICVY7HOm51lZVqr1V9KdKOm5efxaXPtugQ/rs:fit/g:sm/q:40/h:150/w:150/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTEzMzQz/OTQtMTMxODg5OTU2/My5qcGVn.jpeg');

INSERT INTO collections (user_id, collection_name, is_public) VALUES (1004, 'The Testingbass Collection', true);

INSERT INTO collection_record (collection_id, record_id) VALUES (101, '1');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '2');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '3');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '4');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '5');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '6');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '7');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '8');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '9');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '10');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '11');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '12');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '13');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '14');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '15');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '16');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '17');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '18');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '19');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '20');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '21');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '22');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '23');
INSERT INTO collection_record (collection_id, record_id) VALUES (101, '24');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '25');
--INSERT INTO collection_record (collection_id, record_id) VALUES (101, '26');


COMMIT;
