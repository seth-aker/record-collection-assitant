BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, is_premium) VALUES ('Admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('User','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('saker132', '$2a$10$/QCit8V1TCeJc6T2oEeck.80jFB4fgMcCyj.0Mc9L6ccJBeEMbpEC', 'ROLE_ADMIN', true);
INSERT INTO users (username,password_hash,role, is_premium) VALUES ('john', '$2a$10$0KNXXA/DFDxF8sfgE5LszeY2GmjSyUaEmhjTFbXtx3p.qhEaVtm6K', 'ROLE_ADMIN', true); 


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
INSERT INTO records (record_id, record_title, record_artist, record_image) VALUES ('6212203','Forward Escape', 'Tipper', 'https://i.discogs.com/xXLtdZSbtFVlG4RqSqXyQCc5yKugA726ddpSAwun0VU/rs:fit/g:sm/q:90/h:600/w:600/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTYyMTIy/MDMtMTQxMzg0MDc4/OS0zMjI1LmpwZWc.jpeg');



COMMIT TRANSACTION;
