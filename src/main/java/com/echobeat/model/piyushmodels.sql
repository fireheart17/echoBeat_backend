CREATE TABLE IF NOT EXISTS albums (
    album_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    genre VARCHAR(255),
    release_date TIME
);

CREATE TABLE IF NOT EXISTS tracks (
    track_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    track_name VARCHAR(255),
    genre VARCHAR(255),
    lyrics TEXT,
    duration INT,
    country VARCHAR(255),
    like_count INT DEFAULT 0,
    listen_count INT DEFAULT 0,
    album_id BIGINT
);

CREATE TABLE IF NOT EXISTS charts (
    chart_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    chart_type VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS liked_playlists (
    user_id BIGINT,
    playlist_id BIGINT,
    PRIMARY KEY (user_id, playlist_id)
);



