package com.echobeat.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.PlaylistTrack;
import com.echobeat.model.Track;

@Repository
public class PlaylistTrackRepository implements PlaylistTrackInterface {

    private final JdbcTemplate jdbcTemplate;

    public PlaylistTrackRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(PlaylistTrack playlistTrack) {
        return jdbcTemplate.update("INSERT INTO playlist_tracks (playlist_id, track_id) VALUES (?, ?)",
                playlistTrack.getPlaylist_id(), playlistTrack.getTrack_id());
    }

    @Override
    public int delete(long playlistId, String trackId) {
        return jdbcTemplate.update("DELETE FROM playlist_tracks WHERE playlist_id = ? AND track_id = ?", playlistId, trackId);
    }

    @Override
    public List<Track> findByPlaylistId(long playlistId) {
        return jdbcTemplate.query("SELECT * from tracks where track_id in (SELECT track_id FROM playlist_tracks WHERE playlist_id = ?)",
                new BeanPropertyRowMapper<>(Track.class), playlistId);
    }

    @Override
    public List<PlaylistTrack> findByTrackId(String trackId) {
        return jdbcTemplate.query("SELECT * FROM playlist_tracks WHERE track_id = ?",
                new BeanPropertyRowMapper<>(PlaylistTrack.class), trackId);
    }
}