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
