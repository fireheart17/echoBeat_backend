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