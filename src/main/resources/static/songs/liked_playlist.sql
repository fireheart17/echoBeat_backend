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
