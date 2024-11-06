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
