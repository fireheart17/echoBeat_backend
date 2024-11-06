-- CREATE TABLE IF NOT EXISTS subscriptions (
--     subscription_id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     title VARCHAR(255),
--     price INT,
--     duration INT
-- );
INSERT INTO subscriptions (subscription_id, title, price, duration) VALUES
(1, "Free", 0, 0),
(2, "Premium", 10, 30),
(3, "Family", 15, 30),
(4, "Student", 5, 30),
(5, "Premium", 10, 30),
(6, "Family", 15, 30),
(7, "Student", 5, 30),
(8, "Free", 0, 0),
(9, "Premium", 10, 30),
(10, "Family", 15, 30);