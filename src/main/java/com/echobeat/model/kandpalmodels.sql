CREATE TABLE IF NOT EXISTS followers (
    artist_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    PRIMARY KEY (artist_id, user_id)
);
CREATE TABLE IF NOT EXISTS liked_albums (
    user_id BIGINT NOT NULL,
    album_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, album_id)
);
CREATE TABLE IF NOT EXISTS liked_podcasts (
    user_id BIGINT NOT NULL,
    podcast_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, podcast_id)
);
