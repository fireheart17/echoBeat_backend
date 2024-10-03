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