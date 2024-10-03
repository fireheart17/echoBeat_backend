package com.echobeat.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.TrackCreator;

@Repository
public class TrackCreatorRepository implements TrackCreatorInterface {
    private final JdbcTemplate jdbcTemplate;

    public TrackCreatorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TrackCreator save(TrackCreator trackCreator) {
        String sql = "INSERT INTO track_creators (track_id, artist_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, trackCreator.getTrack_id(), trackCreator.getArtist_id());
        // Returning the saved trackCreator (assuming the artist_id doesn't change)
        return trackCreator;
    }

    @Override
    public TrackCreator delete(long trackId, long artistId) {
        TrackCreator podcastCreator = findByTrackIdAndArtistId(trackId, artistId);
        if (podcastCreator != null) {
            String sql = "DELETE FROM track_creators WHERE track_id = ? AND artist_id = ?";
            jdbcTemplate.update(sql, trackId, artistId);
        }
        return podcastCreator; // Return the deleted PodcastCreator
    }

    @Override
    public void update(TrackCreator podcastCreator) {
        String sql = "UPDATE track_creators SET artist_id = ? WHERE track_id = ?";
        jdbcTemplate.update(sql, podcastCreator.getArtist_id(), podcastCreator.getTrack_id());
    }

    @Override
    public TrackCreator findByTrackIdAndArtistId(long trackId, long artistId) {
        String sql = "SELECT * FROM track_creators WHERE track_id = ? AND artist_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(TrackCreator.class), trackId, artistId);
    }

    @Override
    public List<TrackCreator> findAll() {
        String sql = "SELECT * FROM track_creators";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(TrackCreator.class));
    }
}
