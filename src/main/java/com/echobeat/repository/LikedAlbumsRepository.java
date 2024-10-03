package com.echobeat.repository;

import com.echobeat.model.LikedAlbums;
// import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LikedAlbumsRepository implements LikedAlbumsInterface {

    private final JdbcTemplate jdbcTemplate;

    // Constructor to inject JdbcTemplate
    public LikedAlbumsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Method to add a liked album
    @Override
    public int addLikedAlbum(LikedAlbums likedAlbum) {
        String sql = "INSERT INTO liked_albums (user_id, album_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, likedAlbum.getUser_id(), likedAlbum.getAlbum_id());
    }

    // Method to remove a liked album
    @Override
    public int removeLikedAlbum(long user_id, long album_id) {
        String sql = "DELETE FROM liked_albums WHERE user_id = ? AND album_id = ?";
        return jdbcTemplate.update(sql, user_id, album_id);
    }
}
