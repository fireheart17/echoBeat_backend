package com.echobeat.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.Follower;
import com.echobeat.model.User;

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

    @Override
    public int addFollowerToken(long artist_id, long user_id) {
        String sql = "INSERT INTO followers (artist_id, user_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, artist_id, user_id);
    }

    @Override
    public boolean checkFollowerToken(long artist_id, long user_id) {
        return jdbcTemplate.query("SELECT * FROM followers WHERE artist_id=? and user_id=?", new BeanPropertyRowMapper<>(Follower.class), artist_id, user_id) != null;
    }

    @Override
    public List<User> getFollowers(long artist_id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE user_id IN (SELECT user_id FROM followers WHERE artist_id=?)",
                new BeanPropertyRowMapper<>(User.class), artist_id);
    }

}
