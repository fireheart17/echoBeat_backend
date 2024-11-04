package com.echobeat.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.echobeat.model.LikedPlaylists;
import com.echobeat.model.Track;
import com.echobeat.model.Playlist;

@Repository
public class LikedPlaylistsRepository implements LikedPlaylistsInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveLikedPlaylist(LikedPlaylists likedPlaylists) {
        String sql = "INSERT INTO liked_playlists (user_id, playlist_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, likedPlaylists.getUser_id(), likedPlaylists.getPlaylist_id());
    }

    // @Override
    // public int updateLikedPlaylist(LikedPlaylists likedPlaylists) {
    //     String sql = "UPDATE liked_playlists SET playlist_id = ? WHERE user_id = ?";
    //     return jdbcTemplate.update(sql, likedPlaylists.getPlaylist_id(), likedPlaylists.getUser_id());
    // }

    @Override
    public int deleteLikedPlaylist(long userId, long playlistId) {
        String sql = "DELETE FROM liked_playlists WHERE user_id = ? AND playlist_id = ?";
        return jdbcTemplate.update(sql, userId, playlistId);
    }

    @Override
    public boolean findLikedPlaylist(long userId, long playlistId) {
        String sql = "SELECT * FROM liked_playlists WHERE user_id = ? AND playlist_id = ?";
        return (jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(LikedPlaylists.class), userId, playlistId))!=null;
    }

    @Override
    public List<Playlist> findLikedPlaylistsByUserId(long userId) {
        return jdbcTemplate.query("SELECT * from playlists where playlist_id in (SELECT playlist_id FROM liked_playlists WHERE user_id = ?)",
                new BeanPropertyRowMapper<>(Playlist.class), userId);
    }
}
