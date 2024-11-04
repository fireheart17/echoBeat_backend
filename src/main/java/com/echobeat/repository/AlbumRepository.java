package com.echobeat.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.Album;

@Repository
public class AlbumRepository implements AlbumInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Album album) {
        String sql = "INSERT INTO albums (title, genre, release_date) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, album.getTitle(), album.getGenre(), album.getRelease_date());
    }

    @Override
    public int update(Album album) {
        String sql = "UPDATE albums SET title = ?, genre = ?, release_date = ? WHERE album_id = ?";
        return jdbcTemplate.update(sql, album.getTitle(), album.getGenre(), album.getRelease_date(), album.getAlbum_id());
    }

    @Override
    public int deleteById(long album_id) {
        String sql = "DELETE FROM albums WHERE album_id = ?";
        return jdbcTemplate.update(sql, album_id);
    }

    @Override
    public Album findById(long album_id) {
        String sql = "SELECT * FROM albums WHERE album_id = ?";
        Album album = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Album.class), album_id);
        return album;
    }

    @Override
    public List<Album> search(String keyword) {
        String sql = "SELECT * FROM albums WHERE title LIKE ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Album.class), keyword + "%");
    }
}
