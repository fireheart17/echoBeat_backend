package com.echobeat.repository;

import com.echobeat.model.LikedPodcasts;
import com.echobeat.model.Playlist;
import com.echobeat.model.Podcast;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LikedPodcastsRepository implements LikedPodcastsInterface {

    private final JdbcTemplate jdbcTemplate;

    // Constructor to inject JdbcTemplate
    public LikedPodcastsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to add a liked podcast
    @Override
    public int addLikedPodcast(LikedPodcasts likedPodcast) {
        String sql = "INSERT INTO liked_podcasts (user_id, podcast_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, likedPodcast.getUser_id(), likedPodcast.getPodcast_id());
    }

    // Method to remove a liked podcast
    @Override
    public int removeLikedPodcast(long user_id, long podcast_id) {
        String sql = "DELETE FROM liked_podcasts WHERE user_id = ? AND podcast_id = ?";
        return jdbcTemplate.update(sql, user_id, podcast_id);
    }

    @Override
    public List<Podcast> findLikedPodcastsByUserId(long userId) {
        return jdbcTemplate.query("SELECT * from podcast where podcast_id in (SELECT podcast_id FROM liked_podcasts WHERE user_id = ?)",
                new BeanPropertyRowMapper<>(Podcast.class), userId);
    }
}
