-- CREATE TABLE IF NOT EXISTS users (
--     user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
--     first_name VARCHAR(255),
--     last_name VARCHAR(255),
--     username VARCHAR(255),
--     password VARCHAR(255),
--     dob DATE,
--     age INT,
--     gender VARCHAR(10),
--     subscription_id BIGINT,
--     subscription_end_date VARCHAR(255),
--     FOREIGN KEY (subscription_id) REFERENCES subscriptions(subscription_id)
--     ON DELETE SET NULL
--     ON UPDATE CASCADE
-- );
INSERT INTO users (user_id, first_name, last_name, username, password, dob, age, gender, subscription_id, subscription_end_date) VALUES
(1, "John", "Doe", "johndoe", "password123", "1990-01-01", 34, "Male", 1, "2025-01-01"),
(2, "Jane", "Smith", "janesmith", "password123", "1995-02-15", 29, "Female", 2, "2025-02-15"),
(3, "Alice", "Johnson", "alicejohnson", "password123", "1992-03-10", 32, "Female", 3, "2025-03-10"),
(4, "Bob", "Brown", "bobbrown", "password123", "1996-04-20", 28, "Male", 4, "2025-04-20"),
(5, "Charlie", "Davis", "charliedavis", "password123", "1993-05-25", 31, "Male", 5, "2025-05-25"),
(6, "David", "Martinez", "davidmartinez", "password123", "1988-06-30", 36, "Male", 6, "2025-06-30"),
(7, "Eva", "Lopez", "evalopez", "password123", "1997-07-12", 27, "Female", 7, "2025-07-12"),
(8, "Frank", "Miller", "frankmiller", "password123", "1999-08-18", 25, "Male", 8, "2025-08-18"),
(9, "Grace", "Wilson", "gracewilson", "password123", "1994-09-05", 30, "Female", 9, "2025-09-05"),
(10, "Henry", "Taylor", "henrytaylor", "password123", "1987-10-10", 37, "Male", 10, "2025-10-10");
