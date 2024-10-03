package com.echobeat.repository;

import com.echobeat.model.Follower;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FollowerRepository implements FollowerInterface {

    private final JdbcTemplate jdbcTemplate;

    // Constructor to inject JdbcTemplate
    public FollowerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to add a follower and return the number of affected rows
    @Override
    public int addFollower(Follower follower) {
        String sql = "INSERT INTO followers (artist_id, user_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, follower.getArtist_id(), follower.getUser_id());
    }

    // Method to remove a follower and return the number of affected rows
    @Override
    public int removeFollower(long artist_id, long user_id) {
        String sql = "DELETE FROM followers WHERE artist_id = ? AND user_id = ?";
        return jdbcTemplate.update(sql, artist_id, user_id);
    }
}
