-- CREATE TABLE IF NOT EXISTS perks (
--     subscription_id BIGINT NOT NULL,
--     description VARCHAR(255),
--     PRIMARY KEY (subscription_id,description),
--     FOREIGN KEY (subscription_id) REFERENCES subscriptions(subscription_id)
--     ON DELETE CASCADE
--     ON UPDATE CASCADE
-- );
INSERT INTO perks (subscription_id, description) VALUES
(1, "Ad-Free Experience"),
(1, "Unlimited Skips"),
(2, "Exclusive Content"),
(2, "Offline Listening"),
(3, "Priority Support"),
(3, "Early Access to New Releases"),
(4, "Access to Premium Podcasts"),
(5, "VIP Concert Invitations"),
(6, "Discounted Merchandise"),
(7, "Bonus Tracks Access"),
(8, "Exclusive Artist Interviews"),
(9, "No Ads and Offline Mode"),
(10, "Exclusive Streaming Rights");