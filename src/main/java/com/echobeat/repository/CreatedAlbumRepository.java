package com.echobeat.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.Album;
import com.echobeat.model.CreatedAlbum;

@Repository
public class CreatedAlbumRepository implements CreatedAlbumInterface {

    private final JdbcTemplate jdbcTemplate;

    // Constructor to inject JdbcTemplate
    public CreatedAlbumRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to add a created album
    @Override
    public int addCreatedAlbum(CreatedAlbum createdAlbum) {
        String sql = "INSERT INTO created_album (album_id, artist_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, createdAlbum.getAlbum_id(), createdAlbum.getArtist_id());
    }

    // Method to remove a created album
    @Override
    public int removeCreatedAlbum(long album_id, long artist_id) {
        String sql = "DELETE FROM created_album WHERE album_id = ? AND artist_id = ?";
        return jdbcTemplate.update(sql, album_id, artist_id);
    }

    @Override
    public List<Album> getAlbumsByArtistId(long artist_id) {
        String sql = "SELECT DISTINCT album_id FROM created_album WHERE artist_id=artist_id";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Album.class));
    }
}
