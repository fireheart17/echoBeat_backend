package com.echobeat.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.Playlist;


@Repository
public class PlaylistRepository implements PlaylistInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PlaylistRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Playlist playlist) {
        return jdbcTemplate.update("INSERT INTO playlists (title, duration, user_id) VALUES (?, ?, ?)",
                playlist.getTitle(), playlist.getDuration(), playlist.getUser_id());
    }

    @Override
    public int update(Playlist playlist) {
        return jdbcTemplate.update("UPDATE playlists SET title = ?, duration = ? WHERE playlist_id = ?",
                playlist.getTitle(), playlist.getDuration(), playlist.getPlaylist_id());
    }

    @Override
    public int delete(long playlistId) {
        return jdbcTemplate.update("DELETE FROM playlists WHERE playlist_id = ?", playlistId);
    }

    @Override
    public Playlist findByPlaylistId(long playlistId) {
        return jdbcTemplate.queryForObject("SELECT * FROM playlists WHERE playlist_id = ?",
                new BeanPropertyRowMapper<>(Playlist.class), playlistId);
    }

    @Override
    public List<Playlist> findByUserId(long userId) {
        return jdbcTemplate.query("SELECT * FROM playlists WHERE user_id = ?",
                new BeanPropertyRowMapper<>(Playlist.class), userId);
    }
}