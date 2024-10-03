package com.echobeat.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.Track;

@Repository
public class TrackRepository implements TrackInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Save a new track
    @Override
    public int save(Track track) {
        String sql = "INSERT INTO tracks (track_name, genre, lyrics, duration, country, like_count, listen_count, album_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, track.getTrack_name(), track.getGenre(), track.getLyrics(),
                track.getDuration(), track.getCountry(), track.getLike_count(), track.getListen_count(), 
                track.getAlbum_id());
    }

    // Update an existing track
    @Override
    public int update(Track track) {
        String sql = "UPDATE tracks SET track_name = ?, genre = ?, lyrics = ?, duration = ?, " +
                     "country = ?, like_count = ?, listen_count = ?, album_id = ? WHERE track_id = ?";
        return jdbcTemplate.update(sql, track.getTrack_name(), track.getGenre(), track.getLyrics(),
                track.getDuration(), track.getCountry(), track.getLike_count(), track.getListen_count(), 
                track.getAlbum_id(), track.getTrack_id());
    }

    // Delete a track by ID
    @Override
    public int deleteById(String id) {
        String sql = "DELETE FROM tracks WHERE track_id = ?";
        return jdbcTemplate.update(sql, id);
    }

    // Find a track by ID
    @Override
    public Track findById(String id) {
        String sql = "SELECT * FROM tracks WHERE track_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Track.class), id);
    }

    // Find all tracks
    @Override
    public List<Track> findAll() {
        String sql = "SELECT * FROM tracks";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Track.class));
    }
}
