-- CREATE TABLE IF NOT EXISTS SocialMedia (
--     artist_id BIGINT,
--     socialmediatype VARCHAR(255),
--     socialmediahandle VARCHAR(255),
--     PRIMARY KEY (artist_id, socialmediatype),
--     FOREIGN KEY (artist_id) REFERENCES artists(artist_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO SocialMedia (artist_id, socialmediatype, socialmediahandle) VALUES
(1, "Twitter", "@EdSheeran"),
(2, "Instagram", "@JustinBieber"),
(3, "Facebook", "/ArijitSingh"),
(4, "Twitter", "@Shakira"),
(5, "Instagram", "@Drake"),
(6, "Twitter", "@ZaynMalik"),
(7, "Facebook", "/PostMalone"),
(8, "Instagram", "@LuisFonsi"),
(9, "Twitter", "@DuaLipa"),
(10, "Facebook", "/TheWeeknd");