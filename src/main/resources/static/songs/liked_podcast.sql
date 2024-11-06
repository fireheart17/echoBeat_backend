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