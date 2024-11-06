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