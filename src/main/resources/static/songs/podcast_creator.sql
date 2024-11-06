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