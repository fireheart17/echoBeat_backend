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
