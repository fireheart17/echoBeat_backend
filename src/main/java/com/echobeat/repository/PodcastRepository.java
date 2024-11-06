package com.echobeat.repository;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.Podcast;

@Repository
public class PodcastRepository implements PodcastInterface {

    private final JdbcTemplate jdbcTemplate;

    public PodcastRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Save a new podcast and return it
    @Override
    public int save(Podcast podcast) {
        String sql = "INSERT INTO podcast (podcast_id, podcast_name, genre, lyrics, duration, country, like_count, listen_count) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, podcast.getPodcast_id(), podcast.getPodcast_name(), podcast.getGenre(), podcast.getLyrics(),
                            podcast.getDuration(), podcast.getCountry(), podcast.getLike_count(), podcast.getListen_count());

    }

    // Update an existing podcast and return it
    @Override
    public Podcast update(Podcast podcast) {
        String sql = "UPDATE podcast SET podcast_name = ?, genre = ?, lyrics = ?, duration = ?, country = ?, " +
                     "like_count = ?, listen_count = ? WHERE podcast_id = ?";
        jdbcTemplate.update(sql, podcast.getPodcast_name(), podcast.getGenre(), podcast.getLyrics(), podcast.getDuration(),
                            podcast.getCountry(), podcast.getLike_count(), podcast.getListen_count(), podcast.getPodcast_id());

        // Fetch and return the updated Podcast
        return findById(podcast.getPodcast_id());
    }

    // Delete podcast by ID and return the deleted podcast
    @Override
    public Podcast deleteById(long podcastId) {
        // Fetch the podcast before deleting it
        Podcast podcast = findById(podcastId);

        String sql = "DELETE FROM podcast WHERE podcast_id = ?";
        jdbcTemplate.update(sql, podcastId);

        // Return the deleted podcast
        return podcast;
    }

    // Find podcast by ID
    @Override
    public Podcast findById(long podcastId) {
        String sql = "SELECT * FROM podcast WHERE podcast_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Podcast.class), podcastId);
    }

    @Override
    public List<Podcast> search(String keyword) {
        String sql = "SELECT * FROM podcast WHERE podcast_name LIKE ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Podcast.class), keyword + "%");
    }
}

