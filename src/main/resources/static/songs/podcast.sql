-- CREATE TABLE IF NOT EXISTS podcast (
--     podcast_id BIGINT PRIMARY KEY AUTO_INCREMENT,
--     podcast_name VARCHAR(255),
--     genre VARCHAR(100),
--     lyrics TEXT,
--     duration INT,
--     country VARCHAR(100),
--     like_count INT DEFAULT 0,
--     listen_count INT DEFAULT 0
-- );
INSERT INTO podcast (podcast_id, podcast_name, genre, lyrics, duration, country, like_count, listen_count) VALUES
(1, "The Joe Rogan Experience", "Talk", "Interesting interviews", 180, "USA", 0, 0),
(2, "TED Talks Daily", "Education", "Inspiring talks", 30, "USA", 0, 0),
(3, "Stuff You Should Know", "Education", "Explaining how things work", 60, "USA", 0, 0),
(4, "The Daily", "News", "Breaking news and analysis", 20, "USA", 0, 0),
(5, "The Happiness Lab", "Self-Help", "Psychological insights on happiness", 40, "USA", 0, 0),
(6, "Crime Junkie", "True Crime", "Crime stories and investigations", 60, "USA", 0, 0),
(7, "Call Her Daddy", "Comedy", "Comedy, dating, and sex talk", 45, "USA", 0, 0),
(8, "Armchair Expert", "Talk", "Celebrity interviews and discussions", 120, "USA", 0, 0),
(9, "Science Vs", "Science", "Science debates with experts", 40, "Australia", 0, 0),
(10, "The Moth", "Storytelling", "True personal stories", 50, "USA", 0, 0);