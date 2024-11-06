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