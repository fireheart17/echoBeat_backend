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
        String sql = "INSERT INTO tracks (track_id,track_name, genre, lyrics, duration, country, like_count, listen_count, album_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
        return jdbcTemplate.update(sql,track.getTrackId(), track.getTrack_name(), track.getGenre(), track.getLyrics(),
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
                track.getAlbum_id(), track.getTrackId());
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

    // Find tracks by album ID
    @Override
    public List<Track> findByAlbumId(String albumId) {
        String sql = "SELECT * FROM tracks WHERE album_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Track.class), albumId);
    }

    @Override
    public List<Track> newTracks() {
        String sql = "SELECT * FROM tracks LIMIT 10";
        
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Track.class));
    }

    @Override
    public List<Track> topPicks() {
        String sql = "SELECT * FROM tracks ORDER BY like_count DESC LIMIT 10";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Track.class));
    }

    @Override
    public List<Track> Search(String keyword) {
        String sql = "SELECT * FROM tracks WHERE track_name LIKE ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Track.class), keyword + "%");
    }

    @Override
    public List<Track> tracksInAlbum(long id) {
        String sql = "SELECT * FROM tracks WHERE album_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Track.class), id);
    }

    @Override
    public int incrementListenCount(String trackId) {
        String sql = "UPDATE tracks SET listen_count = listen_count + 1 WHERE track_id = ?";
        return jdbcTemplate.update(sql, trackId);
    }
}