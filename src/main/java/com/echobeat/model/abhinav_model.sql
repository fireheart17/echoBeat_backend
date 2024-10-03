
CREATE TABLE IF NOT EXISTS podcast_creators (
    track_id BIGINT,
    artist_id BIGINT,
    PRIMARY KEY (track_id, artist_id)
);

CREATE TABLE IF NOT EXISTS podcast (
    podcast_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    podcast_name VARCHAR(255),
    genre VARCHAR(100),
    lyrics TEXT,
    duration INT,
    country VARCHAR(100),
    like_count INT DEFAULT 0,
    listen_count INT DEFAULT 0
);
