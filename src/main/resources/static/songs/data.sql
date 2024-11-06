-- CREATE TABLE IF NOT EXISTS subscriptions (
--     subscription_id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     title VARCHAR(255),
--     price INT,
--     duration INT
-- );
INSERT INTO subscriptions (subscription_id, title, price, duration) VALUES
(1, "Free", 0, 0),
(2, "Premium", 10, 30),
(3, "Family", 15, 30),
(4, "Student", 5, 30),
(5, "Premium", 10, 30),
(6, "Family", 15, 30),
(7, "Student", 5, 30),
(8, "Free", 0, 0),
(9, "Premium", 10, 30),
(10, "Family", 15, 30);

-- CREATE TABLE IF NOT EXISTS albums (
--     album_id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     title VARCHAR(255),
--     genre VARCHAR(255),
--     release_date TIME
-- );
INSERT INTO albums (album_id, title, genre, release_date) VALUES
(1, "Divide", "Pop", '2017-03-03'),
(2, "Purpose", "Pop", '2015-11-13'),
(3, "25", "Soul", '2015-11-20'),
(4, "After Hours", "Synthwave", '2020-03-20'),
(5, "Hollywood's Bleeding", "Hip-Hop", '2019-09-06'),
(6, "Un Verano Sin Ti", "Reggaeton", '2022-05-06'),
(7, "Future Nostalgia", "Pop", '2020-03-27'),
(8, "Views", "Hip-Hop", '2016-04-29'),
(9, "No.6 Collaborations Project", "Pop", '2019-07-12'),
(10, "Fearless", "Country", '2008-11-11'),
(11, "Stoney", "Hip-Hop", '2016-12-09'),
(12, "Justice", "R&B", '2021-03-19'),
(13, "Folklore", "Indie", '2020-07-24'),
(14, "Planet Her", "Pop", '2021-06-25'),
(15, "Certified Lover Boy", "Hip-Hop", '2021-09-03');

-- CREATE TABLE IF NOT EXISTS charts (
--     chart_id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     chart_type VARCHAR(255)
-- );
INSERT INTO charts (chart_id, chart_type) VALUES
(1, "Billboard Hot 100"),
(2, "Spotify Global Top 50"),
(3, "Apple Music Top 100"),
(4, "Billboard Global 200"),
(5, "iTunes Top Songs"),
(6, "Amazon Music Top Hits"),
(7, "Shazam Top 50"),
(8, "YouTube Music Charts"),
(9, "Pandora Top Spins"),
(10, "TikTok Viral 100");

-- CREATE TABLE IF NOT EXISTS podcast (
--     podcast_id BIGINT PRIMARY KEY AUTO_INCREMENT,
--     podcast_name VARCHAR(255),
--     genre VARCHAR(100),
--     lyrics TEXT,
--     duration INT,
--     country VARCHAR(100),
--     like_count INT DEFAULT 0,
--     listen_count INT DEFAULT 0
-- );
INSERT INTO podcast (podcast_id, podcast_name, genre, lyrics, duration, country, like_count, listen_count) VALUES
(1, "The Joe Rogan Experience", "Talk", "Interesting interviews", 180, "USA", 0, 0),
(2, "TED Talks Daily", "Education", "Inspiring talks", 30, "USA", 0, 0),
(3, "Stuff You Should Know", "Education", "Explaining how things work", 60, "USA", 0, 0),
(4, "The Daily", "News", "Breaking news and analysis", 20, "USA", 0, 0),
(5, "The Happiness Lab", "Self-Help", "Psychological insights on happiness", 40, "USA", 0, 0),
(6, "Crime Junkie", "True Crime", "Crime stories and investigations", 60, "USA", 0, 0),
(7, "Call Her Daddy", "Comedy", "Comedy, dating, and sex talk", 45, "USA", 0, 0),
(8, "Armchair Expert", "Talk", "Celebrity interviews and discussions", 120, "USA", 0, 0),
(9, "Science Vs", "Science", "Science debates with experts", 40, "Australia", 0, 0),
(10, "The Moth", "Storytelling", "True personal stories", 50, "USA", 0, 0);

-- CREATE TABLE IF NOT EXISTS artists (
--     artist_id BIGINT PRIMARY KEY AUTO_INCREMENT,
--     artist_name VARCHAR(255),
--     first_name VARCHAR(255),
--     last_name VARCHAR(255),
--     password VARCHAR(255),
--     global_rank VARCHAR(50),
--     country VARCHAR(100),
--     about TEXT,
--     follower_count INT DEFAULT 0
-- );
INSERT into artists values (1,"Ed Sheeran","Edward","Sheeran","123456789","1","England","A",0);
INSERT into artists values (2,"Justin Bieber","Justin","Bieber","123456789","2","Canada","A",0);
INSERT into artists values (3,"Arijit Singh","Arijit","Singh","123456789","3","India","A",0);
INSERT into artists values (4,"Shakira","Shakira","Isabel","123456789","4","Colombia","A",0);
INSERT into artists values (5,"Drake","Aubrey","Drake","123456789","5","Canada","A",0);
INSERT into artists values (6,"Zayn","Zain","Malik","123456789","6","England","A",0);
INSERT into artists values (7,"Post Malone","Austin","Richard","123456789","7","USA","A",0);
INSERT into artists values (8,"Luis Fonsi","Luis","Rodríguez","123456789","8","Puerto Rico","A",0);
INSERT into artists values (9,"Dua Lipa","Dua","Lipa","123456789","9","Albania","A",0);
INSERT into artists values (10,"Weeknd","Abel","Tesfaye","123456789","10","USA","A",0);

-- CREATE TABLE IF NOT EXISTS users (
--     user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
--     first_name VARCHAR(255),
--     last_name VARCHAR(255),
--     username VARCHAR(255),
--     password VARCHAR(255),
--     dob DATE,
--     age INT,
--     gender VARCHAR(10),
--     subscription_id BIGINT,
--     subscription_end_date VARCHAR(255),
--     FOREIGN KEY (subscription_id) REFERENCES subscriptions(subscription_id)
--     ON DELETE SET NULL
--     ON UPDATE CASCADE
-- );
INSERT INTO users (user_id, first_name, last_name, username, password, dob, age, gender, subscription_id, subscription_end_date) VALUES
(1, "John", "Doe", "johndoe", "password123", "1990-01-01", 34, "Male", 1, "2025-01-01"),
(2, "Jane", "Smith", "janesmith", "password123", "1995-02-15", 29, "Female", 2, "2025-02-15"),
(3, "Alice", "Johnson", "alicejohnson", "password123", "1992-03-10", 32, "Female", 3, "2025-03-10"),
(4, "Bob", "Brown", "bobbrown", "password123", "1996-04-20", 28, "Male", 4, "2025-04-20"),
(5, "Charlie", "Davis", "charliedavis", "password123", "1993-05-25", 31, "Male", 5, "2025-05-25"),
(6, "David", "Martinez", "davidmartinez", "password123", "1988-06-30", 36, "Male", 6, "2025-06-30"),
(7, "Eva", "Lopez", "evalopez", "password123", "1997-07-12", 27, "Female", 7, "2025-07-12"),
(8, "Frank", "Miller", "frankmiller", "password123", "1999-08-18", 25, "Male", 8, "2025-08-18"),
(9, "Grace", "Wilson", "gracewilson", "password123", "1994-09-05", 30, "Female", 9, "2025-09-05"),
(10, "Henry", "Taylor", "henrytaylor", "password123", "1987-10-10", 37, "Male", 10, "2025-10-10");


-- CREATE TABLE IF NOT EXISTS playlists (
--     playlist_id BIGINT NOT NULL AUTO_INCREMENT,
--     title VARCHAR(255) ,
--     duration INT ,
--     user_id BIGINT ,
--     PRIMARY KEY (playlist_id),
--     FOREIGN KEY (user_id) REFERENCES users(user_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO playlists (playlist_id, title, duration, user_id) VALUES
(1, "Top Hits", 120, 1),
(2, "Chill Vibes", 90, 2),
(3, "Workout Playlist", 150, 3),
(4, "Throwback", 180, 4),
(5, "Dance Hits", 200, 5),
(6, "Indie Vibes", 130, 6),
(7, "Rap Classics", 170, 7),
(8, "Pop Favorites", 110, 8),
(9, "Reggaeton Party", 140, 9),
(10, "Bollywood Hits", 160, 10);


-- CREATE TABLE IF NOT EXISTS tracks (
--     track_id VARCHAR(255) PRIMARY KEY,
--     track_name VARCHAR(255),
--     genre VARCHAR(255),
--     lyrics TEXT,
--     duration INT,
--     country VARCHAR(255),
--     like_count INT DEFAULT 0,
--     listen_count INT DEFAULT 0,
--     album_id BIGINT DEFAULT 0,
--     FOREIGN KEY (album_id) REFERENCES albums(album_id)
--     ON DELETE SET NULL
--     ON UPDATE CASCADE
-- );
INSERT into tracks values ("3EPXxR3ImUwfayaurPi3cm","Be Alright","Pop","A",3,"USA",0,0,0);
INSERT into tracks values ("7qiZfU4dY1lWllzX7mPBI3","Shape of You","Pop","A",4,"USA",0,0,0);
INSERT into tracks values ("6habFhsOp2NvshLv26DqMb","Despacito","Reggaeton","A",4,"USA",0,0,0);
INSERT into tracks values ("3KkXRkHbMCARz0aVfEt68P","Sunflower","Hip-Hop","A",5,"USA",0,0,0);
INSERT into tracks values ("0VjIjW4GlUZAMYd2vXMi3b","Blinding Lights","Synthwave","A",4,"USA",0,0,0);
INSERT into tracks values ("5nujrmhLynf4yMoMtj8AQF","Levitating","Pop","A",3,"USA",0,0,0);
INSERT into tracks values ("5QO79kh1waicV47BqGRL3g","Save Your Tears","Synthwave","A",4,"USA",0,0,0);
INSERT into tracks values ("4iJyoBOLtHqaGxP12qzhQI","Peaches","R&B","A",3,"USA",0,0,0);
INSERT into tracks values ("67BtfxlNbhBmCDR2L2l8qd","MONTERO (Call Me By Your Name)","Hip-Hop","A",3,"USA",0,0,0);
INSERT into tracks values ("5HCyWlXZPP0y6Gqq8TgA20","STAY","Pop","A",2,"USA",0,0,0);
INSERT into tracks values ("5CQ30WqJwcep0pYcV4AMNc","Stairway to Heaven","Rock","A",8,"USA",0,0,0);
INSERT into tracks values ("3hRV0jL3vUpRrcy398teAU","The Night We Met","Indie","A",3,"USA",0,0,0);
INSERT into tracks values ("6DCZcSspjsKoFjzjrWoCdn","God's Plan","Hip-Hop","A",3,"USA",0,0,0);
INSERT into tracks values ("4nVBt6MZDDP6tRVdQTgxJg","Story of My Life","Pop","A",4,"USA",0,0,0);
INSERT into tracks values ("2tpWsVSb9UEmDRxAl1zhX1","Counting Stars","Pop","A",4,"USA",0,0,0);
INSERT into tracks values ("35RWttZt8zGGzT0mWtlXpn","Jab Tak","Bollywood","A",4,"India",0,0,0);
INSERT into tracks values ("6DXLO8LndZMVOHM0wNbpzg","Danza Kuduro","Reggaeton","A",4,"Puerto Rico",0,0,0);
INSERT into tracks values ("7JJmb5XwzOO8jgpou264Ml","There's Nothing Holdin' Me Back","Pop","A",3,"Canada",0,0,0);
INSERT into tracks values ("4mBmsPcPa1Eu4LDTHq55Ab","Hothon Se Chhu Lo Tum","Bollywood","A",5,"India",0,0,0);


-- CREATE TABLE IF NOT EXISTS track_creators (
--     track_id VARCHAR(255),
--     artist_id BIGINT,
--     PRIMARY KEY (track_id, artist_id),
--     FOREIGN KEY (track_id) REFERENCES tracks(track_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT into track_creators values ("EPXxR3ImUwfayaurPi3cm",1);
INSERT into track_creators values ("qiZfU4dY1lWllzX7mPBI3",2);
INSERT into track_creators values ("6habFhsOp2NvshLv26DqMb",3);
INSERT into track_creators values ("3KkXRkHbMCARz0aVfEt68P",4);
INSERT into track_creators values ("VjIjW4GlUZAMYd2vXMi3b",5);
INSERT into track_creators values ("5nujrmhLynf4yMoMtj8AQF",6);
INSERT into track_creators values ("5QO79kh1waicV47BqGRL3g",7);
INSERT into track_creators values ("4iJyoBOLtHqaGxP12qzhQI",8);
INSERT into track_creators values ("67BtfxlNbhBmCDR2L2l8qd",9);
INSERT into track_creators values ("5HCyWlXZPP0y6Gqq8TgA20",10);
INSERT into track_creators values ("5CQ30WqJwcep0pYcV4AMNc",5);
INSERT into track_creators values ("3hRV0jL3vUpRrcy398teAU",8);
INSERT into track_creators values ("6DCZcSspjsKoFjzjrWoCdn",3);
INSERT into track_creators values ("4nVBt6MZDDP6tRVdQTgxJg",6);
INSERT into track_creators values ("2tpWsVSb9UEmDRxAl1zhX1",7);
INSERT into track_creators values ("35RWttZt8zGGzT0mWtlXpn",5);
INSERT into track_creators values ("6DXLO8LndZMVOHM0wNbpzg",8);
INSERT into track_creators values ("7JJmb5XwzOO8jgpou264Ml",2);
INSERT into track_creators values ("4mBmsPcPa1Eu4LDTHq55Ab",7);


-- CREATE TABLE IF NOT EXISTS liked_playlists (
--     user_id BIGINT,
--     playlist_id BIGINT,
--     PRIMARY KEY (user_id, playlist_id),
--     FOREIGN KEY (user_id) REFERENCES users(user_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     FOREIGN KEY (playlist_id) REFERENCES playlists(playlist_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO liked_playlists (user_id, playlist_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 6),
(6, 7),
(7, 8),
(8, 9),
(9, 10),
(10, 1),
(10, 2),
(9, 3),
(8, 4),
(7, 5);


-- CREATE TABLE IF NOT EXISTS liked_songs (
--     user_id BIGINT NOT NULL,
--     track_id VARCHAR(255) NOT NULL,
--     PRIMARY KEY (user_id, track_id),
--     FOREIGN KEY (user_id) REFERENCES users(user_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     FOREIGN KEY (track_id) REFERENCES tracks(track_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO liked_songs (user_id, track_id) VALUES
(1, "7qiZfU4dY1lWllzX7mPBI3"),
(2, "3EPXxR3ImUwfayaurPi3cm"),
(3, "6habFhsOp2NvshLv26DqMb"),
(4, "0VjIjW4GlUZAMYd2vXMi3b"),
(5, "3KkXRkHbMCARz0aVfEt68P"),
(6, "5nujrmhLynf4yMoMtj8AQF"),
(7, "4iJyoBOLtHqaGxP12qzhQI"),
(8, "67BtfxlNbhBmCDR2L2l8qd"),
(9, "5HCyWlXZPP0y6Gqq8TgA20"),
(10, "5CQ30WqJwcep0pYcV4AMNc"),
(1, "3hRV0jL3vUpRrcy398teAU"),
(2, "6DCZcSspjsKoFjzjrWoCdn"),
(3, "4nVBt6MZDDP6tRVdQTgxJg"),
(4, "2tpWsVSb9UEmDRxAl1zhX1"),
(5, "35RWttZt8zGGzT0mWtlXpn");


-- CREATE TABLE IF NOT EXISTS perks (
--     subscription_id BIGINT NOT NULL,
--     description VARCHAR(255),
--     PRIMARY KEY (subscription_id,description),
--     FOREIGN KEY (subscription_id) REFERENCES subscriptions(subscription_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO perks (subscription_id, description) VALUES
(1, "Ad-Free Experience"),
(1, "Unlimited Skips"),
(2, "Exclusive Content"),
(2, "Offline Listening"),
(3, "Priority Support"),
(3, "Early Access to New Releases"),
(4, "Access to Premium Podcasts"),
(5, "VIP Concert Invitations"),
(6, "Discounted Merchandise"),
(7, "Bonus Tracks Access"),
(8, "Exclusive Artist Interviews"),
(9, "No Ads and Offline Mode"),
(10, "Exclusive Streaming Rights");


-- CREATE TABLE IF NOT EXISTS playlist_tracks (
--     playlist_id BIGINT NOT NULL,
--     track_id VARCHAR(255) NOT NULL,
--     PRIMARY KEY (playlist_id, track_id),
--     FOREIGN KEY (playlist_id) REFERENCES playlists(playlist_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     FOREIGN KEY (track_id) REFERENCES tracks(track_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO playlist_tracks (playlist_id, track_id) VALUES
(1, "7qiZfU4dY1lWllzX7mPBI3"),
(1, "3EPXxR3ImUwfayaurPi3cm"),
(2, "6habFhsOp2NvshLv26DqMb"),
(2, "0VjIjW4GlUZAMYd2vXMi3b"),
(3, "3KkXRkHbMCARz0aVfEt68P"),
(3, "5nujrmhLynf4yMoMtj8AQF"),
(4, "4iJyoBOLtHqaGxP12qzhQI"),
(4, "67BtfxlNbhBmCDR2L2l8qd"),
(5, "5HCyWlXZPP0y6Gqq8TgA20"),
(5, "5CQ30WqJwcep0pYcV4AMNc"),
(6, "3hRV0jL3vUpRrcy398teAU"),
(7, "6DCZcSspjsKoFjzjrWoCdn"),
(8, "4nVBt6MZDDP6tRVdQTgxJg"),
(9, "2tpWsVSb9UEmDRxAl1zhX1"),
(10, "35RWttZt8zGGzT0mWtlXpn");

-- CREATE TABLE IF NOT EXISTS podcast_creators (
--     podcast_id BIGINT,
--     artist_id BIGINT,
--     PRIMARY KEY (podcast_id, artist_id),
--     FOREIGN KEY (podcast_id) REFERENCES podcast(podcast_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO podcast_creators (podcast_id, artist_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);

-- CREATE TABLE IF NOT EXISTS rankings (
--     track_id VARCHAR(255),
--     chart_id BIGINT,
--     rank_val BIGINT,
--     PRIMARY KEY (chart_id, rank_val),
--     FOREIGN KEY (track_id) REFERENCES tracks(track_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     FOREIGN KEY (chart_id) REFERENCES charts(chart_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO rankings (track_id, chart_id, rank_val) VALUES
("7qiZfU4dY1lWllzX7mPBI3", 1, 1),
("3EPXxR3ImUwfayaurPi3cm", 2, 1),
("6habFhsOp2NvshLv26DqMb", 3, 1),
("0VjIjW4GlUZAMYd2vXMi3b", 4, 1),
("3KkXRkHbMCARz0aVfEt68P", 1, 2),
("5nujrmhLynf4yMoMtj8AQF", 1, 3),
("4iJyoBOLtHqaGxP12qzhQI", 2, 2),
("67BtfxlNbhBmCDR2L2l8qd", 3, 2),
("5HCyWlXZPP0y6Gqq8TgA20", 4, 3),
("5CQ30WqJwcep0pYcV4AMNc", 1, 4);


-- CREATE TABLE IF NOT EXISTS SocialMedia (
--     artist_id BIGINT,
--     socialmediatype VARCHAR(255),
--     socialmediahandle VARCHAR(255),
--     PRIMARY KEY (artist_id, socialmediatype),
--     FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO SocialMedia (artist_id, socialmediatype, socialmediahandle) VALUES
(1, "Twitter", "@EdSheeran"),
(2, "Instagram", "@JustinBieber"),
(3, "Facebook", "/ArijitSingh"),
(4, "Twitter", "@Shakira"),
(5, "Instagram", "@Drake"),
(6, "Twitter", "@ZaynMalik"),
(7, "Facebook", "/PostMalone"),
(8, "Instagram", "@LuisFonsi"),
(9, "Twitter", "@DuaLipa"),
(10, "Facebook", "/TheWeeknd");

-- CREATE TABLE IF NOT EXISTS followers (
--     artist_id BIGINT NOT NULL,
--     user_id BIGINT NOT NULL,
--     PRIMARY KEY (artist_id, user_id),
--     FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     FOREIGN KEY (user_id) REFERENCES users(user_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO followers (artist_id, user_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 6);


-- CREATE TABLE IF NOT EXISTS liked_albums (
--     user_id BIGINT NOT NULL,
--     album_id BIGINT NOT NULL,
--     PRIMARY KEY (user_id, album_id),
--     FOREIGN KEY (user_id) REFERENCES users(user_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     FOREIGN KEY (album_id) REFERENCES albums(album_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO liked_albums (user_id, album_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(1, 3),
(2, 4),
(3, 5),
(4, 6),
(5, 7);


-- CREATE TABLE IF NOT EXISTS liked_podcasts (
--     user_id BIGINT NOT NULL,
--     podcast_id BIGINT NOT NULL,
--     PRIMARY KEY (user_id, podcast_id),
--     FOREIGN KEY (user_id) REFERENCES users(user_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     FOREIGN KEY (podcast_id) REFERENCES podcast(podcast_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO liked_podcasts (user_id, podcast_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 6);

-- CREATE TABLE IF NOT EXISTS created_album (
--     album_id BIGINT NOT NULL,
--     artist_id BIGINT NOT NULL,
--     PRIMARY KEY (album_id, artist_id),
--     FOREIGN KEY (album_id) REFERENCES albums(album_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE,
--     FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO created_album (album_id, artist_id) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);