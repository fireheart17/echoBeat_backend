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