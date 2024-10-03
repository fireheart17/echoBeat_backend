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
