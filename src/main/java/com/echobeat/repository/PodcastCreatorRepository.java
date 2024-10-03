package com.echobeat.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.PodcastCreator;

@Repository
public class PodcastCreatorRepository implements PodcastCreatorInterface {
    private final JdbcTemplate jdbcTemplate;

    public PodcastCreatorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PodcastCreator save(PodcastCreator podcastCreator) {
        String sql = "INSERT INTO podcast_creators (track_id, artist_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, podcastCreator.getTrack_id(), podcastCreator.getArtist_id());
        // Returning the saved PodcastCreator (assuming the artist_id doesn't change)
        return podcastCreator;
    }

    @Override
    public PodcastCreator delete(long trackId, long artistId) {
        PodcastCreator podcastCreator = findByTrackIdAndArtistId(trackId, artistId);
        if (podcastCreator != null) {
            String sql = "DELETE FROM podcast_creators WHERE track_id = ? AND artist_id = ?";
            jdbcTemplate.update(sql, trackId, artistId);
        }
        return podcastCreator; // Return the deleted PodcastCreator
    }

    @Override
    public void update(PodcastCreator podcastCreator) {
        String sql = "UPDATE podcast_creators SET artist_id = ? WHERE track_id = ?";
        jdbcTemplate.update(sql, podcastCreator.getArtist_id(), podcastCreator.getTrack_id());
    }

    @Override
    public PodcastCreator findByTrackIdAndArtistId(long trackId, long artistId) {
        String sql = "SELECT * FROM podcast_creators WHERE track_id = ? AND artist_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(PodcastCreator.class), trackId, artistId);
    }

    @Override
    public List<PodcastCreator> findAll() {
        String sql = "SELECT * FROM podcast_creators";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PodcastCreator.class));
    }
}
