CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255),
    dob TIME,
    age INT,
    gender VARCHAR(10),
    subscription_id BIGINT,
    subscription_end_date VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS artists (
    artist_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    password VARCHAR(255),
    global_rank VARCHAR(50),
    country VARCHAR(100),
    about TEXT,
    follower_count INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS track_creators (
    track_id BIGINT,
    artist_id BIGINT,
    PRIMARY KEY (track_id, artist_id)
);

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

CREATE TABLE IF NOT EXISTS subscriptions (
    subscription_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    price INT,
    duration INT
);

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

CREATE TABLE IF NOT EXISTS playlist_tracks (
    playlist_id BIGINT NOT NULL,
    track_id BIGINT NOT NULL,
    PRIMARY KEY (playlist_id, track_id)
);