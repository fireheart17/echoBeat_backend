package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.LikedPlaylists;
import com.echobeat.model.Playlist;

public interface LikedPlaylistsInterface {
    int saveLikedPlaylist(LikedPlaylists likedPlaylists);
    // int updateLikedPlaylist(LikedPlaylists likedPlaylists);
    int deleteLikedPlaylist(long userId, long playlistId);
    boolean findLikedPlaylist(long userId, long playlistId);
    List<Playlist> findLikedPlaylistsByUserId(long userId);
}
