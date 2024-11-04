package com.echobeat.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.Artist;
import com.echobeat.model.PodcastCreator;

@Repository
public class PodcastCreatorRepository implements PodcastCreatorInterface {
    private final JdbcTemplate jdbcTemplate;

    public PodcastCreatorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PodcastCreator save(PodcastCreator podcastCreator) {
        String sql = "INSERT INTO podcast_creators (podcast_id, artist_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, podcastCreator.getPodcast_id(), podcastCreator.getArtist_id());
        // Returning the saved PodcastCreator (assuming the artist_id doesn't change)
        return podcastCreator;
    }

    @Override
    public PodcastCreator delete(long podcastId, long artistId) {
        PodcastCreator podcastCreator = findByPodcastIdAndArtistId(podcastId, artistId);
        if (podcastCreator != null) {
            String sql = "DELETE FROM podcast_creators WHERE track_id = ? AND artist_id = ?";
            jdbcTemplate.update(sql, podcastId, artistId);
        }
        return podcastCreator; // Return the deleted PodcastCreator
    }

    @Override
    public void update(PodcastCreator podcastCreator) {
        String sql = "UPDATE podcast_creators SET artist_id = ? WHERE track_id = ?";
        jdbcTemplate.update(sql, podcastCreator.getArtist_id(), podcastCreator.getPodcast_id());
    }

    @Override
    public PodcastCreator findByPodcastIdAndArtistId(long podcastId, long artistId) {
        String sql = "SELECT * FROM podcast_creators WHERE track_id = ? AND artist_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(PodcastCreator.class), podcastId, artistId);
    }

    @Override
    public List<PodcastCreator> findAll() {
        String sql = "SELECT * FROM podcast_creators";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(PodcastCreator.class));
    }

    @Override
    public List<Artist> getArtistsByPodcastId(long podcastId) {
        String sql = "SELECT * FROM artists WHERE artist_id IN (SELECT artist_id FROM podcast_creators WHERE podcast_id = ?)";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Artist.class), podcastId);
    }
}
