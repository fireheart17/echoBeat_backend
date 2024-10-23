package com.echobeat.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.LikedSongs;

@Repository
public class LikedSongsRepository implements LikedSongsInterface {

    // private final JdbcTemplate jdbcTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public LikedSongsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(LikedSongs likedSongs) {
        return jdbcTemplate.update("INSERT INTO liked_songs (user_id, track_id) VALUES (?, ?)",
                likedSongs.getUser_id(), likedSongs.getTrack_id());
    }

    @Override
    public int update(LikedSongs likedSongs) {
        return jdbcTemplate.update("UPDATE liked_songs SET user_id = ?, track_id = ? WHERE user_id = ? AND track_id = ?",
                likedSongs.getUser_id(), likedSongs.getTrack_id(), likedSongs.getUser_id(), likedSongs.getTrack_id());
    }

    @Override
    public int delete(long userId, String trackId) {
        return jdbcTemplate.update("DELETE FROM liked_songs WHERE user_id = ? AND track_id = ?", userId, trackId);
    }

    @Override
    public List<LikedSongs> findByTrackId(String trackId) {
        return jdbcTemplate.query("SELECT * FROM liked_songs WHERE track_id = ?",
                new BeanPropertyRowMapper<>(LikedSongs.class), trackId);
    }

    @Override
    public List<LikedSongs> findByUserId(long userId) {
        return jdbcTemplate.query("SELECT * FROM liked_songs WHERE user_id = ?",
                new BeanPropertyRowMapper<>(LikedSongs.class), userId);
    }
}