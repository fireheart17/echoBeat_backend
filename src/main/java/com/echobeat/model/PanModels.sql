CREATE TABLE IF NOT EXISTS liked_songs (
    user_id BIGINT NOT NULL,
    track_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, track_id)
);

CREATE TABLE IF NOT EXISTS perks (
    subscription_id BIGINT NOT NULL,
    description VARCHAR(255),
    PRIMARY KEY (subscription_id)
);

CREATE TABLE IF NOT EXISTS playlists (
    playlist_id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) ,
    duration INT ,
    user_id BIGINT ,
    PRIMARY KEY (playlist_id)
);