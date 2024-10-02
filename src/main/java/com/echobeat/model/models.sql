CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    dob TIME,
    age INT,
    gender VARCHAR(10),
    subscription_id BIGINT,
    subscription_end_date VARCHAR(255)
);
